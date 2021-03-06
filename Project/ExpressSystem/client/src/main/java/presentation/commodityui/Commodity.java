/**
 * 仓库管理员主界面
 * 
 * @author wqy
 *
 */
package presentation.commodityui;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JComponent;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JMenuItem;
import javax.swing.JLabel;

import java.awt.SystemColor;

import javax.swing.UIManager;
import javax.swing.ImageIcon;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;









import connection.ConnectionChecker;
import presentation.logisticui.CourierFrame;
import presentation.logisticui.PayMent;
import presentation.mainui.loginFrame;
import presentation.util.VersionFrame;
import presentation.util.preference;
import util.LogInMsg;

import java.awt.Toolkit;
import java.awt.event.ContainerAdapter;
import java.awt.event.ContainerEvent;

import javax.swing.border.EtchedBorder;

public class Commodity extends JFrame {

	private Commodity frame=this;

	//界面跳转的各种vo
	private Inorder ino;
	private OutOrder outo;
	//↑↑↑↑↑
	//右下角各种审批结果的提示
	private JLabel ruku;
	private JLabel rukuS;
	private JLabel rukuF;
	private JLabel chuku;
	private JLabel chukuS;
	private JLabel chukuF;
	//↑↑↑↑
	//界面自带的各种panel
	private JPanel contentPane;
	public JPanel leftdown;//左下
	
	//frame里传来的
	private LogInMsg lim;
	
	private JLabel biaotilan;
	/**
	 * 窗口宽度
	 */
	private static final int WIDTH = 1280;

	/**
	 * 窗口高度
	 */
	private static final int HEIGHT = 720;
	/**
	 * MIDDLE宽度
	 */
	private static final int WIDTHM = 1152;

	/**
	 * MIDDLE高度
	 */
	private static final int HEIGHTM = 446;


	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Commodity.changeLook();
					Commodity.changeFont();
					Commodity frame = new Commodity();
					frame.setCaiDanLan();
					frame.setVisible(true);
					frame.setClose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	/**
	 * 更改外观
	 */
	private static void changeLook() {
		try {
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencySmallShadow;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			// 关闭右上角设置
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch(Exception e) {
		}
	}
	/**
	 * 更改默认字体
	 */
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

	/**
	 * 设置关闭按钮
	 */
	private  void setClose() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				int result = JOptionPane.showConfirmDialog( Commodity.this, "确认退出？","系统提示",
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

	//设置菜单栏
    public void zhuxiao() {
		int result = JOptionPane.showConfirmDialog( null, "确认退出？","系统提示",
				JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		if(result == JOptionPane.YES_OPTION) {
			dispose();
			loginFrame lf = new loginFrame();
			lf.setVisible(true);
		} else {
			setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		}
	}
	//设置菜单栏
	public void setCaiDanLan(){


		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 80, WIDTH, 34);
		getContentPane().add(menuBar);

		JMenu mnNewMenu = new JMenu("功能");
		menuBar.add(mnNewMenu);
		JMenuItem menuItem = new JMenuItem("个性化");
		menuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final preference pf = new preference();
				pf.setVisible(true);
				pf.getButtton().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					
						biaotilan.setIcon(new ImageIcon("image/henfu.png"));
						pf.dispose();
					}
			});
			
				pf.getButton1().addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
							
								biaotilan.setIcon(new ImageIcon("image/word.jpg"));
					
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
		JMenu mnf = new JMenu("帮助");
		menuBar.add(mnf);

		JMenuItem menuItem_2 = new JMenuItem("详细");
		menuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VersionFrame frame = new VersionFrame();
				frame.setVisible(true);
			}
		});
		mnf.add(menuItem_2);

	}
	/**
	 * Create the frame.
	 */
	public Commodity( LogInMsg lim1) {
		new ConnectionChecker().start();
		this.lim=lim1;
		this.setResizable(false);//不可调整大小
		setIconImage(Toolkit.getDefaultToolkit().getImage("image/0010.jpg"));
		setTitle("快递物流系统");
		this.setSize(WIDTH, HEIGHT);
		((JComponent) this.getContentPane()).setOpaque(true);//不透明
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation((screenWidth-WIDTH)>>1, (screenHeight-HEIGHT)>>1);
		//this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);




		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(5, 0, WIDTH, 78);
		panel.setBackground(Color.LIGHT_GRAY);
		contentPane.add(panel);
		panel.setLayout(null);



		biaotilan = new JLabel("MinJW快递物流系统");
		biaotilan.requestFocus();
		biaotilan.setBounds(0, 0, 1280, 100);
		panel.add(biaotilan);
		biaotilan.setIcon(new ImageIcon("image/henfu.png"));

		final JPanel middle = new JPanel(){
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon img = new ImageIcon("image/0111.jpg");
				g.drawImage(img.getImage(), 0, 0, null);
			}
		}; 
		middle.setBounds(138, 125, WIDTHM, HEIGHTM);
		middle.setBackground(Color.YELLOW);
		contentPane.add(middle);
		middle.setLayout(null);




		JPanel QUANXIANW = new JPanel();
		QUANXIANW.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		QUANXIANW.setBounds(0, 570, 350, 124);



		contentPane.add(QUANXIANW);
		QUANXIANW.setLayout(null);

		JLabel user = new JLabel("用户：");
		user.setBounds(10, 2, 54, 18);
		QUANXIANW.add(user);

		JLabel username = new JLabel(lim.getUserName());
		username.setBounds(56, 2, 170, 18);
		QUANXIANW.add(username);

		JLabel quanxian = new JLabel("权限：");
		quanxian.setBounds(10, 25, 54, 18);
		QUANXIANW.add(quanxian);

		JLabel label = new JLabel(lim.getOrganization());
		label.setBounds(56, 25, 150, 18);
		QUANXIANW.add(label);

		JLabel label_1 = new JLabel("公告:");
		label_1.setBounds(10, 53, 54, 18);
		QUANXIANW.add(label_1);

		JLabel label_2 = new JLabel("快递系统上线试运行，请反馈使用体验");
		label_2.setBounds(56, 53, 284, 18);
		QUANXIANW.add(label_2);

		JPanel right = new JPanel();
		right.setBounds(5, 115, 140, 456);
		contentPane.add(right);
		right.setLayout(null);

		JButton button = new JButton("输入入库单");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//如果vo不为空，说明之前输入过，用原来的，否则new
				if(ino==null){
					ino=new Inorder(lim,frame);
				}
				ino.setBounds(0, 0, 1152, 446);
				ino.setVisible(true);
				middle.removeAll();
				middle.add(ino);
				middle.repaint();
			}
		});
		button.setBounds(10, 10, 120, 100);
		right.add(button);

		JButton button_1 = new JButton("输入出库单");
		button_1.setBounds(10, 120, 120, 100);
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//如果vo不为空，说明之前输入过，用原来的，否则new
				if(outo==null){
					outo=new OutOrder(lim,frame);
				}				outo.setBounds(0, 0, 1152, 446);
				outo.setVisible(true);
				middle.removeAll();
				middle.add(outo);
				middle.repaint();
			}
		});
		right.add(button_1);

		JButton button_2 = new JButton("库存查看");
		button_2.setBounds(10, 224, 120, 100);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChaKan a=new ChaKan(lim);
				a.setBounds(0, 0, 1152, 446);
				a.setVisible(true);
				middle.removeAll();
				middle.add(a);
				middle.repaint();
			}
		});
		right.add(button_2);

		JButton button_3 = new JButton("库存盘点");
		button_3.setBounds(10, 334, 120, 100);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				PanDian a=new PanDian(frame);
				a.setBounds(0, 0, 1152, 446);
				a.setVisible(true);
				middle.removeAll();
				middle.add(a);
				middle.repaint();
			}
		});
		right.add(button_3);

		leftdown = new JPanel();
		leftdown.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		leftdown.setBounds(341, 570, 939, 124);
		contentPane.add(leftdown);
		leftdown.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(26, 7, 470, 32);
		leftdown.add(lblNewLabel_1);

		initDownLabel();
		initRuku(false,false,false);
		initChuku(false,false,false);
		setCaiDanLan();
		setClose();
	}
	//等待审批，已通过审批，未通过审批
	public void initRuku(boolean w,boolean s,boolean f){
		
		ruku.setVisible(w);
		rukuS.setVisible(s);
		rukuF.setVisible(f);
	}
	public void initChuku(boolean w,boolean s,boolean f){
		
		chuku.setVisible(w);
		chukuS.setVisible(s);
		chukuF.setVisible(f);
	}
	public void initDownLabel(){
		ruku = new JLabel("您提交的入库单正在等待审批哦，请耐心等待哦~");
		ruku.setBounds(26, 30, 471, 32);
		leftdown.add(ruku);
		
		rukuS = new JLabel("您提交的入库单已通过审批,现在可以填下一份了哟~");
		rukuS.setBounds(26, 30, 471, 32);
		leftdown.add(rukuS);
		
		rukuF = new JLabel("您提交的入库单未通过审批>_<");
		rukuF.setBounds(26, 30, 471, 32);
		rukuF.setForeground(Color.red);
		leftdown.add(rukuF);

		chuku = new JLabel("您提交的出库单正在等待审批哦，请耐心等待哦~");
		chuku.setBounds(25, 49, 471, 30);
		leftdown.add(chuku);
		
		chukuS = new JLabel("您提交的出库单已通过审批,现在可以填下一份了哟");
		chukuS.setBounds(25, 49, 471, 30);
		leftdown.add(chukuS);
		
		chukuF = new JLabel("您提交的出库单未通过审批>_<");
		chukuF.setBounds(25, 49, 471, 30);
		chukuF.setForeground(Color.red);
		leftdown.add(chukuF);
	}
}
