/**
 * 审批通过后清空所有textfield
 * 
 * @author wqy
 *
 */
package presentation.util;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class CleanTextField {
	public static void clean(JPanel panel){
		int count = panel.getComponentCount();
		for (int i = 0; i < count; i++) {  
		Object obj=panel.getComponent(i);
		if(obj instanceof JTextField){
			((JTextField) obj).setText("");
		}
			}
		}
}
