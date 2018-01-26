package Payment;

/**
 * Created by kusumasri on 8/3/2017.
 */
public class PaymentSelection {
    private Payment payment;

    public void setPaymentMethod(Payment payment)
    {
        this.payment=payment;
    }

    public Payment getpaymentmethod()
    {
        return payment;
    }

    public void pay(String amount)
    {
        payment.pay(amount);
    }

}
