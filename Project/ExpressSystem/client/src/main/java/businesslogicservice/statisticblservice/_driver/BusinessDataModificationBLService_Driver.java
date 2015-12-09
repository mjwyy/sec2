package businesslogicservice.statisticblservice._driver;

import businesslogic.statistic.BusinessDataModification;
import businesslogicservice.statisticblservice.BusinessDataModificationBLService;
import connection.RMIHelper;
import po.DistancePO;
import util.enums.PriceType;
import vo.DistanceVO;
import vo.PriceVO;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.ArrayList;


public class BusinessDataModificationBLService_Driver {

    public static void main(String[] args) throws RemoteException, NotBoundException {
        RMIHelper.tryConnect();
        BusinessDataModificationBLService_Driver driver = new BusinessDataModificationBLService_Driver();
        BusinessDataModificationBLService blService = new BusinessDataModification();
        driver.drive(blService);
    }

	public void drive(BusinessDataModificationBLService service){
//        ArrayList<DistanceVO> distanceVOs = service.getAllDistanceInfo();
//        for(DistanceVO distanceVO : distanceVOs){
//            System.out.println(distanceVO.getCity1()+distanceVO.getCity2()+distanceVO.getDistance());
//        }

        ArrayList<PriceVO> priceVOs = service.getAllPrices();
        for(PriceVO distanceVO : priceVOs){
            System.out.println(distanceVO.getPriceType().toString()+distanceVO.getPrice());
        }
	}
}
