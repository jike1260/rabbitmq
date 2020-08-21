package com.lz.easycode.dao;

import com.lz.easycode.entity.Empl;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * (Empl)表数据库访问层
 *
 * @author makejava
 * @since 2020-08-11 19:10:08
 */
public interface EmplDao {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    Empl queryById(Integer id);

    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    List<Empl> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param empl 实例对象
     * @return 对象列表
     */
    List<Empl> queryAll(Empl empl);

    /**
     * 新增数据
     *
     * @param empl 实例对象
     * @return 影响行数
     */
    int insert(Empl empl);

    /**
     * 修改数据
     *
     * @param empl 实例对象
     * @return 影响行数
     */
    int update(Empl empl);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}