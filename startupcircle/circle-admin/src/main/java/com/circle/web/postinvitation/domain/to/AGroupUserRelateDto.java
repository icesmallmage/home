package com.circle.web.postinvitation.domain.to;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotEmpty;

@Data
public class AGroupUserRelateDto {

    /** 群聊和用户关联表id */
    @ApiModelProperty(value = "群聊和用户关联表id,删除必传")
    private String id;

    /**
     * 群聊id
     */
    @ApiModelProperty(value = "群聊id")
    @NotEmpty(message = "群聊id不能为空")
    private String gId;

    /**
     * 用户id
     */
    @ApiModelProperty(value = "用户id")
    @NotEmpty(message = "用户id不能为空")
    private String userId;

}
