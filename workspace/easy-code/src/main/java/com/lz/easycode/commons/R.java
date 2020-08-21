package com.lz.easycode.commons;

import lombok.Data;

import java.io.Serializable;

/**
 * @ClassName Result
 * @Description TODO    封装统一返回结果
 * @Author LZ
 * @Date 2020/8/12 11:27
 * @Version 1.0
 **/
@Data
public class R implements Serializable {

    private Integer code;

    private String message;

    private Object data;

    public static R ok(){
        return new R(null);
    }

    public static R ok(Object data){
        return new R(data);
    }

    public static R build(Object data){
        return new R(data);
    }

    public static R build(Integer code, String message, Object data){
        return new R(code, message, data);
    }

    public R() {
    }

    public R(Object data) {
        this.code = 200;
        this.message = "OK";
        this.data = data;
    }

    public R(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

}
