package com.garykristy.career.dao;

import java.util.List;

import com.garykristy.career.domain.Person;

public interface PersonDao {

	public List<Person> queryPersons(PersonSearchPara para);

}
