package presentation.infoui;

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
import presentation.util.MJTextField;
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

public class StaffManagementPanel extends JPanel {
	private MJTextField keyword;
	private MJTextField staffID;
	private MJTextField staffname;
	//private MJTextField staffsex;
	private JComboBox comboBox_1;
	private MJTextField org;
	private MJTextField IDCode;
	private MJTextField worktime;
	private MJTextField phonum;
	private MJTextField wage;
	private JTable table;
	private DefaultTableModel model;
	private Vector name;
	private Vector data;
	//private StaffOrganizationManagementBLService service = new StaffOrganizationManagementBLService_Stub();
	private StaffOrganizationManagementBLService service ;
	private StaffVO staffVO;
	private JScrollPane scrollPane;
	private JComboBox comboBox;
	private StaffType staffType;
	private JComboBox position;
	private JLabel tishi;
	private ResultMsg res;
	private int seletedRow;
	private String[] poslist;
	private JComboBox sexlist;
	/**
	 * Create the panel.
	 */
	public StaffManagementPanel() {
		service =  new StaffOrganizationManagement();
		setSize(1152,446);
		setLayout(null);
		
		JLabel label = new JLabel("关键字类型");
		label.setBounds(54, 47, 80, 16);
		add(label);
		
		keyword = new MJTextField();
		keyword.setBounds(296, 38, 198, 28);
		add(keyword);
		keyword.setColumns(10);
		
		position = new JComboBox();
		position.setBounds(296, 40, 198, 23);
		add(position);
		position.setVisible(false);
		
		sexlist = new JComboBox();
		sexlist.setBounds(296, 40, 198, 23);
		add(sexlist);
		sexlist.setVisible(false);
		
		String[] keywordType = {"工号","姓名","性别","机构","职位","身份证号","工龄","手机号码","工资"};
		comboBox = new JComboBox(keywordType);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 if(comboBox.getSelectedItem().equals("性别")){
						String[] sexList = {"男","女"};
						sexlist = new JComboBox(sexList);
						sexlist.setBounds(296, 40, 198, 23);
						add(sexlist);
						position.setVisible(false);
						sexlist.setVisible(true);
						keyword.setVisible(false);
					}else if(comboBox.getSelectedItem().equals("职位")){
						String[] poslist = {"总经理","营业厅业务员","中转中心业务员","库存管理人员","快递员","系统管理人员","司机","财务人员"};
						position = new JComboBox(poslist);
						position.setBounds(296, 40, 198, 23);
						add(position);
						sexlist.setVisible(false);
						position.setVisible(true);
						keyword.setVisible(false);	
					}
			}
		});
		comboBox.setBounds(136, 43, 136, 20);
		add(comboBox);
		
		
		
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data.clear();
				if(comboBox.getSelectedItem().equals("工号")){		
					staffVO = new StaffVO(keyword.getText(),null,null,null,null,null,-1,null,null);
				}
				else if(comboBox.getSelectedItem().equals("姓名")){
					staffVO = new StaffVO(null,keyword.getText(),null,null,null,null,-1,null,null);
				}
				else if(comboBox.getSelectedItem().equals("性别")){
					staffVO = new StaffVO(null,null,(String)sexlist.getSelectedItem(),null,null,null,-1,null,null);
				}
				else if(comboBox.getSelectedItem().equals("机构")){
					staffVO = new StaffVO(null,null,null,keyword.getText(),null,null,-1,null,null);
				}else if(comboBox.getSelectedItem().equals("职位")){
					if(position.getSelectedItem().equals(poslist[0])){staffType = staffType.MANAGER;}
					else if(position.getSelectedItem().equals(poslist[1])){staffType = staffType.HALL_ASSISTANT;}
					else if(position.getSelectedItem().equals(poslist[2])){staffType = staffType.TRANSIT_ASSISTANT;}
					else if(position.getSelectedItem().equals(poslist[3])){staffType = staffType.WAREHOUSE_MANAGER;}
					else if(position.getSelectedItem().equals(poslist[4])){staffType = staffType.DELIVERY_MAN;}
					else if(position.getSelectedItem().equals(poslist[5])){staffType = staffType.SYSTEM_MANAGER;}
					else if(position.getSelectedItem().equals(poslist[6])){staffType = staffType.DRIVER;}
					else if(position.getSelectedItem().equals(poslist[7])){staffType = staffType.ACCOUNTANT;}
					staffVO = new StaffVO(null,null,null,null,staffType,null,-1,null,null);
				}
				
				else if(comboBox.getSelectedItem().equals("身份证号")){
					staffVO = new StaffVO(null,null,null,null,null,keyword.getText(),-1,null,null);
				}
				else if(comboBox.getSelectedItem().equals("工龄")){
					int isNum = 1;
					for(int i = 0;i<keyword.getText().length();i++){
						if(keyword.getText().charAt(i)>'9'||keyword.getText().charAt(i)<'0'){						
							tishi.setVisible(true);
							isNum = 0;
							break;
						}
					}
					if(isNum == 1){
					staffVO = new StaffVO(null,null,null,null,null,null,Integer.parseInt(keyword.getText()),null,null);
					}
				}
				else if(comboBox.getSelectedItem().equals("手机号码")){
					staffVO = new StaffVO(null,null,null,null,null,null,-1,keyword.getText(),null);
				}
				else {
					staffVO = new StaffVO(null,null,null,null,null,null,-1,null,keyword.getText());
				}
				
				 ArrayList<StaffVO> staffVoList = new  ArrayList<StaffVO>();
				 staffVoList = service.findStaffInfo(staffVO);
				 if(!staffVoList.isEmpty()){
					 for(int j = 0;j<staffVoList.size();j++){
						 Vector row = new Vector();
						 row.add(staffVoList.get(j).getStaffID());
						 row.add(staffVoList.get(j).getName());
						 row.add(staffVoList.get(j).getSex());
						 row.add(staffVoList.get(j).getOrganization());
						 row.add(staffVoList.get(j).getPostion());
						 row.add(staffVoList.get(j).getIDNum());
						 row.add(staffVoList.get(j).getWorkingtime());
						 row.add(staffVoList.get(j).getPhoneNum());
						 row.add(staffVoList.get(j).getWage());
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
		});
		btnNewButton.setBounds(514, 39, 80, 27);
		add(btnNewButton);
		
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
		table.setBounds(54, 75, 641, 309);
		scrollPane = new JScrollPane(table);
		TableColumn column = null;
   		int colunms = table.getColumnCount();  
   		for(int i = 0; i < colunms; i++)  
   		{  
   			column = table.getColumnModel().getColumn(i);  
   			/*将每一列的默认宽度设置为180*/  
   			column.setPreferredWidth(180);  
   		}
		scrollPane.setBounds(27, 75, 721, 345);
		add(scrollPane);
		showall();
		

		
		
		table.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent arg0) {
        		 seletedRow = table.getSelectedRow();
          		if(seletedRow != -1){
          			staffID.setText(model.getValueAt(seletedRow, 0).toString());
				    staffname.setText((String)model.getValueAt(seletedRow, 1).toString());
				    comboBox_1.setSelectedItem(((String)model.getValueAt(seletedRow, 2).toString()));
				    org.setText((String)model.getValueAt(seletedRow, 3).toString());
				    zhiwei.setSelectedItem((String)model.getValueAt(seletedRow, 4).toString());
				    IDCode.setText((String)model.getValueAt(seletedRow, 5).toString());
				    worktime.setText((String)model.getValueAt(seletedRow, 6).toString());
				    phonum.setText((String)model.getValueAt(seletedRow, 7).toString());
				    wage.setText((String)model.getValueAt(seletedRow, 8).toString());
				    
				    String pos = new String(" ");
					if(zhiwei.getSelectedItem().equals(poslist0[0])){staffType = staffType.MANAGER;pos = "总经理";}
					else if(zhiwei.getSelectedItem().equals(poslist0[1])){staffType = staffType.HALL_ASSISTANT;pos ="营业厅业务员" ;}
					else if(zhiwei.getSelectedItem().equals(poslist0[2])){staffType = staffType.TRANSIT_ASSISTANT;pos = "中转中心业务员";}
					else if(zhiwei.getSelectedItem().equals(poslist0[3])){staffType = staffType.WAREHOUSE_MANAGER;pos = "库存管理人员";}
					else if(zhiwei.getSelectedItem().equals(poslist0[4])){staffType = staffType.DELIVERY_MAN;pos = "快递员";}
					else if(zhiwei.getSelectedItem().equals(poslist0[5])){staffType = staffType.SYSTEM_MANAGER;pos = "系统管理人员";}
					else if(zhiwei.getSelectedItem().equals(poslist0[6])){staffType = staffType.DRIVER;pos = "司机";}
					else if(zhiwei.getSelectedItem().equals(poslist0[7])){staffType = staffType.ACCOUNTANT;pos ="财务人员";}
            		
          		}
        	}
        });
		
		JLabel label_1 = new JLabel("工号");
		label_1.setBounds(782, 47, 61, 16);
		add(label_1);
		
		tishi = new JLabel("工龄按月计算，请输入正整数");
		tishi.setForeground(Color.RED);
		tishi.setBounds(296, 21, 198, 16);
		add(tishi);
		tishi.setVisible(false);
		
		staffID = new MJTextField();
		staffID.setBounds(837, 41, 192, 28);
		add(staffID);
		staffID.setColumns(10);
		
		JLabel label_2 = new JLabel("姓名");
		label_2.setBounds(782, 75, 61, 16);
		add(label_2);
		
		staffname = new MJTextField();
		staffname.setBounds(837, 69, 192, 28);
		add(staffname);
		staffname.setColumns(10);
		
		JLabel label_3 = new JLabel("性别");
		label_3.setBounds(782, 103, 61, 16);
		add(label_3);
		
		
		
		
		String[] sex = {"男","女"};
	 comboBox_1 = new JComboBox(sex);
		comboBox_1.setBounds(837, 99, 192, 20);
		add(comboBox_1);
		
		
		JLabel label_4 = new JLabel("机构");
		label_4.setBounds(782, 131, 61, 16);
		add(label_4);
		
		org = new MJTextField();
		org.setBounds(837, 125, 192, 28);
		add(org);
		org.setColumns(10);
		
		JLabel label_5 = new JLabel("职位");
		label_5.setBounds(782, 159, 61, 16);
		add(label_5);
		
		JLabel label_6 = new JLabel("身份证号");
		label_6.setBounds(782, 187, 61, 16);
		add(label_6);
		
		IDCode = new MJTextField();
		IDCode.setBounds(837, 181, 192, 28);
		add(IDCode);
		IDCode.setColumns(10);
		
		JLabel label_7 = new JLabel("工龄");
		label_7.setBounds(782, 221, 61, 16);
		add(label_7);
		
		worktime = new MJTextField();
		worktime.setBounds(837, 215, 192, 28);
		add(worktime);
		worktime.setColumns(10);
		
		JLabel label_8 = new JLabel("手机号码");
		label_8.setBounds(782, 249, 61, 16);
		add(label_8);
		
		phonum = new MJTextField();
		phonum.setBounds(837, 243, 192, 28);
		add(phonum);
		phonum.setColumns(10);
		
		JLabel label_9 = new JLabel("工资");
		label_9.setBounds(782, 277, 61, 16);
		add(label_9);
		
		wage = new MJTextField();
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
				staffVO = new StaffVO(staffID.getText(),staffname.getText(),comboBox_1.getSelectedItem().toString(),org.getText(),
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
					staffVO = new StaffVO(staffID.getText(),staffname.getText(),comboBox_1.getSelectedItem().toString(),org.getText(),
							staffType,IDCode.getText(),Integer.parseInt(worktime.getText()),phonum.getText(),wage.getText());
	
				int result2 = JOptionPane.showConfirmDialog(null, "确认删除吗？","系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(result2 == JOptionPane.YES_OPTION){
				
					res = service.delStaff(staffVO);
					if(res.isPass()){
						model.removeRow(seletedRow);
						staffID.setText("");
					    staffname.setText("");
					    org.setText("");
					    IDCode.setText("");
					    worktime.setText("");
					    phonum.setText("");
					    wage.setText("");
					    JOptionPane.showConfirmDialog(null, "删除成功","系统提示",
								JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);
					}else{
						int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
								JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);
					}
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
					staffVO = new StaffVO(staffID.getText(),staffname.getText(),comboBox_1.getSelectedItem().toString(),org.getText(),
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
					}else{
						int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
								JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					}
				}
				
			}
		});
		btnModify.setBounds(856, 328, 77, 49);
		add(btnModify);
		
		JButton btnNewButton_1 = new JButton("显示所有");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {						
				showall();
			}
		});
		btnNewButton_1.setBounds(615, 38, 80, 24);
		add(btnNewButton_1);
		
	}
	
	
	   public void paintComponent(Graphics g) {
			 super.paintComponents(g);
			 ImageIcon img = new ImageIcon("image/0111.jpg");
			 g.drawImage(img.getImage(), 0, 0, null);
			}
	   
	   
	   public void showall(){
		   data.clear();//清空table内容
		  // staffVO = new StaffVO(null,null,null,null,null,null,-1,null,null);
		   ArrayList<StaffVO>  staffList = new   ArrayList<StaffVO> ();
		   staffList = service.findStaffInfo(null);
		   System.out.println( service.findStaffInfo(staffVO).get(0).getWorkingtime());
		   if(staffList == null){
			   int result1 = JOptionPane.showConfirmDialog(null, "显示出错","系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		   }else{
			   if(!staffList.isEmpty()){
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
		   }
		   
		   
				 }
}
