package com.people.dao.impl.mapper;

import java.util.List;

import com.people.dao.PersonSearchPara;
import com.people.domain.Person;

public interface PersonMapper {

	public List<Person> queryPersons(PersonSearchPara para);

}
