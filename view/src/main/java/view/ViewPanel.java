package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
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


	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
		this.setLayout(new BorderLayout());
		//this.setBackground(Color.BLACK);
		pMap.setPreferredSize(new Dimension(640,384));
		pScoreAndLife.setPreferredSize(new Dimension(485,30));
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
					if(counterX==jArrayMap.length-1){
						counterY++;
						counterX=0;
					}
	         }
		}
		this.add(pMap,BorderLayout.CENTER);
	}
	
	public void UpdateMap(int arrayPlayPos[][]){
		for(int i=0; i<arrayPlayPos.length; i++){
			if(arrayPlayPos[i][2] == 0) { jArrayMap[arrayPlayPos[i][0]] [arrayPlayPos[i][1]].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+"/lorann_b.png")); }
			else if(arrayPlayPos[i][2] == 1) { jArrayMap[arrayPlayPos[i][0]] [arrayPlayPos[i][1]].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+"/monster_1.png")); }
			else if(arrayPlayPos[i][2] == 2) { jArrayMap[arrayPlayPos[i][0]] [arrayPlayPos[i][1]].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+"/monster_2.png")); }
			else if(arrayPlayPos[i][2] == 3) { jArrayMap[arrayPlayPos[i][0]] [arrayPlayPos[i][1]].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+"/monster_3.png")); }
			else if(arrayPlayPos[i][2] == 4) { jArrayMap[arrayPlayPos[i][0]] [arrayPlayPos[i][1]].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+"/monster_4.png")); }
			else if(arrayPlayPos[i][2] == 5) { jArrayMap[arrayPlayPos[i][0]] [arrayPlayPos[i][1]].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+"/crystal_ball.png")); }
			else if(arrayPlayPos[i][2] == 6) { jArrayMap[arrayPlayPos[i][0]] [arrayPlayPos[i][1]].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+"/purse.png")); }
			else if(arrayPlayPos[i][2] == 7) { jArrayMap[arrayPlayPos[i][0]] [arrayPlayPos[i][1]].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+"/gate_open.png")); }
			else if(arrayPlayPos[i][2] == 8) { jArrayMap[arrayPlayPos[i][0]] [arrayPlayPos[i][1]].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+"/gate_closed.png")); }
			else if(arrayPlayPos[i][2] == 9) { jArrayMap[arrayPlayPos[i][0]] [arrayPlayPos[i][1]].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+"/fireball_1.png")); }
			else if(arrayPlayPos[i][2] == 10) { jArrayMap[arrayPlayPos[i][0]] [arrayPlayPos[i][1]].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+"/fireball_2.png")); }
			else if(arrayPlayPos[i][2] == 11) { jArrayMap[arrayPlayPos[i][0]] [arrayPlayPos[i][1]].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+"/fireball_3.png")); }
			else if(arrayPlayPos[i][2] == 12) { jArrayMap[arrayPlayPos[i][0]] [arrayPlayPos[i][1]].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+"/fireball_4.png")); }
			else if(arrayPlayPos[i][2] == 13) { jArrayMap[arrayPlayPos[i][0]] [arrayPlayPos[i][1]].setIcon(new ImageIcon(arrayNameFile[this.viewFrame.getCurrentWorldID()]+"/fireball_5.png")); }
		}
	}
	
	public void buildLifeAndScore(){
		//pScoreAndLife.setLayout();
		//this.setLayout(new BorderLayout());
		pScoreAndLife.setBackground(Color.BLACK);
		Font font = new Font("Tahoma", Font.BOLD, 20);
		lLife.setFont(font);
		lLife.setText("<html><font color = #1E7FCB >Resurections : 00</font></html>");
		//lLife.setLocation(10,10);
		lScore.setFont(font);
		lScore.setText("<html><font color = #F0C300 >Score : 00000000</font></html>");
		//lScore.setLocation(10,300);
		pScoreAndLife.add(lLife);
		pScoreAndLife.add(lScore);
		this.add(pScoreAndLife, BorderLayout.SOUTH);
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
