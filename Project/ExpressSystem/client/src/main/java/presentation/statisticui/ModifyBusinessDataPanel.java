package presentation.statisticui;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;

import presentation.util.SubmitDialog;
import presentation.util.checkstyleDialog;
import util.ResultMsg;
import util.enums.PriceType;
import vo.DistanceVO;
import vo.PriceVO;
import businesslogic.statistic.BusinessDataModification;
import businesslogicservice.statisticblservice.BusinessDataModificationBLService;
import businesslogicservice.statisticblservice._stub.BusinessDataModificationBLService_Stub;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class ModifyBusinessDataPanel extends JPanel {
	private JTextField price;
	private JTextField city1;
	private JTextField city2;
	private JTextField distance;
	private BusinessDataModificationBLService service = new BusinessDataModification();
	private ResultMsg  res;
	private SubmitDialog sd;
	private PriceType type;
    private JComboBox pricetype;
	private JTable table;
	private JTable table1;
	private DefaultTableModel model;
	private DefaultTableModel model1;
	private Vector name;
	private Vector name1;
	private Vector data;
	private Vector data1;
	private int seletedRow = -1;
	private int seletedRow1 = -1;
	private  ArrayList<PriceVO> priceVo = new  ArrayList<PriceVO>();
	private  ArrayList<DistanceVO> distanceList = new  ArrayList<DistanceVO>();
	private JTextField newcity;
	/**
	 * Create the panel.
	 */
	public ModifyBusinessDataPanel() {
      setSize(1152,446);
      setLayout(null);
      
		name = new Vector();
		name.add("城市1");
		name.add("城市2");
		name.add("距离");
		data = new Vector();
		model = new DefaultTableModel();
		model.setDataVector(data,name);
		table = new JTable(model);
		table.setBounds(367, 72, 371, 272);
      JScrollPane scrollPane = new JScrollPane(table);
      scrollPane.setBounds(80, 51, 253, 265);
      add(scrollPane);
      
      table.addMouseListener(new MouseAdapter() {
      	public void mouseClicked(MouseEvent arg0) {
      		 seletedRow = table.getSelectedRow();
        		if(seletedRow != -1){
        			city1.setText(model.getValueAt(seletedRow,0).toString());
        			city2.setText(model.getValueAt(seletedRow,1).toString());
        			distance.setText(model.getValueAt(seletedRow,2).toString());      			
        		}
      	}
      });
      
      
        name1 = new Vector();
		name1.add("价格类型");
		name1.add("价格");
		data1 = new Vector();
		model1 = new DefaultTableModel();
		model1.setDataVector(data1,name1);
		table1 = new JTable(model1);
		table1.setBounds(367, 72, 371, 272);
      JScrollPane pricetable = new JScrollPane(table1);
      pricetable.setBounds(779, 54, 238, 234);
      add(pricetable);
      
      table1.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent arg0) {
        		 seletedRow1 = table1.getSelectedRow();
          		if(seletedRow1 != -1){
          			pricetype.setSelectedItem(model1.getValueAt(seletedRow1,0).toString());
          			//System.out.println("price ="+model1.getValueAt(seletedRow1,1).toString());
          			price.setText(model1.getValueAt(seletedRow1,1).toString());         			    			
          		}
        	}
        });
           
     cityshowall();
     priceshowall();
      JLabel label = new JLabel("修改价格常量");
      label.setBounds(780, 17, 127, 28);
      add(label);
      
      JLabel label_1 = new JLabel("价格类型");
      label_1.setBounds(779, 300, 61, 16);
      add(label_1);
      
      final String [] priceType = {"每公里的运费","纸箱价格","木箱价格","快递袋价格"};
      pricetype = new JComboBox(priceType);
      pricetype.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		if(pricetype.getSelectedItem().equals(priceType[0])){
      			type = type.PricePerKg;
      		}
      		else if(pricetype.getSelectedItem().equals(priceType[1])){
      			type = type.PaperBox;
      		}
      		else if(pricetype.getSelectedItem().equals(priceType[2])){
      			type = type.WoodenBox;
      		}else{
      			type = type.PaperBox;
      		}
      			
      	whichrow(pricetype.getSelectedItem().toString());
      		
      	}
      });
      pricetype.setBounds(854, 295, 194, 28);
      add(pricetype);
      
      price = new JTextField();
      price.setBounds(854, 335, 194, 28);
      add(price);
      price.setColumns(10);
      
      JLabel lblNewLabel = new JLabel("价格");
      lblNewLabel.setBounds(779, 341, 61, 16);
      add(lblNewLabel);
      
      JLabel label_2 = new JLabel("修改城市间距离");
      label_2.setBounds(367, 52, 105, 16);
      add(label_2);
      
      JLabel label_3 = new JLabel("城市1");
      label_3.setBounds(367, 92, 61, 16);
      add(label_3);
      
      city1 = new JTextField();
      city1.setBounds(426, 86, 190, 28);
      add(city1);
      city1.setColumns(10);
      
      JLabel label_4 = new JLabel("城市2:");
      label_4.setBounds(367, 126, 61, 16);
      add(label_4);
      
      city2 = new JTextField();
      city2.setBounds(426, 120, 190, 28);
      add(city2);
      city2.setColumns(10);
      
      JLabel label_5 = new JLabel("距离");
      label_5.setBounds(367, 164, 61, 16);
      add(label_5);
      
      distance = new JTextField();
      distance.setBounds(426, 158, 190, 28);
      add(distance);
      distance.setColumns(10);
      
      JButton btnModify = new JButton("MODIFY");
      btnModify.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
         
      		String distanceNum = price.getText();
      		int cantran = 1;
      		for(int i = 0;i<distanceNum.length();i++){
      			if((distanceNum.charAt(i)<'0'||distanceNum.charAt(i)>'9')&&(distanceNum.charAt(i)!='.')){
      				int result1 = JOptionPane.showConfirmDialog(null, "距离请填写数字","系统提示",
    						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
      				cantran = 0;
      				break;
      			}
      		}
      		if(cantran == 1){
      		res = service.inputPrice(type, Double.parseDouble(price.getText()));//格式检查
      		if(res.isPass()){
				
						ResultMsg resultMsg = service.submitPrice(type,  Double.parseDouble(price.getText()));						
					   if(resultMsg.isPass()){
						   System.out.println("selectedrow:"+seletedRow1);
						   model1.setValueAt(price.getText(), seletedRow1, 1);
						   
						   int result1 = JOptionPane.showConfirmDialog(null, "修改成功","系统提示",
									JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
					   }else{
						   int result1 = JOptionPane.showConfirmDialog(null, resultMsg.getMessage(),"系统提示",
									JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);
					   }		
			}
			else{
				int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			}
      		}
            }
      	
      });
      btnModify.setBounds(927, 383, 117, 29);
      add(btnModify);
      
      JButton btnAdd = new JButton("MODIFY");
      btnAdd.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		String distanceNum = distance.getText();
      		int cantran = 1;
      		for(int i = 0;i<distanceNum.length();i++){
      			if((distanceNum.charAt(i)<'0'||distanceNum.charAt(i)>'9')&&(distanceNum.charAt(i)!='.')){
      				int result1 = JOptionPane.showConfirmDialog(null, "距离请填写数字","系统提示",
    						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
      				cantran = 0;
      				break;
      			}
      		}
      		
      		if(cantran == 1){
      		res  = service.inputCityDistance(city1.getText(), city2.getText(), Double.parseDouble(distance.getText()));
      		if(res.isPass()){		
						ResultMsg subMsg = service.submitCityDistance(city1.getText(), city2.getText(), Double.parseDouble(distance.getText()));
						if(subMsg.isPass()){
							Vector row = new Vector();
							row.add(city1.getText());
							row.add(city2.getText());
							data.add(row.clone());
						}else{
							int result1 = JOptionPane.showConfirmDialog(null, subMsg.getMessage(),"系统提示",
									JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
						}
				
				
			}
			else{
				int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			}
      		}
      	}
      });
      btnAdd.setBounds(499, 225, 117, 29);
      add(btnAdd);
  
      
      JLabel label_6 = new JLabel("城市距离列表");
      label_6.setBounds(90, 23, 127, 16);
      add(label_6);
      
      JButton button_1 = new JButton("显示所有");
      button_1.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		 cityshowall();
      	   
      	}
      });
      button_1.setBounds(229, 18, 117, 29);
      add(button_1);
      
      JButton button_2 = new JButton("显示所有");
      button_2.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		priceshowall();
      	}
      });
      button_2.setBounds(931, 18, 117, 29);
      add(button_2);  
      
      JLabel label_7 = new JLabel("新增城市");
      label_7.setBounds(84, 341, 75, 16);
      add(label_7);
      
      newcity = new JTextField();
      newcity.setBounds(80, 369, 171, 28);
      add(newcity);
      newcity.setColumns(10);
      
      JButton btnAdd_1 = new JButton("ADD");
      btnAdd_1.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		boolean f = service.addCity(newcity.getText());
      		if(f){
      			cityshowall();
      		}
      	}
      });
      btnAdd_1.setBounds(236, 412, 97, 28);
      add(btnAdd_1);
	}
	
	public String whichString(PriceType priceType){
		if(priceType == PriceType.Bag ){
			return "快递袋价格";
		}else if(priceType == PriceType.PaperBox){
			return "纸箱价格";
		}else if(priceType == PriceType.WoodenBox){
		     return "木箱价格";
		}else {
			return "每公里的运费";
		}
	}
	
	public PriceType whichType(String s){
		if(s.equals("每公里的费用")){
			return PriceType.PricePerKg;
		}else if(s.equals("纸箱价格")){
			return PriceType.PaperBox;
		}else if(s.equals("木箱价格")){
			return PriceType.WoodenBox;
		}else{
			return PriceType.Bag ;
		}
	}

	public void whichrow(String s){
		int rownum = model1.getRowCount();
  		for(int i = 0;i<rownum;i++){
  			if(model1.getValueAt(i, 0).toString().equals(s)){
  				seletedRow1 = i;
  				price.setText(model1.getValueAt(i, 1).toString());
  				break;
  			}else if(model1.getValueAt(i, 0).toString().equals(s)){
  				seletedRow1 = i;
  				price.setText(model1.getValueAt(i, 1).toString());
  				break;
  			}else if(model1.getValueAt(i, 0).toString().equals(s)){
  				seletedRow1 = i;
  				price.setText(model1.getValueAt(i, 1).toString());
  				break;
  			}else if(model1.getValueAt(i, 0).toString().equals(s)){
  				seletedRow1 = i;
  				price.setText(model1.getValueAt(i, 1).toString());
  				break;
  			}
  		}
	}
	
	public void cityshowall() {
		distanceList = service.getAllDistanceInfo();
  		data.clear();
  		if(!distanceList.isEmpty()){
  			for(int i = 0;i<distanceList.size();i++){
  				Vector row = new Vector();
  				row.add(distanceList.get(i).getCity1());
  				row.add(distanceList.get(i).getCity2());
  				row.add(distanceList.get(i).getDistance());
  				data.add(row.clone());
  			}
  		}
	}
	
	public void priceshowall() {
		priceVo = service.getAllPrices();
  		data1.clear();
  		if(!priceVo.isEmpty()){
  			for(int i = 0;i<priceVo.size();i++){
  				Vector row = new Vector();
  				row.add(whichString(priceVo.get(i).getPriceType()));
  				row.add(priceVo.get(i).getPrice());
  				data1.add(row.clone());
  			}
  		}
	}
}
