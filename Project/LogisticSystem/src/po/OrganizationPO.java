package po;

import java.io.Serializable;
import java.util.ArrayList;

public class OrganizationPO implements Serializable {

	private static final long serialVersionUID = 7828206175791394318L;

	String type = null;
	String code = null;
	String name = null;
	ArrayList<StaffPO> staff = null;
	
}
