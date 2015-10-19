/**
 * ����ļ�����Ϣ���ݽӿ�
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.logisticdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.DeliveryNoteInputPO;

public interface DeliveryNoteInputDataService {
	/**
	 * ǰ��������ͬ��ID��po��Mapper�в�����
	 * ���������������ݿ�������һ��po��¼
	 * @param po ���po
	 */
	public void insert(DeliveryNoteInputPO po) throws RemoteException;
	/**
	 * ǰ��������ͬ��ID��po��Mapper�д���
	 * ���������������ݿ���ɾ��һ��po��¼
	 * @param po ���po
	 */
	public void delete(DeliveryNoteInputPO po) throws RemoteException;
	/**
	 * ǰ��������ͬ��ID��po��Mapper�д���
	 * ���������������ݿ��и���һ��po��¼
	 * @param po ���po
	 */
	public void update(DeliveryNoteInputPO po) throws RemoteException;
	/**
	 * ǰ����������
	 * ���������������ֽ��в��ҷ�����Ӧ��DeliveryNoteInputPO���
	 * @param name �������
	 * @return DeliveryNoteInputPO ���PO
	 */
	public DeliveryNoteInputPO findByName(String name) throws RemoteException;
	/**
	 * ǰ����������
	 * ������������ID���в��ҷ�����Ӧ��DeliveryNoteInputPO���
	 * @param ID ���ID
	 * @return DeliveryNoteInputPO ���PO
	 */
	public DeliveryNoteInputPO findById(String id) throws RemoteException;
	
	/**
	 * ǰ����������
	 * �����������������еĿ��PO
	 * @return DeliveryNoteInputPO ���PO
	 */
	public ArrayList<DeliveryNoteInputPO> show() throws RemoteException;
}
