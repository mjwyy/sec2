package presentation.financeui;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

public class BaseDataBuildingPanel extends JPanel {

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
	public BaseDataBuildingPanel() {
		setSize(WIDTH,HEIGHT);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("o_o请点击右上角的建账项目菜单，选择对机构、银行账户、\n");
		lblNewLabel.setBounds(68, 46, 433, 49);
		add(lblNewLabel);
		
		JLabel label = new JLabel("车辆进行建账信息，建账完毕请点击结束建账按钮> _<\n\n\n\n");
		label.setBounds(68, 107, 624, 16);
		add(label);
		
		

	}
}
