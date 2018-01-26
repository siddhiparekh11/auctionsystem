package Shipment;

/**
 * Created by kusumasri on 8/3/2017.
 */

public class Shipment {

    private State state;
    protected int amount;


    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Shipment()
    {
        state=null;
    }

    public void setState(State state){

        this.state = state;
    }

    public State getState(){
        return state;
    }

}
