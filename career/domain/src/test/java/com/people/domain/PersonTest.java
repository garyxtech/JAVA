package com.people.domain;

import static org.junit.Assert.*;

import org.junit.Test;

import com.people.domain.Person;

/**
 * Unit test for simple App.
 */
public class PersonTest {

	public void testFirstName() {
		Person p = new Person();
		p.setFirstName("gary");
		assertEquals("gary", p.getFirstName());
	}

	public void testLastName() {
		Person p = new Person();
		p.setLastName("xue");
		assertEquals("xue", p.getLastName());
	}
}
