package model.entities;

public abstract class Entity implements ITick{

	ITick ticks;

	protected int posX, posY;
	
	protected final int WIDTH = 32, HEIGHT = 32;
	
	public Entity(int posX, int posY){
		this.posX = posX;
		this.posY = posY;
	}

	public int getPosX() {
		return posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}
	
}
