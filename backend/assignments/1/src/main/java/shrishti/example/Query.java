package shrishti.example;

import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import shrishti.example.Logger.logger;

public class Query {
    public static void retrieveCoinDetails(String coinName) {
        Coin c = null;
        for(Coin n : MarketPlace.getListOfCoins())
            if(Objects.equals(n.getName(), coinName)) {
                c = n;
            } else if(Objects.equals(n.getSymbol(), coinName)) {
                c = n;
            }

        assert c != null;
        logger.printOutput(c.toString());
    }

    public static void retrieveTopCoins(int n) {
        List<Coin> topCoins = MarketPlace.getListOfCoins().stream()
                .sorted(Comparator.comparingDouble(Coin::getPrice).reversed())
                .limit(n).collect(Collectors.toList());;

        logger.printMessage("Top " + n + " coins based on price:");
        topCoins.forEach(coin ->  logger.printMessage(coin.getName() + ": $" + coin.getPrice()));
    }

    public static void traderPortfolio(String walletAddress) {
        Trader t = null;
        for(Trader x : MarketPlace.getListOfTraders()) {
            if(Objects.equals(x.getWalletAddress(), walletAddress))
                t = x;
        }

        assert t != null;
        logger.printMessage("Trader " + t.getFirstNme() + " " +  t.getLastNme() + "'s Portfolio:");
        t.getWallet().forEach((coin, quantity) ->  System.out.println(coin + " " + quantity));

    }

    public static void traderProfitLoss(String walletAddress) {
        Trader t = null;
        for(Trader x : MarketPlace.getListOfTraders()) {
            if(Objects.equals(x.getWalletAddress(), walletAddress))
                t = x;
        }

        assert t != null;
        logger.printMessage("Trader " + t.getFirstNme() + " " +  t.getLastNme() + "'s Profit Loss:");
        logger.printMessage((Double.toString(t.getProfitLoss())));
    }

    public static void topBottomTraders() {
        List<Trader> top5Traders = MarketPlace.getListOfTraders().stream()
                .sorted(Comparator.comparingDouble(Trader::getProfitLoss).reversed())
                .limit(5).collect(Collectors.toList());

        logger.printMessage("Top 5 Traders based on Profit/Loss:");
        top5Traders.forEach(trader ->
                logger.printMessage(trader.getFirstNme() + ": $" + trader.getProfitLoss())
        );

        List<Trader> bottom5Traders = MarketPlace.getListOfTraders().stream()
                .sorted(Comparator.comparingDouble(Trader::getProfitLoss))
                .limit(5).collect(Collectors.toList());

        logger.printMessage("\nBottom 5 Traders based on Profit/Loss:");
        bottom5Traders.forEach(trader ->
                logger.printMessage(trader.getFirstNme() + ": $" + trader.getProfitLoss())
        );
    }
}









