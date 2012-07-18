package com.people.dao.impl;

import java.sql.SQLException;
import java.util.List;

import com.people.dao.PersonDao;
import com.people.dao.PersonSearchPara;
import com.people.dao.impl.mapper.PersonMapper;
import com.people.domain.Person;

/**
 * Hello world!
 * 
 */
public class PersonDaoImpl extends BaseDaoImpl implements PersonDao {

	private PersonMapper personMapper;

	public List<Person> queryPersons(PersonSearchPara para) throws SQLException {
		personMapper = connection.getMapper(PersonMapper.class);
		List<Person> ret = personMapper.queryPersons(para);
		return ret;
	}

}
