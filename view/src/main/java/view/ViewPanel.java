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
 * @author Jean-Aymeric Diet
 */
class ViewPanel extends JPanel implements Observer {

	/** The view frame. */
	private ViewFrame					viewFrame;
	/** The Constant serialVersionUID. */
	private static final long	serialVersionUID	= -998294702363713521L;
	
	JPanel pScoreAndLife = new JPanel();
	
	JPanel pMap = new JPanel();
	
	JLabel jArrayMap[][] = new JLabel[12][20];
	
	private JLabel lLife = new JLabel();
	
	private JLabel lScore = new JLabel();
	
	private String arraySymbol[] = {"b","vb","hb"," "};
	
	private String arrayImageName[] = {"bone","vertical_bone","horizontal_bone","blank"};
	private String arrayNameFile[] = {"sprite","spritePokemon","spriteDBZ","spriteZelda"};
	
	private ArrayList<String> alMap;
	
	private int formerPlayerPosX = -1,formerPlayerPosY = -1;
	
	private int[][] arrayPlayPos;


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
	
	public void setalMap(ArrayList<String> alMap){
		this.alMap = alMap;
		this.loadMap();
		this.buildLifeAndScore();
	}
	
	public void loadMap(){ //le tableau ne peut pas se mettre dans un jPanel c'est bizarre
		int counterX=0, counterY=0;
		for(int i=0;i<240;i++){
			for(int k=0; k<arrayImageName.length;k++){
					if(alMap.get(i).equals(arraySymbol[k])) { this.jArrayMap[counterY][counterX].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+"/"+arrayImageName[k]+".png")); }
	         }
			if(counterX==jArrayMap[0].length-1){
				counterY++;
				counterX=0;
			}
			else { counterX++; }
		}
		this.add(pMap);
	}
	
	public void updateDesign(){
		this.loadMap();
		switch(this.viewFrame.getCurrentWorldID()){
			case 0 :
				this.setBackground(Color.BLACK);
				pScoreAndLife.setBackground(Color.BLACK);
				this.UpdateMap(arrayPlayPos);
				break;
			case 1 :
				this.setBackground(Color.WHITE);
				pScoreAndLife.setBackground(Color.WHITE);
				this.UpdateMap(arrayPlayPos);
				break;
			case 2 :
				this.setBackground(Color.BLACK);
				pScoreAndLife.setBackground(Color.BLACK);
				this.UpdateMap(arrayPlayPos);
				break;
			case 3 :
				this.setBackground(Color.BLACK);
				pScoreAndLife.setBackground(Color.BLACK);
				this.UpdateMap(arrayPlayPos);
				break;
		}
		
	}
	String changeItem;
	public void UpdateMap(int arrayPlayPos[][]){
		this.arrayPlayPos = arrayPlayPos;
		if(formerPlayerPosX != -1 && formerPlayerPosY != -1) {
			System.out.println("x : "+ formerPlayerPosX + " = " + arrayPlayPos[0][0] + "  y : " + formerPlayerPosY + " = " + arrayPlayPos[0][1]);
			if(formerPlayerPosX != arrayPlayPos[0][0] || formerPlayerPosY != arrayPlayPos[0][1]){
				jArrayMap[formerPlayerPosY][formerPlayerPosX].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+"/blank.png"));
			}
		}
		formerPlayerPosX = arrayPlayPos[0][0];
		formerPlayerPosY = arrayPlayPos[0][1];

		for(int i=0; i<arrayPlayPos.length; i++){
			switch(arrayPlayPos[i][2]){
			case 0:
				changeItem="/lorann_b.png";
				break;
			case 1:
				changeItem="/monster_1.png";
				break;
			case 2:
				changeItem="/monster_2.png";
				break;
			case 3:
				changeItem="/monster_3.png";
				break;
			case 4:
				changeItem="/monster_4.png";
				break;
			case 5:
				changeItem="/crystal_ball.png";
				break;
			case 6:
				changeItem="/purse.png";
				break;
			case 7:
				changeItem="/gate_open.png";
				break;
			case 8:
				changeItem="/gate_closed.png";
				break;
			case 9:
				changeItem="/fireball_1.png";
				break;
			case 10:
				changeItem="/fireball_2.png";
				break;
			case 11:
				changeItem="/fireball_3.png";
				break;
			case 12:
				changeItem="/fireball_4.png";
				break;
			case 13:
				changeItem="/fireball_5.png";
				break;
			}
			jArrayMap[arrayPlayPos[i][1]] [arrayPlayPos[i][0]].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+changeItem));
		/*	if(arrayPlayPos[i][2] == 0)       { jArrayMap[arrayPlayPos[i][1]] [arrayPlayPos[i][0]].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+"/lorann_b.png")); }
			else if(arrayPlayPos[i][2] == 1)  { jArrayMap[arrayPlayPos[i][1]] [arrayPlayPos[i][0]].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+"/monster_1.png")); }
			else if(arrayPlayPos[i][2] == 2)  { jArrayMap[arrayPlayPos[i][1]] [arrayPlayPos[i][0]].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+"/monster_2.png")); }
			else if(arrayPlayPos[i][2] == 3)  { jArrayMap[arrayPlayPos[i][1]] [arrayPlayPos[i][0]].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+"/monster_3.png")); }
			else if(arrayPlayPos[i][2] == 4)  { jArrayMap[arrayPlayPos[i][1]] [arrayPlayPos[i][0]].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+"/monster_4.png")); }
			else if(arrayPlayPos[i][2] == 5)  { jArrayMap[arrayPlayPos[i][1]] [arrayPlayPos[i][0]].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+"/crystal_ball.png")); }
			else if(arrayPlayPos[i][2] == 6)  { jArrayMap[arrayPlayPos[i][1]] [arrayPlayPos[i][0]].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+"/purse.png")); }
			else if(arrayPlayPos[i][2] == 7)  { jArrayMap[arrayPlayPos[i][1]] [arrayPlayPos[i][0]].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+"/gate_open.png")); }
			else if(arrayPlayPos[i][2] == 8)  { jArrayMap[arrayPlayPos[i][1]] [arrayPlayPos[i][0]].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+"/gate_closed.png")); }
			else if(arrayPlayPos[i][2] == 9)  { jArrayMap[arrayPlayPos[i][1]] [arrayPlayPos[i][0]].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+"/fireball_1.png")); }
			else if(arrayPlayPos[i][2] == 10) { jArrayMap[arrayPlayPos[i][1]] [arrayPlayPos[i][0]].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+"/fireball_2.png")); }
			else if(arrayPlayPos[i][2] == 11) { jArrayMap[arrayPlayPos[i][1]] [arrayPlayPos[i][0]].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+"/fireball_3.png")); }
			else if(arrayPlayPos[i][2] == 12) { jArrayMap[arrayPlayPos[i][1]] [arrayPlayPos[i][0]].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+"/fireball_4.png")); }
			else if(arrayPlayPos[i][2] == 13) { jArrayMap[arrayPlayPos[i][1]] [arrayPlayPos[i][0]].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+"/fireball_5.png")); }
		*/}
	}
	
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
	 * Gets the view frame.
	 *
	 * @return the view frame
	 */
	private ViewFrame getViewFrame() {
		return this.viewFrame;
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
