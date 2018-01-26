package System;

import java.util.ArrayList;

/**
 * Created by siddhiparekh11 on 8/3/17.
 */
public class AfricaSupplier implements Supplier {


    @Override
    public ArrayList<Product> returnProducts() {

        ArrayList<Product> africanCatalogue=new ArrayList<>();
        africanCatalogue.add(new Product("prod1","furniture","chair"));
        africanCatalogue.add(new Product("prod2","furniture","rosewood dinning table"));
        africanCatalogue.add(new Product("prod3","furniture","timberwood chair"));
        africanCatalogue.add(new Product("prod4","furniture","1940 clock"));
        africanCatalogue.add(new Product("prod5","furniture","timerwood bed"));

        return africanCatalogue;
    }
}
