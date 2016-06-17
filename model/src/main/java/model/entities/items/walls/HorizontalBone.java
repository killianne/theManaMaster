package model.entities.items.walls;

public class HorizontalBone extends Wall{

	public HorizontalBone(int posX, int posY) {
		super(posX, posY);
	}

	public boolean isSolid()      { return true; }

	public void tick() 			  {}

	public boolean isDead()       { return false; }

	public int getPosX()          { return this.posX; }

	public void setPosX(int posX) { this.posX = posX; }

	public int getPosY()          { return this.posY; }

	public void setPosY(int posY) { this.posY = posY; }

	public int getWIDTH()         { return this.WIDTH; }

	public int getHEIGHT()        { return this.HEIGHT; }

}
