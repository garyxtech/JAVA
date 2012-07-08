package com.garykristy.career.dao.impl;

import java.util.List;

import org.junit.Test;

import static org.junit.Assert.*;

import com.garykristy.career.domain.Person;

/**
 * Unit test for simple App.
 */
public class PersonDaoImplTest {

	@Test
	public void testQueryPersons() {
		PersonDaoImpl impl = new PersonDaoImpl();
		List<Person> found = impl.queryPersons(null);
		assertNotNull(found);
	}
}
