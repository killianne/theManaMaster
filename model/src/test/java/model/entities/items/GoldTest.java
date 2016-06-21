package model.entities.items;

import org.junit.Before;

public class GoldTest extends ItemTest{

	@Before
	public void setUp() throws Exception {
		this.item = new Gold(12,4);
	}

}
