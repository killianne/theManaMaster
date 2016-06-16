package model;

import java.util.ArrayList;
import java.util.Observable;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import model.database.DAOWorld;
import model.entities.creatures.player.Player;
import model.worlds.World;

public class Model extends Observable implements IModel{

	protected World world  = new World(2);
	DAOWorld daoWorld = new DAOWorld();
	private IController controller;
	// Player
	
	Player player = new Player(2,2, ControllerOrder.DOWN);
	public void test(){
		
		System.out.println(player.getDirection());
		System.out.println("Xplayer = " + player.getPosX());
		System.out.println("Yplayer = " + player.getPosY());
	}
	
	
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
				System.out.print(loadWorld().get(x + y*20));
			}
			System.out.println("");
		}
		
	}
	/*
	public void run(){
		test();
	}
	*/
	public ArrayList<String> loadWorld(){
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
	
	public IController getController(){
		return controller;
	}
	
	public void setController(IController controller){
		this.controller = controller;
	}
	
	public ControllerOrder getOrderPerform(ControllerOrder controllerOrder){
		// Setting player & monsters directions
		player.setDirection(controllerOrder);
		player.tick();
		test();
		
		System.out.println(controllerOrder);
		return controllerOrder;
	}

	public String getMessage() {
		// TODO Auto-generated method stub
		return null;
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
