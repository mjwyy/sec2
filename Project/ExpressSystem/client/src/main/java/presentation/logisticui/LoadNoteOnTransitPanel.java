package presentation.logisticui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JTable;
import java.awt.Color;

public class LoadNoteOnTransitPanel extends JPanel {
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
	private JTable table;

	/**
	 * Create the panel.
	 */
	public LoadNoteOnTransitPanel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 488, 390);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("日期");
		lblNewLabel_2.setBounds(25, 28, 61, 16);
		panel.add(lblNewLabel_2);
		
		textField_7 = new JTextField();
		textField_7.setEnabled(false);
		textField_7.setBounds(88, 22, 134, 29);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel label_5 = new JLabel("到达地");
		label_5.setBounds(234, 28, 61, 16);
		panel.add(label_5);
		
		textField_8 = new JTextField();
		textField_8.setEnabled(false);
		textField_8.setColumns(10);
		textField_8.setBounds(298, 22, 134, 29);
		panel.add(textField_8);
		
		JLabel label_6 = new JLabel("汽运编号");
		label_6.setBounds(25, 86, 61, 16);
		panel.add(label_6);
		
		JLabel label_7 = new JLabel("车辆代号");
		label_7.setBounds(25, 136, 61, 16);
		panel.add(label_7);
		
		JLabel label_8 = new JLabel("监装员");
		label_8.setBounds(25, 182, 61, 16);
		panel.add(label_8);
		
		JLabel label_9 = new JLabel("押运员");
		label_9.setBounds(25, 236, 61, 16);
		panel.add(label_9);
		
		textField_9 = new JTextField();
		textField_9.setEnabled(false);
		textField_9.setColumns(10);
		textField_9.setBounds(86, 80, 134, 29);
		panel.add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setEnabled(false);
		textField_10.setColumns(10);
		textField_10.setBounds(88, 130, 134, 29);
		panel.add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setEnabled(false);
		textField_11.setColumns(10);
		textField_11.setBounds(88, 176, 134, 29);
		panel.add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setEnabled(false);
		textField_12.setColumns(10);
		textField_12.setBounds(88, 230, 134, 29);
		panel.add(textField_12);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		scrollPane.setBounds(274, 86, 172, 216);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton button_2 = new JButton("提交");
		button_2.setBounds(329, 339, 117, 30);
		panel.add(button_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		panel_1.setBounds(489, 0, 249, 390);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("日期");
		lblNewLabel.setBounds(6, 19, 61, 16);
		panel_1.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(79, 13, 134, 29);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("汽运编号");
		label.setBounds(6, 54, 61, 16);
		panel_1.add(label);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(79, 48, 134, 29);
		panel_1.add(textField_1);
		
		JLabel lblNewLabel_1 = new JLabel("车辆代号");
		lblNewLabel_1.setBounds(6, 95, 61, 16);
		panel_1.add(lblNewLabel_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(79, 89, 134, 29);
		panel_1.add(textField_2);
		
		JLabel label_1 = new JLabel("监装员");
		label_1.setBounds(6, 136, 61, 16);
		panel_1.add(label_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(79, 130, 134, 29);
		panel_1.add(textField_3);
		
		JLabel label_2 = new JLabel("押运员");
		label_2.setBounds(6, 175, 61, 16);
		panel_1.add(label_2);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(79, 169, 134, 29);
		panel_1.add(textField_4);
		
		JLabel label_3 = new JLabel("到达地");
		label_3.setBounds(6, 214, 61, 16);
		panel_1.add(label_3);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(79, 208, 134, 29);
		panel_1.add(textField_5);
		
		JButton button = new JButton("确认");
		button.setBounds(126, 258, 117, 30);
		panel_1.add(button);
		
		JLabel label_4 = new JLabel("条形码");
		label_4.setBounds(6, 307, 61, 16);
		panel_1.add(label_4);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(79, 301, 134, 29);
		panel_1.add(textField_6);
		
		JButton button_1 = new JButton("添加");
		button_1.setBounds(126, 339, 117, 29);
		panel_1.add(button_1);

	}

}
