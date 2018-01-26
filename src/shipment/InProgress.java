package Shipment;

/**
 * Created by kusumasri on 8/3/2017.
 */
public class InProgress implements State {

    @Override
    public void shipmentStatusChange(Shipment shipment) {
        System.out.println("Shipment in progress");
        shipment.setState(this);
    }
}
