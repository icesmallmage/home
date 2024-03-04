package com.circle.web.system.controller.system;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.circle.common.annotation.Log;
import com.circle.common.core.controller.BaseController;
import com.circle.common.core.domain.AjaxResult;
import com.circle.common.core.page.TableDataInfo;
import com.circle.common.enums.BusinessType;
import com.circle.common.utils.poi.ExcelUtil;
import com.circle.web.system.domain.SysHatProvince;
import com.circle.web.system.service.ISysHatProvinceService;
import io.swagger.annotations.Api;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 【省份城市地区联动】Controller
 * 
 * @author ruoyi
 * @date 2024-02-22
 */
@Api("系统业务 - 省份城市地区联动")
@RestController
@RequestMapping("/system/province")
public class SysHatProvinceController extends BaseController
{
    @Autowired
    private ISysHatProvinceService sysHatProvinceService;

    /**
     * 查询【请填写功能名称】列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SysHatProvince sysHatProvince)
    {
        startPage();
        List<SysHatProvince> list = sysHatProvinceService.selectSysHatProvinceList(sysHatProvince);
        return getDataTable(list);
    }

    /**
     * 获取【请填写功能名称】详细信息
     */
    @GetMapping(value = "/{sid}")
    public AjaxResult getInfo(@PathVariable("sid") String sid)
    {
        return success(sysHatProvinceService.selectSysHatProvinceBySid(sid));
    }

    /**
     * 新增【请填写功能名称】
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysHatProvince sysHatProvince)
    {
        return toAjax(sysHatProvinceService.insertSysHatProvince(sysHatProvince));
    }

    /**
     * 修改【请填写功能名称】
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysHatProvince sysHatProvince)
    {
        return toAjax(sysHatProvinceService.updateSysHatProvince(sysHatProvince));
    }

    /**
     * 删除【请填写功能名称】
     */
    @Log(title = "【请填写功能名称】", businessType = BusinessType.DELETE)
	@DeleteMapping("/{sids}")
    public AjaxResult remove(@PathVariable String[] sids)
    {
        return toAjax(sysHatProvinceService.deleteSysHatProvinceBySids(sids));
    }
}
