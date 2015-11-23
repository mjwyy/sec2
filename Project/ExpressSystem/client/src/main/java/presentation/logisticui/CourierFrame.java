package presentation.logisticui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.EtchedBorder;

public class CourierFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CourierFrame frame = new CourierFrame();
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
	public CourierFrame() {
		setSize(1280,720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1280, 100);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_1.setBounds(0, 100, 1280, 25);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(138, 125, 1152, 446);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_3.setBounds(347, 570, 933, 124);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_4.setBounds(0, 570, 350, 124);
		contentPane.add(panel_4);
		
		JButton btnNewButton = new JButton("登记寄件单");
		btnNewButton.setBounds(0, 123, 140, 152);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("录入收件单");
		button.setBounds(0, 272, 140, 152);
		contentPane.add(button);
		
		JButton button_1 = new JButton("查询订单信息");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button_1.setBounds(0, 421, 140, 152);
		contentPane.add(button_1);
	}
}
