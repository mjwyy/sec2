package presentation.logisticui;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import presentation.financeui.PaymentInputPanel;
import presentation.util.checkstyleDialog;
import util.BarcodeAndState;
import util.ResultMsg;
import util.enums.GoodsState;
import vo.ArrivalNoteOnTransitVO;

import javax.swing.JTextArea;

import businesslogicservice.logisticblservice.ArrivalNoteOnTransitBLService;
import businesslogicservice.logisticblservice._Stub.ArrivalNoteOnTransitBLService_Stub;

import java.awt.SystemColor;

public class ArrivalNoteOnTransitPanel extends JPanel {
	private JTextField centrenum1;
	private JTextField date1;
	private JTextField barcode;
	private JTextField departure1;
	private JTextField transformNum;
	private ArrivalNoteOnTransitBLService service;
	private BarcodeAndState brcodeAndState;
	private ResultMsg res;
	private JTextField box;
	private JTextField date2;
	private JTextField centrenum2;
	private JTable table;
	private DefaultTableModel model;
	private Vector name;
	private Vector data;

	/**
	 * Create the panel.
	 */
	
	 public static void main(String[] args){
		JFrame f = new JFrame();
		ArrivalNoteOnTransitPanel p = new ArrivalNoteOnTransitPanel();
		p.setVisible(true);
		f.setSize(1150,444);
	f.getContentPane().add(p);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public ArrivalNoteOnTransitPanel() {
		setBackground(SystemColor.window);
		setSize(1152,446);									
	    setLayout(null);
	    JLabel lblNewLabel = new JLabel("到达日期");
	    lblNewLabel.setBounds(869, 39, 61, 16);
		add(lblNewLabel);
												
												
		date1 = new JTextField();
		date1.setBounds(970, 32, 134, 30);
		add(date1);
												
		date1.setColumns(10);
												
		JLabel lblNewLabel_1 = new JLabel("中转中心编号");
		lblNewLabel_1.setBounds(869, 88, 89, 16);
		add(lblNewLabel_1);
												
												
		centrenum1= new JTextField();
		centrenum1.setBounds(970, 81, 134, 30);
		add(centrenum1);										
	    centrenum1.setColumns(10);
												
	    JButton btnNewButton = new JButton("确认");
	    btnNewButton.setBounds(1014, 120, 117, 30);
		add(btnNewButton);	
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrivalNoteOnTransitVO vo = new ArrivalNoteOnTransitVO(null,centrenum1.getText(),date1.getText(),null,null);
				service = new ArrivalNoteOnTransitBLService_Stub();
				//格式检查
			    res = service.inputCenterArrivalDoc(vo);
				//正确则信息填入那边
				if(res.isPass()){
					date2.setText(date1.getText());
					centrenum2.setText(centrenum1.getText());
				}
				else{
					checkstyleDialog checkstyle = new checkstyleDialog(res.getMessage());
					checkstyle.setVisible(true);
			}
			}
		});
												
        JLabel label = new JLabel("条形码");
        label.setBounds(869, 189, 61, 16);
		add(label);
												
		
		barcode = new JTextField();
		barcode.setBounds(970, 182, 134, 30);
		add(barcode);
		barcode.setColumns(10);
		
		JLabel departture = new JLabel("出发地");
		departture.setBounds(869, 239, 61, 16);
        add(departture);
															
        JLabel label_2 = new JLabel("中转单编号");
        label_2.setBounds(869, 294, 74, 16);
		add(label_2);
		
		JLabel label_1 = new JLabel("货运状态");
		label_1.setBounds(869, 345, 61, 16);
		add(label_1);
		String[] state = {"完好","缺损","丢失"};
		final JComboBox comboBox = new JComboBox(state);
		comboBox.setBounds(970, 341, 134, 27);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				box.setText((String)comboBox.getSelectedItem());
			}
		});
		comboBox.setBackground(SystemColor.textHighlight);
		add(comboBox);
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"完好","缺损","丢失"}));
		box = new JTextField();
		box.setBounds(970, 339, 134, 28);
		box.setText((String)comboBox.getSelectedItem());
		add(box);
		box.setColumns(10);
																
		departure1 = new JTextField();
		departure1.setBounds(970, 232, 134, 30);
		add(departure1);
	    departure1.setColumns(10);													
																		
	    transformNum = new JTextField();
	    transformNum.setBounds(970, 287, 134, 30);
		add(transformNum);
		transformNum.setColumns(10);
			
			JButton button = new JButton("添加");
			button.setBounds(1014, 390, 117, 30);
			add(button);
			
			JLabel arrivaldateLabel = new JLabel("到达日期");
			arrivaldateLabel.setBounds(58, 39, 61, 16);
			add(arrivaldateLabel);
			
			date2 = new JTextField();
			date2.setEditable(false);
			date2.setBounds(145, 33, 134, 28);
			add(date2);
			date2.setColumns(10);
			
			JLabel centerNum = new JLabel("中转中心编号");
			centerNum.setBounds(442, 39, 89, 16);
			add(centerNum);
			
			centrenum2 = new JTextField();
			centrenum2.setEditable(false);
			centrenum2.setBounds(574, 33, 134, 28);
			add(centrenum2);
			centrenum2.setColumns(10);
					
			name = new Vector();
			name.add("条形码");
			name.add("中转单编号");
			name.add("出发地");
			name.add("货运状态");
			data = new Vector();
			model = new DefaultTableModel();
			model.setDataVector(data,name);
			table = new JTable(model);
			table.setBounds(59, 87, 649, 273);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(59, 87, 649, 273);
			add(scrollPane);
			
			
			JButton button_1 = new JButton("提交");
			button_1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//弹出dialog 要求确认信息
					ArrivalNoteOnTransitVO vo = new ArrivalNoteOnTransitVO(date1.getText(),null,centrenum1.getText(),null,null);
					
					
				}
			});
			button_1.setBounds(591, 391, 117, 29);
			add(button_1);
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					ArrayList<BarcodeAndState> bas = new ArrayList<BarcodeAndState>();
					if(comboBox.getSelectedItem().equals("完整"))
					    brcodeAndState = new BarcodeAndState(barcode.getText(),GoodsState.COMPLETE);
					else if(comboBox.getSelectedItem().equals("缺损"))
						brcodeAndState = new BarcodeAndState(barcode.getText(),GoodsState.DAMAGED);
					else
						brcodeAndState = new BarcodeAndState(barcode.getText(),GoodsState.LOST);
					bas.add(brcodeAndState);
					ArrivalNoteOnTransitVO vo = new ArrivalNoteOnTransitVO(transformNum.getText(),null,
							null,departure1.getText(),bas);
					res = service.inputCenterArrivalDoc(vo);
					if(res.isPass()){
						//ArrivalNoteInfo ani = new ArrivalNoteInfo(barcode.getText(),transformNum.getText(),
								//departureText.getText(),(String)comboBox.getSelectedItem());
						
						
						
					}else{
						checkstyleDialog checkstyle = new checkstyleDialog(res.getMessage());
						checkstyle.setVisible(true);
					}
					
				}
			});																
																	
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
	
	


