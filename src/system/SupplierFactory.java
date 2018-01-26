package System;

/**
 * Created by siddhiparekh11 on 8/3/17.
 */
public class SupplierFactory {

    public Supplier getSupplier(String supplierType){

        if(supplierType == "Africa")
            return new AfricaSupplier();
        else if(supplierType == "Europe")
            return new EuropeSupplier();
        else if(supplierType == "Asia")
            return new AsiaSupplier();

        return new AsiaSupplier();

    }
}
