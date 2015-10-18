package dataservice.financedataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 * 
 * @author River
 * 期初建账调用其他增删改查的接口
 * 一但开始期初建账操作，期间Data禁止其他用户数据访问与修改
 */
public interface BaseDataBuildingDataService extends Remote {
	
	/**
	 * 前置条件：无
	 * 后置条件：Data开始接受单一客户端操作请求
	 * @param withBase
	 * @return
	 * @throws RemoteException
	 */
	public boolean startBaseDataBuilding(boolean withBase)
			throws RemoteException;
	
	/**
	 * 前置条件：建账的客户端完成了建账所有操作
	 * 后置条件：Data层结束建账，并使用新账
	 * @return
	 * @throws RemoteException
	 */
	public boolean endBaseDataBuilding()
			throws RemoteException;
	
}
