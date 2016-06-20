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
	
	/** arraylist, map for contain position of item   */
	private ArrayList<String> map = new ArrayList<String>();
	
	private static boolean running= false;
	
	public	ControllerMonster(Controller controller,IModel model,IView view){
		this.view=view;
		this.controller=controller;
		this.model=model;
		map=this.model.getWorldForController();
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
	public void init(){
		this.controller.getModel();
	}
	
	public void run(){
		
		init();
		
		while(running) {
			monsterIaTypeA();
			try {
				Thread.sleep(250);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			view.getArrayPosMonsterFromController(controller.getPos());
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
			
		
			this.model.setDemonAPos(controllerOrder,arreyMonsterA[i][2]);
			arreyMonsterA = this.model.getDemonAPos();
			if(getCollisionMonster(arreyMonsterA[i][0],arreyMonsterA[i][1]))
				returnPosMonster(controllerOrder,arreyMonsterA[i][2]);
			
			arreyMonsterA = this.model.getDemonAPos();
			
		}
		
	}
	
	public void returnPosMonster(ControllerOrder controllerOrder,int id){
		ControllerOrder[] real = {ControllerOrder.RIGHT,ControllerOrder.LEFT,ControllerOrder.DOWN,ControllerOrder.UP} ;
		ControllerOrder[] inverseReal = {ControllerOrder.LEFT,ControllerOrder.RIGHT,ControllerOrder.UP,ControllerOrder.DOWN} ;
		for(int i=0;i<4;i++){
			if(controllerOrder == real[i]){
				this.model.setDemonAPos(inverseReal[i],id);
			}
		}
	}
}
