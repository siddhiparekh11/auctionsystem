package System;

import java.util.ArrayList;

/**
 * Created by siddhiparekh11 on 8/3/17.
 */
public class BiddingSystem {

    ArrayList<Buyer> subscribers;
    Product[] auctionProducts;

    int biddingHours;

    public static BiddingSystem sysObj;
    static{
        sysObj=new BiddingSystem();
    }
    public static BiddingSystem getSystemObj()
    {


        return sysObj;
    }
    {
        auctionProducts=new Product[5];
        subscribers=new ArrayList<>();

    }
    public void subscribeBuyers(Buyer b)
    {
        subscribers.add(b);
    }

    public void startBidding(Product[] p,int biddingHours)
    {
             auctionProducts=p;
            notifyAllBuyers("AuctionStarted");
    }

    public void notifyAllBuyers(String operation)
    {
          if(operation.equals("AuctionStarted"))
          {
                for(Buyer b:subscribers)
                {
                    b.update("Started");
                }

          }

          else if(operation.equals("AuctionStopped"))
          {

              for(Buyer b:subscribers)
              {
                  b.update("Stopped");
              }
          }
    }
    public void notifyNewBid(Product p)
    {
        for(Buyer b: p.getMyBidders())
        {
            if(b!=p.getCurrBidder())
            b.update1("NewBid",p);
        }
    }
    public void listAuctionProducts()
    {
        System.out.printf("%1s %-20s %-25s", "n", "System.Product", "Minimum Bidding Price");
        System.out.println();
        for(int i=0;i<auctionProducts.length;i++)
        {
            System.out.printf("%1s %-20s %-25s", i+1, auctionProducts[i].getProdDesc(), auctionProducts[i].getMinBiddingPrice());
            System.out.println();
        }


    }

    public void endBidding()
    {
        notifyAllBuyers("AuctionStopped");
    }
    public Product[] getAuctionProducts() {
        return auctionProducts;
    }

    public ArrayList<Buyer> getSubscribers() {
        return subscribers;
    }
}
