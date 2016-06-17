package model.worlds;

import java.util.ArrayList;

import model.database.DAOWorld;

public class World {
	
	DAOWorld daoWorld = new DAOWorld();
	
	private int id;
  //private String name;
	
	public World(int id) {
		this.id = id;
	}
	
	public int getId() 		  { return id; }

	public void setId(int id) { this.id = id; }
	
	public ArrayList<Integer> loadPlayerPos(int id){
		return daoWorld.loadPlayerPosition(this.getId());
	}
	
	public ArrayList<Integer> loadDemonAPos(int id){
		return daoWorld.loadDemonAPosition(this.getId());
	}
	
	public ArrayList<Integer> loadDemonBPos(int id){
		return daoWorld.loadDemonBPosition(this.getId());
	}
	
	public ArrayList<Integer> loadDemonCPos(int id){
		return daoWorld.loadDemonCPosition(this.getId());
	}
	
	public ArrayList<Integer> loadDemonDPos(int id){
		return daoWorld.loadDemonCPosition(this.getId());
	}
	
	public ArrayList<Integer> loadEnergyBubblePos(int id){
		return daoWorld.loadEnergyBubblePosition(this.getId());
	}
	
	public ArrayList<Integer> loadDoorPos(int id){
		return daoWorld.loadDoorPosition(this.getId());
	}
	
	public ArrayList<Integer> loadPursePos(int id){
		return daoWorld.loadPursePosition(this.getId());
	}
	
	
	
	
	public Integer checkIfDemonAIsInTheWorld(final int id){
		return daoWorld.checkWhatMonsterIsInTheWorld(id).get(0);
	}
	public Integer checkIfDemonBIsInTheWorld(final int id){
		return daoWorld.checkWhatMonsterIsInTheWorld(id).get(1);
	}
	public Integer checkIfDemonCIsInTheWorld(final int id){
		return daoWorld.checkWhatMonsterIsInTheWorld(id).get(2);
	}
	public Integer checkIfDemonDIsInTheWorld(final int id){
		return daoWorld.checkWhatMonsterIsInTheWorld(id).get(3);
	}
	public Integer checkIfEnergyBubbleIsInTheWorld(final int id){
		return daoWorld.checkWhatMonsterIsInTheWorld(id).get(4);
	}
	public Integer checkIfPurseIsInTheWorld(final int id){
		return daoWorld.checkWhatMonsterIsInTheWorld(id).get(5);
	}
	
	
	// GETTERS AND SETTERS
	
	

	/*
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	*/
	
}
