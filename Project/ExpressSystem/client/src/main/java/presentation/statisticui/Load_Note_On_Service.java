/**
 * 营业厅装车单详细信息
 * 
 * @author wqy
 *
 */
package presentation.statisticui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import util.ResultMsg;
import vo.LoadNoteOnServiceVO;

public class Load_Note_On_Service extends JFrame {
	private JTextField data;
	private JTextField service;
	private JTextField to;
	private JTextField scar;
	private JTextField car;
	private JTextField superman;
	private JTextField senderman;
	private JTextField code;
	private ArrayList<String> barcodes=new  ArrayList<String> ();
	/**
	 * 窗口宽度
	 */
	private static final int WIDTH = 800;

	/**
	 * 窗口高度
	 */
	private static final int HEIGHT = 494;
	/**
	 * 右边标签
	 */
	private static final int WIDTHL = WIDTH/3*2+19;
	/**
	 * 右边field
	 */
	private static final int WIDTHT = WIDTHL+76;

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					changeLook();
					changeFont();
					Load_Note_On_Service frame = new Load_Note_On_Service();

					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	private static void changeLook() {
		try {
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencySmallShadow;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			// 关闭右上角设置
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch(Exception e) {
		}
	}
	/**
	 * 更改默认字体
	 */
	private static void changeFont() {
		Font font = new Font("微软雅黑", Font.PLAIN, 15);   
		@SuppressWarnings("rawtypes")
		java.util.Enumeration keys = UIManager.getDefaults().keys();   
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();   
			Object value = UIManager.get(key);    
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);     
			} 
		} 
	}
	public void toCenter(JFrame frame){
		int winWid=frame.getWidth();
		int winHei=frame.getHeight();
		Toolkit kit=Toolkit.getDefaultToolkit();
		Dimension screenSize=kit.getScreenSize();
		int screeW=screenSize.width;
		int screeH=screenSize.height;
		frame.setLocation(screeW/2-winWid/2,screeH/2-winHei/2);
	}
	/**
	 * Create the frame.
	 */
	public Load_Note_On_Service() {
		setResizable(false);
		JPanel ppp=(JPanel)this.getContentPane();
		ImageIcon img=new ImageIcon("image/0111.jpg");
		JLabel llll=new JLabel(img);
		llll.setBounds(0, 0, img.getIconWidth(), img.getIconHeight());

		ppp.setOpaque(false);
		this.getLayeredPane().add(llll,new Integer(Integer.MIN_VALUE));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setSize(WIDTH,HEIGHT);
		toCenter(this);
		setBackground(Color.WHITE);
		getContentPane().setLayout(null);

		init();
	}
	/**
	 * 营业厅装车单界面
	 * 
	 * @author wqy
	 *
	 */

	public void init(){

		/**
		 * Create the panel.
		 */


		JLabel label = new JLabel("日期");
		label.setBounds(58, 41, 54, 18);
		getContentPane().add(label);

		data = new JTextField();
		data.setEnabled(false);
		data.setEditable(false);
		data.setBounds(146, 40, 124, 21);
		getContentPane().add(data);
		data.setColumns(10);

		JLabel label_1 = new JLabel("营业厅编号");
		label_1.setBounds(324, 43, 84, 15);
		getContentPane().add(label_1);

		service = new JTextField();
		service.setEnabled(false);
		service.setEditable(false);
		service.setBounds(418, 40, 124, 21);
		getContentPane().add(service);
		service.setColumns(10);

		JLabel label_2 = new JLabel("目的地");
		label_2.setBounds(58, 96, 54, 15);
		getContentPane().add(label_2);

		to = new JTextField();
		to.setEnabled(false);
		to.setEditable(false);
		to.setBounds(146, 94, 286, 18);
		getContentPane().add(to);
		to.setColumns(10);

		JLabel label_3 = new JLabel("车辆编号");
		label_3.setBounds(58, 150, 78, 15);
		getContentPane().add(label_3);

		scar = new JTextField();
		scar.setEnabled(false);
		scar.setEditable(false);
		scar.setBounds(146, 147, 207, 21);
		getContentPane().add(scar);
		scar.setColumns(10);

		JLabel label_4 = new JLabel("汽运编号");
		label_4.setBounds(58, 206, 66, 15);
		getContentPane().add(label_4);

		car = new JTextField();
		car.setEnabled(false);
		car.setEditable(false);
		car.setBounds(146, 203, 207, 21);
		getContentPane().add(car);
		car.setColumns(10);

		JLabel label_5 = new JLabel("监装员");
		label_5.setBounds(58, 251, 66, 15);
		getContentPane().add(label_5);

		superman = new JTextField();
		superman.setEnabled(false);
		superman.setEditable(false);
		superman.setBounds(146, 248, 84, 21);
		getContentPane().add(superman);
		superman.setColumns(10);

		JLabel lblNewLabel = new JLabel("押运员");
		lblNewLabel.setBounds(58, 304, 54, 15);
		getContentPane().add(lblNewLabel);

		senderman = new JTextField();
		senderman.setEnabled(false);
		senderman.setEditable(false);
		senderman.setBounds(146, 301, 84, 21);
		getContentPane().add(senderman);
		senderman.setColumns(10);

		JLabel label_6 = new JLabel("货物编码");
		label_6.setBounds(396, 150, 93, 15);
		getContentPane().add(label_6);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(226, 188, 147, -51);
		getContentPane().add(scrollPane);

		JButton btnNewButton = new JButton("提交");
		btnNewButton.setBounds(418, 370, 93, 23);
		getContentPane().add(btnNewButton);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(376, 188, 224, 99);
		getContentPane().add(scrollPane_1);

		code = new JTextField();
		code.setEditable(false);
		code.setEnabled(false);
		scrollPane_1.setViewportView(code);
		code.setColumns(10);

		JLabel label_15 = new JLabel("装车单");
		label_15.setBounds(28, 10, 84, 15);
		getContentPane().add(label_15);

	}
	/*public class confirmListener implements ActionListener{

			LoadNoteOnServiceVO  vo=null;
			//初始化顺序问题
			Boolean isT;
			public void actionPerformed(ActionEvent arg0) {

				vo=new LoadNoteOnServiceVO (dataf.getText(),servicecodef.getText(),carcodef.getText(),tof.getText(),scarcodef.getText(),supermanf.getText(),sendmanf.getText(),barcodes);

				ResultMsg result=load.inputHallLoadDoc(vo);
				if(result.isPass()){//格式检查正确
				data.setText(dataf.getText());
				service.setText(servicecodef.getText());
				to.setText(tof.getText());
				scar.setText(scarcodef.getText());
				car.setText(carcodef.getText());
				superman.setText(supermanf.getText());
				senderman.setText(sendmanf.getText());
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
				s=s+codeF.getText()+"状态："+state.getSelectedItem().toString()+"\r\n";
				codeee.setText(s);
				codeF.setText("");
				BarcodeAndStates.add(bas);
			}


		}
		public class submitListener implements ActionListener{
			ArrivalNoteOnServiceVO  vo=null;


			public void actionPerformed(ActionEvent e) {
				vo=new ArrivalNoteOnServiceVO (dataF.getText(),true, codeF.getText(),fromF.getText(),  BarcodeAndStates);
				int result = JOptionPane.showConfirmDialog(null, "确认提交审批？","系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(result == JOptionPane.YES_OPTION) {
					arrive.submitHallArrivalDoc(vo);

				}
				else {
					return;

				}

			}
		}*/
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		ImageIcon img = new ImageIcon("image/0111.jpg");
		g.drawImage(img.getImage(), 0, 0, null);
		float lineWidth = 3.0f;
		((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
		g.drawLine(WIDTH/3*2, 0, WIDTH/3*2, HEIGHT);
	}
}


