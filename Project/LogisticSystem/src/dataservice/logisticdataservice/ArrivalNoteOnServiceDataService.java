/**
 * ����Ӫҵ����������ݽӿ�
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.logisticdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ArrivalNoteOnServicePO;


public interface ArrivalNoteOnServiceDataService {
	/**
	 * ǰ��������ͬ��ID��po��Mapper�в�����
	 * ���������������ݿ�������һ��po��¼
	 * @param po ���po
	 */
	public void insert(ArrivalNoteOnServicePO po) throws RemoteException;
	/**
	 * ǰ��������ͬ��ID��po��Mapper�д���
	 * ���������������ݿ���ɾ��һ��po��¼
	 * @param po ���po
	 */
	public void delete(ArrivalNoteOnServicePO po) throws RemoteException;
	/**
	 * ǰ��������ͬ��ID��po��Mapper�д���
	 * ���������������ݿ��и���һ��po��¼
	 * @param po ���po
	 */
	public void update(ArrivalNoteOnServicePO po) throws RemoteException;
	/**
	 * ǰ����������
	 * ���������������ֽ��в��ҷ�����Ӧ��NotePO���
	 * @param name �������
	 * @return NotePO ���PO
	 */
	public ArrivalNoteOnServicePO findByName(String name) throws RemoteException;
	/**
	 * ǰ����������
	 * ������������ID���в��ҷ�����Ӧ��NotePO���
	 * @param ID ���ID
	 * @return NotePO ���PO
	 */
	public ArrivalNoteOnServicePO findById(String id) throws RemoteException;
	
	/**
	 * ǰ����������
	 * �����������������еĿ��PO
	 * @return NotePO ���PO
	 */
	public ArrayList<ArrivalNoteOnServicePO> show() throws RemoteException;
}
