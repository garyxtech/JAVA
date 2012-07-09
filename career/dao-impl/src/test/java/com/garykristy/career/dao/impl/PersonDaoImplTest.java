package com.garykristy.career.dao.impl;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.io.IOUtils;
import org.dbunit.DatabaseUnitException;
import org.dbunit.dataset.DataSetException;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.ext.hsqldb.HsqldbConnection;
import org.dbunit.operation.DatabaseOperation;
import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.garykristy.career.dao.PersonSearchPara;
import com.garykristy.career.domain.Person;

/**
 * Unit test for simple App.
 */
public class PersonDaoImplTest {

	private static PersonDaoImpl dao = new PersonDaoImpl();
	private static Connection connection;
	private static HsqldbConnection dbunitConnection;

	@BeforeClass
	public static void setupDatabase() throws Exception {
		Class.forName("org.hsqldb.jdbcDriver");
		connection = DriverManager
				.getConnection("jdbc:hsqldb:mem:dao-impl-test;shutdown=true");
		dbunitConnection = new HsqldbConnection(connection, null);
		dao.setDbConn(connection);
		createTable();
	}

	@AfterClass
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

	@Test
	public void testQueryUsers() throws SQLException, DatabaseUnitException,
			IOException {
		IDataSet setupDataSet = getDataSet("/users.xml");
		DatabaseOperation.CLEAN_INSERT.execute(dbunitConnection, setupDataSet);

		List<Person> persons = dao.queryPersons(new PersonSearchPara());
		assertNotNull(persons);
		assertEquals("只应该找到一个Person，", 1, persons.size());
		Person gary = persons.get(0);
		assertEquals("gary", gary.getFirstName());
		assertEquals("xue", gary.getLastName());
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
