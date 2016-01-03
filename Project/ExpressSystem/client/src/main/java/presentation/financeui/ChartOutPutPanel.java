package presentation.financeui;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import presentation.commodityui.PanDian;
import presentation.util.MyJFileChooser;
import presentation.util.ObservingTextField;

import com.qt.datapicker.DatePicker;

import businesslogic.statistic.ChartOutput;
import businesslogicservice.statisticblservice.ChartOutputBLService;
import businesslogicservice.statisticblservice._stub.ChartOutputBLService_Stub;
import util.ResultMsg;
import util.chart.BusinessStateContent;
import util.chart.CostAndProfitContent;
import util.enums.ChartType;
import vo.BusinessStateChartVO;
import vo.ChartVO;
import vo.CostAndProfitChartVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ChartOutPutPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	/**
	 * 窗口宽度
	 */
	private static final int WIDTH = 1152;
	
	/**
	 * 窗口高度
	 */
	private static final int HEIGHT = 446;
	private JTable table;
	private DefaultTableModel model;
	private Vector name;
	private Vector data;
	private ChartVO vo;
	private BusinessStateChartVO vob;
	private CostAndProfitChartVO voc;
	private ChartType charttype;
	private JComboBox comboBox;
	private ChartOutputBLService service = new ChartOutput();
	private  ResultMsg  res;
	private ObservingTextField startT;
	private JLabel lblNewLabel;
	private JLabel end;
	private ObservingTextField endT;
	private ArrayList<BusinessStateContent> bcontents = new ArrayList<BusinessStateContent>();
	private  ArrayList<CostAndProfitContent> costAndProfitContents =new ArrayList<CostAndProfitContent>();
	public  ChartOutPutPanel() {
		setSize(WIDTH,HEIGHT);
		setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("报表种类");
		lblNewLabel_1.setBounds(69, 43, 61, 16);
		add(lblNewLabel_1);
		
		String[] type = {"经营情况表","成本收益表"};
		comboBox = new JComboBox(type);
		comboBox.setBounds(142, 39, 149, 27);
		add(comboBox);
		
		JLabel label = new JLabel("起始时间");
		label.setBounds(303, 43, 61, 16);
		add(label);
		
		startT = new ObservingTextField();
		startT.setBounds(361, 37, 134, 28);
		add(startT);
		startT.setColumns(10);
		
		lblNewLabel = new JLabel();
		lblNewLabel.setIcon(new ImageIcon("image/cs.png"));
		lblNewLabel.addMouseListener(new MouseAdapter() {

			public void mouseEntered(MouseEvent arg0){
				lblNewLabel.setIcon(new ImageIcon("image/csr.png"));
			}
			public void mouseExited(MouseEvent arg0){
				lblNewLabel.setIcon(new ImageIcon("image/cs.png"));
			}
			public void mouseClicked(MouseEvent arg0) {
				DatePicker dp = new DatePicker(startT, Locale.CHINA);
				// previously selected date
				Date selectedDate = dp.parseDate(startT.getText());
				dp.formatDate(selectedDate,"yyyy-mm-dd");
				dp.setSelectedDate(selectedDate);
				dp.start(startT);	
			}
		});
		lblNewLabel.setBounds(504, 38, 36, 26);
		add(lblNewLabel);
	
		JLabel label_1 = new JLabel("结束时间");
		label_1.setBounds(564, 43, 61, 16);
		add(label_1);
		
		endT = new ObservingTextField();
		endT.setBounds(637, 37, 134, 28);
		add(endT);
		endT.setColumns(10);
		
		end = new JLabel();
		end.setIcon(new ImageIcon("image/cs.png"));
		end.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0){
				end.setIcon(new ImageIcon("image/csr.png"));
			}
			public void mouseExited(MouseEvent arg0){
				end.setIcon(new ImageIcon("image/cs.png"));
			}
			public void mouseClicked(MouseEvent e) {
				DatePicker dp = new DatePicker(endT, Locale.CHINA);
				// previously selected date
				Date selectedDate = dp.parseDate(endT.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(endT);	
			}
		});
		end.setBounds(783, 38, 36, 26);
		add(end);
		
		name = new Vector();
		name.add("查询内容");
		data = new Vector();
		model = new DefaultTableModel();
		model.setDataVector(data,name);
		table = new JTable(model);
		table.setBounds(69, 118, 800, 282);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(69, 118, 800, 282);
		add(scrollPane);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {								
				 TableColumn column = null;
			   		int colunms = table.getColumnCount();  
			   		for(int i = 0; i < colunms; i++)  
			   		{  
			   			column = table.getColumnModel().getColumn(i);  
			   			/*将每一列的默认宽度设置为100*/  
			   			column.setPreferredWidth(200);  
			   		} 
			   		
				if(comboBox.getSelectedItem().equals("经营情况表"))
					charttype = charttype.BUSINESS_STAT_CHART;
				else
					charttype = charttype.PROFIT_CHART;
				
				if(!(startT.getText().isEmpty()||endT.getText().isEmpty())){
				res = service.enquiryChart(charttype,startT.getText(),endT.getText());//查询格式检查
				if(res.isPass()){
				
			       if(comboBox.getSelectedItem().equals("经营情况表")){
			    	   name.clear();
			    	   data.clear();
			    	   vob = (BusinessStateChartVO) service.getChartVO(charttype,startT.getText(),endT.getText());
			    	   name.add("收款日期");
			    	   name.add("收益流水");
			    	   name.add("收款金额");
			    	   name.add("收款账户");
			    	   name.add("付款人");
			    	if(!vob.equals(null)){
			    	   bcontents = vob.getContents();
      		    	  
      		    		   for(int i = 0;i <bcontents.size();i++){
			    		   Vector row = new Vector();
			    		   row.add(bcontents.get(i).getDate());
			    		   row.add(bcontents.get(i).getId());
			    		   row.add(bcontents.get(i).getMoney());
			    		   row.add(bcontents.get(i).getAccount());
			    		   row.add(bcontents.get(i).getPayer());
			    		   data.add(row.clone());
			    		  
      		    		   }   	
      		    		 model.setDataVector(data,name);
			    		   table = new JTable(model);
			    	} else{
			    		noFind();
			    	}
			    	   
			       }else{
			    	   name.clear();
			    	   data.clear();
			    	   voc = (CostAndProfitChartVO)service.getChartVO(charttype,startT.getText(),endT.getText());
			    	   name.add("日期");
			    	   name.add("收入");
			    	   name.add("成本");
			    	   name.add("利润");
			    	   if(!voc.equals(null)){	   
			    	   costAndProfitContents = voc.getCostAndProfitContents();			    	
			    	   for(int i = 0;i<costAndProfitContents.size();i++){
			    		   Vector row = new Vector();
			    		   row.add(costAndProfitContents.get(i).getDate());
			    		   row.add(costAndProfitContents.get(i).getIncome());
			    		   row.add(costAndProfitContents.get(i).getCost());
			    		   row.add(costAndProfitContents.get(i).getProfit());
			    		   data.add(row.clone());
			    		   model.setDataVector(data,name);
			    		   table = new JTable(model);   
			    	   }
			    	   }else{
			    		  noFind();
			    		   
			    	   }
			       }
					
				}else{
					int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				}
				}else{
			    	   int result1 = JOptionPane.showConfirmDialog(null, "请将信息填写完整","系统提示",
								JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			       }
				
			}
		});
		btnNewButton.setBounds(844, 37, 89, 30);
		add(btnNewButton);
		
		JButton button = new JButton("导出");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO 导出
				MyJFileChooser mfc=new MyJFileChooser();
	        	if(mfc.showSaveDialog(ChartOutPutPanel.this)== JFileChooser.APPROVE_OPTION){
	        		String filename=mfc.getSelectedFile().getParent();
	        		System.out.println(filename);
	        		
	        		if(vob != null){
	        			ResultMsg resultMsg = service.exportChart(vob, filename);
	        			isResPass(resultMsg);
	        		}else if(voc != null){
	        			ResultMsg resultMsg = service.exportChart(vob, filename);
	        			isResPass(resultMsg);
	        		}else{
	        			 int result1 = JOptionPane.showConfirmDialog(null, "没有文件可以导出","系统提示",
									JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);
	        		}
				
	        	}	
			}
		});
		button.setBounds(962, 37, 89, 30);
		add(button);

	}
	
	public void isResPass(ResultMsg resultMsg){
		if(resultMsg.isPass()){
			int result1 = JOptionPane.showConfirmDialog(null, "操作成功","系统提示",
					JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		}else{
			int result1 = JOptionPane.showConfirmDialog(null, resultMsg.getMessage(),"系统提示",
					JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);
		}
	}
	
	public void noFind(){
		int result1 = JOptionPane.showConfirmDialog(null, "此间时间木有查询到信息","系统提示",
				JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE); 
	}
}
