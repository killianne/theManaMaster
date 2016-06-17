package contract;

import java.util.ArrayList;
import java.util.Observable;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	public ControllerOrder getOrderPerform(ControllerOrder controllerOrder);
	/**
	 * Gets the message.
	 *
	 * @return the message
	 */

	/**
	 * Load the message.
	 *
	 * @param key
	 *          the key
	 */
	ArrayList<String> loadWorld();

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
	
	public int getPlayerPosX();
	public int getPlayerPosY();
	
	public int getDemonAPosX();
	public int getDemonAPosY();
	
	public int getDemonBPosX();
	public int getDemonBPosY();
	
	public int getDemonCPosX();
	public int getDemonCPosY();
	
	public int getDemonDPosX();
	public int getDemonDPosY();
	
	public int[] getPlayerPositions();
	
	
}
