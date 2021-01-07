package com.xj.mq.xjmqrabbitmqprovider.service;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

/**
 * @Author: 郭佳
 * @ClassName: TopicSender
 * @Description:
 * @Date: 2021-01-06 18:05
 */
@Component
public class TopicSender   implements RabbitTemplate.ConfirmCallback {
    private RabbitTemplate rabbitTemplate;

    @Autowired
    public TopicSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
        rabbitTemplate.setConfirmCallback(this);
    }

    public void send2() {
        for (int i = 0; i < 3; i++) {
            String context = "hi, i am messages " + i;
            System.out.println("Sender : " + context);
            CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
            System.out.println("callbackSender UUID: " + correlationData.getId());
            this.rabbitTemplate.convertAndSend("topicExchange", "topic.messages", context, correlationData);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    //实现回调
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        System.out.println("confirm: " + correlationData.getId() + ",s=" + s + ",b:" + b);

    }
}
