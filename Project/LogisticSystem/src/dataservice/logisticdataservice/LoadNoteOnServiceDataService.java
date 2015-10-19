/**
 * ¼��Ӫҵ��װ�������ݽӿ�
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.logisticdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LoadNoteOnServicePO;

public interface LoadNoteOnServiceDataService {
	/**
	 * ǰ��������ͬ��ID��po��Mapper�в�����
	 * ���������������ݿ�������һ��po��¼
	 * @param po ���po
	 */
	public void insert(LoadNoteOnServicePO po) throws RemoteException;
	/**
	 * ǰ��������ͬ��ID��po��Mapper�д���
	 * ���������������ݿ���ɾ��һ��po��¼
	 * @param po ���po
	 */
	public void delete(LoadNoteOnServicePO po) throws RemoteException;
	/**
	 * ǰ��������ͬ��ID��po��Mapper�д���
	 * ���������������ݿ��и���һ��po��¼
	 * @param po ���po
	 */
	public void update(LoadNoteOnServicePO po) throws RemoteException;
	/**
	 * ǰ����������
	 * ���������������ֽ��в��ҷ�����Ӧ��LoadNoteOnServicePO���
	 * @param name �������
	 * @return LoadNoteOnServicePO ���PO
	 */
	public LoadNoteOnServicePO findByName(String name) throws RemoteException;
	/**
	 * ǰ����������
	 * ������������ID���в��ҷ�����Ӧ��LoadNoteOnServicePO���
	 * @param ID ���ID
	 * @return LoadNoteOnServicePO ���PO
	 */
	public LoadNoteOnServicePO findById(String id) throws RemoteException;
	
	/**
	 * ǰ����������
	 * �����������������еĿ��PO
	 * @return LoadNoteOnServicePO ���PO
	 */
	public ArrayList<LoadNoteOnServicePO> show() throws RemoteException;
}
