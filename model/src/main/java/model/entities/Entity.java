package model.entities;

import model.entities.items.IDoor;

public abstract class Entity implements ITick, IPosition{

	protected int posX, posY;
	
	protected final int WIDTH = 32, HEIGHT = 32;
	
	public Entity(int posX, int posY){
		this.posX = posX;
		this.posY = posY;
	}
	
}
