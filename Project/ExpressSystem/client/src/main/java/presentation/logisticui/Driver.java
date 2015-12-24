/**
 * 管理司机界面
 * 
 * @author wqy
 *
 */
package presentation.logisticui;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;

import presentation.util.MJTextField;
import presentation.util.ShowMessageFrame;
import util.ResultMsg;
import util.enums.StaffType;
import vo.DriverVO;
import businesslogic.info.DriverVehicleManagement;
import businesslogicservice.infoblservice.DriverVehicleManagementBLService;
import businesslogicservice.infoblservice._stub.DriverVehicleManagementBLService_Stub;

public class Driver extends JPanel {
	private MJTextField key;
	private MJTextField code;
	private MJTextField name;
	private MJTextField sex;
	private MJTextField orgi;
	private MJTextField posi;
	private MJTextField id;
	private MJTextField workhour;
	private MJTextField phone;
	private MJTextField sala;
	private MJTextField qixian;
	private JTable table;
	private DefaultTableModel model;
//	DriverVehicleManagementBLService  dvm=new DriverVehicleManagementBLService_Stub();
	DriverVehicleManagementBLService  dvm=new DriverVehicleManagement();
	

	
	private JComboBox comboBox;
	/**
	 * Create the panel.
	 */
	public Driver() {
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
			{ "司机编号", "姓名", "性别", "所属机构","职位", "身份证号","工作时长","手机" ,"工资","驾照过期日期"};  

		/* 
		 * 初始化JTable里面各项的值 
		 */  
		Object[][] obj = new Object[1][10];  




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
				code.setText(oa.toString());
				Object ob=model.getValueAt(selectedRow, 1);
				name.setText(ob.toString());
				Object oc=model.getValueAt(selectedRow, 2);
				sex.setText(oc.toString());
				Object o4=model.getValueAt(selectedRow, 3);
				orgi.setText(o4.toString());
				Object od=model.getValueAt(selectedRow, 4);
				posi.setText(od.toString());
				Object oe=model.getValueAt(selectedRow, 5);
				id.setText(oe.toString());
				Object oc4=model.getValueAt(selectedRow, 6);
				workhour.setText(oc4.toString());
				Object of=model.getValueAt(selectedRow, 7);
				phone.setText(of.toString());
				Object odc=model.getValueAt(selectedRow, 8);
				sala.setText(odc.toString());
				Object og=model.getValueAt(selectedRow, 9);
				qixian.setText(og.toString());
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
			column.setPreferredWidth(150);  
		}  
		/* 
		 * 设置JTable自动调整列表的状态，此处设置为关闭 
		 */  
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  

		/*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/  
		JScrollPane scroll = new JScrollPane(table);  
		scroll.setLocation(78, 40);
		scroll.setSize(590, 272);  


		add(scroll);
		this.setVisible(true); 
		initTabel();//初始化

		JLabel label = new JLabel("司机信息管理");
		label.setBounds(10, 10, 103, 15);
		add(label);

		JLabel label_1 = new JLabel("关键字类型");
		label_1.setBounds(159, 8, 93, 18);
		add(label_1);

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"司机编号", "姓名", "性别", "所属机构", "职位", "身份证号", "工作时长", "手机", "工资", "行驶证期限"}));
		comboBox.setBounds(262, 7, 123, 21);
		add(comboBox);

		key = new MJTextField();
		key.setText("请输入关键字");
		key.setBounds(410, 2, 117, 28);
		add(key);
		key.setColumns(10);

		JButton button = new JButton("查询");
		button.addActionListener(new findListener() );
		button.setBounds(537, 6, 63, 23);
		add(button);

		JButton btnNewButton = new JButton("新增");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(workhour.getText().isEmpty()||!workHourRight(workhour.getText())){
					JOptionPane.showConfirmDialog(null, "工作时长必须是数字哦~","系统提示",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					     return ;
				}
				
				DriverVO vo=new DriverVO(code.getText(),name.getText(),sex.getText(),orgi.getText(),StaffType.DRIVER,
						id.getText(),Integer.parseInt(workhour.getText()),phone.getText(),sala.getText(),qixian.getText());
				ResultMsg result=dvm.addDriver(vo);
				if(result.isPass()){
					String[] rowValues={code.getText(),name.getText(),sex.getText(),orgi.getText(),posi.getText(),
							id.getText(),workhour.getText(),phone.getText(),sala.getText(),qixian.getText()};
					model.addRow(rowValues);
					setTishi(0);
				}
				else{
					int result1 = JOptionPane.showConfirmDialog(null, result.getMessage(),"系统提示",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(692, 413, 70, 23);
		add(btnNewButton);

		JButton btnNewButton_1 = new JButton("删除");
		btnNewButton_1.setBounds(792, 413, 70, 23);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				int seletedRow=table.getSelectedRow();
				if(seletedRow!=-1){
					DriverVO vo=new DriverVO(code.getText(),name.getText(),sex.getText(),orgi.getText(),StaffType.DRIVER,
							id.getText(),Integer.parseInt(workhour.getText()),phone.getText(),sala.getText(),qixian.getText());
					 int result11 = JOptionPane.showConfirmDialog(null, "确认删除？","系统提示",
                             JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                     if(result11 == JOptionPane.YES_OPTION) {
					ResultMsg result=dvm.deleteDriver(vo);	
					if(result.isPass()){
						
					model.removeRow(seletedRow);
					setTishi(2);
					}
					else{
		        		int result1 = JOptionPane.showConfirmDialog(null, result.getMessage(),"系统提示",
								JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		        	}
                     }
				}
				else{
					//未选中提示要选中才能编辑哦；

					JOptionPane.showMessageDialog(null, "要选中表格中的一行才可以删除哦~", "友情提示",JOptionPane.WARNING_MESSAGE);  
				}
			}
		});
		add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("修改");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow =table.getSelectedRow();
				if(selectedRow!=-1){
					DriverVO vo=new DriverVO(code.getText(),name.getText(),sex.getText(),orgi.getText(),StaffType.DRIVER,
							id.getText(),Integer.parseInt(workhour.getText()),phone.getText(),sala.getText(),qixian.getText());
					ResultMsg result=dvm.modifyDriver(vo);	
					if(result.isPass()){
					model.setValueAt(code.getText(),selectedRow, 0);
					model.setValueAt(name.getText(),selectedRow, 1);
					model.setValueAt(sex.getText(),selectedRow, 2);
					model.setValueAt(orgi.getText(),selectedRow, 3);
					model.setValueAt(posi.getText(),selectedRow, 4);
					model.setValueAt(id.getText(),selectedRow, 5);
					model.setValueAt(workhour.getText(),selectedRow, 6);
					model.setValueAt(phone.getText(),selectedRow, 7);
					model.setValueAt(sala.getText(),selectedRow, 8);
					model.setValueAt(qixian.getText(),selectedRow, 9);
					setTishi(1);
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
		btnNewButton_2.setBounds(924, 413, 70, 23);
		add(btnNewButton_2);

		JLabel label_2 = new JLabel("司机编号");
		label_2.setBounds(722, 10, 84, 28);
		add(label_2);

		JLabel label_3 = new JLabel("姓名");
		label_3.setBounds(722, 54, 54, 15);
		add(label_3);

		JLabel label_4 = new JLabel("性别");
		label_4.setBounds(722, 98, 54, 15);
		add(label_4);

		JLabel label_5 = new JLabel("职位");
		label_5.setBounds(722, 176, 82, 15);
		add(label_5);

		JLabel label_6 = new JLabel("身份证号");
		label_6.setBounds(722, 214, 82, 15);
		add(label_6);

		JLabel label_7 = new JLabel("手机");
		label_7.setBounds(722, 295, 54, 15);
		add(label_7);

		JLabel label_8 = new JLabel("驾照过期日期");
		label_8.setBounds(708, 363, 93, 15);
		add(label_8);

		code = new MJTextField();
		code.setBounds(824, 11, 170, 28);
		add(code);
		code.setColumns(10);

		name = new MJTextField();
		name.setColumns(10);
		name.setBounds(824, 48, 170, 28);
		add(name);

		sex = new MJTextField();
		sex.setColumns(10);
		sex.setBounds(824, 92, 170, 28);
		add(sex);

		posi = new MJTextField();
		posi.setColumns(10);
		posi.setBounds(824, 170, 170, 28);
		add(posi);

		id = new MJTextField();
		id.setColumns(10);
		id.setBounds(824, 208, 170, 28);
		add(id);

		phone = new MJTextField();
		phone.setColumns(10);
		phone.setBounds(824, 284, 170, 28);
		add(phone);

		qixian = new MJTextField();
		qixian.setColumns(10);
		qixian.setBounds(824, 357, 170, 28);
		add(qixian);

		JLabel label_9 = new JLabel("所属机构");
		label_9.setBounds(722, 136, 103, 15);
		add(label_9);

		orgi = new MJTextField();
		orgi.setColumns(10);
		orgi.setBounds(824, 132, 170, 28);
		add(orgi);

		JLabel label_10 = new JLabel("工作时长（按月）");
		label_10.setBounds(708, 251, 135, 23);
		add(label_10);

		workhour = new MJTextField();
		workhour.setColumns(10);
		workhour.setBounds(824, 246, 170, 28);
		add(workhour);

		JLabel lblNewLabel = new JLabel("工资");
		lblNewLabel.setBounds(722, 325, 54, 15);
		add(lblNewLabel);

		sala = new MJTextField();
		sala.setColumns(10);
		sala.setBounds(824, 322, 170, 28);
		add(sala);
		
		JButton aaall = new JButton("刷新");
		aaall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			initTabel();
			}
		});
		aaall.setBounds(610, 6, 93, 23);
		add(aaall);



	}  
	 public void setTishi(int i){
	        //0新增成功
	        if(i==0){
	            new ShowMessageFrame("新增成功");
	        }
	        //1修改成功
	        else if(i==1){
	            new ShowMessageFrame("修改成功");
	        }
	        //2删除成功
	        else{
	            new ShowMessageFrame("删除成功");
	        }
	    }
	public class findListener implements ActionListener{
DriverVO vo=null;
		public void actionPerformed(ActionEvent arg0) {
			if(comboBox.getSelectedIndex()==0){//司机编号
			vo=new DriverVO(key.getText(),null,null,null,null,null,-1,null,null,null);
			}
			else if(comboBox.getSelectedIndex()==1){//姓名
				vo=new DriverVO(null,key.getText(),null,null,null,null,-1,null,null,null);
			}
			else if(comboBox.getSelectedIndex()==2){//性别
				vo=new DriverVO(null,null,key.getText(),null,null,null,-1,null,null,null);
			}
			else if(comboBox.getSelectedIndex()==3){//所属机构
				vo=new DriverVO(null,null,key.getText(),null,null,null,-1,null,null,null);
			}
			else if(comboBox.getSelectedIndex()==4){//职位
				
				vo=new DriverVO(null,null,null,null,StaffType.DRIVER,null,-1,null,null,null);
			}
			else if(comboBox.getSelectedIndex()==5){//身份证号
				vo=new DriverVO(null,null,null,null,null,key.getText(),-1,null,null,null);
			}
			else if(comboBox.getSelectedIndex()==6){//工作时长按月
				if(key.getText().isEmpty()||!workHourRight(key.getText())){
					JOptionPane.showConfirmDialog(null, "工作时长必须是数字哦~","系统提示",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					     return ;
				}
				vo=new DriverVO(null,null,null,null,null,null,Integer.parseInt(key.getText()),null,null,null);
			}
			else if(comboBox.getSelectedIndex()==7){//手机
				vo=new DriverVO(null,null,null,null,null,null,-1,key.getText(),null,null);
			}
			else if(comboBox.getSelectedIndex()==8){//工资
				vo=new DriverVO(null,null,null,null,null,null,-1,null,key.getText(),null);
			}
			else if(comboBox.getSelectedIndex()==9){//行驶证期限
				vo=new DriverVO(null,null,null,null,null,null,-1,null,null,key.getText());
			}
			//显示到tabel里,先清空
			cleanTable();
			ArrayList<DriverVO> vvoo=dvm.findDriver(vo);
			for(int i=0;i<vvoo.size();i++){
				DriverVO vo=vvoo.get(i);
				String staffID=vo.getStaffID();
				String name=vo.getName();
				String sex=vo.getSex();
				String organization=vo.getOrganization();
				StaffType postion=vo.getPostion();
				String IDNum=vo.getIDNum();
				int workingtime=vo.getWorkingtime();
				String phoneNum=vo.getPhoneNum();
				String wage=vo.getWage();
				String licenseDate=vo.getLicenseDate();
				Object[] oo={staffID, name,sex,organization,postion,IDNum,workingtime,phoneNum,wage,licenseDate};
				model.addRow(oo);
			}
		}
		}
		
	
	public boolean workHourRight(String s){
		char[] c=s.toCharArray();
		for(int i=0;i<s.length();i++){
			if(!Character.isDigit(c[i])){
				return false;
			}
		}
		return true;
	}
	public void cleanTable(){
		//显示到tabel里,先清空
		int count=model.getRowCount();
		//这边modelremove后会变小，应该从后往前删
				for(int i=count-1;i>=0;i--){
					model.removeRow(i);
				}
	}
	public void initTabel(){
		ArrayList<DriverVO> vvoo=dvm.findDriver(null);//得到所有司机信息
		for(int i=0;i<vvoo.size();i++){
			DriverVO vo=vvoo.get(i);
			String staffID=vo.getStaffID();
			String name=vo.getName();
			String sex=vo.getSex();
			String organization=vo.getOrganization();
			StaffType postion=vo.getPostion();
			String IDNum=vo.getIDNum();
			int workingtime=vo.getWorkingtime();
			String phoneNum=vo.getPhoneNum();
			String wage=vo.getWage();
			String licenseDate=vo.getLicenseDate();
			Object[] oo={staffID, name,sex,organization,postion,IDNum,workingtime,phoneNum,wage,licenseDate};
			model.addRow(oo);
		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		ImageIcon img = new ImageIcon("image/0111.jpg");
		g.drawImage(img.getImage(), 0, 0, null);
	}
}
