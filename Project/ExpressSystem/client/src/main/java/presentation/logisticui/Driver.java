package presentation.logisticui;

import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JSplitPane;
import javax.swing.table.TableColumn;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Driver extends JPanel {
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Driver() {
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
	        { "司机编号", "姓名", "性别", "出生日期", "身份证号","手机" ,"行驶证期限"};  
	  
	        /* 
	         * 初始化JTable里面各项的值 
	         */  
	        Object[][] obj = new Object[1][7];  
	        for (int i = 0; i < 1; i++)  
	        {  
	            for (int j = 0; j < 7; j++)  
	            {  
	                switch (j)  
	                {  
	                case 0:  
	                    obj[i][j] = "001";  
	                    break;  
	                case 1:  
	                    obj[i][j] = "王翔翔";  
	                    break;  
	                case 2:  
	                    obj[i][j] = "男";  
	                    break;  
	                case 3:  
	                    obj[i][j] = "2011-11-11";  
	                    break;  
	                case 4:  
	                    obj[i][j] = "32088888888";  
	                    break;  
	                case 5:  
	                    obj[i][j] = "1388888";  
	                    break;  
	                case 6:  
	                    obj[i][j] = "88";  
	                    break; 
	                }  
	            }  
	        }  
	          
	          
	        /* 
	         * JTable的其中一种构造方法 
	         */  
	        JTable table = new JTable(obj, columnNames);  
	        /* 
	         * 设置JTable的列默认的宽度和高度 
	         */  
	        TableColumn column = null;  
	        int colunms = table.getColumnCount();  
	        for(int i = 0; i < colunms; i++)  
	        {  
	            column = table.getColumnModel().getColumn(i);  
	            /*将每一列的默认宽度设置为100*/  
	            column.setPreferredWidth(100);  
	        }  
	        /* 
	         * 设置JTable自动调整列表的状态，此处设置为关闭 
	         */  
	        table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
	          
	        /*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/  
	        JScrollPane scroll = new JScrollPane(table);  
	        scroll.setLocation(0, 40);
	        scroll.setSize(810, 272);  
	          
	          
	        add(scroll);  
	        
	        JLabel label = new JLabel("司机信息管理");
	        label.setBounds(10, 10, 103, 15);
	        add(label);
	        
	        JLabel label_1 = new JLabel("关键字类型");
	        label_1.setBounds(105, 10, 93, 15);
	        add(label_1);
	        
	        JComboBox comboBox = new JComboBox();
	        comboBox.setBounds(193, 7, 84, 21);
	        add(comboBox);
	        
	        textField = new JTextField();
	        textField.setText("请输入关键字");
	        textField.setBounds(287, 9, 117, 28);
	        add(textField);
	        textField.setColumns(10);
	        
	        JButton button = new JButton("查询");
	        button.setBounds(414, 6, 63, 23);
	        add(button);
	        
	        JButton btnNewButton = new JButton("新增");
	        btnNewButton.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Tempo a=new Tempo();
	        		a.add();
	        		a.setVisible(true);
	        	}
	        });
	        btnNewButton.setBounds(500, 6, 70, 23);
	        add(btnNewButton);
	        
	        JButton btnNewButton_1 = new JButton("删除");
	        btnNewButton_1.setBounds(592, 6, 70, 23);
	        add(btnNewButton_1);
	        
	        JButton btnNewButton_2 = new JButton("修改");
	        btnNewButton_2.addActionListener(new ActionListener() {
	        	public void actionPerformed(ActionEvent e) {
	        		Tempo a=new Tempo();
	        		a.modify();;
	        		a.setVisible(true);
	        	}
	        });
	        btnNewButton_2.setBounds(685, 6, 70, 23);
	        add(btnNewButton_2);
	        this.setVisible(true);  
	        
	    }  
	    public void paintComponent(Graphics g) {
			 super.paintComponents(g);
			 ImageIcon img = new ImageIcon("C:\\Users\\Administrator\\Desktop\\0011.jpg");
			 g.drawImage(img.getImage(), 0, 0, null);
			}
}
