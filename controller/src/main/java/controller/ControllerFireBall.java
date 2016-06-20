package controller;

public class ControllerFireBall implements Runnable {
	
	private Controller ctrl;
	
	private static boolean running= false;
	
	private Thread thread;
	
	public ControllerFireBall(Controller ctrl){
		this.ctrl = ctrl;		
	}

	public void run() {
		init();
		
		while(running) {
			tick();
			render();
		}
		
	}
	
	public void init(){
		this.ctrl.getModel();
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