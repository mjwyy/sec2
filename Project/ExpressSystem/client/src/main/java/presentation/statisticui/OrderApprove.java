package presentation.statisticui;

/**
 * 审批单据主界面
 * 
 * @author wqy
 *
 */
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTextField;

public class OrderApprove extends JPanel {
	private JTable table;
	private DefaultTableModel model;
	private JTextField textField;
	/**
	 * Create the panel.
	 */
	public OrderApprove() {
setSize(1142,446);

String[] columnNames =  
{ "序号", "审批状态", "单据类型", "单据编号", "生成时间","选择" };  

/* 
 * 初始化JTable里面各项的值 
 */  
Object[][] obj = new Object[1][6];  
for (int i = 0; i < 1; i++)  
{  
    for (int j = 0; j < 6; j++)  
    {  
        switch (j)  
        {  
        case 0:  
            obj[i][j] = "1";  
            break;  
        case 1:  
            obj[i][j] = "待审核";  
            break;  
        case 2:  
            obj[i][j] = "中转单";  
            break;  
        case 3:  
            obj[i][j] = "2011-11-11";  
            break;  
        case 4:  
            obj[i][j] = "8888";  
            break;  
        
        }  
    }  
}  
  
  
/* 
 * JTable的其中一种构造方法 
 */  
model=new DefaultTableModel(obj,columnNames);
table = new JTable(model);
table.addMouseListener(new MouseAdapter() {
	public void mouseClicked(MouseEvent arg0) {
	int selectedRow= table.getSelectedRow();
	Object oa=model.getValueAt(selectedRow, 0);
	//codef.setText(oa.toString());
	Object ob=model.getValueAt(selectedRow, 1);
	//dataf.setText(ob.toString());
	Object oc=model.getValueAt(selectedRow, 2);
	//tof.setText(oc.toString());
	Object od=model.getValueAt(selectedRow, 3);
	//areaf.setText(od.toString());
	Object oe=model.getValueAt(selectedRow, 4);
	//rowf.setText(oe.toString());
	Object of=model.getValueAt(selectedRow, 5);
	//jiahaof.setText(of.toString());
//	Object og=model.getValueAt(selectedRow, 6);
	//weihaof.setText(og.toString());
	}
});
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
setLayout(null);
table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);  
  
/*用JScrollPane装载JTable，这样超出范围的列就可以通过滚动条来查看*/  
JScrollPane scroll = new JScrollPane(table);
scroll.setBounds(182, 116, 494, 252);
  
  
add(scroll);
JButton button = new JButton("查看详细");
button.setBounds(342, 378, 103, 23);
add(button);
JButton btnNewButton = new JButton("审批通过");
btnNewButton.setBounds(465, 378, 93, 23);
add(btnNewButton);
JButton button_1 = new JButton("审批不通过");
button_1.setBounds(597, 378, 135, 23);
add(button_1);
JLabel label = new JLabel("单据列表");
label.setBounds(185, 24, 83, 15);
add(label);
JButton button_2 = new JButton("待审批单据");
button_2.setBounds(357, 20, 122, 23);
add(button_2);
JButton button_3 = new JButton("已通过单据");
button_3.setBounds(501, 15, 103, 32);
add(button_3);
JButton button_4 = new JButton("未通过单据");
button_4.setBounds(614, 20, 108, 23);
add(button_4);
JLabel label_1 = new JLabel("筛选类型");
label_1.setBounds(186, 91, 54, 15);
add(label_1);
JComboBox comboBox = new JComboBox();
comboBox.setModel(new DefaultComboBoxModel(new String[] {"所有", "中转单", "到达单", "装车单", "派送单"}));
comboBox.setBounds(250, 88, 83, 21);
add(comboBox);
textField = new JTextField();
textField.setBounds(379, 85, 66, 21);
add(textField);
textField.setColumns(10);
JButton button_5 = new JButton("查询");
button_5.setBounds(465, 83, 93, 23);
add(button_5);


	}
}
