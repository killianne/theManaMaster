package controller;

import contract.IModel;

public class ControllerFireBall implements Runnable {
	
	private Controller ctrl;
	
	private IModel model;
	
	private static boolean running= false;
	
	private Thread thread;
	
	public ControllerFireBall(Controller ctrl, IModel model){
		this.ctrl = ctrl;		
		this.model = model;
	}

	public void run() {
		init();
		
		while(running) {
			tick();
			render();
		}
		
	}
	
	public void init(){
		
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