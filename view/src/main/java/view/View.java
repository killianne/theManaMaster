package view;

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
	protected static ControllerOrder keyCodeToControllerOrder(final boolean[] arrayKey) {
		if(arrayKey[0] && arrayKey[2]) { return ControllerOrder.UL; }
		else if(arrayKey[0] && arrayKey[3]) { return ControllerOrder.UR; }
		else if(arrayKey[1] && arrayKey[2]) { return ControllerOrder.DL; }
		else if(arrayKey[1] && arrayKey[3]) { return ControllerOrder.DR; }
		else if(arrayKey[0] ) { return ControllerOrder.UP; }
		else if(arrayKey[1] ) { return ControllerOrder.DOWN; }
		else if(arrayKey[2] ) { return ControllerOrder.LEFT; }
		else if(arrayKey[3] ) { return ControllerOrder.RIGHT; }
		else     { return ControllerOrder.NO; }
	}
	
	public void getMapFromController(ArrayList<String> alMap){
		this.convertArrayListToArrayString(alMap);
		this.viewFrame.getViewPanel().buildViewPanel();
	}
	
	private void convertArrayListToArrayString(ArrayList<String> alMap){
		int counterX = 0, counterY = 0;
		for(int i=0; i<240;i++){
			this.arrayMap[counterY][counterX] = alMap.get(i);
			if(counterX == 19) { counterX = 0; counterY++; }
			else               {counterX++;                }
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
