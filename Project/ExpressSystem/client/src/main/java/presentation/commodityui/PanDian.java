/**
 * 库存盘点界面
 * 
 * @author wqy
 *
 */
package presentation.commodityui;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import businesslogic.commodity.StorageExport;
import businesslogic.commodity.StorageInquiryAll;
import businesslogicservice.commodityblservice.StorageInquiryAllBLService;
import businesslogicservice.commodityblservice._Stub.StorageInquiryAllBLService_Stub;
import presentation.util.MyJFileChooser;
import util.ResultMsg;
import vo.CommodityGoodsVO;
import vo.InventoryVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.util.ArrayList;

import presentation.util.CurrentTime;
public class PanDian extends JPanel {
//	StorageInquiryAllBLService sab=new StorageInquiryAllBLService_Stub();
	StorageInquiryAllBLService sab=new StorageInquiryAll();
private JFrame frame;
private DefaultTableModel model;
private JTable table;
private InventoryVO inventory=null;
private boolean isnull=true;
	/**
	 * Create the panel.
	 */
	public PanDian(JFrame frame) {
		this.frame=frame;
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
	        { "批次批号","快递编号","入库日期","目的地","区号","排号","架号","位号"};  
	  
	        /* 
	         * 初始化JTable里面各项的值 
	         */  
	        Object[][] obj = new Object[1][8];  
 
	          
	          
	        /* 
	         * JTable的其中一种构造方法 
	         */  
	        model=new DefaultTableModel(obj,columnNames);
			table = new JTable(model);
			model.removeRow(0); 
	        /* 
	         * 设置JTable的列默认的宽度和高度 
	         */  
	        TableColumn column = null;  
	        int colunms = table.getColumnCount();  
	        for(int i = 0; i < colunms; i++)  
	        {  
	            column = table.getColumnModel().getColumn(i);  
	            column.setPreferredWidth(200);  
	        }  
	        /* 
	         * 设置JTable自动调整列表的状态，此处设置为关闭 
	         */  
	        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
	          
	        /*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/  
	        JScrollPane scroll = new JScrollPane(table);  
	        scroll.setLocation(10, 40);
	        scroll.setSize(1095, 272);  
	          
	          
	        add(scroll);  
	        
	        JLabel label = new JLabel("库存盘点");
	        label.setBounds(10, 10, 103, 15);
	        add(label);
	        
	        JButton btnNewButton_3 = new JButton("生成库存快照");
	        btnNewButton_3.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		try {
	        			//当天的库存快照，时间为当天
	        			//批次（日期）批号（序号）,
	        			//快递编号、入库日期、目的地、区号、排号、架号、位号
						inventory=sab.request();
						isnull=false;
						ArrayList<CommodityGoodsVO> goodsInfo=inventory.getGoodsInfo();
						
						if(goodsInfo.size()==0){
							JOptionPane.showMessageDialog(null, "暂时木有库存哦~");
							return ;
						}
						for(int i=0;i<goodsInfo.size();i++){
							CommodityGoodsVO v=goodsInfo.get(i);

							Object[] aa={CurrentTime.getCurrentTimeDateSimple()+"000"+i,v.getBarcode(),CurrentTime.getCurrentTimeDate(),
									v.getDestination(),v.getAreacode(),
									v.getRownumber(),v.getFramenumber(),v.getPlacenumber()};
							model.addRow(aa);
						}
					} catch (Exception e) {
						//第一次库存盘点的时间
						String firstTime=JOptionPane.showInputDialog("请输入初次盘点时间");
					sab.inputFirst(firstTime);
						e.printStackTrace();
					}
	        	
	        	}
	        });
	        btnNewButton_3.setBounds(357, 7, 121, 23);
	        add(btnNewButton_3);
	        
	        JButton btnexcel = new JButton("导出excel");
	        btnexcel.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent arg0) {
	        		if(isnull){
	        			JOptionPane.showMessageDialog(null, "请先库存盘点哦~");
	        			return;
	        		}
	        	MyJFileChooser mfc=new MyJFileChooser();
	        	if(mfc.showSaveDialog(PanDian.this)== JFileChooser.APPROVE_OPTION){
	        		String filename=mfc.getSelectedFile().getAbsolutePath();
	        		System.out.println(filename);
	        		
	        		StorageExport  sse=new StorageExport();
	        		
	        			try {
							sse.exportTo(inventory,filename);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
	        		
	        		
	        	}
	        	}
	        });
	        btnexcel.setBounds(521, 6, 93, 23);
	        add(btnexcel);
	        this.setVisible(true);  
	        
	    }  
	    public void paintComponent(Graphics g) {
			 super.paintComponents(g);
			 ImageIcon img = new ImageIcon("image/0111.jpg");
			 g.drawImage(img.getImage(), 0, 0, null);
			}
	
}
