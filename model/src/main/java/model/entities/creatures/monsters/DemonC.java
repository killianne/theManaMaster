package model.entities.creatures.monsters;

public class DemonC extends Monster{

	public DemonC(int posX, int posY) throws Exception {
		super(posX, posY);
		if(this.getPosX() < 0 || this.getPosX() > 20)
			throw new Exception("demonC posX out of range");
		if(this.getPosY() < 0 || this.getPosY() > 12)
			throw new Exception("demonC posY out of range");
	}

	public void tick()		{ move(); }

	public boolean isDead() { return false; }
	
	public void move(){
		// Mouvements IA
	}

	public boolean hasSomethingAround() {
		// Gestion collisions
		return false;
	}

	public int getPosX()          { return this.posX; }

	public void setPosX(int posX) { this.posX = posX; }

	public int getPosY()          { return this.posY; }

	public void setPosY(int posY) { this.posY = posY; }

	public int getWIDTH()         { return this.WIDTH; }

	public int getHEIGHT()        { return this.HEIGHT; }
	
	
}
