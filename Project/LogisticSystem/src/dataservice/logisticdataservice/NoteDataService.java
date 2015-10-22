/**
 * 输入单据数据接口
 * @author wqy
 * @date 2015/10/17
 */
package dataservice.logisticdataservice;
import java.rmi.RemoteException;
import java.util.ArrayList;
import po.NotePO;
public interface NoteDataService {
	/**
	 * 前置条件：同样ID的po在Mapper中不存在
	 * 后置条件：在数据库中增加一个po记录
	 * @param po Notepo
	 */
	public void insert(NotePO po) throws RemoteException;
	/**
	 * 前置条件：同样ID的po在Mapper中存在
	 * 后置条件：在数据库中删除一个po记录
	 * @param po Notepo
	 */
	public void delete(NotePO po) throws RemoteException;
	/**
	 * 前置条件：同样ID的po在Mapper中存在
	 * 后置条件：在数据库中更新一个po记录
	 * @param po Notepo
	 */
	public void update(NotePO po) throws RemoteException;
	/**
	 * 前置条件：无
	 * 后置条件：查找返回相应的NotePO结果
	 * @param name 关键字
	 * @return NotePO 
	 */
	public ArrayList<NotePO> find(String name) throws RemoteException;
	
	/**
	 * 前置条件：无
	 * 后置条件：返回所有的NotePO
	 * @return NotePO 
	 */
	public ArrayList<NotePO> findAll() throws RemoteException;

	/**
	 * 前置条件：无
	 * 后置条件：初始化持久化数据库
	 */
	public void init() throws RemoteException;
	/**
	 * 前置条件：无
	 * 后置条件：结束持久化数据库的使用
	 */
	public void finish() throws RemoteException;
}