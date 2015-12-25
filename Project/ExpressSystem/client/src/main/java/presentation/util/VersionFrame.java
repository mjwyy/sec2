package presentation.util;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;

public class VersionFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VersionFrame frame = new VersionFrame();
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
	public VersionFrame() {
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("开发时间2015年，版本号MinJW2016\n");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		lblNewLabel.setBounds(48, 48, 246, 31);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("开发人员");
		label.setFont(new Font("Lucida Grande", Font.BOLD | Font.ITALIC, 13));
		label.setBounds(48, 96, 82, 16);
		contentPane.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("王梦麟");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel_1.setBounds(48, 124, 94, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel("徐江河");
		label_1.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		label_1.setBounds(139, 131, 61, 16);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("吴秦月");
		label_2.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		label_2.setBounds(223, 131, 61, 16);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("汪文藻");
		label_3.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		label_3.setBounds(294, 131, 61, 16);
		contentPane.add(label_3);
	}
}
