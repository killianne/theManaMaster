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
		
		System.out.println("Player's pos = " + getDemonAPosition().get(0));
		System.out.println("Player's pos = " + getDemonAPosition().get(1));
		
		System.out.println("DEMON A ? = " + DemonAIsInTheWorld());
		System.out.println("DEMON D ? = " + DemonDIsInTheWorld());
		this.controller.run();
	}
	
	
	// Monsters
	/*
	Monster demonA = new DemonA();
	Monster demonB = new DemonB();
	Monster demonC = new DemonC();
	Monster demonD = new DemonD();
	*/
	
	
	public void arrayToTab(){
		
	}
	
	public ArrayList<Integer> getPlayerPosition(){
		return world.loadPlayerPos(world.getId());
	}
	
	public ArrayList<Integer> getDemonAPosition(){
		if(DemonAIsInTheWorld() == 1)
			return world.loadDemonAPos(world.getId());
		return null;
	}
	//Chargement DemonB
	public ArrayList<Integer> getDemonBPosition(){
		if(DemonBIsInTheWorld() == 1)
			return world.loadDemonBPos(world.getId());
		return null;
	}
	
	public ArrayList<Integer> getDemonCPosition(){
		if(DemonCIsInTheWorld() == 1)
			return world.loadDemonCPos(world.getId());
		return null;
	}
	
	public ArrayList<Integer> getDemonDPosition(){
		if(DemonDIsInTheWorld() == 1)
			return world.loadDemonDPos(world.getId());
		return null;
	}
	
	public ArrayList<Integer> getEnergyBubblePosition(){
		if(EnergyBubbleIsInTheWorld() == 1)
			return world.loadEnergyBubblePos(world.getId());
		return null;
	}
	
	public ArrayList<Integer> getDoorPosition(){
		return world.loadDoorPos(world.getId());
	}
	
	public ArrayList<Integer> getPursePosition(){
		if(PurseIsInTheWorld() == 1)
			return world.loadPursePos(world.getId());
		return null;
	}
	
	// TEST WHAT DEMONS ARE IN THE WORLD
	
	public Integer DemonAIsInTheWorld(){
		return world.checkIfDemonAIsInTheWorld(world.getId());
	}
	
	public Integer DemonBIsInTheWorld(){
		return world.checkIfDemonBIsInTheWorld(world.getId());
	}
	
	public Integer DemonCIsInTheWorld(){
		return world.checkIfDemonCIsInTheWorld(world.getId());
	}

	public Integer DemonDIsInTheWorld(){
		return world.checkIfDemonDIsInTheWorld(world.getId());
	}

	public Integer EnergyBubbleIsInTheWorld(){
		return world.checkIfEnergyBubbleIsInTheWorld(world.getId());
	}
	
	public Integer PurseIsInTheWorld(){
		return world.checkIfPurseIsInTheWorld(world.getId());
	}
	
	public Model(){
		
		
	/*
		for(int y=0; y<12; y++){
			for(int x=0; x<20; x++){
				System.out.print(loadWorld().get(x + y*20));
			}
			System.out.println("");
		}
		System.out.println(this.player.getPosX());
	*/
	}

	public ArrayList<String> loadWorld(){
		return daoWorld.loadWorldById(world.getId());
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
	
	
	private int tab[] = new int[2];
	public int[] getPlayerPositions(){
		tab[0] = player.getPosX();
		tab[1] = player.getPosY();
		System.out.println("yo");
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
