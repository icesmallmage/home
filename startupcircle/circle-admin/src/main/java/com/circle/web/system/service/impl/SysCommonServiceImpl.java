package com.circle.web.system.service.impl;

import com.circle.web.postinvitation.mapper.AGroupChatMapper;
import com.circle.web.system.service.SysCommonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.listener.PatternTopic;
import org.springframework.data.redis.listener.RedisMessageListenerContainer;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import static com.circle.web.redis.RedisListenerBean.connectionFactory;
import static com.circle.web.redis.RedisListenerBean.listenerAdapter;

/**
 * 存放公共全局属性值
 */
@Component
@Service
public class SysCommonServiceImpl implements SysCommonService {

    private static final Logger logger = LoggerFactory.getLogger(SysCommonServiceImpl.class);

    @Resource
    private AGroupChatMapper aGroupChatMapper;

    public static List<String> groupIds;

    public List<String> groupIdsOld;

    @PostConstruct
    public void initGroupId(){
        // 查询群聊个数
        groupIds = aGroupChatMapper.selectIds();
        groupIdsOld = groupIds;
        logger.info("初始群聊个数为： " + groupIdsOld.size());
    }

    @Scheduled(fixedRate = 5000)
    public void realRefreshGroupId(){
        // 查询群聊个数
        groupIds = aGroupChatMapper.selectIds();
        if(!groupIds.equals(groupIdsOld)){
            // 如果2个list元素不相等, 获取到新的群聊id, 加入到监听
            RedisMessageListenerContainer container = new RedisMessageListenerContainer();
            container.setConnectionFactory(connectionFactory);
            List<String> groupIdsNew = new ArrayList<>();
            groupIdsNew.addAll(groupIds);
            groupIds.removeAll(groupIdsOld);
            groupIds.stream().forEach(t -> {
                container.addMessageListener(listenerAdapter, new PatternTopic(t));
            });
            groupIdsOld = groupIdsNew;
            logger.info("新群聊个数为： " + groupIdsOld.size());
        }
    }

}
