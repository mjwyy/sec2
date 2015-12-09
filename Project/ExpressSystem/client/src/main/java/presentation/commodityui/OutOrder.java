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
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import presentation.util.FitTabel;
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
	private JTextField codef;
	private JTextField dataf;
	private JTextField tof;
	private JComboBox typef;
	private JTextField bianhaof;
	private JTable table;
	private DefaultTableModel model;
	private JComboBox comboBox1;//汽运or中专
	//快递编号
	private ArrayList<String> barcode=new ArrayList<String> ();
	/**
	 * Create the panel.
	 */
	public OutOrder() {
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
	        
	        JButton button_1 = new JButton("提交");
	        button_1.addActionListener(new ActionListener() {
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
	        		StorageOutVO vv=new StorageOutVO(dataf.getText(),tof.getText(),bianhaof.getText(),typef.getSelectedItem().toString(),barcode,ist(comboBox1.getSelectedIndex()));
	        		int result1 = JOptionPane.showConfirmDialog(null, "确认提交审批？","系统提示",
	    					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
	    			if(result1 == JOptionPane.YES_OPTION) {
	        		ResultMsg result=sob.submitStorageOutDoc(vv);
	        		if(result.isPass()) {
	    			}
	    				else{
	    					JOptionPane.showConfirmDialog(null, result.getMessage(),"系统提示",
	    							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
	    				}
	    			}
	    			else {
	    				return;

	    			}
	        	}
	        });
	        button_1.setBounds(550, 359, 93, 23);
	        add(button_1);
	        
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
	        
	        JButton button_2 = new JButton("加入");
	        button_2.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
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
	        button_2.setBounds(981, 319, 93, 23);
	        add(button_2);
	        
	        codef = new JTextField();
	        codef.setBounds(826, 247, 127, 28);
	        add(codef);
	        codef.setColumns(10);
	        
	        dataf = new JTextField();
	        dataf.setBounds(826, 35, 127, 28);
	        add(dataf);
	        dataf.setColumns(10);
	        
	        bianhaof = new JTextField();
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
			
			tof = new JTextField();
			tof.setBounds(826, 86, 127, 28);
			add(tof);
			tof.setColumns(10);
			
			JButton btnModify = new JButton("modify");
			btnModify.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
				
					int selectedRow =table.getSelectedRow();
					if(selectedRow!=-1){
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
				}
			});
			btnModify.setBounds(878, 319, 93, 23);
			add(btnModify);
			
			JButton btnDelete = new JButton("delete");
			btnDelete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
				
					int seletedRow=table.getSelectedRow();
	        		if(seletedRow!=-1)
	        			model.removeRow(seletedRow);
				}
			});
			btnDelete.setBounds(775, 319, 93, 23);
			add(btnDelete);
			
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
