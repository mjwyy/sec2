/**
 * 营业厅到达单界面
 * 
 * @author wqy
 *
 */
package presentation.logisticui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import businesslogic.logistic.ArrivalNoteOnService;
import businesslogicservice.logisticblservice.ArrivalNoteOnServiceBLService;
import businesslogicservice.logisticblservice._Stub.ArrivalNoteOnServiceBLService_Stub;
import util.BarcodeAndState;
import util.LogInMsg;
import util.ResultMsg;
import util.enums.GoodsState;
import vo.ArrivalNoteOnServiceVO;
import vo.CreditNoteVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import presentation.util.CurrentTime;
import presentation.util.LeftDownPanel;
import presentation.util.UnEditablePanel;

public class ArrivalOrder extends JPanel {
	JPanel thisP=this;
	//ArrivalNoteOnServiceBLService arrive=new ArrivalNoteOnServiceBLService_Stub();
	ArrivalNoteOnServiceBLService arrive=new ArrivalNoteOnService();
	private JTextField DATA;
	private JTextField FROM;
	private JTextField CODE;
	private JTextField dataF;
	private JTextField barcodeF;
	private JTextField fromF;
	private ArrayList<BarcodeAndState> BarcodeAndStates =new ArrayList<BarcodeAndState>();
	private JComboBox state;
private LogInMsg lim;
private Service frame;//
	
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
	private JTextField codeF;
	private JTextField TYPE;
	private JComboBox typeF;
	private JTable table;
	private DefaultTableModel model;
	
	public ArrivalOrder(LogInMsg lim,Service frame) {


		/**
		 * Create the panel.
		 */
		this.lim=lim;
		this.frame=frame;
		setSize(WIDTH,HEIGHT);
		setBackground(Color.WHITE);
		setLayout(null);

		JLabel label = new JLabel("日期");
		label.setBounds(97, 41, 82, 18);
		add(label);

		DATA = new JTextField();
		DATA.setEnabled(false);
		DATA.setEditable(false);
		DATA.setBounds(189, 37, 130, 28);
		add(DATA);
		DATA.setColumns(10);

		JLabel label_1 = new JLabel("出发地");
		label_1.setBounds(348, 43, 71, 18);
		add(label_1);

		FROM = new JTextField();
		FROM.setEnabled(false);
		FROM.setEditable(false);
		FROM.setBounds(429, 37, 147, 28);
		add(FROM);
		FROM.setColumns(10);

		JLabel lblNewLabel = new JLabel("单据编号");
		lblNewLabel.setBounds(97, 122, 82, 18);
		add(lblNewLabel);

		CODE = new JTextField();
		CODE.setEditable(false);
		CODE.setEnabled(false);
		CODE.setBounds(189, 116, 242, 28);
		add(CODE);
		CODE.setColumns(10);

		JLabel label_6 = new JLabel("货物编码");
		label_6.setBounds(244, 163, 93, 18);
		add(label_6);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(226, 188, 147, -51);
		add(scrollPane);

		JButton btnNewButton = new JButton("提交");
		btnNewButton.setBounds(310, 356, 93, 23);
		btnNewButton.addActionListener(new submitListener());
		add(btnNewButton);

	
		
		
		 String[] columnNames =  
		        { "货物编码", "货物状态"};  
		  
		        Object[][] obj = new Object[1][2];  
		      
		          
		          
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
		        	Object ob=model.getValueAt(selectedRow, 1);
		        	state.setSelectedItem(ob.toString());;
		        	
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
		          
		        /*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/  
		        JScrollPane scroll = new JScrollPane(table); 
		    	scroll.setBounds(120, 188, 353, 138);
		scroll.setViewportView(table);
		add(scroll);

		JLabel label_7 = new JLabel("日期");
		label_7.setBounds(WIDTHL, 43, 54, 15);
		add(label_7);
		//日期自动填充
		dataF = new JTextField(CurrentTime.getCurrentTimeDate());
		dataF.setBounds(863, 40, 140, 28);
		add(dataF);
		dataF.setColumns(10);

		JLabel label_11 = new JLabel("出发地");
		label_11.setBounds(WIDTHL, 81, 54, 15);
		add(label_11);

		JButton btnNewButton_1 = new JButton("确认");
		btnNewButton_1.setBounds(1025, 223, 93, 23);
		btnNewButton_1.addActionListener(new confirmListener());
		add(btnNewButton_1);

		JLabel label_14 = new JLabel("货物编码");
		label_14.setBounds(787, 265, 66, 15);
		add(label_14);

		barcodeF = new JTextField();
		barcodeF.setBounds(863, 157, 255, 28);
		add(barcodeF);
		barcodeF.setColumns(10);

		JButton button = new JButton("添加");
		button.addActionListener(new addListener());
		button.setBounds(1025, 330, 93, 23);
		add(button);

		fromF = new JTextField();
		fromF.setBounds(863, 78, 140, 28);
		add(fromF);
		fromF.setColumns(10);


		JLabel label_2 = new JLabel("新增到达单");
		label_2.setBounds(10, 0, 102, 15);
		add(label_2);

		JLabel label_3 = new JLabel("单据编号");
		label_3.setBounds(787, 163, 66, 15);
		add(label_3);

		codeF = new JTextField();
		codeF.setBounds(863, 259, 140, 28);
		add(codeF);
		codeF.setColumns(10);

		JLabel label_5 = new JLabel("货物状态");
		label_5.setBounds(787, 308, 76, 15);
		add(label_5);

		state = new JComboBox();
		state.setModel(new DefaultComboBoxModel(new String[] {"完整", "损坏", "丢失"}));
		state.setBounds(873, 305, 130, 21);
		add(state);
		
		JLabel label_4 = new JLabel("编号类型");
		label_4.setBounds(787, 125, 66, 15);
		add(label_4);
		
		 typeF = new JComboBox();
		typeF.setModel(new DefaultComboBoxModel(new String[] {"中转单编号", "汽运编号"}));
		typeF.setBounds(863, 119, 140, 21);
		add(typeF);
		
		JLabel lblNewLabel_1 = new JLabel("编号类型");
		lblNewLabel_1.setBounds(97, 81, 82, 18);
		add(lblNewLabel_1);
		
		TYPE = new JTextField();
		TYPE.setEnabled(false);
		TYPE.setEditable(false);
		TYPE.setBounds(189, 81, 130, 28);
		add(TYPE);
		TYPE.setColumns(10);



	}
	public class confirmListener implements ActionListener{

		ArrivalNoteOnServiceVO  vo=null;
		//初始化顺序问题
		Boolean isT;
		//伪造的vo
		
		public void actionPerformed(ActionEvent arg0) {
			ArrayList<BarcodeAndState> wei =new ArrayList<BarcodeAndState>();
			GoodsState state1=GoodsState.COMPLETE;
			BarcodeAndState bas=new BarcodeAndState("0123456789",state1);
			wei.add(bas);
			if(typeF.getSelectedIndex()==0)
				isT=false;
			else isT=true;
			vo=new ArrivalNoteOnServiceVO (dataF.getText(),isT, barcodeF.getText(),fromF.getText(),wei);
			ResultMsg result=arrive.inputHallArrivalDoc(vo);
			if(result.isPass()){//格式检查正确
			DATA.setText(dataF.getText());
			CODE.setText(barcodeF.getText());
			FROM.setText(fromF.getText());
			TYPE.setText(typeF.getSelectedItem().toString());
			
			}
			else{//格式有误
				int result1 = JOptionPane.showConfirmDialog(null, result.getMessage(),"系统提示",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

				}
		
			
		}
	}
	public class addListener implements ActionListener{
		String s="";
		GoodsState state1;
		BarcodeAndState bas;
		public void actionPerformed(ActionEvent e) {
			if(state.getSelectedItem().toString().equals("完整"))
				state1=GoodsState.COMPLETE;
			else if(state.getSelectedItem().toString().equals("损坏"))
				state1=GoodsState.DAMAGED;
			else
				state1=GoodsState.LOST;
			bas=new BarcodeAndState(codeF.getText(),state1);
			//伪造的vo
			ArrayList<BarcodeAndState> wei =new ArrayList<BarcodeAndState>();
			wei.add(bas);
			ArrivalNoteOnServiceVO  aa=new ArrivalNoteOnServiceVO("2015-10-22",false,"025000201510120000003","南京",wei);
			ResultMsg result=arrive.inputHallArrivalDoc(aa);
			if(result.isPass()){//格式检查正确
				String[] row={codeF.getText(),state.getSelectedItem().toString()};
				model.addRow(row);
				codeF.setText("");
			}
			else{//格式有误
				int result1 = JOptionPane.showConfirmDialog(null, result.getMessage(),"系统提示",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

				}
		}


	}
	public class submitListener implements ActionListener{
		ArrivalNoteOnServiceVO  vo=null;
		Boolean isT;

		public void actionPerformed(ActionEvent e) {
			if(TYPE.getText().isEmpty()){
				JOptionPane.showConfirmDialog(null, "有咚咚漏填啦","系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			return ;
			}
			if(model.getRowCount()==0){
				JOptionPane.showConfirmDialog(null, "有咚咚漏填啦","系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			return ;
			}
			if(TYPE.getText().equals("中转单编号"))
				isT=false;
			else isT=true;
			//获取table里的数据BarcodeAndStates加到
			int count=model.getRowCount();
			for(int i=0;i<count;i++){
				String cc=model.getValueAt(i, 0).toString();
				String gs=model.getValueAt(i, 1).toString();
				GoodsState gss;
				if(gs.equals("完整"))
					gss=GoodsState.COMPLETE;
				else if(gs.equals("损坏"))
					gss=GoodsState.DAMAGED;
				else
					gss=GoodsState.LOST;
				BarcodeAndState aaaa=new BarcodeAndState(cc,gss);
				BarcodeAndStates.add(aaaa);
			}
			vo=new ArrivalNoteOnServiceVO (DATA.getText(),isT, CODE.getText(),FROM.getText(),BarcodeAndStates);
			vo.setUserName(lim.getUserName());
			int result1 = JOptionPane.showConfirmDialog(null, "确认提交审批？","系统提示",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			if(result1 == JOptionPane.YES_OPTION) {
				ResultMsg resultS=arrive.submitHallArrivalDoc(vo);
				
			//提交之后panel里都不可编辑
			UnEditablePanel.UnEdit(thisP);
			//提交之后右下面板换
			frame.initDaoda(false);
		/*	LeftDownPanel ldp=new LeftDownPanel();
			ldp.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
			ldp.setBounds(0,0,939, 124);
		ldp.setVisible(true);
			frame.leftdown.removeAll();
			frame.leftdown.add(ldp);
			frame.leftdown.repaint();*/
			if(resultS.isPass()){//提交成功
//判断审批是否通过
			}
			else{//有误
				JOptionPane.showConfirmDialog(null, resultS.getMessage(),"系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

			}
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
