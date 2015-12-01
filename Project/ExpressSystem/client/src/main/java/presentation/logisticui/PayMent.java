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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

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
	//先用stub代替哦
	private CreditNoteInputBLService payment=new CreditNoteInputBLService_Stub();
	private JTextField DATA;
	private JTextField MONEY;
	private JTextField dataF;
	private JTextField codeF;
	private JTextField senderF;
	private JTextField SENDER;
	private JTextField moneyF;
	private ArrayList<String> barcode=new ArrayList<String>();
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
	private JTable table;
	private DefaultTableModel model;
	/**
	 * Create the panel.
	 */
	public PayMent() {
		setSize(WIDTH,HEIGHT);
		setBackground(Color.WHITE);
		setLayout(null);

		JLabel label = new JLabel("日期");
		label.setBounds(58, 41, 54, 18);
		add(label);

		DATA = new JTextField();
		DATA.setEnabled(false);
		DATA.setEditable(false);
		DATA.setBounds(122, 35, 185, 31);
		add(DATA);
		DATA.setColumns(10);

		JLabel label_4 = new JLabel("金额");
		label_4.setBounds(58, 91, 93, 15);
		add(label_4);

		MONEY = new JTextField();
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

		JButton submit = new JButton("提交");
		submit.addActionListener(new submitListener());
		submit.setBounds(438, 340, 93, 23);
		add(submit);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(122, 188, 225, 150);
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

		dataF = new JTextField();
		dataF.setBounds(WIDTHT, 37, 211, 28);
		add(dataF);
		dataF.setColumns(10);

		JLabel label_13 = new JLabel("派件员");
		label_13.setBounds(787, 147, 82, 15);
		add(label_13);

		JButton confirm = new JButton("确认");
		confirm.addActionListener(new confirmListener());

		confirm.setBounds(978, 188, 93, 23);
		add(confirm);

		JLabel label_14 = new JLabel("货物编码");
		label_14.setBounds(787, 233, 66, 15);
		add(label_14);

		codeF = new JTextField();
		codeF.setBounds(863, 225, 211, 31);
		add(codeF);
		codeF.setColumns(10);

		JButton add = new JButton("添加");
		add.setIcon(null);
		add.addActionListener(new addListener());
		add.setBounds(940, 286, 66, 23);
		add(add);



		JLabel label_2 = new JLabel("新增收款单");
		label_2.setBounds(10, 16, 102, 15);
		add(label_2);

		senderF = new JTextField();
		senderF.setBounds(863, 141, 211, 28);
		add(senderF);
		senderF.setColumns(10);

		JLabel label_1 = new JLabel("快递员");
		label_1.setBounds(329, 43, 54, 15);
		add(label_1);

		SENDER = new JTextField();
		SENDER.setEnabled(false);
		SENDER.setEditable(false);
		SENDER.setBounds(410, 35, 180, 31);
		add(SENDER);
		SENDER.setColumns(10);

		JLabel label_3 = new JLabel("收款金额");
		label_3.setBounds(WIDTHL, 91, 77, 15);
		add(label_3);

		moneyF = new JTextField();
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
		CreditNoteVO vo=null;
		 
		
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
			int result = JOptionPane.showConfirmDialog(null, "确认提交审批？","系统提示",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(result == JOptionPane.YES_OPTION) {
				payment.submitReceipeDoc(vo);
				
			}
			else {
				return;

			}

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
