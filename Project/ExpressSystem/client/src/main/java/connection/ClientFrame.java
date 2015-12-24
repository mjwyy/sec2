package connection;

import java.awt.BasicStroke;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import presentation.mainui.loginFrame;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblboss;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ClientFrame frame = new ClientFrame();
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
	public ClientFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel(){
			public void paintComponent(Graphics g) {
				 super.paintComponent(g);
				 ImageIcon img = new ImageIcon("image/serverBackground.jpg");
				 g.drawImage(img.getImage(), 0, 0, null);
				 float lineWidth = 3.0f;
			      ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
			      g.drawLine(768, 0, 768, 500);
				}
				};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMInJw = new JLabel("M inJW物流管理系统");
		lblMInJw.setBounds(28, 31, 211, 16);
		contentPane.add(lblMInJw);
		
		JLabel lblServerIp = new JLabel("Server IP：");
		lblServerIp.setBounds(28, 97, 106, 16);
		contentPane.add(lblServerIp);
		
		textField = new JTextField();
		textField.setBounds(28, 125, 286, 28);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("启动");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			if(!textField.getText().isEmpty()){
				lblboss.setVisible(false);
				 RMIHelper.setServerIP(textField.getText());
				 
				  try {
					RMIHelper.tryConnect();
				} catch (RemoteException | NotBoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			        changeFont();
			        changeLook();		        
			         loginFrame frame = new loginFrame();//    
			        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("image/0010.jpg"));
			        dispose();
			}else {
				lblboss.setVisible(true);
			}
			}
		});
		button.setBounds(199, 192, 117, 29);
		contentPane.add(button);
		
		lblboss = new JLabel("请填写服务器IP再启动哦！");
		lblboss.setBounds(209, 233, 187, 16);
		contentPane.add(lblboss);
		lblboss.setVisible(false);
	}

	 /**
		 * 更改外观
		 */
		public static void changeLook() {
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
		public static void changeFont() {
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
		
}
