package System; /**
 * Created by siddhiparekh11 on 8/1/17.
 */

import java.util.ArrayList;

public class Product {

    String prodId;
    String prodType;
    String prodDetails;
    String prodDesc;

    double minBiddingPrice;
    double maxBiddingPrice;
    Buyer currHighestBidder;
    Buyer currBidder;
    ArrayList<Buyer> myBidders;




    boolean sold;

    public Buyer getCurrBidder() {
        return currBidder;
    }

    public void setCurrBidder(Buyer currBidder) {
        this.currBidder = currBidder;
    }

    public void addMyBidders(Buyer b)
    {
        myBidders.add(b);

    }
    {
        myBidders=new ArrayList<>();
    }

    public ArrayList<Buyer> getMyBidders() {
        return myBidders;
    }

    public Product(String id, String type,String desc)
    {
        this.prodId=id;
        this.prodType=type;
        this.prodDetails="";
        this.prodDesc=desc;

        this.minBiddingPrice=10.0;
        this.maxBiddingPrice=20.0;

        this.sold=false;

    }

    public void setMinBiddingPrice(double minBiddingPrice) {
        this.minBiddingPrice = minBiddingPrice;
    }

    public void setSold(boolean sold) {
        this.sold = sold;
    }

    public boolean isSold() {
        return sold;
    }

    public String getProdType() {
        return prodType;
    }

    public String getProdDetails() {
        return prodDetails;
    }

    public String getProdDesc() {
        return prodDesc;
    }



    public double getMinBiddingPrice() {
        return minBiddingPrice;
    }

    public double getMaxBiddingPrice() {
        return maxBiddingPrice;
    }

    public void setMaxBiddingPrice(double maxBiddingPrice) {
        this.maxBiddingPrice = maxBiddingPrice;
    }

    public Buyer getCurrHighestBidder() {
        return currHighestBidder;
    }

    public void setCurrHighestBidder(Buyer currHighestBidder) {
        this.currHighestBidder = currHighestBidder;
    }
}
