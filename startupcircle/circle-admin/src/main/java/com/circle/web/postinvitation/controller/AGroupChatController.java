package com.circle.web.postinvitation.controller;

import com.circle.common.core.controller.BaseController;
import com.circle.common.core.domain.AjaxResult;
import com.circle.web.postinvitation.domain.to.AGroupChatDto;
import com.circle.web.postinvitation.domain.to.AGroupUserRelateDto;
import com.circle.web.postinvitation.domain.vo.AGroupChatVo;
import com.circle.web.postinvitation.service.IAGroupChatService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.*;

@Api("核心业务 - 发帖模块 - 群聊")
@RestController
@RequestMapping("/postInvitation/groupChat")
public class AGroupChatController extends BaseController {

    @Autowired
    private IAGroupChatService iaGroupChatService;

    @Value("${redis.channel.msgUser}")
    private String msgUser;

    @Value("${redis.set.onlineUsers}")
    private String onlineUsers;

    @Value("${redis.channel.infoUser}")
    private String infoUser;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 查询该用户所有的群聊分页列表
     */
    @ApiOperation("查询该用户所有的群聊分页列表")
    @GetMapping(value = "groupChatPageList")
    public AjaxResult<PageInfo<AGroupChatVo>> groupChatPageList(@RequestParam("pageNum") Integer pageNum,
                                                    @RequestParam("pageSize") Integer pageSize){
        return success(iaGroupChatService.groupChatPageList(pageNum, pageSize));
    }

    /**
     * 创建群聊
     */
    @ApiOperation("创建群聊")
    @PostMapping(value = "insertGroupChat")
    public AjaxResult insertGroupChat(@RequestBody AGroupChatDto dto){
        iaGroupChatService.insertAGroupChat(dto);
        return success();
    }

    /**
     * 用户加入群聊
     */
    @ApiOperation("用户加入/退出群聊")
    @PostMapping(value = "userJoinGroup")
    public AjaxResult userJoinGroup(@RequestBody AGroupUserRelateDto dto){
        iaGroupChatService.userJoinGroup(dto);
        return success();
    }

}
