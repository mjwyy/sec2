package presentation.logisticui;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

import presentation.logisticui.ReceiveOrderPanel.Submitter;
import presentation.util.CurrentTime;
import presentation.util.EditableTrue;
import presentation.util.MJTextField;
import presentation.util.UnEditablePanel;
import presentation.util.checkstyleDialog;
import util.BarcodesAndLocation;
import util.LogInMsg;
import util.ResultMsg;
import util.enums.TransitType;
import vo.TransitNoteOnTransitVO;
import dataservice.logisticdataservice.TransitNoteInputDataService;
import businesslogic.logistic.TransitNoteInput;
import businesslogicservice.logisticblservice.TransitNoteInputBLService;
import businesslogicservice.logisticblservice._Stub.TransitNoteInputBLService_Stub;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JComboBox;

public class TransitNoteInputPanel extends JPanel {
	TransitNoteInputPanel thisP = this;
	private MJTextField date2;
	private MJTextField transitnum2;
	private MJTextField loader2;
	private MJTextField setout2;
	private MJTextField arrival2;
	private MJTextField date1;
	private MJTextField transitnum1;
	private MJTextField loader1;
	private MJTextField setout1;
	private MJTextField arrival1;
	private MJTextField barcode;
	private DefaultTableModel model;
	private Vector name;
	private Vector data;
    private JTable table;
    private TransitType transitNoteType;
    private TransitNoteInputBLService service = new TransitNoteInput();
    private ResultMsg res;
    private MJTextField section;
    private MJTextField line;
    private MJTextField jiahao;
    private MJTextField number;
    private MJTextField flightNumber2;
    private MJTextField flightNumber1;
    private ArrayList<BarcodesAndLocation> barcodesandLocation = new ArrayList<BarcodesAndLocation>();
    private TransitNoteOnTransitVO transitNoteOnTransitVO;
    private  LogInMsg lim ;
    private int seletedRow = -1;
    private TransitFrame parent;
    private JButton submit;
    private JButton ADD;
    private JButton Modify;
    private JButton delete;
    private JButton confirm;
	/**
	 * 窗口宽度
	 */
	private static final int WIDTH = 1152;
	
	/**
	 * 窗口高度
	 */
	private static final int HEIGHT = 446;
	private JTextField transitType2;

	/**
	 * Create the panel.
	 */
	
	 public static void main(String[] args){
	/*	JFrame f = new JFrame();
		TransitNoteInputPanel p = new TransitNoteInputPanel();
		p.setVisible(true);
		f.setSize(WIDTH,HEIGHT);
	f.getContentPane().add(p);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
	}
	public TransitNoteInputPanel(LogInMsg logInMsg,TransitFrame tf) {
		setSize(1152,446);
		setLayout(null);
		lim = logInMsg;
		JLabel label = new JLabel("日期");
		label.setBounds(84, 44, 61, 16);
		add(label);
		parent  = tf;
		
		date2 = new MJTextField();
		date2.setEditable(false);
		date2.setBounds(142, 38, 134, 28);
		add(date2);
		date2.setColumns(10);
		
		JLabel label_1 = new JLabel("中转单编号");
		label_1.setBounds(348, 44, 74, 16);
		add(label_1);
		
		transitnum2 = new MJTextField();
		transitnum2.setEditable(false);
		transitnum2.setBounds(434, 38, 310, 28);
		add(transitnum2);
		transitnum2.setColumns(10);
		
		JLabel label_2 = new JLabel("监装员");
		label_2.setBounds(84, 115, 61, 16);
		add(label_2);
		
		loader2 = new MJTextField();
		loader2.setEditable(false);
		loader2.setBounds(142, 109, 134, 28);
		add(loader2);
		loader2.setColumns(10);
		
		JLabel label_3 = new JLabel("出发地");
		label_3.setBounds(84, 176, 61, 16);
		add(label_3);
		
		setout2 = new MJTextField();
		setout2.setEditable(false);
		setout2.setBounds(142, 170, 134, 28);
		add(setout2);
		setout2.setColumns(10);
		
		JLabel label_4 = new JLabel("到达地");
		label_4.setBounds(84, 243, 61, 16);
		add(label_4);
		
		arrival2 = new MJTextField();
		arrival2.setEditable(false);
		arrival2.setBounds(142, 237, 134, 28);
		add(arrival2);
		arrival2.setColumns(10);
		
		String[] transitType = {"汽车","火车","飞机"};
		final JComboBox transitType1 = new JComboBox(transitType);
		transitType1.setBounds(891, 200, 78, 27);
		add(transitType1);
		flightNumber1 = new MJTextField();
		flightNumber1.setBounds(966, 198, 134, 28);
		add(flightNumber1);
		flightNumber1.setColumns(10);
		
		
		
		submit = new JButton("提交");
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((!barcodesandLocation.isEmpty())&&(!date2.getText().isEmpty())){			
					transitNoteOnTransitVO = new TransitNoteOnTransitVO(date2.getText(),transitnum2.getText(),
							flightNumber2.getText(),transitNoteType,setout2.getText(),arrival2.getText(),loader2.getText(),barcodesandLocation);
					transitNoteOnTransitVO.setUserName(lim.getUserName());
					transitNoteOnTransitVO.setOrganization(lim.getOrganization());
					UnEditablePanel.UnEdit(TransitNoteInputPanel.this);//设置为不可编辑
					submit.setEnabled(false);
					ADD.setEnabled(false);
					Modify.setEnabled(false);
					delete.setEnabled(false);
					confirm.setEnabled(false);
					parent.setZhongzhuan(true, false, false);
					parent.setTransitNoteInputOanel(thisP);
					new Submitter().start();	
				
			}else{
				int result1 = JOptionPane.showConfirmDialog(null, "请将中转单填写完整","系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			}
			}
		});
		submit.setBounds(626, 385, 117, 37);
		add(submit);
		
		JLabel label_5 = new JLabel("日期");
		label_5.setBounds(818, 44, 61, 16);
		add(label_5);
		
		CurrentTime currentTime = new CurrentTime();
		date1 = new MJTextField();
		date1.setText(currentTime.getCurrentTimeDate());
		date1.setColumns(10);
		date1.setBounds(891, 38, 209, 28);
		add(date1);
		
		JLabel lblNewLabel = new JLabel("条形码");
		lblNewLabel.setBounds(818, 295, 61, 16);
		add(lblNewLabel);
		
		JLabel label_6 = new JLabel("中转单编号");
		label_6.setBounds(818, 78, 99, 16);
		add(label_6);
		
		transitnum1 = new MJTextField();
		transitnum1.setColumns(10);
		transitnum1.setBounds(891, 72, 209, 28);
		add(transitnum1);
		
		JLabel label_7 = new JLabel("监装员");
		label_7.setBounds(818, 109, 61, 16);
		add(label_7);
		
		loader1 = new MJTextField();
		loader1.setColumns(10);
		loader1.setBounds(891, 103, 209, 28);
		add(loader1);
		
		JLabel label_8 = new JLabel("出发地");
		label_8.setBounds(818, 142, 61, 16);
		add(label_8);
		
		JLabel label_9 = new JLabel("到达地");
		label_9.setBounds(818, 170, 61, 16);
		add(label_9);
		
		setout1 = new MJTextField();
		setout1.setColumns(10);
		setout1.setBounds(891, 134, 209, 28);
		add(setout1);
		
		arrival1 = new MJTextField();
		arrival1.setColumns(10);
		arrival1.setBounds(891, 164, 209, 28);
		add(arrival1);
		
		confirm = new JButton("确认");
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<BarcodesAndLocation> mock = new ArrayList<BarcodesAndLocation>();
				 BarcodesAndLocation bal = new  BarcodesAndLocation("1234567890",12,12,12,12);
				 mock.add(bal);
				 
				 if(transitType1.getSelectedItem().equals("汽车"))
					 transitNoteType = transitNoteType.Car;
					else if(transitType1.getSelectedItem().equals("火车"))
						transitNoteType = transitNoteType.Train;
					else
						transitNoteType = transitNoteType.Aircraft;
				 
				 boolean isempty = date1.getText().isEmpty()||transitnum1.getText().isEmpty()||
							flightNumber1.getText().isEmpty()||setout1.getText().isEmpty()||arrival1.getText().isEmpty()||loader1.getText().isEmpty();
				 if(!isempty){
				 TransitNoteOnTransitVO vo = new TransitNoteOnTransitVO(date1.getText(),transitnum1.getText(),
							flightNumber1.getText(),transitNoteType,setout1.getText(),arrival1.getText(),loader1.getText(),mock);
				 
				 res = service.inputCenterTransitDoc(vo);
				if(res.isPass()){
					date2.setText(date1.getText());
					transitnum2.setText(transitnum1.getText());
					setout2.setText(setout1.getText());
					arrival2.setText(arrival1.getText());
					loader2.setText(loader1.getText());
					transitType2.setText((String)transitType1.getSelectedItem());
					flightNumber2.setText(flightNumber1.getText());
				}else{
					int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				}	
				 }else {
					 JOptionPane.showConfirmDialog(null, "有咚咚木有填","系统提示",
								JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				 }
			}
		});
		confirm.setBounds(1006, 238, 86, 28);
		add(confirm);
		
		barcode = new MJTextField();
		barcode.setColumns(10);
		barcode.setBounds(891, 289, 209, 28);
		add(barcode);
		
		name = new Vector();
		name.add("条形码");
		name.add("区号");
		name.add("排号");
		name.add("架号");
		name.add("位号");
		data = new Vector();
		model = new DefaultTableModel();
		model.setDataVector(data, name);
		table = new JTable(model);
		table.setBounds(328, 92, 369, 281);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(298, 100, 446, 273);
		add(scrollPane);
		
	    table.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent arg0) {
        		 seletedRow = table.getSelectedRow();
          		if(seletedRow != -1){
          			barcode.setText(model.getValueAt(seletedRow,0).toString());
          			section.setText(model.getValueAt(seletedRow, 1).toString());
          			line.setText(model.getValueAt(seletedRow, 2).toString());
          			jiahao.setText(model.getValueAt(seletedRow, 3).toString());
          			number.setText(model.getValueAt(seletedRow, 3).toString());
          		}
        	}
        });
		
	
		
		ADD = new JButton("ADD");
		ADD.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {				
					addBarcodeAndLocation();
				
			}
		});
		ADD.setBounds(1006, 394, 86, 28);
		add(ADD);
		
		
		
		
		scrollPane.setViewportView(table);
		
		JLabel label_10 = new JLabel("区号");
		label_10.setBounds(856, 335, 61, 16);
		add(label_10);
		
		section = new MJTextField();
		section.setBounds(905, 329, 39, 28);
		add(section);
		section.setColumns(10);
		
		JLabel label_11 = new JLabel("排号");
		label_11.setBounds(996, 333, 61, 16);
		add(label_11);
		
		line = new MJTextField();
		line.setBounds(1053, 327, 39, 28);
		add(line);
		line.setColumns(10);
		
		JLabel label_12 = new JLabel("架号");
		label_12.setBounds(856, 370, 61, 16);
		add(label_12);
		
		jiahao = new MJTextField();
		jiahao.setBounds(904, 364, 40, 28);
		add(jiahao);
		jiahao.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("位号");
		lblNewLabel_1.setBounds(996, 370, 45, 16);
		add(lblNewLabel_1);
		
		number = new MJTextField();
		number.setBounds(1053, 364, 39, 28);
		add(number);
		number.setColumns(10);
		
		JLabel label_13 = new JLabel("运输号");
		label_13.setBounds(84, 289, 117, 28);
		add(label_13);
		
		flightNumber2 = new MJTextField();
		flightNumber2.setEditable(false);
		flightNumber2.setBounds(142, 289, 134, 28);
		add(flightNumber2);
		flightNumber2.setColumns(10);
		
		JLabel label_14 = new JLabel("运输号");
		label_14.setBounds(818, 204, 88, 16);
		add(label_14);
		
		
		
		
		transitType2 = new MJTextField();
		transitType2.setEditable(false);
		transitType2.setBounds(142, 335, 134, 28);
		add(transitType2);
		transitType2.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("运输类型");
		lblNewLabel_2.setBounds(69, 341, 61, 16);
		add(lblNewLabel_2);
		
		delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(seletedRow != -1){
				model.removeRow(seletedRow);
				barcodesandLocation.remove(seletedRow);
				seletedRow = -1;
				}else {
					JOptionPane.showConfirmDialog(null, "尼木有选择要删除的行哦！","系统提示",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				}
			}
		});
		delete.setBounds(818, 394, 86, 28);
		add(delete);
		
		Modify = new JButton("MODIFY");
		Modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(seletedRow != -1){
					model.removeRow(seletedRow);
					barcodesandLocation.remove(seletedRow);
					seletedRow = -1;
				    addBarcodeAndLocation();		
				}else {
					JOptionPane.showConfirmDialog(null, "尼木有选择要修改的行哦！","系统提示",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				}
			}
		});
		Modify.setBounds(914, 394, 86, 28);
		add(Modify);
		
		

	}
	
	public void paintComponent(Graphics g) {
		 super.paintComponents(g);
		 ImageIcon img = new ImageIcon("image/0011.jpg");
		 g.drawImage(img.getImage(), 0, 0, null);
		 float lineWidth = 3.0f;
	      ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
	      g.drawLine(768, 0, 768, 500);
		}
	
	public TransitNoteOnTransitVO getVO(){
		return transitNoteOnTransitVO;
	}
	
	public void setResult(ResultMsg s) {
		//parent.setzhongzhuanB(false);	//隐藏等待审批字样
		//parent.initzhongzhuan(s.isPass());//显示审批结果
		parent.setZhongzhuan(false, s.isPass(), !s.isPass());
		parent.leftdown.repaint();
		if(s.isPass()){
			parent.setTransitNoteInputOanel(null);
		}else{
			int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
					JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);//提示错误信息
			EditableTrue.Edit(thisP);
			
			date2.setEditable(false);;
			transitnum2.setEditable(false);
			flightNumber2.setEditable(false);
			setout2.setEditable(false);
			arrival2.setEditable(false);
			loader2.setEditable(false);
			submit.setEnabled(true);
			ADD.setEnabled(true);
			Modify.setEnabled(true);
			delete.setEnabled(true);
			confirm.setEnabled(true);
		}
		
		}
	
	class Submitter extends Thread {
		@Override
		public void run() {
			super.run();
			setResult(service.submitCenterTransitDoc(transitNoteOnTransitVO));
		}
	}
	
	public void addBarcodeAndLocation() {
		if(barcode.getText().isEmpty()||section.getText().isEmpty()||line.getText().isEmpty()||
				jiahao.getText().isEmpty()||number.getText().isEmpty()){
		int result1 = JOptionPane.showConfirmDialog(null, "条形码与位置信息要填完整哦！","系统提示",
				JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		}else{
		ArrayList<BarcodesAndLocation> add = new ArrayList<BarcodesAndLocation>();
		BarcodesAndLocation bal = new BarcodesAndLocation(barcode.getText(),Integer.parseInt(section.getText())
				,Integer.parseInt(line.getText()),Integer.parseInt(jiahao.getText()),Integer.parseInt(number.getText()));
		add.add(bal);
		TransitNoteOnTransitVO vo = new TransitNoteOnTransitVO("2015-12-12","025000201510120000002",
				"MF8190",transitNoteType.Aircraft,"南京","北京","王小二",add);
		res = service.inputCenterTransitDoc(vo);
		if(res.isPass()){
			Vector row  = new Vector();
			row.add(barcode.getText());
			row.add(section.getText());
			row.add(line.getText());
			row.add(jiahao.getText());
			row.add(number.getText());
			data.add(row.clone());
			model.setDataVector(data, name);
			table.setModel(model);
			barcode.setText("");
			section.setText(section.getText());
			line.setText("");
			jiahao.setText("");
			number.setText("");
			barcodesandLocation.add(bal);	
		}else{
			int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		}
		}
	}
}

