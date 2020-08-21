package com.lz.easycode;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.oas.annotations.EnableOpenApi;

@EnableOpenApi
@MapperScan("com.lz.easycode.dao")
@SpringBootApplication
public class EasyCodeApplication {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        SpringApplication.run(EasyCodeApplication.class, args);
        long end = System.currentTimeMillis();
        System.out.println("========================= 启动完成 =========================");
        System.out.println("用时: " + (end - start) + " ms");
    }

}
