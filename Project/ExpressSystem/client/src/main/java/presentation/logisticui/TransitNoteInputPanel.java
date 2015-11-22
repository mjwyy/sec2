package presentation.logisticui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import java.awt.Color;

public class TransitNoteInputPanel extends JPanel {
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
	private JTable table;

	/**
	 * Create the panel.
	 */
	public TransitNoteInputPanel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 488, 390);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("日期");
		lblNewLabel_2.setBounds(29, 33, 61, 16);
		panel.add(lblNewLabel_2);
		
		textField_7 = new JTextField();
		textField_7.setEnabled(false);
		textField_7.setBounds(69, 27, 134, 29);
		panel.add(textField_7);
		textField_7.setColumns(10);
		
		JLabel label_4 = new JLabel("中转单编号");
		label_4.setBounds(215, 33, 75, 16);
		panel.add(label_4);
		
		textField_8 = new JTextField();
		textField_8.setEnabled(false);
		textField_8.setBounds(287, 27, 134, 29);
		panel.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel label_5 = new JLabel("监装员");
		label_5.setBounds(29, 92, 61, 16);
		panel.add(label_5);
		
		textField_9 = new JTextField();
		textField_9.setEnabled(false);
		textField_9.setColumns(10);
		textField_9.setBounds(69, 86, 134, 29);
		panel.add(textField_9);
		
		JLabel label_6 = new JLabel("出发地");
		label_6.setBounds(29, 151, 61, 16);
		panel.add(label_6);
		
		textField_10 = new JTextField();
		textField_10.setEnabled(false);
		textField_10.setColumns(10);
		textField_10.setBounds(69, 145, 134, 29);
		panel.add(textField_10);
		
		JLabel label_7 = new JLabel("到达地");
		label_7.setBounds(29, 204, 61, 16);
		panel.add(label_7);
		
		textField_11 = new JTextField();
		textField_11.setEnabled(false);
		textField_11.setColumns(10);
		textField_11.setBounds(69, 198, 134, 29);
		panel.add(textField_11);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(225, 67, 210, 248);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new EtchedBorder(EtchedBorder.RAISED, Color.LIGHT_GRAY, Color.LIGHT_GRAY));
		panel_1.setBounds(489, 0, 249, 390);
		add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("日期");
		lblNewLabel.setBounds(19, 18, 61, 16);
		panel_1.add(lblNewLabel);
		
		JLabel label = new JLabel("中转单编号");
		label.setBounds(19, 58, 65, 16);
		panel_1.add(label);
		
		JLabel label_1 = new JLabel("出发地");
		label_1.setBounds(19, 100, 61, 16);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("到达地");
		label_2.setBounds(19, 141, 61, 16);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("监装员");
		label_3.setBounds(19, 184, 61, 16);
		panel_1.add(label_3);
		
		textField = new JTextField();
		textField.setBounds(97, 12, 134, 29);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(96, 52, 134, 29);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(97, 91, 134, 29);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(97, 135, 134, 29);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(97, 178, 134, 29);
		panel_1.add(textField_4);
		textField_4.setColumns(10);
		
		JButton button = new JButton("确认");
		button.setBounds(126, 220, 117, 30);
		panel_1.add(button);
		
		JLabel lblNewLabel_1 = new JLabel("货柜号");
		lblNewLabel_1.setBounds(19, 308, 61, 16);
		panel_1.add(lblNewLabel_1);
		
		JLabel lbll = new JLabel("条形码");
		lbll.setBounds(19, 268, 61, 16);
		panel_1.add(lbll);
		
		textField_5 = new JTextField();
		textField_5.setBounds(97, 262, 134, 29);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		textField_6 = new JTextField();
		textField_6.setBounds(97, 302, 134, 29);
		panel_1.add(textField_6);
		textField_6.setColumns(10);
		
		JButton button_1 = new JButton("添加");
		button_1.setBounds(126, 343, 117, 30);
		panel_1.add(button_1);

	}
}
