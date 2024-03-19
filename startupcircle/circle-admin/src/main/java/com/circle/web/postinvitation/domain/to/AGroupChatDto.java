package com.circle.web.postinvitation.domain.to;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import javax.validation.constraints.NotEmpty;

@Data
public class AGroupChatDto {

    /** 群聊名 */
    @ApiModelProperty(value = "群聊名(如果没传复用帖子名)")
    private String name;

    /** 关联帖子id */
    @ApiModelProperty(value = "关联帖子id")
    @NotEmpty(message = "关联帖子id不能为空")
    private String tId;

    /** 群主id */
    @ApiModelProperty(value = "群主id")
    @NotEmpty(message = "群主id不能为空")
    private String groOwnId;

    /** 群主名 */
    @ApiModelProperty(value = "群主名")
    private String groOwnName;


}
