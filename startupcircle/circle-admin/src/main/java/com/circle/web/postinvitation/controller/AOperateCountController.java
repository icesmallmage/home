package com.circle.web.postinvitation.controller;

import com.alibaba.fastjson2.JSONObject;
import com.circle.common.core.controller.BaseController;
import com.circle.common.core.domain.AjaxResult;
import com.circle.web.postinvitation.domain.to.AOperateCountDto;
import com.circle.web.postinvitation.service.IOperateCountService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api("核心业务 - 发帖模块 - 操作收藏点赞 ")
@RestController
@RequestMapping("/postInvitation/operate")
public class AOperateCountController extends BaseController {

    @Autowired
    private IOperateCountService iOperateCountService;

    @ApiOperation("操作收藏点赞")
    @PostMapping(value = "operateCount")
    public AjaxResult operateCount(@RequestBody AOperateCountDto dto){
        logger.info("入参：" + JSONObject.toJSONString(dto));
        iOperateCountService.operateCount(dto);
        return success();
    }

}
