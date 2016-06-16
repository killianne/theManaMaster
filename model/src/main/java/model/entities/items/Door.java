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
		if(isOpen)
			return false;
		return true;
	}

	public void tick() {
		
	}

	public boolean isDead() {
		return false;
	}

	public int getPosX() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setPosX(int posX) {
		// TODO Auto-generated method stub
		
	}

	public int getPosY() {
		// TODO Auto-generated method stub
		return 0;
	}

	public void setPosY(int posY) {
		// TODO Auto-generated method stub
		
	}

	public int getWIDTH() {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getHEIGHT() {
		// TODO Auto-generated method stub
		return 0;
	}

}
