package presentation.financeui;

import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import presentation.util.ObservingTextField;

import com.qt.datapicker.DatePicker;

import businesslogic.statistic.LogInquiry;
import businesslogicservice.statisticblservice.LogInquiryBLService;
import util.ResultMsg;
import vo.SystemLogVO;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SystemLogPanel extends JPanel {

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
	private ObservingTextField date;
	private JTextField content;
	private JTable table;
	private DefaultTableModel model;
	private Vector name;
	private Vector data;
	private SystemLogVO vo;
	private ResultMsg res;
	private LogInquiryBLService service = new LogInquiry();
	private JLabel end;
	public  SystemLogPanel() {
		setSize(WIDTH,HEIGHT);
		setLayout(null);
		
		JLabel label = new JLabel("日志时间");
		label.setBounds(81, 55, 61, 16);
		add(label);
		
		date = new ObservingTextField();
		date.setBounds(159, 49, 134, 28);
		add(date);
		date.setColumns(10);
		
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
				DatePicker dp = new DatePicker(date, Locale.CHINA);
				// previously selected date
				Date selectedDate = dp.parseDate(date.getText());
				dp.setSelectedDate(selectedDate);
				dp.start(date);	
			}
		});
		end.setBounds(307, 49, 36, 26);
		add(end);
		
		JLabel label_1 = new JLabel("内容关键字");
		label_1.setBounds(374, 55, 88, 16);
		add(label_1);
		
		content = new JTextField();
		content.setBounds(470, 49, 272, 28);
		add(content);
		content.setColumns(10);
		
		name = new Vector();
		name.add("时间");
		name.add("内容");
		data = new Vector();
		model = new DefaultTableModel();
		model.setDataVector(data,name);
		table = new JTable(model);
		table.setBounds(65, 120, 1001, 307);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(65, 120, 1001, 307);
		add(scrollPane);
		
		JButton btnNewButton = new JButton("查询");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//查询时间 和 内容 是否可以为空
				
				if(date.getText().isEmpty()||content.getText().isEmpty()){
					int result1 = JOptionPane.showConfirmDialog(null, "请填写完整查询关键字","系统提示",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
				}	
				else{	
				vo = new SystemLogVO(date.getText(),content.getText());
		        res = service.inputKeywords(vo);
		        if(res.isPass()){
		        	ArrayList<SystemLogVO> systemVO = new ArrayList<SystemLogVO>();
		        	systemVO = service.getLogInfo(vo);
		        	for(int i = 0;i<systemVO.size();i++){
		        		Vector row = new Vector();
		        		row.add(systemVO.get(i).getTime());
		        		row.add(systemVO.get(i).getContent());
		        		data.add(row.clone());
		        		model.setDataVector(data, name);
		        		table.setModel(model);
		        	}
		        }else{
		        	int result1 = JOptionPane.showConfirmDialog(null, res.getMessage(),"系统提示",
							JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
		        }
				
			}
			}
		});
		btnNewButton.setBounds(899, 50, 125, 43);
		add(btnNewButton);
		
	
	

	}
}
