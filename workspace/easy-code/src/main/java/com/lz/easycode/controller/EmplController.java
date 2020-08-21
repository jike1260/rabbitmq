package com.lz.easycode.controller;

import com.lz.easycode.commons.BaseController;
import com.lz.easycode.commons.R;
import com.lz.easycode.entity.Empl;
import com.lz.easycode.service.EmplService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Empl)表控制层
 *
 * @author makejava
 * @since 2020-08-11 19:05:23
 */
@Api(value = "EmplController",tags = "雇员相关接口")
@RestController
@RequestMapping("/empl")
public class EmplController extends BaseController {
    /**
     * 服务对象
     */
    @Resource
    private EmplService emplService;

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @ApiOperation(value = "获取雇员",notes = "根据主建获取雇员信息")
    @ApiImplicitParam(name = "id", value = "主键", required = true, dataType = "Integer")
    @GetMapping("selectOne")
    public R selectOne(Integer id) {
        Empl empl = emplService.queryById(id);
        return R.build(empl);
    }

    /**
     * @Description //TODO 添加一个雇员
     * @Param [empl]
     * @return java.lang.String
     * @Author LZ
     * @Date 2020/8/11 19:18
     **/
    @ApiOperation(value = "添加雇员",notes = "添加一个雇员")
    @ApiImplicitParam(name = "empl", value = "主键", required = true, dataType = "Empl")
    @PostMapping("/add")
    public R addEmpl(Empl empl){
        emplService.insert(empl);
        return R.build(empl);
    }

}