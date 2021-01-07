package com.xj.mq.xjmqrabbitmqconsumer.controller;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @Author: 郭佳
 * @ClassName: DirectReceiver
 * @Description:
 * @Date: 2020-12-21 15:33
 */
@Component
public class DirectReceiver {

   //消息确认消费
    @RabbitListener(queues = "topic.messages")
//    @RabbitHandler
    public void process(String message) {
        System.out.println("Topic Receiver2  : " + message);
    }


    //    @RabbitHandler
    @RabbitListener(queues = "TestFanoutQueue")//监听的队列名称 TestDirectQueue
    public void processFanout(Map testMessage) {
        System.out.println("FanoutReceiver消费者收到消息  : " + testMessage.toString());
    }

    //    @RabbitHandler
    @RabbitListener(queues = "TestDirectQueue")//监听的队列名称 TestDirectQueue
    public void process(Map testMessage) {
        System.out.println("DirectReceiver消费者收到消息  : " + testMessage.toString());
    }

    @RabbitListener(queues = "topic.man")
    public void receiveMessage2(Map testMessage) {
        System.out.println("我是监听topic.man 的,满足 topic.# 的都过来 ， " + testMessage.toString());
    }

    @RabbitListener(queues = "topic.woman")
    public void receiveMessage3(Map testMessage) {
        System.out.println("我是监听topic.woman 的,满足 topic.# 的都过来 ， " + testMessage.toString());
    }
}
