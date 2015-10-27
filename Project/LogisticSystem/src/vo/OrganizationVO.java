package vo;

import java.util.ArrayList;

public class OrganizationVO {
	
	/**
	 * 机构编号
	 */
	private String organizationNum;
	
	/**
	 * 机构名
	 */
	private String name;
	
	/**
	 * 机构类型
	 */
	private String type;
	
    /**
     * 机构内人员信息
     */
	private ArrayList<StaffVO> staffinfo;
	
	/**
	 * @param organizationNum
	 * @param staffinfo
	 */
	public OrganizationVO(String organizationNum, String name, String type,
			ArrayList<StaffVO> staffinfo) {
		super();
		this.organizationNum = organizationNum;
		this.name = name;
		this.type = type;
		this.staffinfo = staffinfo;
	}

	public String getOrganizationNum() {
		return organizationNum;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public ArrayList<StaffVO> getStaffinfo() {
		return staffinfo;
	}
	
	

}
