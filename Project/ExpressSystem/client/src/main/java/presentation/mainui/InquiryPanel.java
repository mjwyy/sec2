package presentation.mainui;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class InquiryPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public InquiryPanel() {
		setSize(800,720);
		setLayout(null);
		
		
	

	}
	public void paintComponent(Graphics g) {
		 super.paintComponents(g);
		 
		
		 Image img = new ImageIcon("login.png").getImage();
		 g.drawImage(img,0,0,getSize().width,getSize().height,null);
		 g.drawImage(img, 0, 0, null);
		 float lineWidth = 3.0f;
	      ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
	      g.drawLine(800, 0, 800, 720);
		}
}
