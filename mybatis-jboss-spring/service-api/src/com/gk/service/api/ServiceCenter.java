package com.gk.service.api;

public interface ServiceCenter {

	public void setInitData(Object data);

	public void init();

	public <T extends BaseService> T getService(Class<T> clazz);

}
