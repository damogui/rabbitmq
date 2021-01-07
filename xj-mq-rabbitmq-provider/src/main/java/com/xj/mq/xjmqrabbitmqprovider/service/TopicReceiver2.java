package com.xj.mq.xjmqrabbitmqprovider.service;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Author: 郭佳
 * @ClassName: TopicReceiver2
 * @Description:
 * @Date: 2021-01-06 18:10
 */
//@Component
//@RabbitListener(queues = "topic.messages")
public class TopicReceiver2 {
    @RabbitHandler
    public void process(String message) {
        System.out.println("Topic Receiver2  : " + message);
    }
}
