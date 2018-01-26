package System; /**
 * Created by siddhiparekh11 on 8/1/17.
 */
import java.util.Scanner;
//this buyer doesn't enjoy the automatic bidding option
public class FreeBuyer extends Buyer {



  FreeBuyer(String id, String name)
  {
      this.buyerId=id;
      this.buyerName=name;

  }

    public void buy(){

    }

    public void bidding(Product p)
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
            else if(temp>(p.getMinBiddingPrice()) && temp>=p.getMaxBiddingPrice())
            {
                p.setMinBiddingPrice(p.getMaxBiddingPrice());
                p.setMaxBiddingPrice(temp);
                p.setCurrHighestBidder(this);
                p.setCurrBidder(this);
                BiddingSystem.getSystemObj().notifyNewBid(p);


            }

    }





}
