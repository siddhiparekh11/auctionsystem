package Payment;

/**
 * Created by kusumasri on 8/3/2017.
 */
public class Debitcard implements Payment{

    @Override
    public void pay(String amount) {
        System.out.println("payment done with debit card: " + amount);
    }
}
