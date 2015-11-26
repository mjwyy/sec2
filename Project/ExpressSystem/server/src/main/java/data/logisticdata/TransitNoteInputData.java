package data.logisticdata;

import dataservice.logisticdataservice.TransitNoteInputDataService;
import po.TransitNotePO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/10.
 */
public class TransitNoteInputData extends NoteInputData implements TransitNoteInputDataService {

    @Override
    public boolean insert(TransitNotePO po) throws RemoteException {
        String sql = "insert into `note_transit` ( `barcodes`, `transitDocNumber`, `supercargoMan`, " +
                "`departurePlace`, `date`, `desitination`, `flightNumber`) " +
                "values ( ?, ?, ?, ?, ?, ?, ?)";
        return false;
    }

    @Override
    public ArrayList<TransitNotePO> find(TransitNotePO po) throws RemoteException {
        TransitNotePO pox = new TransitNotePO(null, null, null, null, null, null, null);
        ArrayList<TransitNotePO> list =  new ArrayList<TransitNotePO>();
        list.add(pox);
        return list;
    }

    @Override
    public ArrayList<TransitNotePO> findAll() throws RemoteException {
        return null;
    }
}
