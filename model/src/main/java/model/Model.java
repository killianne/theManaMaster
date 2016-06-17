package model;

import java.util.ArrayList;
import java.util.Observable;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import model.database.DAOWorld;
import model.entities.creatures.monsters.DemonA;
import model.entities.creatures.monsters.DemonB;
import model.entities.creatures.monsters.DemonC;
import model.entities.creatures.monsters.DemonD;
import model.entities.creatures.player.Player;
import model.worlds.World;

public class Model extends Observable implements IModel{

	
	
	protected World world  = new World(1);
	DAOWorld daoWorld = new DAOWorld();
	private IController controller;
	// Player
	
	Player player = new Player(2,2, ControllerOrder.DOWN);
	DemonA demonA = new DemonA(10, 10);
	DemonB demonB = new DemonB(11, 10);
	DemonC demonC = new DemonC(10, 11);
	DemonD demonD = new DemonD(11, 11);
	
	public void test(){
		System.out.println(player.getDirection());
		System.out.println("Xplayer = " + player.getPosX());
		System.out.println("Yplayer = " + player.getPosY());
		
		System.out.println("XdemonA = " + demonA.getPosX());
		System.out.println("YdemonA = " + demonA.getPosY());
		
		this.controller.run();
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
		System.out.println(this.player.getPosX());
		
	}

	public ArrayList<String> loadWorld(){
		return daoWorld.loadWorldById(world.getId());
	}
	
	public ArrayList<String> getWorldMap(){
		return daoWorld.getWorldMap();
	}
	
	public ControllerOrder getOrderPerform(ControllerOrder controllerOrder){
		// Setting player & monsters directions
		player.setDirection(controllerOrder);
		player.tick();
		test();
		
		System.out.println(controllerOrder);
		return controllerOrder;
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
	
	
	
	public void setPlayer(Player newPlayer){
		this.player = newPlayer;
	}
	
	public Observable getObservable(){
		return this;
	}


	public int getPlayerPosX(){
		return player.getPosX();
	}
	
	public int getPlayerPosY(){
		return player.getPosY();
	}
	
	public int getDemonAPosX(){
		return demonA.getPosX();
	}
	
	public int getDemonAPosY(){
		return demonA.getPosY();
	}
	
	public int getDemonBPosX(){
		return demonB.getPosX();
	}
	
	public int getDemonBPosY(){
		return demonB.getPosY();
	}
	
	public int getDemonCPosX(){
		return demonC.getPosX();
	}
	
	public int getDemonCPosY(){
		return demonC.getPosY();
	}
	
	public int getDemonDPosX(){
		return demonD.getPosX();
	}
	
	public int getDemonDPosY(){
		return demonD.getPosY();
	}
	
	
	private int tab[][] = new int[1][3];
	public int[][] getPlayerPositions(){
		tab[0][0] = player.getPosX();
		tab[0][1] = player.getPosY();
		tab[0][2] = 0;
		return tab;
	}
	
	public int[][] getAllCreaturePosition(){
		
		
		return null;
	}


	/*
	public void tickAll(){
		getPlayer().tick();
	}
	*/
	
}
