package com.garykristy.career.domain;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class PersonTest extends TestCase {
	/**
	 * Create the test case
	 * 
	 * @param testName
	 *            name of the test case
	 */
	public PersonTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(PersonTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
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
