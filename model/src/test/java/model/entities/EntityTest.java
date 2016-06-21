package model.entities;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class EntityTest{

	protected Entity entity;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetPosX(){
		assertNotNull(this.entity.getPosX());
	}
	
	@Test
	public void testGetPosY(){
		assertNotNull(this.entity.getPosY());
	}
	
	

}
