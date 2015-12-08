package businesslogic;

import util.FormatCheck;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by kylin on 15/11/17.
 */
public class FormatCheck_Test {

//    @Test
    public void testBarcode(){
        assertEquals(true, FormatCheck.isBarcode("0123456789").isPass());
        assertEquals(true, FormatCheck.isBarcode("0123412589").isPass());
        assertEquals(false, FormatCheck.isBarcode("012a456789").isPass());
        assertEquals(false, FormatCheck.isBarcode("").isPass());
        assertEquals(false, FormatCheck.isBarcode("asdsadfasd").isPass());
        assertEquals(false, FormatCheck.isBarcode("啊啊是打算等我").isPass());
    }

//    @Test
    public void testDate(){
        System.out.println("0123456".substring(1,3));
        assertEquals(true, FormatCheck.isNumberDate("20180124").isPass());
        assertEquals(true, FormatCheck.isNumberDate("20181124").isPass());
        assertEquals(true, FormatCheck.isNumberDate("20180224").isPass());
        assertEquals(false, FormatCheck.isNumberDate("2015-12-24").isPass());
        assertEquals(false, FormatCheck.isNumberDate("20151288").isPass());
        assertEquals(false, FormatCheck.isNumberDate("20158824").isPass());
        assertEquals(false, FormatCheck.isNumberDate("20151232").isPass());
        assertEquals(false, FormatCheck.isNumberDate("20150231").isPass());
    }

//    @Test
    public void testisServiceHallLoadNumber(){
        assertEquals(true, FormatCheck.isServiceHallLoadNumber("02510002015092100000").isPass());
        assertEquals(true, FormatCheck.isServiceHallLoadNumber("02510012015092100000").isPass());
        assertEquals(false, FormatCheck.isServiceHallLoadNumber("02500002015092100000").isPass());
        assertEquals(false, FormatCheck.isServiceHallLoadNumber("025100012015882100000").isPass());
        assertEquals(false, FormatCheck.isServiceHallLoadNumber("02510002015093300000").isPass());
        assertEquals(false, FormatCheck.isServiceHallLoadNumber("02500002015092100000").isPass());
    }

    @Test
    public void testInventoryTime(){
        assertEquals(true, FormatCheck.isReceiveTime("2015-09-26 10:30").isPass());
        assertEquals(true, FormatCheck.isReceiveTime("2015-09-26 10:30").isPass());
        assertEquals(true, FormatCheck.isReceiveTime("2015-10-01 10:30").isPass());
        assertEquals(false, FormatCheck.isReceiveTime("2015-10-33 10:30").isPass());
        assertEquals(false, FormatCheck.isReceiveTime("2015-10-33 110:30").isPass());
        assertEquals(false, FormatCheck.isReceiveTime("2015-10-01  10:30").isPass());
        assertEquals(false, FormatCheck.isReceiveTime("2015-10-01 10 30").isPass());
        assertEquals(false, FormatCheck.isReceiveTime("20151001 10:30").isPass());
    }

//    @Test
    public void testisCenterLoadNumber(){
        assertEquals(true, FormatCheck.isCenterLoadNumber("025000201510121234561").isPass());
        assertEquals(true, FormatCheck.isCenterLoadNumber("025000201510121234561").isPass());
        assertEquals(true, FormatCheck.isCenterLoadNumber("025002201502121234561").isPass());
        assertEquals(false, FormatCheck.isCenterLoadNumber("025102201502121234561").isPass());
        assertEquals(true, FormatCheck.isCenterLoadNumber("125002201502121234561").isPass());
        assertEquals(false, FormatCheck.isCenterLoadNumber("025002201522121234561").isPass());
        assertEquals(false, FormatCheck.isCenterLoadNumber("025002201502331234561").isPass());
        assertEquals(false, FormatCheck.isCenterLoadNumber("02500201502121234561").isPass());
    }

//    @Test
    public void testChineseName(){
        assertEquals(true, FormatCheck.isChineseName("王二狗").isPass());
        assertEquals(true, FormatCheck.isChineseName("拉啊空间十啊实打实").isPass());
        assertEquals(true, FormatCheck.isChineseName("端木雪莹").isPass());
        assertEquals(false, FormatCheck.isChineseName("王二狗x").isPass());
        assertEquals(false, FormatCheck.isChineseName("王二 狗").isPass());
        assertEquals(false, FormatCheck.isChineseName(" 王二狗").isPass());
        assertEquals(false, FormatCheck.isChineseName("王x二狗").isPass());
        assertEquals(false, FormatCheck.isChineseName("asdw王sad").isPass());
    }

//    @Test
    public void testPhoneNumber(){
        assertEquals(true, FormatCheck.isPhoneNumber("18795853010").isPass());
        assertEquals(true, FormatCheck.isPhoneNumber("+8611233451234").isPass());
        assertEquals(true, FormatCheck.isPhoneNumber("19958530110").isPass());
        assertEquals(false, FormatCheck.isPhoneNumber("28795853010").isPass());
        assertEquals(false, FormatCheck.isPhoneNumber("387958 3010").isPass());
        assertEquals(false, FormatCheck.isPhoneNumber(" 18795 853010").isPass());
        assertEquals(false, FormatCheck.isPhoneNumber("1879-5853010").isPass());
        assertEquals(false, FormatCheck.isPhoneNumber("+18795853010").isPass());
    }

//    @Test
    public void testFixedPhoneNumber(){
        assertEquals(true, FormatCheck.isFixedPhoneNumber("0250-66778899").isPass());
        assertEquals(true, FormatCheck.isFixedPhoneNumber("0516-89578899").isPass());
        assertEquals(false, FormatCheck.isFixedPhoneNumber("025066778899").isPass());
        assertEquals(false, FormatCheck.isFixedPhoneNumber("0250 66778899").isPass());
        assertEquals(false, FormatCheck.isFixedPhoneNumber("+0250-66778899").isPass());
        assertEquals(false, FormatCheck.isFixedPhoneNumber("+0250").isPass());
    }

//    @Test
    public void testServiceHallNumber(){
        assertEquals(true, FormatCheck.isServiceHallNumber("0251000").isPass());
        assertEquals(true, FormatCheck.isServiceHallNumber("0251001").isPass());
        assertEquals(false, FormatCheck.isServiceHallNumber("02510002").isPass());
        assertEquals(false, FormatCheck.isServiceHallNumber(" ").isPass());
        assertEquals(false, FormatCheck.isServiceHallNumber(" 0251000").isPass());
        assertEquals(false, FormatCheck.isServiceHallNumber("+025100 0").isPass());
    }

//    @Test
    public void testCarNumber(){
        assertEquals(true, FormatCheck.isCarNumber("025001002").isPass());
        assertEquals(true, FormatCheck.isCarNumber("025222002").isPass());
        assertEquals(false, FormatCheck.isCarNumber(" 02510002").isPass());
        assertEquals(false, FormatCheck.isCarNumber("025222002 ").isPass());
        assertEquals(false, FormatCheck.isCarNumber(" 0251000").isPass());
        assertEquals(false, FormatCheck.isCarNumber(" 025100 0").isPass());
    }

//    @Test
    public void testDriverNumber(){
        assertEquals(true, FormatCheck.isDriverNumber("025001002").isPass());
        assertEquals(true, FormatCheck.isDriverNumber("025222002").isPass());
        assertEquals(false, FormatCheck.isDriverNumber(" 02510002").isPass());
        assertEquals(false, FormatCheck.isDriverNumber("025222002 ").isPass());
        assertEquals(false, FormatCheck.isDriverNumber(" 0251000").isPass());
        assertEquals(false, FormatCheck.isDriverNumber(" 025100 0").isPass());
    }

//    @Test
    public void testIDNumber(){
        assertEquals(true, FormatCheck.isIDNumber("320322199606120043").isPass());
        assertEquals(true, FormatCheck.isIDNumber("32032219960612004x").isPass());
        assertEquals(false, FormatCheck.isIDNumber(" 320322199606120043").isPass());
        assertEquals(false, FormatCheck.isIDNumber("320322199606120043 ").isPass());
        assertEquals(false, FormatCheck.isIDNumber("3203221996061200x3").isPass());
        assertEquals(false, FormatCheck.isIDNumber("0320322199606120043").isPass());
    }

//    @Test
    public void testCenterNumber(){
        assertEquals(true, FormatCheck.isCenterNumber("025001").isPass());
        assertEquals(true, FormatCheck.isCenterNumber("025006").isPass());
        assertEquals(false, FormatCheck.isCenterNumber(" 025001").isPass());
        assertEquals(false, FormatCheck.isCenterNumber("025001 ").isPass());
        assertEquals(false, FormatCheck.isCenterNumber("025x001").isPass());
        assertEquals(false, FormatCheck.isCenterNumber("01225001").isPass());
    }
    
    @Test
    public void testIsBaseData(){
        assertEquals(true, FormatCheck.isBaseData("213").isPass());
        assertEquals(true, FormatCheck.isBaseData("213.2131").isPass());
        assertEquals(false, FormatCheck.isBaseData("-025001").isPass());
        assertEquals(false, FormatCheck.isBaseData("123.123.1").isPass());
        assertEquals(false, FormatCheck.isBaseData("-123.213").isPass());
        assertEquals(false, FormatCheck.isBaseData("00.123").isPass());
    }
    
}
