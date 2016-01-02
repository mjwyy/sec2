package connection;

import javax.swing.JOptionPane;

public class ConnectionChecker extends Thread {

	private Object getter;
	private static String objName = "DisconnectionCheckerObj";
	
	@Override
	public void run() {
		super.run();

		Thread thisThread = Thread.currentThread();
		blinker = thisThread;		
		
		while(true) {
			
			//Check every 5 seconds.
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			if (thisThread==blinker) {
				try {
					getter = RMIHelper.getRemoteObj(objName);
					if (getter == null)
						throw new Exception();
				} catch (Exception e) {
					e.printStackTrace();
					showDisconnectedPane();
					break;
				}
			}

		}
	}
	
	private volatile Thread blinker;

    public void stopMe() {
        blinker = null;
    }

	private void showDisconnectedPane() {
		//TODO 显示具有断线信息的对话框，最好上面的按钮会关闭当前窗口
		JOptionPane.showConfirmDialog(null,"断线啦","系统提示",
				JOptionPane.OK_OPTION,JOptionPane.QUESTION_MESSAGE);
		System.out.println("Disconnection detected! Showing dialog...");
		this.stopMe();
	}
	
}
