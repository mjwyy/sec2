package data.financedata;

import data.database.DatabaseManager;
import data.statisticdata.LogInsHelper;
import dataservice.financedataservice.SettlementManagementDataService;
import po.BankAccountPO;
import po.IncomeNotePO;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/16.
 * 
 * Database dependencies:
 * 
 * 财务人员收款单 IncomeNotes
 * Columns:id(varchar(32)),date(varchar(32)),receiveOrg(varchar(16)),receiveStaff(varchar(8)),
 *	payer(varchar(16)),money(varchar(16)),account(varchar(16)),
 *	isPassed(int),advice(varchar)
 * 
 */
public class SettlementManagementData implements SettlementManagementDataService {
	
	private static final long serialVersionUID = -5692094959798049197L;
	
	private Connection connection;
	
	public SettlementManagementData() {
		super();
	}
	
    @Override
    public boolean addIncomeNote(IncomeNotePO note, String staffID) throws RemoteException {
    	//注意审批、修改银行账户余额
        return false;
    }

	@Override
	public ArrayList<IncomeNotePO> findAll() throws RemoteException {
		
		//返回所有的信息，因为总部只有一个
		
		connection = DatabaseManager.getConnection();
		String sql = "select * from IncomeNotes";
		Statement stmt = null;
		ResultSet set = null;
		
		ArrayList<IncomeNotePO> result = new ArrayList<>();
		
		try {
			stmt = connection.createStatement();
			set = stmt.executeQuery(sql);
			
			while (set.next()) {
				String time = set.getString("date");
				String receivingOrganization = set.getString("receiveOrg");
				String incomeHandler = set.getString("receiveStaff");
				String incomeSource = set.getString("payer");
				String money = set.getString("money");
				BankAccountPO bankAccountPO = new BankAccountPO(null, set.getString("account"), null);
				
				IncomeNotePO po = new IncomeNotePO(time, receivingOrganization, incomeHandler,
						incomeSource, money, bankAccountPO);
				
				result.add(po);
			}
			
		} catch (SQLException e) {
			LogInsHelper.insertLog("由connection获取Statement失败");
			e.printStackTrace();
			throw new RemoteException("系统数据异常，操作取消，请联系系统管理员。");
		}
		
		LogInsHelper.insertLog("成功提取所有财务收款单信息");
		
		return result;
	}
}
