package model.entities.creatures.monsters;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class DemonDTest extends MonsterTest{
	
	@Before
	public void setUp() throws Exception {
		this.monster = new DemonD(10, 9);
	}

	@Test
	public void testGetPosX(){
		final int expectedX = 10;
		assertEquals(expectedX, this.monster.getPosX());
	}
	
	@Test
	public void testGetPosY(){
		final int expectedY = 9;
		assertEquals(expectedY, this.monster.getPosY());
	}	
	
	@Test
	public void testSetPosX(){
		int expected = 5;
		this.monster.setPosX(expected);
		assertEquals(expected, this.monster.getPosX());
	}
	
	@Test
	public void testSetPosY(){
		int expected = 10;
		this.monster.setPosY(expected);
		assertEquals(expected, this.monster.getPosY());
	}
	
	@Test
	public void testIsDead(){ // Life is > 0
		boolean expected = false;
		assertEquals(expected, this.monster.isDead());
	}
	
	@Test
	public void testGetHealth(){
		int expected = 0; // No Lives have been put;
		assertEquals(expected, this.monster.getHealth());
	}
	
	@Test
	public void testSetHealth(){
		int expected = 11;
		this.monster.setHealth(expected);
		assertEquals(expected, this.monster.getHealth());
	}
	
	@Test
	public void testDemonDMinPosX(){
		try{
		new DemonD(-1, 9);
		fail("Should return an Exception when posX < 0");
		}catch(Exception e){
			String expected = "demonD posX out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void testDemonDMaxPosX(){
		try{
		new DemonD(21, 9);
		fail("Should return an Exception when posX > 20");
		}catch(Exception e){
			String expected = "demonD posX out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void testDemonDMinPosY(){
		try{
		new DemonD(4, -1);
		fail("Should return an Exception when posY < 0");
		}catch(Exception e){
			String expected = "demonD posY out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void testDemonDMaxPosY(){
		try{
		new DemonD(4, 13);
		fail("Should return an Exception when posY > 12");
		}catch(Exception e){
			String expected = "demonD posY out of range";
			assertEquals(expected, e.getMessage());
		}
	}

}
