package presentation.logisticui;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import presentation.util.checkstyleDialog;
import util.ResultMsg;
import vo.TransitNoteOnTransitVO;
import dataservice.logisticdataservice.TransitNoteInputDataService;
import businesslogic.logistic.TransitNoteInput;
import businesslogicservice.logisticblservice.TransitNoteInputBLService;
import businesslogicservice.logisticblservice._Stub.TransitNoteInputBLService_Stub;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TransitNoteInputPanel extends JPanel {
	private JTextField date2;
	private JTextField transitnum2;
	private JTextField loader2;
	private JTextField setout2;
	private JTextField arrival2;
	private JTextField date1;
	private JTextField transitnum1;
	private JTextField loader1;
	private JTextField setout1;
	private JTextField arrival1;
	private JTextField textField_10;
	private JTextField textField_11;
	private DefaultTableModel model;
	private Vector name;
	private Vector data;
    private JTable table;
    private TransitNoteInputBLService service;
    private TransitNoteInputDataService service1;
    private ResultMsg res;

	/**
	 * Create the panel.
	 */
	
	 public static void main(String[] args){
		JFrame f = new JFrame();
		TransitNoteInputPanel p = new TransitNoteInputPanel();
		p.setVisible(true);
		f.setSize(1150,446);
	f.getContentPane().add(p);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public TransitNoteInputPanel() {
		setSize(1152,446);
		setLayout(null);
		
		JLabel label = new JLabel("日期");
		label.setBounds(84, 44, 61, 16);
		add(label);
		
		date2 = new JTextField();
		date2.setEditable(false);
		date2.setBounds(142, 38, 134, 28);
		add(date2);
		date2.setColumns(10);
		
		JLabel label_1 = new JLabel("中转单编号");
		label_1.setBounds(348, 44, 74, 16);
		add(label_1);
		
		transitnum2 = new JTextField();
		transitnum2.setEditable(false);
		transitnum2.setBounds(434, 38, 134, 28);
		add(transitnum2);
		transitnum2.setColumns(10);
		
		JLabel label_2 = new JLabel("监装员");
		label_2.setBounds(84, 115, 61, 16);
		add(label_2);
		
		loader2 = new JTextField();
		loader2.setEditable(false);
		loader2.setBounds(142, 109, 134, 28);
		add(loader2);
		loader2.setColumns(10);
		
		JLabel label_3 = new JLabel("出发地");
		label_3.setBounds(84, 176, 61, 16);
		add(label_3);
		
		setout2 = new JTextField();
		setout2.setEditable(false);
		setout2.setBounds(142, 170, 134, 28);
		add(setout2);
		setout2.setColumns(10);
		
		JLabel label_4 = new JLabel("到达地");
		label_4.setBounds(84, 243, 61, 16);
		add(label_4);
		
		arrival2 = new JTextField();
		arrival2.setEditable(false);
		arrival2.setBounds(142, 237, 134, 28);
		add(arrival2);
		arrival2.setColumns(10);
		
		
		
		
		
		JButton button = new JButton("提交");
		button.setBounds(451, 385, 117, 29);
		add(button);
		
		JLabel label_5 = new JLabel("日期");
		label_5.setBounds(856, 44, 61, 16);
		add(label_5);
		
		date1 = new JTextField();
		date1.setColumns(10);
		date1.setBounds(958, 38, 134, 28);
		add(date1);
		
		JLabel lblNewLabel = new JLabel("条形码");
		lblNewLabel.setBounds(856, 283, 61, 16);
		add(lblNewLabel);
		
		JLabel label_6 = new JLabel("中转单编号");
		label_6.setBounds(856, 82, 74, 16);
		add(label_6);
		
		transitnum1 = new JTextField();
		transitnum1.setColumns(10);
		transitnum1.setBounds(958, 76, 134, 28);
		add(transitnum1);
		
		JLabel label_7 = new JLabel("监装员");
		label_7.setBounds(856, 115, 61, 16);
		add(label_7);
		
		loader1 = new JTextField();
		loader1.setColumns(10);
		loader1.setBounds(958, 109, 134, 28);
		add(loader1);
		
		JLabel label_8 = new JLabel("出发地");
		label_8.setBounds(856, 153, 61, 16);
		add(label_8);
		
		JLabel label_9 = new JLabel("到达地");
		label_9.setBounds(856, 198, 61, 16);
		add(label_9);
		
		setout1 = new JTextField();
		setout1.setColumns(10);
		setout1.setBounds(958, 149, 134, 28);
		add(setout1);
		
		arrival1 = new JTextField();
		arrival1.setColumns(10);
		arrival1.setBounds(958, 192, 134, 28);
		add(arrival1);
		
		JButton button_1 = new JButton("确认");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				service = new TransitNoteInputBLService_Stub();
				TransitNoteOnTransitVO vo = new TransitNoteOnTransitVO(date1.getText(),transitnum1.getText(),null,setout1.getText(),
						arrival1.getText(),null,loader1.getText(),null);
				res = service.inputCenterTransitDoc(vo);
				if(res.isPass()){
					date2.setText(date1.getText());
					transitnum2.setText(transitnum1.getText());
					setout2.setText(setout1.getText());
					arrival2.setText(arrival1.getText());
					loader2.setText(loader1.getText());
				}else{
					checkstyleDialog checkstyle = new checkstyleDialog(res.getMessage());
					checkstyle.setVisible(true);
				}
				
				
				
			}
		});
		button_1.setBounds(1006, 238, 117, 29);
		add(button_1);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(958, 277, 134, 28);
		add(textField_10);
		
		JLabel label_10 = new JLabel("货柜号");
		label_10.setBounds(856, 335, 61, 16);
		add(label_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(958, 329, 134, 28);
		add(textField_11);
		
		name = new Vector();
		name.add("条形码");
		name.add("货柜号");
		data = new Vector();
		model = new DefaultTableModel();
		model.setDataVector(data, name);
		table = new JTable(model);
		table.setBounds(328, 92, 252, 259);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(328, 92, 252, 259);
		add(scrollPane);
		
		JButton button_2 = new JButton("添加");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//代写
				service = new TransitNoteInputBLService_Stub();
				TransitNoteOnTransitVO vo = new TransitNoteOnTransitVO(date1.getText(),transitnum1.getText(),null,setout1.getText(),
						arrival1.getText(),null,loader1.getText(),null);
			
			}
		});
		button_2.setBounds(1006, 385, 117, 29);
		add(button_2);
		
		
		
		
		scrollPane.setViewportView(table);

	}
	
	public void paintComponent(Graphics g) {
		 super.paintComponents(g);
		 //ImageIcon img = new ImageIcon("C:\\Users\\Administrator\\Desktop\\0011.jpg");
		// g.drawImage(img.getImage(), 0, 0, null);
		 float lineWidth = 3.0f;
	      ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
	      g.drawLine(768, 0, 768, 500);
		}
}
