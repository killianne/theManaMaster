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
 * @author Jean-Aymeric Diet
 */
public class View implements IView, Runnable {

	/** The frame. */
	private final ViewFrame viewFrame;
	
	private static ArrayList<String> alMap = new ArrayList<String>();
	
	private static int arrayPos[][];

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
		if(arrayKey[0] && arrayKey[2])      { return ControllerOrder.UL;    }
		else if(arrayKey[0] && arrayKey[3]) { return ControllerOrder.UR;    }
		else if(arrayKey[1] && arrayKey[2]) { return ControllerOrder.DL;    }
		else if(arrayKey[1] && arrayKey[3]) { return ControllerOrder.DR;    }
		else if(arrayKey[0] )               { return ControllerOrder.UP;    }
		else if(arrayKey[1] )               { return ControllerOrder.DOWN;  }
		else if(arrayKey[2] )               { return ControllerOrder.LEFT;  }
		else if(arrayKey[3] )               { return ControllerOrder.RIGHT; }
		else if(arrayKey[4] )               { return ControllerOrder.SHOOT; }
		else                                { return ControllerOrder.NO;    }
	}
	
	public void getMapFromController(ArrayList<String> alMap){
		//this.alMap = alMap;
		this.viewFrame.getViewPanel().setalMap(alMap);
	}
	
	public void getArrayPosFromController(int[][] arrayPos){
		//this.arrayPos = arrayPos;
		this.viewFrame.getViewPanel().UpdateMap(arrayPos);
	}
	
	protected static int[][] getArrayPos(){
		return arrayPos;
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
