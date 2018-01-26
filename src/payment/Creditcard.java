package Payment;

/**
 * Created by kusumasri on 8/3/2017.
 */
public class Creditcard implements Payment {
    @Override
    public void pay(String amount) {
        System.out.println("Payment done using credit card: " + amount);
    }
}
