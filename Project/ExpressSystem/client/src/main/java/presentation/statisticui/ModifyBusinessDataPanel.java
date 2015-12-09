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
import businesslogic.statistic.BusinessDataModification;
import businesslogicservice.statisticblservice.BusinessDataModificationBLService;
import businesslogicservice.statisticblservice._stub.BusinessDataModificationBLService_Stub;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
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
	private DefaultTableModel model;
	private Vector name;
	private Vector data;
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
      scrollPane.setBounds(90, 64, 455, 154);
      add(scrollPane);
      
      JLabel label = new JLabel("修改价格常量");
      label.setBounds(90, 268, 127, 28);
      add(label);
      
      JLabel label_1 = new JLabel("价格类型");
      label_1.setBounds(90, 321, 61, 16);
      add(label_1);
      
      final String [] priceType = {"每公里的费用","纸箱价格"," 木箱价格","快递袋价格"};
      pricetype = new JComboBox(priceType);
      pricetype.addActionListener(new ActionListener() {
      	public void actionPerformed(ActionEvent e) {
      		if(pricetype.getSelectedItem().equals(priceType[0])){
      			type = type.PricePerKg;
      		}
      		else if(pricetype.getSelectedItem().equals(priceType[1])){
      			type = type.PaperBox;
      		}
      		else if(pricetype.getSelectedItem().equals(priceType[1])){
      			type = type.WoodenBox;
      		}else{
      			type = type.PaperBox;
      		}
      			
      			
      		
      	}
      });
      pricetype.setBounds(186, 316, 194, 28);
      add(pricetype);
      
      price = new JTextField();
      price.setBounds(186, 355, 194, 28);
      add(price);
      price.setColumns(10);
      
      JLabel lblNewLabel = new JLabel("价格");
      lblNewLabel.setBounds(90, 361, 61, 16);
      add(lblNewLabel);
      
      JLabel label_2 = new JLabel("修改城市间距离");
      label_2.setBounds(759, 23, 105, 16);
      add(label_2);
      
      JLabel label_3 = new JLabel("城市1");
      label_3.setBounds(759, 61, 61, 16);
      add(label_3);
      
      city1 = new JTextField();
      city1.setBounds(854, 55, 190, 28);
      add(city1);
      city1.setColumns(10);
      
      JLabel label_4 = new JLabel("城市2:");
      label_4.setBounds(759, 101, 61, 16);
      add(label_4);
      
      city2 = new JTextField();
      city2.setBounds(854, 95, 190, 28);
      add(city2);
      city2.setColumns(10);
      
      JLabel label_5 = new JLabel("距离");
      label_5.setBounds(759, 139, 61, 16);
      add(label_5);
      
      distance = new JTextField();
      distance.setBounds(854, 133, 190, 28);
      add(distance);
      distance.setColumns(10);
      
      JButton button = new JButton("确认");
      button.addActionListener(new ActionListener() {
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
      		res = service.inputPrice(type, Double.parseDouble(price.getText()));
      		if(res.isPass()){
				
						ResultMsg resultMsg = service.submitPrice(type,  Double.parseDouble(price.getText()));						
					   if(resultMsg.isPass()){
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
      button.setBounds(424, 356, 117, 29);
      add(button);
      
      JButton btnAdd = new JButton("ADD");
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
							
						}
				
				
			}
			else{
				int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			}
      		}
      	}
      });
      btnAdd.setBounds(927, 189, 117, 29);
      add(btnAdd);
  
      
      JLabel label_6 = new JLabel("城市距离列表");
      label_6.setBounds(90, 23, 127, 16);
      add(label_6);
	}
}
