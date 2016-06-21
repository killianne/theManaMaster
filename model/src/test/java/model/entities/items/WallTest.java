package model.entities.items;

import org.junit.Before;

public class WallTest extends ItemTest{

	@Before
	public void setUp() throws Exception {
		this.item = new Wall(1, 1);
	}

}
