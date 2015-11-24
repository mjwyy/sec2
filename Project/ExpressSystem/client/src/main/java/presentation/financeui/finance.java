package presentation.financeui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JMenuItem;
import javax.swing.JSeparator;
import javax.swing.JSplitPane;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Component;

import javax.swing.Box;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JButton;

public class finance extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					finance frame = new finance();
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
	public finance() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 460);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 780, 33);
		panel.setBackground(Color.PINK);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("我是小图片");
		lblNewLabel_1.setBounds(6, 6, 131, 16);
		panel.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 33, 780, 22);
		panel_1.setBackground(Color.YELLOW);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(6, 0, 132, 22);
		panel_1.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("系统（S）");
		menuBar.add(mnNewMenu);
		
		JMenu mnf = new JMenu("功能（F）");
		menuBar.add(mnf);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 388, 790, 50);
		panel_3.setBackground(Color.MAGENTA);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(0, 0, 243, 211);
		panel_3.add(panel_7);
		panel_7.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("系统公告");
		lblNewLabel.setBounds(0, 0, 354, 39);
		panel_7.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 54, 110, 335);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(0, 5, 102, 38);
		panel_2.add(menuBar_1);
		
		JMenu menu = new JMenu("日常结算管理");
		menuBar_1.add(menu);
		
		
		JMenuItem menuItem = new JMenuItem("录入付款单");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    PaymentInputPanel p = new PaymentInputPanel();
			    p.setBounds(109, 54, 671, 335);
			    contentPane.add(p);
			    p.setLayout(null);
			   // contentPane.repaint(109, 54, 671, 335);
			    contentPane.repaint();
			}
		});
	
		
		menu.add(menuItem);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("结算管理");
		menu.add(mntmNewMenuItem);
		
		JMenuBar menuBar_2 = new JMenuBar();
		menuBar_2.setBounds(0, 105, 102, 38);
		panel_2.add(menuBar_2);
		
		JMenu mnNewMenu_1 = new JMenu("查询与统计");
		menuBar_2.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("查看系统日志");
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JMenuItem menuItem_1 = new JMenuItem("获取统计报表");
		mnNewMenu_1.add(menuItem_1);
		
		JMenuBar menuBar_3 = new JMenuBar();
		menuBar_3.setBounds(0, 205, 102, 38);
		panel_2.add(menuBar_3);
		
		JMenu mnNewMenu_2 = new JMenu("财务信息管理");
		menuBar_3.add(mnNewMenu_2);
		
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("银行账户管理");
		mnNewMenu_2.add(mntmNewMenuItem_2);
		
		JMenuItem menuItem_2 = new JMenuItem("期初建账");
		mnNewMenu_2.add(menuItem_2);
		
		//Border border = new EtchedBorder(EtchedBorder.RAISED);
	    panel_2.setBorder(new EtchedBorder(EtchedBorder.RAISED));
	    panel_7.setBorder(new EtchedBorder(EtchedBorder.RAISED));
	    
	   
	

		
		
		
	}
}
