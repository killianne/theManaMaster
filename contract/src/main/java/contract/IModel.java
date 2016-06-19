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
	ArrayList<String> getWorldForController();

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
	
	public int getPlayerPosX();
	public int getPlayerPosY();
	public void setPlayerPosY(int y);
	public void setPlayerPosX(int x);
	/*
	public int getDemonAPosX();
	public int getDemonAPosY();
	
	public int getDemonBPosX();
	public int getDemonBPosY();
	
	public int getDemonCPosX();
	public int getDemonCPosY();
	
	public int getDemonDPosX();
	public int getDemonDPosY();
	*/
	public int[][] getPlayerPositions();
	
	
	public Integer DemonAIsInTheWorld();
	public Integer DemonBIsInTheWorld();
	public Integer DemonCIsInTheWorld();
	public Integer DemonDIsInTheWorld();
	public Integer EnergyBubbleIsInTheWorld();
	public Integer PurseIsInTheWorld();
	
	public void instantiateMonsters();
	public int[][] arrayPos();
}
