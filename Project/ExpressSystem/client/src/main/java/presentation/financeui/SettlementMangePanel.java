package presentation.financeui;

import java.rmi.RemoteException;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import presentation.util.CurrentTime;
import presentation.util.MJTextField;
import util.ResultMsg;
import vo.BankAccountVO;
import vo.IncomeNoteVO;
import businesslogic.finance.SettlementManagement;
import businesslogic.info.BankAccountManagement;
import businesslogicservice.financeblservice.SettlementManagementBLService;
import businesslogicservice.financeblservice._stub.SettlementManagementBLService_Stub;
import businesslogicservice.infoblservice.BankAccountManagementBLService;
import businesslogicservice.infoblservice._stub.BankAccountManagemntBLService_Stub;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JComboBox;

import dataservice.exception.ElementNotFoundException;


public class SettlementMangePanel extends JPanel {

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
	private BankAccountVO bankAccount;
	private IncomeNoteVO vo;
	private MJTextField date;
	private MJTextField payee;
	private MJTextField institution;
	private MJTextField payservice;
	private MJTextField money;
	private MJTextField account;
	private JTable table;
	private DefaultTableModel model;
	private Vector name;
	private Vector data;
	private SettlementManagementBLService service = new SettlementManagement();
	private BankAccountManagementBLService bankservice = new BankAccountManagement();
	private ResultMsg res;
	private JTextField keyword;
	private ArrayList<IncomeNoteVO> IncomeNoteVOList;
	private JComboBox keywordtype;
	public  SettlementMangePanel() {
		setSize(WIDTH,HEIGHT);
		setLayout(null);
		
		JLabel label = new JLabel("收款日期");
		label.setBounds(843, 38, 61, 16);
		add(label);
		
		date = new MJTextField();
		date.setText(CurrentTime.getCurrentTimeDate());
		date.setBounds(939, 32, 164, 28);
		add(date);
		date.setColumns(10);
		
		JLabel label_1 = new JLabel("收款人");
		label_1.setBounds(843, 89, 61, 16);
		add(label_1);
		
		payee = new MJTextField();
		payee.setBounds(939, 83, 164, 28);
		add(payee);
		payee.setColumns(10);
		
		JLabel label_2 = new JLabel("收款单位");
		label_2.setBounds(843, 144, 61, 16);
		add(label_2);
		
		institution = new MJTextField();
		institution.setBounds(939, 138, 164, 28);
		add(institution);
		institution.setColumns(10);
		
		JLabel label_3 = new JLabel("交款营业厅");
		label_3.setBounds(843, 194, 78, 16);
		add(label_3);
		
		payservice = new MJTextField();
		payservice.setBounds(939, 188, 164, 28);
		add(payservice);
		payservice.setColumns(10);
		
		JLabel label_5 = new JLabel("金额");
		label_5.setBounds(843, 236, 61, 16);
		add(label_5);
		
		money = new MJTextField();
		money.setBounds(939, 236, 164, 28);
		add(money);
		money.setColumns(10);
		
		JLabel label_6 = new JLabel("银行账号");
		label_6.setBounds(843, 288, 61, 16);
		add(label_6);
		
		account = new MJTextField();
		account.setBounds(939, 282, 164, 28);
		add(account);
		account.setColumns(10);
		
		JButton button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//bankAccount = bankservice.find(new BankAccountVO(null,account.getText(),null)).get(0);
				if(bankservice.find(new BankAccountVO(null,account.getText(),null)).isEmpty()){
					int result1 = JOptionPane.showConfirmDialog(null, "无此银行账户","系统提示",
							JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);
				}
				else{
					bankAccount = bankservice.find(new BankAccountVO(null,account.getText(),null)).get(0);
				if(money.getText().isEmpty()||date.getText().isEmpty()||institution.getText().isEmpty()||
						payee.getText().isEmpty()||payservice.getText().isEmpty()){
					int result1 = JOptionPane.showConfirmDialog(null, "有咚咚木有填","系统提示",
							JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);
				}else{
				vo = new IncomeNoteVO(money.getText(),date.getText(),institution.getText(),
						payee.getText(),payservice.getText(),bankAccount);
				res = service.addReceiveRecord(vo);
				if(res.isPass()){
					Vector row = new Vector();
					row.add(date.getText());
					row.add(payee.getText());
					row.add(institution.getText());
					row.add(payservice.getText());
					row.add(money.getText());
					row.add(account.getText());
					data.add(row.clone());
					int result1 = JOptionPane.showConfirmDialog(null, "提交成功","系统提示",
							JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);
				}else{
					int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
							JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);
				}
				}
			}
			}
		});
		button.setBounds(986, 350, 117, 29);
		add(button);
		
		name = new Vector();
		name.add("收款日期");
		name.add("收款人");
		name.add("收款单位");
		name.add("交款营业厅");
		name.add("金额");
		name.add("银行账号");
		data = new Vector();
		model = new DefaultTableModel();
		model.setDataVector(data,name);
		table = new JTable(model);
		table.setBounds(17, 100, 713, 321);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(17, 100, 713, 321);
		add(scrollPane);
		
		JLabel label_4 = new JLabel("关键字类型");
		label_4.setBounds(17, 38, 94, 16);
		add(label_4);
		
		String[] type = {"收款日期","收款人","收款单位","交款营业厅"};
		keywordtype = new JComboBox(type);
		keywordtype.setBounds(123, 34, 177, 28);
		add(keywordtype);
		
		keyword = new JTextField();
		keyword.setBounds(309, 33, 231, 29);
		add(keyword);
		keyword.setColumns(10);
		
		JButton button_1 = new JButton("查询");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				data.clear();
				if(keywordtype.getSelectedItem().toString().equals("收款日期"))
				vo = new IncomeNoteVO(null,keyword.getText(),null,null,null,null);
				else if(keywordtype.getSelectedItem().toString().equals("收款人"))
					vo = new IncomeNoteVO(null,null,null,keyword.getText(),null,null);
				else if(keywordtype.getSelectedItem().toString().equals("收款单位"))
					vo = new IncomeNoteVO(null,null,keyword.getText(),null,null,null);
				else 
					vo = new IncomeNoteVO(null,null,null,null,keyword.getText(),null);
				IncomeNoteVOList = service.find(vo);
				if(!IncomeNoteVOList.isEmpty()){
				for(int i = 0;i<IncomeNoteVOList.size();i++){
				Vector row = new Vector();
				row.add(IncomeNoteVOList.get(i).getDate());
				row.add(IncomeNoteVOList.get(i).getPayee());
				row.add(IncomeNoteVOList.get(i).getInstitution());
				row.add(IncomeNoteVOList.get(i).getPayService());
				row.add(IncomeNoteVOList.get(i).getMoney());
				row.add(IncomeNoteVOList.get(i).getBankAccount().getAccount());
				data.add(row.clone());
				}
				}else {
					JOptionPane.showConfirmDialog(null, "未查询到相关信息","系统提示",
							JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);
				}
			}
		});
		button_1.setBounds(613, 33, 117, 29);
		add(button_1);
	}
}
