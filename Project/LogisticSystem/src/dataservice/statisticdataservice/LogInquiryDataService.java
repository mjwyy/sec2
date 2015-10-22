package dataservice.statisticdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LogEntryPO;

public interface LogInquiryDataService extends Remote {

	/**
<<<<<<< HEAD
	 * Dataå±‚æ ¹æ®æ—¶é—´ã€å…³é”®è¯æŸ¥è¯¢Logï¼Œè¿”å›žç›¸å…³æ¡ç›®
	 *
=======
	 * Ç°ÖÃÌõ¼þ£ºÎÞ
	 * ºóÖÃÌõ¼þ£ºData²ã¸ù¾ÝÊ±¼ä¡¢¹Ø¼ü´Ê²éÑ¯Log£¬·µ»ØÏà¹ØÌõÄ¿
>>>>>>> master
	 * @param time
	 * @param keyword
	 * @return
	 * @throws RemoteException
	 */
	public ArrayList<LogEntryPO> findLogEntries(String time,ArrayList<String> keyword)
		throws RemoteException;
	
}
