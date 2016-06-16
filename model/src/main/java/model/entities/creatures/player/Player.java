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
	}
	
	public Creature getPlayer(){
		return this;
	}
	
	public FireBall getFireBall() {
		return fireBall;
	}

	public void setFireBall(FireBall fireBall) {
		this.fireBall = fireBall;
	}

	public ControllerOrder getDirection() {
		return this.direction;
	}

	public void setDirection(ControllerOrder direction) {
		this.direction = direction;
	}

	public void move() {
		if(direction == ControllerOrder.UP)    posY--;
		if(direction == ControllerOrder.DOWN)  posY++;
		if(direction == ControllerOrder.LEFT)  posX--;
		if(direction == ControllerOrder.RIGHT) posX++;
		
		if(direction == ControllerOrder.UL){   posY--; posX--;  }
		if(direction == ControllerOrder.UR){   posY--; posX++;  }
		if(direction == ControllerOrder.DL){   posY++; posX--;  }
		if(direction == ControllerOrder.DR){   posY++; posX++;  }
	}

	public void tick() {
		move();
	}
	
	public void shoot(){
		fireBall = new FireBall(posX, posY, this.direction);
		System.out.println("FireBall direction");
	}
	
	public boolean isDead() {
		return false;
	}

	public boolean hasSomethingAround() {
		// TODO Auto-generated method stub
		return false;
	}

	public int getPosX() {
		return this.posX;
	}

	public void setPosX(int posX) {
		// TODO Auto-generated method stub
		
	}

	public int getPosY() {
		return this.posY;
	}

	public void setPosY(int posY) {
	}

	public int getWIDTH() {
		return 0;
	}

	public int getHEIGHT() {
		return 0;
	}



	
	
}
