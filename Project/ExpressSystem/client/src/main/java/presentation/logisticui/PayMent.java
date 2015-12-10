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
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import presentation.logisticui.ArrivalOrder.Submitter;
import presentation.util.CleanTextField;
import presentation.util.CurrentTime;
import presentation.util.LeftDownPanel;
import presentation.util.MJTextField;
import presentation.util.UnEditablePanel;
import util.LogInMsg;
import util.ResultMsg;
import vo.CreditNoteVO;
import vo.PaymentVO;
import vo.ReceivingNoteVO;
import businesslogic.finance.CreditNoteInput;
import businesslogicservice.financeblservice.CreditNoteInputBLService;
import businesslogicservice.financeblservice.PaymentInputBLService;
import businesslogicservice.financeblservice._stub.CreditNoteInputBLService_Stub;
import businesslogicservice.financeblservice._stub.PaymentInputBLService_Stub;
import businesslogicservice.logisticblservice.ReceivingNoteInputBLService;
import businesslogicservice.logisticblservice._Stub.ReceivingNoteInputBLService_Stub;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class PayMent extends JPanel {
	JPanel thisP=this;
	//先用stub代替哦
//	private CreditNoteInputBLService payment=new CreditNoteInputBLService_Stub();
	CreditNoteInputBLService payment=new CreditNoteInput();
	private CreditNoteVO vo;
	//不可编及的框
	private MJTextField DATA;
	private MJTextField MONEY;
	private MJTextField SENDER;
	//可编辑的框
	private JTextField dataF;
	private MJTextField codeF;
	private MJTextField senderF;
	private MJTextField moneyF;
	//frame传来的
	private LogInMsg lim;
	private Service frame;//
	
	//条形码table
	private JTable table;
	private DefaultTableModel model;
	private ArrayList<String> barcode=new ArrayList<String>();
	
	//button
	private JButton add;
	private JButton confirm ;
	private JButton submit ;
	/**
	 * 窗口宽度
	 */
	private static final int WIDTH = 1152;
	
	/**
	 * 窗口高度
	 */
	private static final int HEIGHT = 446;
	/**
	 * 右边标签
	 */
	private static final int WIDTHL = WIDTH/3*2+19;
	/**
	 * 右边field
	 */
	private static final int WIDTHT = WIDTHL+76;

	/**
	 * Create the panel.
	 */
	public PayMent(LogInMsg lim,Service frame) {
		this.frame=frame;
		this.lim=lim;
		setSize(WIDTH,HEIGHT);
		setBackground(Color.WHITE);
		setLayout(null);

		JLabel label = new JLabel("日期");
		label.setBounds(58, 41, 54, 18);
		add(label);

		DATA = new MJTextField();
		DATA.setEnabled(false);
		DATA.setEditable(false);
		DATA.setBounds(122, 35, 185, 31);
		add(DATA);
		DATA.setColumns(10);

		JLabel label_4 = new JLabel("金额");
		label_4.setBounds(58, 91, 93, 15);
		add(label_4);

		MONEY = new MJTextField();
		MONEY.setEnabled(false);
		MONEY.setEditable(false);
		MONEY.setBounds(122, 85, 185, 28);
		add(MONEY);
		MONEY.setColumns(10);

		JLabel label_6 = new JLabel("货物编码");
		label_6.setBounds(190, 147, 93, 15);
		add(label_6);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(226, 188, 147, -51);
		add(scrollPane);

		submit = new JButton("提交");
		submit.addActionListener(new submitListener());
		submit.setBounds(438, 340, 93, 23);
		add(submit);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(122, 188, 195, 150);
		add(scrollPane_1);
		

		 String[] columnNames =  
		        { "货物编码"};  
		  
		        Object[][] obj = new Object[1][1];  
		      
		          
		          
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
		        	codeF.setText(oa.toString());
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
		            column.setPreferredWidth(200);  
		        }  
		        /* 
		         * 设置JTable自动调整列表的状态，此处设置为关闭 
		         */  
		        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
		          
		scrollPane_1.setViewportView(table);

		JLabel label_7 = new JLabel("日期");
		label_7.setBounds(WIDTHL, 43, 54, 15);
		add(label_7);
//日期自动填充
		dataF = new JTextField(CurrentTime.getCurrentTimeDate());
		dataF.setBounds(WIDTHT, 37, 211, 28);
		add(dataF);
		dataF.setColumns(10);

		JLabel label_13 = new JLabel("派件员");
		label_13.setBounds(787, 147, 82, 15);
		add(label_13);

		confirm = new JButton("确认");
		confirm.addActionListener(new confirmListener());

		confirm.setBounds(978, 188, 93, 23);
		add(confirm);

		JLabel label_14 = new JLabel("货物编码");
		label_14.setBounds(787, 233, 66, 15);
		add(label_14);

		codeF = new MJTextField();
		codeF.setBounds(863, 225, 211, 31);
		add(codeF);
		codeF.setColumns(10);

		add = new JButton("添加");
		add.setIcon(null);
		add.addActionListener(new addListener());
		add.setBounds(940, 286, 66, 23);
		add(add);



		JLabel label_2 = new JLabel("新增收款单");
		label_2.setBounds(10, 16, 102, 15);
		add(label_2);

		senderF = new MJTextField();
		senderF.setBounds(863, 141, 211, 28);
		add(senderF);
		senderF.setColumns(10);

		JLabel label_1 = new JLabel("快递员");
		label_1.setBounds(329, 43, 54, 15);
		add(label_1);

		SENDER = new MJTextField();
		SENDER.setEnabled(false);
		SENDER.setEditable(false);
		SENDER.setBounds(410, 35, 180, 31);
		add(SENDER);
		SENDER.setColumns(10);

		JLabel label_3 = new JLabel("收款金额");
		label_3.setBounds(WIDTHL, 91, 77, 15);
		add(label_3);

		moneyF = new MJTextField();
		moneyF.setBounds(WIDTHT, 85, 211, 28);
		add(moneyF);
		moneyF.setColumns(10);
	}

	public class confirmListener implements ActionListener{

		CreditNoteVO vo=null;
		//初始化顺序问题

		public void actionPerformed(ActionEvent arg0) {
			ArrayList<String> ba=new ArrayList<String>();
			ba.add("0123456789");
			vo=new CreditNoteVO(dataF.getText(), moneyF.getText(), senderF.getText(), ba);
			ResultMsg result=payment.addReceipeDoc(vo);
			if(result.isPass()){//格式检查正确
				DATA.setText(dataF.getText());
				MONEY.setText(moneyF.getText());
				SENDER.setText(senderF.getText());
			}
			else{//格式有误
				int result1 = JOptionPane.showConfirmDialog(null, result.getMessage(),"系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

			}
		}
	}
	public void lock(boolean notlock){//解锁那些可以编辑的框框
		//notlock==true 不锁
		//textfield
		dataF.setEditable(notlock);
		dataF.setEnabled(notlock);
		codeF.setEditable(notlock);
		codeF.setEnabled(notlock);
		senderF.setEditable(notlock);
		senderF.setEnabled(notlock);
		moneyF.setEditable(notlock);
		moneyF.setEnabled(notlock);
		//button
		add.setEnabled(notlock);
		confirm.setEnabled(notlock);
		submit.setEnabled(notlock);
	}
	public class addListener implements ActionListener{
		CreditNoteVO vo=null;
		public void actionPerformed(ActionEvent e) {
			ArrayList<String> ba=new ArrayList<String>();
			ba.add(codeF.getText());
			vo=new CreditNoteVO("2011-1-1","10","厘米", ba);
			ResultMsg result=payment.addReceipeDoc(vo);
			if(result.isPass()){//格式检查正确
				String[] s={codeF.getText()};
				model.addRow(s);
				codeF.setText("");
			}
			else{//格式有误
				int result1 = JOptionPane.showConfirmDialog(null, result.getMessage(),"系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

			}
			
		}


	}
	public class submitListener implements ActionListener{
		
		 
		
		public void actionPerformed(ActionEvent e) {
			if(DATA.getText().isEmpty()){
				JOptionPane.showConfirmDialog(null, "有咚咚漏填啦","系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			return ;
			}
			if(model.getRowCount()==0){
				JOptionPane.showConfirmDialog(null, "有咚咚漏填啦","系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			return ;
			}
			int count=model.getRowCount();
			for(int i=0;i<count;i++){
				String cc=model.getValueAt(i, 0).toString();
				barcode.add(cc);
			}
			vo=new CreditNoteVO(DATA.getText(), MONEY.getText(), SENDER.getText(), barcode);
			vo.setUserName(lim.getUserName());
			
			int result = JOptionPane.showConfirmDialog(null, "确认提交审批？","系统提示",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(result == JOptionPane.YES_OPTION) {
				ResultMsg resultS=payment.submitReceipeDoc(vo);
				//提交之后panel里都不可编辑
				lock(false);
				//提交之后右下面板换
				frame.initFukuan(true,false,false);
				//提交审批
				new Submitter().start();
				
			}
			else {
				return;

			}

		}
		}
	public void setResult(ResultMsg s) {//审批之后才调这个方法
		//审批通没通过在这里体现
		frame.initFukuan(false,s.isPass(),!s.isPass());
		frame.leftdown.repaint();
		lock(true);
		if(s.isPass()){//审批通过之后，清空textfiled
			CleanTextField.clean(thisP);
		}
		else{//审批未通过
			JOptionPane.showConfirmDialog(null, s.getMessage());
			
		}
		
		}
	class Submitter extends Thread {
		
		public void run() {
			super.run();
			//ResultMsg result=payment.submitReceipeDoc(vo);
			//setResult(result);
			setResult(payment.submitReceipeDoc(vo));
		}
	}
		public void paintComponent(Graphics g) {
			super.paintComponents(g);
			ImageIcon img = new ImageIcon("image/0111.jpg");
			g.drawImage(img.getImage(), 0, 0, null);
			float lineWidth = 3.0f;
			((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
			g.drawLine(WIDTH/3*2, 0, WIDTH/3*2, HEIGHT);
		}
	}
