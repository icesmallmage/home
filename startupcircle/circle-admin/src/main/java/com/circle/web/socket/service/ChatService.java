package com.circle.web.socket.service;

import com.circle.web.socket.model.ChatMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ChatService.class);

    @Autowired
    private SimpMessageSendingOperations simpMessageSendingOperations;

    public void sendMsg(@Payload ChatMessage chatMessage, String topic) {
        LOGGER.info("simpMessageSendingOperations发送消息, 渠道:" + topic + ", 内容:" + chatMessage.toString());
        String url = "/topic/" + topic;
        simpMessageSendingOperations.convertAndSend(url, chatMessage);
    }

    public void alertUserStatus(@Payload ChatMessage chatMessage, String topic) {
        LOGGER.info("simpMessageSendingOperations修改用户信息:" + chatMessage.toString());
        String url = "/topic/" + topic;
        simpMessageSendingOperations.convertAndSend(url, chatMessage);
    }
}
