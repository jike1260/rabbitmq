package com.lz.easycode.controller;

import com.lz.easycode.mqtt.Mqtt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName MqttController
 * @Description TODO
 * @Author LZ
 * @Date 2020/8/15 17:51
 * @Version 1.0
 **/
@RestController
public class MqttController {

    @Autowired
    private Mqtt mqtt;

    @GetMapping("/mqttRun")
    public String mqttRun(){
        mqtt.mqtt();
        return "================= mqtt启动 =================";
    }
}
