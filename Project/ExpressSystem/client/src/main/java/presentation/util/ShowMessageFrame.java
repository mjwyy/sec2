//自定义弹出的无边提醒框（可自动消失） 
package presentation.util;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.WindowConstants;

public class ShowMessageFrame extends JFrame {
    private JLabel text;
    Toolkit tk = Toolkit.getDefaultToolkit();
    Dimension screensize = tk.getScreenSize();
    int height = screensize.height;
    int width = screensize.width;
    private String str = null;

    public ShowMessageFrame(String str) {
        this.str = str;
        new Thread(new Runnable() {
            @Override
            public void run() {
                initGUI();
            }
        }).start();
    }

    private void initGUI() {
        try {
            setUndecorated(true);
            this.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
            setLocationRelativeTo(null);
            setVisible(true);
            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            {
                text = new JLabel(  str , JLabel.CENTER);
                getContentPane().add(text, BorderLayout.CENTER);
                text.setBackground(new java.awt.Color(255, 251, 240));
            }
            pack();
            setBounds(width / 2 - 180, height - 150, 360, 100);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e1) {
                e1.printStackTrace();
            }
            dispose();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}