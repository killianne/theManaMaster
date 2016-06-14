package view;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
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
	
	public void buildViewPanel(){
		imageArray = new BufferedImage[12][20];
		//load les images
		/*
		for(int i=0; i<12; i++){
			for(int j=0; j<20; j++){
				try{
					//this.imageArray[i][j] = ImageIO.read(new File("/masterpom/sprite/bone.png"));
				}
				catch (IOException e){
	                e.printStackTrace();
	            }
			}
		}
		*/
		
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
		/*
		int placeX = 10, placeY = 10;
		for(int i = 0; i<this.imageArray.length; i++) {
			for(int j=0; j<imageArray[0].length; j++){
				Graphics2D g2 = (Graphics2D)graphics ;
	            g2.drawImage(this.imageArray[i][j],placeX,placeY, null);
	            placeX += 33;
			}
			placeY += 33;
        }
        */
	}
}
