package presentation.financeui;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JLabel;

import businesslogic.statistic.BaseDataBuilding;
import businesslogicservice.statisticblservice.BaseDataBuildingBLService;
import presentation.logisticui.Car;
import presentation.mainui.ManageorgPanel;
import util.ResultMsg;

public class BaseDataBuildingPanel extends JPanel {
	private JPanel bankpanel;
	private BaseDataBuildingBLService service;

	/**
	 * Create the panel.
	 */
	/**
	 * 窗口宽度
	 */
	private static final int WIDTH = 1152;
	
	/**
	 * 窗口高度
	 */
	private static final int HEIGHT = 446;
	public BaseDataBuildingPanel() {
		setSize(WIDTH,HEIGHT);
		setLayout(null);
		//jigoujianzhang() ;
		
		JButton button = new JButton("机构建账");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jigoujianzhang() ;
			}
		});
		button.setBounds(28, 6, 117, 29);
		add(button);
		
		JButton button_1 = new JButton("银行账户建账");
		button_1.addActionListener(new ActionListener() {
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
		button_1.setBounds(177, 6, 117, 29);
		add(button_1);
		
		JButton button_2 = new JButton("车辆建账");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Car a=new Car();
				bankpanel.removeAll();
				bankpanel.add(a);
				bankpanel.repaint();
			}
		});
		button_2.setBounds(342, 6, 117, 29);
		add(button_2);
		
		JButton button_3 = new JButton("建账结束");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				service = new BaseDataBuilding();
				ResultMsg res = service.endDataBuilding();
				int result1 = JOptionPane.showConfirmDialog(null, service.restartWithoutBasis().getMessage(),"系统提示",
						JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);
			}
		});
		button_3.setBounds(643, 6, 117, 29);
		add(button_3);
		
		bankpanel = new JPanel(){
			public void paintComponent(Graphics g) {
			 super.paintComponent(g);
			 ImageIcon img = new ImageIcon("image/0111.jpg");
			 g.drawImage(img.getImage(), 0, 0, null);
			 float lineWidth = 3.0f;
		      ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
		      g.drawLine(768, 0, 768, 500);
			}
		};
		bankpanel.setBounds(6, 38, 1146, 387);
		add(bankpanel);	
		jigoujianzhang();

	}
   
	public void jigoujianzhang() {
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
}
