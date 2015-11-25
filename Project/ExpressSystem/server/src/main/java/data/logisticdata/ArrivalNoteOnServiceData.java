package data.logisticdata;

import data.database.DatabaseManager;
import data.statisticdata.OrderInquiryData;
import dataservice.logisticdataservice.ArrivalNoteOnServiceDataService;
import po.ArrivalNoteOnServicePO;
import po.DeliverNoteOnServicePO;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/16.
 */
public class ArrivalNoteOnServiceData implements ArrivalNoteOnServiceDataService {

    private OrderInquiryData orderDataService;

    @Override
    public boolean insertArrivalNote(ArrivalNoteOnServicePO po) throws RemoteException, SQLException {
        Connection connection = DatabaseManager.getConnection();
        String sql = "insert into `note_arrival_on_service` ( " +
                "`arrivalKind`, `from`, `barcodes`, `TransferNumber`, `date`)" +
                " values ( ?, ?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);


        DatabaseManager.releaseConnection(connection, statement, null);
        int result = statement.executeUpdate();
        return result > 0;
    }

    @Override
    public ArrayList<ArrivalNoteOnServicePO> findArrivalNote(ArrivalNoteOnServicePO po) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<ArrivalNoteOnServicePO> findAllArrivalNote() throws RemoteException {
        return null;
    }

    @Override
    public boolean insertDeliverNote(DeliverNoteOnServicePO po) throws RemoteException {
        return false;
    }

    @Override
    public ArrayList<DeliverNoteOnServicePO> findDeliverNote(DeliverNoteOnServicePO po) throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<DeliverNoteOnServicePO> findAllDeliverNote() throws RemoteException {
        return null;
    }
}
