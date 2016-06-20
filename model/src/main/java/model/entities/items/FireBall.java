package model.entities.items;

import contract.ControllerOrder;

public class FireBall extends Item{

	ControllerOrder direction;
	
	public FireBall(int posX, int posY, ControllerOrder direction) {
		super(posX, posY);
		setDirection(direction);
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
	
	public ControllerOrder getDirection(){
		return this.direction;
	}
	
	public void setDirection(ControllerOrder direction){
		this.direction = direction;
	}

	public boolean isDead() 	  { return false; }

	public int getPosX()          { return this.posX; }

	public void setPosX(int posX) { this.posX = posX; }

	public int getPosY()          { return this.posY; }

	public void setPosY(int posY) { this.posY = posY; }

	public int getWIDTH()         { return this.WIDTH; }

	public int getHEIGHT()        { return this.HEIGHT; }

}
