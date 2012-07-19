package com.people.service;

import java.sql.SQLException;

import javax.jws.WebMethod;
import javax.jws.WebService;

import com.people.domain.Person;

@WebService
public interface PersonInfoService {

	@WebMethod
	public Person findPersonById(String id) throws SQLException;

}
