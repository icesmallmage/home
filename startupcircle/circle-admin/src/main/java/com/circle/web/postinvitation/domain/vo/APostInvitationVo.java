package com.circle.web.postinvitation.domain.vo;

import com.circle.web.postinvitation.domain.po.APostInvitation;
import io.swagger.annotations.ApiModelProperty;

public class APostInvitationVo extends APostInvitation {

    @ApiModelProperty(value = "当前登录人是否收藏")
    private Boolean booView;

    @ApiModelProperty(value = "当前登录人是否点赞")
    private Boolean booUpvote;

    public Boolean getBooView() {
        return booView;
    }

    public void setBooView(Boolean booView) {
        this.booView = booView;
    }

    public Boolean getBooUpvote() {
        return booUpvote;
    }

    public void setBooUpvote(Boolean booUpvote) {
        this.booUpvote = booUpvote;
    }
}
