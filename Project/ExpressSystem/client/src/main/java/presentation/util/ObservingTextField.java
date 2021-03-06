package presentation.util;

import java.util.Calendar;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JTextField;
import com.qt.datapicker.DatePicker;

public class ObservingTextField extends JTextField implements Observer {
    public void update(Observable o, Object arg) {
        Calendar calendar = (Calendar) arg;
        DatePicker dp = (DatePicker) o;
        dp.formatDate(calendar, "yyyy-MM-dd");
        
        setText(dp.formatDate(calendar,"yyyy-MM-dd"));
    }
}
