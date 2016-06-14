package controller;

import contract.ControllerOrder;
import contract.IController;
import contract.IModel;
import contract.IView;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
public class Controller implements IController {

	/** The view. */
	private IView	view;

	/** The model. */
	private IModel	model;

	
	public Controller( IView view,  IModel model) {
		this.setView(view);
		this.setModel(model);
	}

	private void setView(final IView view) {
		this.view = view;
	}

	private void setModel(final IModel model) {
		this.model = model;
	}
	String arr[][]={{"1"},{"2"}};
	public void run(){
		
		this.view.getMapFromController(arr);
		
	}
	



	

}
