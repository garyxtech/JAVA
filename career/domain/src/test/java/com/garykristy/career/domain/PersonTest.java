package com.garykristy.career.domain;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class PersonTest {

	@Test
	public void testFirstName() {
		Person p = new Person();
		p.setFirstName("gary");
		assertEquals("gary", p.getFirstName());
	}

	@Test
	public void testLastName() {
		Person p = new Person();
		p.setLastName("xue");
		assertEquals("xue", p.getLastName());
	}
}
