package view;

import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.SwingUtilities;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

/**
 * The Class View.
 *
 * @author Jean-Aymeric Diet
 */
public class View implements IView, Runnable {

	/** The frame. */
	private final ViewFrame viewFrame;
	
	private static String arrayMap[][] = new String[12][20];

	/**
	 * Instantiates a new view.
	 *
	 * @param model
	 *          the model
	 */
	public View(final IModel model) {
		this.viewFrame = new ViewFrame(model);
		SwingUtilities.invokeLater(this);
	}
	
	/**
	 * Key code to controller order.
	 *
	 * @param keyCode
	 *          the key code
	 * @return the controller order
	 */
	protected static ControllerOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
			case KeyEvent.VK_Z:
				return ControllerOrder.UP;
			case KeyEvent.VK_S:
				return ControllerOrder.DOWN;
			case KeyEvent.VK_Q:
				return ControllerOrder.LEFT;
			case KeyEvent.VK_D:
			 return ControllerOrder.RIGHT;
			default:
				return ControllerOrder.NO;
		}
	}
	
	
	public void getMapFromController(ArrayList<String> alMap){
		System.out.println("yo");
		this.convertArrayListToArrayString(alMap);
		this.viewFrame.getViewPanel().buildViewPanel();
	}
	
	private void convertArrayListToArrayString(ArrayList<String> alMap){
		int counterX = 0, counterY = 0;
		for(int i=0; i<240;i++){
			System.out.println(alMap.get(i));
			this.arrayMap[counterY][counterX] = alMap.get(i);
			if(counterX == 19) { counterX = 0; System.out.println(); }
		}
	}
	
	protected static String[][] getArrayMap(){
		return arrayMap;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printMessage(final String message) {
		this.viewFrame.printMessage(message);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		this.viewFrame.setVisible(true);
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	public void setController(final IController controller) {
		this.viewFrame.setController(controller);
	}
}
