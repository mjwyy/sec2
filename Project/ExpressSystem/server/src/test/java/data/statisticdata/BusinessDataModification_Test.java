package data.statisticdata;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import util.enums.PriceType;
import data.statisticdata.MockObject.MockDistance;
import dataservice.exception.ElementNotFoundException;
import dataservice.exception.InterruptWithExistedElementException;
import dataservice.statisticdataservice.BusinessDataModificationDataService;

public class BusinessDataModification_Test {
	
	private BusinessDataModificationDataService service = new BusinessDataModificationData();
	private PriceType type;

	@Test
	public void testAddCity() throws RemoteException, InterruptWithExistedElementException {
		assertEquals(true,service.addCity("南京"));	
		assertEquals(true,service.addCity("上海"));
		assertEquals(true,service.addCity("深圳"));	
	}
	
	public void testGetAllCity() throws RemoteException {
	     ArrayList<String> city = new ArrayList<String>();
	     city.add("南京");
	     city.add("上海");
	     city.add("深圳");
		assertEquals(true,city.equals(service.getAllCities()));	
	}
	
	public void testSetandGetPrice() throws RemoteException, ElementNotFoundException {
	
		assertEquals(true,service.setPrice(type.PricePerKg, 20.0));
		assertEquals("20.0",service.getPrice(type.PricePerKg));
		assertEquals(true,service.setPrice(type.Bag, 10.0));
		assertEquals("10.0",service.getPrice(type.Bag));
		assertEquals(true,service.setPrice(type.PaperBox, 15));
		assertEquals("15",service.getPrice(type.PaperBox));
		assertEquals(true,service.setPrice(type.WoodenBox, 30));
		assertEquals("30",service.getPrice(type.WoodenBox));
		
	}
	
	
	
	public void testSetandGetDistance() throws RemoteException, ElementNotFoundException {
		MockDistance distance1 = new MockDistance("南京","上海",2000);
		MockDistance diatance2 = new MockDistance("上海","深圳",400000);
		MockDistance distance3 = new MockDistance("上海","南京",2000);
		assertEquals(true,service.setDistance(distance1));
		assertEquals(true,service.setDistance(diatance2));
		assertEquals(false,service.setDistance(distance3));
		MockDistance distance4 = new MockDistance("南京","上海",0);
		assertEquals("南京",service.getDistance(distance4).getCity1());
		assertEquals("上海",service.getDistance(distance4).getCity2());
		assertEquals("2000",service.getDistance(distance4).getDistance());
		
		
	}
	


}
