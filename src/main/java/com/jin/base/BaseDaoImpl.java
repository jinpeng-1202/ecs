package com.jin.base;

import com.jin.common.Pager;
import org.apache.commons.beanutils.PropertyUtils;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {

    @Resource
    private SqlSessionTemplate sqlSession;


    /**
     * @Description: 通过对象获得名称（辅助方法）
     */
    private String getModel(T obj) {
        String paths = obj.getClass().toString();
        String model = paths.substring(paths.lastIndexOf(".") + 1, paths.length());

        return model;
    }

    /**
     * 根据ID是查询对象
     *
     * @param obj
     * @return
     */
    public T getObjectById(T obj) {
        String model = getModel(obj);
        Class<? extends Object> clazz = obj.getClass();
        Long id;
        try {
            Method m = clazz.getDeclaredMethod("getId");
            id = (Long) m.invoke(obj);
        } catch (Exception e) {
            throw new RuntimeException("根据ID查询对象时，反射出错", e);
        }

        String packageName = obj.getClass().getPackage().getName();
        String statement = "com.jin.dao." + model + "Dao.getObjectById";
        T t = sqlSession.selectOne(statement, id);
        return t;
    }


    /**
     * 插入记录
     * 返回插入记录的条数
     *
     * @param obj
     */
    public int insert(T obj) {
        String model = getModel(obj);
        String packageName = obj.getClass().getPackage().getName();
        String statement = "com.jin.dao." + model + "Dao.insert";
        int o = sqlSession.insert(statement, obj);
        return o;
    }

    /**
     * 更新记录
     *
     * @param obj
     */
    public int update(T obj) {
        String model = getModel(obj);
        String packageName = obj.getClass().getPackage().getName();
        String statement = "com.jin.dao." + model + "Dao.update";
        return sqlSession.update(statement, obj);
    }

    /**
     * 保存或修改表
     *
     * @param obj
     */
    public void saveOrUpdate(T obj) {
        String model = getModel(obj);

        Class<? extends Object> clazz = obj.getClass();
        Long id;
        try {
            Method m = clazz.getDeclaredMethod("getId");
            id = (Long) m.invoke(obj);
        } catch (Exception e) {

            throw new RuntimeException("根据ID查询对象时，反射出错", e);
        }
        String packageName = obj.getClass().getPackage().getName();
        String statement = "com.jin.dao." + model + "Dao.getObjectById";
        T t = sqlSession.selectOne(statement, id);
        if (t != null) {
            statement = "com.jin.dao." + model + "Dao.update";
            sqlSession.update(statement, obj);
        } else {
            statement = "com.jin.dao." + model + "Dao.insert";
            sqlSession.insert(statement, obj);
        }
    }


    public void insertBatch(final List<T> list) {
        if (list.isEmpty() || list == null) {
            return;
        }

        T obj = list.get(0);
        String model = getModel(obj);
        try {
            sqlSession.getConnection().setReadOnly(false);
            System.out.println(sqlSession.getConnection().isReadOnly());
        } catch (Exception e) {
        }
        String packageName = obj.getClass().getPackage().getName();
        String statement = "com.jin.dao." + model + "Dao.insertBatch";
        sqlSession.insert(statement, list);
    }

    /**
     * 根据ID删除记录
     *
     * @param obj
     */
    public void deleteById(T obj) {
        String model = getModel(obj);
        String packageName = obj.getClass().getPackage().getName();
        String statement = "com.jin.dao." + model + "Dao.delete";
        try {
            sqlSession.getConnection().setReadOnly(false);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        sqlSession.delete(statement, obj);
    }

    /**
     * 查询
     *
     * @param obj
     * @return
     */
    public List<T> queryList(T obj) {
        String model = getModel(obj);
        List<T> list = null;
        String packageName = obj.getClass().getPackage().getName();
        String statement = "com.jin.dao." + model + "Dao.getList";
        list = sqlSession.selectList(statement, obj);
        if (list == null)
            list = new ArrayList<T>();
        return list;
    }

    public T queryObj(T obj) {
        String model = getModel(obj);
        String statement = "com.jin.dao." + model + "Dao.getList";
        return sqlSession.selectOne(statement, obj);
    }

    public Pager<T> queryPage(T obj, Integer pageSize, Integer currentPage) {
        String model = getModel(obj);
        List<T> list = null;
        Pager<T> page = new Pager<T>();
        page.setPageSize(pageSize);
        page.setCpage(currentPage);
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            map = PropertyUtils.describe(obj);
        } catch (Exception e) {
            e.printStackTrace();
        }
        String packageName = obj.getClass().getPackage().getName();
        String statement = "com.jin.dao." + model + "Dao.getListForPageCount";

        Long totalSize = (Long) sqlSession.selectOne(statement, map);
        page.setTotalItem(totalSize);
        map.put("startRow", page.getPageStart());
        map.put("endRow", page.getPageSize());
        statement = "com.jin.dao." + model + "Dao.getListForPage";
        list = sqlSession.selectList(statement, map);
        page.setList(list);
        return page;
    }


    /**
     * 根据 sqlid 查询数据返回列表数据。
     *
     * @param myBatisSqlId
     * @param conditions
     * @param t
     * @return
     */
    @Override
    public List getListBySqlId(String myBatisSqlId, Object conditions, T t) {
        String model = getModel(t);
        String statement = "com.jin.dao." + model + "Dao." + myBatisSqlId;
        List list = sqlSession.selectList(statement, conditions);
        return list;
    }


    /**
     * 根据 sqlid 查询数据返回单个数据
     *
     * @param myBatisSqlId
     * @param conditions
     * @param t
     * @return
     */
    public Object getObjectBySqlId(String myBatisSqlId, Object conditions, T t) {
        String model = getModel(t);
        String statement = "com.jin.dao." + model + "Dao." + myBatisSqlId;
        Object object = sqlSession.selectOne(statement, conditions);
        return object;
    }

    /**
     *  根据sqlid更新 返回更新行数
     * @param myBatisSqlId
     * @param conditions
     * @param t
     */
    public int updateBySqlIdCount(String myBatisSqlId, Object conditions, T t) {
        String model = getModel(t);
        String statement = "com.jin.dao." + model + "Dao." + myBatisSqlId;
        return sqlSession.update(statement, conditions);
    }


    public void updateBySqlId(String myBatisSqlId, Object conditions, T t) {
        String model = getModel(t);
        String statement = "com.jin.dao." + model + "Dao." + myBatisSqlId;
        sqlSession.update(statement, conditions);
    }


    /**
     * 根据自定义语句查询数据
     *
     * @param querySqlId  查询居ID
     * @param countSqlId  查询总记录数语句。
     * @param param       参数
     * @param pageSize    每页大小
     * @param currentPage 查询当前页。
     * @param t
     * @return
     */
    public Pager<Object> queryPageBySqlid(String querySqlId, String countSqlId, Object param, Integer pageSize, Integer currentPage, T t) {
        String model = getModel(t);
        List<Object> list = null;
        Pager<Object> page = new Pager<Object>();
        page.setPageSize(pageSize);
        page.setCpage(currentPage);
        Map<String, Object> map = new HashMap<String, Object>();
        try {
            if (param instanceof Map) {
                map.putAll((Map<String, Object>) param);
            } else
                map = PropertyUtils.describe(param);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String statement = "com.jin.dao." + model + "Dao." + countSqlId;

        Long totalSize = (Long) sqlSession.selectOne(statement, map);
        page.setTotalItem(totalSize);
        map.put("startRow", page.getPageStart());
        map.put("endRow", page.getPageSize());
        statement = "com.jin.dao." + model + "Dao." + querySqlId;
        list = sqlSession.selectList(statement, map);
        page.setList(list);
        return page;
    }

}
