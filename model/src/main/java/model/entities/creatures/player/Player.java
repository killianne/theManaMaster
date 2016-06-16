package model.entities.creatures.player;

import contract.ControllerOrder;
import model.Model;
import model.entities.creatures.Creature;
import model.entities.items.FireBall;

public class Player extends Creature{

	FireBall fireBall;
	Model model;
	ControllerOrder direction;
	
	public Player(int posX, int posY, ControllerOrder direction) {
		super(posX, posY);
		fireBall = new FireBall(posX, posY, direction);
		
		this.direction = direction;
		// TODO Auto-generated constructor stub
	}

	public FireBall getFireBall() {
		return fireBall;
	}

	public void setFireBall(FireBall fireBall) {
		this.fireBall = fireBall;
	}

	public ControllerOrder getDirection() {
		return direction;
	}

	public void setDirection(ControllerOrder direction) {
		this.direction = model.getOrderPerform(direction);
	}

	public void move() {
		// TODO Auto-generated method stub
	}

	public void tick() {
		// TODO Auto-generated method stub
		
	}

	public boolean isDead() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean hasSomethingAround() {
		// TODO Auto-generated method stub
		return false;
	}



	
	
}
