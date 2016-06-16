package contract;

import java.util.ArrayList;

/**
 * The Interface IController.
 *
 * @author Jean-Aymeric Diet
 */
public interface IController {
		public ControllerOrder orderPerform(ControllerOrder controllerOrder);
		public void getMapForView(ArrayList<String> alMap);
}
