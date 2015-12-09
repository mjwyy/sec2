package presentation.util;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class EditableTrue {
	public static void Edit(JPanel panel){
		int count = panel.getComponentCount();
		for (int i = 0; i < count; i++) {  
		Object obj=panel.getComponent(i);
		if(obj instanceof JTextField){
			((JTextField) obj).setEditable(true);
			((JTextField) obj).setEnabled(true);
		}
			}
		}

}
