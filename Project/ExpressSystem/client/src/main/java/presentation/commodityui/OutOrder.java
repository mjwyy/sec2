/**
 * 出库主界面
 * 
 * @author wqy
 *
 */
package presentation.commodityui;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import presentation.util.Chachong;
import presentation.util.CleanTextField;
import presentation.util.CurrentTime;
import presentation.util.FitTabel;
import presentation.util.MJTextField;
import util.LogInMsg;
import util.ResultMsg;
import vo.StorageOutVO;
import businesslogic.commodity.StorageOut;
import businesslogicservice.commodityblservice.StorageOutBLService;
import businesslogicservice.commodityblservice._Stub.StorageOutBLService_Stub;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class OutOrder extends JPanel {
	//	StorageOutBLService sob=new StorageOutBLService_Stub();
	StorageOutBLService sob=new StorageOut();
	private JPanel thisP=this;
	private StorageOutVO vv;
	//可编辑的框框
	private MJTextField codef;
	private JTextField dataf;
	private MJTextField tof;
	private JComboBox typef;
	private MJTextField bianhaof;
	private JComboBox comboBox1;//汽运or中专
	//给查重用的arrayList
			private ArrayList<String> chachong=new  ArrayList<String> ();
			
	//button
	private  JButton submit;
	private JButton btnDelete ;
	private JButton btnModify;
	private JButton add ;
	//
	//快递编号
	private JTable table;
	private DefaultTableModel model;
	private ArrayList<String> barcode=new ArrayList<String> ();

	//界面传来的东东
	private LogInMsg lim;
	private Commodity frame;

	/**
	 * Create the panel.
	 */
	public OutOrder(LogInMsg lim,Commodity frame) {
		setSize(1152,446);
		setLayout(null);
		intiComponent();
	}


	/** 
	 * 初始化窗体组件 
	 */  
	private void intiComponent()    {  
		/* 
		 * 设置JTable的列名 
		 */  
		String[] columnNames =  
			{   "出库日期", "目的地","编号", "装运形式","快递编号", };  


		Object[][] obj = new Object[1][5];  


		model=new DefaultTableModel(obj,columnNames);
		table = new JTable(model);
		model.removeRow(0);
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int selectedRow= table.getSelectedRow();

				Object ob=model.getValueAt(selectedRow,0);
				dataf.setText(ob.toString());
				Object oc=model.getValueAt(selectedRow, 1);
				tof.setText(oc.toString());
				Object oE=model.getValueAt(selectedRow, 2);
				bianhaof.setText(oE.toString());
				Object od=model.getValueAt(selectedRow, 3);
				typef.setSelectedItem(od.toString());
				Object oa=model.getValueAt(selectedRow, 4);
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
			column.setPreferredWidth(126);  
		}  
		column = table.getColumnModel().getColumn(2); 
		column.setPreferredWidth(200); 
		/* 
		 * 设置JTable自动调整列表的状态，此处设置为关闭 
		 */  
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  

		/*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/  
		JScrollPane scroll = new JScrollPane(table);  
		scroll.setLocation(10, 40);
		scroll.setSize(709, 272);  


		add(scroll);  

		JLabel label = new JLabel("输入出库单");
		label.setBounds(10, 10, 103, 15);
		add(label);

		submit = new JButton("提交");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(model.getRowCount()<1){
					JOptionPane.showConfirmDialog(null, "不能提交空表格哦~","系统提示",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					return ;
				}
				int count=model.getRowCount();
				for(int i=0;i<count;i++){
					barcode.add(model.getValueAt(i,4).toString());
				}
				vv=new StorageOutVO(dataf.getText(),tof.getText(),bianhaof.getText(),typef.getSelectedItem().toString(),barcode,ist(comboBox1.getSelectedIndex()));
				int result1 = JOptionPane.showConfirmDialog(null, "确认提交审批？","系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(result1 == JOptionPane.YES_OPTION) {
					//将提交放到新的线程中

					//提交之后panel里都不可编辑
					lock(false);
					//提交之后右下面板换
					frame.initChuku(true,false,false);
					//	frame.setReceivingNoteVo(vo);//将vo存到Frame里
					//提交审批
					new Submitter().start();
//					ResultMsg result=sob.submitStorageOutDoc(vv);
					
//					if(result.isPass()) {
//					}
//					else{
//						JOptionPane.showConfirmDialog(null, result.getMessage(),"系统提示",
//								JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
//					}
				}
				else {
					return;

				}
			}
		});
		submit.setBounds(550, 359, 93, 23);
		add(submit);

		JLabel label_2 = new JLabel("货物信息");
		label_2.setBounds(878, 10, 93, 15);
		add(label_2);

		JLabel label_3 = new JLabel("快递编号");
		label_3.setBounds(749, 253, 87, 15);
		add(label_3);

		JLabel label_4 = new JLabel("出库日期");
		label_4.setBounds(749, 41, 87, 15);
		add(label_4);

		JLabel label_5 = new JLabel("目的地");
		label_5.setBounds(749, 92, 87, 15);
		add(label_5);

		add = new JButton("加入");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(Chachong.isRepeat(chachong,codef.getText())){
					//如果已经重复，则不能添加
					JOptionPane.showMessageDialog(null, "不能重复添加相同的条形码哦~", "友情提示",JOptionPane.WARNING_MESSAGE);  
					return;
				}
				chachong.add(codef.getText());
				ArrayList<String> ba=new ArrayList<String> ();
				ba.add(codef.getText());
				StorageOutVO vv=new StorageOutVO(dataf.getText(),tof.getText(),bianhaof.getText(),typef.getSelectedItem().toString(),ba,ist(comboBox1.getSelectedIndex()));
				ResultMsg result=sob.addStorageOutDoc(vv);

				if(result.isPass()){
					String[] rowValues={dataf.getText(),tof.getText(),
							bianhaof.getText(),typef.getSelectedItem().toString(),codef.getText()};
					model.addRow(rowValues);
					//FitTabel.fitTable(table);//调整列宽之后不好看
					codef.setText("");
					//这样快递编号arraylist
				}
				else{
					int result1 = JOptionPane.showConfirmDialog(null, result.getMessage(),"系统提示",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				}


			}
		});
		add.setBounds(760, 319, 93, 23);
		add(add);

		codef = new MJTextField();
		codef.setBounds(826, 247, 127, 28);
		add(codef);
		codef.setColumns(10);
//自动填充日期
		dataf = new JTextField(CurrentTime.getCurrentTimeDate());
		dataf.setBounds(826, 35, 127, 28);
		add(dataf);
		dataf.setColumns(10);

		bianhaof = new MJTextField();
		bianhaof.setBounds(886, 136, 218, 28);
		add(bianhaof);
		bianhaof.setColumns(10);

		JLabel lblNewLabel = new JLabel("装运形式");
		lblNewLabel.setBounds(749, 196, 85, 15);
		add(lblNewLabel);
		this.setVisible(true);  


		String[] orderType = { "铁路", "公路","空运"};
		typef = new JComboBox(orderType);
		typef.setBounds(826, 193, 127, 21);
		typef.setSelectedIndex(0);
		typef.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			}
		});
		add(typef);


		String[] orderType1 = { "中转单编号", "汽运编号"};
		comboBox1 = new JComboBox(orderType1);
		comboBox1.setBounds(749, 139, 127, 21);
		comboBox1.setSelectedIndex(0);
		comboBox1.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
			}
		});
		add(comboBox1);

		tof = new MJTextField();
		tof.setBounds(826, 86, 127, 28);
		add(tof);
		tof.setColumns(10);

		btnModify = new JButton("modify");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int selectedRow =table.getSelectedRow();
				if(selectedRow!=-1){
					 String temp=model.getValueAt(selectedRow, 0).toString();
					 if(Chachong.isRepeat(chachong,codef.getText())){
						 //如果已经重复，则不能添加
						 JOptionPane.showMessageDialog(null, "不能重复添加相同的条形码哦~", "友情提示",JOptionPane.WARNING_MESSAGE);  
						 return;
					 }
					 //不重复，则加入
					 chachong.remove(temp);
					 chachong.add(codef.getText());
					ArrayList<String> ba=new ArrayList<String> ();
					ba.add(codef.getText());
					StorageOutVO vv=new StorageOutVO(dataf.getText(),tof.getText(),bianhaof.getText(),typef.getSelectedItem().toString(),ba,ist(comboBox1.getSelectedIndex()));
					ResultMsg result=sob.addStorageOutDoc(vv);//格式检查
					if(result.isPass()){
						model.setValueAt(dataf.getText(),selectedRow, 0);
						model.setValueAt(tof.getText(),selectedRow, 1);
						model.setValueAt(bianhaof.getText(),selectedRow, 2);
						model.setValueAt(typef.getSelectedItem().toString(),selectedRow, 3);
						model.setValueAt(codef.getText(),selectedRow, 4);
					}
					else{
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
		btnModify.setBounds(878, 319, 93, 23);
		add(btnModify);

		btnDelete = new JButton("delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				int seletedRow=table.getSelectedRow();
				if(seletedRow!=-1){
					 //检查重复的array删
					 chachong.remove(model.getValueAt(seletedRow, 0));
					model.removeRow(seletedRow);
				}
				else{
					//未选中提示要选中才能编辑哦；

					JOptionPane.showMessageDialog(null, "要选中表格中的一行才可以删除哦~", "友情提示",JOptionPane.WARNING_MESSAGE);  
				}
			}
		});
		btnDelete.setBounds(996, 319, 93, 23);
		add(btnDelete);

	}  
	public void setResult(ResultMsg s) {//审批之后才调这个方法
		//审批通没通过在这里体现
		frame.initChuku(false,s.isPass(),!s.isPass());
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
			//ResultMsg result=si.submitPutInStorageDoc(siv);
			//setResult(result);
			setResult(sob.submitStorageOutDoc(vv));
		}
	}
	public void lock(boolean notlock){//解锁那些可以编辑的框框
		//notlock==true 不锁
		//textfield
		dataf.setEditable(notlock);
		dataf.setEnabled(notlock);
		tof.setEditable(notlock);
		tof.setEnabled(notlock);
		typef.setEditable(notlock);
		typef.setEnabled(notlock);
		codef.setEditable(notlock);
		codef.setEnabled(notlock);
		bianhaof.setEditable(notlock);
		bianhaof.setEnabled(notlock);
		comboBox1.setEditable(notlock);
		comboBox1.setEnabled(notlock);
		//button
		submit.setEnabled(notlock);
		add.setEnabled(notlock);
		btnDelete.setEnabled(notlock);
		btnModify.setEnabled(notlock);
	}
	public boolean ist(int i){
		//0是中专但，1是汽运编号
		if(i==0)
			return true;
		else
			return false;
	}
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		ImageIcon img = new ImageIcon("image/0111.jpg");
		g.drawImage(img.getImage(), 0, 0, null);
	}
}
