/**
 * 营业厅快递收款单界面
 * 
 * @author wqy
 *
 */
package presentation.logisticui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;

import util.ResultMsg;
import vo.CreditNoteVO;
import vo.PaymentVO;
import vo.ReceivingNoteVO;
import businesslogicservice.financeblservice.CreditNoteInputBLService;
import businesslogicservice.financeblservice.PaymentInputBLService;
import businesslogicservice.financeblservice._stub.CreditNoteInputBLService_Stub;
import businesslogicservice.financeblservice._stub.PaymentInputBLService_Stub;
import businesslogicservice.logisticblservice.ReceivingNoteInputBLService;
import businesslogicservice.logisticblservice._Stub.ReceivingNoteInputBLService_Stub;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

public class PayMent extends JPanel {
	//先用stub代替哦
	private CreditNoteInputBLService payment=new CreditNoteInputBLService_Stub();
	private JTextField DATA;
	private JTextField MONEY;
	private JTextField dataF;
	private JTextField codeF;
	private JTextField senderF;
	private JTextField SENDER;
	private JTextField moneyF;
	private JTextArea CODE;
	private ArrayList<String> barcode=new ArrayList<String>();
	/**
	 * Create the panel.
	 */
	public PayMent() {
		setBackground(Color.WHITE);
		setLayout(null);

		JLabel label = new JLabel("日期");
		label.setBounds(58, 41, 54, 18);
		add(label);

		DATA = new JTextField();
		DATA.setEnabled(false);
		DATA.setEditable(false);
		DATA.setBounds(122, 40, 94, 31);
		add(DATA);
		DATA.setColumns(10);

		JLabel label_4 = new JLabel("金额");
		label_4.setBounds(58, 81, 93, 15);
		add(label_4);

		MONEY = new JTextField();
		MONEY.setEnabled(false);
		MONEY.setEditable(false);
		MONEY.setBounds(122, 78, 94, 28);
		add(MONEY);
		MONEY.setColumns(10);

		JLabel label_6 = new JLabel("货物编码");
		label_6.setBounds(150, 163, 93, 15);
		add(label_6);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(226, 188, 147, -51);
		add(scrollPane);

		JButton submit = new JButton("提交");
		submit.addActionListener(new submitListener());
		submit.setBounds(278, 304, 93, 23);
		add(submit);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(58, 188, 334, 99);
		add(scrollPane_1);

		CODE = new JTextArea();
		CODE.setLineWrap(true);//可以换行
		scrollPane_1.setViewportView(CODE);

		JLabel label_7 = new JLabel("日期");
		label_7.setBounds(497, 43, 54, 15);
		add(label_7);

		dataF = new JTextField();
		dataF.setBounds(592, 40, 110, 28);
		add(dataF);
		dataF.setColumns(10);

		JLabel label_13 = new JLabel("派件员");
		label_13.setBounds(497, 132, 82, 15);
		add(label_13);

		JButton confirm = new JButton("确认");
		confirm.addActionListener(new confirmListener());

		confirm.setBounds(672, 174, 93, 23);
		add(confirm);

		JLabel label_14 = new JLabel("货物编码");
		label_14.setBounds(497, 247, 66, 15);
		add(label_14);

		codeF = new JTextField();
		codeF.setBounds(594, 244, 171, 31);
		add(codeF);
		codeF.setColumns(10);

		JButton add = new JButton("添加");
		add.addActionListener(new addListener());
		add.setBounds(672, 304, 93, 23);
		add(add);



		JLabel label_2 = new JLabel("新增收款单");
		label_2.setBounds(10, 0, 102, 15);
		add(label_2);

		senderF = new JTextField();
		senderF.setBounds(592, 129, 110, 28);
		add(senderF);
		senderF.setColumns(10);

		JLabel label_1 = new JLabel("快递员");
		label_1.setBounds(258, 43, 54, 15);
		add(label_1);

		SENDER = new JTextField();
		SENDER.setEnabled(false);
		SENDER.setEditable(false);
		SENDER.setBounds(306, 40, 86, 31);
		add(SENDER);
		SENDER.setColumns(10);

		JLabel label_3 = new JLabel("收款金额");
		label_3.setBounds(497, 81, 77, 15);
		add(label_3);

		moneyF = new JTextField();
		moneyF.setBounds(592, 78, 110, 28);
		add(moneyF);
		moneyF.setColumns(10);
	}

	public class confirmListener implements ActionListener{

		//	CreditNoteVO vo=new CreditNoteVO(dataF.getText(), moneyF.getText(), senderF.getText(), null);
		//ResultMsg result=payment.addReceipeDoc(vo);
		boolean result=true;
		public void actionPerformed(ActionEvent arg0) {
			if(result){//格式检查正确
				DATA.setText(dataF.getText());
				MONEY.setText(moneyF.getText());
				SENDER.setText(senderF.getText());
			}
			else{//格式有误
				int result1 = JOptionPane.showConfirmDialog(null, "格式错误，请检查输入","系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

			}
		}
	}
	public class addListener implements ActionListener{
		String s="";

		public void actionPerformed(ActionEvent e) {
			barcode.add(codeF.getText());
			s=s+codeF.getText()+"\r\n";
			CODE.setText(s);
			codeF.setText("");
		}


	}
	public class submitListener implements ActionListener{
	//	CreditNoteVO vo=new CreditNoteVO(DATA.getText(), MONEY.getText(), SENDER.getText(), barcode);
		public void actionPerformed(ActionEvent e) {
			int result = JOptionPane.showConfirmDialog(null, "确认提交审批？","系统提示",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(result == JOptionPane.YES_OPTION) {
				//payment.submitReceipeDoc(vo);
				
			}
			else {
				return;

			}

		}
		}
		public void paintComponent(Graphics g) {
			super.paintComponents(g);
			ImageIcon img = new ImageIcon("C:\\Users\\Administrator\\Desktop\\0011.jpg");
			g.drawImage(img.getImage(), 0, 0, null);
			float lineWidth = 3.0f;
			((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
			g.drawLine(450, 0, 450, 400);
		}
	}
