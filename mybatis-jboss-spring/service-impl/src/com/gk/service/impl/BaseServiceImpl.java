package com.gk.service.impl;

import com.gk.dao.api.DaoCenter;
import com.gk.service.api.BaseService;

public abstract class BaseServiceImpl implements BaseService {

	protected DaoCenter daoCenter;

	@Override
	public void setDaoCenter(DaoCenter daoCenter) {
		this.daoCenter = daoCenter;
	}

}
