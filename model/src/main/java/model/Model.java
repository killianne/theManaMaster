package model;

import java.util.ArrayList;
import java.util.Observable;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import model.database.DAOWorld;
import model.entities.Entity;
import model.entities.creatures.monsters.DemonA;
import model.entities.creatures.monsters.DemonB;
import model.entities.creatures.monsters.DemonC;
import model.entities.creatures.monsters.DemonD;
import model.entities.creatures.monsters.Monster;
import model.entities.creatures.player.Player;
import model.entities.items.EnergyBubble;
import model.entities.items.Gold;
import model.worlds.World;

public class Model extends Observable implements IModel{

	
	
	protected World world  = new World(1);
	DAOWorld daoWorld = new DAOWorld();
	private IController controller;
	// Player
	private ArrayList<Integer> DemonAPosBegin=daoWorld.loadDemonAPosition(world.getId());
//	DemonAPosBegin=daoWorld.loadDemonAposition(world.getID());
	Player player = new Player(2,2, ControllerOrder.DOWN);
	DemonA demonA = new DemonA(daoWorld.loadDemonAPosition(world.getId()).get(0),daoWorld.loadDemonAPosition(world.getId()).get(1));
	DemonB demonB = new DemonB(daoWorld.loadDemonBPosition(world.getId()).get(0),daoWorld.loadDemonBPosition(world.getId()).get(1));
	DemonC demonC = new DemonC(daoWorld.loadDemonCPosition(world.getId()).get(0),daoWorld.loadDemonCPosition(world.getId()).get(1));
	DemonD demonD = new DemonD(10,10);
	private ArrayList<Entity> alEntity;
	ArrayList<String> Map =new ArrayList();
	
	public int lastPlayerX;
	public int lastPlayerY;
	
	public void instantiateMonsters(){
		this.alEntity = new ArrayList<Entity>();
		for(int i=0;i<daoWorld.loadDemonAPosition(world.getId()).size()/2;i+=2){
			System.out.println(daoWorld.loadDemonAPosition(world.getId()).get(i+1));
			alEntity.add(new DemonA(daoWorld.loadDemonAPosition(world.getId()).get(i)-1,daoWorld.loadDemonAPosition(world.getId()).get(i+1)-1));
		}
		for(int i=0;i<daoWorld.loadDemonBPosition(world.getId()).size()/2;i+=2){
			alEntity.add(new DemonB(daoWorld.loadDemonBPosition(world.getId()).get(i)-1,daoWorld.loadDemonBPosition(world.getId()).get(i+1)-1));
		}
		for(int i=0;i<daoWorld.loadDemonCPosition(world.getId()).size()/2;i+=2){
			alEntity.add(new DemonC(daoWorld.loadDemonCPosition(world.getId()).get(i)-1,daoWorld.loadDemonCPosition(world.getId()).get(i+1)-1));
		}
		for(int i=0;i<daoWorld.loadDemonDPosition(world.getId()).size()/2;i+=2){
			alEntity.add(new DemonD(daoWorld.loadDemonDPosition(world.getId()).get(i)-1,daoWorld.loadDemonDPosition(world.getId()).get(i+1)-1));
		}
		for(int i=0;i<daoWorld.loadEnergyBubblePosition(world.getId()).size()/2;i+=2){
			alEntity.add(new EnergyBubble(daoWorld.loadEnergyBubblePosition(world.getId()).get(i)-1,daoWorld.loadEnergyBubblePosition(world.getId()).get(i+1)-1));
		}
		for(int i=0;i<daoWorld.loadPursePosition(world.getId()).size()/2;i+=2){
			alEntity.add(new Gold(daoWorld.loadPursePosition(world.getId()).get(i)-1,daoWorld.loadPursePosition(world.getId()).get(i+1)-1));
		}
		
		//instantiation of the personage in function the Database
		player.setPosX(daoWorld.loadPlayerPosition(world.getId()).get(0)-1);
		player.setPosY(daoWorld.loadPlayerPosition(world.getId()).get(1)-1);
	}
	
	public int[][] arrayPos(){
		int[][] array = new int[alEntity.size()+1][3];
		
		array[0][0] = this.getPlayerPosX();
		array[0][1] = this.getPlayerPosY();
		array[0][2] = 0;
		
		for(int i=0; i<alEntity.size(); i++){
			if(alEntity.get(i) instanceof DemonA) {
				System.out.println("A");
				array[i+1][0] = alEntity.get(i).getPosX();
				array[i+1][1] = alEntity.get(i).getPosY();
				array[i+1][2] = 1;
			}
			if(alEntity.get(i) instanceof DemonB) {
				System.out.println("B");
				array[i+1][0] = alEntity.get(i).getPosX();
				array[i+1][1] = alEntity.get(i).getPosY();
				array[i+1][2] = 2;
			}
			if(alEntity.get(i) instanceof DemonC) {
				System.out.println("C");
				array[i+1][0] = alEntity.get(i).getPosX();
				array[i+1][1] = alEntity.get(i).getPosY();
				array[i+1][2] = 3;
			}
			if(alEntity.get(i) instanceof DemonD) {
				System.out.println("D");
				array[i+1][0] = alEntity.get(i).getPosX();
				array[i+1][1] = alEntity.get(i).getPosY();
				array[i+1][2] = 4;
			}
			if(alEntity.get(i) instanceof EnergyBubble) {
				System.out.println("EnergyBubble");
				array[i+1][0] = alEntity.get(i).getPosX();
				array[i+1][1] = alEntity.get(i).getPosY();
				array[i+1][2] = 5;
			}
			if(alEntity.get(i) instanceof Gold) {
				System.out.println("Purse");
				array[i+1][0] = alEntity.get(i).getPosX();
				array[i+1][1] = alEntity.get(i).getPosY();
				array[i+1][2] = 6;
			}
		}
		for(int i=0; i<array.length; i++){
			for(int j=0; j<array[0].length; j++){
				System.out.print(array[i][j] + "-");
			}
			System.out.println();
		}
		return array;
	}
	
	
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

	public ArrayList<String> getWorldForController(){
		Map=daoWorld.loadWorldById(world.getId());
		return daoWorld.loadWorldById(world.getId());
	}
	
	public ControllerOrder getOrderPerform(ControllerOrder controllerOrder){
		// Setting player & monsters directions
		lastPlayerX=player.getPosX();
		lastPlayerY=player.getPosY();
		player.setDirection(controllerOrder);
		player.tick();
		
		if(getChock(player.getPosX(),player.getPosY())==true){
			
			collision();
		}
		System.out.println("collision or not:"+getChock(player.getPosX(),player.getPosY()));
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
	public void setPlayerPosX(int x){
		  player.setPosX(x);
	}
	
	public void setPlayerPosY(int y){
		 player.setPosY(y);
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
	
	
	public void collision(){
		player.setPosX(lastPlayerX);
		player.setPosY(lastPlayerY);
	}
	
	public boolean getChock(int x, int y){

		if(Map.get((20*(y)+x)).contains("b")||Map.get((20*(y)+x)).contains("hb")||Map.get((20*(y)+x)).contains("vb")){
			return true;
			}
		//TODO collission
			return false;
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
