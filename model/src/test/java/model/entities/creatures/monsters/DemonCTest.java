package model.entities.creatures.monsters;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class DemonCTest extends MonsterTest{

	@Before
	public void setUp() throws Exception {
		this.monster = new DemonC(15, 4);
	}

	@Test
	public void testGetPosX(){
		final int expectedX = 15;
		assertEquals(expectedX, this.monster.getPosX());
	}
	
	@Test
	public void testGetPosY(){
		final int expectedY = 4;
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
	public void testDemonCMinPosX(){
		try{
		new DemonC(-1, 9);
		fail("Should return an Exception when posX < 0");
		}catch(Exception e){
			String expected = "demonC posX out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void testDemonCMaxPosX(){
		try{
		new DemonC(21, 9);
		fail("Should return an Exception when posX > 20");
		}catch(Exception e){
			String expected = "demonC posX out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void testDemonCMinPosY(){
		try{
		new DemonC(4, -1);
		fail("Should return an Exception when posY < 0");
		}catch(Exception e){
			String expected = "demonC posY out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void testDemonCMaxPosY(){
		try{
		new DemonC(4, 13);
		fail("Should return an Exception when posY > 12");
		}catch(Exception e){
			String expected = "demonC posY out of range";
			assertEquals(expected, e.getMessage());
		}
	}

}
