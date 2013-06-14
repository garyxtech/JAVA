package com.gk.dao.impl;

import org.springframework.context.ApplicationContext;

import com.gk.dao.api.BaseDao;
import com.gk.dao.api.DaoCenter;

public class SpringDaoCenterImpl implements DaoCenter {

	private ApplicationContext springContext;

	@SuppressWarnings("unchecked")
	@Override
	public <T extends BaseDao> T getDao(Class<T> clazz) {
		T dao = (T) springContext.getBean(clazz.getName());
		return dao;
	}

	@Override
	public void setInitData(Object data) {
		springContext = (ApplicationContext) data;
	}

	@Override
	public void init() {
	}

}
