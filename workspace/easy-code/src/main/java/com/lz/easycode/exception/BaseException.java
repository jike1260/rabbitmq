package com.lz.easycode.exception;

import com.lz.easycode.enums.ExceptionEnums;

/**
 * @ClassName BaseException
 * @Description TODO    自定义异常类
 * @Author LZ
 * @Date 2020/8/8 17:37
 * @Version 1.0
 **/
public class BaseException extends RuntimeException{


    private ExceptionEnums exceptionEnums;

    private Object data;

    private String detailInfo;

    public BaseException(ExceptionEnums exceptionEnums) {
        this.exceptionEnums = exceptionEnums;
    }

    public BaseException(ExceptionEnums exceptionEnums, String detailInfo) {
        this.exceptionEnums = exceptionEnums;
        this.detailInfo = detailInfo;
    }

    public BaseException(ExceptionEnums exceptionEnums, Object data) {
        this.exceptionEnums = exceptionEnums;
        this.data = data;
    }

    public BaseException(ExceptionEnums exceptionEnums,Object data,String detailInfo ) {
        this.exceptionEnums = exceptionEnums;
        this.data = data;
        this.detailInfo = detailInfo;
    }


    public ExceptionEnums getExceptionEnums() {
        return exceptionEnums;
    }

    public void setExceptionEnums(ExceptionEnums exceptionEnums) {
        this.exceptionEnums = exceptionEnums;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return detailInfo;
    }

    public void setErrorMsg(String detailInfo) {
        this.detailInfo = detailInfo;
    }

    @Override
    public String toString() {
        return "BaseException{" +
                "exceptionEnums=" + exceptionEnums +
                ", data=" + data +
                ", detailInfo='" + detailInfo + '\'' +
                '}';
    }
}
