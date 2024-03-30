package com.circle.web.postinvitation.domain.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * @author liuyan
 * @date 2024/3/30 15:36
 */
@Data
public class APostCriticVo {

    @ApiModelProperty(value = "id")
    private Long id;

    /** 发评论人id */
    @ApiModelProperty(value = "发评论人id")
    private String postUserId;

    /** 发评论人昵称 */
    @ApiModelProperty(value = "发评论人昵称")
    private String postNickName;

    /** 评论内容 */
    @ApiModelProperty(value = "评论内容")
    private String content;

    /** 关联帖子id */
    @ApiModelProperty(value = "关联帖子id")
    private String postInvitationId;

    /** 关联帖子id */
    @ApiModelProperty(value = "关联帖子标题")
    private String postInvitationTitle;

    @ApiModelProperty(value = "发评论人父id")
    private Long parentId;

    /** 发评论人父昵称 */
    @ApiModelProperty(value = "发评论人父昵称")
    private String parentNickName;

    @ApiModelProperty(value = "发评论人父评论")
    private String parentContent;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

}
