package com.lz.easycode.service.impl;

import com.lz.easycode.entity.Empl;
import com.lz.easycode.dao.EmplDao;
import com.lz.easycode.service.EmplService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * (Empl)表服务实现类
 *
 * @author makejava
 * @since 2020-08-11 19:10:09
 */
@Service("emplService")
public class EmplServiceImpl implements EmplService {
    @Resource
    private EmplDao emplDao;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public Empl queryById(Integer id) {
        return this.emplDao.queryById(id);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit 查询条数
     * @return 对象列表
     */
    @Override
    public List<Empl> queryAllByLimit(int offset, int limit) {
        return this.emplDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param empl 实例对象
     * @return 实例对象
     */
    @Override
    public Empl insert(Empl empl) {
        this.emplDao.insert(empl);
        return empl;
    }

    /**
     * 修改数据
     *
     * @param empl 实例对象
     * @return 实例对象
     */
    @Override
    public Empl update(Empl empl) {
        this.emplDao.update(empl);
        return this.queryById(empl.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer id) {
        return this.emplDao.deleteById(id) > 0;
    }
}