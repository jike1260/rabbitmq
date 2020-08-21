package com.lz.easycode.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lz.easycode.commons.R;
import com.lz.easycode.constants.Constant;
import com.lz.easycode.entity.Dept;
import com.lz.easycode.enums.ExceptionEnums;
import com.lz.easycode.exception.BaseException;
import com.lz.easycode.service.DeptService;
import com.lz.easycode.commons.BaseController;
import com.lz.easycode.util.RedisUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * (Dept)表控制层
 *
 * @author makejava
 * @since 2020-08-06 17:04:38
 */
@Api(value = "DeptController",tags = "部门相关接口")
@RestController
@RequestMapping("dept")
public class DeptController extends BaseController {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 服务对象
     */
    @Autowired
    private DeptService deptService;

    @Autowired
    private RedisUtil redisUtil;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "获取部门",notes = "根据主建获取部门信息")
    @ApiImplicitParam(name = "id", value = "主键", required = true, dataType = "Integer")
    @GetMapping("selectOne")
    public R selectOne(Integer id) {

        if(id < 1){
            throw new IllegalArgumentException("参数有误,请检查后重新输入!");
        }
        //1.缓存中查找
            Object dept = redisUtil.get(Constant.REDIS_DEPT + id);
            logger.info("=== 查询redis ===" + dept);
            //2.缓存中有，则返回结果
            if(null != dept){
                Dept dept1 = JSON.parseObject(dept.toString(), Dept.class);
                return R.build(dept1);
            }
            //3.缓存中没有，则查询mysql，并存入缓存
            Dept dept2 = deptService.queryById(id);
            logger.info("=== 查询mysql ===" + JSONObject.toJSONString(dept2));
            if(null != dept2){
                redisUtil.set(Constant.REDIS_DEPT + id, JSONObject.toJSONString(dept2));
                logger.info("数据首次查询，添加到缓存" + JSONObject.toJSONString(dept2));
                return R.build(dept2);

            }
            //4.如果未查询到结果 返回异常
            throw new BaseException(ExceptionEnums.SERVER_DB_IS_NULL,"没有您要查询的数据");

    }
    
    /**
     * @Description //TODO 获取资源文件信息
     * @Param [name]
     * @return java.lang.String
     * @Author LZ
     * @Date 2020/8/7 16:40
     **/
    @GetMapping("testMsg")
    public R testMsg(String name){
        String message = getMessage("welcome.msg", name);
        String message1 = getMessage("welcome.url");
        logger.info(message);
        logger.info(message1);
        return R.build(200,message,message1);
    }

    /**
     * @Description //TODO 分页查询
     * @Param [page]    页码
     * @Param [rows]    每页条数
     * @return com.lz.easycode.commons.Result
     * @Author LZ
     * @Date 2020/8/12 11:50
     **/
    @ApiOperation(value = "获取部门信息", notes = "获取分页数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "rows", value = "单页条数", required = true, dataType = "Integer")
    })
    @GetMapping("/getList")
    public R getList(Integer page, Integer rows){
        Integer offset = (page - 1) * rows;
        List<Dept> depts = deptService.queryAllByLimit(offset, rows);
        logger.info(JSONObject.toJSONString(depts));
        return R.build(depts);
    }

}