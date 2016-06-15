package model.worlds;

public class World {
	
	private int id;
  //private String name;

	public World() {
		this.setId(1);
	}
	
	public World(int id) {
		this.setId(id);
	}
	
	/*
	public World(String name){
		daoWorld.loadWorldByName(name);
	}
	*/
	
	// GETTERS AND SETTERS
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	/*
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	*/
	
}
