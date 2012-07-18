package com.people.service;

import java.sql.SQLException;

import com.people.domain.Person;

public interface PersonInfoService {

	public Person findPersonById(String id) throws SQLException;

}
