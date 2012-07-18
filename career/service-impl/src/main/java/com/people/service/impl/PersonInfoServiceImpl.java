package com.people.service.impl;

import com.people.domain.Person;
import com.people.service.PersonInfoService;

public class PersonInfoServiceImpl implements PersonInfoService {

	public Person findPersonById(String id) {
		Person ret = new Person();
		ret.setFirstName("[unknown]");
		ret.setLastName("mr?ms?");
		return ret;
	}

}
