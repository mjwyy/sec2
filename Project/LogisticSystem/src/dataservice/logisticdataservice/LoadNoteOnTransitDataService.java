/**
 * ¼����ת����װ�������ݽӿ�
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.logisticdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.LoadNoteOnTransitPO;

public interface LoadNoteOnTransitDataService {
	/**
	 * ǰ��������ͬ��ID��po��Mapper�в�����
	 * ���������������ݿ�������һ��po��¼
	 * @param po ���po
	 */
	public void insert(LoadNoteOnTransitPO po) throws RemoteException;
	/**
	 * ǰ��������ͬ��ID��po��Mapper�д���
	 * ���������������ݿ���ɾ��һ��po��¼
	 * @param po ���po
	 */
	public void delete(LoadNoteOnTransitPO po) throws RemoteException;
	/**
	 * ǰ��������ͬ��ID��po��Mapper�д���
	 * ���������������ݿ��и���һ��po��¼
	 * @param po ���po
	 */
	public void update(LoadNoteOnTransitPO po) throws RemoteException;
	/**
	 * ǰ����������
	 * ���������������ֽ��в��ҷ�����Ӧ��LoadNoteOnTransitPO���
	 * @param name �������
	 * @return LoadNoteOnTransitPO ���PO
	 */
	public LoadNoteOnTransitPO findByName(String name) throws RemoteException;
	/**
	 * ǰ����������
	 * ������������ID���в��ҷ�����Ӧ��NotePO���
	 * @param ID ���ID
	 * @return LoadNoteOnTransitPO ���PO
	 */
	public LoadNoteOnTransitPO findById(String id) throws RemoteException;
	
	/**
	 * ǰ����������
	 * �����������������еĿ��PO
	 * @return LoadNoteOnTransitPO ���PO
	 */
	public ArrayList<LoadNoteOnTransitPO> show() throws RemoteException;
}
