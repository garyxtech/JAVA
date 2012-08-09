package com.people.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.dbunit.DatabaseUnitException;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.ext.hsqldb.HsqldbConnection;
import org.dbunit.operation.DatabaseOperation;

import com.people.dao.PersonSearchPara;
import com.people.domain.Person;

/**
 * Unit test for simple App.
 */
public class PersonDaoImplTest {

	private static PersonDaoImpl dao = new PersonDaoImpl(null);
	private static Connection connection;
	private static HsqldbConnection dbunitConnection;
	private static SqlSessionFactory factory;

	public static void setupDatabase() throws Exception {
		Class.forName("org.hsqldb.jdbcDriver");
		connection = DriverManager
				.getConnection("jdbc:hsqldb:mem:dao-impl-test;shutdown=true");
		dbunitConnection = new HsqldbConnection(connection, null);
		createTable();

		factory = new SqlSessionFactoryBuilder().build(Resources
				.getResourceAsStream("mybatis.conf.xml"));
		dao.setConnection(factory.openSession());
	}

	public static void closeDatabase() throws SQLException {
		if (connection != null) {
			connection.close();
			connection = null;
		}
		if (dbunitConnection != null) {
			dbunitConnection.close();
			dbunitConnection = null;
		}
	}

	public void testQueryUsers() throws SQLException, DatabaseUnitException,
			IOException {
		IDataSet setupDataSet = getDataSet("/users.xml");
		DatabaseOperation.CLEAN_INSERT.execute(dbunitConnection, setupDataSet);

		PersonSearchPara para = new PersonSearchPara();
		para.setMain(new Person());
		para.getMain().setId("1");
		List<Person> persons = dao.queryPersons(para);
		assertNotNull(persons);
		assertEquals("只应该找到一个Person，", 1, persons.size());
		Person gary = persons.get(0);
		assertEquals("名字应该是Gary", "gary", gary.getFirstName());
		assertEquals("姓名应该是xue", "xue", gary.getLastName());
	}

	private IDataSet getDataSet(String resPath) throws DataSetException,
			IOException {
		IDataSet set = new FlatXmlDataSet(
				PersonDaoImplTest.class.getResource(resPath));
		return set;
	}

	private static void createTable() throws SQLException, IOException {
		connection.createStatement().execute(readCreatTabelSql());
	}

	private static String readCreatTabelSql() throws IOException {
		InputStream is = PersonDaoImplTest.class.getResourceAsStream("/db.sql");
		String sql = IOUtils.toString(is);
		return sql;
	}
}
