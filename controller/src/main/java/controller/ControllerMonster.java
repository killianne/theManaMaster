package controller;

import java.util.ArrayList;

import contract.ControllerOrder;
import contract.IModel;
import contract.IView;

public class ControllerMonster implements Runnable {

	private Thread thread;
	
	private IModel model;
	private Controller controller;
	private IView view;
	
	private boolean iaMonster1=false,iaMonster2=false,iaMonster3=false,iaMonster4=false;
	
	/** Map arraylist in String */
	private String positionInArraylist;
	private int itemCollision[][];
	/** arraylist, map for contain position of item   */
	private ArrayList<String> map = new ArrayList<String>();
	
	private static boolean running= false;
	
	public	ControllerMonster(Controller controller,IModel model,IView view){
		this.view=view;
		this.controller=controller;
		this.model=model;
		map=this.model.getWorldForController();
	}
	
	public boolean getCollisionMonster(int x, int y,int id){
		int xColis, yColis;
		xColis=x;yColis=y;
		this.itemCollision=controller.getPos();
		positionInArraylist=map.get(20*yColis+xColis);
		
	
		
		if(positionInArraylist.contains("b")||positionInArraylist.contains("hb")||positionInArraylist.contains("vb")){
		
			return true;
		}
		for(int i=0;i<itemCollision.length;i++)
		{
			if(itemCollision[i][4]!=id && itemCollision[i][0]==x && itemCollision[i][1]==y){
				
				return true;
			}
		}
		
		
		return false;	
	}
	public void init(){
		//this.controller.getModel();
		this.itemCollision=controller.getPos();
		for(int i=0;i<itemCollision.length;i++){
			if(itemCollision[i][2] == 1){ iaMonster1=true; }
			if(itemCollision[i][2] == 2){ iaMonster2=true; }
		}
	}
	
	public void run(){
		
		init();
		
		while(running) {
			map=this.model.getWorldForController();
			if(iaMonster1){
				monsterIaTypeA();
				}
				if(iaMonster2)
				monsterIaTypeB();
			try {
				Thread.sleep(125);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			//view.getArrayPosMonsterFromController(controller.getPos());
			view.getArrayPosFromController(controller.getPos());
		}
		
	}
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public void monsterIaTypeA(){
		ControllerOrder controllerOrder = ControllerOrder.NO;
		int random;
		int[][] arreyMonsterA = this.model.getDemonAPos();
		for(int i=0; i<arreyMonsterA.length; i++){
			random = (int) (Math.random() * 4);
			
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
			
		
			this.model.setDemonPos(controllerOrder,arreyMonsterA[i][2]);
		arreyMonsterA = this.model.getDemonAPos();
			if(getCollisionMonster(arreyMonsterA[i][0],arreyMonsterA[i][1],arreyMonsterA[i][3]))
				returnPosMonster(controllerOrder,arreyMonsterA[i][2]);
			
			arreyMonsterA = this.model.getDemonAPos();
			
		}
		
	}
	public void monsterIaTypeB(){
		ControllerOrder controllerOrder = ControllerOrder.NO;
		int random;
		int[][] position=controller.getPos();
		int x,y;
		boolean xT=false,yT=false;
		int[][] arreyMonsterB = this.model.getDemonBPos();
		for(int i=0; i<arreyMonsterB.length; i++){
			
			x=position[0][0]-arreyMonsterB[i][0];
			y=position[0][1]-arreyMonsterB[i][1];
			 if(x<= 0){
				 x=x*-1;
				 xT=true;
			 }
			 if(y<=0){
				 y=y*-1;
				 yT=true;
			 }
			controllerOrder=iAMonsterBExtend( x,  y,  xT , yT);
	
			this.model.setDemonPos(controllerOrder,arreyMonsterB[i][2]);
			arreyMonsterB = this.model.getDemonBPos();
			if(getCollisionMonster(arreyMonsterB[i][0],arreyMonsterB[i][1],arreyMonsterB[i][3]))
				returnPosMonster(controllerOrder,arreyMonsterB[i][2]);
							
			arreyMonsterB = this.model.getDemonBPos();
			
		}
		
	}
	public ControllerOrder iAMonsterBExtend(int x, int y, boolean xT ,boolean yT){
	
		if(x<y && xT==true && x!=0){
			 return ControllerOrder.LEFT;
		 }
		 else if(x<y && x!=0 ){
			 return ControllerOrder.RIGHT;
		 }
		 else if(y<x && yT==true&& y!=0){
			 return ControllerOrder.UP;
		 }
		 else if(y<x && y!=0){
			 return ControllerOrder.DOWN;
		 }
		 else if(x<y  && x==0 && yT==true){
			 return ControllerOrder.UP;
		 }
		 else if(x<y && x==0 ){
			 return ControllerOrder.DOWN;
		 }
		 else if(y<x  && y==0 && xT==true){
			 return ControllerOrder.LEFT;
		 }
		 else if(y<x && y==0){
			 return ControllerOrder.RIGHT;
		 }
		 else{
			 return ControllerOrder.NO;
		 }
		
		
	}
	public void returnPosMonster(ControllerOrder controllerOrder,int id){
		ControllerOrder[] real = {ControllerOrder.RIGHT,ControllerOrder.LEFT,ControllerOrder.DOWN,ControllerOrder.UP} ;
		ControllerOrder[] inverseReal = {ControllerOrder.LEFT,ControllerOrder.RIGHT,ControllerOrder.UP,ControllerOrder.DOWN} ;
		for(int i=0;i<4;i++){
			if(controllerOrder == real[i]){
				this.model.setDemonPos(inverseReal[i],id);
			}
		}
	}
}
