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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.JTextField;

import util.LogInMsg;
import util.ResultMsg;
import vo.LoadNoteOnServiceVO;
import businesslogic.logistic.LoadNoteOnService;
import businesslogicservice.logisticblservice.LoadNoteOnServiceBLService;
import businesslogicservice.logisticblservice._Stub.LoadNoteOnServiceBLService_Stub;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import presentation.logisticui.ArrivalOrder.Submitter;
import presentation.util.Chachong;
import presentation.util.CleanTextField;
import presentation.util.CurrentTime;
import presentation.util.MJTextField;
import presentation.util.UnEditablePanel;

public class LoadCarOrder extends JPanel {
	//要用的借口
	private LoadNoteOnServiceBLService load= new LoadNoteOnService();
	private LoadNoteOnServiceVO  vo;
	private JPanel thisP=this;
	//不可编辑框
	private MJTextField data;
	private MJTextField service;
	private MJTextField to;
	private MJTextField scar;
	private MJTextField car;
	private MJTextField superman;
	private MJTextField senderman;
	//条形码table
	private JTable table;
	private DefaultTableModel model;
	private ArrayList<String> barcodes=new  ArrayList<String> ();
	//给查重用的arrayList
	private ArrayList<String> chachong=new  ArrayList<String> ();
	//可编辑textfield
	private JTextField dataf;
	private MJTextField servicecodef;
	private MJTextField carcodef;
	private MJTextField codef;
	private MJTextField tof;
	private MJTextField scarcodef;
	private MJTextField supermanf;
	private MJTextField sendmanf;
	private JLabel q;
	
	//button
	private JButton tianjia;//添加
	private JButton queren ;//确认
	private JButton confirm ;
	private JButton modify;
	private JButton delete;
	//frame传来的东东
	private LogInMsg lim;
	private Service frame;//


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
	public LoadCarOrder(LogInMsg lim,Service frame) {


		this.lim=lim;
		this.frame=frame;
		setSize(WIDTH,HEIGHT);
		setBackground(Color.WHITE);
		setLayout(null);

		JLabel label = new JLabel("日期");
		label.setBounds(58, 41, 54, 18);
		add(label);

		data = new MJTextField();
		data.setEnabled(false);
		data.setEditable(false);
		data.setBounds(146, 40, 124, 28);
		add(data);
		data.setColumns(10);

		JLabel label_1 = new JLabel("营业厅编号");
		label_1.setBounds(324, 43, 84, 15);
		add(label_1);

		service = new MJTextField();
		service.setEnabled(false);
		service.setEditable(false);
		service.setBounds(418, 40, 124, 28);
		add(service);
		service.setColumns(10);

		JLabel label_2 = new JLabel("目的地");
		label_2.setBounds(58, 96, 54, 15);
		add(label_2);

		to = new MJTextField();
		to.setEnabled(false);
		to.setEditable(false);
		to.setBounds(146, 94, 286, 28);
		add(to);
		to.setColumns(10);

		JLabel label_3 = new JLabel("车辆编号");
		label_3.setBounds(58, 150, 78, 15);
		add(label_3);

		scar = new MJTextField();
		scar.setEnabled(false);
		scar.setEditable(false);
		scar.setBounds(146, 147, 207, 28);
		add(scar);
		scar.setColumns(10);

		JLabel label_4 = new JLabel("汽运编号");
		label_4.setBounds(58, 206, 66, 15);
		add(label_4);

		car = new MJTextField();
		car.setEnabled(false);
		car.setEditable(false);
		car.setBounds(146, 203, 207, 28);
		add(car);
		car.setColumns(10);

		JLabel label_5 = new JLabel("监装员");
		label_5.setBounds(58, 251, 66, 15);
		add(label_5);

		superman = new MJTextField();
		superman.setEnabled(false);
		superman.setEditable(false);
		superman.setBounds(146, 248, 84, 28);
		add(superman);
		superman.setColumns(10);

		JLabel lblNewLabel = new JLabel("押运员");
		lblNewLabel.setBounds(58, 304, 54, 15);
		add(lblNewLabel);

		senderman = new MJTextField();
		senderman.setEnabled(false);
		senderman.setEditable(false);
		senderman.setBounds(146, 301, 84, 28);
		add(senderman);
		senderman.setColumns(10);

		JLabel label_6 = new JLabel("货物编码");
		label_6.setBounds(396, 150, 93, 15);
		add(label_6);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(226, 188, 147, -51);
		add(scrollPane);

		confirm = new JButton("提交");
		confirm.addActionListener(new submitListener() );
		confirm.setBounds(418, 370, 93, 23);
		add(confirm);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(376, 188, 224, 172);
		add(scrollPane_1);

		String[] columnNames =  
			{ "货物编码"};  

		Object[][] obj = new Object[1][1];  



		/* 
		 * JTable的其中一种构造方法 
		 */  
		model=new DefaultTableModel(obj,columnNames);
		table = new JTable(model);
		model.removeRow(0);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int selectedRow= table.getSelectedRow();
				Object oa=model.getValueAt(selectedRow, 0);
				codef.setText(oa.toString());
			}
		});
		/* 
		 * 设置JTable的列默认的宽度和高度 
		 */  
		TableColumn column = null;  
		int colunms = table.getColumnCount();  
		for(int i = 0; i < colunms; i++)  
		{  
			column = table.getColumnModel().getColumn(i);  
			/*将每一列的默认宽度设置为100*/  
			column.setPreferredWidth(200);  
		}  
		/* 
		 * 设置JTable自动调整列表的状态，此处设置为关闭 
		 */  
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  

		scrollPane_1.setViewportView(table);

		JLabel label_7 = new JLabel("日期");
		label_7.setBounds(WIDTHL, 10, 54, 15);
		add(label_7);

		dataf = new JTextField(CurrentTime.getCurrentTimeDate());
		dataf.setBounds(880, 7, 101, 28);
		add(dataf);
		dataf.setColumns(10);

		JLabel label_8 = new JLabel("营业厅编号");
		label_8.setBounds(787, 43, 93, 15);
		add(label_8);
		//自动填充
		servicecodef = new MJTextField(lim.getOrganization_id());
		servicecodef.setBounds(880, 40, 239, 28);
		add(servicecodef);
		servicecodef.setColumns(10);

		JLabel label_9 = new JLabel("汽运编号");
		label_9.setBounds(787, 81, 93, 15);
		add(label_9);

		carcodef = new MJTextField();
		carcodef.setBounds(1018, 78, 101, 28);
		add(carcodef);
		carcodef.setColumns(10);

		JLabel label_10 = new JLabel("目的地");
		label_10.setBounds(787, 122, 78, 15);
		add(label_10);

		JLabel label_11 = new JLabel("车辆编号");
		label_11.setBounds(787, 150, 93, 15);
		add(label_11);

		JLabel label_12 = new JLabel("监装员");
		label_12.setBounds(787, 188, 78, 15);
		add(label_12);

		JLabel label_13 = new JLabel("押运员");
		label_13.setBounds(787, 226, 78, 15);
		add(label_13);

		queren = new JButton("确认");
		queren.addActionListener(new confirmListener());
		queren.setBounds(995, 247, 93, 23);
		add(queren);

		JLabel label_14 = new JLabel("货物编码");
		label_14.setBounds(WIDTHL, 281, 78, 15);
		add(label_14);

		codef = new MJTextField();
		codef.setBounds(880, 280, 239, 28);
		add(codef);
		codef.setColumns(10);

		tianjia = new JButton("添加");
		tianjia.addActionListener(new addListener());
		tianjia.setBounds(787, 337, 93, 23);
		add(tianjia);

		tof = new MJTextField();
		tof.setBounds(880, 116, 239, 28);
		add(tof);
		tof.setColumns(10);

		scarcodef = new MJTextField();
		scarcodef.setBounds(880, 150, 239, 28);
		add(scarcodef);
		scarcodef.setColumns(10);

		supermanf = new MJTextField();
		supermanf.setBounds(880, 185, 101, 28);
		add(supermanf);
		supermanf.setColumns(10);

		sendmanf = new MJTextField();
		sendmanf.setBounds(880, 223, 101, 28);
		add(sendmanf);
		sendmanf.setColumns(10);

		JLabel label_15 = new JLabel("新增装车单");
		label_15.setBounds(28, 10, 84, 15);
		add(label_15);

		modify = new JButton("修改");
		modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow =table.getSelectedRow();
				if(selectedRow!=-1){
					String temp=model.getValueAt(selectedRow, 0).toString();
					LoadNoteOnServiceVO  vo=null;

					ArrayList<String> ba=new ArrayList<String>();
					if(Chachong.isRepeat(chachong,codef.getText())){
						//如果已经重复，则不能添加
						JOptionPane.showMessageDialog(null, "不能重复添加相同的条形码哦~", "友情提示",JOptionPane.WARNING_MESSAGE);  
						return;
					}
					//不重复，则加入
					chachong.remove(temp);
					chachong.add(codef.getText());
					ba.add(codef.getText());
					vo=new LoadNoteOnServiceVO ("2011-11-11","0251000","02510002015092100000","北京","025000000","厘米","厘米",ba);
					ResultMsg result=load.inputHallLoadDoc(vo);
					if(result.isPass()){//格式检查正确
						model.setValueAt(codef.getText(), selectedRow,0);
						codef.setText("");


					}
					else{//格式有误
						int result1 = JOptionPane.showConfirmDialog(null, result.getMessage(),"系统提示",
								JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

					}
				}
				else{
					//未选中提示要选中才能编辑哦；

					JOptionPane.showMessageDialog(null, "要选中表格中的一行才可以修改哦~", "友情提示",JOptionPane.WARNING_MESSAGE);  
				}
			}
		});
		modify.setBounds(905, 337, 93, 23);
		add(modify);

		delete = new JButton("删除");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow =table.getSelectedRow();
				if(selectedRow!=-1){
					//检查重复的array删
					chachong.remove(model.getValueAt(selectedRow, 0));
					model.removeRow(selectedRow);
				}
				else{
					//未选中提示要选中才能编辑哦；

					JOptionPane.showMessageDialog(null, "要选中表格中的一行才可以删除哦~", "友情提示",JOptionPane.WARNING_MESSAGE);  
				}
			}
		});
		delete.setBounds(1008, 337, 93, 23);
		add(delete);

		q = new JLabel(lim.getOrganization_id()+CurrentTime.getCurrentTimeDateSimple());
		q.setBounds(880, 78, 139, 28);
		add(q);

	}
	public class confirmListener implements ActionListener{

		LoadNoteOnServiceVO  vo=null;
		//初始化顺序问题
		public void actionPerformed(ActionEvent arg0) {
			ArrayList<String> ba=new ArrayList<String>();
			ba.add("0123456789");
			vo=new LoadNoteOnServiceVO (dataf.getText(),servicecodef.getText(),q.getText()+carcodef.getText(),tof.getText(),scarcodef.getText(),supermanf.getText(),sendmanf.getText(),ba);

			ResultMsg result=load.inputHallLoadDoc(vo);
			if(result.isPass()){//格式检查正确
				data.setText(dataf.getText());
				service.setText(servicecodef.getText());
				to.setText(tof.getText());
				scar.setText(scarcodef.getText());
				car.setText(q.getText()+carcodef.getText());
				superman.setText(supermanf.getText());
				senderman.setText(sendmanf.getText());
			}
			else{//格式有误
				int result1 = JOptionPane.showConfirmDialog(null, result.getMessage(),"系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

			}


		}
	}

	public class addListener implements ActionListener{
		LoadNoteOnServiceVO  vo=null;
		public void actionPerformed(ActionEvent e) {
			ArrayList<String> ba=new ArrayList<String>();

			if(Chachong.isRepeat(chachong,codef.getText())){
				//如果已经重复，则不能添加
				JOptionPane.showMessageDialog(null, "不能重复添加相同的条形码哦~", "友情提示",JOptionPane.WARNING_MESSAGE);  
				return;
			}
			chachong.add(codef.getText());
			ba.add(codef.getText());
			vo=new LoadNoteOnServiceVO ("2011-11-11","0251000","02510002015092100000","北京","025000000","厘米","厘米",ba);
			ResultMsg result=load.inputHallLoadDoc(vo);
			if(result.isPass()){//格式检查正确
				String[] s={codef.getText()};
				model.addRow(s);
				codef.setText("");
			}
			else{//格式有误
				int result1 = JOptionPane.showConfirmDialog(null, result.getMessage(),"系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

			}

		}


	}
	public class submitListener implements ActionListener{



		public void actionPerformed(ActionEvent e) {
			if(data.getText().isEmpty()){
				JOptionPane.showConfirmDialog(null, "有咚咚漏填啦","系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				return ;
			}
			if(model.getRowCount()==0){
				JOptionPane.showConfirmDialog(null, "有咚咚漏填啦","系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				return ;
			}
			int count=model.getRowCount();
			for(int i=0;i<count;i++){
				String cc=model.getValueAt(i, 0).toString();
				barcodes.add(cc);
			}
			vo=new LoadNoteOnServiceVO (data.getText(),service.getText(),car.getText(),to.getText(),scar.getText(),superman.getText(),senderman.getText(),barcodes);
			vo.setUserName(lim.getUserName());
			vo.setOrganization(lim.getOrganization());
			int result = JOptionPane.showConfirmDialog(null, "确认提交审批？","系统提示",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(result == JOptionPane.YES_OPTION) {
				//将提交放到新的线程中

				//提交之后panel里都不可编辑
				lock(false);
				//提交之后右下面板换
				frame.initZhuangche(true,false,false);
				//提交审批
				new Submitter().start();
			}
			else {
				return;

			}

		}
	}
	public void lock(boolean notlock){//解锁那些可以编辑的框框
		//notlock==true 不锁
		//textfield
		dataf.setEditable(notlock);
		dataf.setEnabled(notlock);
		servicecodef.setEditable(notlock);
		servicecodef.setEnabled(notlock);
		carcodef.setEditable(notlock);
		carcodef.setEnabled(notlock);
		codef.setEditable(notlock);
		codef.setEnabled(notlock);
		tof.setEditable(notlock);
		tof.setEnabled(notlock);
		scarcodef.setEditable(notlock);
		scarcodef.setEnabled(notlock);
		supermanf.setEditable(notlock);
		supermanf.setEnabled(notlock);
		sendmanf.setEditable(notlock);
		sendmanf.setEnabled(notlock);
		//button
		queren.setEnabled(notlock);
		tianjia.setEnabled(notlock);
		confirm.setEnabled(notlock);
		modify.setEnabled(notlock);
		delete.setEnabled(notlock);
	}
	public void setResult(ResultMsg s) {//审批之后才调这个方法
		//审批通没通过在这里体现
		frame.initZhuangche(false,s.isPass(),!s.isPass());
		frame.leftdown.repaint();
		lock(true);
		if(s.isPass()){//审批通过之后，清空textfiled
			//解锁那些可以编辑的框框
			//清空textfiled
			CleanTextField.clean(thisP);
			//然而日期还是要填上的
			dataf.setText(CurrentTime.getCurrentTimeDate());
			//jtable也要清空
			CleanTextField.cleanJtable(table);
		}
		else{//审批未通过
			JOptionPane.showConfirmDialog(null,s.getMessage() ,"系统提示",
					JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);
			//解锁那些可以编辑的框框
		}

	}
	class Submitter extends Thread {

		public void run() {
			super.run();
			//			ResultMsg result=load.submitHallLoadDoc(vo);
			//			setResult(result);
			setResult(load.submitHallLoadDoc(vo));
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		ImageIcon img = new ImageIcon("image/0111.jpg");
		g.drawImage(img.getImage(), 0, 0, null);
		float lineWidth = 3.0f;
		((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
		g.drawLine(WIDTH/3*2, 0, WIDTH/3*2, HEIGHT);
	}
}
