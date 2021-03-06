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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import presentation.logisticui.ArrivalOrder.Submitter;
import presentation.util.Chachong;
import presentation.util.CleanTextField;
import presentation.util.CurrentTime;
import presentation.util.MJTextField;
import presentation.util.UnEditablePanel;
import util.LogInMsg;
import util.ResultMsg;
import vo.DeliverNoteOnServiceVO;
import businesslogic.logistic.ArrivalNoteOnService;
import businesslogicservice.logisticblservice.ArrivalNoteOnServiceBLService;
import businesslogicservice.logisticblservice._Stub.ArrivalNoteOnServiceBLService_Stub;

public class SendOrder extends JPanel {
	//
	//	ArrivalNoteOnServiceBLService arr=new ArrivalNoteOnServiceBLService_Stub();
	ArrivalNoteOnServiceBLService arr=new ArrivalNoteOnService();
	private JPanel thisP=this;
	private 	DeliverNoteOnServiceVO vo;
	//不可编辑框
	private MJTextField sendcode;
	private MJTextField data;
	private MJTextField sender;
	//可编辑框
	private JTextField dataf;
	private MJTextField codef;
	private MJTextField senderf;
	private MJTextField sendcodef;
	//条形码表格
	private JTable table;
	private DefaultTableModel model;
	private ArrayList<String> BarCode=new ArrayList<String>();

	//给查重用的arrayList
	private ArrayList<String> chachong=new  ArrayList<String> ();
	//frame传来的东东
	private LogInMsg lim;
	private Service frame;//
	//button
	private JButton tianjia;
	private JButton queren ;
	private JButton confirm;
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

	public SendOrder(LogInMsg lim,Service frame) {
		this.lim=lim;
		this.frame=frame;
		setSize(WIDTH,HEIGHT);
		setBackground(Color.WHITE);
		setLayout(null);

		JLabel label = new JLabel("日期");
		label.setBounds(76, 41, 75, 18);
		add(label);

		data = new MJTextField();
		data.setEnabled(false);
		data.setEditable(false);
		data.setBounds(161, 37, 123, 28);
		add(data);
		data.setColumns(10);

		JLabel label_4 = new JLabel("派件员");
		label_4.setBounds(76, 81, 93, 15);
		add(label_4);

		sender = new MJTextField();
		sender.setEnabled(false);
		sender.setEditable(false);
		sender.setBounds(161, 75, 123, 28);
		add(sender);
		sender.setColumns(10);

		JLabel label_6 = new JLabel("货物编码");
		label_6.setBounds(150, 163, 93, 15);
		add(label_6);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(226, 188, 147, -51);
		add(scrollPane);

		confirm = new JButton("提交");
		confirm.addActionListener(new submitListener() );
		confirm.setBounds(298, 343, 93, 23);
		add(confirm);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(58, 188, 210, 139);
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
		label_7.setBounds(783, 81, 54, 15);
		add(label_7);

		dataf = new JTextField(CurrentTime.getCurrentTimeDate());
		dataf.setBounds(863, 81, 159, 28);
		add(dataf);
		dataf.setColumns(10);

		JLabel label_13 = new JLabel("派件员");
		label_13.setBounds(783, 135, 82, 15);
		add(label_13);

		queren = new JButton("确认");
		queren.addActionListener(new confirmListener());
		queren.setBounds(953, 174, 93, 23);
		add(queren);

		JLabel label_14 = new JLabel("货物编码");
		label_14.setBounds(783, 250, 66, 15);
		add(label_14);

		codef = new MJTextField();
		codef.setBounds(863, 244, 194, 28);
		add(codef);
		codef.setColumns(10);

		tianjia = new JButton("添加");
		tianjia.addActionListener(new addListener() );
		tianjia.setBounds(783, 304, 93, 23);
		add(tianjia);



		JLabel label_2 = new JLabel("新增派送单");
		label_2.setBounds(10, 0, 102, 15);
		add(label_2);

		senderf = new MJTextField();
		senderf.setBounds(863, 129, 159, 28);
		add(senderf);
		senderf.setColumns(10);

		JLabel label_1 = new JLabel("派件单编号");
		label_1.setBounds(331, 43, 93, 15);
		add(label_1);

		sendcode = new MJTextField();
		sendcode.setEnabled(false);
		sendcode.setEditable(false);
		sendcode.setBounds(419, 37, 123, 28);
		add(sendcode);
		sendcode.setColumns(10);

		JLabel label_3 = new JLabel("派件单编号");
		label_3.setBounds(783, 43, 94, 15);
		add(label_3);

		sendcodef = new MJTextField();
		sendcodef.setBounds(863, 37, 159, 28);
		add(sendcodef);
		sendcodef.setColumns(10);

		JButton button = new JButton("修改");
		button.addActionListener(new ActionListener() {
			DeliverNoteOnServiceVO vo=null;

			public void actionPerformed(ActionEvent e) {
				int selectedRow =table.getSelectedRow();

				if(selectedRow!=-1){
					String temp=model.getValueAt(selectedRow, 0).toString();
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
					//id具体是啥？
					vo=new DeliverNoteOnServiceVO("1234567890","2010-11-11",ba,"厘米");
					ResultMsg result=arr.inputHallDeliverDoc(vo);
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

					JOptionPane.showMessageDialog(null, "要选中表格中的一行才可以删除哦~", "友情提示",JOptionPane.WARNING_MESSAGE);  
				}
			}
		});
		button.setBounds(892, 304, 93, 23);
		add(button);

		JButton button_1 = new JButton("删除");
		button_1.addActionListener(new ActionListener() {
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
		button_1.setBounds(995, 304, 93, 23);
		add(button_1);


	}
	public class addListener implements ActionListener{

		DeliverNoteOnServiceVO vo=null;
		public void actionPerformed(ActionEvent e) {
			ArrayList<String> ba=new ArrayList<String>();
			if(Chachong.isRepeat(chachong,codef.getText())){
				//如果已经重复，则不能添加
				JOptionPane.showMessageDialog(null, "不能重复添加相同的条形码哦~", "友情提示",JOptionPane.WARNING_MESSAGE);  
				return;
			}
			chachong.add(codef.getText());
			ba.add(codef.getText());
			//id具体是啥？
			vo=new DeliverNoteOnServiceVO("1234567890","2010-11-11",ba,"厘米");
			ResultMsg result=arr.inputHallDeliverDoc(vo);
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
				BarCode.add(cc);
			}
			vo=new DeliverNoteOnServiceVO(sendcodef.getText(),dataf.getText(),BarCode,senderf.getText());
			vo.setUserName(lim.getUserName());
			vo.setOrganization(lim.getOrganization());
			System.out.println(vo.getUserName());
			System.out.println(vo.getOrganization());
			int result = JOptionPane.showConfirmDialog(null, "确认提交审批？","系统提示",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(result == JOptionPane.YES_OPTION) {
				//ResultMsg resultS=arr.submitHallDeliverDoc(vo);
				//将提交放到新的线程中

				//提交之后panel里都不可编辑
				lock(false);
				//提交之后右下面板换
				frame.initPaisong(true,false,false);
				//提交审批
				new Submitter().start();
			}
			else {
				return;

			}
		}

	}
	public void setResult(ResultMsg s) {//审批之后才调这个方法
		//审批通没通过在这里体现
		frame.initPaisong(false,s.isPass(),!s.isPass());
		frame.leftdown.repaint();
		//解锁那些可以编辑的框框
		lock(true);
		if(s.isPass()){//审批通过之后，清空textfiled
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

		}

	}
	public void lock(boolean notlock){//解锁那些可以编辑的框框
		//notlock==true 不锁
		//textfield
		dataf.setEditable(notlock);
		dataf.setEnabled(notlock);

		codef.setEditable(notlock);
		codef.setEnabled(notlock);

		sendcodef.setEditable(notlock);
		sendcodef.setEnabled(notlock);

		senderf.setEditable(notlock);
		senderf.setEnabled(notlock);
		//button
		queren.setEnabled(notlock);
		tianjia.setEnabled(notlock);
		confirm.setEnabled(notlock);
	}
	class Submitter extends Thread {

		public void run() {
			super.run();
			//ResultMsg result=arr.submitHallDeliverDoc(vo);
			//setResult(result);
			setResult(arr.submitHallDeliverDoc(vo));
		}
	}
	public class confirmListener implements ActionListener{
		DeliverNoteOnServiceVO vo=null;
		public void actionPerformed(ActionEvent e) {
			ArrayList<String> ba=new ArrayList<String>();
			ba.add("0123456789");
			vo=new DeliverNoteOnServiceVO(sendcodef.getText(),dataf.getText(),ba,senderf.getText());
			ResultMsg result=arr.inputHallDeliverDoc(vo);
			if(result.isPass()){//格式检查正确
				sendcode.setText(sendcodef.getText());
				data.setText(dataf.getText());
				sender.setText(senderf.getText());
			}
			else{//格式有误
				int result1 = JOptionPane.showConfirmDialog(null, result.getMessage(),"系统提示",
						JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);

			}
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
