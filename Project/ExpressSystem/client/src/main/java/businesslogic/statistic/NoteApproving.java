package businesslogic.statistic;

import businesslogicservice.statisticblservice.NoteApprovingBLService;
import util.enums.DocType;
import vo.NoteVO;

import java.util.ArrayList;

/**
 * Created by kylin on 15/11/17.
 */
public class NoteApproving implements NoteApprovingBLService {
    @Override
    public ArrayList<NoteVO> getAllDoc() {
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
