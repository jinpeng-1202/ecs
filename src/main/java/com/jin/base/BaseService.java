package com.jin.base;


import com.jin.common.Pager;

import java.util.List;


/**
 * Created by dengfu on 2017/4/10.
 */
public interface BaseService<T> {


    public T getObjectById(T obj) ;

    public   int insert(T obj);


    public int update(T obj) ;

    public void saveOrUpdate(T obj);


    public   void insertBatch(final List<T> list);


    public void deleteById(T obj);


    public   List<T> queryList(T obj) ;


    public Pager<T> queryPage(T obj, Integer pageSize, Integer currentPage);

    public List getListBySqlId(String myBatisSqlId, Object conditions, T t) ;

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
    public  Pager<Object> queryPageBySqlId(String querySqlId, String countSqlId, Object param, Integer pageSize, Integer currentPage, T t);

    public int updateBySqlIdCount(String myBatisSqlId, Object conditions, T t);
    
    public T queryObj(T obj);
}
