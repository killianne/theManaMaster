package view;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

import javax.swing.*;
import java.util.ArrayList;


/**
 * The Class View.
 *
 * @author Thomas
 */
public class View implements IView, Runnable {

	/** The frame. */
	private static ViewFrame viewFrame;
	
	private static Thread thread;
	
	private static boolean running= false;
	
	private static int counterThread;

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}
	
	/**
	 * The direction of the personage.
	 *
	 * @param arrayKey
	 *          the array of the key(s) pressed
	 * @return the controller order
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final boolean[] arrayKey) {
		if(arrayKey[0] && arrayKey[2])      { viewFrame.getViewPanel().setLorannKey("lorann_ul"); return ControllerOrder.UL;    }
		else if(arrayKey[0] && arrayKey[3]) { viewFrame.getViewPanel().setLorannKey("lorann_ur"); return ControllerOrder.UR;    }
		else if(arrayKey[1] && arrayKey[2]) { viewFrame.getViewPanel().setLorannKey("lorann_bl"); return ControllerOrder.DL;    }
		else if(arrayKey[1] && arrayKey[3]) { viewFrame.getViewPanel().setLorannKey("lorann_br"); return ControllerOrder.DR;    }
		else if(arrayKey[0] )               { viewFrame.getViewPanel().setLorannKey("lorann_u");  return ControllerOrder.UP;    }
		else if(arrayKey[1] )               { viewFrame.getViewPanel().setLorannKey("lorann_b");  return ControllerOrder.DOWN;  }
		else if(arrayKey[2] )               { viewFrame.getViewPanel().setLorannKey("lorann_l");  return ControllerOrder.LEFT;  }
		else if(arrayKey[3] )               { viewFrame.getViewPanel().setLorannKey("lorann_r");  return ControllerOrder.RIGHT; }
		else if(arrayKey[4] )               { return ControllerOrder.SHOOT; }
		else                                { return ControllerOrder.NO;    }
	}
	
	/**
	 * Gets map from controller and give it to ViewPanel
	 * 
	 * @param alMap
	 * 			the ArrayList that contains the map
	 */
	public void getMapFromController(ArrayList<String> alMap){
		viewFrame.getViewPanel().setALMap(alMap);
	}
	
	/**
	 * Gets the positions of the player-monsters-items from controller and give it to ViewPanel
	 * 
	 * @param arrayPos
	 * 			the array that contains all the positions
	 */
	public void getArrayPosFromController(int[][] arrayPos){
		viewFrame.getViewPanel().updateMap(arrayPos);
		//viewFrame.getViewPanel().updateMapPersonage(arrayPos);
		//viewFrame.getViewPanel().updateMapMonster(arrayPos);
		//viewFrame.getViewPanel().updateMapItem(arrayPos);
	}
	
	public void getArrayPosPersonageFromController(int[][] arrayPos){
		viewFrame.getViewPanel().updateMapPersonage(arrayPos);
	}
	
	public void getArrayPosMonsterFromController(int[][] arrayPos){
		viewFrame.getViewPanel().updateMapMonster(arrayPos);
	}
	
	public void getArrayPosItemFromController(int[][] arrayPos){
		viewFrame.getViewPanel().updateMapItem(arrayPos);
	}
	
	protected static int getCounterThread(){
		return counterThread;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		init();
		
		while(running) {
			tick();
			render();
		}
		
	}
	
	public void init(){
		counterThread=0;
	}
	
	public void tick(){
		counterThread++;
		if(counterThread==8){counterThread = 0; }
		try {
			Thread.sleep(80);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}
	
	public void render(){
		viewFrame.getViewPanel().moovePersonage(counterThread);
	}
	
	public synchronized void start(){
		if(running)
			return;
		running = true;
		thread = new Thread(this);
		thread.start();
	}
	
	public static synchronized void stop(){
		if(!running)
			return;
		running = false;
		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		viewFrame.setController(controller);
	}


}
