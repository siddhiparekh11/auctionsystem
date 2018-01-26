package System;

/**
 * Created by siddhiparekh11 on 8/1/17.
 */
public class BuyerFactory {

    public Buyer getBuyer(String buyerType, String id, String name){

        if(buyerType == null)
            return new FreeBuyer(id,name);
        else if(buyerType == "Premium")
            return new PremiumBuyer(id,name);
        else if(buyerType == "Free")
            return new FreeBuyer(id,name);

           return new FreeBuyer(id,name);

    }


}
