package presentation.statisticui;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import po.StaffPO;
import util.ResultMsg;
import util.enums.StaffType;
import vo.InstitutionInfoVO;
import vo.OrganizationInfoVO;
import vo.StaffVO;
import businesslogic.info.StaffOrganizationManagement;
import businesslogicservice.infoblservice.StaffOrganizationManagementBLService;
import businesslogicservice.infoblservice._stub.StaffOrganizationManagementBLService_Stub;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;

public class ManageStaffPanel extends JPanel {
	private JTextField staffID;
	private JTextField staffname;
	private JTextField org;
	private JTextField IDCode;
	private JTextField worktime;
	private JTextField phonum;
	private JTextField wage;
	private JTable table;
	private DefaultTableModel model;
	private Vector name;
	private Vector data;
	private StaffOrganizationManagementBLService service = new StaffOrganizationManagement();
	private StaffVO staffVO;
	private StaffVO firststaffVO;
	private JScrollPane scrollPane;
	private StaffType staffType;
	private ResultMsg res;
	private int seletedRow;
	private String[] poslist;
	private JComboBox sex;
	private ArrayList<StaffVO> staffList = new ArrayList<StaffVO>();
	private JButton btnNewButton;
	/**
	 * Create the panel.
	 */
	public ManageStaffPanel() {
		setSize(1152,600);
		setLayout(null)
		;
		

		final String[] poslist0 = {"总经理","营业厅业务员","中转中心业务员","库存管理人员","快递员","系统管理人员","司机","财务人员"};
		final JComboBox zhiwei = new JComboBox(poslist0);
		zhiwei.setBounds(837, 154, 192, 28);
		add(zhiwei);
		
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
		//showall();
		TableColumn column = null;
   		int colunms = table.getColumnCount();  
   		for(int i = 0; i < colunms; i++)  
   		{  
   			column = table.getColumnModel().getColumn(i);  
   			/*将每一列的默认宽度设置为180*/  
   			column.setPreferredWidth(180);  
   		}
		
		
		table.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent arg0) {
        		 seletedRow = table.getSelectedRow();
          		if(seletedRow != -1){
          			staffID.setText(model.getValueAt(seletedRow, 0).toString());
				    staffname.setText(model.getValueAt(seletedRow, 1).toString());
				    //staffsex.setText(model.getValueAt(seletedRow, 2).toString());
				    sex.setSelectedItem(model.getValueAt(seletedRow, 2).toString());
				    org.setText(model.getValueAt(seletedRow, 3).toString());
				    zhiwei.setSelectedItem(model.getValueAt(seletedRow, 4).toString());
				    IDCode.setText(model.getValueAt(seletedRow, 5).toString());
				    worktime.setText(model.getValueAt(seletedRow, 6).toString());
				    phonum.setText(model.getValueAt(seletedRow, 7).toString());
				    wage.setText(model.getValueAt(seletedRow, 8).toString());

					
					String pos = new String(" ");
					if(zhiwei.getSelectedItem().equals(poslist0[0])){staffType = staffType.MANAGER;pos = "总经理";}
					else if(zhiwei.getSelectedItem().equals(poslist0[1])){staffType = staffType.HALL_ASSISTANT;pos ="营业厅业务员" ;}
					else if(zhiwei.getSelectedItem().equals(poslist0[2])){staffType = staffType.TRANSIT_ASSISTANT;pos = "中转中心业务员";}
					else if(zhiwei.getSelectedItem().equals(poslist0[3])){staffType = staffType.WAREHOUSE_MANAGER;pos = "库存管理人员";}
					else if(zhiwei.getSelectedItem().equals(poslist0[4])){staffType = staffType.DELIVERY_MAN;pos = "快递员";}
					else if(zhiwei.getSelectedItem().equals(poslist0[5])){staffType = staffType.SYSTEM_MANAGER;pos = "系统管理人员";}
					else if(zhiwei.getSelectedItem().equals(poslist0[6])){staffType = staffType.DRIVER;pos = "司机";}
					else if(zhiwei.getSelectedItem().equals(poslist0[7])){staffType = staffType.ACCOUNTANT;pos ="财务人员";}
					
					firststaffVO = new StaffVO(staffID.getText(),staffname.getText(),sex.getSelectedItem().toString(),org.getText(),
							staffType,IDCode.getText(),Integer.parseInt(worktime.getText()),phonum.getText(),wage.getText());
					
          		}
        	}
        });
		
		JLabel label_1 = new JLabel("工号");
		label_1.setBounds(782, 47, 61, 16);
		add(label_1);
		
		staffID = new JTextField();
		staffID.setBounds(837, 41, 192, 28);
		add(staffID);
		staffID.setColumns(10);
		
		JLabel label_2 = new JLabel("姓名");
		label_2.setBounds(782, 75, 61, 16);
		add(label_2);
		
		staffname = new JTextField();
		staffname.setBounds(837, 69, 192, 28);
		add(staffname);
		staffname.setColumns(10);
		
		JLabel label_3 = new JLabel("性别");
		label_3.setBounds(782, 103, 61, 16);
		add(label_3);
		
		JLabel label_4 = new JLabel("机构");
		label_4.setBounds(782, 131, 61, 16);
		add(label_4);
		
		org = new JTextField();
		org.setBounds(837, 125, 192, 28);
		add(org);
		org.setColumns(10);
		
		JLabel label_5 = new JLabel("职位");
		label_5.setBounds(782, 159, 61, 16);
		add(label_5);
		
		JLabel label_6 = new JLabel("身份证号");
		label_6.setBounds(782, 187, 61, 16);
		add(label_6);
		
		IDCode = new JTextField();
		IDCode.setBounds(837, 181, 192, 28);
		add(IDCode);
		IDCode.setColumns(10);
		
		JLabel label_7 = new JLabel("工龄");
		label_7.setBounds(782, 221, 61, 16);
		add(label_7);
		
		worktime = new JTextField();
		worktime.setBounds(837, 215, 192, 28);
		add(worktime);
		worktime.setColumns(10);
		
		JLabel label_8 = new JLabel("手机号码");
		label_8.setBounds(782, 249, 61, 16);
		add(label_8);
		
		phonum = new JTextField();
		phonum.setBounds(837, 243, 192, 28);
		add(phonum);
		phonum.setColumns(10);
		
		JLabel label_9 = new JLabel("工资");
		label_9.setBounds(782, 277, 61, 16);
		add(label_9);
		
		wage = new JTextField();
		wage.setBounds(837, 271, 192, 28);
		add(wage);
		wage.setColumns(10);
		
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String pos = new String(" ");
				if(zhiwei.getSelectedItem().equals(poslist0[0])){staffType = staffType.MANAGER;pos = "总经理";}
				else if(zhiwei.getSelectedItem().equals(poslist0[1])){staffType = staffType.HALL_ASSISTANT;pos ="营业厅业务员" ;}
				else if(zhiwei.getSelectedItem().equals(poslist0[2])){staffType = staffType.TRANSIT_ASSISTANT;pos = "中转中心业务员";}
				else if(zhiwei.getSelectedItem().equals(poslist0[3])){staffType = staffType.WAREHOUSE_MANAGER;pos = "库存管理人员";}
				else if(zhiwei.getSelectedItem().equals(poslist0[4])){staffType = staffType.DELIVERY_MAN;pos = "快递员";}
				else if(zhiwei.getSelectedItem().equals(poslist0[5])){staffType = staffType.SYSTEM_MANAGER;pos = "系统管理人员";}
				else if(zhiwei.getSelectedItem().equals(poslist0[6])){staffType = staffType.DRIVER;pos = "司机";}
				else if(zhiwei.getSelectedItem().equals(poslist0[7])){staffType = staffType.ACCOUNTANT;pos ="财务人员";}
				staffVO = new StaffVO(staffID.getText(),staffname.getText(),sex.getSelectedItem().toString(),org.getText(),
						staffType,IDCode.getText(),Integer.parseInt(worktime.getText()),phonum.getText(),wage.getText());
				res = service.addStaff(staffVO);
				if(res.isPass()){
					 Vector row = new Vector();
					 row.add(staffVO.getStaffID());
					 row.add(staffVO.getName());
					 row.add(staffVO.getSex());
					 row.add(staffVO.getOrganization());
					 row.add(staffVO.getPostion());					
					 row.add(staffVO.getIDNum());
					 row.add(staffVO.getWorkingtime());
					 row.add(staffVO.getPhoneNum());
					 row.add(staffVO.getWage());
					 data.add(row.clone());
					 model.setDataVector(data, name);
			   		table.setModel(model); 
			   		staffList.add(staffVO);
			   		
				}else{			
					int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					}
				
					
			}
		});
		btnAdd.setBounds(773, 327, 77, 49);
		add(btnAdd);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seletedRow=table.getSelectedRow();
				if(seletedRow != -1)		    
					staffVO = new StaffVO(staffID.getText(),staffname.getText(),sex.getSelectedItem().toString(),org.getText(),
							staffType,IDCode.getText(),Integer.parseInt(worktime.getText()),phonum.getText(),wage.getText());
					
					res = service.delStaff(staffVO);
					if(res.isPass()){
						 staffList.remove(staffVO);
						model.removeRow(seletedRow);
						staffID.setText("");
					    staffname.setText("");
					  
					    org.setText("");
					    IDCode.setText("");
					    worktime.setText("");
					    phonum.setText("");
					    wage.setText("");
					    JOptionPane.showConfirmDialog(null, "删除成功","系统提示",
								JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					   
					}else{
						int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
								JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					}
				
			}
		});
		btnDelete.setBounds(945, 329, 77, 49);
		add(btnDelete);
		
		JButton btnModify = new JButton("MODIFY");
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				seletedRow=table.getSelectedRow();
				if(seletedRow != -1){
					staffVO = new StaffVO(staffID.getText(),staffname.getText(),sex.getSelectedItem().toString(),org.getText(),
							staffType,IDCode.getText(),Integer.parseInt(worktime.getText()),phonum.getText(),wage.getText());
					res = service.ModifyStaff(staffVO);
					if(res.isPass()){
						model.removeRow(seletedRow);
						Vector row = new Vector();
						 row.add(staffVO.getStaffID());
						 row.add(staffVO.getName());
						 row.add(staffVO.getSex());
						 row.add(staffVO.getOrganization());
						 row.add(staffVO.getPostion());					
						 row.add(staffVO.getIDNum());
						 row.add(staffVO.getWorkingtime());
						 row.add(staffVO.getPhoneNum());
						 row.add(staffVO.getWage());
						 data.add(row.clone());
						 model.setDataVector(data, name);
				   		 table.setModel(model);
				   		 staffList.remove(firststaffVO);
				   		 staffList.add(staffVO);
				   	  JOptionPane.showConfirmDialog(null, "修改成功","系统提示",
								JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					}else{
						int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
								JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					}
				}
				
			}
		});
		btnModify.setBounds(856, 328, 77, 49);
		add(btnModify);
		
		btnNewButton = new JButton("确认");
		btnNewButton.setBounds(775, 388, 247, 36);
		add(btnNewButton);
		
		String[] sexchoose = {"男","女"};
		sex = new JComboBox(sexchoose);
		sex.setBounds(837, 99, 192, 20);
		add(sex);
		
		
		
	
		
	}
	  
	
	public JButton getButton(){
		return btnNewButton;
	}
	
	
	   public void paintComponent(Graphics g) {
			 super.paintComponents(g);
			 ImageIcon img = new ImageIcon("image/0111.jpg");
			 g.drawImage(img.getImage(), 0, 0, null);
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
			 
	   


	public ArrayList<StaffVO> getStaffList() {
		return staffList;
	}


	public void setStaffList(ArrayList<StaffVO> staffList) {
		this.staffList = staffList;
	}
}

