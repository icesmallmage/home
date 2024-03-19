package com.circle.web.redis;

import com.circle.web.system.service.SysCommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.data.redis.listener.adapter.MessageListenerAdapter;
import org.springframework.stereotype.Component;


import static com.circle.web.system.service.impl.SysCommonServiceImpl.groupIds;

/**
 * Redis订阅频道属性类
 * @author yangzhendong01
 */
@Component
public class RedisListenerBean {

    private static final Logger logger = LoggerFactory.getLogger(RedisListenerBean.class);

    @Value("${redis.channel.msgUser}")
    private String msgUser;

    @Value("${redis.channel.infoUser}")
    private String infoUser;

    @Autowired
    private SysCommonService sysCommonService;

    public static RedisConnectionFactory connectionFactory;
    public static MessageListenerAdapter listenerAdapter;

    /**
     * redis消息监听器容器
     * 可以添加多个监听不同话题的redis监听器，只需要把消息监听器和相应的消息订阅处理器绑定，该消息监听器
     * 通过反射技术调用消息订阅处理器的相关方法进行一些业务处理
     * @param connectionFactory
     * @param listenerAdapter
     * @return
     */
    @Bean
    RedisMessageListenerContainer container(RedisConnectionFactory connectionFactory, MessageListenerAdapter listenerAdapter) {
        RedisListenerBean.connectionFactory = connectionFactory;
        RedisListenerBean.listenerAdapter = listenerAdapter;
        RedisMessageListenerContainer container = new RedisMessageListenerContainer();
        container.setConnectionFactory(connectionFactory);
        // msgUser
        for(String id : groupIds){
            container.addMessageListener(listenerAdapter, new PatternTopic(id));
            logger.info("监听的渠道: " + id);
        }
        container.addMessageListener(listenerAdapter, new PatternTopic(msgUser));
        logger.info("监听的所有渠道: " + msgUser);
        container.addMessageListener(listenerAdapter, new PatternTopic(infoUser));
        return container;
    }
}
