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
	public void run(){
		System.out.println("yo");
		String arrayMap[][]={{"b","ga","vb","vb","vb","vb","vb","vb","vb","vb","vb","vb","vb","vb","vb","vb","vb","vb","vb","vb","b" },
				             {"vh"," "," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ,"vh"},
				             {"vh"," "," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ,"vh"},
				             {"vh"," "," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ,"vh"},
				             {"vh"," "," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ,"vh"},
				             {"vh"," "," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ,"vh"},
				             {"vh"," "," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ,"vh"},
				             {"vh"," "," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ,"vh"},
				             {"vh"," "," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ,"vh"},
				             {"vh"," "," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ,"vh"},
				             {"vh"," "," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ,"vh"},
				             {"b","vb","vb","vb","vb","vb","vb","vb","vb","vb","vb","vb","vb","vb","vb","vb","vb","vb","vb","vb","b" }  };
		this.view.getMapFromController(arrayMap);
		
	}
	public void orderPerform(final ControllerOrder controllerOrder) {
	
		System.out.print(controllerOrder);
	}



	

}
