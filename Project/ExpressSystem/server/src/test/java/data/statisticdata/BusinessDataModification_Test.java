package data.statisticdata;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import dataservice.statisticdataservice.BusinessDataModificationDataService;
import org.junit.Test;

import util.enums.PriceType;
import data.statisticdata.MockObject.MockDistance;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;

public class BusinessDataModification_Test {
	
	private BusinessDataModificationDataService service = new BusinessDataModificationData();

    //	@Test
    public void testAddCity() throws RemoteException, InterruptWithExistedElementException {
		//assertEquals(true,service.addCity("南京"));	
		//assertEquals(true,service.addCity("上海"));
		//assertEquals(true,service.addCity("深圳"));	
	}

    //    @Test
    public void testGetAllCity() throws RemoteException {
	     ArrayList<String> city = new ArrayList<String>();
	     city.add("南京");
	     city.add("上海");
	     city.add("深圳");
		//assertEquals(true,city.equals(service.getAllCities()));	
	}

    //    @Test
    public void testSetandGetPrice() throws RemoteException, ElementNotFoundException, SQLException {
//		service.setPrice(PriceType.Bag, 1.0);
        System.out.println(service.getPrice(PriceType.PricePerKg));
        System.out.println(service.getPrice(PriceType.Bag));
        System.out.println(service.getPrice(PriceType.PaperBox));
        System.out.println(service.getPrice(PriceType.WoodenBox));
    }

    @Test
    public void testSetandGetDistance() throws RemoteException, ElementNotFoundException, SQLException {
        MockDistance distance4 = new MockDistance("nanJing", "nanJing", 0);
        service.setDistance(distance4);
        System.out.println(service.getDistance("nanJing", "nanJing"));
    }


}
