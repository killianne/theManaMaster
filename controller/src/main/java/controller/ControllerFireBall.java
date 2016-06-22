package controller;

import java.util.ArrayList;

import contract.IController;
import contract.IModel;
import contract.IView;

public class ControllerFireBall implements Runnable {
	
	private IModel model;
	
	private IView view;
	
	private IController ctrl;
	
	private int idImage=0;
	
	private static boolean running= false;
	
	private Thread thread;
	
	private ArrayList<String> alMap;
	
	public ControllerFireBall(Controller ctrl, IModel model, IView view){
		this.model = model;
		this.view = view;
		this.ctrl = ctrl;
	}

	public void run() {
		try {
			init();
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		while(running) {
			if(this.model.getSwitchWorldFireball()){
				alMap=this.model.getWorldForController();
				running=false;
				this.model.removeFireBall();
				try {
					thread.join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			else{
			
			tick();
			render();
			idImage++;
			if(idImage == 5) { idImage=0;}
			
			
			}
			try { Thread.sleep(250); } catch (InterruptedException e) { e.printStackTrace(); }
		}
		
	}
	
	public void init() throws Exception{
		this.model.shootFireBall();
	
		alMap = this.model.getWorldForController();
	}
	
	public void tick(){
		this.model.moveFireBall();
		this.collision();
	}
	
	public void render(){
		System.out.println("dir view : " + this.model.getDirectionFireBall());
		this.view.getArrayPosFireBallFromController(this.model.getPosFireBall()[0], this.model.getPosFireBall()[1], this.idImage, this.model.getDirectionFireBall());
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
	
	public void collision(){
		int[][] arrayPos = this.model.arrayPos();
		int x = this.model.getPosFireBall()[0];
		int y = this.model.getPosFireBall()[1];
		String elementInArrayList = alMap.get(20*y+x);
		if(elementInArrayList.equals("vb") || elementInArrayList.equals("hb") || elementInArrayList.equals("b")){
			this.model.moveFireBallReverse();
		}
		for(int i=0; i<arrayPos.length; i++){
			if(x == arrayPos[i][0] && y == arrayPos[i][1]){
				if(arrayPos[i][2] == 5 || arrayPos[i][2] == 6 || arrayPos[i][2] == 7 || arrayPos[i][2] == 8){
					this.model.moveFireBallReverse();
				}
				else if(arrayPos[i][2] == 1 || arrayPos[i][2] == 2 || arrayPos[i][2] == 3 || arrayPos[i][2] == 4){
					this.ctrl.stopMonster();
					this.model.removeFireBall();
					this.model.removeAlFromEntity(arrayPos[i][3]);
					running=false;
					this.ctrl.startMonster();
					
					alMap = this.model.getWorldForController();
					arrayPos = this.model.arrayPos();
					this.view.updateAllMapFromController(arrayPos, alMap);
					try {thread.join();}
					catch (InterruptedException e) {e.printStackTrace();}
				}
				else if(arrayPos[i][2] == 0){
					this.view.getArrayPosFireBallFromController(this.model.getPosFireBall()[0], this.model.getPosFireBall()[1], this.idImage, this.model.getDirectionFireBall());
					running=false;
					this.model.removeFireBall();
					try {thread.join();}
					catch (InterruptedException e) {e.printStackTrace();}
				}
			}
		}
	}

}