package model;

import java.util.ArrayList;
import java.util.Observable;

import contract.IModel;
import model.database.DAOWorld;
import model.worlds.World;

public class Model extends Observable implements IModel{

	protected World world  = new World();
	DAOWorld daoWorld = new DAOWorld();
	
	// Player
	/*
	Player player = new Player();
	*/
	
	// Monsters
	/*
	Monster demonA = new DemonA();
	Monster demonB = new DemonB();
	Monster demonC = new DemonC();
	Monster demonD = new DemonD();
	*/
	
	public Model(){
		for(int y=0; y<12; y++){
			for(int x=0; x<20; x++){
				System.out.print(loadWorld(1).get(x + y*20));
			}
			System.out.println("");
		}
	}
	
	public ArrayList<String> loadWorld(int id){
		return daoWorld.loadWorldById(world.getId());
	}
	
	public Observable getObservable(){
		return this; // COde bouchonn�
	}
	
	public World getWorld(){
		return world;
	}
	
	public void setWorld(World world){
		this.world = world;
	}

	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	public void loadMessage(String key) {
		// TODO Auto-generated method stub
		
	}
	
	/*
	public Player getPlayer(){
		return player;
	}
	
	public void setPlayer(Player newPlayer){
		this.player = newPlayer;
	}
	
	public void tickAll(){
		getPlayer().tick();
	}
	*/
	
}
