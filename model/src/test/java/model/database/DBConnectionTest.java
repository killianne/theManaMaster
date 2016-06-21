package model.database;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

public class DBConnectionTest {

	DBConnection dbConnection;

	@Before
	public void setUp() throws Exception {
		dbConnection = new DBConnection();
	}
	
	@Test
	public void testINSTANCENotNull(){
		assertNotNull(DBConnection.INSTANCE);
	}
	
	@Test
	public void testSingletonInstance(){
		assertNotNull(DBConnection.getInstance());
	}
	
	@Test
	public void testOpen(){
		final boolean expected = true;
		assertEquals(expected, dbConnection.open());
	}
	
	// TESTING GETTERS AND SETTERS
	
	@Test
	public void testGetConnection(){
		assertNotNull(dbConnection.getConnection());
	}
	
	@Test
	public void testSetConnection(){
		dbConnection.setConnection(null);
		assertNull(dbConnection.getConnection());
	}
	
	@Test
	public void testGetStatement(){
		assertNull(dbConnection.getStatement());
	}
	
	@Test
	public void testSetStatement(){
		dbConnection.setStatement(null);
		assertNull(dbConnection.getStatement());
	}
	
	
	

}
