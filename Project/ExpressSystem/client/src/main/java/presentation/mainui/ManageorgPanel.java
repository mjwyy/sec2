package presentation.mainui;

import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import presentation.statisticui.ManageStaffPanel;
import presentation.statisticui.StaffInfoPanel;
import util.ResultMsg;
import util.enums.OrganizationType;
import vo.OrganizationInfoVO;
import vo.StaffVO;
import businesslogic.info.StaffOrganizationManagement;
import businesslogicservice.infoblservice.StaffOrganizationManagementBLService;
import businesslogicservice.infoblservice._stub.StaffOrganizationManagementBLService_Stub;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ManageorgPanel extends JPanel {
	private JTextField keyword;
	private JTextField orgnum;
	private JTextField orgname;
	private JTable table;
	private DefaultTableModel model;
	private Vector name;
	private Vector data;
	private JComboBox keywordType;
	private JComboBox orgtype;
	private OrganizationInfoVO vo;
	private StaffOrganizationManagementBLService service = new StaffOrganizationManagement();
	private OrganizationType organizationType;
	private ArrayList<StaffVO> staffinfo = new  ArrayList<StaffVO>();
	private int seletedRow;
	private ManageStaffPanel msp ;
	private JFrame f;
	private ArrayList<OrganizationInfoVO> orgvo = new ArrayList<OrganizationInfoVO>();
	private ResultMsg res;
	private JButton btnNewButton_5;


	/**
	 * Create the panel.
	 */
	public ManageorgPanel() {
		setSize(1152,446);
		setLayout(null);
		
		name = new Vector();
		name.add("机构编号");
		name.add("机构类型");
		name.add("机构名称");
		data = new Vector();
		model = new DefaultTableModel();
		model.setDataVector(data,name);
		table = new JTable(model);
		table.setBounds(38, 72, 612, 348);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(38, 72, 612, 303);
		add(scrollPane);
		showall();
		
		table.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent arg0) {
        		 seletedRow = table.getSelectedRow();
          		if(seletedRow != -1){
          		orgnum.setText(model.getValueAt(seletedRow, 0).toString());
          		orgtype.setSelectedItem(model.getValueAt(seletedRow, 1).toString());
          		orgname.setText(model.getValueAt(seletedRow, 1).toString());
          		OrganizationInfoVO vos = new OrganizationInfoVO(model.getValueAt(seletedRow, 0).toString(),null,null,null);
          		orgvo = service.findOrgInfo(vos);
          		for(int i = 0;i<orgvo.size();i++){
          			staffinfo = orgvo.get(i).getStaffinfo();
          		}
          		
          		JButton button = new JButton("查看所选机构人员信息");
        		button.addActionListener(new ActionListener() {
        			public void actionPerformed(ActionEvent e) {
        				f = new JFrame();
        				f.setBounds(140, 125, 721, 345);
        				StaffInfoPanel sip = new StaffInfoPanel();
        				sip.setStaffList(staffinfo);
        				sip.showall();
        				sip.setVisible(true);
        				f.add(sip);
        				f.setVisible(false);
        				
        			}
        		});
        		button.setBounds(488, 387, 162, 38);
        		add(button);
          		}
          		
        	}
        });
		
		JLabel label = new JLabel("关键字类型");
		label.setBounds(38, 41, 91, 16);
		add(label);
		
		String[] keywordlist = {"机构编码","机构类型","机构名"};
		keywordType = new JComboBox(keywordlist);
		keywordType.setBounds(117, 37, 142, 20);
		add(keywordType);
		
		keyword = new JTextField();
		keyword.setBounds(260, 35, 216, 28);
		add(keyword);
		keyword.setColumns(10);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//zhe li bu dui 
				if(keywordType.getSelectedItem().toString().equals("机构编码")){	
					vo = new OrganizationInfoVO(keywordType.getSelectedItem().toString(),null,null,null);
				}
				else if(keywordType.getSelectedItem().toString().equals("机构类型")){	
					vo = new OrganizationInfoVO(null,whichType(keywordType.getSelectedItem().toString()),null,null);
				}
				else{
					vo = new OrganizationInfoVO(null,null,keywordType.getSelectedItem().toString(),null);
				}
				ArrayList<OrganizationInfoVO> orglist = new ArrayList<OrganizationInfoVO>();
				
				orglist = service.findOrgInfo(vo);
				if(!orglist.isEmpty()){
					for(int i = 0;i<orglist.size();i++){
						Vector row = new Vector();
						row.add(orglist.get(i).getOrganizationNum());
						row.add(thisType(orglist.get(i).getType()));
						row.add(orglist.get(i).getName());
						 data.add(row.clone());
					}
					 model.setDataVector(data, name);
				   	 table.setModel(model);
				}
				else{
					Vector row = new Vector();
					row.add("为查询到相关机构信息，请检查关键字输入是否正确");
					data.add(row.clone());
					model.setDataVector(data, name);
				   	table.setModel(model);
				}
				
			}
		});
		btnNewButton.setBounds(488, 31, 73, 38);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("显示所有");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showall();
			}
		});
		btnNewButton_1.setBounds(577, 31, 73, 38);
		add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("机构编号");
		lblNewLabel.setBounds(772, 54, 61, 16);
		add(lblNewLabel);
		
		orgnum = new JTextField();
		orgnum.setBounds(840, 48, 287, 28);
		add(orgnum);
		orgnum.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("机构类型");
		lblNewLabel_1.setBounds(772, 111, 61, 16);
		add(lblNewLabel_1);
		
		String[] orgTypeList = {"营业厅","中转中心","仓库","总部"};
		orgtype = new JComboBox(orgTypeList);
		orgtype.setBounds(840, 107, 287, 20);
		add(orgtype);
		
		JLabel label_1 = new JLabel("机构名称");
		label_1.setBounds(772, 171, 61, 16);
		add(label_1);
		
		orgname = new JTextField();
		orgname.setBounds(840, 165, 287, 28);
		add(orgname);
		orgname.setColumns(10);
		
		JLabel label_2 = new JLabel("请点击编辑此机构人员信息，进行人员信息的新增和修改");
		label_2.setBounds(772, 215, 302, 16);
		add(label_2);
		
		JButton btnNewButton_2 = new JButton("ADD");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				staffinfo.clear();
				if(btnNewButton_5 != null){
					remove(btnNewButton_5);
				}
				vo = new OrganizationInfoVO(orgnum.getText(),whichType(keywordType.getSelectedItem().toString()),
						orgname.getText(),staffinfo);
				res  = service.addOrganization(vo);
				if(res.isPass()){
					Vector row = new Vector();
					row.add(orgnum.getText());
					row.add(keywordType.getSelectedItem().toString());
					row.add(orgname.getText());
					data.add(row.clone());
					// model.setDataVector(data, name);
				   // table.setModel(model);
				   add();
				}else{
					int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				}
			
			}
		});
		btnNewButton_2.setBounds(772, 254, 75, 49);
		add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("MODIFY");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(btnNewButton_5 != null){
					remove(btnNewButton_5);
				}
				for(int i = 0;i<staffinfo.size();i++){
					staffinfo.get(i).setOrganization(orgname.getText());
				}
				modify();
			}
		});
		btnNewButton_3.setBounds(881, 254, 77, 49);
		add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("DELETE");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OrganizationInfoVO vos = new OrganizationInfoVO(model.getValueAt(seletedRow, 0).toString(),null,null,null);
				for(int i = 0;i< service.findOrgInfo(vos).size();i++){
					res  = service.delOrganization(service.findOrgInfo(vos).get(i));
					if(res.isPass()){
						if(!res.isPass()){
							int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
									JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						}else{
							int result1 = JOptionPane.showConfirmDialog(null, "机构人员信息删除成功","系统提示",
									JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						}
					}
				}
			}
		});
		btnNewButton_4.setBounds(981, 254, 77, 49);
		add(btnNewButton_4);

	}
	
	public OrganizationType whichType(String str) {
		if(str.equals("营业厅"))
			return organizationType = organizationType.SERVICE_HALL;
		else if(str.equals("中转中心"))
			return organizationType = organizationType.TRANSIT_CENTER;
		else if(str.equals("仓库"))
			return organizationType = organizationType.STORE_HOUSE;
		else 
			return organizationType = organizationType.HEADQUARTERS;
	}
	
	public String thisType(OrganizationType orgType) {
		if(orgType == orgType.SERVICE_HALL)
			return "营业厅";
		else if(orgType == orgType.TRANSIT_CENTER)
		return "中转中心";
		else if(orgType == orgType.STORE_HOUSE)
			return "仓库";
		else
			return "总部 ";
	}
	
	public void showall(){
		ArrayList<OrganizationInfoVO> volist = new ArrayList<OrganizationInfoVO>();
		volist = service.showAll();
		if(!volist.isEmpty()){
			for(int i = 0;i<volist.size();i++){
				Vector row = new Vector();
				row.add(volist.get(i).getOrganizationNum());
				row.add(thisType(volist.get(i).getType()));
				row.add(volist.get(i).getName());
				 data.add(row.clone());
			}
			 model.setDataVector(data, name);
		   	 table.setModel(model);
		}
		else{
			Vector row = new Vector();
			row.add("无任何机构信息");
			data.add(row.clone());
			model.setDataVector(data, name);
		   	table.setModel(model);
		}
	}
	
	public void modify(){
		 btnNewButton_5 = new JButton("编辑此人员信息");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f = new JFrame();
				f.setBounds(140, 125,1152, 446);
				msp = new ManageStaffPanel();
				msp.setStaffList(staffinfo);
				msp.showall();
				msp.setBounds(0, 0, 1152, 446);
				f.getContentPane().add(msp);
				f.setVisible(true);
				msp.setVisible(true);
				
				msp.getButton().addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						staffinfo = msp.getStaffList();	
						vo = new OrganizationInfoVO(orgnum.getText(),whichType(keywordType.getSelectedItem().toString()),
								orgname.getText(),staffinfo);
						res = service.ModifyOrganization(vo);
						if(!res.isPass()){
							int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
									JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						}else{
							int result1 = JOptionPane.showConfirmDialog(null, "机构人员信息成功更新","系统提示",
									JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						}
					}
					
				});
			}
		});
		btnNewButton_5.setBounds(782, 315, 279, 49);
		add(btnNewButton_5);
		repaint();
	}
	
	public void add(){
		btnNewButton_5 = new JButton("编辑此人员信息");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				f = new JFrame();
				f.setBounds(140, 125,1152, 446);
				msp = new ManageStaffPanel();
				msp.setStaffList(staffinfo);
				msp.showall();
				msp.setBounds(0, 0, 1152, 446);
				f.getContentPane().add(msp);
				f.setVisible(true);
				msp.setVisible(true);
				
				msp.getButton().addActionListener(new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent e) {
						staffinfo = msp.getStaffList();	
						vo = new OrganizationInfoVO(orgnum.getText(),whichType(keywordType.getSelectedItem().toString()),
								orgname.getText(),staffinfo);
						res = service.addOrganization(vo);
						if(!res.isPass()){
							int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
									JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

						}else{
							int result1 = JOptionPane.showConfirmDialog(null, "机构人员信息成功增加","系统提示",
									JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						}
					}
					
				});
			}
		});
		btnNewButton_5.setBounds(782, 315, 279, 49);
		add(btnNewButton_5);
		repaint();
	}
	
	
}
