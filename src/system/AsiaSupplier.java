package System;

import java.util.ArrayList;

/**
 * Created by siddhiparekh11 on 8/3/17.
 */
public class AsiaSupplier implements Supplier {
    @Override
    public ArrayList<Product> returnProducts() {
        ArrayList<Product> asiaCatalogue=new ArrayList<>();
        asiaCatalogue.add(new Product("prod6","furniture","Beech wood chair"));
        asiaCatalogue.add(new Product("prod7","furniture","Oak wood dinning table"));
        asiaCatalogue.add(new Product("prod8","furniture","Timberwood center table"));
        asiaCatalogue.add(new Product("prod9","furniture","Rosewood Nightstand"));
        asiaCatalogue.add(new Product("prod10","furniture","Oak wood bed"));

        return asiaCatalogue;
    }
}
