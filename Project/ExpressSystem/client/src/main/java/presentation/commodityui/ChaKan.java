/**
 * 库存查看界面
 * 
 * @author wqy
 *
 */
package presentation.commodityui;

import java.awt.Color;
import java.awt.Font;
import java.awt.font.*;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import businesslogic.commodity.StorageInquiryPart;
import businesslogicservice.commodityblservice.StorageInquiryPartBLService;
import businesslogicservice.commodityblservice._Stub.StorageInquiryPartBLService_Stub;

import com.qt.datapicker.DatePicker;

import presentation.util.CurrentTime;
import presentation.util.ObservingTextField;
import util.LogInMsg;
import util.ResultMsg;
import vo.CommodityGoodsVO;
import vo.InventoryVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class ChaKan extends JPanel {
	private ObservingTextField startT;
	private JLabel lblNewLabel;
	private JLabel end ;
	private JTable table;
	private ObservingTextField endT;
	private DefaultTableModel model;
	private DefaultTableModel model1;
	private JScrollPane scroll1;//详细.放commodityGoodsVO
	private JScrollPane scroll;
	private JPanel heji;//合计
	private InventoryVO vo;//
	private InventoryVO ivo;
	//StorageInquiryPartBLService spb=new StorageInquiryPartBLService_Stub();
	StorageInquiryPartBLService spb=new StorageInquiryPart();
	private JTextField inn;
	private JTextField outn;
	private JTextField mon;
	private LogInMsg lim;
	/**
	 * Create the panel.
	 */
	public ChaKan(LogInMsg lim) {
		this.lim=lim;
		setSize(1152,446);
		setLayout(null);
		intiComponent();
	}

	/** 
	 * 初始化窗体组件 
	 */  
	private void intiComponent()    {  
		/* 
		 * 设置JTable的列名 
		 */  
		String[] columnNames =  
			{ "编号", "出库数量", "入库数量", "金额", "货物信息" };  

		/* 
		 * 初始化JTable里面各项的值 
		 */  
		Object[][] obj = new Object[1][5];  
		Object []a={1,1,1,2,"点击察看"};



		/* 
		 * JTable的其中一种构造方法 
		 */  
		model=new DefaultTableModel(obj,columnNames);
		table = new JTable(model);
		model.removeRow(0);
		model.addRow(a); 
		TableColumn column = null;  
		int colunms = table.getColumnCount();  
		for(int i = 0; i < colunms; i++)  
		{  
			column = table.getColumnModel().getColumn(i);  
			/*将每一列的默认宽度设置为100*/  
			column.setPreferredWidth(180);  
		}  
		/* 
		 * 设置JTable自动调整列表的状态，此处设置为关闭 
		 */  
		table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
		table.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent e) {

				if(table.isCellSelected(table.getSelectedRow(), table.getSelectedColumn())){
					if(table.getSelectedColumn()==4){

						scroll1.setVisible(true);
						heji.setVisible(true);
						//详细信息显示
						if(ivo==null){//为空
							JOptionPane.showConfirmDialog(null, "木有什么可以看哒","系统提示",
									JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
							return;
						}
						InventoryVO vv=ivo;
						ArrayList<CommodityGoodsVO> goodsInfo=vv.getGoodsInfo();
						for(int i=0;i<goodsInfo.size();i++){
							CommodityGoodsVO v=goodsInfo.get(i);

							Object[] aa={		v.getBarcode(),v.getAreacode(),v.getDestination(),v.getRownumber(),v.getFramenumber(),v.getPlacenumber()};
							model1.addRow(aa);
						}
					}

				}
			}
		});




		TableColumn goodColumn = table.getColumn("货物信息"); 
		DefaultTableCellRenderer fontColor = new DefaultTableCellRenderer() {   

			public void setValue(Object value) { //重写setValue方法，从而可以动态设置列单元字体颜色   
				setForeground(Color.blue ); 
				// setIcon(icon);
				Font font = new Font("微软雅黑", Font.BOLD+Font.ITALIC, 15);  

				setFont(font);
				setText((value == null) ? "" : value.toString());  

			}  
		};




		goodColumn.setCellRenderer(fontColor);  


		/*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/  
		scroll = new JScrollPane(table);  
		scroll.setLocation(20, 40);
		scroll.setSize(905, 162);  
		scroll.setVisible(false); //已开始看不见

		add(scroll);  

		JLabel label = new JLabel("库存列表");
		label.setBounds(10, 10, 103, 15);
		add(label);

		JLabel label_1 = new JLabel("起始日期");
		label_1.setBounds(105, 10, 93, 15);
		add(label_1);

		JButton button = new JButton("查询");
		button.addActionListener(new findListener() );
		button.setBounds(638, 6, 82, 23);
		add(button);

		JLabel label_2 = new JLabel("截止日期");
		label_2.setBounds(351, 10, 84, 15);
		add(label_2);
		this.setVisible(true);  



		String[] columnNames1 =  
			{ "编号",  "条形码", "区号", "目的地","排号","架号","位号" };  

		/* 
		 * 初始化JTable里面各项的值 
		 */  
		Object[][] obj1 = new Object[1][7];  



		/* 
		 * JTable的其中一种构造方法 
		 */  
		model1=new DefaultTableModel(obj1,columnNames1);
		JTable table1 = new JTable(model1);  
		model1.removeRow(0);
		/* 
		 * 设置JTable的列默认的宽度和高度 
		 */  
		TableColumn column1 = null;  
		int colunms1 = table1.getColumnCount();  
		for(int i = 0; i < colunms1; i++)  
		{  
			column1 = table1.getColumnModel().getColumn(i);  
			/*将每一列的默认宽度设置为100*/  
			column1.setPreferredWidth(200);  
		}  
		/* 
		 * 设置JTable自动调整列表的状态，此处设置为关闭 
		 */  
		table1.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  

		/*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/  
		scroll1 = new JScrollPane(table1);  
		scroll1.setLocation(20, 276);
		scroll1.setSize(1090, 170);  
		scroll1.setVisible(false); //看不见yikaishi

		add(scroll1);

		startT = new ObservingTextField();
		startT.setEditable(false);
		lblNewLabel = new JLabel("");
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
		startT.setBounds(177,10,110,28);
		add(startT);
		lblNewLabel.setBounds(297, 4, 36, 26);
		add(lblNewLabel);

		endT = new ObservingTextField();
		endT.setEditable(false);

		end = new JLabel("");
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
		endT.setBounds(420,4,110,28);
		add(endT);
		end.setBounds(573, 6, 42, 24);
		add(end);

		heji = new JPanel();
		heji.setBounds(20, 217, 792, 49);
		add(heji);
		heji.setLayout(null);

		JLabel label_3 = new JLabel("合计：");
		label_3.setBounds(10, 10, 53, 20);
		heji.add(label_3);

		JLabel label_4 = new JLabel("总入库数量");
		label_4.setBounds(47, 10, 87, 20);
		heji.add(label_4);

		inn = new JTextField();
		inn.setBounds(134, 7, 66, 28);
		heji.add(inn);
		inn.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("总出库数量");
		lblNewLabel_1.setBounds(238, 10, 75, 20);
		heji.add(lblNewLabel_1);

		outn = new JTextField();
		outn.setColumns(10);
		outn.setBounds(315, 10, 66, 28);
		heji.add(outn);

		JLabel lblNewLabel_2 = new JLabel("总金额");
		lblNewLabel_2.setBounds(419, 13, 54, 20);
		heji.add(lblNewLabel_2);

		mon = new JTextField();
		mon.setColumns(10);
		mon.setBounds(483, 10, 66, 28);
		heji.add(mon);
		heji.setVisible(false);//kanbujian
	} 
	public class findListener implements ActionListener{
		public void actionPerformed(ActionEvent arg0) {
			ResultMsg result=	spb.inputTime(startT.getText()+" "+CurrentTime.second(), endT.getText()+" "+CurrentTime.second());
			if(result.isPass()){
								ivo=spb.show(startT.getText()+" "+CurrentTime.second(), endT.getText()+" "+CurrentTime.second());
				//把上面的tabel显示一下
				scroll.setVisible(true);
				int chu=0;
				int ru=0;
				int money=0;
				
					vo=ivo;
					Object [] aaa={model.getRowCount()+1,vo.getOutNum(),vo.getInNum(),vo.getMoney(),"点击查看"};
					model.addRow(aaa);
					//算一下合计
					//出库
					chu=chu+Integer.parseInt(vo.getOutNum()	);
					ru=ru+Integer.parseInt(vo.getInNum()	);
					money=money+Integer.parseInt(vo.getMoney()	);
				
				inn.setText(ru+"");
				outn.setText(chu+"");
				mon.setText(money+"");
			}
			else{
				int result1 = JOptionPane.showConfirmDialog(null, result.getMessage(),"系统提示",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
			}

		}
	}
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		ImageIcon img = new ImageIcon("image/0111.jpg");
		g.drawImage(img.getImage(), 0, 0, null);
	}
}
