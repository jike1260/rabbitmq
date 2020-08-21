package com.lz.easycode.config;

import com.alibaba.fastjson.support.spring.FastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @ClassName RedisConfig
 * @Description TODO 基于fashjson 重写redis序列化方式
 * @Author LZ
 * @Date 2020/8/8 14:45
 * @Version 1.0
 **/
@Configuration
public class RedisConfig {

//    @Bean
//    public RedisTemplate<String, Object> getRedisTemplate( RedisConnectionFactory factory) {
//
//        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<String, Object>();
//        redisTemplate.setConnectionFactory(factory);
//        // 设置键（key）的序列化采用StringRedisSerializer。
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
//        // 设置值（value）的序列化采用FastJsonRedisSerializer。
//        redisTemplate.setValueSerializer(new FastJsonRedisSerializer<>(Object.class));
//        redisTemplate.setHashValueSerializer(new FastJsonRedisSerializer<>(Object.class));
//        return redisTemplate;
//    }
    @Bean
    public RedisTemplate<String, Object> getRedisTemplate(LettuceConnectionFactory factory) {

        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setConnectionFactory(factory);
        // 设置键（key）的序列化采用StringRedisSerializer。
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        // 设置值（value）的序列化采用FastJsonRedisSerializer。
        redisTemplate.setValueSerializer(new FastJsonRedisSerializer<>(Object.class));
        redisTemplate.setHashValueSerializer(new FastJsonRedisSerializer<>(Object.class));
        return redisTemplate;
    }

//    @Value("${spring.redis.host}")
//    private String host;
//    @Value("${spring.redis.port}")
//    private int port;
//    @Value("${spring.redis.timeout}")
//    private int timeout;

    /**
     * @Description //TODO 定义JedisPool
     * @Param []
     * @return redis.clients.jedis.JedisPool
     * @Author LZ
     * @Date 2020/8/8 15:47
     **/
//    @Bean
//    public JedisPool redisPoolFactory(){
//        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
//        JedisPool jedisPool = new JedisPool(jedisPoolConfig, host, port, timeout, null);
//        return jedisPool;
//    }
//    @Bean
//    public  RedisCommands<String, String> redisPoolFactory(){
//        RedisURI redisURI = RedisURI.create("redis://127.0.0.1/");
//        StatefulRedisConnection<String, String> connect = RedisClient.create(redisURI).connect();
//        RedisCommands<String, String> sync = connect.sync();
//        return sync;
//    }

}
