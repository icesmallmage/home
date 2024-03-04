package com.circle.web.postinvitation.domain.to;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class APostInvitationDto {

    /** 标题 */
    @ApiModelProperty(value = "标题")
    private String title;

    /** 行业 */
    @ApiModelProperty(value = "行业")
    private String industry;

    /** 职业 */
    @ApiModelProperty(value = "职业")
    private String profession;

    @ApiModelProperty(value = "发评论人省份")
    private String province;

    @ApiModelProperty(value = "发评论人城市")
    private String city;

}
