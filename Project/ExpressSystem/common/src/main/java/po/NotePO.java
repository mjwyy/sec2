/**
 * NOTEPO
 * 所有单据的父类
 * @author wqy
 * @date 2015/10/17
 */
package po;

import java.io.Serializable;

import util.enums.DocState;
import vo.NoteVO;

public abstract class NotePO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5768739830941620932L;

	// 创建这个单据的业务员信息
    private StaffPO userName;

	private DocState state;

	public DocState getState() {
		return state;
	}

	public void setState(DocState state) {
		this.state = state;
	}

    public StaffPO getUserName() {
        return userName;
	}

    public NoteVO toVO(){
        return null;
    }

}
