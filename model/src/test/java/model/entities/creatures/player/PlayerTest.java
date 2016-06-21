package model.entities.creatures.player;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.ControllerOrder;
import model.entities.creatures.CreatureTest;

public class PlayerTest extends CreatureTest{

	@Override
	@Before
	public void setUp() throws Exception {
		this.creature = new Player(4, 9, ControllerOrder.DL);
	}
	
	@Test
	public void testGetPosX(){
		final int expectedX = 4;
		assertEquals(expectedX, this.creature.getPosX());
	}
	
	@Test
	public void testGetPosY(){
		final int expectedY = 9;
		assertEquals(expectedY, this.creature.getPosY());
	}	
	
	@Test
	public void testSetPosX(){
		int expected = 4;
		this.creature.setPosX(expected);
		assertEquals(expected, this.creature.getPosX());
	}
	
	@Test
	public void testSetPosY(){
		int expected = 9;
		this.creature.setPosY(expected);
		assertEquals(expected, this.creature.getPosY());
	}
	
	@Test
	public void testPlayerMinPosX(){
		try{
		new Player(-1, 9, ControllerOrder.NO);
		fail("Should return an Exception when posX < 0");
		}catch(Exception e){
			String expected = "player posX out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void testPlayerMaxPosX(){
		try{
		new Player(21, 9, ControllerOrder.NO);
		fail("Should return an Exception when posX > 20");
		}catch(Exception e){
			String expected = "player posX out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void testPlayerMinPosY(){
		try{
		new Player(4, -1, ControllerOrder.NO);
		fail("Should return an Exception when posY < 0");
		}catch(Exception e){
			String expected = "player posY out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void testPlayerMaxPosY(){
		try{
		new Player(4, 13, ControllerOrder.NO);
		fail("Should return an Exception when posY > 12");
		}catch(Exception e){
			String expected = "player posY out of range";
			assertEquals(expected, e.getMessage());
		}
	}

}
