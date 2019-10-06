package com.shsxt.base;

import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;

/**
 * BaseMapper 接口方法定义
 *  基本CRUD 方法定义
 *
 *  添加
 *     添加记录  返回影响行数
 *     添加记录返回主键
 *     批量添加
 *  查询
 *     详情查询
 *     列表查询（分页   不分页）
 *  更新
 *      单条记录更新
 *      批量更新
 *   删除
 *      单条记录删除
 *      批量删除
 */

public interface BaseMapper<T,ID> {

    /**
     * 添加记录 返回影响行数
     * @param entity
     * @return
     */
    public int save(T entity);

    /**
     * 添加记录 返回主键
     * @param entity
     * @return
     */
    public ID saveHasKey(T entity);

    /**
     * 批量添加
     * @param entities
     * @return
     */
    public int saveBatch(List<T> entities);


    /**
     * 记录详情查询
     * @param id
     * @return
     */
    public T queryById(ID id);


    /**
     * 多条件列表查询
     * @param baseQuery
     * @return
     */
    public List<T> queryByParams(BaseQuery baseQuery);


    /**
     * 分页查询
     * @param baseQuery
     * @return
     */
    public PageInfo<T> queryByParamsForPage(BaseQuery baseQuery);


    /**
     * 更新单条记录
     * @param entity
     * @return
     */
    public int update(T entity);


    /**
     * 批量更新
     * @param map
     * @return
     */
    public int updateBatch(Map<String, Object> map);

    /**
     * 删除单条记录
     * @param id
     * @return
     */
    public int delete(ID id);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    public int deleteBatch(ID[] ids);


}
