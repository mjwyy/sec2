package businesslogicservice.statisticblservice._driver;

import businesslogicservice.statisticblservice.NoteApprovingBLService;
import vo.NoteVO;

public class NoteApprovingBLService_Driver {

	public void drive(NoteApprovingBLService service){
		service.getAllDoc();
		service.getDocByType(null);
		service.passAllDoc();
		service.passDoc(new NoteVO(){});
		service.failDoc(new NoteVO(){});
		service.inputAdvice(new NoteVO(){}, "declined");
	}
	
}
