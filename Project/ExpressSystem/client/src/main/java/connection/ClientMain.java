package connection;

import presentation.mainui.loginFrame;

import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.UIManager;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

/**
 * Created by kylin on 15/11/21.
 */
public class ClientMain {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        RMIHelper.tryConnect();
        changeFont();
        changeLook();
        
         loginFrame frame = new loginFrame();
       // frame.setAlwaysOnTop(true);          // 置顶
     // 双击置顶/取消置顶
//        frame.addMouseListener(new MouseAdapter() {
//            public void mouseClicked(MouseEvent e) {
//                if (e.getClickCount() == 2) {
//                    frame.setAlwaysOnTop(!frame.isAlwaysOnTop());
//                }
//            }
//        });
//    
        frame.setIconImage(Toolkit.getDefaultToolkit().getImage("image/0010.jpg"));
//        StorageInBLService ser = new StorageIn();
        

    }
    /**
	 * 更改外观
	 */
	public static void changeLook() {
		try {
			BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.FrameBorderStyle.translucencySmallShadow;
			org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
			// 关闭右上角设置
			UIManager.put("RootPane.setupButtonVisible", false);
		} catch(Exception e) {
		}
	}
	/**
	 * 更改默认字体
	 */
	public static void changeFont() {
		Font font = new Font("微软雅黑", Font.PLAIN, 15);   
		@SuppressWarnings("rawtypes")
		java.util.Enumeration keys = UIManager.getDefaults().keys();   
		while (keys.hasMoreElements()) {
			Object key = keys.nextElement();   
			Object value = UIManager.get(key);    
			if (value instanceof javax.swing.plaf.FontUIResource) {
				UIManager.put(key, font);     
			} 
		} 
	}
}
