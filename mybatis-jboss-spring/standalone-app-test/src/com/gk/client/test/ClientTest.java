package com.gk.client.test;

import java.lang.reflect.InvocationTargetException;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.gk.dao.api.DaoCenter;
import com.gk.pojo.User;
import com.gk.service.api.ServiceCenter;
import com.gk.service.api.UserService;

public class ClientTest {

	public static void main(String[] args) throws Throwable {

		ClassPathXmlApplicationContext springContext = new ClassPathXmlApplicationContext(
				new String[] { "/com/gk/service/impl/conf/spring-service.xml",
						"com/gk/dao/impl/conf/spring-dao.xml" });

		DaoCenter dc = getDaoCenter();
		dc.setInitData(springContext);
		dc.init();

		ServiceCenter sc = getServiceCenter(dc);
		sc.setInitData(springContext, dc);
		sc.init();

		UserService userService = sc.getService(UserService.class);

		User defaultUser = userService.getUserById(0);

		System.out.println("Default user is: " + defaultUser.getFirstName()
				+ " " + defaultUser.getLastName());

		springContext.close();
	}

	private static ServiceCenter getServiceCenter(DaoCenter dc)
			throws IllegalArgumentException, SecurityException, InstantiationException, IllegalAccessException, InvocationTargetException, NoSuchMethodException, ClassNotFoundException {
		return (ServiceCenter) Class.forName("com.gk.service.impl.SpringServiceCenterImpl")
				.getConstructor().newInstance();
	}

	private static DaoCenter getDaoCenter() throws IllegalArgumentException,
			SecurityException, InstantiationException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException,
			ClassNotFoundException {
		return (DaoCenter) Class.forName("com.gk.dao.impl.SpringDaoCenterImpl")
				.getConstructor().newInstance();
	}

}
