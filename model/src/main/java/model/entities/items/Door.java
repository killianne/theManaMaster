package model.entities.items;

public class Door extends Item implements IDoor{
	
	public boolean isOpen;

	public Door(int posX, int posY,boolean door) throws Exception {
		super(posX, posY);
		if(this.getPosX() < 0 || this.getPosX() > 20)
			throw new Exception("door posX out of range");
		if(this.getPosY() < 0 || this.getPosY() > 12)
			throw new Exception("door posY out of range");
		this.isOpen=door;
	}
	
	public boolean isOpen(){
		if(isOpen == true)
			return true;
		return false;
	}
	
	public boolean isSolid(){ 
		if(isOpen)			  // Si la porte est ouverte
			return false;	  // Alors elle est traversable
		return true;		  // Sinon elle compte comme un mur
	}

	public void tick() 			  {}

	public boolean isDead() 	  { return false; }

	public int getPosX()          { return this.posX; }

	public void setPosX(int posX) { this.posX = posX; }

	public int getPosY()          { return this.posY; }

	public void setPosY(int posY) { this.posY = posY; }

	public int getWIDTH()         { return this.WIDTH; }

	public int getHEIGHT()        { return this.HEIGHT; }
	
	public void openDoor()        { isOpen = true; }
	

}
