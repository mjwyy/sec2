package businesslogic;

import businesslogic.util.FormatCheck;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kylin on 15/11/17.
 */
public class FormatCheck_Test {

//    @Test
    public void testBarcode(){
        assertEquals(true, FormatCheck.IsBarcode("0123456789"));
        assertEquals(true, FormatCheck.IsBarcode("0123412589"));
        assertEquals(false, FormatCheck.IsBarcode("012a456789"));
        assertEquals(false, FormatCheck.IsBarcode(""));
        assertEquals(false, FormatCheck.IsBarcode("asdsadfasd"));
        assertEquals(false, FormatCheck.IsBarcode("啊啊是打算等我"));
    }

//    @Test
    public void testDate(){
        assertEquals(true, FormatCheck.IsDate("2018-1-24"));
        assertEquals(true, FormatCheck.IsDate("2015-12-24"));
        assertEquals(true, FormatCheck.IsDate("1996-6-1"));
        assertEquals(false, FormatCheck.IsDate("2015 12 05"));
        assertEquals(false, FormatCheck.IsDate("20151205"));
        assertEquals(false, FormatCheck.IsDate("1996-0712"));
        assertEquals(false, FormatCheck.IsDate("960612"));
        assertEquals(false, FormatCheck.IsDate("2014 9 3"));
    }

//    @Test
    public void testInventoryTime(){
        assertEquals(true, FormatCheck.IsInventoryTime("2015-09-26 10:30"));
        assertEquals(true, FormatCheck.IsInventoryTime("2015-9-26 10:30"));
        assertEquals(true, FormatCheck.IsInventoryTime("2015-10-1 10:30"));
        assertEquals(false, FormatCheck.IsInventoryTime("2015-10-01-10:30"));
        assertEquals(false, FormatCheck.IsInventoryTime("2015 10 01 10:30"));
        assertEquals(false, FormatCheck.IsInventoryTime("2015-10-01  10:30"));
        assertEquals(false, FormatCheck.IsInventoryTime("2015-10-01 10 30"));
        assertEquals(false, FormatCheck.IsInventoryTime("20151001 10:30"));
    }

//    @Test
    public void testChineseName(){
        assertEquals(true, FormatCheck.IsChineseName("王二狗"));
        assertEquals(true, FormatCheck.IsChineseName("拉啊空间十啊实打实"));
        assertEquals(true, FormatCheck.IsChineseName("端木雪莹"));
        assertEquals(false, FormatCheck.IsChineseName("王二狗x"));
        assertEquals(false, FormatCheck.IsChineseName("王二 狗"));
        assertEquals(false, FormatCheck.IsChineseName(" 王二狗"));
        assertEquals(false, FormatCheck.IsChineseName("王x二狗"));
        assertEquals(false, FormatCheck.IsChineseName("asdw王sad"));
    }

//    @Test
    public void testPhoneNumber(){
        assertEquals(true, FormatCheck.IsPhoneNumber("18795853010"));
        assertEquals(true, FormatCheck.IsPhoneNumber("+8611233451234"));
        assertEquals(true, FormatCheck.IsPhoneNumber("19958530110"));
        assertEquals(false, FormatCheck.IsPhoneNumber("28795853010"));
        assertEquals(false, FormatCheck.IsPhoneNumber("387958 3010"));
        assertEquals(false, FormatCheck.IsPhoneNumber(" 18795 853010"));
        assertEquals(false, FormatCheck.IsPhoneNumber("1879-5853010"));
        assertEquals(false, FormatCheck.IsPhoneNumber("+18795853010"));
    }

//    @Test
    public void testFixedPhoneNumber(){
        assertEquals(true, FormatCheck.IsFixedPhoneNumber("0250-66778899"));
        assertEquals(true, FormatCheck.IsFixedPhoneNumber("0516-89578899"));
        assertEquals(false, FormatCheck.IsFixedPhoneNumber("025066778899"));
        assertEquals(false, FormatCheck.IsFixedPhoneNumber("0250 66778899"));
        assertEquals(false, FormatCheck.IsFixedPhoneNumber("+0250-66778899"));
        assertEquals(false, FormatCheck.IsFixedPhoneNumber("+0250"));
    }

//    @Test
    public void testServiceHallNumber(){
        assertEquals(true, FormatCheck.IsServiceHallNumber("0251000"));
        assertEquals(true, FormatCheck.IsServiceHallNumber("0251001"));
        assertEquals(false, FormatCheck.IsServiceHallNumber("02510002"));
        assertEquals(false, FormatCheck.IsServiceHallNumber(" "));
        assertEquals(false, FormatCheck.IsServiceHallNumber(" 0251000"));
        assertEquals(false, FormatCheck.IsServiceHallNumber("+025100 0"));
    }

//    @Test
    public void testCarNumber(){
        assertEquals(true, FormatCheck.IsCarNumber("025001002"));
        assertEquals(true, FormatCheck.IsCarNumber("025222002"));
        assertEquals(false, FormatCheck.IsCarNumber(" 02510002"));
        assertEquals(false, FormatCheck.IsCarNumber("025222002 "));
        assertEquals(false, FormatCheck.IsCarNumber(" 0251000"));
        assertEquals(false, FormatCheck.IsCarNumber(" 025100 0"));
    }

//    @Test
    public void testDriverNumber(){
        assertEquals(true, FormatCheck.IsDriverNumber("025001002"));
        assertEquals(true, FormatCheck.IsDriverNumber("025222002"));
        assertEquals(false, FormatCheck.IsDriverNumber(" 02510002"));
        assertEquals(false, FormatCheck.IsDriverNumber("025222002 "));
        assertEquals(false, FormatCheck.IsDriverNumber(" 0251000"));
        assertEquals(false, FormatCheck.IsDriverNumber(" 025100 0"));
    }

//    @Test
    public void testIDNumber(){
        assertEquals(true, FormatCheck.IsIDNumber("320322199606120043"));
        assertEquals(true, FormatCheck.IsIDNumber("32032219960612004x"));
        assertEquals(false, FormatCheck.IsIDNumber(" 320322199606120043"));
        assertEquals(false, FormatCheck.IsIDNumber("320322199606120043 "));
        assertEquals(false, FormatCheck.IsIDNumber("3203221996061200x3"));
        assertEquals(false, FormatCheck.IsIDNumber("0320322199606120043"));
    }

    @Test
    public void testCenterNumber(){
        assertEquals(true, FormatCheck.IsCenterNumber("025001"));
        assertEquals(true, FormatCheck.IsCenterNumber("025006"));
        assertEquals(false, FormatCheck.IsCenterNumber(" 025001"));
        assertEquals(false, FormatCheck.IsCenterNumber("025001 "));
        assertEquals(false, FormatCheck.IsCenterNumber("025x001"));
        assertEquals(false, FormatCheck.IsCenterNumber("01225001"));
    }
    
}
