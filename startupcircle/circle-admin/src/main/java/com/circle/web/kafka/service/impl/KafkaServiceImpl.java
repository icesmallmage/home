package com.circle.web.kafka.service.impl;

import com.circle.web.kafka.service.KafkaService;
import com.circle.web.postinvitation.domain.po.APostCritic;
import org.springframework.stereotype.Service;

/**
 * @author liuyan
 * @date 2024/3/31 14:14
 */
@Service
public class KafkaServiceImpl implements KafkaService {



    @Override
    public int getCommentMessageCount(String userId, String tId) {



        return 0;
    }

    @Override
    public APostCritic getNewCritic(String userId) {


        return null;
    }

    @Override
    public void initCommentMessageCount(String userId, String tId) {

    }

}
