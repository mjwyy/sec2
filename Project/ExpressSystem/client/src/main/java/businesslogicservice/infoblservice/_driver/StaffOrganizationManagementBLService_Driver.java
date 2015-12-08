
package businesslogicservice.infoblservice._driver;

import businesslogic.info.StaffOrganizationManagement;
import businesslogicservice.infoblservice.StaffOrganizationManagementBLService;
import businesslogicservice.infoblservice._stub.StaffOrganizationManagementBLService_Stub;
import connection.RMIHelper;
import util.ResultMsg;
import util.enums.OrganizationType;
import vo.OrganizationInfoVO;
import vo.StaffVO;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class StaffOrganizationManagementBLService_Driver {

    /**
     * 营业厅编号格式为“025城市编码+1营业厅+000鼓楼营业厅”。
     * 中转中心编号格式为“025城市编码+0营业厅+00鼓楼中转中心”。
     * 仓库同中转中心
     */
	public void drive(StaffOrganizationManagementBLService service){


	}

    public static void main(String[] args) throws RemoteException, NotBoundException {
        RMIHelper.tryConnect();
        StaffOrganizationManagementBLService_Driver driver2 =
                new StaffOrganizationManagementBLService_Driver();
        driver2.drive(new StaffOrganizationManagement());
    }
}
