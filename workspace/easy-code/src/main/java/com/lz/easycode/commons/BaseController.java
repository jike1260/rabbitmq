package com.lz.easycode.commons;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * @Description //TODO 基础控制层
 * @Param
 * @return
 * @Author LZ
 * @Date 2020/8/11 18:04
 **/
public abstract class BaseController {

	Logger logger = LoggerFactory.getLogger(this.getClass());

	/**
	 *  自动注入此资源对象
	 **/
	@Autowired
	private MessageSource messageSource;

	/**
	 * @Description //TODO 获取配置文件信息
	 * @Param [key, args]
	 * @return java.lang.String
	 * @Author LZ
	 * @Date 2020/8/11 18:04
	 **/
	public String getMessage(String key, String... args) {
		return this.messageSource.getMessage(key, args, Locale.getDefault()); 
	}

	/**
	 * @Description //TODO 自定义日期格式转换器
	 * @Param [binder]
	 * @return void
	 * @Author LZ
	 * @Date 2020/8/11 18:05
	 **/
	@InitBinder
	public void initBinder(WebDataBinder binder){
		// 首先建立一个可以将字符串转换为日期的工具程序类
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		// 明确的描述此时需要注册一个日期格式的转化处理程序类
		binder.registerCustomEditor(Date.class,new CustomDateEditor(sdf,true));
	}
}
