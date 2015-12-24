package presentation.logisticui;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import presentation.financeui.PaymentInputPanel;
import presentation.logisticui.ReceiveOrderPanel.Submitter;
import presentation.util.Chachong;
import presentation.util.CurrentTime;
import presentation.util.GetTime;
import presentation.util.MJTextField;
import presentation.util.UnEditablePanel;
import presentation.util.checkstyleDialog;
import util.BarcodeAndState;
import util.LogInMsg;
import util.ResultMsg;
import util.enums.GoodsState;
import vo.ArrivalNoteOnTransitVO;

import javax.swing.JTextArea;

import businesslogic.logistic.ArrivalNoteOnTransit;
import businesslogicservice.logisticblservice.ArrivalNoteOnTransitBLService;
import businesslogicservice.logisticblservice._Stub.ArrivalNoteOnTransitBLService_Stub;

import java.awt.SystemColor;

public class ArrivalNoteOnTransitPanel extends JPanel {
	 ArrivalNoteOnTransitPanel thisP  = this;
	private MJTextField centrenum1;
	private MJTextField date1;
	private MJTextField barcode;
	private MJTextField departure1;
	private MJTextField trannum1;
	private ArrivalNoteOnTransitBLService service = new ArrivalNoteOnTransit();
	private BarcodeAndState brcodeAndState;
	private ResultMsg res;
	private JTextField date2;
	private JTextField centrenum2;
	private JTable table;
	private DefaultTableModel model;
	private Vector name;
	private Vector data;
	private JTextField departure2;
	private JTextField trannum2;
	private ArrivalNoteOnTransitVO arrivalNoteOnTransitVO;
	private ArrayList<BarcodeAndState> barcodeAndStates = new ArrayList<BarcodeAndState>();
	private LogInMsg lim; 
	private JButton button_1;
	private JComboBox statechoose;
	private int seletedRow = -1;
	private TransitFrame parent;
	private JButton delete ;
	private JButton ADD;
	private JButton confirm;
	private JButton submit;
	private JButton modify;
	private String jigou;
	
	/**
	 * Create the panel.
	 */
	
	 public static void main(String[] args){
		/*JFrame f = new JFrame();
		ArrivalNoteOnTransitPanel p = new ArrivalNoteOnTransitPanel();
		p.setVisible(true);
		f.setSize(1150,444);
	f.getContentPane().add(p);
		f.setVisible(true);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
	}
	public ArrivalNoteOnTransitPanel( LogInMsg  logInMsg,TransitFrame ft) {
		parent = ft;
		service = new ArrivalNoteOnTransit();
		barcodeAndStates = new ArrayList<BarcodeAndState>();
		setBackground(SystemColor.window);
		setSize(1152,446);									
	    setLayout(null);
	    JLabel lblNewLabel = new JLabel("到达日期");
	    lblNewLabel.setBounds(852, 39, 78, 16);
		add(lblNewLabel);
		 lim =  logInMsg;
												
		CurrentTime currentTime = new CurrentTime();										
		date1 = new MJTextField();
		date1.setText(currentTime.getCurrentTimeDate());
		date1.setBounds(970, 32, 156, 30);
		
		add(date1);
												
		date1.setColumns(10);
												
		JLabel lblNewLabel_1 = new JLabel("中转中心编号");
		lblNewLabel_1.setBounds(852, 88, 106, 16);
		add(lblNewLabel_1);
												
												
		centrenum1= new MJTextField();
		centrenum1.setText(lim.getOrganization_id());
		centrenum1.setBounds(970, 81, 156, 30);
		add(centrenum1);										
	    centrenum1.setColumns(10);
												
	    confirm = new JButton("确认");
	    confirm.setBounds(1009, 237, 117, 30);
		add(confirm);	
		confirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<BarcodeAndState> bas = new ArrayList<BarcodeAndState>();
				BarcodeAndState mock = new BarcodeAndState("1234567890",GoodsState.COMPLETE);
				bas.add(mock);
		       if(trannum1.getText().isEmpty()||centrenum1.getText().isEmpty()||
		    		   date1.getText().isEmpty()||departure1.getText().isEmpty()){
		    		 JOptionPane.showConfirmDialog(null, "有咚咚漏天啦！","系统提示",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		       }else{
				ArrivalNoteOnTransitVO vo = new ArrivalNoteOnTransitVO(jigou+trannum1.getText(),centrenum1.getText(),date1.getText(),
						departure1.getText(),bas);
				//格式检查
			    res = service.inputCenterArrivalDoc(vo);
				//正确则信息填入那边
				if(res.isPass()){
					date2.setText(date1.getText());
					centrenum2.setText(centrenum1.getText());
					trannum2.setText(jigou+trannum1.getText());
					departure2.setText(departure1.getText());
				}
				else{
					int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			}
		       }
			}
		});
												
        JLabel label = new JLabel("条形码");
        label.setBounds(852, 297, 78, 16);
		add(label);
												
		
		barcode = new MJTextField();
		barcode.setBounds(970, 290, 156, 30);
		add(barcode);
		barcode.setColumns(10);
		
		JLabel departture = new JLabel("出发地");
		departture.setBounds(852, 133, 78, 16);
        add(departture);
															
        JLabel label_2 = new JLabel("中转单编号");
        label_2.setBounds(852, 178, 106, 16);
		add(label_2);
		
		JLabel label_1 = new JLabel("货运状态");
		label_1.setBounds(852, 345, 78, 16);
		add(label_1);
		String[] state = {"完好","缺损","丢失"};
		  statechoose = new JComboBox(state);
		statechoose.setBounds(970, 341, 156, 27);
		statechoose.setBackground(SystemColor.textHighlight);
		add(statechoose);
																
		departure1 = new MJTextField();
		departure1.setBounds(970, 126, 156, 30);
		add(departure1);
	    departure1.setColumns(10);													
																		
	    trannum1 = new MJTextField();
	    trannum1.setBounds(992, 195, 134, 30);
		add(trannum1);
		trannum1.setColumns(10);
			
			 ADD = new JButton("ADD");
			ADD.setBounds(1037, 390, 94, 30);
			add(ADD);
			
			JLabel arrivaldateLabel = new JLabel("到达日期");
			arrivaldateLabel.setBounds(44, 73, 61, 16);
			add(arrivaldateLabel);
			
			date2 = new JTextField();
			date2.setEditable(false);
			date2.setBounds(162, 67, 180, 28);
			add(date2);
			date2.setColumns(10);
			
			JLabel centerNum = new JLabel("中转中心编号");
			centerNum.setBounds(44, 151, 117, 16);
			add(centerNum);
			
			centrenum2 = new JTextField();
			centrenum2.setEditable(false);
			centrenum2.setBounds(162, 145, 180, 28);
			add(centrenum2);
			centrenum2.setColumns(10);
					
			name = new Vector();
			name.add("条形码");
			name.add("货运状态");
			data = new Vector();
			model = new DefaultTableModel();
			model.setDataVector(data,name);
			table = new JTable(model);
			table.setBounds(367, 72, 371, 272);
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(367, 72, 371, 272);
			add(scrollPane);
			
			  table.addMouseListener(new MouseAdapter() {
		        	public void mouseClicked(MouseEvent arg0) {
		        		 seletedRow = table.getSelectedRow();
		          		if(seletedRow != -1){
		          			barcode.setText(model.getValueAt(seletedRow,0).toString());
		          			statechoose.setSelectedItem(model.getValueAt(seletedRow, 1).toString());
		          			
		          		}
		        	}
		        });
			
			
			submit = new JButton("提交");
			submit.addActionListener(new submitListener());
			submit.setBounds(591, 391, 117, 29);
			add(submit);
			
			JLabel label_3 = new JLabel("出发地");
			label_3.setBounds(44, 228, 61, 16);
			add(label_3);
			
			departure2 = new JTextField();
			departure2.setEditable(false);
			departure2.setBounds(162, 222, 180, 28);
			add(departure2);
			departure2.setColumns(10);
			
			JLabel label_4 = new JLabel("中转单编号");
			label_4.setBounds(44, 297, 75, 16);
			add(label_4);
			
			trannum2 = new JTextField();
			trannum2.setEditable(false);
			trannum2.setBounds(162, 291, 180, 28);
			add(trannum2);
			trannum2.setColumns(10);
			
			delete = new JButton("DELETE");
			delete.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(seletedRow >= 0){
					model.removeRow(seletedRow);
					barcodeAndStates.remove(seletedRow);
					seletedRow = -1;
					System.out.println(seletedRow);
					for(int i = 0;i<barcodeAndStates.size();i++){
						System.out.println(barcodeAndStates.get(i).getBarcode()+" "+barcodeAndStates.get(i).getState().toString());
					}
					}else{
						JOptionPane.showConfirmDialog(null, "尼木有选择要删除的行哦！","系统提示",
								JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					}
				}
			});
			delete.setBounds(848, 390, 89, 30);
			add(delete);
			
			modify = new JButton("MODIFY");
			modify.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(seletedRow >= 0){
						barcodeAndStates.remove(seletedRow);
						model.removeRow(seletedRow);
						addBarcode();
						seletedRow = -1;
						System.out.println(seletedRow);
						for(int i = 0;i<barcodeAndStates.size();i++){
							System.out.println(barcodeAndStates.get(i).getBarcode()+" "+barcodeAndStates.get(i).getState().toString());
						}
					}else{
						JOptionPane.showConfirmDialog(null, "尼木有选择要修改的行哦！","系统提示",
								JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					}
				}
			});
			modify.setBounds(938, 390, 102, 30);
			add(modify);
			
			jigou = lim.getOrganization_id()+GetTime.getTime(date1.getText());
			JLabel lblNewLabel_2 = new JLabel(jigou);		
			lblNewLabel_2.setBounds(850, 206, 144, 16);
			add(lblNewLabel_2);
			
			
			ADD.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					addBarcode();
				}
			});	
																	
	}
	
	
	public void paintComponent(Graphics g) {
		 super.paintComponents(g);
		 ImageIcon img = new ImageIcon("image/0011.jpg");
		g.drawImage(img.getImage(), 0, 0, null);
		 float lineWidth = 3.0f;
	      ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
	      g.drawLine(768, 0, 768, 500);
	}
	
	public ArrivalNoteOnTransitVO getVO(){
		return arrivalNoteOnTransitVO;
	}
	
	public JButton getButton_1() {
		return button_1;
	}

	public  class submitListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			boolean isempty = date2.getText().isEmpty();
			if((!barcodeAndStates.isEmpty())&&!isempty){
				arrivalNoteOnTransitVO = new ArrivalNoteOnTransitVO(trannum2.getText(),centrenum2.getText(),date2.getText(),
						departure2.getText(), barcodeAndStates);
				arrivalNoteOnTransitVO.setUserName(lim.getUserName());
				arrivalNoteOnTransitVO.setOrganization(lim.getOrganization());
				UnEditablePanel.UnEdit(ArrivalNoteOnTransitPanel.this);//设置为不可编辑
				delete.setEnabled(false);
				ADD.setEnabled(false);
				confirm.setEnabled(false);
				modify.setEnabled(false);
				submit.setEnabled(false);
				parent.setdaodaB(true);;//显示等待审批字样	
				parent.setArrivalNoteOnTransitpanel(thisP);
				new Submitter().start();
		
	   }else{
		   int result1 = JOptionPane.showConfirmDialog(null, "有咚咚漏天啦！","系统提示",
					JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);
	   }
	
     }
   }
	
	public void setResult(ResultMsg s) {
		parent.setdaodaB(false);	
		parent.initDaoda(s.isPass());
		parent.leftdown.repaint();
		if(s.isPass()){
			//parent.setArrivalNoteOnTransitVO(null);;
			parent.setArrivalNoteOnTransitpanel(null);
		}else{
			int result1 = JOptionPane.showConfirmDialog(null, s.getMessage(),"系统提示",
					JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);
			date1.setEditable(true);
			date1.setEnabled(true);
			trannum1.setEditable(true);
			trannum1.setEnabled(true);
			centrenum1.setEditable(true);
			centrenum1.setEnabled(true);
			departure1.setEditable(true);
			departure1.setEnabled(true);
			barcode.setEditable(true);
			barcode.setEnabled(true);
			statechoose.setEditable(true);
			statechoose.setEnabled(true);
			delete.setEnabled(true);
			ADD.setEnabled(true);
			modify.setEnabled(true);
			confirm.setEnabled(true);
			submit.setEnabled(true);
		}
		
		}
	
	class Submitter extends Thread {
		@Override
		public void run() {
			super.run();
			setResult(service.submitCenterArrivalDoc(arrivalNoteOnTransitVO));
		}
	}
	
	
	public void addBarcode() {
		ArrayList<BarcodeAndState> bas = new ArrayList<BarcodeAndState>();
		if(!barcode.getText().isEmpty()){
		if(statechoose.getSelectedItem().equals("完好"))
		    brcodeAndState = new BarcodeAndState(barcode.getText(),GoodsState.COMPLETE);
		else if(statechoose.getSelectedItem().equals("缺损"))
			brcodeAndState = new BarcodeAndState(barcode.getText(),GoodsState.DAMAGED);
		else
			brcodeAndState = new BarcodeAndState(barcode.getText(),GoodsState.LOST);
		bas.add(brcodeAndState);
		
		
		ArrivalNoteOnTransitVO vo = new ArrivalNoteOnTransitVO("025000201510100000001","025000",date1.getText(),
				"北京",bas);
		
		if(Chachong.isRepeatState(barcodeAndStates, barcode.getText())){
			JOptionPane.showConfirmDialog(null, "该条形码已存在于表中","系统提示",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		}else{
		
		res = service.inputCenterArrivalDoc(vo);
		if(res.isPass()){
			Vector row = new Vector();
			row.add(barcode.getText());
			row.add(statechoose.getSelectedItem());
			data.add(row.clone());
			model.setDataVector(data, name);
			table.setModel(model);
			barcodeAndStates.add( brcodeAndState);	
			barcode.setText("");
				
		}else{
			int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		}
		}
		}else{
			JOptionPane.showConfirmDialog(null, "有咚咚木有填","系统提示",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		}
	}
}


	
	


