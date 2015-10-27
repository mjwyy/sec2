package vo;

import java.util.ArrayList;

public class OrganizationInfoVO {
	
	/**
	 * 机构编号
	 */
	private String organizationNum;
	
	/**
	 * 机构名称
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
	public OrganizationInfoVO(String organizationNum,String type,String name,ArrayList<StaffVO> staffinfo){
		this.organizationNum = organizationNum;
		this.staffinfo = staffinfo;
		this.type = type;
		this.name = name;
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
