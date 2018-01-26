package Shipment;

/**
 * Created by kusumasri on 8/3/2017.
 */
public class StartedShipment implements State {

    @Override
    public void shipmentStatusChange(Shipment shipment) {
        System.out.println("Shipment has started");
        shipment.setState(this);
    }
}
