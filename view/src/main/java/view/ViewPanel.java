package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
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
	
	private BufferedImage imageArray[][];
	
	private BufferedImage background;
	
	//private JPanel pSouth = new JPanel();
	
	private JLabel lLife = new JLabel("Resurections :");


	/**
	 * Instantiates a new view panel.
	 *
	 * @param viewFrame
	 *          the view frame
	 */
	public ViewPanel(final ViewFrame viewFrame) {
		this.setViewFrame(viewFrame);
		viewFrame.getModel().getObservable().addObserver(this);
		this.buildViewPanel();
	}
	
	//public
	
	public void buildViewPanel(){
		imageArray = new BufferedImage[12][20];
		//load les images
		try{
			this.background = ImageIO.read(new File("sprite/fond.png"));
		}catch (IOException e){
			System.err.println("Can't read background");
			e.printStackTrace();
		}
		
		for(int i=0; i<12; i++){
			for(int j=0; j<20; j++){
				try{
					this.imageArray[i][j] = ImageIO.read(new File("sprite/bone.png"));
					/*
					if (arrayString[i][j].equals("b")) { this.imageArray[i][j] = ImageIO.read(new File("sprite/bone.png")); }
					else if (arrayString[i][j].equals("c")) { this.imageArray[i][j] = ImageIO.read(new File("sprite/crystal_ball.png")); }
					else if (arrayString[i][j].equals("f1")) { this.imageArray[i][j] = ImageIO.read(new File("sprite/fireball_1.png")); }
					else if (arrayString[i][j].equals("f2")) { this.imageArray[i][j] = ImageIO.read(new File("sprite/fireball_2.png")); }
					else if (arrayString[i][j].equals("f3")) { this.imageArray[i][j] = ImageIO.read(new File("sprite/fireball_3.png")); }
					else if (arrayString[i][j].equals("f4")) { this.imageArray[i][j] = ImageIO.read(new File("sprite/fireball_4.png")); }
					else if (arrayString[i][j].equals("f5")) { this.imageArray[i][j] = ImageIO.read(new File("sprite/fireball_5.png")); }
					else if (arrayString[i][j].equals("gc")) { this.imageArray[i][j] = ImageIO.read(new File("sprite/gate_closed.png")); }
					else if (arrayString[i][j].equals("go")) { this.imageArray[i][j] = ImageIO.read(new File("sprite/gate_open.png")); }
					else if (arrayString[i][j].equals("lb")) { this.imageArray[i][j] = ImageIO.read(new File("sprite/lorann_b.png")); }
					else if (arrayString[i][j].equals("lbl")) { this.imageArray[i][j] = ImageIO.read(new File("sprite/loran_lbl.png")); }
					else if (arrayString[i][j].equals("lbr")) { this.imageArray[i][j] = ImageIO.read(new File("sprite/lorann_lbr.png")); }
					else if (arrayString[i][j].equals("lbu")) { this.imageArray[i][j] = ImageIO.read(new File("sprite/loran_lu.png")); }
					else if (arrayString[i][j].equals("lul")) { this.imageArray[i][j] = ImageIO.read(new File("sprite/lorann_lul.png")); }
					else if (arrayString[i][j].equals("lur")) { this.imageArray[i][j] = ImageIO.read(new File("sprite/loran_lur.png")); }
					else if (arrayString[i][j].equals("ll")) { this.imageArray[i][j] = ImageIO.read(new File("sprite/lorann_ll.png")); }
					else if (arrayString[i][j].equals("lr")) { this.imageArray[i][j] = ImageIO.read(new File("sprite/loran_lr.png")); }
					else if (arrayString[i][j].equals("m1")) { this.imageArray[i][j] = ImageIO.read(new File("sprite/monster_1.png")); }
					else if (arrayString[i][j].equals("m2")) { this.imageArray[i][j] = ImageIO.read(new File("sprite/monster_2.png")); }
					else if (arrayString[i][j].equals("m3")) { this.imageArray[i][j] = ImageIO.read(new File("sprite/monster_3.png")); }
					else if (arrayString[i][j].equals("m4")) { this.imageArray[i][j] = ImageIO.read(new File("sprite/monster_4.png")); }
					else if (arrayString[i][j].equals("p")) { this.imageArray[i][j] = ImageIO.read(new File("sprite/purse.png")); }
					else if (arrayString[i][j].equals("vb")) { this.imageArray[i][j] = ImageIO.read(new File("sprite/vertical_bone.png")); }
					else if (arrayString[i][j].equals("hb")) { this.imageArray[i][j] = ImageIO.read(new File("sprite/horizontal_bone.png")); }
					*/
				}
				catch (IOException e){
					System.err.println("Can't read images");
	                e.printStackTrace();
	            }
			}
		}
		 //marche pas
		this.lLife.setAlignmentY(50);
		this.lLife.setAlignmentX(50);
		this.add(lLife);
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

	/*
	 * (non-Javadoc)
	 *
	 * @see javax.swing.JComponent#paintComponent(java.awt.Graphics)
	 */
	@Override
	protected void paintComponent(final Graphics graphics) {
		//graphics.clearRect(0, 0, this.getWidth(), this.getHeight());
		//graphics.drawString(this.getViewFrame().getModel().getMessage(), 10, 20);
		Graphics2D g2 = (Graphics2D)graphics ;
		g2.drawImage(this.background,0,0,null);
		
		int placeX = 10, placeY = 10;
		for(int i = 0; i<this.imageArray.length; i++) {
			for(int j=0; j<imageArray[0].length; j++){
	            g2.drawImage(this.imageArray[i][j],placeX,placeY, null);
	            placeX += 32;
			}
			placeX = 10;
			placeY += 32;
        }
        
	}
}
