package model.entities.items;

import model.entities.Entity;

public abstract class Item extends Entity implements ITypeItem{

	public Item(int posX, int posY) {
		super(posX, posY);
	}

}
