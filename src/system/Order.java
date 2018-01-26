package System;

import java.util.Scanner;

import Payment.*;
import Shipment.*;

/**
 * Created by kusumasri on 8/4/2017.
 */
public class Order {
    public int orderid;
    public static int count=0;
    Product product;
    Buyer buyer;
    Shipment shipment;

    public Order(Product product, Buyer buyer)
    {
        this.product=product;
        this.buyer=buyer;
        count++;
        this.orderid=count;
        if(buyer instanceof FreeBuyer)
        {
            shipment=new PaidShipping();
        }
        else
        {
            shipment=new FreeShipping();
        }

    }

    public void  viewOrder()
    {

        System.out.println(" System.Product Name"+product.getProdDesc()+"\n"+"Amount to be paid"+product.getMinBiddingPrice());
    }

    public void processPayment()
    {

        Double amountToPay=product.getMinBiddingPrice();
        PaymentSelection paymentSelection=new PaymentSelection();
        System.out.println("Adding amount for shipment");
        amountToPay+=shipment.getAmount();
        System.out.println("The winner is: " + buyer.getBuyerName());

        System.out.println("Total amount to be paid "+amountToPay);
        System.out.println("Please enter Payment Type : 'CreditCard' or 'DebitCard' or 'ByCash'");
        Scanner scanner = new Scanner(System.in);
        String paymentType = scanner.next();
        System.out.println("Payment type is : " + paymentType);

        if( "CreditCard".equalsIgnoreCase(paymentType) )
        {
            paymentSelection.setPaymentMethod(new Creditcard());
        }
        else if( "DebitCard".equalsIgnoreCase(paymentType) )
        {
            paymentSelection.setPaymentMethod(new Debitcard());
        }
        else if( "ByCash".equalsIgnoreCase(paymentType) )
        {
            paymentSelection.setPaymentMethod(new Cash());
        }

        System.out.println("PaymentContext has : "+paymentSelection.getpaymentmethod());

        paymentSelection.pay(Double.toString(amountToPay));

    }

    public void procesShipment()
    {
        StartedShipment started=new StartedShipment();
        started.shipmentStatusChange(shipment);
        System.out.println("After two days");
        InProgress inprogress=new InProgress();
        inprogress.shipmentStatusChange(shipment);
        System.out.println("After 3 days");
        Delivered delivered=new Delivered();
        delivered.shipmentStatusChange(shipment);

    }

}
