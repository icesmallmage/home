package com.circle.web.postinvitation.controller;

import java.util.List;

import com.circle.common.annotation.Log;
import com.circle.common.core.controller.BaseController;
import com.circle.common.core.domain.AjaxResult;
import com.circle.common.enums.BusinessType;
import com.circle.web.postinvitation.domain.to.APostInvitationAddDto;
import com.circle.web.postinvitation.domain.to.APostInvitationDto;
import com.circle.web.postinvitation.domain.vo.APostInvitationVo;
import com.circle.web.postinvitation.service.IAPostInvitationService;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 【帖子信息表】Controller
 * 
 * @author ruoyi
 * @date 2024-01-30
 */
@Api("核心业务 - 发帖模块 - 帖子信息")
@RestController
@RequestMapping("/postInvitation/invitation")
public class APostInvitationController extends BaseController
{
    @Autowired
    private IAPostInvitationService aPostInvitationService;

    @ApiOperation("查询帖子信息分页列表")
    @GetMapping("/pageList")
    public AjaxResult<PageInfo<APostInvitationVo>> pageList(APostInvitationDto dto,
                                                            @RequestParam("pageNum") int pageNum,
                                                            @RequestParam("pageSize") int pageSize) {
        PageInfo<APostInvitationVo> list = aPostInvitationService.pageList(dto, pageNum, pageSize);
        return success(list);
    }

    @ApiOperation("查询帖子信息列表")
    @GetMapping("/list")
    public AjaxResult<List<APostInvitationVo>> list(APostInvitationDto dto)
    {
        List<APostInvitationVo> list = aPostInvitationService.selectAPostInvitationList(dto);
        return success(list);
    }

    /**
     * 新增【帖子信息表】
     */
    @ApiOperation("新增【帖子信息表】")
    @Log(title = "新增【帖子信息表】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody APostInvitationAddDto dto)
    {
        aPostInvitationService.insertAPostInvitation(dto);
        return success();
    }

    /**
     * 删除【帖子信息表】
     */
    @ApiOperation("删除【帖子信息表】")
    @Log(title = "删除【帖子信息表】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        aPostInvitationService.deleteAPostInvitationByIds(ids);
        return success();
    }

    /**
     * 查询当前登录人收藏了哪些帖子
     */
    @ApiOperation("查询收藏、点赞帖子信息分页列表")
    @GetMapping("/operateList")
    public AjaxResult<PageInfo<APostInvitationVo>> operateList(@RequestParam("operateType") String operateType,
                                                            @RequestParam("pageNum") int pageNum,
                                                            @RequestParam("pageSize") int pageSize) {
        return success(aPostInvitationService.operateList(operateType, pageNum, pageSize));
    }

}
