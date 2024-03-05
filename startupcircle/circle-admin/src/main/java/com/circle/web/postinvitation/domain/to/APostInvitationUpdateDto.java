package com.circle.web.postinvitation.domain.to;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class APostInvitationUpdateDto {

    @ApiModelProperty(value = "帖子id")
    private String id;

    @ApiModelProperty(value = "收藏量")
    private String viewCount;

    /** 点赞量 */
    @ApiModelProperty(value = "点赞量")
    private String upvoteCount;

    /** 评论量 */
    @ApiModelProperty(value = "评论量")
    private String criticCount;

}
