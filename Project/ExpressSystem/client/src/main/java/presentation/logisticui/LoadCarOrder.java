/**
 * 营业厅装车单界面
 * 
 * @author wqy
 *
 */
package presentation.logisticui;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;

public class LoadCarOrder extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	/**
	 * 窗口宽度
	 */
	private static final int WIDTH = 1152;
	
	/**
	 * 窗口高度
	 */
	private static final int HEIGHT = 446;
	/**
	 * 右边标签
	 */
	private static final int WIDTHL = WIDTH/3*2+19;
	/**
	 * 右边field
	 */
	private static final int WIDTHT = WIDTHL+76;

	/**
	 * Create the panel.
	 */
	public LoadCarOrder() {
		setSize(WIDTH,HEIGHT);
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel label = new JLabel("日期");
		label.setBounds(58, 41, 54, 18);
		add(label);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setBounds(122, 40, 66, 21);
		add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("营业厅编号");
		label_1.setBounds(245, 43, 71, 15);
		add(label_1);
		
		textField_1 = new JTextField();
		textField_1.setEnabled(false);
		textField_1.setEditable(false);
		textField_1.setBounds(326, 40, 66, 21);
		add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("目的地");
		label_2.setBounds(58, 96, 54, 15);
		add(label_2);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		textField_2.setBounds(122, 94, 286, 18);
		add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_3 = new JLabel("车辆编号");
		label_3.setBounds(58, 150, 54, 15);
		add(label_3);
		
		textField_3 = new JTextField();
		textField_3.setEnabled(false);
		textField_3.setEditable(false);
		textField_3.setBounds(122, 147, 66, 21);
		add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_4 = new JLabel("汽运编号");
		label_4.setBounds(58, 206, 66, 15);
		add(label_4);
		
		textField_4 = new JTextField();
		textField_4.setEnabled(false);
		textField_4.setEditable(false);
		textField_4.setBounds(122, 203, 66, 21);
		add(textField_4);
		textField_4.setColumns(10);
		
		JLabel label_5 = new JLabel("监装员");
		label_5.setBounds(58, 251, 66, 15);
		add(label_5);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setEditable(false);
		textField_5.setBounds(122, 248, 66, 21);
		add(textField_5);
		textField_5.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("押运员");
		lblNewLabel.setBounds(58, 304, 54, 15);
		add(lblNewLabel);
		
		textField_6 = new JTextField();
		textField_6.setEnabled(false);
		textField_6.setEditable(false);
		textField_6.setBounds(122, 301, 66, 21);
		add(textField_6);
		textField_6.setColumns(10);
		
		JLabel label_6 = new JLabel("货物编码");
		label_6.setBounds(245, 150, 93, 15);
		add(label_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(226, 188, 147, -51);
		add(scrollPane);
		
		JButton btnNewButton = new JButton("提交");
		btnNewButton.setBounds(278, 304, 93, 23);
		add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(226, 188, 166, 99);
		add(scrollPane_1);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setEnabled(false);
		scrollPane_1.setViewportView(textField_7);
		textField_7.setColumns(10);
		
		JLabel label_7 = new JLabel("日期");
		label_7.setBounds(WIDTHL, 10, 54, 15);
		add(label_7);
		
		textField_8 = new JTextField();
		textField_8.setBounds(WIDTHT, 7, 66, 21);
		add(textField_8);
		textField_8.setColumns(10);
		
		JLabel label_8 = new JLabel("营业厅编号");
		label_8.setBounds(WIDTHL, 43, 78, 15);
		add(label_8);
		
		textField_9 = new JTextField();
		textField_9.setBounds(WIDTHT, 40, 66, 21);
		add(textField_9);
		textField_9.setColumns(10);
		
		JLabel label_9 = new JLabel("汽运编号");
		label_9.setBounds(WIDTHL, 81, 78, 15);
		add(label_9);
		
		textField_10 = new JTextField();
		textField_10.setBounds(WIDTHT, 78, 66, 21);
		add(textField_10);
		textField_10.setColumns(10);
		
		JLabel label_10 = new JLabel("目的地");
		label_10.setBounds(WIDTHL, 122, 54, 15);
		add(label_10);
		
		JLabel label_11 = new JLabel("车辆编号");
		label_11.setBounds(WIDTHL, 150, 74, 15);
		add(label_11);
		
		JLabel label_12 = new JLabel("监装员");
		label_12.setBounds(WIDTHL, 188, 54, 15);
		add(label_12);
		
		JLabel label_13 = new JLabel("押运员");
		label_13.setBounds(WIDTHL, 226, 54, 15);
		add(label_13);
		
		JButton btnNewButton_1 = new JButton("确认");
		btnNewButton_1.setBounds(672, 247, 93, 23);
		add(btnNewButton_1);
		
		JLabel label_14 = new JLabel("货物编码");
		label_14.setBounds(WIDTHL, 281, 78, 15);
		add(label_14);
		
		textField_11 = new JTextField();
		textField_11.setBounds(WIDTHT, 278, 140, 21);
		add(textField_11);
		textField_11.setColumns(10);
		
		JButton button = new JButton("添加");
		button.setBounds(672, 304, 93, 23);
		add(button);
		
		textField_12 = new JTextField();
		textField_12.setBounds(WIDTHT, 119, 66, 21);
		add(textField_12);
		textField_12.setColumns(10);
		
		textField_13 = new JTextField();
		textField_13.setBounds(WIDTHT, 150, 66, 21);
		add(textField_13);
		textField_13.setColumns(10);
		
		textField_14 = new JTextField();
		textField_14.setBounds(WIDTHT, 181, 66, 21);
		add(textField_14);
		textField_14.setColumns(10);
		
		textField_15 = new JTextField();
		textField_15.setBounds(WIDTHT, 223, 66, 21);
		add(textField_15);
		textField_15.setColumns(10);
		
		JLabel label_15 = new JLabel("新增装车单");
		label_15.setBounds(28, 10, 84, 15);
		add(label_15);

	}
	public void paintComponent(Graphics g) {
		 super.paintComponents(g);
		 ImageIcon img = new ImageIcon("C:\\Users\\Administrator\\Desktop\\0011.jpg");
		 g.drawImage(img.getImage(), 0, 0, null);
		 float lineWidth = 3.0f;
	      ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
	      g.drawLine(WIDTH/3*2, 0, WIDTH/3*2, HEIGHT);
		}
}
