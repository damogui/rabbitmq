package com.xj.mq.xjmqrabbitmqprovider.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 郭佳
 * @ClassName: TopicRabbitConfig
 * @Description:
 * @Date: 2020-12-21 15:34
 */
@Configuration
public class TopicRabbitConfig {
    //绑定键
    public final static String man = "topic.order";//0
    public final static String woman = "topic.cancel.order";//1
    public final static String order = "buriedPoint.ordered";//2
    public final static String pay = "PaySuccessWebOrder";//3
    public final static String enterClass = "enterClass";//4
    public final static String exitClass = "exitClass";//5
    public final static String buriedPoint = "buriedPoint.orderCanceld";//6
    public final static String testPoint = "test.Point";//6
    /*消息确认队列*/
   public final static  String CONFIRM="topic.messages";

    @Bean
    public Queue confirmQueue() {
        return new Queue(TopicRabbitConfig.CONFIRM);
    }
    @Bean
    public Queue firstQueue() {
        return new Queue(TopicRabbitConfig.man);
    }

    @Bean
    public Queue secondQueue() {
        return new Queue(TopicRabbitConfig.woman);
    }
    @Bean
    public Queue Queue3() {
        return new Queue(TopicRabbitConfig.order);
    }
    @Bean
    public Queue QueueEnterClass() {
        return new Queue(TopicRabbitConfig.enterClass);
    }

    @Bean
    public Queue QueueExitClass() {
        return new Queue(TopicRabbitConfig.exitClass);
    }
    @Bean
    public Queue QueuePay() {
        return new Queue(TopicRabbitConfig.pay);
    }
    @Bean
    public Queue QueueBuried() {
        return new Queue(TopicRabbitConfig.buriedPoint);
    }
    @Bean
    TopicExchange exchange() {
        return new TopicExchange("topicExchange");
    }
    @Bean
    TopicExchange exchange2() {
        return new TopicExchange("topicExchange2");
    }

    //将secondQueue和topicExchange绑定,而且绑定的键值为用上通配路由键规则topic.#
    // 这样只要是消息携带的路由键是以topic.开头,都会分发到该队列
    @Bean
    Binding bindingExchangeMessage2() {
        return BindingBuilder.bind(secondQueue()).to(exchange()).with("topic.#");
    }
    //将firstQueue和topicExchange绑定,而且绑定的键值为topic.man
    //这样只要是消息携带的路由键是topic.man,才会分发到该队列
    @Bean
    Binding bindingExchangeMessage3() {
        return BindingBuilder.bind(Queue3()).to(exchange()).with(order);
    }
   //新增
   @Bean
   Binding bindingExchangeMessage4() {
       return BindingBuilder.bind(firstQueue()).to(exchange()).with(pay);
   }
    @Bean
    Binding bindingExchangeMessage5() {
        return BindingBuilder.bind(QueueEnterClass()).to(exchange()).with(enterClass);
    }
    @Bean
    Binding bindingExchangeMessage6() {
        return BindingBuilder.bind(QueueExitClass()).to(exchange()).with(exitClass);
    }
    @Bean
    Binding bindingExchangeMessage7() {
        return BindingBuilder.bind(QueuePay()).to(exchange()).with(pay);
    }
    @Bean
    Binding bindingExchangeMessage() {
        return BindingBuilder.bind(QueueBuried()).to(exchange()).with(buriedPoint);
    }

    @Bean
    Binding bindingExchangeMessage8() {
        return BindingBuilder.bind(QueueBuried()).to(exchange2()).with(testPoint);
    }

    //进行绑定确认queue
    @Bean
    Binding bindingConfirmExchange() {
        return BindingBuilder.bind(confirmQueue()).to(exchange()).with(CONFIRM);
    }


}
