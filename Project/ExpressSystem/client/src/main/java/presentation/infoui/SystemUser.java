/**
 * 管理系统用户主界面
 * 
 * @author wqy
 *
 */
package presentation.infoui;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import presentation.logisticui.CourierFrame;
import presentation.mainui.loginFrame;
import presentation.util.MJTextField;
import presentation.util.ShowMessageFrame;
import businesslogic.info.SystemUserManagement;
import businesslogicservice.infoblservice.SystemUserManagementBLService;
import businesslogicservice.infoblservice._stub.SystemUserManagementBLService_Stub;
import util.LogInMsg;
import util.ResultMsg;
import util.enums.Authority;
import vo.UserVO;

public class SystemUser extends JFrame {
	/**
	 * 窗口宽度
	 */
	private static final int WIDTH = 1280;

	/**
	 * 窗口高度
	 */
	private static final int HEIGHT = 720;
	/**
	 * MIDDLE宽度
	 */
	private static final int WIDTHM = 1152;

	/**
	 * MIDDLE高度
	 */
	private static final int HEIGHTM = 446;
	//SystemUserManagementBLService sum=new SystemUserManagementBLService_Stub();
	SystemUserManagementBLService sum=new SystemUserManagement();
	private JPanel contentPane;
	private MJTextField code;
	private MJTextField pass;
	private MJTextField textField_5;
	private MJTextField textField_6;
	private MJTextField textField_7;
	private JTable table;
	private DefaultTableModel model;
	private  JComboBox comboBox;
	private JComboBox chooseUp;
	private UserVO uservo;//修改的originvo
	private MJTextField key;
	private JComboBox findkey ;
	private LogInMsg lim;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SystemUser.changeLook();
					SystemUser.changeFont();
					SystemUser frame = new SystemUser(null);
					frame.setCaiDanLan();
					frame.setVisible(true);
					frame.setClose();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/
	/**
	 * 更改外观
	 */
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

	/**
	 * 设置关闭按钮
	 */
	private  void setClose() {
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				int result = JOptionPane.showConfirmDialog( SystemUser.this, "确认退出？","系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				if(result == JOptionPane.YES_OPTION) {
					dispose();
					loginFrame lf = new loginFrame();
					lf.setVisible(true);
				} else {
					setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				}
			}
		});
	}

	//设置菜单栏
	public void setCaiDanLan(){


		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 80, WIDTH, 34);
		getContentPane().add(menuBar);

		JMenu mns = new JMenu("系统(S)");
		menuBar.add(mns);

		JMenu mns_1 = new JMenu("功能(F)");
		menuBar.add(mns_1);



	}
	/**
	 * Create the frame.
	 */
	public SystemUser(LogInMsg lim) {
		this.lim=lim;
		JPanel pppp = (JPanel)this.getContentPane();
		// 加载背景图片 
		ImageIcon img = new ImageIcon("image/0111.jpg");
		JLabel llll=new JLabel(img);
		llll.setBounds(0,0,img.getIconWidth(),img.getIconHeight());
		pppp.setOpaque(false);//最上层透明
		this.getLayeredPane().add(llll,new Integer(Integer.MIN_VALUE));//第二层加图片







		this.setResizable(false);//不可调整大小
		setIconImage(Toolkit.getDefaultToolkit().getImage("image/henfu.png"));
		setTitle("快递物流系统");
		this.setSize(WIDTH, HEIGHT);
		((JComponent) this.getContentPane()).setOpaque(true);//不透明
		int screenWidth = Toolkit.getDefaultToolkit().getScreenSize().width;
		int screenHeight = Toolkit.getDefaultToolkit().getScreenSize().height;
		this.setLocation((screenWidth-WIDTH)>>1, (screenHeight-HEIGHT)>>1);
		//this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);




		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(5, 0, WIDTH, 78);
		panel.setBackground(Color.LIGHT_GRAY);






		JPanel QUANXIANW = new JPanel();
		QUANXIANW.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		QUANXIANW.setBounds(0, 570, 350, 124);



		contentPane.add(QUANXIANW);
		QUANXIANW.setLayout(null);

		JLabel user = new JLabel("用户：");
		user.setBounds(10, 2, 54, 15);
		QUANXIANW.add(user);

		JLabel username = new JLabel(lim.getUserName());
		//JLabel username = new JLabel();
		username.setBounds(56, 2, 54, 15);
		QUANXIANW.add(username);

		JLabel quanxian = new JLabel("权限：");
		quanxian.setBounds(10, 25, 54, 15);
		QUANXIANW.add(quanxian);

		JLabel auth = new JLabel(lim.getOrganization());
		//JLabel auth = new JLabel();
		auth.setBounds(56, 25, 129, 15);
		QUANXIANW.add(auth);

		JLabel label_1 = new JLabel("公告:");
		label_1.setBounds(10, 53, 54, 15);
		QUANXIANW.add(label_1);

		JLabel label_2 = new JLabel("快递系统上线试运行，请反馈使用体验");
		label_2.setBounds(56, 53, 284, 15);
		QUANXIANW.add(label_2);

		JPanel leftdown = new JPanel();
		leftdown.setBorder(new EtchedBorder(EtchedBorder.RAISED, null, null));
		leftdown.setBounds(341, 570, 939, 124);
		contentPane.add(leftdown);
		leftdown.setLayout(null);

		initComponent();
	}
	private void initComponent()    {  

		/* 
		 * 设置JTable的列名 
		 */  
		String[] columnNames =  
			{ "账号", "密码","权限"};  

		/* 
		 * 初始化JTable里面各项的值 
		 */  
		Object[][] obj = new Object[1][3];  

		JPanel middle = new JPanel(){
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon img = new ImageIcon("image/0111.jpg");
				g.drawImage(img.getImage(), 0, 0, null);
			}
		};
		middle.setBounds(0, 149, 1291, 424);
		contentPane.add(middle);
		middle.setLayout(null);
		model=new DefaultTableModel(obj,columnNames);
		table = new JTable(model);
		model.removeRow(0);
		initTabel(null);//初始化表格
		table.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				int selectedRow= table.getSelectedRow();

				Object ob=model.getValueAt(selectedRow, 0);
				code.setText(ob.toString());
				Object od=model.getValueAt(selectedRow, 1);
				pass.setText(od.toString());
				String oc=model.getValueAt(selectedRow, 2).toString();
				//
				if(oc.equals("总经理")){
					comboBox.setSelectedIndex(0);
				}
				else if(oc.equals("财务人员")){
					comboBox.setSelectedIndex(1);
				}
				else if(oc.equals("高级财务人员")){
					comboBox.setSelectedIndex(2);
				}
				else if(oc.equals("库存管理人员")){
					comboBox.setSelectedIndex(3);
				}
				else if(oc.equals("中转中心业务员")){
					comboBox.setSelectedIndex(4);
				}
				else if(oc.equals("营业厅业务员")){
					comboBox.setSelectedIndex(5);
				}
				else if(oc.equals("快递员")){
					comboBox.setSelectedIndex(6);
				}
				else if(oc.equals("系统管理员")){
					comboBox.setSelectedIndex(7);
				}
				//创originvo
				uservo=new UserVO(code.getText(),pass.getText(),Authority.getAuthObject(comboBox.getSelectedIndex()+1));
			}
		});  
		int colunms = table.getColumnCount();  
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
		JScrollPane scroll = new JScrollPane(table);
		scroll.setBounds(20, 35, 690, 366);
		middle.add(scroll);

		/* 
		 * JTable的其中一种构造方法 
		 */  
		/* 
		 * 设置JTable的列默认的宽度和高度 
		 */  
		TableColumn column = null;  
		for(int i = 0; i < colunms; i++)  
		{  
			column = table.getColumnModel().getColumn(i);  
			/*将每一列的默认宽度设置为100*/  
			column.setPreferredWidth(300);  
		}  
		/* 
		 * 设置JTable自动调整列表的状态，此处设置为关闭 
		 */  

		/*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/  

		comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"总经理", "财务人员", "高级财务人员", "库存管理人员", "中转中心业务员", "营业厅业务员","快递员", "系统管理员"}));
		comboBox.setBounds(842, 173, 188, 21);
		middle.add(comboBox);
		
		
		chooseUp = new JComboBox();
		chooseUp.setModel(new DefaultComboBoxModel(new String[] {"总经理", "财务人员", "高级财务人员", "库存管理人员", "中转中心业务员", "营业厅业务员","快递员", "系统管理员"}));
		chooseUp.setBounds(359, 5, 184, 28);
		chooseUp.setVisible(false);
		middle.add(chooseUp);

		JButton button_2 = new JButton("新增");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Authority au=Authority.getAuthObject(comboBox.getSelectedIndex()+1);
				UserVO vo=new UserVO(code.getText(),pass.getText(),au);
				ResultMsg result=sum.add(vo);
				if(result.isPass()){
					String[] rowValues={code.getText(),pass.getText(),comboBox.getSelectedItem().toString()
					};
					model.addRow(rowValues);
					setTishi(0);
				}
				else{
					int result1 = JOptionPane.showConfirmDialog(null, result.getMessage(),"系统提示",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				}
			}
		});
		button_2.setBounds(766, 260, 99, 30);
		middle.add(button_2);

		JLabel label_6 = new JLabel("密码");
		label_6.setBounds(766, 116, 66, 15);
		middle.add(label_6);

		JLabel label_5 = new JLabel("权限");
		label_5.setBounds(766, 176, 66, 15);
		middle.add(label_5);

		JLabel label_4 = new JLabel("账号");
		label_4.setBounds(766, 67, 99, 15);
		middle.add(label_4);

		JButton button_3 = new JButton("删除");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int seletedRow=table.getSelectedRow();
				if(seletedRow!=-1){
					Authority au=Authority.getAuthObject(comboBox.getSelectedIndex()+1);
					UserVO vo=new UserVO(code.getText(),pass.getText(),au);
					ResultMsg result=sum.delete(vo);
					if(result.isPass()){
						int result11 = JOptionPane.showConfirmDialog(null, "确认删除？","系统提示",
								JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						if(result11 == JOptionPane.YES_OPTION) {
						model.removeRow(seletedRow);
						setTishi(2);
						}
					}
					else{
						int result1 = JOptionPane.showConfirmDialog(null, result.getMessage(),"系统提示",
								JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);


					}
				}
				else{
					//未选中提示要选中才能编辑哦；

					JOptionPane.showMessageDialog(null, "要选中表格中的一行才可以删除哦~", "友情提示",JOptionPane.WARNING_MESSAGE);  
				}
			}
		});
		button_3.setBounds(875, 260, 99, 30);
		middle.add(button_3);

		code = new MJTextField();
		code.setBounds(841, 61, 189, 28);
		middle.add(code);
		code.setColumns(10);

		pass = new MJTextField();
		pass.setBounds(841, 110, 189, 28);
		middle.add(pass);
		pass.setColumns(10);

		JButton button_4 = new JButton("修改");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedRow =table.getSelectedRow();
				if(selectedRow!=-1){
					Authority au=Authority.getAuthObject(comboBox.getSelectedIndex()+1);
					UserVO vo=new UserVO(code.getText(),pass.getText(),au);
					ResultMsg result=sum.modify(uservo, vo);
					if(result.isPass()){

						model.setValueAt(code.getText(),selectedRow, 0);
						model.setValueAt(pass.getText(),selectedRow, 1);
						model.setValueAt(comboBox.getSelectedItem().toString(),selectedRow, 2);
					setTishi(1);
					}
					else{
						int result1 = JOptionPane.showConfirmDialog(null, result.getMessage(),"系统提示",
								JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);


					}


				}
				else{
					//未选中提示要选中才能编辑哦；

					JOptionPane.showMessageDialog(null, "要选中表格中的一行才可以修改哦~", "友情提示",JOptionPane.WARNING_MESSAGE);  
				}
			}
		});
		button_4.setBounds(1013, 260, 99, 30);
		middle.add(button_4);

		JLabel lblNewLabel_1 = new JLabel("管理系统用户");
		lblNewLabel_1.setBounds(20, 6, 164, 28);
		middle.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("关键字类型");
		lblNewLabel_2.setBounds(141, 13, 99, 15);
		middle.add(lblNewLabel_2);

		findkey = new JComboBox();
		findkey.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			if(findkey.getSelectedIndex()==1){//权限
				key.setVisible(false);
				chooseUp.setVisible(true);
			}
			else{
				
				chooseUp.setVisible(false);
				key.setVisible(true);
			}
			}
		});
		findkey.setModel(new DefaultComboBoxModel(new String[] {"账号", "权限"}));
		findkey.setBounds(235, 10, 99, 21);
		middle.add(findkey);

		key = new MJTextField();
		key.setText("请输入关键字");
		key.setColumns(10);
		key.setBounds(359, 5, 117, 28);
		middle.add(key);

		JButton button = new JButton("查询");
		button.addActionListener(new findListener());
		button.setBounds(553, 8, 63, 23);
		middle.add(button);

		JButton button_1 = new JButton("刷新");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			initTabel(null);
			}
		});
		button_1.setBounds(626, 8, 84, 23);
		middle.add(button_1);
		
		JLabel lblNewLabel_3 = new JLabel("帐号不能修改哦~");
		lblNewLabel_3.setBounds(1013, 315, 137, 28);
		middle.add(lblNewLabel_3);


		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("image/henfu.png"));
		lblNewLabel.setBounds(0, -25, 1291, 105);
		contentPane.add(lblNewLabel);


		setCaiDanLan();
	} 
	public void setTishi(int i){
		//0新增成功
		if(i==0){
		new ShowMessageFrame("新增成功");
		}
		//1修改成功
		else if(i==1){
			new ShowMessageFrame("修改成功");
			}
		//2删除成功
		else{
			new ShowMessageFrame("删除成功");
			}
	}
	public void cleanTable(){
		//显示到tabel里,先清空
		int count=model.getRowCount();
		//这边modelremove后会变小，应该从后往前删
				for(int i=count-1;i>=0;i--){
					model.removeRow(i);
				}
	}
	public void initTabel(UserVO uuu){
		cleanTable();
		ArrayList<UserVO> vvoo=sum.find(uuu);//得到所有信息
		int size=vvoo.size();
		if(size==0){
			JOptionPane.showMessageDialog(null, "没有找到相关用户");
		}
		else{
		for(int i=0;i<vvoo.size();i++){
			UserVO vo=vvoo.get(i);
			String userNum=vo.getUserNum();
			String initialPassword=vo.getInitialPassword();
			Authority authority=vo.getAuthority();
			String s="";
			if(authority==Authority.MANAGER){
				s="总经理";
			}
			else if(authority==Authority.ACCOUNTANT_HIGH){
				s="高级财务人员";
			}
			else if(authority==Authority.ACCOUNTANT){
				s="财务人员";
			}
			else if(authority==Authority.WAREHOUSE_MANAGER){
				s="库存管理人员";
			}
			else if(authority==Authority.DELIVERY_MAN){
				s="快递员";
			}
			else if(authority==Authority.SYSTEM_MANAGER){
				s="系统管理员";
			}
			else if(authority==Authority.TRANSIT_CENTER_PERSONNEL){
				s="中转中心业务员";
			}
			else{
				s="营业厅业务员";
			}
			Object[] oo={userNum,initialPassword,s};
			model.addRow(oo);
		}
		}
	}
	public class findListener implements ActionListener{
UserVO vvvv=null;
		public void actionPerformed(ActionEvent arg0) {
			Authority aau=null;
			String ssss=chooseUp.getSelectedItem().toString();
			if(findkey.getSelectedIndex()==0){//账号
				vvvv=new UserVO(key.getText(),null,null);
			}
			else{//权限
				if(ssss.equals("总经理")){
					aau=Authority.MANAGER;
				}
				else if(ssss.equals("高级财务人员")){
					aau=Authority.ACCOUNTANT_HIGH;
				}
				else if(ssss.equals("财务人员")){
					aau=Authority.ACCOUNTANT;
				}
				else if(ssss.equals("库存管理人员")){
					aau=Authority.WAREHOUSE_MANAGER;
				}
				else if(ssss.equals("中转中心业务员")){
					aau=Authority.TRANSIT_CENTER_PERSONNEL;
				}
				else if(ssss.equals("快递员")){
					aau=Authority.DELIVERY_MAN;
				}
				else if(ssss.equals("系统管理员")){
					aau=Authority.SYSTEM_MANAGER;
				}
				else{
					aau=Authority.SERVICE_HALL_PERSONNEL;
				}
				vvvv=new UserVO (null,null,aau);
			}
		initTabel(vvvv);
		
		}
		
	}
}
