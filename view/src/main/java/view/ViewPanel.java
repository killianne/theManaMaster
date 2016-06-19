package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * The Class ViewPanel.
 *
 * @author Thomas
 */
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame					viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;
	
	/** The JPanel that contains the label of the available life(s) and the actual score. */
	JPanel pScoreAndLife = new JPanel();
	
	/** The JPanel that contains the map. */
	JPanel pMap = new JPanel();
	
	/** The array of JPanel that contains the image of the design. */
	JLabel jArrayMap[][] = new JLabel[12][20];
	
	/** The JLabel of the available life(s). */
	private JLabel lLife = new JLabel();
	
	/** The JLabel of the actual score. */
	private JLabel lScore = new JLabel();
	
	/** The array that contains the symbols of the map's items. */
	private String arraySymbol[] = {"b","vb","hb"," "};
	
	/** The array that contains the name of the static items images. */
	private String arrayStaticImageName[] = {"bone","vertical_bone","horizontal_bone","blank"};
	
	/** The array that contains the name of the non static items images. */
	private String arrayNonStaticImageName[] = {"monster_1","monster_2","monster_3","monster_4","crystal_ball","purse",
			"gate_open","gate_closed","fireball_1","fireball_2","fireball_3","fireball_4","fireball_5"};
	
	/** The array that contains the name of all the lorann images */
	private String arrayLorannImageName[] = {"lorann_b","lorann_bl","lorann_l","lorann_ul","lorann_u","lorann_ur","lorann_r","lorann_br"};
	
	/** The array that contains the name of the files that contain the images for the different design. */
	private String arrayNameFile[] = {"sprite","spritePokemon","spriteDBZ","spriteZelda"};
	
	/** The array that contains the name of the static items image. */
	private ArrayList<String> alMap;
	
	/** The former positions of the personage  */
	private int formerPlayerPosX = -1,formerPlayerPosY = -1;
	
	/** The array that contains the positions of the personage-monsters-items*/
	private int[][] arrayPos;
	
	private String lorannKey = "";


	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
		this.setLayout(null);
		this.setBackground(Color.BLACK);
		pMap.setBounds(10,10,640,384);
		pScoreAndLife.setBounds(30,394,450,30);
		pMap.setLayout(new GridLayout(12,20));
		for (int i=0; i<12; i++) {
			for (int j=0; j<20; j++) {
				jArrayMap[i][j] = new JLabel();
				pMap.add(jArrayMap[i][j]);
			}
		}
		
	}
	
	public void setLorannKey(String s){
		this.lorannKey=s;
	}
	
	/**
	 * Save the map in a variable and load the JPanels that ViewPanel contains
	 * 
	 * @param alMap
	 * 			The ArrayList that contains the map
	 */
	public void setALMap(ArrayList<String> alMap){
		this.alMap = alMap;
		this.loadMap();
		this.buildLifeAndScore();
	}
	
	/**
	 * Load the map in an array of JPanels from an ArrayList
	 */
	public void loadMap(){
		int counterX=0, counterY=0;
		for(int i=0;i<240;i++){
			for(int k=0; k<arrayStaticImageName.length;k++){
					if(alMap.get(i).equals(arraySymbol[k])) { this.jArrayMap[counterY][counterX].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+"/"+arrayStaticImageName[k]+".png")); }
	         }
			if(counterX==jArrayMap[0].length-1){
				counterY++;
				counterX=0;
			}
			else { counterX++; }
		}
		this.add(pMap);
	}
	
	/**
	 * Build the JLabel of the life and the score
	 */
	public void buildLifeAndScore(){
		pScoreAndLife.setLayout(new BorderLayout());
		pScoreAndLife.setBackground(Color.BLACK);
		Font font = new Font("Tahoma", Font.BOLD, 20);
		lLife.setFont(font);
		lLife.setText("<html><font color = #1E7FCB >Resurections : 00</font></html>");
		lScore.setFont(font);
		lScore.setText("<html><font color = #F0C300 >Score : 00000000</font></html>");
		pScoreAndLife.add(lLife, BorderLayout.WEST);
		pScoreAndLife.add(lScore, BorderLayout.EAST);
		this.add(pScoreAndLife);
		pScoreAndLife.revalidate();
	}
	
	/**
	 * Sets the score
	 * 
	 * @param score
	 * 			The score
	 */
	public void setScore(int score){
		lScore.setText("<html><font color = #F0C300 >Score : " + score + "</font></html>");
	}
	
	/**
	 * Sets the available life(s)
	 * 
	 * @param life
	 * 			The number of life(s)
	 */
	public void setLife(int life){
		lLife.setText("<html><font color = #1E7FCB >Resurections : " + life + "</font></html>");
	}
	
	/**
	 * Modify the current design
	 */
	public void updateDesign(){
		this.loadMap();
		switch(this.viewFrame.getCurrentWorldID()){
			case 0 :
				this.setBackground(Color.BLACK);
				pScoreAndLife.setBackground(Color.BLACK);
				this.UpdateMap(arrayPos);
				break;
			case 1 :
				this.setBackground(Color.WHITE);
				pScoreAndLife.setBackground(Color.WHITE);
				this.UpdateMap(arrayPos);
				break;
			case 2 :
				this.setBackground(Color.BLACK);
				pScoreAndLife.setBackground(Color.BLACK);
				this.UpdateMap(arrayPos);
				break;
			case 3 :
				this.setBackground(Color.BLACK);
				pScoreAndLife.setBackground(Color.BLACK);
				this.UpdateMap(arrayPos);
				break;
		}
		
	}
	
	/**
	 * Update the map in function of the positions of the personage-monsters-items
	 * 
	 * @param arrayPlayPos
	 * 			The array that contains the positions of the personage-monsters-items
	 */
	public void UpdateMap(int arrayPos[][]){
		this.arrayPos = arrayPos;
		if(formerPlayerPosX != -1 && formerPlayerPosY != -1) {
			if(formerPlayerPosX != arrayPos[0][0] || formerPlayerPosY != arrayPos[0][1]){
				jArrayMap[formerPlayerPosY][formerPlayerPosX].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+"/blank.png"));
			}
		}
		formerPlayerPosX = arrayPos[0][0];
		formerPlayerPosY = arrayPos[0][1];
		
		//i = 1 because we don't want the pos of the player
		for(int i=1; i<arrayPos.length; i++){
			for(int k=0; k<arrayNonStaticImageName.length; k++){
				// k- 1 because in the table ID = 1 minimum but in the array of name it begin at 0
				if(arrayPos[i][2] == k) { jArrayMap[arrayPos[i][1]] [arrayPos[i][0]].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+ "/" + arrayNonStaticImageName[k-1] + ".png")); }
			}
		}
		
		if(lorannKey.equals("")){
			jArrayMap[arrayPos[0][1]] [arrayPos[0][0]].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+ "/" + arrayLorannImageName[View.getCounterThread()] + ".png"));
		}
		else{
			jArrayMap[arrayPos[0][1]] [arrayPos[0][0]].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+ "/" + lorannKey + ".png"));
			lorannKey ="";
		}
	}
	
	/**
	 * Make the sprite of the personage moove
	 * 
	 * @param counterThread
	 * 				The Id the personage's image
	 */
	public void moovePersonage(int counterThread){
		for(int k=0; k<arrayLorannImageName.length; k++){
			if(counterThread == k) { jArrayMap[formerPlayerPosY][formerPlayerPosX].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+"/" + arrayLorannImageName[k] + ".png")); }
		}
	}

	/**
	 * Sets the view frame.
	 *
	 * @param viewFrame
	 *          the new view frame
	 */
	private void setViewFrame(final ViewFrame viewFrame) {
		this.viewFrame = viewFrame;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.util.Observer#update(java.util.Observable, java.lang.Object)
	 */
	public void update(final Observable arg0, final Object arg1) {
		this.repaint();
	}
}
