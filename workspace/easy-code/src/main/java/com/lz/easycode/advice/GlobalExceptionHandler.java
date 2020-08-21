package com.lz.easycode.advice;


import com.lz.easycode.exception.BaseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description //TODO 全局异常处理
 * @Param
 * @return
 * @Author LZ
 * @Date 2020/8/8 17:22
 **/
//@ControllerAdvice// 作为一个控制层的切面处理
@RestControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 * @Description //TODO rest风格
	 * @Param [request, e]
	 * @return java.lang.Object
	 * @Author LZ
	 * @Date 2020/8/8 17:23
	 **/
	@ExceptionHandler(Exception.class) // 所有的异常都是Exception子类
	public Object defaultErrorHandler(HttpServletRequest request, Exception e) {
		class ErrorInfo {
			private String code ;
			private String message ;
			private String url ;
			public String getCode() {
				return code;
			}
			public void setCode(String code) {
				this.code = code;
			}
			public String getMessage() {
				return message;
			}
			public void setMessage(String message) {
				this.message = message;
			}
			public String getUrl() {
				return url;
			}
			public void setUrl(String url) {
				this.url = url;
			}
		}
		ErrorInfo info = new ErrorInfo() ;
		//判断是否是自定义异常
		if(e instanceof BaseException){
			BaseException baseException = (BaseException) e;
			// 标记一个错误信息类型
			info.setCode(baseException.getExceptionEnums().getEcode());
			info.setMessage(baseException.getExceptionEnums().getEmsg());
			info.setUrl(request.getRequestURL().toString());
            logger.error("============================ 自定义异常 ============================");
		}else {
			info.setCode(Integer.toString(HttpStatus.INTERNAL_SERVER_ERROR.value()));
			info.setMessage(e.getMessage());
			info.setUrl(request.getRequestURL().toString());
            logger.error("============================ 系统异常 ============================");
		}
		return info ;
	}

/*	public static final String DEFAULT_ERROR_VIEW = "error"; // 定义错误显示页，error.html
	public ModelAndView defaultErrorHandler(HttpServletRequest request,
											Exception e) { // 出现异常之后会跳转到此方法
		ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW); // 设置跳转路径
		mav.addObject("exception", e); // 将异常对象传递过去
		mav.addObject("url", request.getRequestURL()); // 获得请求的路径
		return mav;
	}*/
}
