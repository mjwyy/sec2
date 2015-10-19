/**
 * ������ת���ĵ�������ݽӿ�
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.logisticdataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.ArrivalNoteOnTransitPO;

public interface ArrivalNoteOnTransitDataService {
	/**
	 * ǰ��������ͬ��ID��po��Mapper�в�����
	 * ���������������ݿ�������һ��po��¼
	 * @param po ���po
	 */
	public void insert(ArrivalNoteOnTransitPO po) throws RemoteException;
	/**
	 * ǰ��������ͬ��ID��po��Mapper�д���
	 * ���������������ݿ���ɾ��һ��po��¼
	 * @param po ���po
	 */
	public void delete(ArrivalNoteOnTransitPO po) throws RemoteException;
	/**
	 * ǰ��������ͬ��ID��po��Mapper�д���
	 * ���������������ݿ��и���һ��po��¼
	 * @param po ���po
	 */
	public void update(ArrivalNoteOnTransitPO po) throws RemoteException;
	/**
	 * ǰ����������
	 * ���������������ֽ��в��ҷ�����Ӧ��ArrivalNoteOnTransitPO���
	 * @param name �������
	 * @return ArrivalNoteOnTransitPO ���PO
	 */
	public ArrivalNoteOnTransitPO findByName(String name) throws RemoteException;
	/**
	 * ǰ����������
	 * ������������ID���в��ҷ�����Ӧ��ArrivalNoteOnTransitPO���
	 * @param ID ���ID
	 * @return ArrivalNoteOnTransitPO ���PO
	 */
	public ArrivalNoteOnTransitPO findById(String id) throws RemoteException;
	
	/**
	 * ǰ����������
	 * �����������������еĿ��PO
	 * @return ArrivalNoteOnTransitPO ���PO
	 */
	public ArrayList<ArrivalNoteOnTransitPO> show() throws RemoteException;
}
