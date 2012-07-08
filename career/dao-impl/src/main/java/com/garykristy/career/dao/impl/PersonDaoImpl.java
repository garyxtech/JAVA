package com.garykristy.career.dao.impl;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.garykristy.career.dao.PersonDao;
import com.garykristy.career.dao.PersonSearchPara;
import com.garykristy.career.domain.Person;

/**
 * Hello world!
 * 
 */
public class PersonDaoImpl implements PersonDao {

	private Connection dbConn;

	public List<Person> queryPersons(PersonSearchPara para) {
		List<Person> ret = new ArrayList<Person>();
		return ret;
	}

	public Connection getDbConn() {
		return dbConn;
	}

	public void setDbConn(Connection dbConn) {
		this.dbConn = dbConn;
	}

}
