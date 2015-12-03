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
import javax.swing.JTextField;

import businesslogicservice.statisticblservice.NoteApprovingBLService;
import businesslogicservice.statisticblservice._stub.NoteApprovingBLService_Stub;
import presentation.util.CheckBoxTable;
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
	NoteApprovingBLService nab=new NoteApprovingBLService_Stub();
	private JTable table;
	private DefaultTableModel model;
	private JTextField textField;
	public String state(boolean p){//审批状态
		if(p){
			return "通过审批";
		}
		else
			return "未通过审批";
	}
	public String type(NoteVO vo){//单据类型
		if(vo instanceof ArrivalNoteOnServiceVO){
			return "营业厅到达单";
		}
		if(vo instanceof DeliverNoteOnServiceVO){
			return "营业厅派件单";
		}
		if(vo instanceof ArrivalNoteOnTransitVO){
			return "中转中心到达单";
		}
		if(vo instanceof DeliveryNoteVO){
			return "寄件单";
		}
		if(vo instanceof LoadNoteOnServiceVO){
			return "营业厅装车单";
		}
		if(vo instanceof LoadNoteOnTransitVO){
			return "中转中心装车单";
		}
		if(vo instanceof ReceivingNoteVO){
			return "收件单";
		}
		if(vo instanceof TransitNoteOnTransitVO){
			return "中转中心中转单";
		}
	}
	public void initTable(){
		ArrayList<ArrivalNoteOnServiceVO>  ans=nab.getArrivalNoteOnServiceVO();
		for(int i=0;i<ans.size();i++){
			ArrivalNoteOnServiceVO aa=ans.get(i);
			String[] obj={state(aa.isAppproved()),};

		}
		ArrayList<DeliverNoteOnServiceVO> dns=nab.getDeliverNoteOnServiceVO();

		ArrayList<ArrivalNoteOnTransitVO> ant=nab.getArrivalNoteOnTransitVO();

		ArrayList<DeliveryNoteVO> dn=nab.getDeliveryNoteVO();

		ArrayList<LoadNoteOnServiceVO>ls=nab. getLoadNoteOnServiceVO();

		ArrayList<LoadNoteOnTransitVO> lt=nab.getLoadNoteOnTransitVO();

		ArrayList<ReceivingNoteVO> rn=nab.getReceivingNoteVO();

		ArrayList<TransitNoteOnTransitVO> tot=nab.getTransitNoteVO();

	}
	/**
	 * Create the panel.
	 */
	public OrderApprove() {
		setSize(1142,446);

		String[] columnNames =  
			{  "审批状态", "单据类型", "单据编号","选择" };  

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
		checkbox(table);
		//先从数据库里得到所有单据
		ArrayList<NoteVO> notevo=nab.getAllDoc();






		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int selectedRow= table.getSelectedRow();
				Object oa=model.getValueAt(selectedRow, 0);
				//codef.setText(oa.toString());
				Object ob=model.getValueAt(selectedRow, 1);
				//dataf.setText(ob.toString());
				Object oc=model.getValueAt(selectedRow, 2);
				//tof.setText(oc.toString());
				Object od=model.getValueAt(selectedRow, 3);
				//areaf.setText(od.toString());
				Object oe=model.getValueAt(selectedRow, 4);
				//rowf.setText(oe.toString());
				Object of=model.getValueAt(selectedRow, 5);
				//jiahaof.setText(of.toString());
				//	Object og=model.getValueAt(selectedRow, 6);
				//weihaof.setText(og.toString());
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
			column.setPreferredWidth(100);  
		}
		setLayout(null);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  

		/*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/  
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(182, 116, 647, 252);


		add(scroll);
		JButton button = new JButton("查看详细");
		button.addActionListener(new DetailListener() );
		button.setBounds(342, 378, 103, 23);
		add(button);
		JButton btnNewButton = new JButton("审批通过");
		btnNewButton.setBounds(465, 378, 93, 23);
		add(btnNewButton);
		JButton button_1 = new JButton("审批不通过");
		button_1.setBounds(597, 378, 135, 23);
		add(button_1);
		JLabel label = new JLabel("单据列表");
		label.setBounds(185, 24, 83, 15);
		add(label);
		JButton button_2 = new JButton("待审批单据");
		button_2.setBounds(357, 20, 122, 23);
		add(button_2);
		JLabel label_1 = new JLabel("筛选类型");
		label_1.setBounds(186, 91, 54, 15);
		add(label_1);
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"所有", "中转单", "到达单", "装车单", "派送单"}));
		comboBox.setBounds(250, 88, 83, 21);
		add(comboBox);
		textField = new JTextField();
		textField.setBounds(379, 85, 66, 21);
		add(textField);
		textField.setColumns(10);
		JButton button_5 = new JButton("查询");
		button_5.setBounds(465, 83, 93, 23);
		add(button_5);


	}
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
	public class DetailListener implements ActionListener{

		public void actionPerformed(ActionEvent e) {
			int count=model.getRowCount();
			for(int i=0;i<count;i++){
				System.out.println(model.getValueAt(i, 5));
				//Boolean cb=(JCheckBox) model.getValueAt(i, 5);
				//if(cb.isSelected()){
				//System.out.println("sele");
			}
		}
	}


}
