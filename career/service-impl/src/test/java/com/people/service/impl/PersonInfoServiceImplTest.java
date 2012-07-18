package com.people.service.impl;

import static org.junit.Assert.*;

import org.junit.Test;

import com.people.domain.Person;
import com.people.service.impl.PersonInfoServiceImpl;

public class PersonInfoServiceImplTest {

	@Test
	public void testFindPerson() {
		PersonInfoServiceImpl impl = new PersonInfoServiceImpl();
		Person personFound = impl.findPersonById("gary");
		assertNotNull(personFound);
	}

}
