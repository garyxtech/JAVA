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
				new String[] {
						"/com/gk/service/impl/binding/spring/conf/spring-service.xml",
						"com/gk/dao/impl/binding/spring/conf/spring-dao.xml" });

		DaoCenter dc = getDaoCenter();
		dc.setInitData(springContext);
		dc.init();

		ServiceCenter sc = getServiceCenter(dc);
		sc.setInitData(springContext, dc);
		sc.init();

		UserService userService = sc.getService(UserService.class);

		// ==========================================================

		System.out.println("========== create table");
		userService.createUserTable();

		printAllUsers(userService);

		// ====== test for transaction
		try {
			userService.testTransaction();
		} catch (Exception e) {
			System.out.println("Catch Ex: " + e.getMessage());
		}
		printAllUsers(userService);

		/*
		 * 
		 * // ==========================================================
		 * 
		 * System.out.println("====== To insert admin and f1 and f2 ======");
		 * try { userService.insertF1F2AndThenADMIN(); } catch (Exception e) {
		 * System.out.println("ERROR:" + e.getMessage()); }
		 * 
		 * printAllUsers(userService);
		 * 
		 * // ==========================================================
		 * 
		 * System.out
		 * .println("====== To insert admin and f1 and f2 AGAIN =========");
		 * 
		 * try { userService.insertF1F2AndThenADMIN(); } catch (Exception e) {
		 * System.out.println("ERROR:" + e.getMessage()); }
		 * 
		 * printAllUsers(userService);
		 */

	}

	private static ServiceCenter getServiceCenter(DaoCenter dc)
			throws IllegalArgumentException, SecurityException,
			InstantiationException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException,
			ClassNotFoundException {
		return (ServiceCenter) Class
				.forName(
						"com.gk.service.impl.binding.spring.SpringServiceCenterImpl")
				.getConstructor().newInstance();
	}

	private static DaoCenter getDaoCenter() throws IllegalArgumentException,
			SecurityException, InstantiationException, IllegalAccessException,
			InvocationTargetException, NoSuchMethodException,
			ClassNotFoundException {
		return (DaoCenter) Class
				.forName("com.gk.dao.impl.binding.spring.SpringDaoCenterImpl")
				.getConstructor().newInstance();
	}

	private static void printAllUsers(UserService service) {
		System.out.println("-- all users --");
		for (User u : service.fetchAllUsers()) {
			System.out.println(u.getFirstName() + " " + u.getLastName());
		}
	}

}
