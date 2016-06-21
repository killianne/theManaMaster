package model.entities.items;

import org.junit.Before;

public class DoorTest extends ItemTest{

	@Before
	public void setUp() throws Exception {
		this.item = new Door(19, 8, false);
	}
	
}
