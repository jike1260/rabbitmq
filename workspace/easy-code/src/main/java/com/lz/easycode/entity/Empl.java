package com.lz.easycode.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * (Empl)实体类
 *
 * @author makejava
 * @since 2020-08-11 19:10:08
 */
@ApiModel
@Data
public class Empl implements Serializable {

    private static final long serialVersionUID = -94979279989229102L;

    /**
    * 主键
    */
    @ApiModelProperty(value = "主键")
    private Integer id;

    /**
    * 姓名
    */
    @ApiModelProperty(value = "姓名")
    private String name;

    /**
    * 生日
    */
    @ApiModelProperty(value = "生日")
    private Date birthday;

    /**
    * 性别
    */
    @ApiModelProperty(value = "性别")
    private Integer sex;

    /**
    * 工资
    */
    @ApiModelProperty(value = "工资")
    private Double salary;

    /**
    * 联系电话
    */
    @ApiModelProperty(value = "联系电话")
    private String phone;

    /**
    * 联系地址
    */
    @ApiModelProperty(value = "联系地址")
    private String addr;

}