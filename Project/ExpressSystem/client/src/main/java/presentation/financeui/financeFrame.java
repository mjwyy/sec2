package presentation.financeui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import businesslogic.statistic.BaseDataBuilding;
import businesslogicservice.statisticblservice.BaseDataBuildingBLService;
import presentation.logisticui.Car;
import presentation.logisticui.CourierFrame;
import presentation.mainui.ManageorgPanel;
import presentation.mainui.loginFrame;
import presentation.util.welcomPanel;
import util.LogInMsg;
import util.ResultMsg;

import javax.swing.JLabel;
import javax.swing.JMenuItem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
//财务的panel监听待加
public class financeFrame extends JFrame {

	private JPanel contentPane;
	private JPanel bankpanel;
	private welcomPanel welcome;
	private LogInMsg  lim;
	private BaseDataBuildingBLService service;
	private PaymentInputPanel paymentInputPanel;
	private JPanel leftdown;
	private JLabel jiesuanWait;
	private JLabel jiesuanTongguo;
	private JLabel jiesuanBu;
	
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
	public static void main(String[] args) {
		//EventQueue.invokeLater(new Runnable() {
			/*public void run() {
				try {
					 financeFrame.changeLook();
					 financeFrame.changeFont();
					 
					financeFrame frame = new financeFrame();
					frame.setClose();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}*/
		//});
	}
	
	private static void changeLook() {
	    try {
	    	BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencySmallShadow;
	        org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
	        // 关闭右上角设置
	       UIManager.put("RootPane.setupButtonVisible", false);
	    } catch(Exception e) {
	    }
	}
	
	private static void changeFont() {
		Font font = new Font("微软雅黑", Font.PLAIN, 15);   
		@SuppressWarnings("rawtypes")
		java.util.Enumeration keys = UIManager.getDefaults().keys();   
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();   
		    Object value = UIManager.get(key);    
		    if (value instanceof javax.swing.plaf.FontUIResource) {
		    	UIManager.put(key, font);     
		    } 
		} 
	}
	
	public  void setClose() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				int result = JOptionPane.showConfirmDialog( financeFrame.this, "确认退出？","系统提示",
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
	public financeFrame(LogInMsg limm) {
	    lim = limm;
		setSize(WIDTH,HEIGHT);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setClose();
		this.setResizable(false);//不可调整大小
		setTitle("MinJW物流管理系统");
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel(){
			public void paintComponent(Graphics g) {
				 super.paintComponent(g);
				 ImageIcon img = new ImageIcon("image/henfu.png");
				 g.drawImage(img.getImage(), 0, 0, null);
				}
				};
		panel.setBounds(0, 0, 1280, 100);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 100, 1280, 25);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		bankpanel = new JPanel();
		bankpanel.setBounds(138, 125, 1152, 446);
		contentPane.add(bankpanel);
		bankpanel.setLayout(null);
		welcome = new welcomPanel();
		welcome.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		welcome.setBounds(0, 0, 1152, 446);
		bankpanel.add(welcome);
		welcome.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(6, 0, 132, 22);
		panel_1.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("系统（S）");
		menuBar.add(mnNewMenu);
		
		JMenu mnf = new JMenu("功能（F）");
		menuBar.add(mnf);
		
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 570, 350, 124);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("姓名：");
		label.setBounds(6, 19, 77, 16);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("机构：");
		label_1.setBounds(6, 70, 61, 16);
		panel_2.add(label_1);
		
		JLabel lblNewLabel = new JLabel(lim.getUserName());
		lblNewLabel.setBounds(95, 19, 226, 27);
		panel_2.add(lblNewLabel);
		
		JLabel label_2 = new JLabel(lim.getOrganization());
		label_2.setBounds(95, 70, 226, 27);
		panel_2.add(label_2);
		
		leftdown = new JPanel();
		leftdown.setBounds(347, 570, 933, 124);
		leftdown.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		contentPane.add(leftdown);
		leftdown.setLayout(null);
		
	    jiesuanWait = new JLabel("付款记录已去审批，请耐心等待");
		jiesuanWait.setBounds(19, 24, 718, 37);
		leftdown.add(jiesuanWait);
		jiesuanWait.setVisible(false);
		
		jiesuanTongguo = new JLabel("付款记录通过审批了，可以填下一份了");
		jiesuanTongguo .setBounds(19, 24, 718, 37);
		leftdown.add(jiesuanTongguo );
		jiesuanTongguo .setVisible(false);
		
		jiesuanBu = new JLabel("付款记录通过审批了，可以填下一份了");
		jiesuanBu .setBounds(19, 24, 718, 37);
		leftdown.add(jiesuanBu );
		jiesuanBu .setVisible(false);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 140, 137, 89);
		contentPane.add(panel_4);
		
		JMenuBar menuBar_1 = new JMenuBar();
		panel_4.add(menuBar_1);
		
		JMenu mnNewMenu_1 = new JMenu("日常财务处理");
		menuBar_1.add(mnNewMenu_1);
		
		JMenuItem menuItem = new JMenuItem("录入付款单");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PaymentInputPanel pip = new PaymentInputPanel(lim,financeFrame.this){
					public void paintComponent(Graphics g) {
						 super.paintComponent(g);
						 ImageIcon img = new ImageIcon("image/0111.jpg");
						 g.drawImage(img.getImage(), 0, 0, null);
						}
						};
				bankpanel.removeAll();
				bankpanel.add(pip);
				bankpanel.repaint();
			}
		});
		mnNewMenu_1.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("结算管理");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SettlementMangePanel smp = new SettlementMangePanel(){
					public void paintComponent(Graphics g) {
						 super.paintComponent(g);
						 ImageIcon img = new ImageIcon("image/0111.jpg");
						 g.drawImage(img.getImage(), 0, 0, null);
						 float lineWidth = 3.0f;
					      ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
					      g.drawLine(768, 0, 768, 500);
						}
						};
				bankpanel.removeAll();
				bankpanel.add(smp);
				bankpanel.repaint();
			}
		});
		mnNewMenu_1.add(menuItem_1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 282, 137, 89);
		contentPane.add(panel_5);
		
		JMenuBar menuBar_2 = new JMenuBar();
		panel_5.add(menuBar_2);
		
		JMenu mnNewMenu_2 = new JMenu("统计与查询");
		menuBar_2.add(mnNewMenu_2);
		
		JMenuItem menuItem_2 = new JMenuItem("查询系统日志");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 SystemLogPanel slp = new  SystemLogPanel(){
					public void paintComponent(Graphics g) {
						 super.paintComponent(g);
						 ImageIcon img = new ImageIcon("image/0111.jpg");
						 g.drawImage(img.getImage(), 0, 0, null);
						 float lineWidth = 3.0f;
					      ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
					      g.drawLine(0, 110, 1152, 110);
						}
						};
				bankpanel.removeAll();
				bankpanel.add(slp);
				bankpanel.repaint();		
			}
		});
		mnNewMenu_2.add(menuItem_2);
		
		JMenuItem menuItem_3 = new JMenuItem("生成统计报表");
		menuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChartOutPutPanel copp = new  ChartOutPutPanel(){
						public void paintComponent(Graphics g) {
							 super.paintComponent(g);
							 ImageIcon img = new ImageIcon("image/0111.jpg");
							 g.drawImage(img.getImage(), 0, 0, null);
							 float lineWidth = 3.0f;
						      ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
						      g.drawLine(920, 0, 920, 100);
						      g.drawLine(0, 100, 1152, 100);
							}
							};
					bankpanel.removeAll();
					bankpanel.add(copp);
					bankpanel.repaint();	
			}
		});
		mnNewMenu_2.add(menuItem_3);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 431, 137, 89);
		contentPane.add(panel_6);
		
		JMenuBar menuBar_3 = new JMenuBar();
		panel_6.add(menuBar_3);
		
		JMenu mnNewMenu_3 = new JMenu("财务信息管理");
		menuBar_3.add(mnNewMenu_3);
		
		JMenuItem menuItem_4 = new JMenuItem("管理银行账户");
		menuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BankAccountManagePanel bamp = new BankAccountManagePanel(){
					public void paintComponent(Graphics g) {
						 super.paintComponent(g);
						 ImageIcon img = new ImageIcon("image/0111.jpg");
						 g.drawImage(img.getImage(), 0, 0, null);
						 float lineWidth = 3.0f;
					      ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
					      g.drawLine(768, 0, 768, 500);
						}
						};
				bankpanel.removeAll();
				bankpanel.add(bamp);
				bankpanel.repaint();
			}
		});
				
		mnNewMenu_3.add(menuItem_4);
		
		JMenuItem menuItem_5 = new JMenuItem("有基础期初建账");
		menuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BaseDataBuildingPanel bdbp = new BaseDataBuildingPanel(){
					public void paintComponent(Graphics g) {
						 super.paintComponent(g);
						 ImageIcon img = new ImageIcon("image/0111.jpg");
						 g.drawImage(img.getImage(), 0, 0, null);
						}
						};
				bankpanel.removeAll();
				bankpanel.add(bdbp);
				bankpanel.repaint();		
				service = new BaseDataBuilding();
				service.restartWithBasis();
				if(!service.restartWithBasis().isPass()){
					int result1 = JOptionPane.showConfirmDialog(null, service.restartWithBasis().getMessage(),"系统提示",
							JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);
				}
				
				
			}
		});
		mnNewMenu_3.add(menuItem_5);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("无基础期初建账");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BaseDataBuildingPanel bdbp = new BaseDataBuildingPanel(){
					public void paintComponent(Graphics g) {
						 super.paintComponent(g);
						 ImageIcon img = new ImageIcon("image/0111.jpg");
						 g.drawImage(img.getImage(), 0, 0, null);
						}
						};
				bankpanel.removeAll();
				bankpanel.add(bdbp);
				bankpanel.repaint();
				
				
				service = new BaseDataBuilding();
				service.restartWithoutBasis();
				
				if(!service.restartWithoutBasis().isPass()){
					int result1 = JOptionPane.showConfirmDialog(null, service.restartWithoutBasis().getMessage(),"系统提示",
							JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);
				}
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem);	
	}


	public void setPaymentInputPanel(PaymentInputPanel paymentInputPanel) {
		this.paymentInputPanel = paymentInputPanel;
	}
	
	public void setLeftdown(boolean dengdai,boolean tongguo,boolean butongguo) {
		jiesuanWait.setVisible(dengdai);
		jiesuanTongguo.setVisible(tongguo);
		jiesuanBu.setVisible(butongguo);
	}
}
