package com.people.dao.mock;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.people.dao.PersonDao;
import com.people.dao.PersonSearchPara;
import com.people.domain.Person;

@Component
public class PersonDaoMock implements PersonDao {

	public List<Person> queryPersons(PersonSearchPara para) throws SQLException {
		List<Person> ret = new ArrayList<Person>();
		if (null == para) {
			return ret;
		}
		if (null == para.getMain()) {
			return ret;
		}
		if ("1".equals(para.getMain().getId())) {
			Person gary_id1 = new Person();
			gary_id1.setId("1");
			gary_id1.setFirstName("gary");
			gary_id1.setLastName("xue");
			ret.add(gary_id1);
		}
		return ret;
	}

}
