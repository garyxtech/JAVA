package com.gk.service.api;

import com.gk.dao.api.DaoCenter;

public interface ServiceCenter {

	public void setInitData(Object data, DaoCenter daoCenter);

	public void init();

	public <T extends BaseService> T getService(Class<T> clazz);

}
