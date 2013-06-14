package com.gk.dao.api;

public interface DaoCenter {

	public void setInitData(Object data);

	public void init();

	public <T extends BaseDao> T getDao(Class<T> clazz);

}
