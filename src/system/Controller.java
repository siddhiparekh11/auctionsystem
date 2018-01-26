package System;

import java.util.Scanner;
import java.util.Iterator;
/**
 * Created by siddhiparekh11 on 8/1/17.
 */
public class Controller {

    public static void main(String[] args)
    {

        Scanner sc=new Scanner(System.in);
        int buyerCount=0;

        //the System.BusinessOwner is populating the catalogue (Singleton and Factory)
        System.out.println();
        System.out.println("Usecase 1: The Owner of the auction system populates the product catalogue.");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Design pattern 1: There is only one owner so Singleton is used.");
        System.out.println("Design pattern 2: Owner is concerned with the products and not the suppliers so Factory is used to populate the product database");
        System.out.println();
        BusinessOwner admin=BusinessOwner.getBusinessOwner();
        admin.setCatalogue(admin.populateCatalogue());
        admin.appendCatalogue(admin.populateCatalogue());
        admin.appendCatalogue(admin.populateCatalogue());
        System.out.println();
        System.out.println("Listing System.Product Catalogue:");
        admin.listCatalogue();



        //let's create a buyer and registered him to the owner website
        System.out.println();
        System.out.println("Usecase 2: Let's add some buyers to our system. Two types of buyers Free and Premium");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Premium buyers have automatic bidding facility and free shipment");
        System.out.println("Here simple Inheritance is used.");
        System.out.println();
        while(true) {


            System.out.println("Are you a free buyer?Y/N");
            if(sc.next().toLowerCase().equals("y"))
            {
                System.out.println("Enter your name:");
                admin.addBuyer(new FreeBuyer("System.Buyer" + buyerCount,sc.next().toString()));
            }
            else
            {
                System.out.println("Enter your name:");
                admin.addBuyer(new PremiumBuyer("System.Buyer" + buyerCount,sc.next().toString()));
            }
            System.out.println("Add more buyers?Y/N");
            if(sc.next().toLowerCase().equals("y"))
                continue;
            else
                break;

        }


        //now the admin starts bidding
        System.out.println("Usecase 3: Bidding");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Design pattern 1: Singleton for bidding system.");
        System.out.println("Design pattern 2: Observer for bidding notifications.");
        System.out.println("Design pattern 3: Iterating through buyers.");
        System.out.println();
        System.out.println("Auction starts.");
        admin.startBidding();

        //now the system will ask the buyers to participate
        System.out.println();
        System.out.println("Bidding starts.");
        System.out.println("Listing Auction Products.");
        System.out.println();
        BiddingSystem.getSystemObj().listAuctionProducts();
        Iterator i = BiddingSystem.getSystemObj().getSubscribers().iterator();
        Buyer b;
        System.out.println();
        while(i.hasNext())
        {
            b=(Buyer)i.next();
            System.out.println(b.getBuyerName()+" do you want to bid?Y/N");
            if(sc.next().toLowerCase().equals("y"))
            {
                b.initialBidding();
            }
        }

        //now the admin will stop the bidding
        System.out.println("Usecase 4: Auction is over. Now Payment and shipping");
        System.out.println("--------------------------------------------------------------------------------");
        System.out.println("Design pattern 1: Strategy for payment - Credit, Debit, Cash.");
        System.out.println("Design pattern 2: State for shipment statuses - Started, In progress, Delivered.");

        admin.stopBidding();















    }

}
