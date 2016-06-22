package main;

import controller.Controller;
import controller.ControllerMonster;
import model.Model;
import view.View;

/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {

	/**
	 * The main method.
	 *
	 * @param args
	 *          the arguments
	 * @throws Exception 
	 */
	public static void main(final String[] args) throws Exception {
	
		final Model model = new Model();
		final View view = new View(model);
		final Controller controller = new Controller(view, model);
		
		view.setController(controller);
		controller.instantiateInitialMap();
		controller.instantiateMonsterThread();
		view.start();
	}
}