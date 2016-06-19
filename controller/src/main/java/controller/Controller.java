package controller;



import java.util.ArrayList;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
public class Controller implements IController {

	/** The view. */
	private IView	view;

	/** The model. */
	private IModel	model;

	
	/** Map arraylist in String */
	String positionInArraylist;
	
	/** tab position in map for all entity */
	int tab[][]= new int[1][3];
	int checkItem[] =new int[6];
	
	/** Direction */ 
	ControllerOrder controllerOrder;
	/** position Player */
	int lastPlayerPositionX;
	int lastPlayerPositionY;
	int playerPositionX;
	int playerPositionY;
	
	// arraylist
	private ArrayList<String> map =new ArrayList();
	
	
	public Controller( IView view,  IModel model) {
		this.setView(view);
		this.setModel(model);
		map=this.model.loadWorld();
	}

	public void checkMapItem(){
		checkItem[0]=this.model.DemonAIsInTheWorld();
		checkItem[1]=this.model.DemonBIsInTheWorld();
		checkItem[2]=this.model.DemonCIsInTheWorld();
		checkItem[3]=this.model.DemonDIsInTheWorld();
		checkItem[4]=this.model.EnergyBubbleIsInTheWorld();
		checkItem[5]=this.model.PurseIsInTheWorld();
	}
		
	private void setView(final IView view) {
		this.view = view;
	}

	private void setModel(final IModel model) {
		this.model = model;
	}
	public void instantiateInitialMap(){
		this.view.getMapFromController(this.model.loadWorld());
		this.view.getArrayPosFromController(this.model.getPlayerPositions());
	}
	public void run(){
	
		this.memoryPos();
		this.playerMove();
		this.getCollision(playerPositionX, playerPositionY);
		this.view.getArrayPosFromController(this.getPlayerPositions());
		
	
		System.out.println(controllerOrder);
	}
	
	public void memoryPos(){
		/** memory player position*/
		playerPositionX=this.model.getPlayerPosX();
		playerPositionY=this.model.getPlayerPosY();
		lastPlayerPositionX=this.model.getPlayerPosX();
		lastPlayerPositionY=this.model.getPlayerPosY();
				
	}
	
public int[][] getPlayerPositions(){
		tab[0][0] = this.model.getPlayerPosX();
		tab[0][1] = this.model.getPlayerPosY();
		tab[0][2] = 0;
		//tab[1][0] = 13;
		//tab[1][1] = 9;
		//tab[1][2] = 1;
		return tab;
	}
	
public void getCollision(int x , int y){
	
		positionInArraylist=map.get(20*y+x);
		if(positionInArraylist.contains("b")||positionInArraylist.contains("hb")||positionInArraylist.contains("vb")){
			collision();
			System.out.println("ok");
			}
		//TODO collission	
		}

public void collision(){
	this.model.setPlayerPosX(lastPlayerPositionX);
	this.model.setPlayerPosY(lastPlayerPositionY);
}


public void playerMove() {
	
	if(controllerOrder == ControllerOrder.UL){   playerPositionY--; playerPositionX--;  }
	if(controllerOrder == ControllerOrder.UR){   playerPositionY--; playerPositionX++;  }
	if(controllerOrder == ControllerOrder.DL){   playerPositionY++; playerPositionX--;  }
	if(controllerOrder == ControllerOrder.DR){   playerPositionY++; playerPositionX++;  }
	
	if(controllerOrder == ControllerOrder.UP)    playerPositionY--;
	if(controllerOrder == ControllerOrder.DOWN)  playerPositionY++;
	if(controllerOrder == ControllerOrder.LEFT)  playerPositionX--;
	if(controllerOrder == ControllerOrder.RIGHT) playerPositionX++;
	
	this.model.setPlayerPosX(playerPositionX);
	this.model.setPlayerPosY(playerPositionY);
}

	public void orderPerform(final ControllerOrder controllerOrder) {
		this.controllerOrder=controllerOrder;
		this.run();
	}


	



	

}
