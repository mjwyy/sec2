package businesslogic.statistic;

import businesslogicservice.statisticblservice.NoteApprovingBLService;
import connection.RemoteObjectGetter;
import dataservice.exception.ElementNotFoundException;
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

    public NoteApproving() {
        RemoteObjectGetter getter = new RemoteObjectGetter();
        this.dataService =
                (NoteApprovingDataService)getter.getObjectByName("NoteApprovingDataService");
    }

    @Override
    public ArrayList<NoteVO> getAllDoc() {
        ArrayList<NoteVO> noteVOArrayList = new ArrayList<>();
        ArrayList<NotePO> notePOs;
        try {
            notePOs = dataService.getAllDoc();
            // TODO po转化为VO的问题 VO拖到common里面
            for (NotePO po:notePOs){

            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return noteVOArrayList;
    }

    @Override
    public ArrayList<NoteVO> getDocByType(DocType type) {
        ArrayList<NoteVO> noteVOArrayList = new ArrayList<>();
        ArrayList<NotePO> notePOs;
        try {
            notePOs = dataService.getDocByType(type);
            // TODO po转化为VO的问题
            for (NotePO po:notePOs){

            }
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return noteVOArrayList;
    }

    @Override
    public void passAllDoc() {
        ArrayList<NoteVO> noteVOArrayList = this.getAllDoc();
        for (NoteVO vo:noteVOArrayList)
            this.passDoc(vo);
    }

    @Override
    public void passDoc(NoteVO docVO) {
        try {
            dataService.passDoc(docVO.toPO());
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }

    //TODO 此接口方法多余
    @Override
    public void failDoc(NoteVO docVO) {

    }

    @Override
    public void inputAdvice(NoteVO docVO, String advice) {
        try {
            dataService.failDoc(docVO.toPO(),advice);
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
