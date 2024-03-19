package com.circle.web.redis;

import com.circle.common.utils.JsonUtil;
import com.circle.web.socket.model.ChatMessage;
import com.circle.web.socket.service.ChatService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.connection.Message;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.circle.web.system.service.impl.SysCommonServiceImpl.groupIds;

/**
 * Redis订阅频道处理类
 * @author yangzhendong01
 */
@Component
public class RedisListenerHandle extends MessageListenerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(RedisListenerHandle.class);

    @Value("${redis.channel.msgUser}")
    private String msgUser;

    @Value("${redis.channel.infoUser}")
    private String infoUser;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Autowired
    private ChatService chatService;

    private List<String> ids;


    /**
     * 收到监听消息
     * @param message
     * @param bytes
     */
    @Override
    public void onMessage(Message message, byte[] bytes) {
        byte[] body = message.getBody();
        byte[] channel = message.getChannel();
        String rawMsg;
        String topic;
        try {
            rawMsg = redisTemplate.getStringSerializer().deserialize(body);
            topic = redisTemplate.getStringSerializer().deserialize(channel);
            LOGGER.info("发送消息渠道:" + topic + ", 发送消息内容：" + rawMsg);
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
            return;
        }

        if (msgUser.equals(topic) || groupIds.contains(topic)) {
            LOGGER.info("发送消息,渠道:" + topic + ", 内容:"+ rawMsg);
            ChatMessage chatMessage = JsonUtil.parseJsonToObj(rawMsg, ChatMessage.class);
            if (chatMessage != null) {
                chatService.sendMsg(chatMessage, topic);
            }
        } else if (msgUser.equals(topic)) {
            ChatMessage chatMessage = JsonUtil.parseJsonToObj(rawMsg, ChatMessage.class);
            if (chatMessage != null) {
                chatService.alertUserStatus(chatMessage, topic);
            }
        }else {
            LOGGER.warn("没有找到对应的消息渠道!");
        }
    }
}
