package com.circle.web.kafka.service;

import com.circle.web.postinvitation.domain.po.APostCritic;

/**
 * @author liuyan
 * @date 2024/3/30 14:53
 */
public interface KafkaService {

    /**
     * 查询当前登录人： 别人回复了他的总数
     */
    int getCommentMessageCount(String userId, String tId);

    /**
     * 获取当前用户的最新评论
     * @param userId
     * @return
     */
    APostCritic getNewCritic(String userId);

    /**
     * 重置当前登录人： 别人回复他的总数设置为0
     */
    void initCommentMessageCount(String userId, String tId);

}
