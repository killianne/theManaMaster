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

}
