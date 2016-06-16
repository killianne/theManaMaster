package model.entities.items;

import contract.ControllerOrder;

public class FireBall extends Item{

	public FireBall(int posX, int posY, ControllerOrder direction) {
		super(posX, posY);
		// TODO Auto-generated constructor stub
	}

	public boolean isSolid() {
		return true;
		
	}

	public void tick() {
		// TODO Auto-generated method stub
		
	}

	public boolean isDead() {
		return false;
	}
	
	public void hasSomethingAround(){
		
	}

}
