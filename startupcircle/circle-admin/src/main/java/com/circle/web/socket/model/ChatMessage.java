package com.circle.web.socket.model;


import com.circle.common.enums.MessageType;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

/**
 * 聊天入参
 */
@Data
public class ChatMessage {

    @ApiModelProperty(value = "聊天类型")
    private MessageType messageType;

    @ApiModelProperty(value = "聊天内容")
    private String content;

    @ApiModelProperty(value = "群聊id")
    @NotEmpty(message = "群聊id不能为空")
    private String gId;

    @ApiModelProperty(value = "用户id")
    @NotEmpty(message = "用户id不能为空")
    private String userId;

    @ApiModelProperty(value = "用户昵称")
    private String nickName;

}
