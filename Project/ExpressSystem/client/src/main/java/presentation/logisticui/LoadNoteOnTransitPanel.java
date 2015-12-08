package presentation.logisticui;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;

import presentation.util.CurrentTime;
import presentation.util.checkstyleDialog;
import util.LogInMsg;
import util.ResultMsg;
import vo.LoadNoteOnTransitVO;
import businesslogic.logistic.LoadNoteOnTransit;
import businesslogicservice.logisticblservice.LoadNoteOnTransitBLService;
import businesslogicservice.logisticblservice._Stub.LoadNoteOnTransitBLService_Stub;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class LoadNoteOnTransitPanel extends JPanel {
	private JTextField date2;
	private JTextField trucknum2;
	private JTextField carnum2;
	private JTextField supervisor2;
	private JTextField escort2;
	private JTextField destination2;
	private JTextField date1;
	private JTextField destination1;
	private JTextField trucknum1;
	private JTextField carnum;
	private JTextField supervisor1;
	private JTextField escort1;
	private JTextField addbarcode;
	private JTable table;
	private DefaultTableModel model;
	private Vector name;
	private Vector data;
	private LoadNoteOnTransitBLService service = new LoadNoteOnTransit() ;
	private ResultMsg res;
	private ArrayList<String> goodsbarcode = new ArrayList<String>();
	private LoadNoteOnTransitVO loadNoteOnTransitVO;
	private  LogInMsg lim ;
	private int seletedRow;

	/**
	 * Create the panel.
	 */
	
	
	 public static void main(String[] args){
		/*JFrame f = new JFrame();
		LoadNoteOnTransitPanel p = new LoadNoteOnTransitPanel();
		p.setVisible(true);
		f.setSize(1150,446);
	f.getContentPane().add(p);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
	}
	public LoadNoteOnTransitPanel( LogInMsg  logInMsg) {
		setSize(1152,446);
		setLayout(null);
		lim = logInMsg;
		JLabel label = new JLabel("日期");
		label.setBounds(64, 54, 61, 16);
		add(label);
		
		JLabel label_1 = new JLabel("汽运编号");
		label_1.setBounds(64, 120, 61, 16);
		add(label_1);
		
		JLabel label_2 = new JLabel("车辆代号");
		label_2.setBounds(64, 182, 61, 16);
		add(label_2);
		
		JLabel label_3 = new JLabel("监装员");
		label_3.setBounds(64, 239, 61, 16);
		add(label_3);
		
		JLabel label_4 = new JLabel("押运员");
		label_4.setBounds(64, 298, 61, 16);
		add(label_4);
		
		date2 = new JTextField();
		date2.setEditable(false);
		date2.setBounds(138, 48, 134, 28);
		add(date2);
		date2.setColumns(10);
		
		trucknum2 = new JTextField();
		trucknum2.setEditable(false);
		trucknum2.setColumns(10);
		trucknum2.setBounds(138, 114, 134, 28);
		add(trucknum2);
		
		carnum2 = new JTextField();
		carnum2.setEditable(false);
		carnum2.setColumns(10);
		carnum2.setBounds(138, 176, 134, 28);
		add(carnum2);
		
		supervisor2 = new JTextField();
		supervisor2.setEditable(false);
		supervisor2.setColumns(10);
		supervisor2.setBounds(138, 233, 134, 28);
		add(supervisor2);
		
		escort2 = new JTextField();
		escort2.setEditable(false);
		escort2.setColumns(10);
		escort2.setBounds(138, 298, 134, 28);
		add(escort2);
		
		destination2 = new JTextField();
		destination2.setEditable(false);
		destination2.setColumns(10);
		destination2.setBounds(456, 48, 134, 28);
		add(destination2);
		
		JLabel label_5 = new JLabel("到达地");
		label_5.setBounds(383, 54, 61, 16);
		add(label_5);
		
		name = new Vector();
		name.add("条形码");
		data = new Vector();
		model = new DefaultTableModel();
		model.setDataVector(data, name);
		table = new JTable(model);
		table.setBounds(383, 120, 206, 234);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(383, 120, 206, 234);
		add(scrollPane);
		
		  table.addMouseListener(new MouseAdapter() {
	        	public void mouseClicked(MouseEvent arg0) {
	        		 seletedRow = table.getSelectedRow();
	          		if(seletedRow != -1){
	            		addbarcode.setText(model.getValueAt(seletedRow, 0).toString());
	            		//System.out.println("lalllla");
	          		}
	        	}
	        });
		
		
		JButton button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//判断单据是否填写完整
				if(!goodsbarcode.isEmpty()){
				 loadNoteOnTransitVO = new LoadNoteOnTransitVO(date2.getText(), trucknum2.getText(),destination2.getText(), 
						                 carnum2.getText(),supervisor2.getText(), escort2.getText(), goodsbarcode);
				 loadNoteOnTransitVO.setUserName(lim.getUserName());
				 loadNoteOnTransitVO.setOrganization(lim.getOrganization());
				service.submitCenterLoadDoc(loadNoteOnTransitVO);
				date1.setEditable(false); 
				trucknum1.setEditable(false);
				destination1.setEditable(false);; 
				carnum.setEditable(false);;
				supervisor1.setEditable(false);;
				escort1.setEditable(false);
				addbarcode.setEditable(false);
				
			}else{
				int result1 = JOptionPane.showConfirmDialog(null, "请将装车单填写完整","系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			}
		  }
		});
		button.setBounds(506, 378, 117, 29);
		add(button);
		
		JLabel label_6 = new JLabel("日期");
		label_6.setBounds(842, 54, 61, 16);
		add(label_6);
		
		JLabel label_7 = new JLabel("到达地");
		label_7.setBounds(842, 94, 61, 16);
		add(label_7);
		
		JLabel label_8 = new JLabel("汽运编号");
		label_8.setBounds(842, 139, 61, 16);
		add(label_8);
		
		JLabel label_9 = new JLabel("车辆代号");
		label_9.setBounds(842, 182, 61, 16);
		add(label_9);
		
		JLabel label_10 = new JLabel("监装员");
		label_10.setBounds(842, 223, 61, 16);
		add(label_10);
		
		JLabel label_11 = new JLabel("押运员");
		label_11.setBounds(842, 262, 61, 16);
		add(label_11);
		
		CurrentTime currentTime = new CurrentTime();
		date1 = new JTextField();
		date1.setText(currentTime.getCurrentTimeSecond());
		date1.setColumns(10);
		date1.setBounds(930, 48, 134, 28);
		add(date1);
		
		destination1 = new JTextField();
		destination1.setColumns(10);
		destination1.setBounds(930, 88, 134, 28);
		add(destination1);
		
		trucknum1 = new JTextField();
		trucknum1.setColumns(10);
		trucknum1.setBounds(930, 133, 134, 28);
		add(trucknum1);
		
		carnum = new JTextField();
		carnum.setColumns(10);
		carnum.setBounds(930, 176, 134, 28);
		add(carnum);
		
		supervisor1 = new JTextField();
		supervisor1.setColumns(10);
		supervisor1.setBounds(930, 217, 134, 28);
		add(supervisor1);
		
		escort1 = new JTextField();
		escort1.setColumns(10);
		escort1.setBounds(930, 256, 134, 28);
		add(escort1);
		
		JButton button_1 = new JButton("确认");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//下面伪造barcode，以便构造vo
				ArrayList<String> s = new ArrayList<String>();
				s.add("1234567890");
				
				LoadNoteOnTransitVO vo = new LoadNoteOnTransitVO(date1.getText(), trucknum1.getText(),destination1.getText(), 
						carnum.getText(),supervisor1.getText(), escort1.getText(), s);
				res = service.inputCenterLoadDoc(vo);//格式检查
				//格式通过
				if(res.isPass()){
					date2.setText(date1.getText());
					trucknum2.setText(trucknum1.getText());
					destination2.setText(destination1.getText());
					carnum2.setText(carnum.getText());
					supervisor2.setText(supervisor1.getText());
					escort2.setText(escort1.getText());					
				}else{//格式未通过，返回错误信息
					int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				}
				
				
			}
		});
		button_1.setBounds(1009, 299, 117, 29);
		add(button_1);
		
		JLabel label_12 = new JLabel("条形码");
		label_12.setBounds(842, 338, 61, 16);
		add(label_12);
		
		addbarcode = new JTextField();
		addbarcode.setBounds(930, 340, 134, 28);
		add(addbarcode);
		addbarcode.setColumns(10);
		
		
		//添加条形码
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<String> barcode = new ArrayList<String>();
				barcode.add(addbarcode.getText());
				LoadNoteOnTransitVO vo = new LoadNoteOnTransitVO(date2.getText(), trucknum2.getText(),destination2.getText(), 
						carnum2.getText(),supervisor2.getText(), escort2.getText(), barcode);
				res = service.inputCenterLoadDoc(vo);//格式检查
				if(res.isPass()){
					Vector row = new Vector();
					row.add(addbarcode.getText());
					data.add(row.clone());
					model.setDataVector(data, name);
					table.setModel(model);
					addbarcode.setText("");
					goodsbarcode.add(addbarcode.getText());
					
				}
				else{
					int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				}
				
				
			}
		});
		btnAdd.setBounds(1037, 378, 89, 29);
		add(btnAdd);
		
		JButton btnNewButton = new JButton("DELETE");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(seletedRow != -1)
				model.removeRow(seletedRow);
			}
		});
		btnNewButton.setBounds(842, 378, 89, 28);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("MODIFY");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(seletedRow != -1){
					model.removeRow(seletedRow);
					ArrayList<String> barcode = new ArrayList<String>();
					barcode.add(addbarcode.getText());
					LoadNoteOnTransitVO vo = new LoadNoteOnTransitVO(date2.getText(), trucknum2.getText(),destination2.getText(), 
							carnum2.getText(),supervisor2.getText(), escort2.getText(), barcode);
					res = service.inputCenterLoadDoc(vo);//格式检查
					if(res.isPass()){
						Vector row = new Vector();
						row.add(addbarcode.getText());
						data.add(row.clone());
						model.setDataVector(data, name);
						table.setModel(model);
						addbarcode.setText("");
						goodsbarcode.add(addbarcode.getText());
						
					}
					else{
						int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
								JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					}
					
				}
			}
		});
		btnNewButton_1.setBounds(940, 378, 89, 29);
		add(btnNewButton_1);

	}
	
	
	public  LoadNoteOnTransitVO getVO(){
		return  loadNoteOnTransitVO;
	}
}
