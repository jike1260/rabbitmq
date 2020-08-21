package com.lz.easycode.service;

import com.lz.easycode.entity.Empl;
import java.util.List;

/**
 * (Empl)表服务接口
 *
 * @author makejava
 * @since 2020-08-11 19:10:09
 */
public interface EmplService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Empl queryById(Integer id);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Empl> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param empl 实例对象
     * @return 实例对象
     */
    Empl insert(Empl empl);

    /**
     * 修改数据
     *
     * @param empl 实例对象
     * @return 实例对象
     */
    Empl update(Empl empl);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Integer id);

}