package System;

import java.util.Scanner;

/**
 * Created by siddhiparekh11 on 8/1/17.
 */
//automatic bidding will be done for this buyer
public class PremiumBuyer extends Buyer {

    PremiumBuyer(String id, String name)
    {
        this.buyerId=id;
        this.buyerName=name;

    }

    public void buy(){

    }
    public void bidding(Product p)
    {
        if(p.getCurrHighestBidder()==null || p.getCurrHighestBidder().equals(this)==false)
        {
            double temp;
            Scanner sc=new Scanner(System.in);
            System.out.println("The minimum bid amount is " + (p.getMinBiddingPrice()+1));
            System.out.println("Enter your bid amount:");
            temp=sc.nextDouble();
            if(temp>(p.getMinBiddingPrice()) && temp<p.getMaxBiddingPrice()) {

                p.setMinBiddingPrice(temp);
                p.setCurrBidder(this);
                BiddingSystem.getSystemObj().notifyNewBid(p);



            }
            else if(temp>(p.getMinBiddingPrice()) && temp>p.getMaxBiddingPrice())
            {
                p.setMinBiddingPrice(p.getMaxBiddingPrice());
                p.setMaxBiddingPrice(temp);
                p.setCurrHighestBidder(this);
                p.setCurrBidder(this);
                BiddingSystem.getSystemObj().notifyNewBid(p);


            }

        }
        else
        {
            automaticBidding(p);
        }


    }
    public void automaticBidding(Product p)
    {
        System.out.println("Automatic Bidding.");
        p.setMinBiddingPrice(p.getMinBiddingPrice()+1);
        p.setCurrBidder(this);
        BiddingSystem.getSystemObj().notifyNewBid(p);

    }


}
