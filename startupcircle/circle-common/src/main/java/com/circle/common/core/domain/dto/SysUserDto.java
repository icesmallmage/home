package com.circle.common.core.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class SysUserDto {

    @ApiModelProperty(value = "用户账号")
    @NotEmpty(message = "用户昵称不能为空")
    @Size(min = 0, max = 20, message = "用户账号长度不能超过20个字符")
    private String userName;

    @ApiModelProperty(value = "用户昵称: 没传的话存账号")
    @Size(min = 0, max = 20, message = "用户昵称长度不能超过20个字符")
    private String nickName;

    @ApiModelProperty(value = "用户性别: 0=男，1=女")
    @NotEmpty(message = "用户性别不能为空")
    private String sex;

    @ApiModelProperty(value = "password")
    @NotEmpty(message = "password不能为空")
    private String password;

    @ApiModelProperty(value = "行业名称")
    @NotEmpty(message = "行业名称不能为空")
    private String firmName;

    /** 职业名称 */
    @ApiModelProperty(value = "职业名称（暂时没有职业不用传）")
    private String jobName;

    @ApiModelProperty(value = "省份")
    @NotEmpty(message = "省份不能为空")
    private String province;

    @ApiModelProperty(value = "城市")
    @NotEmpty(message = "城市不能为空")
    private String city;

}
