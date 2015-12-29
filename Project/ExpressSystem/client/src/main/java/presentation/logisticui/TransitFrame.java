package presentation.logisticui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.io.File;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import connection.ConnectionChecker;
import presentation.mainui.loginFrame;
import presentation.util.ChanageLook;
import presentation.util.VersionFrame;
import presentation.util.preference;
import presentation.util.welcomPanel;
import util.LogInMsg;
import vo.ArrivalNoteOnTransitVO;
import vo.LoadNoteOnTransitVO;
import vo.TransitNoteOnTransitVO;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JMenuItem;

public class TransitFrame extends JFrame {

	private JPanel contentPane;
	private welcomPanel welcome;
    private JPanel bankpanel;
    private ArrivalNoteOnTransitVO arrivalNoteOnTransitVO;
    private LoadNoteOnTransitVO loadNoteOnTransitVO;
    private TransitNoteOnTransitVO transitNoteOnTransitVO;
    private LogInMsg  lim;
    private String userInfo;
    public JPanel leftdown;
	private  JLabel daoda;
	private  JLabel daodB;
	private  JLabel zhuangche;
	private  JLabel zhongzhuan;
	private  JLabel daodaA;
	private  JLabel zhuangcheA;
	private  JLabel zhuangcheB;
	private  JLabel zhongzhuanA;
	private  JLabel zhongzhuanB;
	private ArrivalNoteOnTransitPanel arrivalNoteOnTransitpanel;
	private LoadNoteOnTransitPanel loadNoteOnTransitpanel;
	private TransitNoteInputPanel transitNoteInputpanel;
	private JPanel panel;
	/**
	 * 窗口宽度
	 */
	private static final int WIDTH = 1280;
	
	/**
	 * 窗口高度
	 */
	private static final int HEIGHT = 720;
	protected static final String transitNoteInputPanel = null;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//TransitFrame.changeLook();
					//TransitFrame frame = new TransitFrame();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
				int result = JOptionPane.showConfirmDialog( TransitFrame.this, "确认退出？","系统提示",
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
	
	public void zhuxiao() {
		int result = JOptionPane.showConfirmDialog( TransitFrame.this, "确认退出？","系统提示",
				JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(result == JOptionPane.YES_OPTION) {
			dispose();
			loginFrame lf = new loginFrame();
			lf.setVisible(true);
		} else {
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		}
	}

	/**
	 * Create the frame.
	 */
	public TransitFrame( LogInMsg logInMsg ) {
		ConnectionChecker c = new ConnectionChecker();
		 c.start();
		setResizable(false);
		lim = logInMsg;
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
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
		
		 panel = new JPanel(){
			public void paintComponent(Graphics g) {
				 super.paintComponent(g);
				 ImageIcon img = new ImageIcon("image/henfu.png");
				 g.drawImage(img.getImage(), 0, 0, null);
				}
				};
		panel.setBounds(0, 0, 1280, 100);
		contentPane.add(panel);
		panel.setLayout(null);
		
		
		
		JLabel lblL = new JLabel();
		lblL.setBounds(1075, 280, 0, 0);
		panel.add(lblL);
		
		
		JPanel panel_2 = new JPanel();
	
		panel_2.setBounds(0, 570, 350, 124);
		panel_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("姓名：");
		label.setBounds(16, 16, 61, 16);
		panel_2.add(label);
		
		JLabel label_1 = new JLabel("机构：");
		label_1.setBounds(16, 62, 61, 16);
		panel_2.add(label_1);
		
		JLabel lblNewLabel = new JLabel(lim.getUserName());
		lblNewLabel.setBounds(72, 16, 166, 16);
		panel_2.add(lblNewLabel);
		
		JLabel lblNewLabel_2 = new JLabel(lim.getOrganization());
		lblNewLabel_2.setBounds(71, 62, 187, 16);
		panel_2.add(lblNewLabel_2);
		
	
		
		
		
		leftdown = new JPanel();
		leftdown.setBounds(347, 570, 933, 124);
		contentPane.add(leftdown);
		leftdown.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.LIGHT_GRAY, Color.GRAY));
		leftdown.setLayout(null);
		
		JButton button = new JButton("查看中转单");
		button.setBounds(560, 89, 117, 29);
		button.setVisible(false);
		leftdown.add(button);
		
		JButton button_1 = new JButton("查看到达单");
		button_1.setBounds(435, 89, 117, 29);
		button_1.setVisible(false);
		leftdown.add(button_1);
		
		JButton button_2 = new JButton("查看装车单");
		button_2.setBounds(689, 89, 117, 29);
		button_2.setVisible(false);
		leftdown.add(button_2);
		
		
		JButton btnNewButton = new JButton("录入到达单");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(arrivalNoteOnTransitpanel == null){
				ArrivalNoteOnTransitPanel anot = new ArrivalNoteOnTransitPanel(lim,TransitFrame.this){
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
				}else{
					arrivalNoteOnTransitpanel.setBounds(0, 0, 1152, 446);
					bankpanel.removeAll();
					bankpanel.add(arrivalNoteOnTransitpanel);
					bankpanel.repaint();
				}
				
			}
		});
		btnNewButton.setBounds(0, 123, 140, 152);
		contentPane.add(btnNewButton);
		
		
		JButton btnNewButton_1 = new JButton("录入中转单");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(transitNoteInputpanel == null ){
			TransitNoteInputPanel tni = new TransitNoteInputPanel( lim,TransitFrame.this){
				public void paintComponent(Graphics g) {
					 super.paintComponent(g);
					 ImageIcon img = new ImageIcon("image/0111.jpg");
					 g.drawImage(img.getImage(), 0, 0, null);
					 float lineWidth = 3.0f;
				      ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
				      g.drawLine(768, 0, 768, 500);
					}
					}; 
			tni.setBounds(0, 0, 1152, 446);
			bankpanel.removeAll();
			bankpanel.add(tni);
			bankpanel.repaint();
		    }else{
					transitNoteInputpanel.setBounds(0, 0, 1152, 446);
					bankpanel.removeAll();
					bankpanel.add(transitNoteInputpanel);
					bankpanel.repaint();
				}
			
			}
		});
		btnNewButton_1.setBounds(0, 272, 140, 152);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("录入装车单");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(loadNoteOnTransitpanel == null){
				LoadNoteOnTransitPanel lnot = new LoadNoteOnTransitPanel( lim,TransitFrame.this){
					public void paintComponent(Graphics g) {
						 super.paintComponent(g);
						 ImageIcon img = new ImageIcon("image/0111.jpg");
						 g.drawImage(img.getImage(), 0, 0, null);
						 float lineWidth = 3.0f;
					      ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
					      g.drawLine(768, 0, 768, 500);
						}
						}; 
				lnot.setBounds(0, 0, 1152, 446);
				bankpanel.removeAll();
				bankpanel.add(lnot);
				bankpanel.repaint();
			}else{
				loadNoteOnTransitpanel.setBounds(0, 0, 1152, 446);
				bankpanel.removeAll();
				bankpanel.add(loadNoteOnTransitpanel);
				bankpanel.repaint();
			}
			}
		});
		btnNewButton_2.setBounds(0, 420, 140, 152);
		contentPane.add(btnNewButton_2);
		
		daoda = new JLabel("您提交的到达单已通过审批,现在可以填下一份了哟");
		daoda.setBounds(21, 10, 487, 24);
		leftdown.add(daoda);
		daoda.setVisible(false);
		daodaA = new JLabel("您提交的到达单未通过审批,请前去修改哦～");
		daodaA.setForeground(Color.red);
		daodaA.setBounds(21, 10, 487, 24);
		daodaA.setVisible(false);
		leftdown.add(daodaA);
		daodB = new JLabel("您提交的到达单正在等待审批哦，请耐心等待哦~");
		daodB.setBounds(21, 10, 487, 24);
		daodB.setVisible(false);
		leftdown.add(daodB);
		
		zhongzhuan = new JLabel("您提交的中转单单已通过审批,现在可以填下一份了哟");
		zhongzhuan.setBounds(21, 58, 487, 24);
		zhongzhuan.setForeground(Color.red);
		zhongzhuan.setVisible(false);
		leftdown.add(zhongzhuan);
		
		zhongzhuanA = new JLabel("您提交的中转单审批未通过,请前去修改哦～");
		zhongzhuanA.setForeground(Color.red);
		zhongzhuanA.setBounds(21, 58, 487, 24);
		zhongzhuanA.setVisible(false);
		leftdown.add(zhongzhuanA);
		
		zhongzhuanB = new JLabel("您提交的中转单正在等待审批哦，请耐心等待哦~");
		zhongzhuanB.setBounds(21, 58, 487, 24);
		zhongzhuanB.setForeground(Color.red);
		zhongzhuanB.setVisible(false);
		leftdown.add(zhongzhuanB);
		
		zhuangche = new JLabel("您提交的装车单已通过审批,现在可以填下一份了哟");
		zhuangche.setBounds(21, 35, 487, 24);
		zhuangche.setVisible(false);
		leftdown.add(zhuangche);
		
		zhuangcheA = new JLabel("您提交的装车单审批未通过,请前去修改哦～");
		zhuangcheA.setForeground(Color.red);
		zhuangcheA.setBounds(21, 35, 487, 24);
		zhuangcheA.setVisible(false);
		leftdown.add(zhuangcheA);
		
		zhuangcheB = new JLabel("您提交的装车正在等待审批哦，请耐心等待哦~");
		zhuangcheB.setBounds(21, 35, 487, 24);
		zhuangcheB.setVisible(false);
		leftdown.add(zhuangcheB);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 100, 1280, 25);
		contentPane.add(panel_1);
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		panel_1.setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(6, 0, 132, 22);
		panel_1.add(menuBar);
		
		JMenu mnNewMenu = new JMenu("功能（F）");
		menuBar.add(mnNewMenu);
		
		JMenuItem menuItem = new JMenuItem("个性化");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final preference pf = new preference();
				pf.setVisible(true);
				pf.getButtton().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					JPanel p = new JPanel(){
							public void paintComponent(Graphics g) {
								 super.paintComponent(g);
								 ImageIcon img = new ImageIcon("image/henfu.png");
								 g.drawImage(img.getImage(), 0, 0, null);
								}
								};
						p.setBounds(0, 0, 1280, 100);
						panel.removeAll();
						panel.add(p);
						panel.repaint();
						p.setLayout(null);
						pf.dispose();
					}
			});
			
				pf.getButton1().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					JPanel p = new JPanel(){
							public void paintComponent(Graphics g) {
								 super.paintComponent(g);
								 ImageIcon img = new ImageIcon("image/word.jpg");
								 g.drawImage(img.getImage(), 0, 0, null);
								}
								};
						p.setBounds(0, 0, 1280, 100);
						panel.removeAll();
						panel.add(p);
						panel.repaint();
						p.setLayout(null);
						pf.dispose();
					}
			});
				

			}
		});
		mnNewMenu.add(menuItem);
		
		JMenuItem menuItem_1 = new JMenuItem("注销");
		menuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				zhuxiao();
			}
		});
		mnNewMenu.add(menuItem_1);
		
		JMenu mnf = new JMenu("帮助（H）");
		menuBar.add(mnf);
		
		JMenuItem menuItem_2 = new JMenuItem("详细");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VersionFrame frame = new VersionFrame();
				frame.setVisible(true);
			}
		});
		mnf.add(menuItem_2);
		
		JMenuItem mntmHelp = new JMenuItem("Help");
		mnf.add(mntmHelp);
        
	}	
	public  void initzhongzhuan(boolean torf){	
		zhongzhuanA.setVisible(torf);//提交显示，未审批～true
		zhongzhuan.setVisible(!torf);
		
	}
	public  void initZhuangche(boolean torf){	
		zhuangche.setVisible(!torf);	
		zhuangcheA.setVisible(torf);
	}
	public  void initDaoda(boolean torf){	
		daoda.setVisible(torf);
		daodaA.setVisible(!torf);	
	}
	
	public void setdaodaB(boolean torf){
	daodB.setVisible(torf);
	}
	
	public void setzhuangcheB(boolean torf){
		zhuangcheB.setVisible(torf);
	}
	
	public void setzhongzhuanB(boolean torf){
		zhongzhuanB.setVisible(torf);
	}

	public ArrivalNoteOnTransitVO getArrivalNoteOnTransitVO() {
		return arrivalNoteOnTransitVO;
	}

	public void setArrivalNoteOnTransitVO(
			ArrivalNoteOnTransitVO arrivalNoteOnTransitVO) {
		this.arrivalNoteOnTransitVO = arrivalNoteOnTransitVO;
	}

	public LoadNoteOnTransitVO getLoadNoteOnTransitVO() {
		return loadNoteOnTransitVO;
	}

	public void setLoadNoteOnTransitVO(LoadNoteOnTransitVO loadNoteOnTransitVO) {
		this.loadNoteOnTransitVO = loadNoteOnTransitVO;
	}

	public TransitNoteOnTransitVO getTransitNoteOnTransitVO() {
		return transitNoteOnTransitVO;
	}

	public void setTransitNoteOnTransitVO(
			TransitNoteOnTransitVO transitNoteOnTransitVO) {
		this.transitNoteOnTransitVO = transitNoteOnTransitVO;
	}

	

	public void setArrivalNoteOnTransitpanel(
			ArrivalNoteOnTransitPanel arrivalNoteOnTransitpanel) {
		this.arrivalNoteOnTransitpanel = arrivalNoteOnTransitpanel;
	}

	

	public void setLoadNoteOnTransitpanel(
			LoadNoteOnTransitPanel loadNoteOnTransitpanel) {
		this.loadNoteOnTransitpanel = loadNoteOnTransitpanel;
	}


	public void setTransitNoteInputOanel(TransitNoteInputPanel transitNoteInputpanel) {
		this.transitNoteInputpanel = transitNoteInputpanel;
	}
	
	public void setZhongzhuan(boolean dengdai,boolean tongguo,boolean butongguo){
		zhongzhuanB.setVisible(dengdai);
		zhongzhuan.setVisible(tongguo);
		zhongzhuanA.setVisible(butongguo);
	}
	
	public void setZhuangche(boolean dengdai,boolean tongguo,boolean butongguo) {
		zhuangcheA.setVisible(butongguo);
		zhuangche.setVisible(tongguo);
		zhuangcheB.setVisible(dengdai);
	}
}
