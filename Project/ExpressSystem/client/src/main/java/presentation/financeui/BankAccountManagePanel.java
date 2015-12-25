package presentation.financeui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import util.ResultMsg;
import vo.BankAccountVO;
import businesslogic.info.BankAccountManagement;
import businesslogicservice.infoblservice.BankAccountManagementBLService;
import businesslogicservice.infoblservice._stub.BankAccountManagemntBLService_Stub;

import javax.swing.JComboBox;

import presentation.util.MJTextField;

public class BankAccountManagePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	/**
	 * 窗口宽度
	 */
	private static final int WIDTH = 1152;
	
	/**
	 * 窗口高度
	 */
	private static final int HEIGHT = 446;
	private DefaultTableModel model;
	private Vector name;
	private Vector data;
	private JTable table;
	private MJTextField account;
	private MJTextField accountname;
	private MJTextField balance;
	private BankAccountManagementBLService service = new BankAccountManagement();
	private ArrayList<BankAccountVO> bankAccountList;
	private BankAccountVO vo;
	private ResultMsg res;
	private JTextField keywordText;
	private int seletedRow;
	private JComboBox keyword;
	
	public BankAccountManagePanel(boolean hasBase) {
       setSize(WIDTH,HEIGHT);
       setLayout(null);
       
       JLabel label = new JLabel("账号");
       label.setBounds(812, 95, 61, 16);
       add(label);
       
       account = new MJTextField();
       account.setBounds(905, 89, 204, 28);
       add(account);
       account.setColumns(10);
       
       JLabel label_1 = new JLabel("账户名");
       label_1.setBounds(812, 189, 61, 16);
       add(label_1);
       
       accountname = new MJTextField();
       accountname.setBounds(905, 183, 204, 28);
       add(accountname);
       accountname.setColumns(10);
       
       JLabel label_2 = new JLabel("余额");
       label_2.setBounds(812, 288, 61, 16);
       add(label_2);
       
       balance = new MJTextField();
       balance.setBounds(905, 282, 204, 28);
       add(balance);
       balance.setColumns(10);
       
       name = new Vector();
     		name.add("账号");
     		name.add("账户名");
     		name.add("余额");
     		data = new Vector();
     		model = new DefaultTableModel();
     		model.setDataVector(data,name);
     		table = new JTable(model);
     		table.setBounds(47, 61, 604, 359);
     		
            JScrollPane scrollPane = new JScrollPane(table);
            scrollPane.setBounds(73, 109, 604, 274);
            add(scrollPane);
            if(hasBase){
            showall();
            }
            
            table.addMouseListener(new MouseAdapter() {
	        	public void mouseClicked(MouseEvent arg0) {
	        		 seletedRow = table.getSelectedRow();
	          		if(seletedRow != -1){
	            		accountname.setText(model.getValueAt(seletedRow,1).toString());
	            		account.setText(model.getValueAt(seletedRow, 0).toString());
	            		balance.setText(model.getValueAt(seletedRow, 2).toString());
	            		//System.out.println("lalllla");
	          		}
	        	}
	        });
           
       
       JButton btnAdd = new JButton("Add");
       btnAdd.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       		if(!(account.getText().isEmpty()||accountname.getText().isEmpty()||balance.getText().isEmpty())){
       			vo = new BankAccountVO(accountname.getText(),account.getText(),balance.getText());
       			res = service.add(vo);
       			if(res.isPass()){
       				Vector row = new Vector();
       				row.add(account.getText());
       				row.add(accountname.getText());
       				row.add(balance.getText());
       				data.add(row.clone());
       				model.setDataVector(data, name);
       				table.setModel(model);
       			}
       			else{
       			  int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
       			}
       			
       			
       		}else{
		    	   int result1 = JOptionPane.showConfirmDialog(null, "请将信息填写完整","系统提示",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		       }
       		
       	}
       });
       btnAdd.setBounds(812, 334, 75, 49);
       add(btnAdd);
       
       JButton btnNewButton = new JButton("Modify");
       btnNewButton.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       		seletedRow = table.getSelectedRow();
    		
       		if(seletedRow != -1){
        			
	        	vo = new BankAccountVO(accountname.getText(),account.getText(),balance.getText());
	        	res = service.update(vo);
	        	if(res.isPass()){
	        		model.setValueAt(account.getText(),seletedRow, 0);
		        	model.setValueAt(accountname.getText(),seletedRow, 1);
		        	model.setValueAt(balance.getText(),seletedRow, 2);
		        	
	        	}else{
	        		int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
							JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);
	        	}
	        	
       		}
       		
       	}
       });
       btnNewButton.setBounds(926, 334, 73, 49);
       add(btnNewButton);
       
       JButton btnNewButton_1 = new JButton("Delete");
       btnNewButton_1.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       		seletedRow=table.getSelectedRow();
    		if(seletedRow!=-1){
    			int result2 = JOptionPane.showConfirmDialog(null, "确定要删除吗？","系统提示", 
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
    			if(result2 == JOptionPane.YES_OPTION){
    			vo = new BankAccountVO(model.getValueAt(seletedRow, 1).toString(),
    					model.getValueAt(seletedRow, 0).toString(),model.getValueAt(seletedRow, 2).toString());
    			res = service.delete(vo);
    			if(res.isPass()){
    			model.removeRow(seletedRow);
    			accountname.setText("");
           		account.setText("");
           		balance.setText("");
           		JOptionPane.showConfirmDialog(null, "删除成功","系统提示",
						JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);
    		}
    			else{
    				int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
							JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);
    			}
    			
    			}
			
    		}
       	}
       });
       btnNewButton_1.setBounds(1036, 334, 73, 49);
       add(btnNewButton_1);
       
    
       
       JButton button = new JButton("显示所有");
       button.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       	showall();
       	}
       });
       button.setBounds(602, 56, 75, 41);
       add(button);
       
       JLabel label_3 = new JLabel("关键字");
       label_3.setBounds(49, 66, 61, 16);
       add(label_3);
       
       String[] keyType = {"账户名","账号","余额"}; 
       keyword = new JComboBox(keyType);
       keyword.setBounds(92, 62, 117, 28);
       add(keyword);
       
       keywordText = new JTextField();
       keywordText.setBounds(223, 61, 254, 28);
       add(keywordText);
       keywordText.setColumns(10);
       
       JButton button_1 = new JButton("查询");
       button_1.addActionListener(new ActionListener() {
       	public void actionPerformed(ActionEvent e) {
       		data.clear();
       		if(keyword.getSelectedItem().equals("账户名"))
       			vo = new BankAccountVO(keywordText.getText(),null,null);
       		else if(keyword.getSelectedItem().equals("账号"))
       			vo = new BankAccountVO(null,keywordText.getText(),null);
       		else
       			vo = new BankAccountVO(null,null,keywordText.getText());
       		
       		bankAccountList = service.find(vo);
       		if(!bankAccountList.isEmpty()){
	       		for(int i = 0;i<bankAccountList.size();i++){
	       			Vector row = new Vector();
	       			row.add(bankAccountList.get(i).getAccount());
	       			row.add(bankAccountList.get(i).getName());
	       			row.add(bankAccountList.get(i).getBalance());
	       			data.add(row.clone());
	       		}
	       		model.setDataVector(data, name);
	   			table.setModel(model);
       		}else{
       			 JOptionPane.showConfirmDialog(null, "木有查询到相关账户(((o(*ﾟ▽ﾟ*)o)))","系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
       		}
       		
       	}
       });
       button_1.setBounds(501, 56, 75, 41);
       add(button_1);
	}
	
	public void showall() {
		bankAccountList = service.show();
   		data.clear();
   		if(!bankAccountList.isEmpty()){
 		for(int i = 0;i<bankAccountList.size();i++){
 			Vector row = new Vector();
 			row.add(bankAccountList.get(i).getAccount());
 			row.add(bankAccountList.get(i).getName());
 			row.add(bankAccountList.get(i).getBalance());
 			data.add(row.clone());
 		}
 		model.setDataVector(data, name);
			table.setModel(model);  		
   	}else{
   		Vector row = new Vector();
   		row.add("无信息显示");
   		model.setDataVector(data, name);
			table.setModel(model);
   	}
	}
}
