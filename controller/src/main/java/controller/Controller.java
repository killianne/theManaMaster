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
	
	private ControllerFireBall controllerFireBall;
	
	public Controller( IView view,  IModel model) {
		this.setView(view);
		this.setModel(model);
		controllerFireBall = new ControllerFireBall(this,model,view);
		map=this.model.getWorldForController();
	}
	
	private void setView(final IView view) {
		this.view = view;
	}

	private void setModel(final IModel model) {
		this.model = model;
	}
	
	public void instantiateInitialMap() throws Exception{
		this.view.getMapFromController(this.model.getWorldForController());
		this.model.instantiateMonsters();
		this.view.getArrayPosFromController(this.getPos());
	}
	
	public void run() throws Exception{
		if(this.model.getSwitchWorldPlayer())
			map=this.model.getWorldForController();
		this.memoryPos();
		this.playerMove();
		this.getCollision(playerPositionX, playerPositionY);
		
		//monsterIaTypeA();
		
		//this.view.getArrayPosPersonageFromController(this.getPos());
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

	

	
	public IModel getModel() { return this.model; }
	
	public synchronized void getCollision(int x , int y) throws Exception{
		int[][] itemCollision=getPos();
		positionInArraylist=map.get(20*y+x);
		if(positionInArraylist.contains("b")||positionInArraylist.contains("hb")||positionInArraylist.contains("vb")){
			collision();
		}
		for(int i=0;i<itemCollision.length;i++)
		{
			if(itemCollision[i][4]!=0 && itemCollision[i][0]==x && itemCollision[i][1]==y){
				if(itemCollision[i][2]==5){
					for(int j=0; j<itemCollision.length;j++){
						if(itemCollision[j][2]==8){
							this.model.openDoor(itemCollision[j][3]);
						}
					}
					this.model.removeAlFromEntity(itemCollision[i][3]);
				}
				else if(itemCollision[i][2]==6){
					this.model.addPurse(500);
					this.view.setScore(this.model.getPurse());
					this.model.removeAlFromEntity(itemCollision[i][3]);
				}
				else if(itemCollision[i][2]==7){
					this.model.switchWorld();
					this.view.getMapFromController(this.model.getWorldForController());
					this.view.setBoolMonsterFirstTimeToFalse();
				}
				else {
					collision();
				}
			}
		}
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
	
	if(controllerOrder != ControllerOrder.SHOOT){
		this.model.setPlayerDirection(controllerOrder);
	}
	this.model.setPlayerPosX(playerPositionX);
	this.model.setPlayerPosY(playerPositionY);
}

	public void orderPerform(final ControllerOrder controllerOrder) throws Exception {
		this.controllerOrder=controllerOrder;
		if(controllerOrder == controllerOrder.SHOOT){
			this.controllerFireBall.start();
		}
		this.run();
	}


	



	

}
