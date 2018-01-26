package Shipment;

/**
 * Created by kusumasri on 8/3/2017.
 */
public class PaidShipping extends Shipment {

    @Override
    public int getAmount() {
        return 100;
    }

    @Override
    public void setAmount(int amount) {
        amount=100;
    }

}
