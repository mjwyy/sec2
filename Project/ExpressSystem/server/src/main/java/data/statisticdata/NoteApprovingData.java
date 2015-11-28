package data.statisticdata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

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

        nameAndTableName.put("ArrivalNoteOnServicePO", "note_arrival_on_service");
        nameAndTableName.put("DeliverNoteOnServicePO", "note_delivery_on_service");
        nameAndTableName.put("ArrivalNoteOnTransitPO", "note_arrival_on_transit");
        nameAndTableName.put("DeliveryNotePO", "note_delivery");
        nameAndTableName.put("LoadNoteOnServicePO", "note_load_on_service");
        nameAndTableName.put("LoadNoteOnTransitPO", "note_load_on_transit");
        nameAndTableName.put("ReceivingNotePO", "note_receive_note");
        nameAndTableName.put("TransitNotePO", "note_transit");

        nameAndTableID.put("ArrivalNoteOnServicePO", "TransferNumber");
        nameAndTableID.put("DeliverNoteOnServicePO", "id");
        nameAndTableID.put("ArrivalNoteOnTransitPO", "transferNumber");
        nameAndTableID.put("DeliveryNotePO", "barCode");
        nameAndTableID.put("LoadNoteOnServicePO", "transpotationNumber");
        nameAndTableID.put("LoadNoteOnTransitPO", "transpotationNumber");
        nameAndTableID.put("ReceivingNotePO", "barcode");
        nameAndTableID.put("TransitNotePO", "transitDocNumber");
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
        String sql = "update `" + tableName + "` set `isPassed` = 2 where `" + tableID
                + "` = '" + docPO.getID() + "'";
        System.out.println(sql);
        return SqlHelper.excUpdate(sql);
    }

    @Override
    public boolean failDoc(NotePO docPO, String comment)
            throws RemoteException, ElementNotFoundException, SQLException {
        String name = docPO.getName();
        String tableName = nameAndTableName.get(name);
        String tableID = nameAndTableID.get(name);
        String sql = "update " + tableName + " set isPassed = 1" + ", advice = '" + comment +
                "' where " + tableID + " = '" + docPO.getID() + "'";
        System.out.println(sql);
        return SqlHelper.excUpdate(sql);
    }


}
