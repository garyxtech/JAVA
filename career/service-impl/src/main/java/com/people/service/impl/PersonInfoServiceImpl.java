package com.people.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.jws.WebService;

import com.people.dao.PersonDao;
import com.people.dao.PersonSearchPara;
import com.people.domain.Person;
import com.people.service.PersonInfoService;

@WebService
public class PersonInfoServiceImpl implements PersonInfoService {

	private PersonDao personDao;

	public Person findPersonById(String id) throws SQLException {
		PersonSearchPara para = new PersonSearchPara();
		para.setMain(new Person());
		para.getMain().setId(id);
		List<Person> ret = personDao.queryPersons(para);
		if (ret.size() > 0) {
			return ret.get(0);
		} else {
			return null;
		}
	}

	public PersonDao getPersonDao() {
		return personDao;
	}

	public void setPersonDao(PersonDao personDao) {
		this.personDao = personDao;
	}

}
