package com.people.service.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.people.domain.Person;
import com.people.service.PersonInfoService;

public class PersonInfoServiceImplTest {

	private ApplicationContext springContext;

	private PersonInfoService pis;

	public void setupPersonInfoServiceImpl() throws SQLException {

		springContext = new ClassPathXmlApplicationContext(
				"classpath:spring.xml");

		pis = springContext.getBean(PersonInfoService.class);

	}

	public void testFindPerson() throws SQLException {
		Person personFound = pis.findPersonById("1");
		assertNotNull("必须找到对应person", personFound);
		assertEquals("名字要匹配", "gary", personFound.getFirstName());
		assertEquals("姓要匹配", "xue", personFound.getLastName());
	}

	public void testFindPersonNullID() throws SQLException {
		Person p = pis.findPersonById(null);
		assertNull("null参数返回必须为null对象", p);
	}
}
