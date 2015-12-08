package presentation.statisticui;

import java.awt.BasicStroke;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JButton;
import javax.swing.JMenuItem;

import presentation.financeui.ChartOutPutPanel;
import presentation.financeui.SystemLogPanel;
import presentation.infoui.StaffManagementPanel;
import presentation.mainui.ManageorgPanel;
import presentation.mainui.loginFrame;
import presentation.util.welcomPanel;
import util.LogInMsg;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ManageFrame extends JFrame {

	private JPanel contentPane;
	private JPanel bankpanel;
    private JPanel welcome;

	/**
	 * 窗口宽度
	 */
	private static final int WIDTH = 1280;
	
	/**
	 * 窗口高度
	 */
	private static final int HEIGHT = 720;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//                    LogInMsg lim;
//                    ManageFrame frame = new ManageFrame(lim);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
	
	private  void setClose() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				int result = JOptionPane.showConfirmDialog( ManageFrame.this, "确认退出？","系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(result == JOptionPane.YES_OPTION) {
					dispose();
					loginFrame lf = new loginFrame();
					lf.setVisible(true);
				} else {
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
	}

	/**
	 * Create the frame.
     * @param lim
     */
	public ManageFrame(LogInMsg lim) {
	
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		this.setResizable(false);//不可调整大小
		setIconImage(Toolkit.getDefaultToolkit().getImage("image/0010.jpg"));
		setTitle("快递物流系统");
		this.setSize(WIDTH, HEIGHT);
		((JComponent) this.getContentPane()).setOpaque(true);//不透明
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation((screenWidth-WIDTH)>>1, (screenHeight-HEIGHT)>>1);
		setClose();
		bankpanel = new JPanel();
		bankpanel.setBounds(138, 125, 1152, 446);
		contentPane.add(bankpanel);
		bankpanel.setLayout(null);
		welcome = new welcomPanel();
		welcome.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		welcome.setBounds(0, 0, 1152, 446);
		bankpanel.add(welcome);
		welcome.setLayout(null);
		
		JPanel panel = new JPanel(){
			public void paintComponent(Graphics g) {
				 super.paintComponent(g);
				 ImageIcon img = new ImageIcon("image/henfu.png");
				 g.drawImage(img.getImage(), 0, 0, null);
				}
				};
		panel.setBounds(0, 0, 1280, 100);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 100, 1280, 25);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(6, 0, 132, 22);
		panel_1.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("系统（S）");
		menuBar.add(mnNewMenu);
		
		JMenu mnf = new JMenu("功能（F）");
		menuBar.add(mnf);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 570, 350, 124);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(347, 570, 933, 124);
		contentPane.add(panel_3);
		
		JButton btnNewButton = new JButton("审批单据");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrderApprove a=new OrderApprove();
				a.setVisible(true);
				welcome.removeAll();
				welcome.add(a);
				welcome.repaint();
			}
			});
		btnNewButton.setBounds(0, 123, 140, 80);
		contentPane.add(btnNewButton);
		
		JMenuBar menuBar_1 = new JMenuBar();
		menuBar_1.setBounds(6, 210, 140, 80);
		contentPane.add(menuBar_1);
		//JButton b = new JButton("管理人员机构");
		//menuBar_1.add(b);
		
		JMenu mnNewMenu_1 = new JMenu("管理人员机构");
		mnNewMenu_1.setBackground(SystemColor.window);
		menuBar_1.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("管理机构");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageorgPanel anot = new  ManageorgPanel(){
					public void paintComponent(Graphics g) {
						 super.paintComponent(g);
						 ImageIcon img = new ImageIcon("image/0111.jpg");
						 g.drawImage(img.getImage(), 0, 0, null);
						 float lineWidth = 3.0f;
					      ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
					      g.drawLine(768, 0, 768, 500);
						}
						}; 
				anot.setBounds(0, 0, 1152, 446);
				bankpanel.removeAll();
				bankpanel.add(anot);
				bankpanel.repaint();
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("管理人员");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 StaffManagementPanel anot = new  StaffManagementPanel(){
					public void paintComponent(Graphics g) {
						 super.paintComponent(g);
						 ImageIcon img = new ImageIcon("image/0111.jpg");
						 g.drawImage(img.getImage(), 0, 0, null);
						 float lineWidth = 3.0f;
					      ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
					      g.drawLine(768, 0, 768, 500);
						}
						}; 
				anot.setBounds(0, 0, 1152, 446);
				bankpanel.removeAll();
				bankpanel.add(anot);
				bankpanel.repaint();	
			}
			
		});
		mnNewMenu_1.add(mntmNewMenuItem_1);
		
		JButton btnNewButton_1 = new JButton("修改业务数据");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModifyBusinessDataPanel anot = new  ModifyBusinessDataPanel(){
						public void paintComponent(Graphics g) {
							 super.paintComponent(g);
							 ImageIcon img = new ImageIcon("image/0111.jpg");
							 g.drawImage(img.getImage(), 0, 0, null);
							 float lineWidth = 3.0f;
						      ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
						      g.drawLine(0, 233,1152 , 233);
							}
							}; 
					anot.setBounds(0, 0, 1152, 446);
					bankpanel.removeAll();
					bankpanel.add(anot);
					bankpanel.repaint();
			}
		});
		btnNewButton_1.setBounds(0, 302, 140, 80);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("查询系统日志");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SystemLogPanel anot = new SystemLogPanel(){
						public void paintComponent(Graphics g) {
							 super.paintComponent(g);
							 ImageIcon img = new ImageIcon("image/0111.jpg");
							 g.drawImage(img.getImage(), 0, 0, null);
							}
							}; 
					anot.setBounds(0, 0, 1152, 446);
					bankpanel.removeAll();
					bankpanel.add(anot);
					bankpanel.repaint();
			}
		});
		button.setBounds(0, 389, 140, 80);
		contentPane.add(button);
		
		JButton btnNewButton_2 = new JButton("获取统计报表");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChartOutPutPanel anot = new ChartOutPutPanel(){
					public void paintComponent(Graphics g) {
						 super.paintComponent(g);
						 ImageIcon img = new ImageIcon("image/0111.jpg");
						 g.drawImage(img.getImage(), 0, 0, null);
						}
						}; 
				anot.setBounds(0, 0, 1152, 446);
				bankpanel.removeAll();
				bankpanel.add(anot);
				bankpanel.repaint();
			}
		});
		btnNewButton_2.setBounds(0, 478, 140, 80);
		contentPane.add(btnNewButton_2);
	}
}
