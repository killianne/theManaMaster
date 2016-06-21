package view;

import contract.IController;
import contract.IModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * The Class ViewFrame.
 *
 * @author Thomas
 */
class ViewFrame extends JFrame implements KeyListener {

	/** The model. */
	private IModel						model;

	/** The controller. */
	private IController				controller;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -697358409737458175L;
	
	/** The viewPanel */
	private ViewPanel viewPanel;
	
	/** The menu */
	private JMenuBar menuBar = new JMenuBar();
	
	/** The menus that lead you to others choices */
	private JMenu menuFile = new JMenu("File");
	private JMenu menuDesign = new JMenu("Design");
	
	/** The choices you have in the menu bar*/
	private JMenuItem itemNewGame = new JMenuItem("New game");
	private JMenuItem itemSetting = new JMenuItem("Setting");
	private JMenuItem itemExit = new JMenuItem("Exit");
	
	/** The design of the game that you can choose*/
	private JRadioButtonMenuItem jrbmi1 = new JRadioButtonMenuItem("Standard");
	private JRadioButtonMenuItem jrbmi2 = new JRadioButtonMenuItem("Pokemon");
	private JRadioButtonMenuItem jrbmi3 = new JRadioButtonMenuItem("Dragon Ball");
	private JRadioButtonMenuItem jrbmi4 = new JRadioButtonMenuItem("Zelda");
	
	/** The array needed to know the key(s) pressed*/
	private boolean[] arrayKey = {false,false,false,false,false};
	
	/** The current design of the word*/
	private WorldDesign currentDesign = WorldDesign.STANDARD;
	
	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @throws HeadlessException
	 *           the headless exception
	 */
	public ViewFrame(final IModel model) throws HeadlessException {
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param gc
	 *          the gc
	 */
	public ViewFrame(final IModel model, final GraphicsConfiguration gc) {
		super(gc);
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param title
	 *          the title
	 * @throws HeadlessException
	 *           the headless exception
	 */
	public ViewFrame(final IModel model, final String title) throws HeadlessException {
		super(title);
		this.buildViewFrame(model);
	}

	/**
	 * Instantiates a new view frame.
	 *
	 * @param model
	 *          the model
	 * @param title
	 *          the title
	 * @param gc
	 *          the gc
	 */
	public ViewFrame(final IModel model, final String title, final GraphicsConfiguration gc) {
		super(title, gc);
		this.buildViewFrame(model);
	}
	
	/**
	 * Gets the viewPanel
	 * @return the viewPanel
	 */
	public ViewPanel getViewPanel(){
		return this.viewPanel;
	}
	
	/**
	 * Return the design ID of the design you want
	 * 
	 * @return the design ID
	 */
	public int getCurrentWorldID(){
		if(this.currentDesign == WorldDesign.STANDARD)   { return 0; }
		if(this.currentDesign == WorldDesign.POKEMON)    { return 1; }
		if(this.currentDesign == WorldDesign.DRAGONBALL) { return 2; }
		if(this.currentDesign == WorldDesign.ZELDA)      { return 3; }
		return 0;
	}

	/**
	 * Gets the controller.
	 *
	 * @return the controller
	 */
	private IController getController() {
		return this.controller;
	}

	/**
	 * Sets the controller.
	 *
	 * @param controller
	 *          the new controller
	 */
	protected void setController(final IController controller) {
		this.controller = controller;
	}

	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	protected IModel getModel() {
		return this.model;
	}

	/**
	 * Sets the model.
	 *
	 * @param model
	 *          the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/**
	 * Builds the view frame and call the methode that create the menu bar.
	 *
	 * @param model
	 *          the model
	 */
	private void buildViewFrame(final IModel model) {
		this.setModel(model);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.addKeyListener(this);
		viewPanel = new ViewPanel(this);
		this.setContentPane(viewPanel);
		this.setSize(640+6+10+10,384+23+29+10+10+29);
		this.setLocationRelativeTo(null);
		
		this.buildMenu();
		this.setVisible(true);
	}
	
	/**
	 * Builds the menu bar
	 */
	public void buildMenu(){
		jrbmi1.addActionListener(new StandardWorldListener());
		jrbmi2.addActionListener(new PokemonWorldListener());
		jrbmi3.addActionListener(new DBZWorldListener());
		jrbmi4.addActionListener(new ZeldaWorldListener());
		jrbmi1.setSelected(true);
		
		menuDesign.add(jrbmi1);
		menuDesign.add(jrbmi2);
		menuDesign.add(jrbmi3);
		menuDesign.add(jrbmi4);
		
		itemExit.addActionListener(new ActionListener(){
		      public void actionPerformed(ActionEvent event){
		        System.exit(0);
		      }
		    });
		
		this.menuFile.add(itemNewGame);
		this.menuFile.add(itemSetting);
		this.menuFile.add(menuDesign);
		menuFile.addSeparator();
		this.menuFile.add(itemExit);
		this.menuBar.add(menuFile);
	    this.setJMenuBar(menuBar);
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(final KeyEvent e) {
		
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(final KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_Z :
				arrayKey[0] = true;
				break;
			case KeyEvent.VK_S :
				arrayKey[1] = true;
				break;
			case KeyEvent.VK_Q :
				arrayKey[2] = true;
				break;
			case KeyEvent.VK_D :
				arrayKey[3] = true;
				break;
			case KeyEvent.VK_SPACE :
				arrayKey[4] = true;
				break;
		}
		try {
			this.getController().orderPerform(View.keyCodeToControllerOrder(arrayKey));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(final KeyEvent e) {
		switch(e.getKeyCode()){
			case KeyEvent.VK_Z :
				arrayKey[0] = false;
				break;
			case KeyEvent.VK_S :
				arrayKey[1] = false;
				break;
			case KeyEvent.VK_Q :
				arrayKey[2] = false;
				break;
			case KeyEvent.VK_D :
				arrayKey[3] = false;
				break;
			case KeyEvent.VK_SPACE :
				arrayKey[4] = false;
				break;
		}
	}
	/**
	 * Create an inner class that select the design of the world and modify the menu so you can only choose one design
	 * Here it's for the design STANDARD
	 * @author Thomas
	 *
	 */
	public class StandardWorldListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {      
	      currentDesign = WorldDesign.STANDARD;
	      jrbmi1.setSelected(true);
	      jrbmi2.setSelected(false);
	      jrbmi3.setSelected(false);
	      jrbmi4.setSelected(false);
	      viewPanel.updateDesign();
		}    
	}
	
	/**
	 * Create an inner class that select the design of the world and modify the menu so you can only choose one design
	 * Here it's for the design POKEMON
	 * @author Thomas
	 *
	 */
	public class PokemonWorldListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {      
			currentDesign = WorldDesign.POKEMON;
		      jrbmi1.setSelected(false);
		      jrbmi2.setSelected(true);
		      jrbmi3.setSelected(false);
		      jrbmi4.setSelected(false);
		      viewPanel.updateDesign();
		}    
	}
	
	/**
	 * Create an inner class that select the design of the world and modify the menu so you can only choose one design
	 * Here it's for the design DRAGONBALL
	 * @author Thomas
	 *
	 */
	public class DBZWorldListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {      
			currentDesign = WorldDesign.DRAGONBALL;
		      jrbmi1.setSelected(false);
		      jrbmi2.setSelected(false);
		      jrbmi3.setSelected(true);
		      jrbmi4.setSelected(false);
		      viewPanel.updateDesign();
		}    
	}
	
	/**
	 * Create an inner class that select the design of the world and modify the menu so you can only choose one design
	 * Here it's for the design ZELDA
	 * @author Thomas
	 *
	 */
	public class ZeldaWorldListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {      
			currentDesign = WorldDesign.ZELDA;
		      jrbmi1.setSelected(false);
		      jrbmi2.setSelected(false);
		      jrbmi3.setSelected(false);
		      jrbmi4.setSelected(true);
		      viewPanel.updateDesign();
		}    
	}
	
}
