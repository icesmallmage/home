package com.circle.web.postinvitation.controller;

import com.circle.common.annotation.Log;
import com.circle.common.core.controller.BaseController;
import com.circle.common.core.domain.AjaxResult;
import com.circle.common.enums.BusinessType;
import com.circle.web.postinvitation.domain.po.APostCritic;
import com.circle.web.postinvitation.service.IAPostCriticService;
import com.github.pagehelper.PageInfo;
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
     * 通过帖子id查询回复列表
     */
    @ApiOperation("通过帖子id查询回复分页列表")
    @GetMapping(value = "/getInfoById")
    public AjaxResult<PageInfo<APostCritic>> getInfoById(@RequestParam("id") Long id,
                                                         @RequestParam("pageNum") int pageNum,
                                                         @RequestParam("pageSize") int pageSize) {
        return success(aPostCriticService.getInfoByid(id, pageNum, pageSize));
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
