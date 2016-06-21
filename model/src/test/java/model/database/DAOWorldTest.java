package model.database;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DAOWorldTest {

	DAOWorld daoWorld;
	
	@Before
	public void setUp() throws Exception {
		daoWorld = new DAOWorld();
	}
	
	@Test
	public void testLoadWorldById(){
		for(int id=1 ; id <= 4 ; id++) // TESTING created maps;
			assertNotNull(daoWorld.loadWorldById(id));
	}
	
	@Test
	public void testLoadDemonAPosition(){
		for(int index = 0; index < 2 ; index++)
			assertNotNull(daoWorld.loadDemonAPosition(index));
	}
	
	@Test
	public void testLoadDemonBPosition(){
		for(int index = 0; index < 2 ; index++)
			assertNotNull(daoWorld.loadDemonBPosition(index));
	}
	
	@Test
	public void testLoadDemonCPosition(){
		for(int index = 0; index < 2 ; index++)
			assertNotNull(daoWorld.loadDemonCPosition(index));
	}
	
	@Test
	public void testLoadDemonDPosition(){
		for(int index = 0; index < 2 ; index++)
			assertNotNull(daoWorld.loadDemonDPosition(index));
	}
	
	@Test
	public void testLoadEnergyBubblePosition(){
		for(int index = 0; index < 2 ; index++)
			assertNotNull(daoWorld.loadEnergyBubblePosition(index));
	}
	
	@Test
	public void testLoadDoorPosition(){
		for(int index = 0; index < 2 ; index++)
			assertNotNull(daoWorld.loadDoorPosition(index));
	}
	
	@Test
	public void testLoadPursePosition(){
		for(int index = 0; index < 2 ; index++)
			assertNotNull(daoWorld.loadPursePosition(index));
	}
	
	
}
