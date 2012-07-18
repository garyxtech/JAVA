package com.people.dao;

import java.sql.SQLException;
import java.util.List;

import com.people.domain.Person;

public interface PersonDao {

	public List<Person> queryPersons(PersonSearchPara para) throws SQLException;

}
