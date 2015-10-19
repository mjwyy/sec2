/**
 * ��⴦�����ݽӿ�
 * @author wqy
 * @date 2015/10/17
 */



package dataservice.commoditydataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.StorageInPO;

public interface StorageInDataService {
	/**
	 * ǰ��������ͬ��ID��po��Mapper�в�����
	 * ���������������ݿ�������һ��po��¼
	 * @param po ���po
	 */
	public void insert(StorageInPO po) throws RemoteException;
	/**
	 * ǰ��������ͬ��ID��po��Mapper�д���
	 * ���������������ݿ���ɾ��һ��po��¼
	 * @param po ���po
	 */
	public void delete(StorageInPO po) throws RemoteException;
	/**
	 * ǰ��������ͬ��ID��po��Mapper�д���
	 * ���������������ݿ��и���һ��po��¼
	 * @param po ���po
	 */
	public void update(StorageInPO po) throws RemoteException;
	/**
	 * ǰ����������
	 * ���������������ֽ��в��ҷ�����Ӧ��StorageInPOPO���
	 * @param name �������
	 * @return StorageInPOPO ���PO
	 */
	public StorageInPO findByName(String name) throws RemoteException;
	/**
	 * ǰ����������
	 * ������������ID���в��ҷ�����Ӧ��PO���
	 * @param ID ���ID
	 * @return StorageInPO ���PO
	 */
	public StorageInPO findById(String id) throws RemoteException;
	
	/**
	 * ǰ����������
	 * �����������������еĿ��PO
	 * @return StorageInPO ���PO
	 */
	public ArrayList<StorageInPO> show() throws RemoteException;

}
