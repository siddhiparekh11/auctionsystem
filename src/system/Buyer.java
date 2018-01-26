package System;

import java.util.Scanner;

/**
 * Created by siddhiparekh11 on 8/1/17.
 */
public abstract class Buyer {

  String buyerId;
  String buyerName;
  boolean subscibed;

  int bidItemsCount;

  public abstract void buy();
  public abstract void bidding(Product p);
  public void update(String status)
  {
      if(status.equals("Started"))
      {
          System.out.println(this.buyerName + " has been notified for auction started");
      }

      else if(status.equals("Stopped"))
      {
          System.out.println(this.buyerName + " has been notified for the stopped auction");
      }
  }
  public void update1(String status, Product p)
  {
      Scanner sc= new Scanner(System.in);
      if(status.equals("NewBid"))
    {
      System.out.println(this.buyerName + " has been notified for the updated bid");
      System.out.println(this.buyerName + " do you wish to follow up the" + p.getProdDesc() + " bid?");
      if(sc.next().toLowerCase().equals("y"))
       bidding(p);

    }
  }


  public void initialBidding()
  {
    Product[] p;
    Scanner sc=new Scanner(System.in);
    p= BiddingSystem.getSystemObj().getAuctionProducts();
    double temp;
    for(int i=0;i<p.length;i++)
    {
      System.out.println("Do you want to bid for this product:" + p[i].getProdDesc() + " Y/N");
      if(sc.next().toLowerCase().equals("y"))
      {
        System.out.println("The minimum bid amount is " + (p[i].getMinBiddingPrice()+1));
          System.out.println("The maximum  bid 4 this product is " + (p[i].getMaxBiddingPrice()));
        System.out.println("Enter your bid amount:");
        temp=sc.nextDouble();

          if(temp>(p[i].getMinBiddingPrice()) && temp< (p[i].getMaxBiddingPrice())) {




          p[i].setMinBiddingPrice(temp);
              p[i].addMyBidders(this);
             p[i].setCurrBidder(this);
          BiddingSystem.getSystemObj().notifyNewBid(p[i]);



          break;
        }
        else if(temp>(p[i].getMinBiddingPrice()) && temp>=(p[i].getMaxBiddingPrice()))
        {
            p[i].setMinBiddingPrice(p[i].getMaxBiddingPrice());
            p[i].setMaxBiddingPrice(temp);
          p[i].setCurrHighestBidder(this);
            p[i].addMyBidders(this);
            p[i].setCurrBidder(this);
          BiddingSystem.getSystemObj().notifyNewBid(p[i]);


          break;
        }
        else {
          System.out.println("Your bid amound is lower or equal to than the current bid");
          i = i - 1;
          continue;
        }

      }

    }
  }

    public boolean isSubscibed() {
        return subscibed;
    }

    public String getBuyerName() {
        return buyerName;
    }

    public void setBuyerName(String buyerName) {
        this.buyerName = buyerName;
    }

    public void setSubscibed(boolean subscibed) {
        this.subscibed = subscibed;
    }
}
