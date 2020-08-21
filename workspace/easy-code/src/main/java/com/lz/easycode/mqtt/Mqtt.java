package com.lz.easycode.mqtt;

import org.eclipse.paho.client.mqttv3.MqttClient;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.persist.MemoryPersistence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName Mqtt
 * @Description TODO
 * @Author LZ
 * @Date 2020/8/15 16:49
 * @Version 1.0
 **/
@Component
public class Mqtt {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${mqtt.broker}")
    private String broker;

    @Value("${mqtt.username}")
    private String username;

    @Value("${mqtt.password}")
    private String password;

    @Value("${mqtt.clientId}")
    private String clientId;

    @Value("${mqtt.subTopic}")
    private String subTopic;

    public void mqtt() {

        MemoryPersistence persistence = new MemoryPersistence();

        try {

            MqttClient client = new MqttClient(broker, clientId, persistence);

            // MQTT 连接选项
            MqttConnectOptions connOpts = new MqttConnectOptions();
            connOpts.setUserName(username);
            connOpts.setPassword(password.toCharArray());

            // 保留会话
            connOpts.setCleanSession(true);

            // 设置回调
            client.setCallback(new OnMessageCallback());

            // 建立连接
            logger.info("Connecting to broker: " + broker);
            client.connect(connOpts);
            logger.info("Connected");
            logger.info("======================== emq连接成功 ========================");

            // 订阅
            client.subscribe(subTopic);
        } catch (MqttException me) {
            logger.error("reason " + me.getReasonCode());
            logger.error("msg " + me.getMessage());
            logger.error("loc " + me.getLocalizedMessage());
            logger.error("cause " + me.getCause());
            logger.error("excep " + me);
            me.printStackTrace();
        }
    }
}
