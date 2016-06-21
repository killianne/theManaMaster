package model.entities.items;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import contract.ControllerOrder;

public class FireBallTest extends ItemTest{

	FireBall fireBall;
	
	@Before
	public void setUp() throws Exception {
		this.item = new FireBall(5,5,ControllerOrder.NO);
	}
	
	@Test
	public void testGetPosX(){
		final int expected = 5;
		assertEquals(expected, this.item.getPosX());
	}
	
	@Test
	public void testGetPosY(){
		final int expected = 5;
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
	public void testFireBallMinPosX(){
		try{
			new FireBall(-1, 5, ControllerOrder.NO);
			fail("Should throw Exception when posX < 0");
		}catch(Exception e){
			final String expected = "fireBall posX out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void testFireBallMaxPosX(){
		try{
			new FireBall(21, 5, ControllerOrder.NO);
			fail("Should throw Exception when posX > 20");
		}catch(Exception e){
			final String expected = "fireBall posX out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void testFireBallMinPosY(){
		try{
			new FireBall(5, -1, ControllerOrder.NO);
			fail("Should throw Exception when posY < 0");
		}catch(Exception e){
			final String expected = "fireBall posY out of range";
			assertEquals(expected, e.getMessage());
		}
	}
	
	@Test
	public void testFireBallMaxPosY(){
		try{
			new FireBall(5, 13, ControllerOrder.NO);
			fail("Should throw Exception when posY > 12");
		}catch(Exception e){
			final String expected = "fireBall posY out of range";
			assertEquals(expected, e.getMessage());
		}
	}

}
