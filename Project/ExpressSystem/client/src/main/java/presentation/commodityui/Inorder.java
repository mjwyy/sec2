/**
 * 入库主界面
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

import presentation.util.CleanTextField;
import presentation.util.CurrentTime;
import presentation.util.MJTextField;
import util.LogInMsg;
import util.ResultMsg;
import vo.CommodityGoodsVO;
import vo.StorageInVO;
import businesslogic.commodity.StorageIn;
import businesslogicservice.commodityblservice.StorageInBLService;
import businesslogicservice.commodityblservice._Stub.StorageInBLService_Stub;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;

public class Inorder extends JPanel {

	//	StorageInBLService si=new StorageInBLService_Stub();
	private StorageInBLService si=new StorageIn();
	private StorageInVO siv;//提交用的vo
	private JPanel thisP=this;
	
	//可编辑的框
	private MJTextField codef;
	private MJTextField tof;
	private MJTextField rowf;
	private MJTextField jiahaof;
	private MJTextField weihaof;
	private JTextField dataf;
	private JComboBox comboBox;
	
	//入库单table
	private JTable table;
	private DefaultTableModel model;

	//button
	private JButton submit;
	private JButton add;
	private JButton delete ;
	private JButton btnModify;

	//frame传来的
	private LogInMsg lim;
	private Commodity frame;
	/**
	 * Create the panel.
	 */
	public Inorder(LogInMsg lim,Commodity frame) {
		this.lim = lim;
		this.frame = frame;
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
			{ "快递编号", "入库日期", "目的地", "区号","排号" ,"架号","位号"};  

		/* 
		 * 初始化JTable里面各项的值 
		 */  
		Object[][] obj = new Object[1][7];  



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
				Object ob=model.getValueAt(selectedRow, 1);
				dataf.setText(ob.toString());
				Object oc=model.getValueAt(selectedRow, 2);
				tof.setText(oc.toString());
				Object od=model.getValueAt(selectedRow, 3);
				comboBox.setSelectedIndex(getAreaCode(od.toString()));
				Object oe=model.getValueAt(selectedRow, 4);
				rowf.setText(oe.toString());
				Object of=model.getValueAt(selectedRow, 5);
				jiahaof.setText(of.toString());
				Object og=model.getValueAt(selectedRow, 6);
				weihaof.setText(og.toString());
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
			column.setPreferredWidth(116);  
		}  
		/* 
		 * 设置JTable自动调整列表的状态，此处设置为关闭 
		 */  
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  

		/*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/  
		JScrollPane scroll = new JScrollPane(table);  
		scroll.setLocation(10, 40);
		scroll.setSize(810, 272);  
		table.setSize(810,272);

		add(scroll);  




		JLabel label = new JLabel("输入入库单");
		label.setBounds(26, 10, 103, 15);
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
				ArrayList<CommodityGoodsVO> GoodsInStorageInfo=new ArrayList<CommodityGoodsVO> ();
				for(int i=0;i<count;i++){
					CommodityGoodsVO  cgv=new CommodityGoodsVO(model.getValueAt(i, 0).toString(),model.getValueAt(i, 3).toString(),model.getValueAt(i, 2).toString(),model.getValueAt(i, 4).toString(),
							model.getValueAt(i, 5).toString(),model.getValueAt(i, 6).toString());
					GoodsInStorageInfo.add(cgv);
				}
				//当前时间

				siv=new StorageInVO(CurrentTime.getCurrentTimeDate(),GoodsInStorageInfo);
				
				int result1 = JOptionPane.showConfirmDialog(null, "确认提交审批？","系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(result1 == JOptionPane.YES_OPTION) {
					//将提交放到新的线程中

					//提交之后panel里都不可编辑
					lock(false);
					//提交之后右下面板换
					frame.initRuku(true,false,false);
					//	frame.setReceivingNoteVo(vo);//将vo存到Frame里
					//提交审批
					new Submitter().start();

					//					ResultMsg result=si.submitPutInStorageDoc(siv);
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
		submit.setBounds(685, 359, 93, 23);
		add(submit);

		JLabel label_2 = new JLabel("货物信息");
		label_2.setBounds(950, 10, 103, 15);
		add(label_2);

		JLabel varib = new JLabel("快递编号");
		varib.setBounds(878, 57, 99, 15);
		add(varib);

		JLabel label_5 = new JLabel("目的地");
		label_5.setBounds(878, 147, 66, 15);
		add(label_5);

		JLabel label_6 = new JLabel("区号");
		label_6.setBounds(878, 189, 54, 15);
		add(label_6);

		JLabel label_7 = new JLabel("排号");
		label_7.setBounds(878, 234, 66, 15);
		add(label_7);

		JLabel label_8 = new JLabel("架号");
		label_8.setBounds(878, 280, 87, 15);
		add(label_8);

		JLabel label_9 = new JLabel("位号");
		label_9.setBounds(878, 316, 87, 15);
		add(label_9);

		add = new JButton("加入");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<CommodityGoodsVO> GoodsInStorageInfo=new ArrayList<CommodityGoodsVO> ();
				CommodityGoodsVO  cgv=new CommodityGoodsVO(codef.getText(),getArea(comboBox.getSelectedIndex()),tof.getText(),rowf.getText(),
						jiahaof.getText(),weihaof.getText());
				GoodsInStorageInfo.add(cgv);
				StorageInVO siv=new StorageInVO(dataf.getText(),GoodsInStorageInfo);
				ResultMsg result=si.addPutInStorgaeDoc(siv);
				if(result.isPass()){
					String[] rowValues={codef.getText(),dataf.getText(),
							tof.getText(),getArea(comboBox.getSelectedIndex()),rowf.getText(),
							jiahaof.getText(),weihaof.getText()};
					model.addRow(rowValues);
				}
				else{
					int result1 = JOptionPane.showConfirmDialog(null, result.getMessage(),"系统提示",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				}
			}

		});
		add.setBounds(1063, 380, 66, 23);
		add(add);

		codef = new MJTextField();
		codef.setBounds(987, 54, 133, 28);
		add(codef);
		codef.setColumns(10);

		tof = new MJTextField();
		tof.setBounds(987, 144, 133, 28);
		add(tof);
		tof.setColumns(10);

		rowf = new MJTextField();
		rowf.setBounds(987, 231, 133, 28);
		add(rowf);
		rowf.setColumns(10);

		jiahaof = new MJTextField();
		jiahaof.setBounds(987, 277, 133, 28);
		add(jiahaof);
		jiahaof.setColumns(10);

		weihaof = new MJTextField();
		weihaof.setBounds(987, 313, 133, 28);
		add(weihaof);
		weihaof.setColumns(10);

		btnModify = new JButton("MODIFY");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int selectedRow =table.getSelectedRow();
				if(selectedRow!=-1){
					ArrayList<CommodityGoodsVO> GoodsInStorageInfo=new ArrayList<CommodityGoodsVO> ();
					CommodityGoodsVO  cgv=new CommodityGoodsVO(codef.getText(),getArea(comboBox.getSelectedIndex()),tof.getText(),rowf.getText(),
							jiahaof.getText(),weihaof.getText());
					GoodsInStorageInfo.add(cgv);
					StorageInVO siv=new StorageInVO(dataf.getText(),GoodsInStorageInfo);
					ResultMsg result=si.addPutInStorgaeDoc(siv);//格式检查
					if(result.isPass()){
						model.setValueAt(codef.getText(),selectedRow, 0);
						model.setValueAt(dataf.getText(),selectedRow, 1);
						model.setValueAt(tof.getText(),selectedRow, 2);
						model.setValueAt(getArea(comboBox.getSelectedIndex()),selectedRow, 3);
						model.setValueAt(rowf.getText(),selectedRow, 4);
						model.setValueAt(jiahaof.getText(),selectedRow, 5);
						model.setValueAt(weihaof.getText(),selectedRow, 6);
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
		btnModify.setBounds(966, 380, 87, 23);
		add(btnModify);

		delete = new JButton("delete");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int seletedRow=table.getSelectedRow();
				if(seletedRow!=-1){
					//直接删
					model.removeRow(seletedRow);
				}
				else{
					//未选中提示要选中才能编辑哦；

					JOptionPane.showMessageDialog(null, "要选中表格中的一行才可以删除哦~", "友情提示",JOptionPane.WARNING_MESSAGE);  
				}
			}
		});
		delete.setBounds(851, 380, 93, 23);
		add(delete);

		JLabel label_1 = new JLabel("入库日期");
		label_1.setBounds(878, 107, 99, 15);
		add(label_1);
		//自动填充日期
		dataf = new JTextField(CurrentTime.getCurrentTimeDate());
		dataf.setColumns(10);
		dataf.setBounds(987, 104, 133, 28);
		add(dataf);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"航空区", "铁路区", "公路区"}));
		comboBox.setBounds(987, 186, 133, 28);
		add(comboBox);
		this.setVisible(true);  

	}  
	public void setResult(ResultMsg s) {//审批之后才调这个方法
		//审批通没通过在这里体现
		frame.initRuku(false,s.isPass(),!s.isPass());
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
	public void lock(boolean notlock){//解锁那些可以编辑的框框
		//notlock==true 不锁
		//textfield
		dataf.setEditable(notlock);
		dataf.setEnabled(notlock);
		tof.setEditable(notlock);
		tof.setEnabled(notlock);
		rowf.setEditable(notlock);
		rowf.setEnabled(notlock);
		codef.setEditable(notlock);
		codef.setEnabled(notlock);
		jiahaof.setEditable(notlock);
		jiahaof.setEnabled(notlock);
		weihaof.setEditable(notlock);
		weihaof.setEnabled(notlock);
		comboBox.setEditable(notlock);
		comboBox.setEnabled(notlock);
		//button
		submit.setEnabled(notlock);
		add.setEnabled(notlock);
		delete.setEnabled(notlock);
		btnModify.setEnabled(notlock);
	}
	class Submitter extends Thread {

		public void run() {
			super.run();
			//ResultMsg result=si.submitPutInStorageDoc(siv);
			//setResult(result);
			setResult(si.submitPutInStorageDoc(siv));
		}
	}
	public int getAreaCode(String s){
		int i=0;
		if(s.equals("航空区")){
			i=0;
		}
		else if(s.equals("铁路区")){
			i=1;
		}
		else
			i=2;
		return i;
	}
	public String getArea(int i){
		String s="";
		if(i==0){
			s="航空区";
		}
		else if(i==1){
			s="铁路区";
		}
		else{
			s="公路区";
		}
		return s;
	}
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		ImageIcon img = new ImageIcon("image/0111.jpg");
		g.drawImage(img.getImage(), 0, 0, null);
	}
}
