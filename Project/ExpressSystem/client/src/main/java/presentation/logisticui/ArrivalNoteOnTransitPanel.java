package presentation.logisticui;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.table.AbstractTableModel;

import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

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
import java.awt.SystemColor;

public class ArrivalNoteOnTransitPanel extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField barcode;
	private JTextField departureText;
	private JTextField transformNum;
	private JTextField textField_5;
	private JTextField textField_6;
	private ArrivalNoteOnTransitBLService service;
	private BarcodeAndState brcodeAndState;
	private ResultMsg res;
	private JTextField box;
	

	/**
	 * Create the panel.
	 */
	
	 /*public static void main(String[] args){
		JFrame f = new JFrame();
		ArrivalNoteOnTransitPanel p = new ArrivalNoteOnTransitPanel();
		p.setVisible(true);
		f.setSize(900,456);
	f.getContentPane().add(p);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}*/
	public ArrivalNoteOnTransitPanel() {
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel.setBounds(0, 0, 488, 390);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_3 = new JLabel("到达日期");
		lblNewLabel_3.setBounds(19, 21, 61, 16);
		panel.add(lblNewLabel_3);
		
		textField_5 = new JTextField();
		textField_5.setEnabled(false);
		textField_5.setToolTipText("");
		textField_5.setBounds(79, 15, 134, 30);
		panel.add(textField_5);
		textField_5.setColumns(10);
		
		JLabel label_3 = new JLabel("中转中心编号");
		label_3.setBounds(226, 21, 78, 16);
		panel.add(label_3);
		
		textField_6 = new JTextField();
		textField_6.setEnabled(false);
		textField_6.setBounds(308, 15, 134, 30);
		panel.add(textField_6);
		textField_6.setColumns(10);
		
		
		final JTable table = new JTable();
		table.setBounds(33, 65, 409, 263);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(33, 65, 409, 246);
		panel.add(scrollPane);
		
		JButton button_1 = new JButton("提交");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		button_1.setBounds(353, 344, 117, 30);
		panel.add(button_1);
												
	    JLabel lblNewLabel = new JLabel("到达日期");
		lblNewLabel.setBounds(491, 26, 61, 16);
		add(lblNewLabel);
												
												
		textField_1 = new JTextField();
		textField_1.setBounds(577, 19, 134, 30);
		add(textField_1);
												
		textField_1.setColumns(10);
												
		JLabel lblNewLabel_1 = new JLabel("中转中心编号");
		lblNewLabel_1.setBounds(491, 68, 89, 16);
		add(lblNewLabel_1);
												
												
		textField= new JTextField();
		textField.setBounds(577, 61, 134, 30);
		add(textField);										
	    textField.setColumns(10);
												
	    JButton btnNewButton = new JButton("确认");
		btnNewButton.setBounds(602, 103, 117, 30);
		add(btnNewButton);	
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ArrivalNoteOnTransitVO vo = new ArrivalNoteOnTransitVO(null,textField_1.getText(),textField.getText(),null,null);
				//格式检查
			   // res = service.inputCenterArrivalDoc(vo);
				//正确则信息填入那边
				///if(res.isPass()){
					//textField_5.setText(textField_1.getText());
					///textField_6.setText(textField.getText());
				//}
				/*else{
					checkstyleDialog checkstyle = new checkstyleDialog(res.getMessage());
					checkstyle.setVisible(true);
			}*/
			}
		});
												
        JLabel label = new JLabel("条形码");
		label.setBounds(491, 145, 61, 16);
		add(label);
												
		
		barcode = new JTextField();
		barcode.setBounds(577, 138, 134, 30);
		add(barcode);
		barcode.setColumns(10);
		
		JLabel departture = new JLabel("出发地");
	    departture.setBounds(491, 193, 61, 16);
        add(departture);
															
        JLabel label_2 = new JLabel("中转单编号");
		label_2.setBounds(491, 246, 74, 16);
		add(label_2);
		
		JLabel label_1 = new JLabel("货运状态");
		label_1.setBounds(491, 284, 61, 16);
		add(label_1);
		String[] state = {"完好","缺损","丢失"};
		final JComboBox comboBox = new JComboBox(state);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				box.setText((String)comboBox.getSelectedItem());
			}
		});
		comboBox.setBackground(SystemColor.textHighlight);
		//comboBox.insertItemAt("完好", 0);
		//comboBox.setSelectedIndex(0);
		comboBox.setBounds(577, 280, 134, 27);
		add(comboBox);
		//comboBox.setModel(new DefaultComboBoxModel(new String[] {"完好","缺损","丢失"}));
		box = new JTextField();
		box.setBounds(577, 278, 134, 28);
		box.setText((String)comboBox.getSelectedItem());
		add(box);
		box.setColumns(10);
																
		departureText = new JTextField();
		departureText.setBounds(577, 186, 134, 30);
		add(departureText);
	    departureText.setColumns(10);													
																		
	    transformNum = new JTextField();
		transformNum.setBounds(577, 239, 134, 30);
		add(transformNum);
		transformNum.setColumns(10);
			
			JButton button = new JButton("添加");
			button.setBounds(613, 343, 117, 30);
			add(button);
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
							null,departureText.getText(),bas);
					res = service.inputCenterArrivalDoc(vo);
					if(res.isPass()){
						ArrivalNoteInfo ani = new ArrivalNoteInfo(barcode.getText(),transformNum.getText(),
								departureText.getText(),(String)comboBox.getSelectedItem());
						
						
						
					}else{
						checkstyleDialog checkstyle = new checkstyleDialog(res.getMessage());
						checkstyle.setVisible(true);
					}
					
				}
			});																
																	
	}
	
	
	
	class ArrivalNoteInfo extends AbstractTableModel{
        private  String[] columnNames = { "条形码", "货运状态", "出发地",
                "中转单编号" };
        private String[] data;
        
        public ArrivalNoteInfo(String barcode,String transform,String departure,String state){
        	this.data = new String[]{barcode,transform,departure,state};	
        }
        		
        

		@Override
		public int getRowCount() {
			// TODO Auto-generated method stub
			return 0;
		}
		
		public String[] getData(){
			return data;
		}

		@Override
		public int getColumnCount() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
}
