package com.jin.model;

import java.io.Serializable;

public class BaseModel implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -87057471167527954L;
	
	/** 用于 order by 排序的sql 语句。如：id desc , name */
	private String orderSql;

	public String getOrderSql() {
		return orderSql;
	}

	public void setOrderSql(String orderSql) {
		this.orderSql = orderSql;
	}


}
