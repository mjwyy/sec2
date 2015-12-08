package data.statisticdata;

import static org.junit.Assert.*;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;

import data.database.DatabaseFactory;
import data.database.DatabaseFactoryMysqlImpl;
import data.logisticdata.MockObject.MockArrivalNoteOnTransit;
import data.logisticdata.MockObject.MockDeliveryNote;
import org.junit.Test;

import data.logisticdata.MockObject.MockArrivalNoteOnService;
import dataservice.exception.ElementNotFoundException;
import dataservice.statisticdataservice.NoteApprovingDataService;
import po.*;
import util.BarcodeAndState;
import util.enums.DeliverCategory;
import util.enums.GoodsState;
import util.enums.PackageType;
import util.enums.TransitType;
import vo.LoadNoteOnServiceVO;

public class NoteApprovingData_Test {

    protected NoteApprovingDataService service;

    public NoteApprovingData_Test() throws RemoteException {
        service = DatabaseFactoryMysqlImpl.getInstance().getNoteApprovingDataService();
    }


}
