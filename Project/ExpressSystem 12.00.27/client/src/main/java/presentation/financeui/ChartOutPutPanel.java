package presentation.financeui;

import java.util.ArrayList;
import java.util.Vector;

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

import businesslogic.statistic.ChartOutput;
import businesslogicservice.statisticblservice.ChartOutputBLService;
import businesslogicservice.statisticblservice._stub.ChartOutputBLService_Stub;
import presentation.util.FileChoose;
import util.ResultMsg;
import util.enums.ChartType;
import vo.BusinessStateChartVO;
import vo.ChartVO;
import vo.CostAndProfitChartVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

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
	private JTextField begintime;
	private JTextField endtime;
	private ChartVO vo;
	private BusinessStateChartVO vob;
	private CostAndProfitChartVO voc;
	private ChartType charttype;
	private JComboBox comboBox;
	private ChartOutputBLService service = new ChartOutput();
	private  ResultMsg  res;
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
		
		begintime = new JTextField();
		begintime.setBounds(361, 37, 134, 28);
		add(begintime);
		begintime.setColumns(10);
	
		JLabel label_1 = new JLabel("结束时间");
		label_1.setBounds(554, 43, 61, 16);
		add(label_1);
		
		endtime = new JTextField();
		endtime.setBounds(619, 37, 134, 28);
		add(endtime);
		endtime.setColumns(10);
		
		name = new Vector();
		name.add("查询内容");
		data = new Vector();
		model = new DefaultTableModel();
		model.setDataVector(data,name);
		table = new JTable(model);
		table.setBounds(69, 118, 982, 282);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(69, 118, 982, 282);
		add(scrollPane);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(comboBox.getSelectedItem().equals("经营情况表"))
					charttype = charttype.BUSINESS_STAT_CHART;
				else
					charttype = charttype.BUSINESS_STAT_CHART;
				if(!(begintime.getText().isEmpty()||endtime.getText().isEmpty())){
				res = service.enquiryChart(charttype,begintime.getText(),endtime.getText());
				if(res.isPass()){
				
			       if(comboBox.getSelectedItem().equals("经营情况表")){
			    	   name.clear();
			    	   vob = (BusinessStateChartVO) service.getChartVO(charttype,begintime.getText(),endtime.getText());
			    	   name.add("日期");
			    	   name.add("收益");
			    	   name.add("同期增长率");
			    	   ArrayList<String> everyday = new ArrayList<String>();
			    	   ArrayList<Double> profix = new  ArrayList<Double>();
			    	   ArrayList<Double> growrate = new  ArrayList<Double>();
			    	   for(int i = 0;i<everyday.size();i++){
			    		   Vector row = new Vector();
			    		   row.add(everyday.get(i));
			    		   row.add(profix.get(i));
			    		   row.add(growrate.get(i));
			    		   data.add(row.clone());
			    		   model.setDataVector(data,name);
			    		   table = new JTable(model); 
			    	   }		    	   
			    	   
			       }else{
			    	   voc = (CostAndProfitChartVO)service.getChartVO(charttype,begintime.getText(),endtime.getText());
			    	   name.add("日期");
			    	   name.add("成本");
			    	   name.add("收益");
			    	   ArrayList<String> everyday = new ArrayList<String>();
			    	   ArrayList<Double> profix = new  ArrayList<Double>();
			    	   ArrayList<Double> cost = new  ArrayList<Double>();
			    	   for(int i = 0;i<everyday.size();i++){
			    		   Vector row = new Vector();
			    		   row.add(everyday.get(i));
			    		   row.add(cost.get(i));
			    		   row.add(profix.get(i));
			    		   data.add(row.clone());
			    		   model.setDataVector(data,name);
			    		   table = new JTable(model);   
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
		btnNewButton.setBounds(801, 38, 89, 30);
		add(btnNewButton);
		
		JButton button = new JButton("导出");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO 导出
				new FileChoose();
				
				
			}
		});
		button.setBounds(962, 37, 89, 30);
		add(button);
		
		

	}
}
