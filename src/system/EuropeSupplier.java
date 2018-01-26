package System;

import java.util.ArrayList;

/**
 * Created by siddhiparekh11 on 8/3/17.
 */
public class EuropeSupplier implements Supplier {
    @Override
    public ArrayList<Product> returnProducts() {

        ArrayList<Product> europeCatalogue=new ArrayList<>();
        europeCatalogue.add(new Product("prod11","furniture","Rosewood chair"));
        europeCatalogue.add(new Product("prod12","furniture","Oakwood sofa"));
        europeCatalogue.add(new Product("prod13","furniture","Beachwood bar table"));
        europeCatalogue.add(new Product("prod14","furniture","Timerwood nightstand"));
        europeCatalogue.add(new Product("prod15","furniture","Single timerwood sofa"));
        return europeCatalogue;
    }
}
