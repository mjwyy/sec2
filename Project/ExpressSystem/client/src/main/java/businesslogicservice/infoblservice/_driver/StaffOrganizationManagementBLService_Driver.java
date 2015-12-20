
package businesslogicservice.infoblservice._driver;

import businesslogic.info.StaffOrganizationManagement;
import businesslogicservice.infoblservice.StaffOrganizationManagementBLService;
import businesslogicservice.infoblservice._stub.StaffOrganizationManagementBLService_Stub;
import connection.RMIHelper;
import util.ResultMsg;
import util.enums.OrganizationType;
import util.enums.StaffType;
import vo.OrganizationInfoVO;
import vo.StaffVO;

import java.lang.reflect.Array;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;

public class StaffOrganizationManagementBLService_Driver {

    /**
     * 营业厅编号格式为“025城市编码+1营业厅+000鼓楼营业厅”。
     * 中转中心编号格式为“025城市编码+0营业厅+00鼓楼中转中心”。
     * 仓库同中转中心
     */
	public void drive(StaffOrganizationManagementBLService service){
//        testaddStaff(service);
//        addOrg(service);
//        findStaff(service);
//        findOrg(service);
        testRemove(service);
	}

    private void testRemove(StaffOrganizationManagementBLService service) {
        ResultMsg r = service.delOrganization(new OrganizationInfoVO("010000",OrganizationType.TRANSIT_CENTER,
                "北京第一仓库",null));
        System.out.println(r.getMessage());
    }

    public static void main(String[] args) throws RemoteException, NotBoundException {
        RMIHelper.tryConnect();
        StaffOrganizationManagementBLService_Driver driver2 =
                new StaffOrganizationManagementBLService_Driver();
        driver2.drive(new StaffOrganizationManagement());
    }

    public void testaddStaff(StaffOrganizationManagementBLService service){
        ResultMsg r = service.addStaff(new StaffVO("111","测试","男","南京总部", StaffType.MANAGER,
                "320322199606120014",300,"12345678901","8888"));
        System.out.println(r.getMessage());
        System.out.println(r.isPass());
    }

    public void findStaff(StaffOrganizationManagementBLService service){
//        StaffVO vo  = new StaffVO(null,"经理",null,null,null,null,0,null,null);
        StaffVO vo  = new StaffVO(null,null,"女",null,null,null,-1,null,null);
        ArrayList<StaffVO> staffVOs = service.findStaffInfo(vo);
        for(StaffVO staffVO: staffVOs){
            System.out.println(staffVO.getSex()+" "+
                    staffVO.getName()+" "+staffVO.getOrganization());
        }
    }

    public void addOrg(StaffOrganizationManagementBLService service){
        ResultMsg r = service.addOrganization(new OrganizationInfoVO("010002",OrganizationType.TRANSIT_CENTER,
                "北京第一仓库",null));
        System.out.println(r.getMessage());
    }

    public void findOrg(StaffOrganizationManagementBLService service){
        OrganizationInfoVO organizationInfoVO = new OrganizationInfoVO(
                "010001",null,null,null);
//        OrganizationInfoVO organizationInfoVO = null;
        ArrayList<OrganizationInfoVO> voArrayList = service.findOrgInfo(organizationInfoVO);
        System.out.println("voArrayList.isEmpty()"+voArrayList.isEmpty());
        for(OrganizationInfoVO result : voArrayList){
            System.out.println(result.getName()+" "+result.getOrganizationNum());
        }

    }
}
