/**
 * 审批单据界面
 * 
 * @author wqy
 *
 */
package presentation.statisticui;

/**
 * 审批单据主界面
 * 
 * @author wqy
 *
 */
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

import businesslogic.statistic.NoteApproving;
import businesslogicservice.statisticblservice.NoteApprovingBLService;
import businesslogicservice.statisticblservice._stub.NoteApprovingBLService_Stub;
import presentation.util.CheckBoxTable;
import presentation.util.MJTextField;
import presentation.util.ShowMessageFrame;
import util.ApproveNote;
import util.enums.NoteType;
import vo.ArrivalNoteOnServiceVO;
import vo.ArrivalNoteOnTransitVO;
import vo.DeliverNoteOnServiceVO;
import vo.DeliveryNoteVO;
import vo.LoadNoteOnServiceVO;
import vo.LoadNoteOnTransitVO;
import vo.NoteVO;
import vo.ReceivingNoteVO;
import vo.TransitNoteOnTransitVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class OrderApprove extends JPanel {
	NoteApprovingBLService nab=new NoteApproving();
	private JTable table;
	private DefaultTableModel model;
	ArrayList<ApproveNote> approvenote=null;
	private JTextArea xiangxi;
	private JComboBox orderType ;
	private JCheckBox quanxuan ;
	private static boolean single=true;
	//获取以下各种单据
	public void initTable() {

		try {
			approvenote = nab.getNotes();
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showConfirmDialog(null,e.getMessage());
		}
		if(approvenote!=null){

			for(int i=0;i<approvenote.size();i++){
				ApproveNote aa=approvenote.get(i);
				//这边要改,一开始时待审批
				Object[] obj={"待审批",aa.getType().toString(),aa.getInfo(),false};//false checkbox未选中
				model.addRow(obj);
			}
		}
		else{
			JOptionPane.showMessageDialog(null, "暂时木有要审批的单据");
		}

	}
	private String splitcoude(String s){
		String[] c=s.split(";");
		String temp="";
		for(int i=0;i<c.length;i++){
			temp=temp+c[i]+"\n";
			//如果有一系列的条形码，还要分以下
		}
		return temp;
	}
	private void splitdetail(String s){
		//其他是以中文分....
		String[] c=s.split("；");
		String temp="";
		for(int i=0;i<c.length;i++){
			//如果有一系列的条形码，还要分以下
			//好像条形码也是以;分的(英文)
			if(c[i].contains(";")){
				temp=temp+splitcoude(c[i]);
			}
			else{
				temp=temp+c[i]+"\n";
			}

		}
		xiangxi.setText(temp);
	}
	/**
	 * Create the panel.
	 */
	public OrderApprove() {

		setSize(1142,446);

		String[] columnNames =  
			{  "审批状态", "单据类型", "详细信息","选择" };  

		/* 
		 * 初始化JTable里面各项的值 
		 */  
		Object[][] obj = new Object[1][4];  


		/* 
		 * JTable的其中一种构造方法 
		 */  
		model=new DefaultTableModel(obj,columnNames);
		table = new JTable(model);
		model.removeRow(0);
		//Object[] oo={"aa","bb","cc",false};
		//model.addRow(oo);
		//Object[] oof={"ff","ff","cff",false};
		//model.addRow(oof);
		checkbox(table);
		//先从数据库里得到所有单据
		//	ArrayList<NoteVO> notevo=nab.getAllDoc();

		initTable();




		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				//点中后第三列详细信息显示
				int selectedRow= table.getSelectedRow();
				Object oa=model.getValueAt(selectedRow, 0);
				//codef.setText(oa.toString());
				Object ob=model.getValueAt(selectedRow, 1);
				//dataf.setText(ob.toString());
				Object oc=model.getValueAt(selectedRow, 2);

				splitdetail(oc.toString());
				//tof.setText(oc.toString());
				Object od=model.getValueAt(selectedRow, 3);
				//areaf.setText(od.toString());
				//Object oe=model.getValueAt(selectedRow, 4);
				//rowf.setText(oe.toString());
				//Object of=model.getValueAt(selectedRow, 5);
				//jiahaof.setText(of.toString());
				//	Object og=model.getValueAt(selectedRow, 6);
				//weihaof.setText(og.toString());
			}
		});

		TableColumn column = null;  
		int colunms = table.getColumnCount();  
		for(int i = 0; i < colunms; i++)  
		{  
			column = table.getColumnModel().getColumn(i);  
			column.setPreferredWidth(108);  
		}
		column = table.getColumnModel().getColumn(2);  
		column.setPreferredWidth(400); 
		TableColumn column1 = table.getColumnModel().getColumn(1);  
		column1.setPreferredWidth(160); 
		setLayout(null);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  

		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(10, 98, 804, 305);
		//初始化tabel
		//initTable();

		add(scroll);
		JButton btnNewButton = new JButton("审批通过");
		btnNewButton.addActionListener(new ActionListener(){
			//点中那行，或钩中checkbox的那行；
			public void actionPerformed(ActionEvent arg0) {
				shenpi(true);


			}

		} );
		btnNewButton.setBounds(428, 413, 93, 23);
		add(btnNewButton);
		JButton button_1 = new JButton("审批不通过");
		button_1.addActionListener(new ActionListener(){
			//点中那行，或钩中checkbox的那行；
			public void actionPerformed(ActionEvent arg0) {
				shenpi(false);
			}

		} );
		button_1.setBounds(555, 413, 103, 23);
		add(button_1);
		JLabel label = new JLabel("单据列表");
		label.setBounds(30, 21, 83, 15);
		add(label);
		//JButton button_2 = new JButton("待审批单据");
		//button_2.setBounds(357, 20, 122, 23);
		//add(button_2);
		JLabel label_1 = new JLabel("筛选类型");
		label_1.setBounds(10, 67, 103, 18);
		add(label_1);
		orderType = new JComboBox();
		orderType.setModel(new DefaultComboBoxModel(new String[] {"所有", "寄件单", "收件单", "营业厅到达单", "营业厅装车单", "营业厅派件单", "中转中心到达单", "中转中心装车单", "中转中心中转单", "仓库入库单", "仓库出库单", "营业厅收款单","付款单"}));
		orderType.setBounds(98, 66, 151, 21);
		add(orderType);
		JButton button_5 = new JButton("查询");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//根据单据类型，在界面显示
				String s=orderType.getSelectedItem().toString();
				//
				if(s.equals("所有")){
					cleanTable();
					initTable();
				}
				else{
				chooseType(s);
				}
			}
		});
		button_5.setBounds(259, 65, 93, 23);
		add(button_5);

		JLabel label_2 = new JLabel("详细信息");
		label_2.setBounds(916, 56, 83, 29);
		add(label_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(824, 88, 308, 315);
		add(scrollPane);

		xiangxi = new JTextArea();
		scrollPane.setViewportView(xiangxi);
		xiangxi.setLineWrap(true);
		xiangxi.setOpaque(false);
		xiangxi.setEditable(false);
		xiangxi.setWrapStyleWord(true);
		
		quanxuan = new JCheckBox("全选");
		quanxuan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				quanxua();
				
			}
		});
		quanxuan.setBounds(685, 413, 103, 23);
		add(quanxuan);


	}
	private void quanxua(){
		
		//单数次
		//全部选中第三列为true
		//双数次为false;
		
		for(int i=0;i<model.getRowCount();i++){
			model.setValueAt(single, i, 3);
		}
		single=!single;
	}
	//
	public void checkbox(JTable jTable){//已开始要赋值
		TableColumn   aColumn   =   jTable.getColumnModel().getColumn(3);   
		aColumn.setCellEditor(jTable.getDefaultEditor(Boolean.class));   
		aColumn.setCellRenderer(jTable.getDefaultRenderer(Boolean.class));
	}
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		ImageIcon img = new ImageIcon("image/0111.jpg");
		g.drawImage(img.getImage(), 0, 0, null);
		float lineWidth = 3.0f;
		((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
		g.drawLine(WIDTH/3*2, 0, WIDTH/3*2, HEIGHT);
	}
	public void shenpi(boolean isappr){
		////遍历checkbox是否被选中
		boolean iss=false;
		ArrayList<ApproveNote> results=new ArrayList<ApproveNote>();
		for(int i=0;i<model.getRowCount();i++){
			if((boolean) model.getValueAt(i, 3)){//checkbox被选中
				iss=true;
				ApproveNote aaa=approvenote.get(i);
				//aaa.setPass(isappr);
				if(isappr){//审批通过
					aaa.setPass(isappr);

					//审批通过jtabel里的审批状态变为审批通过
					model.setValueAt("通过", i,0);
				}
				else{//不通过,弹个窗口输入意见
					aaa.setRejectionMessage(JOptionPane.showInputDialog("请输入意见"));
					model.setValueAt("未通过", i,0);
				}
				//model.setValueAt(state(aaa.isPass()), i,0);
				results.add(aaa);
				//之后设置成未被选中状态，否则容易出错。。。
				model.setValueAt(false,i, 3);
			}
		}
		if(!iss){
			new ShowMessageFrame("请选中选择框后再进行操作哦~");
			
			return ;
		}
		try {
			nab.pushResults(results);
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showConfirmDialog(null, e.getMessage());
		}
	}
public void chooseType(String s){
	//TODO
	//便利approvenote,找到相应类型
System.out.println(s);
	cleanTable();
	boolean isemp=true;
	for(int i=0;i<approvenote.size();i++){
		ApproveNote an=approvenote.get(i);
		System.out.println(an.getType().toString());
		if(an.getType().toString().equals(s)){
			//xianshi
			isemp=false;
			System.out.println("ohayu");
			Object[] obj={state(an.isPass()),an.getType().toString(),an.getInfo(),false};//false checkbox未选中
			model.addRow(obj);
		}
		
	}
	if(isemp){
		JOptionPane.showMessageDialog(null, "暂时木有要审批的单据");
}
}
private void cleanTable(){
	int count=model.getRowCount();
	for(int i=count-1;i>=0;i--){
		model.removeRow(i);
	}
}
	
	public String state(boolean p){//审批状态
		if(p){
			return "通过";
		}
		else
			return "未通过";
	}
}
