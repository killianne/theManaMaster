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
		//                     1    2    3    4    5    6    7    8    9   10   11   12   13   14   15   16   17   18   19   20
		String arrayMap[][]={{"b","go","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","b" },
				             {"vb"," "," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ,"vb"},
				             {"vb"," "," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ,"vb"},
				             {"vb"," "," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ,"vb"},
				             {"vb"," "," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ,"vb"},
				             {"vb"," "," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ,"vb"},
				             {"vb"," "," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ,"vb"},
				             {"vb"," "," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ,"vb"},
				             {"vb"," "," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ,"vb"},
				             {"vb"," "," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ,"vb"},
				             {"vb"," "," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ," " ,"vb"},
				             {"b","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","hb","b" }  };
		this.view.getMapFromController(arrayMap);
		
	}
	public void orderPerform(final ControllerOrder controllerOrder) {
	
		System.out.print(controllerOrder);
	}



	

}
