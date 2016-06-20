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
	private ArrayList<String> map = new ArrayList<String>();
	
	
	public Controller( IView view,  IModel model) {
		this.setView(view);
		this.setModel(model);
		map=this.model.getWorldForController();
	}
	
	private void setView(final IView view) {
		this.view = view;
	}

	private void setModel(final IModel model) {
		this.model = model;
	}
	
	public void instantiateInitialMap(){
		this.view.getMapFromController(this.model.getWorldForController());
		this.model.instantiateMonsters();
		this.view.getArrayPosFromController(this.getPos());
	}
	
	public void run(){
	
		this.memoryPos();
		this.playerMove();
		this.getCollision(playerPositionX, playerPositionY);
		
		monsterIaTypeA();
		
		this.view.getArrayPosFromController(this.getPos());
	
		System.out.println(controllerOrder);
	}
	
	public void memoryPos(){
		/** memory player position*/
		playerPositionX=this.model.getPlayerPosX();
		playerPositionY=this.model.getPlayerPosY();
		lastPlayerPositionX=this.model.getPlayerPosX();
		lastPlayerPositionY=this.model.getPlayerPosY();
		}
	
	public int[][] getPos(){
		return model.arrayPos();
	}

	public boolean getCollisionMonster(int x, int y){
		int xColis, yColis;
		xColis=x;yColis=y;
		positionInArraylist=map.get(20*yColis+xColis);
		System.out.println("Position Monster : "+positionInArraylist);
		if(positionInArraylist.contains("b")||positionInArraylist.contains("hb")||positionInArraylist.contains("vb")){
			System.out.println("Monster Collision ");
			return true;
		}
		
		
		
		return false;	
	}
	
	public void monsterIaTypeA(){
		ControllerOrder controllerOrder = ControllerOrder.NO;
		int random;
		int[][] arreyMonsterA = this.model.getDemonAPos();
		for(int i=0; i<arreyMonsterA.length; i++){
			random = (int) (Math.random() * 4);
			System.out.println(random);
			
			switch(random){
			case 0:
				controllerOrder = ControllerOrder.UP;
				break;
			case 1:
				controllerOrder = ControllerOrder.DOWN;
				break;
			case 2:
				controllerOrder = ControllerOrder.RIGHT;
				break;
			case 3:
				controllerOrder = ControllerOrder.LEFT;
				break;
			}
			
		
			this.model.setDemonAPos(controllerOrder,arreyMonsterA[i][2]);
			arreyMonsterA = this.model.getDemonAPos();
			if(getCollisionMonster(arreyMonsterA[i][0],arreyMonsterA[i][1]))
				returnPosMonster(controllerOrder,arreyMonsterA[i][2]);
			
			arreyMonsterA = this.model.getDemonAPos();
			
		}
		
	}
	
	public IModel getModel() { return this.model; }
	
	public void returnPosMonster(ControllerOrder controllerOrder,int id){
		ControllerOrder[] real = {ControllerOrder.RIGHT,ControllerOrder.LEFT,ControllerOrder.DOWN,ControllerOrder.UP} ;
		ControllerOrder[] inverseReal = {ControllerOrder.LEFT,ControllerOrder.RIGHT,ControllerOrder.UP,ControllerOrder.DOWN} ;
		for(int i=0;i<4;i++){
			if(controllerOrder == real[i]){
				this.model.setDemonAPos(inverseReal[i],id);
			}
		}
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
