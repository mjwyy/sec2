/**
 * 管理车辆界面
 * 
 * @author wqy
 *
 */
package presentation.logisticui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import presentation.util.MJTextField;
import util.ResultMsg;
import vo.VehicleVO;
import businesslogic.info.DriverVehicleManagement;
import businesslogicservice.infoblservice.DriverVehicleManagementBLService;
import businesslogicservice.infoblservice._stub.DriverVehicleManagementBLService_Stub;

public class Car extends JPanel {
	private MJTextField key;
    private MJTextField code;
    private MJTextField name;
    private MJTextField time;
    private JTable table;
    private DefaultTableModel model;
    // DriverVehicleManagementBLService  dvm=new DriverVehicleManagementBLService_Stub();
    DriverVehicleManagementBLService  dvm=new DriverVehicleManagement();
     private MJTextField textField_1;
    private JComboBox comboBox;
    private JLabel pict;
    private String fileName;
	/**
	 * Create the panel.
	 */
	public Car() {
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
	        { "车辆代号", "所属机构编号", "首次服役时间","车辆照片"};  
	  
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
	        table.addMouseListener(new MouseAdapter() {
	        	public void mouseClicked(MouseEvent arg0) {
	        	int selectedRow= table.getSelectedRow();
	        	Object oa=model.getValueAt(selectedRow, 0);
	        	code.setText(oa.toString());
	        	Object ob=model.getValueAt(selectedRow, 1);
	        	name.setText(ob.toString());
	        	Object oc=model.getValueAt(selectedRow, 2);
	        	time.setText(oc.toString());
	        	Object od=model.getValueAt(selectedRow, 3);
	        	fileName=od.toString();
	        	pict.setIcon(new ImageIcon(fileName));
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
	            column.setPreferredWidth(250);  
	        }  
	        /* 
	         * 设置JTable自动调整列表的状态，此处设置为关闭 
	         */  
	        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
	          
	        /*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/  
	        JScrollPane scroll = new JScrollPane(table);  
	        scroll.setLocation(10, 40);
	        scroll.setSize(663, 272);  
	          
	          
	        add(scroll);
	        this.setVisible(true); 
	        initTabel();
	        
	        JLabel label = new JLabel("车辆信息管理");
	        label.setBounds(10, 10, 103, 15);
	        add(label);
	        
	        JLabel label_1 = new JLabel("关键字类型");
	        label_1.setBounds(145, 8, 93, 18);
	        add(label_1);
	        
	        comboBox = new JComboBox();
	        comboBox.setModel(new DefaultComboBoxModel(new String[] {"车辆代号", "所属机构编号", "首次服役时间"}));
	        comboBox.setBounds(217, 7, 159, 21);
	        add(comboBox);
	        
	        key = new MJTextField();
	        key.setText("请输入关键字");
	        key.setBounds(398, 4, 117, 28);
	        add(key);
	        key.setColumns(10);
	        
	        JButton button = new JButton("查询");
	        button.addActionListener(new findListener() );
	        button.setBounds(525, 6, 63, 23);
	        add(button);
	        
	        JButton btnNewButton = new JButton("新增");
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		File file=new File(fileName);
		        	VehicleVO vo=new VehicleVO(code.getText(),name.getText(),time.getText(),file);
		        	ResultMsg result=dvm.addVehicle(vo);
		        	
		        	
		        	if(result.isPass()){
	        		String[] rowValues={code.getText(),name.getText(),
	        				time.getText(),fileName};
	        	model.addRow(rowValues);
		        	}
		        	else{
		        		int result1 = JOptionPane.showConfirmDialog(null, result.getMessage(),"系统提示",
								JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		        	}
	        	}
	        });
	        btnNewButton.setBounds(685, 352, 75, 35);
	        add(btnNewButton);
	        
	        JButton btnNewButton_1 = new JButton("删除");
	        btnNewButton_1.setBounds(816, 352, 75, 35);
	        btnNewButton_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		int seletedRow=table.getSelectedRow();
	        		if(seletedRow!=-1){
	        		File file=new File(fileName);
		        	VehicleVO vo=new VehicleVO(code.getText(),name.getText(),time.getText(),file);
		        	ResultMsg result=dvm.deleteVehicle(vo);
	        		
	        		if(result.isPass()){
	        		
	        			model.removeRow(seletedRow);
	        		}
	        		else{
		        		int result1 = JOptionPane.showConfirmDialog(null, result.getMessage(),"系统提示",
								JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		        	}
	        	
	        		}
	        	}
	        }
	        );
	        add(btnNewButton_1);
	        
	        JButton btnNewButton_2 = new JButton("修改");
	        btnNewButton_2.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		int selectedRow =table.getSelectedRow();
	        		if(selectedRow!=-1){
	        		File file=new File(fileName);
		        	VehicleVO vo=new VehicleVO(code.getText(),name.getText(),time.getText(),file);
		        	ResultMsg result=dvm.modifyVehicle(vo);
	        		
	        		if(result.isPass()){
	        		
		        		
		        		model.setValueAt(code.getText(),selectedRow, 0);
			        	model.setValueAt(name.getText(),selectedRow, 1);
			        	model.setValueAt(time.getText(),selectedRow, 2);
			        	model.setValueAt(fileName,selectedRow, 3);
	        		}	
	        		else{
		        		int result1 = JOptionPane.showConfirmDialog(null, result.getMessage(),"系统提示",
								JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		        	}
	        	}
	        	}
	        });
	        btnNewButton_2.setBounds(930, 352, 75, 35);
	        add(btnNewButton_2);
	        
	        JLabel label_2 = new JLabel("车辆代号");
	        label_2.setBounds(722, 67, 84, 28);
	        add(label_2);
	        
	        JLabel label_3 = new JLabel("所属机构编号");
	        label_3.setBounds(722, 140, 98, 15);
	        add(label_3);
	        
	        JLabel label_4 = new JLabel("首次服役时间");
	        label_4.setBounds(722, 216, 98, 15);
	        add(label_4);
	        
	        code = new MJTextField();
	        code.setBounds(830, 68, 170, 28);
	        add(code);
	        code.setColumns(10);
	        
	        name = new MJTextField();
	        name.setColumns(10);
	        name.setBounds(830, 134, 170, 28);
	        add(name);
	        
	        time = new MJTextField();
	        time.setColumns(10);
	        time.setBounds(830, 210, 170, 28);
	        add(time);
	        
	        JButton picture = new JButton("车辆照片");
	        picture.addMouseListener(new MouseListener(){

				public void mouseClicked(MouseEvent arg0) {
					JFileChooser jfc=new JFileChooser(System.getProperty("file.separator"));
					jfc.setDialogTitle("导入照片");
					if (jfc.showOpenDialog(Car.this) == JFileChooser.APPROVE_OPTION) {
						fileName = jfc.getSelectedFile().getAbsolutePath();
						pict.setIcon(new ImageIcon(fileName));

					}
				}

				public void mouseEntered(MouseEvent arg0) {
					
				}

				public void mouseExited(MouseEvent arg0) {
					
				}

				public void mousePressed(MouseEvent arg0) {
					
				}

				public void mouseReleased(MouseEvent arg0) {
					
				}
	        	
	        });
	        picture.setBounds(705, 272, 117, 27);
	        add(picture);
	        
	      
	        
	        JButton button_1 = new JButton("显示全部");
	        button_1.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        	initTabel();
	        	}
	        });
	        button_1.setBounds(597, 7, 84, 23);
	        add(button_1);
	        
	        pict = new JLabel("清选择160*85的皂片");
	        pict.setBounds(840, 248, 160, 85);
	        add(pict);
	        
	       
	        
	    }  
	    public void initTabel(){
	    	for(int i=0;i<model.getRowCount();i++)
				model.removeRow(i);
	    	ArrayList<VehicleVO> vvoo=dvm.findVehicle(null);//得到所有车辆信息
	    	for(int i=0;i<vvoo.size();i++){
	    		VehicleVO vo=vvoo.get(i);
	    		String vehiclecode=vo.getVehiclecode();
	    		String organization=vo.getOrganization();
	    		String serviceTimeLimit=vo.getServiceTimeLimit();
	    		File picture=vo.getPicture();
	    		Object[] oo={vehiclecode,organization,serviceTimeLimit,picture};
	    		model.addRow(oo);
	    	}
	    }
	    public class findListener implements ActionListener{
        	VehicleVO vo=null;
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedIndex()==0){//车辆代号
					vo=new VehicleVO(key.getText(),null,null,null);
				}
				else if(comboBox.getSelectedIndex()==1){//所属机构编号
					vo=new VehicleVO(null,key.getText(),null,null);
				}
				else{//首次服役时间
					vo=new VehicleVO(null,null,key.getText(),null);
				}
				//显示到tabel里,先清空
				for(int i=0;i<model.getRowCount();i++)
					model.removeRow(i);
				ArrayList<VehicleVO> vvoo=dvm.findVehicle(vo);
				for(int i=0;i<vvoo.size();i++){
		    		VehicleVO vo=vvoo.get(i);
		    		String vehiclecode=vo.getVehiclecode();
		    		String organization=vo.getOrganization();
		    		String serviceTimeLimit=vo.getServiceTimeLimit();
		    		File picture=vo.getPicture();
		    		Object[] oo={vehiclecode,organization,serviceTimeLimit,picture};
		    		model.addRow(oo);
		    	}
			}
	    	
	    }
	    public void paintComponent(Graphics g) {
			 super.paintComponents(g);
			 ImageIcon img = new ImageIcon("image/0111.jpg");
			 g.drawImage(img.getImage(), 0, 0, null);
			}
}
