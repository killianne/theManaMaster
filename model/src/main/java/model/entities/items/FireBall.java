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

	public int getPosX() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setPosX(int posX) {
		// TODO Auto-generated method stub
		
	}

	public int getPosY() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setPosY(int posY) {
		// TODO Auto-generated method stub
		
	}

	public int getWIDTH() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getHEIGHT() {
		// TODO Auto-generated method stub
		return 0;
	}

}
