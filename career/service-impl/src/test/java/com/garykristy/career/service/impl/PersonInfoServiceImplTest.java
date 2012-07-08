package com.garykristy.career.service.impl;

import junit.framework.TestCase;

import com.garykristy.career.domain.Person;

public class PersonInfoServiceImplTest extends TestCase {

	public PersonInfoServiceImplTest(String testName) {
		super(testName);
	}

	public void testFindPerson() {
		PersonInfoServiceImpl impl = new PersonInfoServiceImpl();
		Person personFound = impl.findPersonById("gary");
		assertNotNull(personFound);
	}

}
