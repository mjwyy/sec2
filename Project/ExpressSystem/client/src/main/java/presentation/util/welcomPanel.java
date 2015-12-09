package presentation.util;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

import java.awt.BasicStroke;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Calendar;

public class welcomPanel extends JPanel {
	private welcomPanel thisP = this;

	/**
	 * Create the panel.
	 */
	public welcomPanel() {
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("image/welcome.png"));
		lblNewLabel.setBounds(69, 54, 431, 330);
		add(lblNewLabel);
		
		JLabel lbll = new JLabel("欢迎登陆");
		lbll.setFont(new Font("Rosewood Std", Font.BOLD | Font.ITALIC, 27));
		lbll.setBounds(514, 91, 155, 46);
		add(lbll);
		
		
	}
	
	
}
