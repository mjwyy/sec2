/**
 * ������ݽӿ�
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.commoditydataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.InventoryPO;

public interface InventoryDataService {
	/**
	 * ǰ��������ͬ��ID��po��Mapper�в�����
	 * ���������������ݿ�������һ��po��¼
	 * @param po ���po
	 */
	public void insert(InventoryPO po) throws RemoteException;
	/**
	 * ǰ��������ͬ��ID��po��Mapper�д���
	 * ���������������ݿ���ɾ��һ��po��¼
	 * @param po ���po
	 */
	public void delete(InventoryPO po) throws RemoteException;
	/**
	 * ǰ��������ͬ��ID��po��Mapper�д���
	 * ���������������ݿ��и���һ��po��¼
	 * @param po ���po
	 */
	public void update(InventoryPO po) throws RemoteException;
	/**
	 * ǰ����������
	 * ���������������ֽ��в��ҷ�����Ӧ��InventoryPO���
	 * @param name �������
	 * @return InventoryPO ���PO
	 */
	public InventoryPO findByName(String name) throws RemoteException;
	/**
	 * ǰ����������
	 * ������������ID���в��ҷ�����Ӧ��PO���
	 * @param ID ���ID
	 * @return InventoryPO ���PO
	 */
	public InventoryPO findById(String id) throws RemoteException;
	
	/**
	 * ǰ����������
	 * �����������������еĿ��PO
	 * @return StorageInPO ���PO
	 */
	public ArrayList<InventoryPO> show() throws RemoteException;

}
