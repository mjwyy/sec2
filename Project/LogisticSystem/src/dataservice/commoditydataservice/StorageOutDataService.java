/**
 * ���⴦�����ݽӿ�
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.commoditydataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.StorageOutPO;

public interface StorageOutDataService {
	/**
	 * ǰ��������ͬ��ID��po��Mapper�в�����
	 * ���������������ݿ�������һ��po��¼
	 * @param po ���po
	 */
	public void insert(StorageOutPO po) throws RemoteException;
	/**
	 * ǰ��������ͬ��ID��po��Mapper�д���
	 * ���������������ݿ���ɾ��һ��po��¼
	 * @param po ���po
	 */
	public void delete(StorageOutPO po) throws RemoteException;
	/**
	 * ǰ��������ͬ��ID��po��Mapper�д���
	 * ���������������ݿ��и���һ��po��¼
	 * @param po ���po
	 */
	public void update(StorageOutPO po) throws RemoteException;
	/**
	 * ǰ����������
	 * ���������������ֽ��в��ҷ�����Ӧ��StorageOutPOPO���
	 * @param name �������
	 * @return StorageOutPO ���PO
	 */
	public StorageOutPO findByName(String name) throws RemoteException;
	/**
	 * ǰ����������
	 * ������������ID���в��ҷ�����Ӧ��PO���
	 * @param ID ���ID
	 * @return StorageOutPO ���PO
	 */
	public StorageOutPO findById(String id) throws RemoteException;
	
	/**
	 * ǰ����������
	 * �����������������еĿ��PO
	 * @return StorageOutPO ���PO
	 */
	public ArrayList<StorageOutPO> show() throws RemoteException;
}
