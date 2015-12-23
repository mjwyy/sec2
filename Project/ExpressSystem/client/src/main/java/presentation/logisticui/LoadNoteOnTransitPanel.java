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

import presentation.logisticui.ReceiveOrderPanel.Submitter;
import presentation.util.Chachong;
import presentation.util.CurrentTime;
import presentation.util.EditableTrue;
import presentation.util.GetTime;
import presentation.util.MJTextField;
import presentation.util.UnEditablePanel;
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
	LoadNoteOnTransitPanel thisP = this;
	private JTextField date2;
	private JTextField trucknum2;
	private JTextField carnum2;
	private JTextField supervisor2;
	private JTextField escort2;
	private JTextField destination2;
	private MJTextField date1;
	private MJTextField destination1;
	private MJTextField trucknum1;
	private MJTextField carnum;
	private MJTextField supervisor1;
	private MJTextField escort1;
	private MJTextField addbarcode;
	private JTable table;
	private DefaultTableModel model;
	private Vector name;
	private Vector data;
	private LoadNoteOnTransitBLService service = new LoadNoteOnTransit() ;
	private ResultMsg res;
	private ArrayList<String> goodsbarcode = new ArrayList<String>();
	private LoadNoteOnTransitVO loadNoteOnTransitVO;
	private  LogInMsg lim ;
	private int seletedRow = -1;
	private TransitFrame parent;
	private JButton confirm ;
	private JButton modify;
	private JButton submit;
	private JButton add;
	private JButton delete;
	private JLabel lblNewLabel;
	

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
	public LoadNoteOnTransitPanel( LogInMsg  logInMsg,TransitFrame frame) {
		parent = frame;
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
	          		}
	        	}
	        });
		
		
		submit = new JButton("提交");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//判断单据是否填写完整
				if((!goodsbarcode.isEmpty())&&(!date2.getText().isEmpty())){
				 loadNoteOnTransitVO = new LoadNoteOnTransitVO(date2.getText(), trucknum2.getText(),destination2.getText(), 
						                 carnum2.getText(),supervisor2.getText(), escort2.getText(), goodsbarcode);
				 loadNoteOnTransitVO.setUserName(lim.getUserName());
				 loadNoteOnTransitVO.setOrganization(lim.getOrganization());
				 UnEditablePanel.UnEdit(LoadNoteOnTransitPanel.this);
					add.setEnabled(false);
					submit.setEnabled(false);
					delete.setEnabled(false);
					modify.setEnabled(false);
					confirm.setEnabled(false);
				 parent.setZhongzhuan(true, false, false);
				 parent.setLoadNoteOnTransitpanel(thisP);
				 new Submitter().start();
				
				
			}else{
				int result1 = JOptionPane.showConfirmDialog(null, "有咚咚木有填","系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			}
		  }
		});
		submit.setBounds(506, 378, 117, 29);
		add(submit);
		
		JLabel label_6 = new JLabel("日期");
		label_6.setBounds(811, 54, 61, 16);
		add(label_6);
		
		JLabel label_7 = new JLabel("到达地");
		label_7.setBounds(811, 94, 61, 16);
		add(label_7);
		
		JLabel label_8 = new JLabel("汽运编号");
		label_8.setBounds(811, 139, 61, 16);
		add(label_8);
		
		JLabel label_9 = new JLabel("车辆代号");
		label_9.setBounds(811, 182, 61, 16);
		add(label_9);
		
		JLabel label_10 = new JLabel("监装员");
		label_10.setBounds(811, 223, 61, 16);
		add(label_10);
		
		JLabel label_11 = new JLabel("押运员");
		label_11.setBounds(811, 262, 61, 16);
		add(label_11);
		
		CurrentTime currentTime = new CurrentTime();
		date1 = new MJTextField();
		date1.setText(currentTime.getCurrentTimeDate());
		date1.setColumns(10);
		date1.setBounds(930, 48, 134, 28);
		add(date1);
		
		destination1 = new MJTextField();
		destination1.setColumns(10);
		destination1.setBounds(930, 88, 134, 28);
		add(destination1);
		
		trucknum1 = new MJTextField();
		trucknum1.setText("1234567");
		trucknum1.setColumns(10);
		trucknum1.setBounds(1018, 133, 79, 28);
		add(trucknum1);
		
		carnum = new MJTextField();
		carnum.setColumns(10);
		carnum.setBounds(930, 176, 134, 28);
		add(carnum);
		
		supervisor1 = new MJTextField();
		supervisor1.setColumns(10);
		supervisor1.setBounds(930, 217, 134, 28);
		add(supervisor1);
		
		escort1 = new MJTextField();
		escort1.setColumns(10);
		escort1.setBounds(930, 256, 134, 28);
		add(escort1);
		
		confirm = new JButton("确认");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//下面伪造barcode，以便构造vo
				ArrayList<String> s = new ArrayList<String>();
				s.add("1234567890");
				if(date1.getText().isEmpty()||escort1.getText().isEmpty()||supervisor1.getText().isEmpty()||trucknum1.getText().isEmpty()||
						destination1.getText().isEmpty()||carnum.getText().isEmpty()){
					int result1 = JOptionPane.showConfirmDialog(null, "有咚咚木有填","系统提示",
							JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);
					
				}else{
				LoadNoteOnTransitVO vo = new LoadNoteOnTransitVO(date1.getText(), lim.getOrganization_id()+GetTime.getTime(date1.getText())+trucknum1.getText(),destination1.getText(), 
						carnum.getText(),supervisor1.getText(), escort1.getText(), s);
				res = service.inputCenterLoadDoc(vo);//格式检查
				//格式通过
				if(res.isPass()){
					date2.setText(date1.getText());
					trucknum2.setText(lim.getOrganization_id()+GetTime.getTime(date1.getText())+trucknum1.getText());
					destination2.setText(destination1.getText());
					carnum2.setText(carnum.getText());
					supervisor2.setText(supervisor1.getText());
					escort2.setText(escort1.getText());					
				}else{//格式未通过，返回错误信息
					int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				}
				
				}
			}
		});
		confirm.setBounds(1009, 299, 117, 29);
		add(confirm);
		
		JLabel label_12 = new JLabel("条形码");
		label_12.setBounds(822, 346, 61, 16);
		add(label_12);
		
		addbarcode = new MJTextField();
		addbarcode.setBounds(930, 340, 134, 28);
		add(addbarcode);
		addbarcode.setColumns(10);
		
		
		//添加条形码
		add = new JButton("ADD");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addBarcode();
				
			}
		});
		add.setBounds(1037, 378, 89, 29);
		add(add);
		
        delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(seletedRow != -1){
				model.removeRow(seletedRow);
				goodsbarcode.remove(seletedRow);
				seletedRow = -1;	
			}else {
				JOptionPane.showConfirmDialog(null, "尼木有选择要删除的行哦！","系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			}
			}
		});
		delete.setBounds(842, 378, 89, 28);
		add(delete);
		
		modify = new JButton("MODIFY");
		modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(seletedRow != -1){
					model.removeRow(seletedRow);
					goodsbarcode.remove(seletedRow);
					seletedRow = -1;	
					addBarcode();
				}else {
					JOptionPane.showConfirmDialog(null, "尼木有选择要修改的行哦！","系统提示",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				}
			}
		});
		modify.setBounds(940, 378, 89, 29);
		add(modify);
		
		lblNewLabel = new JLabel(lim.getOrganization_id()+GetTime.getTime(date1.getText()));
		lblNewLabel.setBounds(873, 139, 144, 16);
		add(lblNewLabel);

	}
	
	
	public  LoadNoteOnTransitVO getVO(){
		return  loadNoteOnTransitVO;
	}
	
	public void setResult(ResultMsg s) {
	parent.setZhongzhuan(false, s.isPass(), !s.isPass());
		parent.leftdown.repaint();
		if(s.isPass()){
			parent.setLoadNoteOnTransitpanel(null);
		}else{
			int result1 = JOptionPane.showConfirmDialog(null, s.getMessage(),"系统提示",
					JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);
			EditableTrue.Edit(thisP);
			date2.setEditable(false);
			trucknum2.setEditable(false);
			destination2.setEditable(false);
			carnum2.setEditable(false);
			supervisor2.setEditable(false);
			escort2.setEditable(false);	
			add.setEnabled(true);
			submit.setEnabled(true);
			delete.setEnabled(true);
			modify.setEnabled(true);
			confirm.setEnabled(true);
		}
		
		}
	
	class Submitter extends Thread {
		@Override
		public void run() {
			super.run();
			setResult(service.submitCenterLoadDoc(loadNoteOnTransitVO));
		}
	}
	
	public void addBarcode() {
		if(!addbarcode.getText().isEmpty()){
		ArrayList<String> barcode = new ArrayList<String>();
		barcode.add(addbarcode.getText());
		LoadNoteOnTransitVO vo = new LoadNoteOnTransitVO("2015-09-09", "025000201509091234567","上海", 
				"025010222","汪文藻", "汪文藻", barcode);
		if(Chachong.isRepeat(goodsbarcode, addbarcode.getText())){
			JOptionPane.showConfirmDialog(null, "该条形码已经存在","系统提示",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		}else{
		res = service.inputCenterLoadDoc(vo);//格式检查
		if(res.isPass()){
			Vector row = new Vector();
			row.add(addbarcode.getText());
			data.add(row.clone());
			model.setDataVector(data, name);
			table.setModel(model);
			goodsbarcode.add(addbarcode.getText());
			addbarcode.setText("");			
		}
		else{
			int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		}
		}
		}else {
			JOptionPane.showConfirmDialog(null, "要填好条形码哦！亲","系统提示",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		}
	}
}
