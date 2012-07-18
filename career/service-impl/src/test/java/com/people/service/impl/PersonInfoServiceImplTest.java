package com.people.service.impl;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatcher;

import com.people.dao.PersonDao;
import com.people.dao.PersonSearchPara;
import com.people.domain.Person;

public class PersonInfoServiceImplTest {

	private PersonInfoServiceImpl pis;

	@Before
	public void setupPersonInfoServiceImpl() throws SQLException {

		pis = new PersonInfoServiceImpl();

		PersonDao pDao = mock(PersonDao.class);
		when(pDao.queryPersons(argThat(new ArgumentMatcher<PersonSearchPara>() {
			@Override
			public boolean matches(Object argument) {
				PersonSearchPara arg = (PersonSearchPara) argument;
				return null != arg && "gary".equals(arg.getMain().getId());
			}
		}))).thenReturn(getPersonGary());
		when(pDao.queryPersons(argThat(new ArgumentMatcher<PersonSearchPara>() {
			@Override
			public boolean matches(Object argument) {
				PersonSearchPara arg = (PersonSearchPara) argument;
				return null != arg && "kristy".equals(arg.getMain().getId());
			}
		}))).thenReturn(getPersonKristy());

		pis.setPersonDao(pDao);
	}

	private List<Person> getPersonGary() {
		Person p = new Person();
		p.setId("gary");
		p.setFirstName("gary");
		p.setLastName("xue");
		List<Person> ret = new ArrayList<Person>();
		ret.add(p);
		return ret;
	}

	private List<Person> getPersonKristy() {
		Person p = new Person();
		p.setId("kristy");
		p.setFirstName("kristy");
		p.setLastName("liu");
		List<Person> ret = new ArrayList<Person>();
		ret.add(p);
		return ret;
	}

	@Test
	public void testFindPerson() throws SQLException {
		Person personFound = pis.findPersonById("gary");
		assertNotNull("必须找到对应person", personFound);
		assertEquals("名字要匹配", "gary", personFound.getFirstName());
		assertEquals("姓要匹配", "xue", personFound.getLastName());

	}
}
