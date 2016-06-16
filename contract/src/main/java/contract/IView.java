package contract;

import java.util.ArrayList;

/**
 * The Interface IView.
 *
 * @author Jean-Aymeric Diet
 */
public interface IView {

	/**
	 * Prints the message.
	 *
	 * @param message
	 *          the message
	 */
	void printMessage(final String message);
	
	public void getMapFromController(ArrayList<String> alMap);
	
	//protected static ControllerOrder keyCodeToControllerOrder(final int keyCode);
}
