package dataservice.statisticdataservice;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Iterator;

import dataservice.exception.ElementNotFoundException;
import po.*;

/**
 * 单据审批DataService
 * @author River
 *
 */
public interface NoteApprovingDataService extends Remote, Serializable {
	
	ArrayList<ArrivalNoteOnServicePO> getArrivalNoteOnServicePO()
            throws RemoteException;
    
	ArrayList<DeliverNoteOnServicePO> getDeliverNoteOnServicePO()
            throws RemoteException;

	Iterator<ArrivalNoteOnTransitPO> getArrivalNoteOnTransitPO()
            throws RemoteException;

	ArrayList<DeliveryNotePO> getDeliveryNotePO()
            throws RemoteException;

	ArrayList<LoadNoteOnServicePO> getLoadNoteOnServicePO()
            throws RemoteException;

	ArrayList<LoadNoteOnTransitPO> getLoadNoteOnTransitPO()
            throws RemoteException;

	ArrayList<ReceivingNotePO> getReceivingNotePO()
            throws RemoteException;

	ArrayList<TransitNotePO> getTransitNotePO()
            throws RemoteException;
	
	/**
	 * 搜索docPO并通过之
	 *
	 * @param docPO
	 * @return true for successful pass operation
	 */
	boolean passDoc(NotePO docPO)
            throws RemoteException, ElementNotFoundException;

    /**
	 * 搜索docPO并且否决之
	 *
	 * @param docPO
	 * @return true for successful decline operation
	 */
	boolean failDoc(NotePO docPO, String comment)
            throws RemoteException, ElementNotFoundException;
}
