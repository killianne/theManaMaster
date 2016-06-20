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
import model.entities.creatures.player.Player;
import model.entities.items.Door;
import model.entities.items.EnergyBubble;
import model.entities.items.Gold;
import model.worlds.World;

public class Model extends Observable implements IModel{

	
	
	protected World world  = new World(1);
	DAOWorld daoWorld = new DAOWorld();
	private IController controller;

	Player player = new Player(0,0, ControllerOrder.NO);
	
	private ArrayList<Entity> alEntity;
	
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
		for(int i=0;i<daoWorld.loadDoorPosition(world.getId()).size()/2;i+=2){
			alEntity.add(new Door(daoWorld.loadDoorPosition(world.getId()).get(i)-1,daoWorld.loadDoorPosition(world.getId()).get(i+1)-1,daoWorld.loadDoorPosition(world.getId()).get(i+2)==1));
		}
		
		//instantiation of the personage in function the Database
		player.setPosX(daoWorld.loadPlayerPosition(world.getId()).get(0)-1);
		player.setPosY(daoWorld.loadPlayerPosition(world.getId()).get(1)-1);
	}
	
	public int[][] arrayPos(){
		int[][] array = new int[alEntity.size()+1][4];
		
		array[0][0] = this.getPlayerPosX();
		array[0][1] = this.getPlayerPosY();
		array[0][2] = 0;
		//array[x][0] = X; array[x][1] = Y; array[x][2] = ID entity in array in view; array[x][3] = ID entity in ArrayList ; 
		for(int i=0; i<alEntity.size(); i++){
			//i + 1 because there is the player in the array but not in the ArrayList
			if(alEntity.get(i) instanceof DemonA) {
				array[i+1][0] = alEntity.get(i).getPosX();
				array[i+1][1] = alEntity.get(i).getPosY();
				array[i+1][2] = 1;
				array[i+1][3] = i+1;
			}
			if(alEntity.get(i) instanceof DemonB) {
				array[i+1][0] = alEntity.get(i).getPosX();
				array[i+1][1] = alEntity.get(i).getPosY();
				array[i+1][2] = 2;
				array[i+1][3] = i+1;
			}
			if(alEntity.get(i) instanceof DemonC) {
				array[i+1][0] = alEntity.get(i).getPosX();
				array[i+1][1] = alEntity.get(i).getPosY();
				array[i+1][2] = 3;
				array[i+1][3] = i+1;
			}
			if(alEntity.get(i) instanceof DemonD) {
				array[i+1][0] = alEntity.get(i).getPosX();
				array[i+1][1] = alEntity.get(i).getPosY();
				array[i+1][2] = 4;
				array[i+1][3] = i+1;
			}
			if(alEntity.get(i) instanceof EnergyBubble) {
				array[i+1][0] = alEntity.get(i).getPosX();
				array[i+1][1] = alEntity.get(i).getPosY();
				array[i+1][2] = 5;
				array[i+1][3] = i+1;
			}
			if(alEntity.get(i) instanceof Gold) {
				array[i+1][0] = alEntity.get(i).getPosX();
				array[i+1][1] = alEntity.get(i).getPosY();
				array[i+1][2] = 6;
				array[i+1][3] = i+1;
			}
			
			if(alEntity.get(i) instanceof Door) {
				array[i+1][0] = alEntity.get(i).getPosX();
				array[i+1][1] = alEntity.get(i).getPosY();
				Door door = (Door) alEntity.get(i);
				boolean isOpen = door.isOpen();
				if(isOpen){
					array[i+1][2] = 7;
				}
				else{
					array[i+1][2] = 8;
				}
				array[i+1][3] = i+1;
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
	
	public boolean shootFireBall(){
		return player.shootFireBall();
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
	}

	public ArrayList<String> getWorldForController(){
		return daoWorld.loadWorldById(world.getId());
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
	
	
	public int[][] getDemonAPos(){ //methode a optimiser
		int counter=0;
		for(int i=0;i<alEntity.size();i++ ){
			if(alEntity.get(i) instanceof DemonA ){
				counter++;
			}
		}
		int[][] arrayDem = new int[counter][3];
		for(int i=0;i<alEntity.size();i++ ){
			if(alEntity.get(i) instanceof DemonA ){
				arrayDem[i][0]=alEntity.get(i).getPosX();
				arrayDem[i][1]=alEntity.get(i).getPosY();
				arrayDem[i][2]=i;
			}
		}
		if(counter==0)
			return null;
		return arrayDem;
	}
	public int[][] getDemonBPos(){
		int counter=0;
		for(int i=0;i<alEntity.size();i++ ){
			if(alEntity.get(i) instanceof DemonB ){
				counter++;
			}
		}
		int[][] arrayDem = new int[counter][3];
		for(int i=0;i<alEntity.size();i++ ){
			if(alEntity.get(i) instanceof DemonB ){
				arrayDem[i][0]=alEntity.get(i).getPosX();
				arrayDem[i][1]=alEntity.get(i).getPosY();
				arrayDem[i][2]=i;
			}
		}
		if(counter==0)
			return null;
		return arrayDem;
	}
	public int[][] getDemonCPos(){
		int counter=0;
		for(int i=0;i<alEntity.size();i++ ){
			if(alEntity.get(i) instanceof DemonC ){
				counter++;
			}
		}
		int[][] arrayDem = new int[counter][3];
		for(int i=0;i<alEntity.size();i++ ){
			if(alEntity.get(i) instanceof DemonC ){
				arrayDem[i][0]=alEntity.get(i).getPosX();
				arrayDem[i][1]=alEntity.get(i).getPosY();
				arrayDem[i][2]=i;
			}
		}
		if(counter==0)
			return null;
		return arrayDem;
	}
	public int[][] getDemonDPos(){
		int counter=0;
		for(int i=0;i<alEntity.size();i++ ){
			if(alEntity.get(i) instanceof DemonD ){
				counter++;
			}
		}
		int[][] arrayDem = new int[counter][3];
		for(int i=0;i<alEntity.size();i++ ){
			if(alEntity.get(i) instanceof DemonD ){
				arrayDem[i][0]=alEntity.get(i).getPosX();
				arrayDem[i][1]=alEntity.get(i).getPosY();
				arrayDem[i][2]=i;
			}
		}
		if(counter==0)
			return null;
		return arrayDem;
	}	
	public void setDemonAPos(ControllerOrder controllerOrder,int id){
		System.out.println("x debut : " + alEntity.get(id).getPosX() + " | y debut : " + alEntity.get(id).getPosY());
		switch(controllerOrder){
			case RIGHT:
				alEntity.get(id).setPosX(alEntity.get(id).getPosX() + 1);
				break;
			case LEFT:
				alEntity.get(id).setPosX(alEntity.get(id).getPosX() - 1);
				break;
			case UP:
				alEntity.get(id).setPosY(alEntity.get(id).getPosY() - 1);
				break;
			case DOWN:
				alEntity.get(id).setPosY(alEntity.get(id).getPosY() + 1);
				break;
		}
		System.out.println("x fin : " + alEntity.get(id).getPosX() + " | y fin : " + alEntity.get(id).getPosY());
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
