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
import presentation.util.MJTextField;
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
	private MJTextField keyword;
	private MJTextField orgnum;
	private MJTextField orgname;
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
	private int seletedRow  = -1;
	private ManageStaffPanel msp ;
	private JFrame f;
	private ArrayList<OrganizationInfoVO> orgvo = new ArrayList<OrganizationInfoVO>();
	private ResultMsg res;
	private JButton btnNewButton_5;
	private JComboBox jigouleixing;


	/**
	 * Create the panel.
	 */
	public ManageorgPanel() {
		setSize(1152,446);
		setLayout(null);
		renyuan();
		
		//表格显示内容
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
		showall();//初始化时显示所有机构信息
		
		//选中table某一行。这一行的信息显示在编辑狂中，可查看人员信息
		table.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent arg0) {
        		 seletedRow = table.getSelectedRow();
          		if(seletedRow != -1){
          		orgnum.setText(model.getValueAt(seletedRow, 0).toString());
          		orgtype.setSelectedItem(model.getValueAt(seletedRow, 1).toString());
          		orgname.setText(model.getValueAt(seletedRow, 2).toString());
          		OrganizationInfoVO vos = new OrganizationInfoVO(null,null,model.getValueAt(seletedRow, 2).toString(),null);
          		orgvo = service.findOrgInfo(vos);
          		if(orgvo.isEmpty()){
          			JOptionPane.showConfirmDialog(null, "数据库中未查询到该机股信息，异常，请联系系统管理员","系统提示",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
          		}else {
          	       if(orgvo.get(0).getStaffinfo() != null)
          			staffinfo = orgvo.get(0).getStaffinfo();
          		
          		}
          		}
          		
        	}
        });
		
		JLabel label = new JLabel("关键字类型");
		label.setBounds(38, 41, 91, 16);
		add(label);
		
		//查询关键字选项
		final String[] keywordlist = {"机构编码","机构类型","机构名"};
		keywordType = new JComboBox(keywordlist);
		keywordType.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(keywordType.getSelectedItem().toString().equals(keywordlist[1])){
					keyword.setVisible(false);
					jigouleixing.setVisible(true);			
				}else {
				    keyword.setText("");
					keyword.setVisible(true);
					jigouleixing.setVisible(false);	
				}
			}
		});
		keywordType.setBounds(117, 37, 142, 20);
		add(keywordType);
		
		//机构类型的选项
		String[] jigoulist = {"中转中心","营业厅","仓库","总部"};
		jigouleixing = new JComboBox(jigoulist);
		jigouleixing.setBounds(260, 35, 216, 28);
		add(jigouleixing);
		jigouleixing.setVisible(false);
		
		keyword = new MJTextField();
		keyword.setBounds(260, 35, 216, 28);
		add(keyword);
		keyword.setColumns(10);
		
		JButton chaxun = new JButton("查询");
		chaxun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//zhe li bu dui 
				if(keywordType.getSelectedItem().toString().equals("机构编码")){	
					vo = new OrganizationInfoVO(keyword.getText(),null,null,null);
					//System.out.println(keywordType.getSelectedItem().toString());
				}
				else if(keywordType.getSelectedItem().toString().equals("机构类型")){	
					vo = new OrganizationInfoVO(null,whichType(jigouleixing.getSelectedItem().toString()),null,null);
				}
				else{
					vo = new OrganizationInfoVO(null,null,keyword.getText().toString(),null);
				}
				
				ArrayList<OrganizationInfoVO> orglist = new ArrayList<OrganizationInfoVO>();
     			orglist = service.findOrgInfo(vo);
				data.clear();
				
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
				}else{
					JOptionPane.showConfirmDialog(null,"未查询到信息，-_-#","系统提示",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				}
				
				
			}
		});
		chaxun.setBounds(488, 31, 73, 38);
		add(chaxun);
		
		//点击显示所有，将在表格中看到所有机构列表
		JButton xianshi = new JButton("显示所有");
		xianshi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				showall();
			}
		});
		xianshi.setBounds(577, 31, 73, 38);
		add(xianshi);
		
		JLabel lblNewLabel = new JLabel("机构编号");
		lblNewLabel.setBounds(772, 54, 61, 16);
		add(lblNewLabel);
		
		orgnum = new MJTextField();
		orgnum.setBounds(840, 48, 287, 28);
		add(orgnum);
		orgnum.setColumns(10);	//机构编号编辑框
		
		JLabel lblNewLabel_1 = new JLabel("机构类型");
		lblNewLabel_1.setBounds(772, 111, 61, 16);
		add(lblNewLabel_1);
		
		String[] orgTypeList = {"营业厅","中转中心","仓库","总部"};
		orgtype = new JComboBox(orgTypeList);
		orgtype.setBounds(840, 107, 287, 20);
		add(orgtype);//机构类型选择框
		
		JLabel label_1 = new JLabel("机构名称");
		label_1.setBounds(772, 171, 61, 16);
		add(label_1);
		
		orgname = new MJTextField();
		orgname.setBounds(840, 165, 287, 28);
		add(orgname);
		orgname.setColumns(10);
		
		JLabel label_2 = new JLabel("请点击编辑此机构人员信息，进行人员信息的新增和修改");
		label_2.setBounds(772, 215, 302, 16);
		add(label_2);
		
		JButton add = new JButton("ADD");
		add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				staffinfo.clear();
				vo = new OrganizationInfoVO(orgnum.getText(),whichType(orgtype.getSelectedItem().toString()),
						orgname.getText(),staffinfo);
				//System.out.println("添加信息");
				res  = service.addOrganization(vo);
				if(res.isPass()){
					Vector row = new Vector();
					row.add(orgnum.getText());
					row.add(orgtype.getSelectedItem().toString());
					row.add(orgname.getText());
					data.add(row.clone());
					 model.setDataVector(data, name);
				    table.setModel(model);
				    JOptionPane.showConfirmDialog(null, "添加机构成功","系统提示",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				}else{
					int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				}
			
			}
		});
		add.setBounds(772, 254, 75, 49);
		add(add);
		
		JButton modify = new JButton("MODIFY");
		modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(seletedRow != -1){
					System.out.println("modify:" + seletedRow);
					if(!staffinfo.isEmpty()){
				for(int i = 0;i<staffinfo.size();i++){
					staffinfo.get(i).setOrganization(orgname.getText());
				}// 改变一个机构时，该机构隶属人员的信息也做相应改动
					}
				modify();
				}else {
					JOptionPane.showConfirmDialog(null, "尼木有选择要修改的机构哦！^_−☆","系统提示",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				}
			}
		});
		modify.setBounds(881, 254, 77, 49);
		add(modify);
		
		JButton delete = new JButton("DELETE");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(seletedRow != -1){
				OrganizationInfoVO vos = new OrganizationInfoVO(null,null,model.getValueAt(seletedRow, 2).toString(),null);
				if(service.findOrgInfo(vos).isEmpty()){
					JOptionPane.showConfirmDialog(null, "数据库异常，请联系管理员","系统提示",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				}else {
				for(int i = 0;i< service.findOrgInfo(vos).size();i++){
					res  = service.delOrganization(service.findOrgInfo(vos).get(i));
						if(!res.isPass()){
							int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
									JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						}else{
							model.removeRow(seletedRow);
							int result1 = JOptionPane.showConfirmDialog(null, "机构信息删除成功","系统提示",
									JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
							seletedRow = -1;
						}	
				}
				}
			}else {
				JOptionPane.showConfirmDialog(null, "请选择要删除的信息","系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			}
			}
		});
		delete.setBounds(981, 254, 77, 49);
		add(delete);

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
		data.clear();
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
		vo = new OrganizationInfoVO(orgnum.getText(),whichType(orgtype.getSelectedItem().toString()),
				orgname.getText(),staffinfo);
		res = service.ModifyOrganization(vo);
		if(!res.isPass()){
			int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);

		}else{
			int result1 = JOptionPane.showConfirmDialog(null, "机构信息成功更新","系统提示",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			model.setValueAt(orgnum.getText(), seletedRow, 0);
			model.setValueAt(orgtype.getSelectedItem().toString(), seletedRow, 1);
    		model.setValueAt(orgname.getText(), seletedRow, 2);
    		seletedRow = -1;
		}
	}
	
	public void renyuan() {
		btnNewButton_5 = new JButton("编辑/查看人员信息");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				isselected();
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
						vo = new OrganizationInfoVO(orgnum.getText(),whichType(orgtype.getSelectedItem().toString()),
								orgname.getText(),staffinfo);
						res = service.ModifyOrganization(vo);
						if(!res.isPass()){
							int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
									JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						}else{
							int result1 = JOptionPane.showConfirmDialog(null, "此机构人员信息成功更新","系统提示",
									JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
							staffinfo.clear();
						}
					}
					
				});
			}
		});
		btnNewButton_5.setBounds(782, 315, 279, 49);
		add(btnNewButton_5);
	}
	
	public void isselected() {
		if(seletedRow == -1){
			JOptionPane.showConfirmDialog(null, "请先选择机构哦！","系统提示",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		}
	}
}
