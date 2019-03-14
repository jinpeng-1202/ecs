package com.jin.base;

import com.jin.common.Pager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by dengfu on 2017/4/10.
 */
public class BaseServiceImpl<T> implements BaseService<T> {
	//T，不限制泛型类
	protected Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	protected BaseDao<T> baseDao;

	public T getObjectById(T obj) {
		return baseDao.getObjectById(obj);
	}

	public int insert(T obj) {
		return baseDao.insert(obj);
	}

	public int update(T obj) {
		return baseDao.update(obj);
    }

	public void saveOrUpdate(T obj){
		baseDao.saveOrUpdate(obj);
	}

	public void insertBatch(final List<T> list){
		baseDao.insertBatch(list);
	}

	public void deleteById(T obj){
		baseDao.deleteById(obj);
	}

	public List<T> queryList(T obj){
		return baseDao.queryList(obj);
	}

	public Pager<T> queryPage(T obj, Integer pageSize, Integer currentPage){
		return baseDao.queryPage(obj, pageSize, currentPage);
	}

	public List getListBySqlId(String myBatisSqlId, Object conditions, T t) {
		return baseDao.getListBySqlId(myBatisSqlId, conditions, t);
	}

	public Object getObjectBySqlId(String myBatisSqlId,Object conditions,T t){
		return baseDao.getObjectBySqlId(myBatisSqlId, conditions, t);
	}

	public void updateBySqlId(String myBatisSqlId, Object conditions,T t){
		  baseDao.updateBySqlId(myBatisSqlId, conditions, t);

	}


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
	public  Pager<Object> queryPageBySqlId(String querySqlId,String countSqlId,Object param, Integer pageSize, Integer currentPage,T t){
		return baseDao.queryPageBySqlid(  querySqlId,  countSqlId,  param,   pageSize,   currentPage,  t);
	}

	public int updateBySqlIdCount(String myBatisSqlId, Object conditions, T t){
		return baseDao.updateBySqlIdCount(myBatisSqlId,conditions,t);
	}
	
	@Override
	public T queryObj(T obj){
		return baseDao.queryObj(obj);
	}


}
