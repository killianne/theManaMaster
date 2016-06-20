package controller;

import contract.IModel;
import contract.IView;

public class ControllerFireBall implements Runnable {
	
	private Controller ctrl;
	
	private IModel model;
	
	private IView view;
	
	private static boolean running= false;
	
	private Thread thread;
	
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
		}
		
	}
	
	public void init(){
		this.model.shootFireBall();
	}
	
	public void tick(){
		
	}
	
	public void render(){
		
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
	
	

}