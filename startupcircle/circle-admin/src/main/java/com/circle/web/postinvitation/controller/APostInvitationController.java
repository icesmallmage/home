package com.circle.web.postinvitation.controller;

import java.util.List;

import com.circle.common.annotation.Anonymous;
import com.circle.common.annotation.Log;
import com.circle.common.core.controller.BaseController;
import com.circle.common.core.domain.AjaxResult;
import com.circle.common.core.page.TableDataInfo;
import com.circle.common.enums.BusinessType;
import com.circle.web.postinvitation.domain.to.APostInvitationAddDto;
import com.circle.web.postinvitation.domain.to.APostInvitationDto;
import com.circle.web.postinvitation.domain.vo.APostInvitationVo;
import com.circle.web.postinvitation.service.IAPostInvitationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    /**
     * 查询【帖子信息】列表
     */
    @Anonymous
    @ApiOperation("查询帖子信息")
    @GetMapping("/list")
    public TableDataInfo list(APostInvitationDto dto)
    {
        startPage();
        List<APostInvitationVo> list = aPostInvitationService.selectAPostInvitationList(dto);
        return getDataTable(list);
    }

    /**
     * 新增【帖子信息表】
     */
    @Anonymous
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
    @Anonymous
    @ApiOperation("删除【帖子信息表】")
    @Log(title = "删除【帖子信息表】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable String[] ids)
    {
        aPostInvitationService.deleteAPostInvitationByIds(ids);
        return success();
    }

}
