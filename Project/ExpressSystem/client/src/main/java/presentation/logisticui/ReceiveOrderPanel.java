package presentation.logisticui;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 * 快递员登记收件单
 */
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.border.EtchedBorder;

import presentation.util.CurrentTime;
import presentation.util.LeftDownPanel;
import presentation.util.MJTextField;
import presentation.util.SubmitDialog;
import presentation.util.UnEditablePanel;
import presentation.util.checkstyleDialog;
import util.LogInMsg;
import util.ResultMsg;
import vo.ReceivingNoteVO;
import businesslogic.logistic.ReceivingNoteInput;
import businesslogicservice.logisticblservice.ReceivingNoteInputBLService;
import businesslogicservice.logisticblservice._Stub.ReceivingNoteInputBLService_Stub;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class ReceiveOrderPanel extends JPanel {
	ReceiveOrderPanel thisP=this;
	/**
	 * 窗口宽度
	 */
	private static final int WIDTH = 1152;
	
	/**
	 * 窗口高度
	 */
	private static final int HEIGHT = 446;
	private ReceivingNoteInputBLService service;
	private ResultMsg res;
	private MJTextField date;
	private MJTextField barcode;
	private MJTextField receiver;
	private ReceivingNoteVO vo;
	private SubmitDialog sd;
    private LogInMsg lim = null;
    private CourierFrame parent;

	public void paintComponent(Graphics g) {
		 super.paintComponents(g);
		 ImageIcon img = new ImageIcon("image/0011.jpg");
		}
	/**
	 * Create the panel.
	 */
	public ReceiveOrderPanel(LogInMsg logInMsg,CourierFrame courierFrame) {
		parent = courierFrame;
		vo = parent.getReceivingNoteVo();
        lim = logInMsg;
		setSize(WIDTH,HEIGHT);
		setLayout(null);
		service = new ReceivingNoteInput();
		//service = new ReceivingNoteInputBLService_Stub();
		
		JLabel label = new JLabel("收件日期");
		label.setBounds(131, 62, 82, 16);
		add(label);
		
		CurrentTime currentTime = new CurrentTime();
		date = new MJTextField();
		date.setBounds(264, 56, 201, 28);
		date.setText(currentTime.getCurrentTimeMinute());//精确到秒
		add(date);
		date.setColumns(10);
		
		JLabel label_1 = new JLabel("条形码");
		label_1.setBounds(131, 122, 82, 16);
		add(label_1);
		
		barcode = new MJTextField();
		barcode.setBounds(264, 116, 201, 28);
		add(barcode);
		barcode.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("收件人姓名");
		lblNewLabel.setBounds(131, 186, 121, 16);
		add(lblNewLabel);
		
		receiver = new MJTextField();
		receiver.setBounds(264, 180, 201, 28);
		add(receiver);
		receiver.setColumns(10);
			
		//如果从frame里得到的vo不是null，而且是审批未通过,panel可以编辑
		/*if(vo != null){
			barcode.setText(vo.getBarcode());
	        receiver.setText(vo.getReceiveCustomer());
	        date.setText(vo.getTime()); 
	        UnEditablePanel.UnEdit(thisP);
		}*/
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 vo = new ReceivingNoteVO(barcode.getText(),receiver.getText(),date.getText());
				vo.setUserName(lim.getUserName());
				vo.setOrganization(lim.getOrganization());
				res = service.inputReceiveDoc(vo);
				if(res.isPass()){						
						int result1 = JOptionPane.showConfirmDialog(null, "确认提交审批？","系统提示",
								JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						if(result1 == JOptionPane.YES_OPTION) {	
						UnEditablePanel.UnEdit(thisP);
						parent.setReceiveOrderpanel(thisP);
						parent.setShoujian(true, false, false);
						new Submitter().start();
						
						}
					
				}
				else{
					int result1 = JOptionPane.showConfirmDialog(null,res.getMessage() ,"系统提示",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				}
			}
		});
		btnNewButton.setBounds(348, 314, 117, 48);
		add(btnNewButton);	
	}
	
public void setResult(ResultMsg s) {
	parent.setShoujian(false, s.isPass(), !s.isPass());
	parent.leftpanel.repaint();
	if(s.isPass()){
		parent.setReceiveOrderpanel(null);
	}else{
		barcode.setEditable(true);
		barcode.setEnabled(true);
		receiver.setEditable(true);
		receiver.setEnabled(true);
		date.setEditable(true);
		date.setEnabled(true);
		int result1 = JOptionPane.showConfirmDialog(null,s.getMessage() ,"系统提示",
				JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);
	}
		
	}
	
	class Submitter extends Thread {
		@Override
		public void run() {
			super.run();
			setResult(service.submitReceiveDoc(vo));
		}
	}
	
}
