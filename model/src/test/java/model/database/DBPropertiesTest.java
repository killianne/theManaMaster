package model.database;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DBPropertiesTest {

	DBProperties dbProperties;
	
	@Before
	public void setUp() throws Exception {
		dbProperties = new DBProperties();
	}
	
	@Test
	public void testLOGIN(){
		final String expected = "root";
		assertEquals(expected, DBProperties.LOGIN);
	}
	
	@Test
	public void testPASSWORD(){
		final String expected = "";
		assertEquals(expected, DBProperties.PASSWORD);
	}
	
	@Test
	public void testURL(){
		final String expected = "jdbc:mysql://localhost/theManaMaster?autoReconnect=true&useSSL=false";
		assertEquals(expected, DBProperties.URL);
	}
	
}
