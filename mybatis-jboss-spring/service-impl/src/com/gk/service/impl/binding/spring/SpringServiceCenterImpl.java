package com.gk.service.impl.binding.spring;

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
	public void setInitData(Object data, DaoCenter daoCenter) {
		this.springContext = (ApplicationContext) data;
		this.daoCenter = daoCenter;
	}

	@Override
	public void init() {
		//do some other init settings
	}

}
