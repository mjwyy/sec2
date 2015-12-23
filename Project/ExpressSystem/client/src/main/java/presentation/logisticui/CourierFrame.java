package presentation.logisticui;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.border.EtchedBorder;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import presentation.mainui.loginFrame;
import presentation.util.welcomPanel;
import util.LogInMsg;
import util.ResultMsg;
import vo.DeliveryNoteVO;
import vo.ReceivingNoteVO;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class CourierFrame extends JFrame {

	private JPanel contentPane;
	private welcomPanel welcome;
    private JPanel bankpanel;
    private LogInMsg lim; 
    private ReceivingNoteVO receivingNoteVo;
    private DeliveryNoteVO deliveryNoteVo;
    private  JLabel jijian;
    private  JLabel jijianB;
	private  JLabel shoujian;
	private  JLabel shoujianA;
	private  JLabel shoujianB;
	private  JLabel jijianA;
	public JPanel leftpanel;
	public ReceiveOrderPanel rop0;
	private MailOrderPanel mailOrderPanel;
	private ReceiveOrderPanel receiveOrderpanel;
	private JLabel label;
	private JLabel label_1;
	private JLabel limname;
	private JLabel limorg;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LogInMsg limm = null;
					CourierFrame.changeLook();
					CourierFrame frame = new CourierFrame(limm);
					frame.setVisible(true);
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
	
	private  void setClose() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				int result = JOptionPane.showConfirmDialog( CourierFrame.this, "确认退出？","系统提示",
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
	 */
	public CourierFrame(LogInMsg  logInMsg) {
		setSize(1280,720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		lim = logInMsg;
		setClose();
		
		this.setResizable(false);//不可调整大小
		setTitle("MinJW物流管理系统");
		
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
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		panel_1.setBounds(0, 100, 1280, 25);
		contentPane.add(panel_1);
		
		bankpanel = new JPanel();
		bankpanel.setBounds(138, 125, 1152, 446);
		contentPane.add(bankpanel);
		bankpanel.setLayout(null);
		welcome = new welcomPanel();
		welcome.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		welcome.setBounds(0, 0, 1152, 446);
		bankpanel.add(welcome);
		welcome.setLayout(null);
		
		leftpanel = new JPanel();
		leftpanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		leftpanel.setBounds(347, 570, 933, 124);
		contentPane.add(leftpanel);
		
		JPanel right = new JPanel();
		right.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		right.setBounds(0, 570, 350, 124);
		contentPane.add(right);
		right.setLayout(null);
		
		label = new JLabel("姓名：");
		label.setBounds(6, 18, 61, 16);
		right.add(label);
		
		label_1 = new JLabel("机构：");
		label_1.setBounds(6, 46, 61, 16);
		right.add(label_1);
		
		limname = new JLabel(lim.getUserName());
		limname.setBounds(65, 18, 182, 16);
		right.add(limname);
		
		limorg = new JLabel(lim.getOrganization());
		limorg.setBounds(61, 46, 172, 16);
		right.add(limorg);
		
		JButton btnNewButton = new JButton("登记寄件单");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(mailOrderPanel == null){
				MailOrderPanel mop = new MailOrderPanel(lim,CourierFrame.this){
					public void paintComponent(Graphics g) {
						 super.paintComponent(g);
						 ImageIcon img = new ImageIcon("image/0111.jpg");
						 g.drawImage(img.getImage(), 0, 0, null);
						 float lineWidth = 3.0f;
					      ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
					      g.drawLine(768, 0, 768, 500);
						}
						};			
				mop.setBounds(0, 0, 1152, 446);
				bankpanel.removeAll();
				bankpanel.add(mop);
				bankpanel.repaint();
				}else{
					mailOrderPanel.setBounds(0, 0, 1152, 446);
					bankpanel.removeAll();
					bankpanel.add(mailOrderPanel);
					bankpanel.repaint();
				}
			}
		
		});
		btnNewButton.setBounds(0, 123, 140, 152);
		contentPane.add(btnNewButton);
		
		JButton button = new JButton("录入收件单");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(receiveOrderpanel == null){
				ReceiveOrderPanel rop = new ReceiveOrderPanel(lim,CourierFrame.this){
					public void paintComponent(Graphics g) {
						 super.paintComponent(g);
						 ImageIcon img = new ImageIcon("image/0111.jpg");
						 g.drawImage(img.getImage(), 0, 0, null);
						}
						}; 
				rop.setBounds(0, 0, 1152, 446);
				bankpanel.removeAll();
				bankpanel.add(rop);
				bankpanel.repaint();
				}
				else{
					receiveOrderpanel.setBounds(0, 0, 1152, 446);
					bankpanel.removeAll();
					bankpanel.add(receiveOrderpanel);
					bankpanel.repaint();
				}
			}
		});
		button.setBounds(0, 272, 140, 152);
		contentPane.add(button);
		
		JButton button_1 = new JButton("查询订单信息");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InquiryPanel ip = new InquiryPanel(){
					public void paintComponent(Graphics g) {
						 super.paintComponent(g);
						 ImageIcon img = new ImageIcon("image/0111.jpg");
						 g.drawImage(img.getImage(), 0, 0, null);
						}
						}; 
				ip.setBounds(0, 0, 1152, 446);
				bankpanel.removeAll();
				bankpanel.add(ip);
				bankpanel.repaint();
				
				ip.getBack().addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						bankpanel.removeAll();
						bankpanel.add(welcome);
						bankpanel.repaint();
					}
					
				});
			}
		});
		button_1.setBounds(0, 421, 140, 152);
		contentPane.add(button_1);
		
		jijian = new JLabel("您提交的寄件单已通过审批,现在可以填下一份了哟");
		jijian.setBounds(21, 10, 487, 24);
		leftpanel.add(jijian);
		jijian.setVisible(false);
		
		
		jijianB = new JLabel("您提交的寄件正在等待审批，请耐心等待哦～");
		jijianB.setBounds(21, 10, 487, 24);
		jijianB.setForeground(Color.red);
		leftpanel.add(jijianB);
		jijianB.setVisible(false);
		
		jijianA = new JLabel("您提交的寄件单未通过审批");
		jijianA.setBounds(21, 10, 487, 24);
		jijianA.setForeground(Color.red);
		jijianA.setVisible(false);	
		leftpanel.add(jijianA);
	
		shoujian = new JLabel("您提交的收件单已通过审批,现在可以填下一份了哟");
		shoujian.setBounds(21, 60, 487, 24);
		leftpanel.add(shoujian);
		shoujian.setVisible(false);
	
	
      
		
		shoujianA = new JLabel("您提交的收件单未通过审批");
		shoujianA.setBounds(21, 60, 487, 24);
		shoujianA.setForeground(Color.red);
		leftpanel.add(shoujianA);
		shoujianA.setVisible(false);
		
	
	    
		shoujianB = new JLabel("您提交的收件单正在等待审批，请耐心等待哦～");
		shoujianB.setBounds(21, 60, 487, 24);
		shoujianB.setForeground(Color.red);
		leftpanel.add(shoujianB);
		shoujianB.setVisible(false);
	
	}

	public MailOrderPanel getMailOrderPanel() {
		return mailOrderPanel;
	}

	public void setMailOrderPanel(MailOrderPanel mailOrderPanel) {
		this.mailOrderPanel = mailOrderPanel;
	}

	public void setReceiveOrderpanel(ReceiveOrderPanel receiveOrderpanel) {
		this.receiveOrderpanel = receiveOrderpanel;
	}

	public ReceivingNoteVO getReceivingNoteVo() {
		return receivingNoteVo;
	}

	public void setReceivingNoteVo(ReceivingNoteVO receivingNoteVo) {
		this.receivingNoteVo = receivingNoteVo;
	}

	public DeliveryNoteVO getDeliveryNoteVo() {
		return deliveryNoteVo;
	}

	public void setDeliveryNoteVo(DeliveryNoteVO deliveryNoteVo) {
		this.deliveryNoteVo = deliveryNoteVo;
	}
	
	public  void initjijian(boolean torf){	
		jijian.setVisible(torf);
		jijianA.setVisible(!torf);// torf == true show this;	
	}

	public  void initshoujian(boolean torf){	
		shoujian.setVisible(torf);
		shoujianA.setVisible(!torf);// torf == true show this;	
	}
	
	public void setshouJianB(boolean torf){
		shoujianB.setVisible(torf);
	}

	public void setjijianB(boolean torf){
		jijianB.setVisible(torf);
	}
	
   public void setJijian(boolean dengdai,boolean tongguo,boolean butongguo ) {
	   jijianB.setVisible(dengdai);
	   jijian.setVisible(tongguo);
	   jijianA.setVisible(butongguo);	   
   }
	
  public void setShoujian(boolean dengdai,boolean tongguo,boolean butongguo) {
	  shoujianB.setVisible(dengdai);
	  shoujian.setVisible(tongguo);
	  shoujianA.setVisible(butongguo);	  
  }
}
