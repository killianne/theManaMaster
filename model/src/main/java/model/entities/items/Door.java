package model.entities.items;

public class Door extends Item{

	public Door(int posX, int posY) {
		super(posX, posY);
		// TODO Auto-generated constructor stub
	}
	
	public boolean isOpen = false;
	
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
	

}
