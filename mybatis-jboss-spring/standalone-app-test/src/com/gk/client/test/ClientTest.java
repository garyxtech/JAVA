package com.gk.client.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gk.pojo.User;
import com.gk.service.api.ServiceCenter;
import com.gk.service.api.UserService;

public class ClientTest {

	public static void main(String[] args) {

		ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext(
				new String[] { "/com/gk/service/impl/conf/spring-service.xml",
						"com/gk/dao/impl/conf/spring-dao.xml" });

		ServiceCenter sc = springContext.getBean("serviceCenter",
				ServiceCenter.class);
		
		sc.setInitData(springContext);
		sc.init();

		UserService userService = sc.getService(UserService.class);

		User defaultUser = userService.getUserById(0);

		System.out.println("Default user is: " + defaultUser.getFirstName()
				+ " " + defaultUser.getLastName());

		springContext.close();
	}

}
