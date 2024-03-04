package com.circle.web.system.controller.system;

import com.circle.common.annotation.Anonymous;
import com.circle.common.core.controller.BaseController;
import com.circle.common.core.domain.AjaxResult;
import com.circle.web.system.domain.SysHatCity;
import com.circle.web.system.domain.SysHatProvince;
import com.circle.web.system.service.ISysHatAreaService;
import com.circle.web.system.service.ISysHatCityService;
import com.circle.web.system.service.ISysHatProvinceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 省份-城市-区
 */
@Api("系统业务 - 国内地区 - 省份城市区号联动")
@RestController
@RequestMapping("/system/sysHat")
public class SysHatController extends BaseController {

    @Autowired
    private ISysHatProvinceService sysHatProvinceService;

    @Autowired
    private ISysHatCityService sysHatCityService;

    @Autowired
    private ISysHatAreaService sysHatAreaService;

    /**
     * 查询【所有省份】列表
     */
    @ApiOperation("获取【所有省份】列表")
    @Anonymous
    @GetMapping("/sysHatProvinceList")
    public AjaxResult<List<SysHatProvince>> sysHatProvinceList() {
        List<SysHatProvince> list = sysHatProvinceService.selectSysHatProvinceList(new SysHatProvince());
        return success(list);
    }

    /**
     * 通过省份id查询对应城市列表
     */
    @ApiOperation("通过省份id查询对应城市列表")
    @Anonymous
    @GetMapping("/sysHatCityList")
    public AjaxResult<List<SysHatCity>> sysHatCityList(@RequestParam("provinceID") String provinceID) {
        List<SysHatCity> list = sysHatCityService.selectSysHatCityList(provinceID);
        return success(list);
    }

}
