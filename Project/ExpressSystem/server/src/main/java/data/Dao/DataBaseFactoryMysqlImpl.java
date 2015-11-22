package data.dao;

import data.infodata.UserDAOProxy;
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

import java.rmi.RemoteException;

/**
 * Created by kylin on 15/11/22.
 */
public class DataBaseFactoryMysqlImpl implements DatabaseFactory{

    /**
     * 数据实现的提供工厂,单件模式
     */
    private static DataBaseFactoryMysqlImpl dataBaseFactoryMysql = null;

    //TODO 初始化所有的数据层实现
    private DataBaseFactoryMysqlImpl() throws RemoteException {
        systemUserManagementDataService = new UserDAOProxy();
    }

    public static DataBaseFactoryMysqlImpl getInstance() throws RemoteException {
        if(DataBaseFactoryMysqlImpl.dataBaseFactoryMysql == null)
            return new DataBaseFactoryMysqlImpl();
        return DataBaseFactoryMysqlImpl.dataBaseFactoryMysql;
    }

    /**
     * 所有的数据实现服务,皆为单件
     */
    //commodity
    private InventoryDataService inventoryDataService;
    private StorageInDataService storageInDataService;
    private StorageOutDataService storageOutDataService;

    //finance
    private CreditNoteInputDataService creditNoteInputDataService;
    private PaymentInputDataService paymentInputDataService;
    private SettlementManagementDataService settlementManagementDataService;

    //info
    private BankAccountManagementDataService bankAccountManagementDataService;
    private DriverVehicleManagementDataService driverVehicleManagementDataService;
    private StaffOrganizationManagementDataService staffOrganizationManagementDataService;
    private SystemUserManagementDataService systemUserManagementDataService;

    //logistic
    private ArrivalNoteOnServiceDataService arrivalNoteOnServiceDataService;
    private ArrivalNoteOnTransitDataService arrivalNoteOnTransitDataService;
    private DeliveryNoteInputDataService deliveryNoteInputDataService;
    private LoadNoteOnServiceDataService loadNoteOnServiceDataService;
    private LoadNoteOnTransitDataService loadNoteOnTransitDataService;
    private ReceivingNoteInputDataService receivingNoteInputDataService;
    private TransitNoteInputDataService transitNoteInputDataService;

    //statistic
    private BaseDataBuildingDataService baseDataBuildingDataService;
    private BusinessDataModificationDataService businessDataModificationDataService;
    private ChartOutputDataService chartOutputDataService;
    private LogInquiryDataService logInquiryDataService;
    private NoteApprovingDataService noteApprovingDataService;
    private OrderInquiryDataService orderInquiryDataService;

    @Override
    public InventoryDataService getInventoryDataService() {
        return inventoryDataService;
    }

    @Override
    public StorageInDataService getStorageInDataService() {
        return storageInDataService;
    }
    @Override
    public StorageOutDataService getStorageOutDataService() {
        return storageOutDataService;
    }

    @Override
    public CreditNoteInputDataService getCreditNoteInputDataService() {
        return creditNoteInputDataService;
    }

    @Override
    public PaymentInputDataService getPaymentInputDataService() {
        return paymentInputDataService;
    }

    @Override
    public SettlementManagementDataService getSettlementManagementDataService() {
        return settlementManagementDataService;
    }

    @Override
    public BankAccountManagementDataService getBankAccountManagementDataService() {
        return bankAccountManagementDataService;
    }

    @Override
    public DriverVehicleManagementDataService getDriverVehicleManagementDataService() {
        return driverVehicleManagementDataService;
    }

    @Override
    public StaffOrganizationManagementDataService getStaffOrganizationManagementDataService() {
        return staffOrganizationManagementDataService;
    }

    @Override
    public SystemUserManagementDataService getSystemUserManagementDataService() {
        return systemUserManagementDataService;
    }

    @Override
    public ArrivalNoteOnServiceDataService getArrivalNoteOnServiceDataService() {
        return arrivalNoteOnServiceDataService;
    }

    @Override
    public ArrivalNoteOnTransitDataService getArrivalNoteOnTransitDataService() {
        return arrivalNoteOnTransitDataService;
    }

    @Override
    public DeliveryNoteInputDataService getDeliveryNoteInputDataService() {
        return deliveryNoteInputDataService;
    }

    @Override
    public LoadNoteOnServiceDataService getLoadNoteOnServiceDataService() {
        return loadNoteOnServiceDataService;
    }

    @Override
    public LoadNoteOnTransitDataService getLoadNoteOnTransitDataService() {
        return loadNoteOnTransitDataService;
    }

    @Override
    public ReceivingNoteInputDataService getReceivingNoteInputDataService() {
        return receivingNoteInputDataService;
    }

    @Override
    public TransitNoteInputDataService getTransitNoteInputDataService() {
        return transitNoteInputDataService;
    }

    @Override
    public BaseDataBuildingDataService getBaseDataBuildingDataService() {
        return baseDataBuildingDataService;
    }

    @Override
    public BusinessDataModificationDataService getBusinessDataModificationDataService() {
        return businessDataModificationDataService;
    }

    @Override
    public ChartOutputDataService getChartOutputDataService() {
        return chartOutputDataService;
    }

    @Override
    public LogInquiryDataService getLogInquiryDataService() {
        return logInquiryDataService;
    }

    @Override
    public NoteApprovingDataService getNoteApprovingDataService() {
        return noteApprovingDataService;
    }

    @Override
    public OrderInquiryDataService getOrderInquiryDataService() {
        return orderInquiryDataService;
    }
}
