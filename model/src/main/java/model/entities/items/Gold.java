package model.entities.items;

public class Gold extends Item{

	public Gold(int posX, int posY) throws Exception {
		super(posX, posY);
	}

	public boolean isSolid()      { return false; }

	public void tick()            {}

	public boolean isDead() 	  { return false; }

	public int getPosX()          { return this.posX; }

	public void setPosX(int posX) { this.posX = posX; }

	public int getPosY()          { return this.posY; }

	public void setPosY(int posY) { this.posY = posY; }

	public int getWIDTH()         { return this.WIDTH; }

	public int getHEIGHT()        { return this.HEIGHT; }
	

}
