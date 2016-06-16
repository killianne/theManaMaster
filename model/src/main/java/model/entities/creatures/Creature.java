package model.entities.creatures;

import model.entities.Entity;

public abstract class Creature extends Entity implements IMove, ICollision{

	ICreature creature;
	
	protected int health, xMove, yMove;
	
	protected float speed = 2.0f;
	
	public Creature(int posX, int posY) {
		super(posX, posY);
		initMovePosition();
	}
	
	public void initMovePosition(){
		xMove = 0;
		yMove = 0;
	}

	public int getHealth() {
		return health;
	}

	public void setHealth(int health) {
		this.health = health;
	}

	public int getxMove() {
		return xMove;
	}

	public void setxMove(int xMove) {
		this.xMove = xMove;
	}

	public int getyMove() {
		return yMove;
	}

	public void setyMove(int yMove) {
		this.yMove = yMove;
	}

	public float getSpeed() {
		return speed;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}	

}
