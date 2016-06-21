package model.entities.items;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class DoorTest extends ItemTest{
	
	@Before
	public void setUp() throws Exception {
		this.item = new Door(19, 8, false);
	}
	
	@Test
	public void testGetPosX(){
		final int expected = 19;
		assertEquals(expected, this.item.getPosX());
	}
	
	@Test
	public void testGetPosY(){
		final int expected = 8;
		assertEquals(expected, this.item.getPosY());
	}
	
	@Test
	public void testSetPosX(){
		int expected = 10;
		this.item.setPosX(expected);
		assertEquals(expected, this.item.getPosX());
	}
	
	@Test
	public void testSetPosY(){
		int expected = 10;
		this.item.setPosY(expected);
		assertEquals(expected, this.item.getPosY());
	}
	
	@Test
	public void testIsDead(){
		boolean expected = false;
		assertEquals(expected, this.item.isDead());
	}
	
	@Test
	public void testIsSolid(){
		boolean expected = true;
		assertEquals(expected, this.item.isSolid());
	}
	
	@Test
	public void testDoorMinPosX(){
		try{
			new Door(-1, 8, false);
			fail("Should throw Exception when posX < 0");
		}catch(Exception e){
			final String expected = "door posX out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void testDoorMaxPosX(){
		try{
			new Door(21, 8, false);
			fail("Should throw Exception when posX > 20");
		}catch(Exception e){
			final String expected = "door posX out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void testDoorMinPosY(){
		try{
			new Door(19, -1, false);
			fail("Should throw Exception when posY < 0");
		}catch(Exception e){
			final String expected = "door posY out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void testDoorMaxPosY(){
		try{
			new Door(19, 13, false);
			fail("Should throw Exception when posY < 0");
		}catch(Exception e){
			final String expected = "door posY out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	
	
	
}
