package com.xj.mq.xjmqrabbitmqprovider;

import com.xj.mq.xjmqrabbitmqprovider.service.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: 郭佳
 * @ClassName: TopicTest
 * @Description:
 * @Date: 2021-01-06 18:11
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TopicTest {
    @Autowired
    private TopicSender sender;

    @Test
    public void topic() throws Exception {
        sender.send2();
    }
}
