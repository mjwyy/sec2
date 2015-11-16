package data.financedata.MockObject;


import po.IncomeNotePO;

public class MockSettlementManagement extends IncomeNotePO{
	String receivingOrganization;
	public MockSettlementManagement(String receivingOrganization) {
	this.receivingOrganization=receivingOrganization;
	}

}
