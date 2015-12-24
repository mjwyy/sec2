package presentation.logisticui;
//快递员查询界面
import java.awt.Graphics;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import businesslogic.statistic.OrderInquiry;
import dataservice.exception.ElementNotFoundException;
import util.ResultMsg;
import util.enums.GoodsState;
import vo.OrderVO;
import businesslogicservice.statisticblservice.OrderInquiryBLService;
import businesslogicservice.statisticblservice._stub.OrderInquiryBLService_Stub;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class InquiryPanel extends JPanel {
	private JTextField barcode;
	private JTable table;
	private DefaultTableModel model;
	private Vector name;
	private Vector data;
	private OrderInquiryBLService service;
	private ResultMsg res;
	private JLabel lblNewLabel;
	private JButton back;
	/**
	 * Create the panel.
	 */
	
	public void paintComponent(Graphics g) {
		 super.paintComponents(g);
		 ImageIcon img = new ImageIcon("image/0011.jpg");
		g.drawImage(img.getImage(), 0, 0, null);
		 //float lineWidth = 3.0f;
	    // ((Graphics2D)g).setStroke(new BasicStroke(lineWidth));
	     // g.drawLine(768, 0, 768, 500);
		}
	public InquiryPanel() {
	setSize(1152,446);
	setLayout(null);
	
	JLabel label = new JLabel("条形码");
	label.setBounds(76, 48, 61, 16);
	add(label);
	
	barcode = new JTextField();
	barcode.setBounds(136, 42, 381, 37);
	add(barcode);
	barcode.setColumns(10);
	
	name = new Vector();
	name.add("时间");
	name.add("物流信息");
	name.add("货物状态");
	data = new Vector();
	model = new DefaultTableModel();
	model.setDataVector(data, name);
	table = new JTable(model);
	table.setBounds(76, 113, 555, 276);
	JScrollPane scrollPane = new JScrollPane(table);
	scrollPane.setEnabled(false);
	scrollPane.setBounds(76, 113, 731, 276);
	add(scrollPane);
	
    lblNewLabel = new JLabel("条形码应为10位0～9位的数字");
	lblNewLabel.setForeground(Color.RED);
	lblNewLabel.setBounds(136, 85, 367, 16);
	add(lblNewLabel);
	lblNewLabel.setVisible(false);
	
	back = new JButton("返回");
	back.setBounds(836, 390, 82, 37);
	add(back);
	
	JButton btnNewButton = new JButton("查询");
	btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			service = new OrderInquiry();
			res = service.inputBarcode(barcode.getText());
			if(res.isPass()){
                OrderVO vo = null;
                try {
                    vo = service.submitBarcode(barcode.getText());
                    //TODO 界面显示提示框,打印Info里面的内容
                } catch (ElementNotFoundException e1) {
                    e1.printStackTrace();
                    String info = e1.getMessage();

                } catch (RemoteException e1) {
                    e1.printStackTrace();
                    String info = e1.getMessage();
                }
                ArrayList<String> history = new ArrayList<String>();

        		Vector row = new Vector();
        		ArrayList<String> historys = new ArrayList<String>();
        		historys = vo.getHistory();
        		if(historys.isEmpty()){
        			row.add("暂无跟踪记录");
        			data.add(row.clone());
        			row.clear();
        			model.setDataVector(data, name);
        			table.setModel(model);
        			
        		}else{
        			
        		for(int i = 0;i<historys.size();i++){
        			String[] s = historys.get(i).split(",");
        			GoodsState state = vo.getStateOfTransport();
        			String historystate = s[1];
        			row.add(s[0]);
        			row.add(historystate);
        			row.add(whichStates(state));
        			data.add(row.clone());
        			row.clear();
        			model.setDataVector(data, name);
        			table.setModel(model);
        			//这里假设history货运状态以“时间＋“ ”＋历史轨迹形式
        		}
        		}
				
			}else{
				lblNewLabel.setVisible(true);
			}
			
			
		}
	});
	btnNewButton.setBounds(534, 43, 97, 36);
	add(btnNewButton);
	}
	
	public JButton getBack(){
		return back;
	}
	
	  public String whichStates(GoodsState state) {
		  if(state.equals(state.COMPLETE))
			  return "完整(●°u°●)​";
		  else if(state.equals(state.DAMAGED))
			  return "损坏(ｰｰ;)";
		  else 
			  return "丢失(´Д` )";
	  }
}
