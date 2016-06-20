package controller;

import java.util.ArrayList;

import contract.ControllerOrder;
import contract.IModel;
import contract.IView;

public class ControllerMonster implements Runnable {

	private Thread thread;
	
	IModel model;
	Controller controller;
	IView view;
	
	/** Map arraylist in String */
	String positionInArraylist;
	int itemCollision[][];
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
		
		System.out.println("Position Monster : "+positionInArraylist + "/id ="+ id);
		
		if(positionInArraylist.contains("b")||positionInArraylist.contains("hb")||positionInArraylist.contains("vb")){
			System.out.println("Monster Collision ");
			return true;
		}
		for(int i=0;i<itemCollision.length;i++)
		{
			if(itemCollision[i][4]!=id && itemCollision[i][0]==x && itemCollision[i][1]==y){
				System.out.println("collision with player or other item");
				return true;
			}
		}
		
		
		return false;	
	}
	public void init(){
		this.controller.getModel();
	}
	
	public void run(){
		
		init();
		
		while(running) {
			monsterIaTypeA();
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
			
		
			this.model.setDemonPos(controllerOrder,arreyMonsterA[i][2]);
		arreyMonsterA = this.model.getDemonAPos();
		System.out.println(arreyMonsterA[i][2]+"<-oklm");
			if(getCollisionMonster(arreyMonsterA[i][0],arreyMonsterA[i][1],arreyMonsterA[i][3]))
				returnPosMonster(controllerOrder,arreyMonsterA[i][2]);
			
			arreyMonsterA = this.model.getDemonAPos();
			
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
