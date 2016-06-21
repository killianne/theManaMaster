package model.entities.items;

import contract.ControllerOrder;

public class FireBall extends Item{

	ControllerOrder direction;
	
	public FireBall(int posX, int posY, ControllerOrder direction) throws Exception {
		super(posX, posY);
		if(this.getPosX() < 0 || this.getPosX() > 20)
			throw new Exception("fireBall posX out of range");
		if(this.getPosY() < 0 || this.getPosY() > 12)
			throw new Exception("fireBall posY out of range");
		this.direction = direction;
	}
	

	public boolean isSolid()      { return false; } // Go into Player and Monsters  --> KILL monsters.

	public void tick()			  { move();	}
	
	public void move(){
		if(this.direction == ControllerOrder.UL){
			this.posY--;
			this.posX--;
		}
		if(this.direction == ControllerOrder.UR){
			this.posY--;
			this.posX++;
		}
		if(this.direction == ControllerOrder.DL){
			this.posY++;
			this.posX--;
		}
		if(this.direction == ControllerOrder.DR){
			this.posY++;
			this.posX++;
		}
		
		if(this.direction == ControllerOrder.UP)
			this.posY--;
		if(this.direction == ControllerOrder.DOWN)
			this.posY++;
		if(this.direction == ControllerOrder.LEFT)
			this.posX--;
		if(this.direction == ControllerOrder.RIGHT)
			this.posX++;
	}
	
	public void moveReverse(){
		/*
		if(this.direction == ControllerOrder.UL){
			this.posY--;
			this.posX--;
		}
		if(this.direction == ControllerOrder.UR){
			this.posY--;
			this.posX++;
		}
		if(this.direction == ControllerOrder.DL){
			this.posY++;
			this.posX--;
		}
		if(this.direction == ControllerOrder.DR){
			this.posY++;
			this.posX++;
		}
		*/
		if(this.direction == ControllerOrder.UP){
			this.posY++;
			this.direction = ControllerOrder.DOWN;
		}
		else if(this.direction == ControllerOrder.DOWN){
			this.posY--;
			this.direction = ControllerOrder.UP;
		}
		else if(this.direction == ControllerOrder.LEFT){
			this.posX++;
			this.direction = ControllerOrder.RIGHT;
		}
		else if(this.direction == ControllerOrder.RIGHT){
			this.posX--;
			this.direction = ControllerOrder.LEFT;
		}
	}
	
	public void setDirection(ControllerOrder direction){
		this.direction = direction;
	}

	public boolean isDead() 	  { return false; }
	
	public ControllerOrder getDirection() { return direction; }

	public int getPosX()          { return this.posX; }

	public void setPosX(int posX) { this.posX = posX; }

	public int getPosY()          { return this.posY; }

	public void setPosY(int posY) { this.posY = posY; }

	public int getWIDTH()         { return this.WIDTH; }

	public int getHEIGHT()        { return this.HEIGHT; }

}
