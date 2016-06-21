package contract;

import java.util.ArrayList;

/**
 * The Interface IView.
 *
 * @author Jean-Aymeric Diet
 */
public interface IView {
	
	public void getMapFromController(ArrayList<String> alMap);
	
	public void getArrayPosFromController(int[][] arrayPos);
	
	public void getArrayPosPersonageFromController(int[][] arrayPos);
	
	public void getArrayPosMonsterFromController(int[][] arrayPos);
	
	public void getArrayPosItemFromController(int[][] arrayPos);
	
	public void getArrayPosFireBallFromController(int x, int y,int id, ControllerOrder direction);
	
	public void setScore(int purse);
	
	public void setBoolMonsterFirstTimeToFalse();

}
