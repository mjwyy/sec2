package businesslogic.statistic;

import businesslogicservice.statisticblservice.NoteApprovingBLService;
import dataservice.statisticdataservice.NoteApprovingDataService;
import po.NotePO;
import util.enums.DocType;
import vo.NoteVO;

import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 * Created by kylin on 15/11/17.
 */
public class NoteApproving implements NoteApprovingBLService {

    private NoteApprovingDataService dataService;

    // TODO po转化为VO的问题

    @Override
    public ArrayList<NoteVO> getAllDoc() {
        ArrayList<NoteVO> noteVOArrayList;
        ArrayList<NotePO> notePOs;
        try {
            notePOs = dataService.getAllDoc();
            for (NotePO po:notePOs){
            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public ArrayList<NoteVO> getDocByType(DocType type) {
        return null;
    }

    @Override
    public void passAllDoc() {

    }

    @Override
    public void passDoc(NoteVO docVO) {

    }

    @Override
    public void failDoc(NoteVO docVO) {

    }

    @Override
    public void inputAdvice(NoteVO docVO, String advice) {

    }
}
