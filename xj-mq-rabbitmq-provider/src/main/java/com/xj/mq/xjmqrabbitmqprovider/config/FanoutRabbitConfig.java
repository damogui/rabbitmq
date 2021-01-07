package com.xj.mq.xjmqrabbitmqprovider.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: 郭佳
 * @ClassName: FanoutRabbitConfig
 * @Description:
 * @Date: 2021-01-05 15:04
 */
@Configuration
public class FanoutRabbitConfig {
    //队列 起名：TestDirectQueue
    @Bean
    public Queue TestFanoutQueue() {
        return new Queue("TestFanoutQueue",true);
    }

    //Direct交换机 起名：TestDirectExchange
    @Bean
    FanoutExchange TestFanoutExchange() {
        return new FanoutExchange("TestFanoutExchange");
    }

    //绑定  将队列和交换机绑定, 并设置用于匹配键：TestDirectRouting
    @Bean
    Binding bindingFanout() {
        return BindingBuilder.bind(TestFanoutQueue()).to(TestFanoutExchange());
    }
}
