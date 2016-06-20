package controller;

import java.util.ArrayList;

import contract.IModel;
import contract.IView;

public class ControllerFireBall implements Runnable {
	
	private Controller ctrl;
	
	private IModel model;
	
	private IView view;
	
	private int idImage=0;
	
	private static boolean running= false;
	
	private Thread thread;
	
	private ArrayList<String> alMap;
	
	public ControllerFireBall(Controller ctrl, IModel model, IView view){
		this.ctrl = ctrl;		
		this.model = model;
		this.view = view;
	}

	public void run() {
		init();
		
		while(running) {
			tick();
			render();
			idImage++;
			if(idImage == 5) { idImage=0;}
			
			try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
		}
		
	}
	
	public void init(){
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
		int x = this.model.getPosFireBall()[0];
		int y = this.model.getPosFireBall()[1];
		String elementInArrayList = alMap.get(20*y+x);
		if(elementInArrayList.equals("vb") || elementInArrayList.equals("hb") || elementInArrayList.equals("b")){
			System.out.println("MUR !!");
			this.model.moveFireBallReverse();
		}
	}

}