package businesslogic.info;

import businesslogicservice.infoblservice.BankAccountManagementBLService;
import util.ResultMsg;
import vo.BankAccountVO;

import java.util.ArrayList;

<<<<<<< HEAD
=======
import po.BankAccountPO;
import connection.RemoteObjectGetter;
import dataservice.commoditydataservice.StorageInDataService;
import dataservice.infodataservice.BankAccountManagementDataService;

>>>>>>> master
/**
 * Created by kylin on 15/11/17.
 */
public class BankAccountManagement implements BankAccountManagementBLService {
<<<<<<< HEAD
    @Override
    public ArrayList<BankAccountVO> find(BankAccountVO vo) {
        return null;
=======
	
	BankAccountManagementDataService dataService = null;
	
	public BankAccountManagement() {
		RemoteObjectGetter getter = new RemoteObjectGetter();
		dataService = (BankAccountManagementDataService) getter.getObjectByName("BankAccountManagementDataService");
	}
	
    @Override
    public ArrayList<BankAccountVO> find(BankAccountVO vo) {
    	ArrayList<BankAccountVO> result = new ArrayList<>();
    	ArrayList<BankAccountPO> get = null;
    	
    	try {
    		get = dataService.findBankAccount((BankAccountPO) vo.toPO());
    	} catch (Exception e) {
    		System.err.println("查找银行账户时出现异常：");
    		System.err.println(e.getMessage());
    		return result;
    	}
    	
    	for(BankAccountPO po:get) {
    		result.add((BankAccountVO) po.toVO());
    	}
    	
    	return result;
>>>>>>> master
    }

    @Override
    public ResultMsg add(BankAccountVO vo) {
<<<<<<< HEAD
        return null;
=======
    	ResultMsg msg = vo.checkFormat();
    	
    	if(!msg.isPass()) return msg;
    	
    	try {
    		boolean b = dataService.addBankAccount((BankAccountPO) vo.toPO());
    		if(!b) return new ResultMsg(false,"添加银行账户失败，请重试");
    	} catch (Exception e) {
    		return new ResultMsg(false, e.getMessage());
    	}
    	
        return new ResultMsg(true);
>>>>>>> master
    }

    @Override
    public ResultMsg delete(BankAccountVO vo) {
<<<<<<< HEAD
        return null;
=======
    	ResultMsg msg = vo.checkFormat();
    	
    	if(!msg.isPass()) return msg;
    	
    	try {
    		boolean b = dataService.removeBankAccount((BankAccountPO) vo.toPO());
    		if(!b) return new ResultMsg(false,"删除银行账户失败，请重试");
    	} catch (Exception e) {
    		return new ResultMsg(false, e.getMessage());
    	}
    	
        return new ResultMsg(true);
>>>>>>> master
    }

    @Override
    public ResultMsg update(BankAccountVO vo) {
<<<<<<< HEAD
        return null;
=======
        ResultMsg msg = vo.checkFormat();
        if(!msg.isPass()) return msg;
        
        try {
        	boolean b = dataService.modifyBankAccount((BankAccountPO) vo.toPO());
        	if(!b) return new ResultMsg(false,"修改账户信息失败，请重试");
        } catch(Exception e) {
        	return new ResultMsg(false,e.getMessage());
        }
        
        return new ResultMsg(true);
        
>>>>>>> master
    }

    @Override
    public ArrayList<BankAccountVO> show() {
<<<<<<< HEAD
        return null;
=======
    	ArrayList<BankAccountVO> result = new ArrayList<>();
    	ArrayList<BankAccountPO> get = null;
    	
    	try {
    		get = dataService.getAllAccounts();
    	} catch (Exception e) {
    		System.err.println("获取所有银行账户时出现异常：");
    		System.err.println(e.getMessage());
    		return result;
    	}
    	
    	for(BankAccountPO po:get) {
    		result.add((BankAccountVO) po.toVO());
    	}
    	
    	return result;
>>>>>>> master
    }
}
