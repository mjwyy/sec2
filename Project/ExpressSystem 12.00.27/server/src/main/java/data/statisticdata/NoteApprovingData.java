package data.statisticdata;

import java.rmi.RemoteException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import data.database.SqlHelper;
import dataservice.logisticdataservice.*;
import po.*;
import dataservice.exception.ElementNotFoundException;
import dataservice.statisticdataservice.NoteApprovingDataService;

/**
 * @author wwz
 * @date 2015/11/14
 *
 */
public class NoteApprovingData implements NoteApprovingDataService {

    private ArrivalNoteOnServiceDataService arrivalNoteOnServiceDataService;
    private ArrivalNoteOnTransitDataService arrivalNoteOnTransitDataService;
    private DeliveryNoteInputDataService deliveryNoteInputDataService;
    private LoadNoteOnServiceDataService loadNoteOnServiceDataService;
    private LoadNoteOnTransitDataService loadNoteOnTransitDataService;
    private ReceivingNoteInputDataService receivingNoteInputDataService;
    private TransitNoteInputDataService transitNoteInputDataService;

    private HashMap<String, String> nameAndTableName;
    private HashMap<String, String> nameAndTableID;

    public NoteApprovingData(ArrivalNoteOnServiceDataService arrivalNoteOnServiceDataService,
             ArrivalNoteOnTransitDataService arrivalNoteOnTransitDataService,
             DeliveryNoteInputDataService deliveryNoteInputDataService,
             LoadNoteOnServiceDataService loadNoteOnServiceDataService,
             LoadNoteOnTransitDataService loadNoteOnTransitDataService,
             ReceivingNoteInputDataService receivingNoteInputDataService,
             TransitNoteInputDataService transitNoteInputDataService) throws RemoteException {
        this.arrivalNoteOnServiceDataService = arrivalNoteOnServiceDataService;
        this.arrivalNoteOnTransitDataService = arrivalNoteOnTransitDataService;
        this.deliveryNoteInputDataService = deliveryNoteInputDataService;
        this.loadNoteOnServiceDataService = loadNoteOnServiceDataService;
        this.loadNoteOnTransitDataService = loadNoteOnTransitDataService;
        this.receivingNoteInputDataService = receivingNoteInputDataService;
        this.transitNoteInputDataService = transitNoteInputDataService;

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
    public ArrayList<ArrivalNoteOnServicePO> getArrivalNoteOnServicePO() throws RemoteException {
        return this.arrivalNoteOnServiceDataService.getArrivalNoteOnService();
    }

    @Override
    public ArrayList<DeliverNoteOnServicePO> getDeliverNoteOnServicePO() throws RemoteException {
        return this.arrivalNoteOnServiceDataService.getDeliverNoteOnService();
    }

    @Override
    public Iterator<ArrivalNoteOnTransitPO> getArrivalNoteOnTransitPO() throws RemoteException {
        return this.arrivalNoteOnTransitDataService.getArrivalNoteOnTransit();
    }

    @Override
    public ArrayList<DeliveryNotePO> getDeliveryNotePO() throws RemoteException {
        return this.deliveryNoteInputDataService.getDeliveryNote();
    }

    @Override
    public ArrayList<LoadNoteOnServicePO> getLoadNoteOnServicePO() throws RemoteException {
        return this.loadNoteOnServiceDataService.getLoadNoteOnService();
    }

    @Override
    public ArrayList<LoadNoteOnTransitPO> getLoadNoteOnTransitPO() throws RemoteException {
        return this.loadNoteOnTransitDataService.getLoadNoteOnTransit();
    }

    @Override
    public ArrayList<ReceivingNotePO> getReceivingNotePO() throws RemoteException {
        return this.receivingNoteInputDataService.getReceivingNote();
    }

    @Override
    public ArrayList<TransitNotePO> getTransitNotePO() throws RemoteException {
        return this.transitNoteInputDataService.getTransitNotePO();
    }

    @Override
    public boolean passDoc(NotePO docPO) throws RemoteException,
            ElementNotFoundException {
        String name = docPO.getName();
        String tableName = nameAndTableName.get(name);
        String tableID = nameAndTableID.get(name);
        String sql = "update `" + tableName + "` set `isPassed` = 2 where `" + tableID
                + "` = '" + docPO.getID() + "'";
        System.out.println(sql);
        try {
            SqlHelper.excUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public boolean failDoc(NotePO docPO, String comment)
            throws RemoteException, ElementNotFoundException {
        String name = docPO.getName();
        String tableName = nameAndTableName.get(name);
        String tableID = nameAndTableID.get(name);
        String sql = "update " + tableName + " set isPassed = 1" + ", advice = '" + comment +
                "' where " + tableID + " = '" + docPO.getID() + "'";
        System.out.println(sql);
        try {
            SqlHelper.excUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }


}
