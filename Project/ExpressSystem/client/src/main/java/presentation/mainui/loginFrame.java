package presentation.mainui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import presentation.util.checkstyleDialog;
import businesslogicservice.infoblservice.SystemUserManagementBLService;
import businesslogicservice.infoblservice._stub.SystemUserManagementBLService_Stub;
import util.LogInMsg;
import util.enums.Authority;
import vo.UserVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class loginFrame extends JFrame {
//查询的监听还木有写，图片没加上去
	private JPanel contentPane;
	private JTextField account;
	private JTextField password;
	private JTextField textField_2;
	private LogInMsg lim;
	private SystemUserManagementBLService service;
	private Authority authority;
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					loginFrame frame = new loginFrame();
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
	public loginFrame() {
		setSize(1280,720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		InquiryPanel panel = new InquiryPanel();
		panel.setBounds(0, 0, 800, 720);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label_2 = new JLabel("订单号");
		label_2.setBounds(158, 462, 61, 16);
		panel.add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setBounds(231, 456, 375, 28);
		panel.add(textField_2);
		textField_2.setColumns(10);
		
		JButton button_1 = new JButton("查询");
		button_1.setBounds(561, 542, 117, 29);
		panel.add(button_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(800, 0, 480, 720);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("client/image/logo.png"));
		label.setBounds(70, 82, 385, 102);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("帐号");
		label_1.setBounds(102, 248, 61, 16);
		panel_1.add(label_1);
		
		account = new JTextField();
		account.setBounds(197, 239, 258, 34);
		panel_1.add(account);
		account.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("密码");
		lblNewLabel.setBounds(102, 321, 61, 16);
		panel_1.add(lblNewLabel);
		
		password = new JTextField();
		password.setBounds(197, 315, 258, 34);
		panel_1.add(password);
		password.setColumns(10);
		
		final JLabel red = new JLabel("帐号或者密码有误，请检查重新输入");
		red.setForeground(Color.RED);
		red.setBounds(207, 362, 248, 16);
		red.setVisible(false);
		panel_1.add(red);
		
		JButton button = new JButton("登录");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				service = new SystemUserManagementBLService_Stub ();
				lim = service.logIn(account.getText(), password.getText());
				if(lim.isPass()){
					
					if(lim.getAuthority().equals(authority.MANAGER));
					else if(lim.getAuthority().equals(authority.ACCOUNTANT_HIGH));
					else if(lim.getAuthority().equals(authority.ACCOUNTANT_LOW));
					else if(lim.getAuthority().equals(authority.WAREHOUSE_MANAGER));
					else if(lim.getAuthority().equals(authority.DELIVERY_MAN));
					else;
					
					setVisible(false);
					
					
					
				}else{
					red.setVisible(true);
				}
				
			}
		});
		button.setBounds(357, 540, 117, 29);
		panel_1.add(button);	
	
}

}

