package com.circle.web.kafka.example;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFutureCallback;

/**
 * 消息生产者
 */
@Component
@Slf4j
public class KafkaProducer {

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    /**
     * 发送消息
     * @param topic 主题
     * @param msg   消息
     */
    public void send(String topic,String msg){
        kafkaTemplate.send(topic,msg).addCallback(new ListenableFutureCallback<SendResult<String, String>>() {
            @Override
            public void onFailure(Throwable ex) {
                log.error("发送消息失败：{}", ex);
            }

            @Override
            public void onSuccess(SendResult<String, String> result) {
                log.info("发送消息成功:{}:{}", topic, msg);
            }
        });
    }

}
