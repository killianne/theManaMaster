package model.entities.items;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import contract.ControllerOrder;

public class GoldTest extends ItemTest{

	@Before
	public void setUp() throws Exception {
		this.item = new Gold(12,4);
	}
	
	@Test
	public void testGetPosX(){
		final int expected = 12;
		assertEquals(expected, this.item.getPosX());
	}
	
	@Test
	public void testGetPosY(){
		final int expected = 4;
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
		boolean expected = false;
		assertEquals(expected, this.item.isSolid());
	}
	
	@Test
	public void testGoldMinPosX(){
		try{
			new Gold(-1, 4);
			fail("Should throw Exception when posX < 0");
		}catch(Exception e){
			final String expected = "gold posX out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void testGoldMaxPosX(){
		try{
			new Gold(21, 4);
			fail("Should throw Exception when posX > 20");
		}catch(Exception e){
			final String expected = "gold posX out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void testGoldMinPosY(){
		try{
			new Gold(12, -1);
			fail("Should throw Exception when posY < 0");
		}catch(Exception e){
			final String expected = "gold posY out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void testGoldMaxPosY(){
		try{
			new Gold(12, 13);
			fail("Should throw Exception when posY > 12");
		}catch(Exception e){
			final String expected = "gold posY out of range";
			assertEquals(expected, e.getMessage());
		}
	}

}
