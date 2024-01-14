package shrishti.example;
import shrishti.example.Logger.logger;
import java.util.Objects;
import java.util.Random;

public class Transaction {
    public enum Type{
        BUY,
        SELL,
        UPDATEPRICE,
        ADDVOLUME
    }
    private  Parse.CoinData coin;
    private Type onGoingTxn;
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
    public Transaction(Parse.CoinData coin, Type onGoingTxn){
        this.coin=coin;
        this.onGoingTxn=onGoingTxn;
    }
    public synchronized void buy() throws InterruptedException{
        Trader trader = searchTrader(coin.getWalletAddress());
        Coin newCoin = null;
        for(Coin coinA : MarketPlace.getListOfCoins()){
            if(Objects.equals(coinA.getSymbol(), coin.getCoin()))
                newCoin=coinA;
        }
        while(!newCoin.buyCoins(trader, coin.getQuantity())){
            logger.printMessage("coins are being bought");
            wait();
        }
        logger.printMessage("Purchase done");
        logger.printOutput(newCoin.getName()+" "+newCoin.getavailableQuantity());
        notifyAll();
    }
    public synchronized void sell() throws InterruptedException{
        Trader trader = searchTrader(coin.getWalletAddress());
        Coin newCoin = null;
        for(Coin coin1: MarketPlace.getListOfCoins()){
            if(Objects.equals(coin1.getSymbol(),coin.getCoin()))
                newCoin = coin1;
        }
        while(!newCoin.sellCoins(trader, coin.getQuantity())){
            logger.printMessage("Selling is being executed");
            wait();
        }
        logger.printMessage("Selling done");
        logger.printOutput(newCoin.getName()+" "+newCoin.getavailableQuantity());
        notifyAll();
    }

    public void update(){
        Coin newCoin = null;
        for(Coin coinA  : MarketPlace.getListOfCoins()) {
            if (Objects.equals(coinA.getSymbol(), coin.getCoin())) {
            newCoin = coinA;
        }
        }
        assert newCoin != null;
        newCoin.updatePrices(coin.getPrice());
    }

    public synchronized void add(){
        Coin newCoin = null;
        for(Coin coinA  : MarketPlace.getListOfCoins()) {
            if (Objects.equals(coinA.getSymbol(), coin.getCoin())) {
                newCoin = coinA;
            }
        }
        assert newCoin != null;
        newCoin.increaseQuantity(coin.getVolume());
            logger.printMessage("Adding new coins ");
            logger.printOutput(newCoin.getName()+" "+ newCoin.getavailableQuantity());
            notifyAll();
    }
        public Trader searchTrader(String walletAddress){
            for(Trader traderA: MarketPlace.getListOfTraders()){
                if(Objects.equals(traderA.getWalletAddress(), walletAddress))
                    return traderA;
            }
            return null;

    }

}
