package com.lz.rabbitmqprovider.controller;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @ClassName SendMessageController
 * @Description TODO
 * @Author LZ
 * @Date 2020/2/13 11:09
 * @Version 1.0
 **/
@RestController
public class SendMessageController {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @GetMapping("/sendDirect")
    public String sendDirectMessage(){

        String messageData = "test message hello!";
        Map map = createData(messageData);
        rabbitTemplate.convertAndSend("TestDirectExchange","TestDirectRouting",map);
        return "ok";
    }

    @GetMapping("/sendTopic1")
    public String sendTopicMessage1() {
        String messageData = "message: M A N ";
        Map manMap = createData(messageData);
        rabbitTemplate.convertAndSend("topicExchange", "topic.man", manMap);
        return "ok";
    }

    @GetMapping("/sendTopic2")
    public String sendTopicMessage2() {
        String messageData = "message: woman is all ";
        Map womanMap = createData(messageData);
        rabbitTemplate.convertAndSend("topicExchange", "topic.woman", womanMap);
        return "ok";
    }

    @GetMapping("/sendFanoutMessage")
    public String sendFanoutMessage() {
        String messageData = "message: testFanoutMessage ";
        Map map = createData(messageData);
        rabbitTemplate.convertAndSend("fanoutExchange", null, map);
        return "ok";
    }

    @GetMapping("/TestMessageAck")
    public String TestMessageAck() {
        String messageData = "message: non-existent-exchange test message ";
        Map map = createData(messageData);
        rabbitTemplate.convertAndSend("non-existent-exchange", "TestDirectRouting", map);
        return "ok";
    }

    @GetMapping("/TestMessageAck2")
    public String TestMessageAck2() {
        String messageData = "message: lonelyDirectExchange test message ";
        Map map = createData(messageData);
        rabbitTemplate.convertAndSend("lonelyDirectExchange", "TestDirectRouting", map);
        return "ok";
    }

    /**
     * @Description //TODO 组装消息数据
     * @Param [messageData]
     * @return java.util.Map
     * @Author LZ
     * @Date 2020/2/13 11:37
     **/
    private Map createData(String messageData){
        String messageId = String.valueOf(UUID.randomUUID());
        String createTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
        Map<String, Object> map = new HashMap<>();
        map.put("messageId", messageId);
        map.put("messageData", messageData);
        map.put("createTime", createTime);
        return map;
    }

}
