/**
 * 营业厅派送单界面
 * 
 * @author wqy
 *
 */
package presentation.logisticui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

public class SendOrder extends JPanel {
	private JTextField textField;
	private JTextField textField_5;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_11;
	private JTextField textField_1;
	/**
	 * 窗口宽度
	 */
	private static final int WIDTH = 1152;
	
	/**
	 * 窗口高度
	 */
	private static final int HEIGHT = 446;
	/**
	 * Create the panel.
	 */
	public SendOrder() {
		setSize(WIDTH,HEIGHT);
		setBackground(Color.WHITE);
		setLayout(null);
		
		JLabel label = new JLabel("日期");
		label.setBounds(58, 41, 54, 18);
		add(label);
		
		textField = new JTextField();
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setBounds(150, 40, 66, 21);
		add(textField);
		textField.setColumns(10);
		
		JLabel label_4 = new JLabel("派件员");
		label_4.setBounds(58, 81, 93, 15);
		add(label_4);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setEditable(false);
		textField_5.setBounds(150, 78, 66, 21);
		add(textField_5);
		textField_5.setColumns(10);
		
		JLabel label_6 = new JLabel("货物编码");
		label_6.setBounds(150, 163, 93, 15);
		add(label_6);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(226, 188, 147, -51);
		add(scrollPane);
		
		JButton btnNewButton = new JButton("提交");
		btnNewButton.setBounds(278, 304, 93, 23);
		add(btnNewButton);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(58, 188, 334, 99);
		add(scrollPane_1);
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setEnabled(false);
		scrollPane_1.setViewportView(textField_7);
		textField_7.setColumns(10);
		
		JLabel label_7 = new JLabel("日期");
		label_7.setBounds(787, 43, 54, 15);
		add(label_7);
		
		textField_8 = new JTextField();
		textField_8.setBounds(863, 40, 66, 21);
		add(textField_8);
		textField_8.setColumns(10);
		
		JLabel label_13 = new JLabel("派件员");
		label_13.setBounds(787, 132, 82, 15);
		add(label_13);
		
		JButton btnNewButton_1 = new JButton("确认");
		btnNewButton_1.setBounds(953, 174, 93, 23);
		add(btnNewButton_1);
		
		JLabel label_14 = new JLabel("货物编码");
		label_14.setBounds(787, 247, 66, 15);
		add(label_14);
		
		textField_11 = new JTextField();
		textField_11.setBounds(863, 244, 140, 21);
		add(textField_11);
		textField_11.setColumns(10);
		
		JButton button = new JButton("添加");
		button.setBounds(964, 304, 93, 23);
		add(button);
		
	
		
		JLabel label_2 = new JLabel("新增派送单");
		label_2.setBounds(10, 0, 102, 15);
		add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(863, 129, 66, 21);
		add(textField_1);
		textField_1.setColumns(10);

	
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
