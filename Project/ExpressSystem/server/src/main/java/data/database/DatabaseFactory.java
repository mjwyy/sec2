package data.database;

import data.statisticdata.inte.LogInsertDataService;
import dataservice.commoditydataservice.InventoryDataService;
import dataservice.commoditydataservice.StorageInDataService;
import dataservice.commoditydataservice.StorageOutDataService;
import dataservice.financedataservice.CreditNoteInputDataService;
import dataservice.financedataservice.PaymentInputDataService;
import dataservice.financedataservice.SettlementManagementDataService;
import dataservice.infodataservice.BankAccountManagementDataService;
import dataservice.infodataservice.DriverVehicleManagementDataService;
import dataservice.infodataservice.StaffOrganizationManagementDataService;
import dataservice.infodataservice.SystemUserManagementDataService;
import dataservice.logisticdataservice.*;
import dataservice.statisticdataservice.*;

/**
 * Created by kylin on 15/11/18.
 */
public interface DatabaseFactory{

    public InventoryDataService getInventoryDataService();

    public StorageInDataService getStorageInDataService();

    public StorageOutDataService getStorageOutDataService();

    public CreditNoteInputDataService getCreditNoteInputDataService();

    public PaymentInputDataService getPaymentInputDataService();

    public SettlementManagementDataService getSettlementManagementDataService();

    public BankAccountManagementDataService getBankAccountManagementDataService();

    public DriverVehicleManagementDataService getDriverVehicleManagementDataService();

    public StaffOrganizationManagementDataService getStaffOrganizationManagementDataService();

    public SystemUserManagementDataService getSystemUserManagementDataService();

    public ArrivalNoteOnServiceDataService getArrivalNoteOnServiceDataService();

    public ArrivalNoteOnTransitDataService getArrivalNoteOnTransitDataService();

    public DeliveryNoteInputDataService getDeliveryNoteInputDataService();

    public LoadNoteOnServiceDataService getLoadNoteOnServiceDataService();

    public LoadNoteOnTransitDataService getLoadNoteOnTransitDataService();

    public ReceivingNoteInputDataService getReceivingNoteInputDataService();

    public TransitNoteInputDataService getTransitNoteInputDataService();

    public BaseDataBuildingDataService getBaseDataBuildingDataService();

    public BusinessDataModificationDataService getBusinessDataModificationDataService();

    public ChartOutputDataService getChartOutputDataService();

    public LogInquiryDataService getLogInquiryDataService();

    public NoteApprovingDataService getNoteApprovingDataService();

    public OrderInquiryDataService getOrderInquiryDataService();
    
    public LogInsertDataService getLogInsertDataService();

}
