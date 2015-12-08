package presentation.logisticui;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;

import java.awt.Font;

import javax.swing.border.EtchedBorder;

import java.awt.Color;

import javax.swing.JButton;

import presentation.util.MJTextField;
import presentation.util.SubmitDialog;
import presentation.util.UnEditablePanel;
import presentation.util.checkstyleDialog;
import util.LogInMsg;
import util.ResultMsg;
import util.SendDocMsg;
import util.enums.DeliverCategory;
import util.enums.PackageType;
import vo.DeliveryNoteVO;
import businesslogic.logistic.DeliveryNoteInput;
import businesslogicservice.logisticblservice.DeliveryNoteInputBLService;
import businesslogicservice.logisticblservice._Stub.DeliveryNoteInputBLService_Stub;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.DecimalFormat;

public class MailOrderPanel extends JPanel {
	
	/**
	 * 窗口宽度
	 */
	private static final int WIDTH = 1152;
	
	/**
	 * 窗口高度
	 */
	private static final int HEIGHT = 446;
	private PackageType packagetype;
	private MJTextField receiveName;
	private MJTextField receiveAddress;
	private MJTextField receivePho;
	private MJTextField senderAddress;
	private MJTextField name;
	private MJTextField weight;
	private MJTextField goodsnum;
	private MJTextField volum;
	private MJTextField money;
	private MJTextField predate;
	private DeliveryNoteInputBLService service ;
	private MJTextField senderPho;
	private MJTextField barcode;
	private ResultMsg res;
	private ResultMsg sdm;
	private DeliverCategory deliverCategory;
    private  JComboBox category;
    private double packprice;
    private JComboBox pack;
    private SubmitDialog sd;
    private DeliveryNoteVO sendDocVO;
    private MJTextField senderName;
    private LogInMsg lim; 
    private CourierFrame parent;
	/**
	 * Create the panel.
	 */
	
	public void paintComponent(Graphics g) {
		 super.paintComponents(g);
		 ImageIcon img = new ImageIcon("image/0011.jpg");
		g.drawImage(img.getImage(), 0, 0, null);
		 float lineWidth = 3.0f;
	     ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
	      g.drawLine(768, 0, 768, 500);
		}
	
	public MailOrderPanel(LogInMsg logInMsg,CourierFrame courierFrame) {
        lim = logInMsg;
		setSize(WIDTH,HEIGHT);
		setLayout(null);
		 service = new DeliveryNoteInput();//实例化bl接口
		 parent = courierFrame;
		 sendDocVO = parent.getDeliveryNoteVo();
		
		JLabel label = new JLabel("收件人姓名");
		label.setBounds(70, 39, 84, 16);
		add(label);
		
		receiveName = new MJTextField();
		receiveName.setBounds(218, 33, 150, 28);
		add(receiveName);
		receiveName.setColumns(10);
		
		JLabel label_1 = new JLabel("收件地址");
		label_1.setBounds(70, 88, 61, 16);
		add(label_1);
		
		receiveAddress = new MJTextField();
		receiveAddress.setBounds(218, 82, 150, 28);
		add(receiveAddress);
		receiveAddress.setColumns(10);
		
		JLabel label_2 = new JLabel("收件人电话");
		label_2.setBounds(70, 138, 71, 16);
		add(label_2);
		
		receivePho = new MJTextField();
		receivePho.setBounds(218, 132, 150, 28);
		add(receivePho);
		receivePho.setColumns(10);
		
		JLabel label_3 = new JLabel("寄件人姓名");
		label_3.setBounds(70, 185, 97, 16);
		add(label_3);
		
		JLabel label_4 = new JLabel("件数");
		label_4.setBounds(70, 364, 61, 16);
		add(label_4);
		
		senderAddress = new MJTextField();
		senderAddress.setBounds(218, 223, 150, 28);
		add(senderAddress);
		senderAddress.setColumns(10);
		
		JLabel label_5 = new JLabel("货物名称");
		label_5.setBounds(70, 319, 61, 16);
		add(label_5);
		
		name = new MJTextField();
		name.setBounds(218, 313, 150, 28);
		add(name);
		name.setColumns(10);
		
		JLabel label_6 = new JLabel("重量");
		label_6.setBounds(462, 138, 61, 16);
		add(label_6);
		
		weight = new MJTextField();
		weight.setBounds(561, 138, 150, 28);
		add(weight);
		weight.setColumns(10);
		
		JLabel label_7 = new JLabel("以千克为计量单位");
		label_7.setBounds(571, 165, 112, 16);
		label_7.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		add(label_7);
		
		JLabel lblNewLabel = new JLabel("条形码");
		lblNewLabel.setBounds(462, 240, 61, 16);
		add(lblNewLabel);
		
		goodsnum = new MJTextField();
		goodsnum.setText("1");
		goodsnum.setBounds(218, 358, 150, 28);
		add(goodsnum);
		goodsnum.setColumns(10);
		
		JLabel label_8 = new JLabel("包装方式");
		label_8.setBounds(462, 39, 61, 16);
		add(label_8);
		
		String[] packway = {"快递袋","纸箱","木箱"};
		pack = new JComboBox(packway);
		pack.setBounds(561, 35, 150, 27);
		add(pack);
		
		
		JLabel lblNewLabel_1 = new JLabel("快递种类");
		lblNewLabel_1.setBounds(462, 88, 61, 16);
		add(lblNewLabel_1);
		
		String[] expressType = {"经济快递","标准快递","特快专递"};
		 category = new JComboBox(expressType);
		category.setBounds(561, 84, 150, 27);
		add(category);
		
		JLabel label_9 = new JLabel("体积");
		label_9.setBounds(462, 185, 61, 16);
		add(label_9);
		
		volum = new MJTextField();
		volum.setBounds(561, 185, 150, 28);
		add(volum);
		volum.setColumns(10);
		
		JLabel label_10 = new JLabel("以立方米为计量单位");
		label_10.setBounds(571, 210, 112, 16);
		label_10.setFont(new Font("Lucida Grande", Font.PLAIN, 10));
		add(label_10);
		
		
		JLabel label_11 = new JLabel("寄件价格：");
		label_11.setBounds(896, 39, 82, 16);
		add(label_11);
		
		money = new MJTextField();
		money.setBounds(977, 33, 134, 28);
		add(money);
		money.setBackground(Color.LIGHT_GRAY);
		money.setEditable(false);
		money.setEnabled(false);
		money.setColumns(10);
		
		JLabel label_13 = new JLabel("请输入完整的单据信息");
		label_13.setBounds(987, 67, 134, 16);
		add(label_13);
		
		JLabel label_12 = new JLabel("预计到达时间");
		label_12.setBounds(896, 138, 82, 16);
		add(label_12);
		
		predate = new MJTextField();
		predate.setBounds(977, 132, 134, 28);
		add(predate);
		predate.setBackground(Color.LIGHT_GRAY);
		predate.setEnabled(false);
		predate.setEditable(false);
		predate.setColumns(10);
		
		JLabel label_14 = new JLabel("请输入完整的单据信息");
		label_14.setBounds(987, 164, 134, 16);
		add(label_14);
		
		JLabel label_15 = new JLabel("寄件人地址");
		label_15.setBounds(70, 229, 84, 16);
		add(label_15);
		
		JLabel label_16 = new JLabel("寄件人电话");
		label_16.setBounds(70, 271, 84, 16);
		add(label_16);
		
		senderPho = new MJTextField();
		senderPho.setBounds(218, 267, 150, 28);
		add(senderPho);
		senderPho.setColumns(10);
		
		barcode = new MJTextField();
		barcode.setBounds(561, 234, 150, 28);
		add(barcode);
		barcode.setColumns(10);
		
		senderName = new MJTextField();
		senderName.setBounds(218, 179, 150, 28);
		add(senderName);
		senderName.setColumns(10);
		
		if(category.getSelectedItem().equals("经济快递"))
			deliverCategory = deliverCategory.ECNOMIC;
		else if(category.getSelectedItem().equals("标准快递"))
			deliverCategory = deliverCategory.NORMAL;
		else 
			deliverCategory = deliverCategory.EXPRESS;
		
		if(pack.getSelectedItem().equals("快递袋"))
			packagetype = packagetype.Bag;
		else if(pack.getSelectedItem().equals("纸箱"))
			packagetype = packagetype.PaperBox;
		else
			packagetype = packagetype.WoodenBox;
		
		
		
		
		JButton btnNewButton = new JButton("提交");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			            sendDocVO = new DeliveryNoteVO(senderName.getText(),senderAddress.getText(),
						senderPho.getText(),receiveName.getText(),receiveAddress.getText(),receivePho.getText(),
						name.getText(),Integer.parseInt(goodsnum.getText()),Double.parseDouble(weight.getText()),
						Double.parseDouble(volum.getText()),deliverCategory,packagetype,barcode.getText());
			            sendDocVO.setUserName(lim.getUserName());
			            sendDocVO.setOrganization(lim.getOrganization());
			            
				res = service.inputSendDoc(sendDocVO);//对单据进行格式检查
				if(res.isPass()){//格式检查通过
                    SendDocMsg sendDocMsg = (SendDocMsg) res;

                    DecimalFormat df=new DecimalFormat(".##");
                    String price = df.format(sendDocMsg.getPrice());//显示价格，保留两位，四舍五入
                    money.setText(price);
                    predate.setText(sendDocMsg.getPredectedDate());//显示预计到达日期
                    parent.setDeliveryNoteVo(sendDocVO);//将单据信息存到vo里
					int result1 = JOptionPane.showConfirmDialog(null, "确认提交审批？","系统提示",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);//询问是否确认提交

                    if(result1 == JOptionPane.YES_OPTION){
						
						UnEditablePanel.UnEdit(MailOrderPanel.this);


                        sdm = service.submitSendDoc(sendDocVO);
                        if(sdm.isPass()){//提交成功
						;//设置未不可编辑
						}else{
							//提交失败
							int result2 = JOptionPane.showConfirmDialog(null,sdm.getMessage() ,"系统提示",
									JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						}
					}
				}else{
	                //未通过格式检查
					int result1 = JOptionPane.showConfirmDialog(null,res.getMessage() ,"系统提示",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				}
				
				
				
			}
		});
		btnNewButton.setBounds(584, 355, 132, 59);
		add(btnNewButton);
		
	
		
		

	}
}
