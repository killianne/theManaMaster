package model.entities.creatures.monsters;

public class DemonD extends Monster{

	public DemonD(int posX, int posY) {
		super(posX, posY);
		// TODO Auto-generated constructor stub
	}

	public void tick(){
		move();
	}

	public boolean isDead() {
		
		return false;
	}
	
	public void move(){
		// Mouvements IA
	}

	public boolean hasSomethingAround() {
		// Gestion collisions
		return false;
	}

	public int getPosX() {
		return this.posX;
	}

	public void setPosX(int posX) {
		this.posX = posX;
	}

	public int getPosY() {
		return this.posY;
	}

	public void setPosY(int posY) {
		this.posY = posY;
		
	}

	public int getWIDTH() {
		return this.WIDTH;
	}

	public int getHEIGHT() {
		return this.HEIGHT;
	}
	
}
