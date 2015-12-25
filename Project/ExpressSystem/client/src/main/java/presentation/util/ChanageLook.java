package presentation.util;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class ChanageLook  {
	private JPanel panel;
	
	public  ChanageLook(JPanel panel){
		this.panel = panel;
	}

	
public void way() {
	JPanel p = new JPanel(){
		public void paintComponent(Graphics g) {
			 super.paintComponent(g);
			 ImageIcon img = new ImageIcon("image/word.jpg");
			 g.drawImage(img.getImage(), 0, 0, null);
			}
			};
		p.setBounds(0, 0, 1280, 100);
		panel.add(p);
			
	JPanel menu = new JPanel(){
			public void paintComponent(Graphics g) {
				 super.paintComponent(g);
				 ImageIcon img = new ImageIcon("image/caidan.jpg");
				 g.drawImage(img.getImage(), 0, 0, null);
				}
				};
	menu.setBounds(0, 100, 1280, 25);
	panel.add(menu);
	panel.repaint();	
}
			
}
