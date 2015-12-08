//左下角的panel
package presentation.util;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

public class LeftDownPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public LeftDownPanel() {
setSize(939,124);
setLayout(null);
JLabel lblNewLabel = new JLabel("您提交的单据正在等待审批哦，请耐心等待哦~");
lblNewLabel.setBounds(289, 5, 599, 57);
add(lblNewLabel);
setVisible(true);
	}

}
