package com.circle.web.socket.controller;

import com.circle.common.annotation.Anonymous;
import com.circle.common.utils.JsonUtil;
import com.circle.common.utils.StringUtils;
import com.circle.web.socket.model.ChatMessage;
import com.circle.web.socket.service.ChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

@Controller
public class ChatController {

    private static final Logger logger = LoggerFactory.getLogger(ChatController.class);

    @Value("${redis.channel.msgUser}")
    private String msgUser;

    @Value("${redis.set.onlineUsers}")
    private String onlineUsers;

    @Value("${redis.channel.infoUser}")
    private String infoUser;

    @Autowired
    private ChatService chatService;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Anonymous
    @MessageMapping("/chat.addUser")
    public void addUser(@Payload ChatMessage chatMessage, SimpMessageHeaderAccessor headerAccessor) {

        logger.info("用户加入群聊, id：" + chatMessage.getUserId() + ", 昵称：" + chatMessage.getNickName());
        try {
            headerAccessor.getSessionAttributes().put("userId", chatMessage.getUserId());
            redisTemplate.opsForSet().add(onlineUsers, chatMessage.getUserId());
            redisTemplate.convertAndSend(infoUser, JsonUtil.parseObjToJson(chatMessage));
        } catch (Exception e) {
            logger.error("上线/下线群聊失败：" + e.getMessage());
        }
    }

    @Anonymous
    @MessageMapping("/chat.sendMessage")
    public void sendMessage(@Payload ChatMessage chatMessage, String gId) {
        try {
            String channel = StringUtils.isNotEmpty(gId) ? gId : msgUser;
            redisTemplate.convertAndSend(channel, JsonUtil.parseObjToJson(chatMessage));
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }

}
