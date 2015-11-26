package data.logisticdata;

import data.statisticdata.inte.LogInsertDataService;
import dataservice.logisticdataservice.LoadNoteOnServiceDataService;
import po.LoadNoteOnServicePO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/10.
 */
public class LoadNoteOnServiceData extends NoteInputData implements LoadNoteOnServiceDataService {

    private LogInsertDataService logInsertDataService;

    @Override
    public boolean insert(LoadNoteOnServicePO po) throws RemoteException {
        String sql = "insert into `note_load_on_service` ( `barcodes`, `destination`, `supercargoMan`, " +
                "`guardMan`, `date`, `carNumber`, `hallNumber`, `transpotationNumber`) " +
                "values ( ?, ?, ?, ?, ?, ?, ?, ?";
        return false;
    }

    @Override
    public ArrayList<LoadNoteOnServicePO> find(LoadNoteOnServicePO po) throws RemoteException {
        LoadNoteOnServicePO pox = new LoadNoteOnServicePO(null,null,null,null,null,null,null,null);
        ArrayList<LoadNoteOnServicePO> list =  new ArrayList<LoadNoteOnServicePO>();
        list.add(pox);
        return list;
    }

    @Override
    public ArrayList<LoadNoteOnServicePO> findAll() throws RemoteException {
        LoadNoteOnServicePO pox = new LoadNoteOnServicePO(null,null,null,null,null,null,null,null);
        ArrayList<LoadNoteOnServicePO> list =  new ArrayList<LoadNoteOnServicePO>();
        list.add(pox);
        return list;
    }
}
