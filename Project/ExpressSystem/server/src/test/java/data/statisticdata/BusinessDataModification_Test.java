package data.statisticdata;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.util.ArrayList;

import org.junit.Test;

import util.enums.PriceType;
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
	
	public void testSetPrice() throws RemoteException, ElementNotFoundException {
	
		service.setPrice(type.PricePerKg, 20.0);
		assertEquals("20.0",service.getPrice(type.PricePerKg));
		service.setPrice(type.Bag, 10.0);
		assertEquals("10.0",service.getPrice(type.Bag));
		service.setPrice(type.PaperBox, 15);
		assertEquals("15",service.getPrice(type.PaperBox));
		service.setPrice(type.WoodenBox, 30);
		assertEquals("30",service.getPrice(type.WoodenBox));
		
	}
	
	public void testGetPrice() throws RemoteException, ElementNotFoundException {
		assertEquals("20.0",service.getPrice(type.PricePerKg));
		assertEquals("10.0",service.getPrice(type.Bag));
		assertEquals("15",service.getPrice(type.PaperBox));
		assertEquals("30",service.getPrice(type.WoodenBox));
	}
	
	public void testSetDistance() {
		
	}
	
	public void testGetDistance() {
		
	}

}
