package presentation.financeui;

import java.awt.Choice;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.List;

import javax.swing.DefaultComboBoxModel;


import presentation.util.MJTextField;
import presentation.util.SubmitDialog;
import util.LogInMsg;
import util.ResultMsg;
import vo.PaymentVO;
import businesslogic.finance.PaymentInput;
import businesslogicservice.financeblservice.PaymentInputBLService;
import businesslogicservice.financeblservice._stub.PaymentInputBLService_Stub;

public class PaymentInputPanel extends JPanel {
	private MJTextField date;
	private MJTextField payer;
	private MJTextField account;
	private JComboBox way;
	private PaymentInputBLService service = new PaymentInput();
	private ResultMsg res;
	private JButton btnNewButton;
	private SubmitDialog sd;
	private PaymentVO vo;
	private LogInMsg  lim;
	private financeFrame parent;
	/**
	 * 窗口宽度
	 */
	private static final int WIDTH = 1152;
	
	/**
	 * 窗口高度
	 */
	private static final int HEIGHT = 446;
	private JTextField money;

	/**
	 * Create the panel.
	 */
	public PaymentInputPanel(LogInMsg logInMsg,financeFrame ff) {
		parent = ff;
		setSize(WIDTH,HEIGHT);
		setLayout(null);
		lim = logInMsg;
		JLabel label = new JLabel("付款日期");
		label.setBounds(305, 79, 61, 16);
		add(label);
		
		date = new MJTextField();
		date.setBounds(426, 73, 168, 28);
		add(date);
		date.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("付款人");
		lblNewLabel.setBounds(305, 129, 61, 16);
		add(lblNewLabel);
		
		payer = new MJTextField();
		payer.setBounds(426, 123, 168, 28);
		add(payer);
		payer.setColumns(10);
		
		JLabel label_1 = new JLabel("付款账号");
		label_1.setBounds(305, 179, 61, 16);
		add(label_1);
		
		account = new MJTextField();
		account.setBounds(426, 173, 168, 28);
		add(account);
		account.setColumns(10);
		
		JLabel label_2 = new JLabel("付款种类");
		label_2.setBounds(305, 287, 61, 16);
		add(label_2);
		
		String[] payway = {"租金","运费","工资","奖金"};
		way = new JComboBox(payway);
		way.setModel(new DefaultComboBoxModel(new String[] {"租金", "运费", "工资", "奖金"}));
		way.setBounds(426, 282, 134, 28);
		//comboBox.setVisible(true);
		add(way);
		
		JLabel lblNewLabel_1 = new JLabel("付款金额");
		lblNewLabel_1.setBounds(305, 235, 61, 16);
		add(lblNewLabel_1);
		
		money = new JTextField();
		money.setBounds(426, 229, 165, 28);
		add(money);
		money.setColumns(10);
		
		btnNewButton = new JButton("提交");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!(date.getText().isEmpty()||money.getText().isEmpty()||payer.getText().isEmpty()||account.getText().isEmpty())){
				vo = new PaymentVO(date.getText(), money.getText(),payer.getText(),account.getText(),
						(String)way.getSelectedItem());
				res = service.addPaymentRecord(vo);
				if(res.isPass()){
					 sd = new SubmitDialog();
					 sd.setVisible(true);
					sd.getOK().addActionListener(new  ActionListener(){
						@Override
						public void actionPerformed(ActionEvent e) {
							
							date.setEditable(false);
							money.setEditable(false);
							payer.setEditable(false);
							account.setEditable(false);
							way.setEditable(false);
							btnNewButton.setFocusable(false);
							sd.dispose();
							parent.setPip(PaymentInputPanel.this);
							btnNewButton.setFocusable(false);
							new Submitter().start();		
						}
						
					});
				}else{
					int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				}
				
			}else{
				int result1 = JOptionPane.showConfirmDialog(null, "请将信息填写完整","系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			}
				
			}
		});
		btnNewButton.setBounds(565, 322, 94, 47);
		add(btnNewButton);
		
	}
	
	
	
	public void setResult(ResultMsg s) {
		
		if(s.isPass()){
			parent.setPip(null);;
		}else{
			int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
					JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);	
			date.setEditable(true);
			money.setEditable(true);
			payer.setEditable(true);
			account.setEditable(true);
			way.setEditable(true);
			btnNewButton.setFocusable(true);
			btnNewButton.setFocusable(true);
		}
		
		}
	
	class Submitter extends Thread {
		@Override
		public void run() {
			super.run();
			setResult(service.submitPaymentRecord(vo));
		}
	}
}
