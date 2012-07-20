package com.people.service.impl;

import java.sql.SQLException;
import java.util.List;

import javax.jws.WebService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

import com.people.dao.PersonDao;
import com.people.dao.PersonSearchPara;
import com.people.domain.Person;
import com.people.service.PersonInfoService;

@WebService
@Component
public class PersonInfoServiceImpl implements PersonInfoService {

	@Autowired(required = true)
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
