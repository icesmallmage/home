package com.circle.web.postinvitation.domain.to;

import com.circle.common.annotation.Excel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class APostInvitationUpdateDto {

    @ApiModelProperty(value = "帖子id")
    private String id;

    private String postUserId;

    @ApiModelProperty(value = "发帖人昵称")
    private String postNickName;

    @ApiModelProperty(value = "标题")
    private String title;

    @ApiModelProperty(value = "内容")
    @Excel(name = "内容")
    private String content;

    @ApiModelProperty(value = "行业")
    private String industry;

    @ApiModelProperty(value = "职业")
    private String profession;

    @ApiModelProperty(value = "发评论人省份")
    private String province;

    @ApiModelProperty(value = "发评论人城市")
    private String city;

    @ApiModelProperty(value = "删除标志")
    private String delFlag;

    @ApiModelProperty(value = "收藏量")
    private String viewCount;

    /** 点赞量 */
    @ApiModelProperty(value = "点赞量")
    private String upvoteCount;

    /** 评论量 */
    @ApiModelProperty(value = "评论量")
    private String criticCount;

    private String createBy;

    private Date createTime;

    private String updateBy;

    private Date updateTime;

}
