package com.lz.easycode.mqtt;

import org.eclipse.paho.client.mqttv3.IMqttDeliveryToken;
import org.eclipse.paho.client.mqttv3.MqttCallback;
import org.eclipse.paho.client.mqttv3.MqttMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @ClassName OnMessageCallback
 * @Description TODO
 * @Author LZ
 * @Date 2020/8/15 16:55
 * @Version 1.0
 **/
public class OnMessageCallback implements MqttCallback {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public void connectionLost(Throwable cause) {
        // 连接丢失后，一般在这里面进行重连
        logger.info("连接断开，可以做重连");
    }

    /**
     * @Description //TODO 数据处理
     * @Param [topic, message]
     * @return void
     * @Author LZ
     * @Date 2020/8/15 17:30
     **/
    @Override
    public void messageArrived(String topic, MqttMessage message) throws Exception {
        // subscribe后得到的消息会执行到这里面
        logger.info("接收消息主题:" + topic);
        logger.info("接收消息Qos:" + message.getQos());
        logger.info("接收消息内容:" + new String(message.getPayload()));
    }

    @Override
    public void deliveryComplete(IMqttDeliveryToken token) {
        logger.info("deliveryComplete---------" + token.isComplete());
    }
}