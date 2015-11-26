package data.logisticdata;

import dataservice.logisticdataservice.LoadNoteOnTransitDataService;
import po.LoadNoteOnTransitPO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/10.
 */
public class LoadNoteOnTransitData extends NoteInputData implements LoadNoteOnTransitDataService {

    @Override
    public boolean insert(LoadNoteOnTransitPO po) throws RemoteException {
        String sql = "insert into `note_load_on_transit` ( `barcodes`, `destination`, `supercargoMan`," +
                " `guardMan`, `date`, `carNumber`, `hallNumber`, `transpotationNumber`)" +
                " values ( ?, ?, ?, ?, ?, ?, ?, ?)";
        return false;
    }

    @Override
    public ArrayList<LoadNoteOnTransitPO> find(LoadNoteOnTransitPO po) throws RemoteException {

        LoadNoteOnTransitPO pox = new LoadNoteOnTransitPO(null,null,null,null,null,null,null, null);

        ArrayList<LoadNoteOnTransitPO> list =  new ArrayList<LoadNoteOnTransitPO>();
        list.add(pox);
        return list;
    }

    @Override
    public ArrayList<LoadNoteOnTransitPO> findAll() throws RemoteException {

        LoadNoteOnTransitPO pox = new LoadNoteOnTransitPO(null,null,null,null,null,null,null, null);

        ArrayList<LoadNoteOnTransitPO> list =  new ArrayList<LoadNoteOnTransitPO>();
        list.add(pox);
        return list;
    }
}
