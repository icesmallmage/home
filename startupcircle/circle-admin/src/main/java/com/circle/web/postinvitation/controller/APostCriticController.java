package com.circle.web.postinvitation.controller;

import java.util.List;

import com.circle.common.annotation.Anonymous;
import com.circle.common.annotation.Log;
import com.circle.common.core.controller.BaseController;
import com.circle.common.core.domain.AjaxResult;
import com.circle.common.core.page.TableDataInfo;
import com.circle.common.enums.BusinessType;
import com.circle.web.postinvitation.domain.po.APostCritic;
import com.circle.web.postinvitation.service.IAPostCriticService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 【回复信息】Controller
 * 
 * @author ruoyi
 * @date 2024-01-30
 */
@Api("核心业务 - 发帖模块 - 回复信息")
@RestController
@RequestMapping("/postInvitation/critic")
public class APostCriticController extends BaseController
{
    @Autowired
    private IAPostCriticService aPostCriticService;

    /**
     * 查询【回复信息】列表
     */
    @Anonymous
    @ApiOperation("查询【回复信息】列表")
    @GetMapping("/list")
    public TableDataInfo list(APostCritic aPostCritic)
    {
        startPage();
        List<APostCritic> list = aPostCriticService.selectAPostCriticList(aPostCritic);
        return getDataTable(list);
    }

    /**
     * 获取【回复信息】详细信息
     */
    @Anonymous
    @ApiOperation("获取【回复信息】详细信息")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        aPostCriticService.selectAPostCriticById(id);
        return success();
    }

    /**
     * 获取【帖子回复信息】详细信息
     */
    @Anonymous
    @ApiOperation("获取【帖子回复信息】详细信息")
    @GetMapping(value = "/getInfoById")
    public AjaxResult<List<APostCritic>> getInfoById(@RequestParam("id") Long id)
    {
        return success(aPostCriticService.getInfoByid(id));
    }

    /**
     * 新增【回复信息】
     */
    @ApiOperation("新增【回复信息】")
    @Log(title = "新增【回复信息】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody APostCritic aPostCritic)
    {
        aPostCriticService.insertAPostCritic(aPostCritic);
        return success();
    }

    /**
     * 修改【回复信息】
     */
    @ApiOperation("修改【回复信息】")
    @Log(title = "修改【回复信息】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody APostCritic aPostCritic)
    {
        aPostCriticService.updateAPostCritic(aPostCritic);
        return success();
    }

    /**
     * 删除【回复信息】
     */
    @ApiOperation("删除【回复信息】")
    @Log(title = "删除【回复信息】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        aPostCriticService.deleteAPostCriticByIds(ids);
        return success();
    }
}
