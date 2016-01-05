package businesslogic.logistic.deliverystrategy;

import dataservice.exception.ElementNotFoundException;

import java.rmi.RemoteException;
import java.sql.SQLException;

/**
 * Created by kylin on 16/1/5.
 */
public interface PriceStrategy {

    public double getPrice(DeliveryInfo deliveryInfo,PriceInfo priceInfo)
            throws ElementNotFoundException, RemoteException, SQLException;
}

