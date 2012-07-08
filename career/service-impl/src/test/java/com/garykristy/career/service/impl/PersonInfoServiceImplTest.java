package com.garykristy.career.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.garykristy.career.domain.Person;

public class PersonInfoServiceImplTest {

	@Test
	public void testFindPerson() {
		PersonInfoServiceImpl impl = new PersonInfoServiceImpl();
		Person personFound = impl.findPersonById("gary");
		assertNotNull(personFound);
	}

}
