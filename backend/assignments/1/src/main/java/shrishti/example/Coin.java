package shrishti.example;
import shrishti.example.Logger.logger;

public class Coin {
    private int rank;
    private String name;
    private String symbol;
    private double price;
    private long availableQuantity;
    private double circulatingSupply;

    public Coin() {

    }


    public int getRank(){
        return rank;
    }
    public void setRank(int rank){
        this.rank=rank;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }

    public String getSymbol(){
        return symbol;
    }
    public void setSymbol(String symbol){
        this.symbol=symbol;

    }
    public double getPrice(){
        return price;
    }
    public void setPrice(Double price){
        this.price=price;
    }
    public double getCirculatingSupply(){
        return circulatingSupply;
    }
    public void setCirculatingSupply(double circulatingSupply){
     this.circulatingSupply=circulatingSupply;
    }
    public synchronized long getavailableQuantity(){
        return availableQuantity;
    }



    public synchronized void increaseQuantity(long amount){
        if(availableQuantity + amount <= circulatingSupply){
            availableQuantity+=amount;
        }else{
            logger.printMessage("Exceeded the max quantity " + name);
        }
    }
    public synchronized void updatePrices(double updatedPrice){
        this.price=updatedPrice;
    }

    public Coin(int rank, String name, String symbol, double price, long circulatingSupply){
        this.rank = rank;
        this.name=name;
        this.symbol = symbol;
        this.price = price;
        this.availableQuantity =0;
        this.circulatingSupply=circulatingSupply;

    }


    public synchronized boolean buyCoins(Trader buyer, long quantityNeeded){
        if(availableQuantity >= quantityNeeded){
         availableQuantity -= quantityNeeded;
         buyer.addingCoins(this, quantityNeeded);
         return true;
        }
        logger.printOutput("Coin in market" + availableQuantity);
       logger.printMessage("coin market quantity" + quantityNeeded);
        return false;

    }
    public synchronized boolean sellCoins (Trader seller, long quantityAvailableToSell){
        if(seller.getOwnedQuantity(this)>quantityAvailableToSell && quantityAvailableToSell + availableQuantity <circulatingSupply){
           availableQuantity += quantityAvailableToSell;
            seller.removingCoins(this,  quantityAvailableToSell );
            return true;
        }
        logger.printOutput("COin market quantity" + availableQuantity);
        seller.removingCoins(this, quantityAvailableToSell);
        return false;
    }

    @Override
    public String toString() {
        return "Coin" +
                "name=" + name + '\'' +
                ", quantity=" + availableQuantity +
                ", supply='" + circulatingSupply + '\'' +
                ", price=" + price +'\''+
                ", symbol='"+ symbol + '\''+
                ",rank=" + rank+
                '}';
    }

}
