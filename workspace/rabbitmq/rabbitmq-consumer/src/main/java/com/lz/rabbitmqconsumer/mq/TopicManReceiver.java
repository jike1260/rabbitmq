package com.lz.rabbitmqconsumer.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @ClassName TopicManReceiver
 * @Description TODO
 * @Author LZ
 * @Date 2020/2/13 11:41
 * @Version 1.0
 **/
@Component
@RabbitListener(queues = "topic.man")
public class TopicManReceiver {

    @RabbitHandler
    public void process(Map testMessage){
        System.out.println("TopicManReceiver消费者收到消息:" + testMessage.toString());
    }
}
