package com.manager.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class BaseService<T,ID> {
    @Autowired
    private BaseMapper<T,ID> baseDao;
    /**
     * 添加记录 返回影响行数
     * @param entity
     * @return
     */
    public int save(T entity){
        return baseDao.save(entity);
    }

    /**
     * 添加记录 返回主键
     * @param entity
     * @return
     */
    public ID saveHasKey(T entity){
        baseDao.saveHasKey(entity);
        ID id=null;
        try {
            // 反射获取
           id= (ID) entity.getClass().getDeclaredField("id").get(entity);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return id;
    }

    /**
     * 批量添加
     * @param entities
     * @return
     */
    public int saveBatch(List<T> entities){
        return baseDao.saveBatch(entities);
    }


    /**
     * 记录详情查询
     * @param id
     * @return
     */
    public T queryById(ID id){
        return baseDao.queryById(id);
    }


    /**
     * 多条件列表查询
     * @param baseQuery
     * @return
     */
    public List<T> queryByParams(BaseQuery baseQuery){
        return baseDao.queryByParams(baseQuery);
    }


    /**
     * 分页查询
     * @param baseQuery
     * @return
     */
    public PageInfo<T> queryByParamsForPage(BaseQuery baseQuery){
        PageHelper.startPage(baseQuery.getPageNum(),baseQuery.getPageSize());
        return new PageInfo<T>(baseDao.queryByParams(baseQuery));
    }


    /**
     * 更新单条记录
     * @param entity
     * @return
     */
    public int update(T entity){
        return baseDao.update(entity);
    }


    /**
     * 批量更新
     * @param map
     * @return
     */
    public int updateBatch(Map<String,Object> map){
        return baseDao.updateBatch(map);
    }

    /**
     * 删除单条记录
     * @param id
     * @return
     */
    public int delete(ID id){
        return baseDao.delete(id);
    }

    /**
     * 批量删除
     * @param ids
     * @return
     */
    public int deleteBatch(ID[] ids){
        return baseDao.deleteBatch(ids);
    }

    /**
     * easyui 环境下  分页查询  方法
     * @param query
     * @return
     */
    public Map<String,Object>  queryByParamsFroDataGrid(BaseQuery query){
        PageInfo<T> saleChancePageInfo = queryByParamsForPage(query);
        Map<String,Object> result= new HashMap<String,Object>();
        result.put("total",saleChancePageInfo.getTotal());
        //rows 当前页显示的数据    在list里面是javabean对象
        result.put("rows",saleChancePageInfo.getList());
        return  result;
    }
}
