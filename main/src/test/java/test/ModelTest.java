package test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import contract.ControllerOrder;
import controller.Controller;
import controller.ControllerMonster;
import model.Model;
import view.View;

public class ModelTest {
	private View view;
	private Model model;
	private Controller controller;
	private ControllerMonster controlMonster;
	@Before
	public void setUp() throws Exception {
	
		model= new Model();	
		view= new View(model);
		controller=new Controller(view, model);
		controlMonster = new ControllerMonster(controller,model,view);
		view.setController(controller);
		controller.instantiateInitialMap();
		controlMonster.start();
	
	}
	
	@Test
	public void testGet(){
		assertNotNull(model.getWorld());
		assertNotNull(model.getPlayerPosition());
		assertNotNull(model.getPurse());
		assertNotNull(model.getDoorPosition());
		assertNotNull(model.arrayPos());

	}
}
