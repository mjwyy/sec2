package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.IncomeNotePO;

public interface SettlementManagementDataService extends Remote {
	/**
<<<<<<< HEAD
	 * Dataå±‚å¢žåŠ æ”¶æ¬¾å•è®°å½•ï¼Œä¿®æ”¹å¯¹åº”è´¦æˆ·ä¿¡æ¯
	 *
=======
	 * Ç°ÖÃÌõ¼þ£ºIncomeNotePOÒÑ¾­¾­¹ý¼ì²é£¬¸ñÊ½ÎÞÎó
	 * ºóÖÃÌõ¼þ£ºData²ãÔö¼ÓÊÕ¿îµ¥¼ÇÂ¼£¬ÐÞ¸Ä¶ÔÓ¦ÕË»§ÐÅÏ¢
>>>>>>> master
	 * @return
	 * @throws RemoteException
	 */
	public boolean addIncomeNote(IncomeNotePO note) 
			throws RemoteException;
}
