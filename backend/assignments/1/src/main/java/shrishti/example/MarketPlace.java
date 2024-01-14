package shrishti.example;

import java.util.ArrayList;
import java.util.Random;
public class MarketPlace {
    static ArrayList<Coin> listOfCoin= new ArrayList<>();
    public static ArrayList<Coin> getListOfCoins(){return listOfCoin;}

    public void setListOfCoin(ArrayList<Coin> listOfCoin) {
        this.listOfCoin = listOfCoin;
    }
   static ArrayList<Trader> listOfTraders = new ArrayList<>();
    public static ArrayList<Trader> getListOfTraders(){
        return listOfTraders;
    }
    public void setListOfTraders(ArrayList<Trader> listOfTraders) {
        this.listOfTraders= listOfTraders;
    }

    private String getBlockHash() {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder transactionHash = new StringBuilder();
        Random rnd = new Random();

        for (double i = 0; i < 199999999; i++) {
            i = i;
        }
        while (transactionHash.length() < 128) {
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            transactionHash.append(SALTCHARS.charAt(index));
        }
        String hashCode = transactionHash.toString();
        return "0x" + hashCode.toLowerCase();
    }



}
