package com.circle.web.kafka.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/**
 * 消息消费者
 */
@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "commentMessageTopic",groupId = "myGroup")
    public void  receiveMessage(String message){
        log.info("消费消息："+message);
    }


}
