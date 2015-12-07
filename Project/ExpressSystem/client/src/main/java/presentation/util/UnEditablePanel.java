//让panel里的textfiled都不能动的类
package presentation.util;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class UnEditablePanel {
	public static void UnEdit(JPanel panel){
	int count = panel.getComponentCount();
	for (int i = 0; i < count; i++) {  
	Object obj=panel.getComponent(i);
	if(obj instanceof JTextField){
		((JTextField) obj).setEditable(false);
		((JTextField) obj).setEnabled(false);
	}
		}
	}
	}
