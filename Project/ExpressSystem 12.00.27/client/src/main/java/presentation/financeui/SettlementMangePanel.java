package presentation.financeui;

import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

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
	private JTextField date;
	private JTextField payee;
	private JTextField institution;
	private JTextField payservice;
	private JTextField money;
	private JTextField account;
	private JTable table;
	private DefaultTableModel model;
	private Vector name;
	private Vector data;
	private SettlementManagementBLService service = new SettlementManagement();
	private BankAccountManagementBLService bankservice = new BankAccountManagement();
	private ResultMsg res;
	public  SettlementMangePanel() {
		setSize(WIDTH,HEIGHT);
		setLayout(null);
		
		JLabel label = new JLabel("收款日期");
		label.setBounds(843, 38, 61, 16);
		add(label);
		
		date = new JTextField();
		date.setBounds(939, 32, 164, 28);
		add(date);
		date.setColumns(10);
		
		JLabel label_1 = new JLabel("收款人");
		label_1.setBounds(843, 89, 61, 16);
		add(label_1);
		
		payee = new JTextField();
		payee.setBounds(939, 83, 164, 28);
		add(payee);
		payee.setColumns(10);
		
		JLabel label_2 = new JLabel("收款单位");
		label_2.setBounds(843, 144, 61, 16);
		add(label_2);
		
		institution = new JTextField();
		institution.setBounds(939, 138, 164, 28);
		add(institution);
		institution.setColumns(10);
		
		JLabel label_3 = new JLabel("交款营业厅");
		label_3.setBounds(843, 194, 78, 16);
		add(label_3);
		
		payservice = new JTextField();
		payservice.setBounds(939, 188, 164, 28);
		add(payservice);
		payservice.setColumns(10);
		
		JLabel label_5 = new JLabel("金额");
		label_5.setBounds(843, 236, 61, 16);
		add(label_5);
		
		money = new JTextField();
		money.setBounds(939, 236, 164, 28);
		add(money);
		money.setColumns(10);
		
		JLabel label_6 = new JLabel("银行账号");
		label_6.setBounds(843, 288, 61, 16);
		add(label_6);
		
		account = new JTextField();
		account.setBounds(939, 282, 164, 28);
		add(account);
		account.setColumns(10);
		
		JButton button = new JButton("提交");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bankAccount = bankservice.find(new BankAccountVO(null,account.getText(),null)).get(0);
				vo = new IncomeNoteVO(money.getText(),date.getText(),institution.getText(),
						payee.getText(),payservice.getText(),bankAccount);
				//daijia
				
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
		table.setBounds(17, 17, 713, 404);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(17, 17, 713, 404);
		add(scrollPane);
	}
}
