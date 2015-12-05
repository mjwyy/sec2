package presentation.logisticui;
import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
/**
 * 快递员登记收件单
 */
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import presentation.util.SubmitDialog;
import presentation.util.checkstyleDialog;
import util.LogInMsg;
import util.ResultMsg;
import vo.ReceivingNoteVO;
import businesslogic.logistic.ReceivingNoteInput;
import businesslogicservice.logisticblservice.ReceivingNoteInputBLService;
import businesslogicservice.logisticblservice._Stub.ReceivingNoteInputBLService_Stub;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReceiveOrderPanel extends JPanel {
	
	/**
	 * 窗口宽度
	 */
	private static final int WIDTH = 1152;
	
	/**
	 * 窗口高度
	 */
	private static final int HEIGHT = 446;
	private ReceivingNoteInputBLService service = new ReceivingNoteInput();
	private ResultMsg res;
	private JTextField date;
	private JTextField barcode;
	private JTextField receiver;
	private ReceivingNoteVO vo;
	private SubmitDialog sd;
    private LogInMsg lim = null;

	public void paintComponent(Graphics g) {
		 super.paintComponents(g);
		 ImageIcon img = new ImageIcon("image/0011.jpg");
		}
	/**
	 * Create the panel.
	 */
	public ReceiveOrderPanel(LogInMsg logInMsg) {
        lim = logInMsg;
		setSize(WIDTH,HEIGHT);
		setLayout(null);
		
		JLabel label = new JLabel("收件日期");
		label.setBounds(165, 62, 61, 16);
		add(label);
		
		date = new JTextField();
		date.setBounds(264, 56, 134, 28);
		add(date);
		date.setColumns(10);
		
		JLabel label_1 = new JLabel("条形码");
		label_1.setBounds(165, 122, 61, 16);
		add(label_1);
		
		barcode = new JTextField();
		barcode.setBounds(264, 116, 134, 28);
		add(barcode);
		barcode.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("收件人姓名");
		lblNewLabel.setBounds(165, 186, 73, 16);
		add(lblNewLabel);
		
		receiver = new JTextField();
		receiver.setBounds(264, 180, 134, 28);
		add(receiver);
		receiver.setColumns(10);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 vo = new ReceivingNoteVO(barcode.getText(),receiver.getText(),date.getText());
				res = service.inputReceiveDoc(vo);
				if(res.isPass()){
					 sd = new SubmitDialog();
					 sd.setVisible(true);
					sd.getOK().addActionListener(new  ActionListener(){

						@Override
						public void actionPerformed(ActionEvent e) {
							vo.setUserName(lim.getUserName());
							sd.setVisible(false);
                            ResultMsg resultMsg = service.submitSendDoc(vo);
                          //  String msg = resultMsg.getMessage();
                            checkstyleDialog checkstyle = new checkstyleDialog(resultMsg.getMessage());
                            checkstyle.setVisible(true);
						}
						
					});
					
				}
				else{
					checkstyleDialog checkstyle = new checkstyleDialog(res.getMessage());
					checkstyle.setVisible(true);
				}
			}
		});
		btnNewButton.setBounds(348, 314, 117, 48);
		add(btnNewButton);

	}
}
