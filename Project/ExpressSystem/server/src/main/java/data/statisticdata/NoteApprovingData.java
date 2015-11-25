package data.statisticdata;

import java.rmi.RemoteException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

import data.database.DatabaseManager;
import data.database.SqlHelper;
import po.NotePO;
import util.enums.DocType;
import dataservice.exception.ElementNotFoundException;
import dataservice.statisticdataservice.NoteApprovingDataService;

/**
 * @author wwz
 * @date 2015/11/14
 *
 */
public class NoteApprovingData implements NoteApprovingDataService {

    private HashMap<String, String> nameAndTableName;
    private HashMap<String, String> nameAndTableID;

    public NoteApprovingData() {
        nameAndTableName = new HashMap<>();
        nameAndTableID = new HashMap<>();

        nameAndTableName.put("ArrivalNoteOnTransitPO", "note_arrival_on_transit");
        nameAndTableName.put("ArrivalNoteOnServicePO", "note_arrival_on_service");
        nameAndTableName.put("DeliveryNotePO", "note_delivery");

        nameAndTableID.put("ArrivalNoteOnTransitPO", "transferNumber");
        nameAndTableID.put("ArrivalNoteOnServicePO", "TransferNumber");
        nameAndTableID.put("DeliveryNotePO", "barCode");
    }

    @Override
    public ArrayList<NotePO> getAllDoc() throws RemoteException {
        return null;
    }

    @Override
    public ArrayList<NotePO> getDocByType(DocType type) throws RemoteException {
        return null;
    }

    @Override
    public boolean passDoc(NotePO docPO) throws RemoteException,
            ElementNotFoundException, SQLException {
        String name = docPO.getName();
        String tableName = nameAndTableName.get(name);
        String tableID = nameAndTableID.get(name);
        String sql = "update `" + tableName + "` set `isPassed` = 2 where `" + tableID + "` = " + docPO.getID();
        System.out.println(sql);
        return SqlHelper.excSqlStatement(sql);
    }

    @Override
    public boolean failDoc(NotePO docPO, String comment)
            throws RemoteException, ElementNotFoundException, SQLException {
        String name = docPO.getName();
        String tableName = nameAndTableName.get(name);
        String tableID = nameAndTableID.get(name);
        String sql = "update " + tableName + " set isPassed = 1" + ", advice = '" + comment +
                "' where " + tableID + " = " + docPO.getID();
        System.out.println(sql);
        return SqlHelper.excSqlStatement(sql);
    }


}
