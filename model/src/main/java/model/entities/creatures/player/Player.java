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
	
	public FireBall getFireBall() 						{ return fireBall; }

	public void setFireBall(FireBall fireBall) 			{ this.fireBall = fireBall; }
	
	public boolean isFireBallNull()                     { return fireBall == null; }
	
	public boolean shootFireBall(){
		if(isFireBallNull()){
			switch(direction){
				case UP :
					fireBall = new FireBall(posX,posY,ControllerOrder.DOWN);
					break;
				case DOWN :
					fireBall = new FireBall(posX,posY,ControllerOrder.UP);
					break;
				case RIGHT :
					fireBall = new FireBall(posX,posY,ControllerOrder.LEFT);
					break;
				case LEFT :
					fireBall = new FireBall(posX,posY,ControllerOrder.RIGHT);
					break;
			}
			return true;
		}
		return false;
	}

	public ControllerOrder getDirection() 				{ return this.direction; }

	public void setDirection(ControllerOrder direction) { this.direction = direction; }

	public void move() {
		
		if(direction == ControllerOrder.UL){   posY--; posX--;  }
		if(direction == ControllerOrder.UR){   posY--; posX++;  }
		if(direction == ControllerOrder.DL){   posY++; posX--;  }
		if(direction == ControllerOrder.DR){   posY++; posX++;  }
		
		if(direction == ControllerOrder.UP)    posY--;
		if(direction == ControllerOrder.DOWN)  posY++;
		if(direction == ControllerOrder.LEFT)  posX--;
		if(direction == ControllerOrder.RIGHT) posX++;
		
	}

	public void tick() { move(); }
	
	public void shoot(){
		fireBall = new FireBall(posX, posY, this.direction);
		System.out.println("FireBall direction" + this.direction);
	}
	
	public boolean isDead() {
		if(this.getHealth() > 0)
			return false;
		return true;
	}

	public boolean hasSomethingAround() {
		// Gestion des collisions
		return false;
	}

	public int getPosX()          { return this.posX; }

	public void setPosX(int posX) { this.posX = posX; }

	public int getPosY()          { return this.posY; }

	public void setPosY(int posY) { this.posY = posY; }

	public int getWIDTH()         { return this.WIDTH; }

	public int getHEIGHT()        { return this.HEIGHT; }	
	
}
