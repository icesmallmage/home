package com.circle.web.postinvitation.domain.to;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class APostInvitationAddDto {

    /** 发帖人id */
    @ApiModelProperty(value = "发帖人id")
    private String postUserId;

    /** 发帖人昵称 */
    @ApiModelProperty(value = "发帖人昵称")
    private String postNickName;

    /** 标题 */
    @ApiModelProperty(value = "标题")
    private String title;

    /** 内容 */
    @ApiModelProperty(value = "内容")
    private String content;

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
