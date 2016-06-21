package model.entities.items;

import org.junit.Before;

import contract.ControllerOrder;

public class FireBallTest extends ItemTest{

	@Before
	public void setUp() throws Exception {
		this.item = new FireBall(5,5,ControllerOrder.NO);
	}

}
