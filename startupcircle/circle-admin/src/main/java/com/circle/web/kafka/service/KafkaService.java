package com.circle.web.kafka.service;

/**
 * @author liuyan
 * @date 2024/3/30 14:53
 */
public interface KafkaService {

    /**
     * 查询当前登录人： 别人回复了他的总数
     */
    int getCommentMessageCount(String userId, String tId);

}
