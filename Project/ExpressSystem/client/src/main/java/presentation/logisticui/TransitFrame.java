package presentation.logisticui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.io.File;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JLabel;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import presentation.util.welcomPanel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;

public class TransitFrame extends JFrame {

	private JPanel contentPane;
	private welcomPanel welcome;
    private JPanel bankpanel;
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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//TransitFrame.changeLook();
					TransitFrame frame = new TransitFrame();
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

	/**
	 * Create the frame.
	 */
	public TransitFrame() {
		setResizable(false);
		setBackground(new Color(153, 204, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1280, 720);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		bankpanel = new JPanel();
		bankpanel.setBounds(138, 125, 1152, 446);
		contentPane.add(bankpanel);
		bankpanel.setLayout(null);
		welcome = new welcomPanel();
		welcome.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		welcome.setBounds(0, 0, 1152, 446);
		bankpanel.add(welcome);
		welcome.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1280, 100);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(168, 6, 865, 94);
		lblNewLabel_1.setIcon(new ImageIcon("/Users/alice/Desktop/sec2-master-3/Project/ExpressSystem/client/image/image1.jpg"));
		panel.add(lblNewLabel_1);
		
		JLabel lblL = new JLabel();
		lblL.setBounds(1075, 280, 0, 0);
		panel.add(lblL);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
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
		panel_2.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.LIGHT_GRAY, Color.GRAY));
		panel_2.setBounds(0, 570, 350, 124);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label = new JLabel("系统公告");
		label.setBounds(16, 6, 52, 16);
		panel_2.add(label);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(16, 106, 61, 16);
		panel_2.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("录入到达单");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrivalNoteOnTransitPanel anot = new ArrivalNoteOnTransitPanel();
				anot.setBounds(0, 0, 1152, 446);
				bankpanel.removeAll();
				bankpanel.add(anot);
				bankpanel.repaint();
				
			}
		});
		btnNewButton.setBounds(0, 123, 140, 152);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("录入中转单");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			TransitNoteInputPanel tni = new TransitNoteInputPanel();
			tni.setBounds(0, 0, 1152, 446);
			bankpanel.removeAll();
			bankpanel.add(tni);
			bankpanel.repaint();
			}
		});
		btnNewButton_1.setBounds(0, 272, 140, 152);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("录入装车单");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoadNoteOnTransitPanel lnot = new LoadNoteOnTransitPanel();
				lnot.setBounds(0, 0, 1152, 446);
				bankpanel.removeAll();
				bankpanel.add(lnot);
				bankpanel.repaint();
			}
		});
		btnNewButton_2.setBounds(0, 420, 140, 152);
		contentPane.add(btnNewButton_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(347, 570, 933, 124);
		contentPane.add(panel_3);
		panel_3.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.LIGHT_GRAY, Color.GRAY));
		
		
		
	}
}
