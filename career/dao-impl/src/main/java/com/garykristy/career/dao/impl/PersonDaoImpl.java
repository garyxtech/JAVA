package com.garykristy.career.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
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

	public List<Person> queryPersons(PersonSearchPara para) throws SQLException {
		List<Person> ret = new ArrayList<Person>();
		ResultSet rs = dbConn.createStatement().executeQuery(
				"select * from Person");
		while (rs.next()) {
			Person p = new Person();
			p.setId(rs.getString("id"));
			p.setFirstName(rs.getString("firstName"));
			p.setLastName(rs.getString("lastName"));
			ret.add(p);
		}
		return ret;
	}

	public Connection getDbConn() {
		return dbConn;
	}

	public void setDbConn(Connection dbConn) {
		this.dbConn = dbConn;
	}

}
