package data.commoditydata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.util.ArrayList;

import po.StorageInPO;
import dataservice.commoditydataservice.StorageInDataService;

/**
 * 
 * @author River
 * database:
 * id(varchar(32)),date(varchar(32)),warehouseID(varchar(20))，isPassed(int,enum Doc for java)
 */

public class StorageInData implements StorageInDataService {
	
	private Connection connection;
	
	public StorageInData() {
		super();
	}
	
    @Override
    public boolean insert(StorageInPO po,String staffID) throws RemoteException {
    	
    	
    	// 添加staffID的日志记录
        return false;
    }
}
