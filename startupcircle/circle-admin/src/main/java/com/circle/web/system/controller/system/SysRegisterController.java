package com.circle.web.system.controller.system;

import com.circle.common.annotation.Anonymous;
import com.circle.common.core.domain.dto.SysUserDto;
import com.circle.common.core.domain.entity.SysUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.circle.common.core.controller.BaseController;
import com.circle.common.core.domain.AjaxResult;
import com.circle.common.core.domain.model.RegisterBody;
import com.circle.common.utils.StringUtils;
import com.circle.framework.web.service.SysRegisterService;
import com.circle.system.service.ISysConfigService;

/**
 * 注册验证
 * 
 * @author ruoyi
 */
@Api("核心业务 - 注册")
@RestController
public class SysRegisterController extends BaseController
{
    @Autowired
    private SysRegisterService registerService;

    @Autowired
    private ISysConfigService configService;

    @PostMapping("/register")
    public AjaxResult register(@RequestBody RegisterBody user)
    {
        if (!("true".equals(configService.selectConfigByKey("sys.account.registerUser"))))
        {
            return error("当前系统没有开启注册功能！");
        }
        String msg = registerService.register(user);
        return StringUtils.isEmpty(msg) ? success() : error(msg);
    }


    @ApiOperation("app注册")
    @PostMapping("/appRegister")
    public AjaxResult appRegister(@RequestBody SysUserDto dto){
        return registerService.appRegister(dto);
    }

    @Anonymous
    @ApiOperation("app注册验证用户否被注册")
    @GetMapping("/checkUserName")
    public AjaxResult checkUserName(@RequestParam("userName") String userName){

        Boolean boo = registerService.checkUserName(userName);
        return boo ? success() : error("该账号已被使用");

    }



}
