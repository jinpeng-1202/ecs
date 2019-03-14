package com.jin.base;


import com.jin.common.Pager;

import java.util.List;


public interface BaseDao<T>{


    /**
     * 根据ID是查询对象
     * @param obj
     * @return
     */
    public T getObjectById(T obj) ;


    /**
     * 插入记录
     * @param obj
     */
    public   int insert(T obj);
    /**
     * 更新记录
     * @param obj
     */
    public int update(T obj) ;

    /**
     * 保存或修改表
     * @param obj
     */
    public void saveOrUpdate(T obj);


    public   void insertBatch(final List<T> list);

    /**
     * 根据ID删除记录
     * @param obj
     */
    public void deleteById(T obj);

    /**
     * 查询
     * @param obj
     * @return
     */
    public   List<T> queryList(T obj) ;
    public Pager<T> queryPage(T obj, Integer pageSize, Integer currentPage);


    /**
     * 根据 sqlid 查询数据返回列表数据
     * @param myBatisSqlId
     * @param conditions
     * @param t
     * @return
     */
    public List getListBySqlId(String myBatisSqlId, Object conditions, T t);


    /**
     * 根据 sqlid 查询数据返回单个数据
     * @param myBatisSqlId
     * @param conditions
     * @param t
     * @return
     */
    public Object getObjectBySqlId(String myBatisSqlId, Object conditions, T t);

    public void updateBySqlId(String myBatisSqlId, Object conditions, T t);
    /**
     * 根据自定义语句查询数据
     * @param querySqlId   查询居ID
     * @param countSqlId   查询总记录数语句。
     * @param param   参数
     * @param pageSize  每页大小
     * @param currentPage  查询当前页。
     * @param t
     * @return
     */
    public  Pager<Object> queryPageBySqlid(String querySqlId, String countSqlId, Object param, Integer pageSize, Integer currentPage, T t);


    public int updateBySqlIdCount(String myBatisSqlId, Object conditions, T t);
    
    /**
     * 
     * 根据参数查询单个对象
     * @Title: queryObj 
     * @date 2017年5月10日 下午4:01:20
     * @author 邓夫
     * @modifier 
     * @modifydate 
     * @param obj
     * @return
     */
    public T queryObj(T obj);
}
