/**
 * ����ļ�����Ϣ���ݽӿ�
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.logisticdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ReceivingNoteInputPO;

public interface ReceivingNoteInputDataService {
	/**
	 * ǰ��������ͬ��ID��po��Mapper�в�����
	 * ���������������ݿ�������һ��po��¼
	 * @param po ���po
	 */
	public void insert(ReceivingNoteInputPO po) throws RemoteException;
	/**
	 * ǰ��������ͬ��ID��po��Mapper�д���
	 * ���������������ݿ���ɾ��һ��po��¼
	 * @param po ���po
	 */
	public void delete(ReceivingNoteInputPO po) throws RemoteException;
	/**
	 * ǰ��������ͬ��ID��po��Mapper�д���
	 * ���������������ݿ��и���һ��po��¼
	 * @param po ���po
	 */
	public void update(ReceivingNoteInputPO po) throws RemoteException;
	/**
	 * ǰ����������
	 * ���������������ֽ��в��ҷ�����Ӧ��ReceivingNoteInputPO���
	 * @param name �������
	 * @return NotePO ���PO
	 */
	public ReceivingNoteInputPO findByName(String name) throws RemoteException;
	/**
	 * ǰ����������
	 * ������������ID���в��ҷ�����Ӧ��ReceivingNoteInputPO���
	 * @param ID ���ID
	 * @return ReceivingNoteInputPO ���PO
	 */
	public ReceivingNoteInputPO findById(String id) throws RemoteException;
	
	/**
	 * ǰ����������
	 * �����������������еĿ��PO
	 * @return ReceivingNoteInputPO ���PO
	 */
	public ArrayList<ReceivingNoteInputPO> show() throws RemoteException;
}
