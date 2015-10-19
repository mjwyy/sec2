/**
 * ������ת�����ݽӿ�
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.logisticdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.TransitNoteInputPO;

public interface TransitNoteInputDataService {
	/**
	 * ǰ��������ͬ��ID��po��Mapper�в�����
	 * ���������������ݿ�������һ��po��¼
	 * @param po ���po
	 */
	public void insert(TransitNoteInputPO po) throws RemoteException;
	/**
	 * ǰ��������ͬ��ID��po��Mapper�д���
	 * ���������������ݿ���ɾ��һ��po��¼
	 * @param po ���po
	 */
	public void delete(TransitNoteInputPO po) throws RemoteException;
	/**
	 * ǰ��������ͬ��ID��po��Mapper�д���
	 * ���������������ݿ��и���һ��po��¼
	 * @param po ���po
	 */
	public void update(TransitNoteInputPO po) throws RemoteException;
	/**
	 * ǰ����������
	 * ���������������ֽ��в��ҷ�����Ӧ��NotePO���
	 * @param name �������
	 * @return TransitNoteInputPO ���PO
	 */
	public TransitNoteInputPO findByName(String name) throws RemoteException;
	/**
	 * ǰ����������
	 * ������������ID���в��ҷ�����Ӧ��TransitNoteInputPO���
	 * @param ID ���ID
	 * @return TransitNoteInputPO ���PO
	 */
	public TransitNoteInputPO findById(String id) throws RemoteException;
	
	/**
	 * ǰ����������
	 * �����������������еĿ��PO
	 * @return TransitNoteInputPO ���PO
	 */
	public ArrayList<TransitNoteInputPO> show() throws RemoteException;
}
