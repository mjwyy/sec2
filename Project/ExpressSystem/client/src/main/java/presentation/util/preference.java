package presentation.util;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class preference extends JFrame {

	private JPanel contentPane;
	private JButton button;
	private JButton button_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					preference frame = new preference();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public preference() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation((screenWidth-450)>>1, (screenHeight-300)>>1);
		//setBounds(100, 100, 450, 300);
		setSize(450,300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("image/cat.jpg"));
		lblNewLabel.setBounds(16, 37, 207, 116);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon("image/bule.jpg"));
		lblNewLabel_1.setBounds(235, 37, 207, 116);
		contentPane.add(lblNewLabel_1);
		
		 button = new JButton("喵喵可爱版");
		button.setBounds(6, 202, 129, 29);
		contentPane.add(button);
		
	    button_1 = new JButton("蓝色经典版");
		button_1.setBounds(245, 202, 117, 29);
		contentPane.add(button_1);
	}
	
	public JButton getButtton() {
		return button;
	}
	
	public JButton getButton1() {
		return  button_1;
	}
}
