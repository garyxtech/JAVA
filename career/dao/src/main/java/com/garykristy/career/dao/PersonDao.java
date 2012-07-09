package com.garykristy.career.dao;

import java.sql.SQLException;
import java.util.List;

import com.garykristy.career.domain.Person;

public interface PersonDao {

	public List<Person> queryPersons(PersonSearchPara para) throws SQLException;

}
