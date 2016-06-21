package model.entities.items;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

public class EnergyBubbleTest extends ItemTest{

	@Before
	public void setUp() throws Exception {
		this.item = new EnergyBubble(10, 11);
	}
	
	@Test
	public void testGetPosX(){
		final int expected = 10;
		assertEquals(expected, this.item.getPosX());
	}
	
	@Test
	public void testGetPosY(){
		final int expected = 11;
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
	public void testEnergyBubbleMinPosX(){
		try{
			new EnergyBubble(-1, 11);
			fail("Should throw Exception when posX < 0");
		}catch(Exception e){
			final String expected = "energyBubble posX out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void testEnergyBubbleMaxPosX(){
		try{
			new EnergyBubble(21, 11);
			fail("Should throw Exception when posX > 20");
		}catch(Exception e){
			final String expected = "energyBubble posX out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void testEnergyBubbleMinPosY(){
		try{
			new EnergyBubble(10, -1);
			fail("Should throw Exception when posY < 0");
		}catch(Exception e){
			final String expected = "energyBubble posY out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void testEnergyBubbleMaxPosY(){
		try{
			new EnergyBubble(10, 13);
			fail("Should throw Exception when posY > 12");
		}catch(Exception e){
			final String expected = "energyBubble posY out of range";
			assertEquals(expected, e.getMessage());
		}
	}

}
