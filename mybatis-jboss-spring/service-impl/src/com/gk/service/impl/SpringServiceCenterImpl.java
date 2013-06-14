package com.gk.service.impl;

import org.springframework.context.ApplicationContext;

import com.gk.dao.api.DaoCenter;
import com.gk.service.api.BaseService;
import com.gk.service.api.ServiceCenter;

public class SpringServiceCenterImpl implements ServiceCenter {

	private DaoCenter daoCenter;

	private ApplicationContext springContext;

	@SuppressWarnings("unchecked")
	@Override
	public <T extends BaseService> T getService(Class<T> clazz) {
		T service = (T) springContext.getBean(clazz.getName());
		service.setDaoCenter(daoCenter);
		return service;
	}

	@Override
	public void setInitData(Object data) {
		springContext = (ApplicationContext) data;
	}

	@Override
	public void init() {
		daoCenter = (DaoCenter) springContext.getBean("daoCenter");
		daoCenter.setInitData(springContext);
		daoCenter.init();
	}

}
