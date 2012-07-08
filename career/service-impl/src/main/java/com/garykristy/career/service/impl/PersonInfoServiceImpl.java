package com.garykristy.career.service.impl;

import com.garykristy.career.domain.Person;
import com.garykristy.career.service.PersonInfoService;

public class PersonInfoServiceImpl implements PersonInfoService {

	public Person findPersonById(String id) {
		Person ret = new Person();
		ret.setFirstName("[unknown]");
		ret.setLastName("mr?ms?");
		return ret;
	}

}
