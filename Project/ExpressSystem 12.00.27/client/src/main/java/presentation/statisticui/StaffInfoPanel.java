package presentation.statisticui;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import vo.StaffVO;

public class StaffInfoPanel extends JPanel {
	private JTable table;
	private DefaultTableModel model;
	private Vector name;
	private Vector data;
	private JScrollPane scrollPane;
	private ArrayList<StaffVO> staffList = new ArrayList<StaffVO>();

	/**
	 * Create the panel
	 */
	public StaffInfoPanel() {
		setSize( 721, 345);
		name = new Vector();
		name.add("工号");
		name.add("姓名");
		name.add("性别");
		name.add("机构");
		name.add("职位");
		name.add("身份证号");
		name.add("工龄");
		name.add("手机号");
		name.add("工资");
		data = new Vector();
		model = new DefaultTableModel();
		model.setDataVector(data,name);
		table = new JTable(model);
		table.setBounds(27, 75, 721, 345);
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(27, 75, 721, 345);
		add(scrollPane);
		

	}
	
	   public void showall(){
			
			 
			 if(!staffList.isEmpty()){
				 for(int j = 0;j<staffList.size();j++){
					 Vector row = new Vector();
					 row.add(staffList.get(j).getStaffID());
					 row.add(staffList.get(j).getName());
					 row.add(staffList.get(j).getSex());
					 row.add(staffList.get(j).getOrganization());
					 row.add(staffList.get(j).getPostion());
					 row.add(staffList.get(j).getIDNum());
					 row.add(staffList.get(j).getWorkingtime());
					 row.add(staffList.get(j).getPhoneNum());
					 row.add(staffList.get(j).getWage());
					 data.add(row.clone());
				 }
				 model.setDataVector(data, name);
		   			table.setModel(model); 
			 }else{
				 Vector row = new Vector();
				 data.add(row.clone());
				 row.add("无信息");
				 model.setDataVector(data, name);
		   			table.setModel(model); 
			 }
		 }
	   
	   public void setStaffList(ArrayList<StaffVO> staffList) {
			this.staffList = staffList;
		}

}
