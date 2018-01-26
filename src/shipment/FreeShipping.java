package Shipment;

/**
 * Created by kusumasri on 8/3/2017.
 */
public class FreeShipping extends  Shipment {

    @Override
    public int getAmount() {
        return 0;
    }

    @Override
    public void setAmount(int amount) {
        amount=0;
    }
}
