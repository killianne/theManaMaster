package contract;

import java.util.ArrayList;
import java.util.Observable;

/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {

	//public ControllerOrder getOrderPerform(ControllerOrder controllerOrder);
	
	ArrayList<String> getWorldForController();

	/**
	 * Gets the observable.
	 *
	 * @return the observable
	 */
	Observable getObservable();
	
	public void addPurse(int purse);
	public int getPurse();
	public void openDoor();
	
	public void removeAlFromEntity(int id);
	
	public boolean shootFireBall() throws Exception;
	public void moveFireBall();
	public int[] getPosFireBall();
	public ControllerOrder getDirectionFireBall();
	public void moveFireBallReverse();
	
	public int getPlayerPosX();
	public int getPlayerPosY();
	public void setPlayerPosY(int y);
	public void setPlayerPosX(int x);
	public void setPlayerDirection(ControllerOrder direction);
	
	public int [][] getDemonAPos();
	public int [][] getDemonBPos();
	public int [][] getDemonCPos();
	public int [][] getDemonDPos();

	public void setDemonPos(ControllerOrder controllerOrder,int id);
	
	public int[][] getPlayerPositions();
	
	
	public Integer DemonAIsInTheWorld();
	public Integer DemonBIsInTheWorld();
	public Integer DemonCIsInTheWorld();
	public Integer DemonDIsInTheWorld();
	public Integer EnergyBubbleIsInTheWorld();
	public Integer PurseIsInTheWorld();
	
	public void instantiateMonsters() throws Exception;
	public int[][] arrayPos();
}
