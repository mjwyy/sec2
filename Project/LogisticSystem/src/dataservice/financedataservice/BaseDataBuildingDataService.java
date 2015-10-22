package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 
 * @author River
<<<<<<< HEAD
 */
public interface BaseDataBuildingDataService extends Remote {

	/**
	 * Dataå¼€å§‹æŽ¥å—å•ä¸€å®¢æˆ·ç«¯æ“ä½œè¯·æ±‚
	 *
=======
 * ÆÚ³õ½¨ÕËµ÷ÓÃÆäËûÔöÉ¾¸Ä²éµÄ½Ó¿Ú
 * Ò»µ«¿ªÊ¼ÆÚ³õ½¨ÕË²Ù×÷£¬ÆÚ¼äData½ûÖ¹ÆäËûÓÃ»§Êý¾Ý·ÃÎÊÓëÐÞ¸Ä
 */
public interface BaseDataBuildingDataService extends Remote {
	
	/**
	 * Ç°ÖÃÌõ¼þ£ºÎÞ
	 * ºóÖÃÌõ¼þ£ºData¿ªÊ¼½ÓÊÜµ¥Ò»¿Í»§¶Ë²Ù×÷ÇëÇó
	 * @param withBase
>>>>>>> master
	 * @return
	 * @throws RemoteException
	 */
	public boolean startBaseDataBuilding(boolean withBase)
			throws RemoteException;
<<<<<<< HEAD

	/**
	 * Dataå±‚ç»“æŸå»ºè´¦ï¼Œå¹¶ä½¿ç”¨æ–°è´¦
	 *
=======
	
	/**
	 * Ç°ÖÃÌõ¼þ£º½¨ÕËµÄ¿Í»§¶ËÍê³ÉÁË½¨ÕËËùÓÐ²Ù×÷
	 * ºóÖÃÌõ¼þ£ºData²ã½áÊø½¨ÕË£¬²¢Ê¹ÓÃÐÂÕË
>>>>>>> master
	 * @return
	 * @throws RemoteException
	 */
	public boolean endBaseDataBuilding()
			throws RemoteException;
	
}
