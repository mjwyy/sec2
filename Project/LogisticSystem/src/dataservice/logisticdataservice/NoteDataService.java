/**
 * ���뵥�����ݽӿ�
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.logisticdataservice;
import java.rmi.RemoteException;
import java.util.ArrayList;
import po.NotePO;
public interface NoteDataService {
	/**
	 * ǰ��������ͬ��ID��po��Mapper�в�����
	 * ���������������ݿ�������һ��po��¼
	 * @param po ���po
	 */
	public void insert(NotePO po) throws RemoteException;
	/**
	 * ǰ��������ͬ��ID��po��Mapper�д���
	 * ���������������ݿ���ɾ��һ��po��¼
	 * @param po ���po
	 */
	public void delete(NotePO po) throws RemoteException;
	/**
	 * ǰ��������ͬ��ID��po��Mapper�д���
	 * ���������������ݿ��и���һ��po��¼
	 * @param po ���po
	 */
	public void update(NotePO po) throws RemoteException;
	/**
	 * ǰ����������
	 * ���������������ֽ��в��ҷ�����Ӧ��NotePO���
	 * @param name �������
	 * @return NotePO ���PO
	 */
	public NotePO findByName(String name) throws RemoteException;
	/**
	 * ǰ����������
	 * ������������ID���в��ҷ�����Ӧ��NotePO���
	 * @param ID ���ID
	 * @return NotePO ���PO
	 */
	public NotePO findById(String id) throws RemoteException;
	
	/**
	 * ǰ����������
	 * �����������������еĿ��PO
	 * @return NotePO ���PO
	 */
	public ArrayList<NotePO> show() throws RemoteException;

	/**
	 * ǰ����������
	 * ������������ʼ���־û����ݿ�
	 */
	public void init() throws RemoteException;
	/**
	 * ǰ����������
	 * ���������������־û����ݿ��ʹ��
	 */
	public void finish() throws RemoteException;
}
