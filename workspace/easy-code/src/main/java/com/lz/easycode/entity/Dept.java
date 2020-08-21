package com.lz.easycode.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * (Dept)实体类
 *
 * @author makejava
 * @since 2020-08-06 17:04:36
 */
@Data
@ApiModel
public class Dept implements Serializable {

    private static final long serialVersionUID = -67803845169422879L;

    /**
    * id
    */
    @ApiModelProperty(value = "id")
    private Integer deptno;

    /**
    * 部门名称
    */
    @ApiModelProperty(value = "部门名称")
    private String dname;

    /**
    * 所在库
    */
    @ApiModelProperty(value = "所在库")
    private String loc;

}