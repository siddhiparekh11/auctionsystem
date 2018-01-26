package System;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by siddhiparekh11 on 8/1/17.
 */

//Singleton class
public class BusinessOwner {
    ArrayList<Product> catalogue;

    ArrayList<Buyer> registeredBuyers;

    BiddingSystem sys;
    static int itemsLeft=0;


    public static BusinessOwner admin;
    static{
        admin=new BusinessOwner();
    }

    public static BusinessOwner getBusinessOwner()
    {



        return admin;
    }
    {
        catalogue=new ArrayList<>();
        registeredBuyers=new ArrayList<>();
    }
    public  Supplier populateCatalogue()
    {
        Scanner sc = new Scanner(System.in);
        String ans=null;
        Supplier s=null;
        SupplierFactory sf=new SupplierFactory();
        System.out.println("From which continents you want your products from? - Africa, Europe, Asia.");
        ans=sc.next();
        if(ans.toLowerCase().equals("africa"))
            s= sf.getSupplier("Africa");
        else if(ans.toLowerCase().equals("europe"))
            s=sf.getSupplier("Europe");
        else if(ans.toLowerCase().equals("asia"))
            s=sf.getSupplier("Asia");

        return s;


    }


    public void addBuyer(Buyer b)
    {
       Scanner sc=new Scanner(System.in);
       String ans=null;
        this.registeredBuyers.add(b);
        System.out.println("Do you want to subscribe to the bidding system?Y/N");
        ans=sc.next();
        if(ans.toLowerCase().equals("y")) {
            BiddingSystem.getSystemObj().subscribeBuyers(b);
            b.setSubscibed(true);

        }


    }

    public ArrayList<Buyer> getRegisteredBuyers() {
        return registeredBuyers;
    }

    public ArrayList<Product> getCatalogue() {
        return catalogue;
    }

    public void setCatalogue(Supplier s) {
        this.catalogue=s.returnProducts();
    }

    public void appendCatalogue(Supplier s)
    {

        for(int k=0;k<s.returnProducts().size();k++)
        {
            this.catalogue.add(s.returnProducts().get(k));

        }

    }

    public void addBuyerToSubscribeList(Buyer b)
    {
        if(b.isSubscibed()==false)
        {
           BiddingSystem.getSystemObj().subscribeBuyers(b);
            b.setSubscibed(true);
        }
    }

    public void startBidding()
    {

        Product[] p=new Product[5];
        for(int i=0;i<itemsLeft+5;i++)
        {
           p[i]=catalogue.get(i);
        }
        itemsLeft=itemsLeft+5;
        BiddingSystem.getSystemObj().startBidding(p,5);


    }
    public void listCatalogue()
    {

        System.out.printf("%1s %-20s %-25s", "n", "System.Product", "Minimum Bidding Price");
        System.out.println();
        for(int i=0;i<catalogue.size();i++)
        {
            System.out.printf("%1s %-20s %-25s", i+1, catalogue.get(i).getProdDesc(), catalogue.get(i).getMinBiddingPrice());
            System.out.println();
        }

    }

    public void stopBidding()
    {

       Order o=null;

        for(int i=0;i<catalogue.size();i++)
         {
             if(catalogue.get(i).getCurrHighestBidder()!=null) {
                 o = new Order(catalogue.get(i), catalogue.get(i).getCurrHighestBidder());
                 o.processPayment();
                 o.procesShipment();
             }
             else if(catalogue.get(i).getCurrBidder()!=null) {
                 o = new Order(catalogue.get(i), catalogue.get(i).getCurrBidder());
                 o.processPayment();
                 o.procesShipment();
             }



         }

    }









}
