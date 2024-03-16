package com.circle.common.core.domain.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class SysUserUpdateDto {

    @ApiModelProperty(value = "userId")
    @NotEmpty(message = "用户id不能为空")
    private String userId;

    @ApiModelProperty(value = "用户昵称: 没传的话存账号")
    private String nickName;

    @ApiModelProperty(value = "行业名称")
    private String firmName;

    /** 职业名称 */
    @ApiModelProperty(value = "职业名称（暂时没有职业不用传）")
    private String jobName;

    @ApiModelProperty(value = "省份")
    private String province;

    @ApiModelProperty(value = "城市")
    private String city;

}
