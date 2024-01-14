package shrishti.example;
import java.util.Map;
import shrishti.example.Logger.logger;

public class Trader {
    private String firstName;
    private String lastName;
    private String phone;
    private String walletAddress;
    private double profitLoss;

    public Trader() {

    }

    public String getFirstNme() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastNme() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getWalletAddress() {
        return walletAddress;
    }

    public void setWalletAddress(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    public double getProfitLoss() {
        return profitLoss;
    }

    public void setProfitLoss(double profitLoss) {
        this.profitLoss = profitLoss;
    }

    public Map<Coin, Long> getWallet() {
        return wallet;
    }

    public void setWallet(Map<Coin, Long> wallet) {
        this.wallet = wallet;
    }

    private Map<Coin, Long> wallet;

    public Trader(String firstName, String lastName, String phone, String walletAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.walletAddress = walletAddress;
    }
    public synchronized void addingCoins(Coin coin, long quantity) {
        wallet.put(coin, wallet.getOrDefault(coin, 0L) + quantity);
        profitLoss -= coin.getPrice() * quantity;
    }
    public synchronized void removingCoins(Coin coin, long quantity){
        long currentlyQuantity = wallet.get(coin);
        if (currentlyQuantity >= quantity) {
            wallet.put(coin, currentlyQuantity - quantity);
            profitLoss += coin.getPrice() * quantity;
        } else {
            logger.printOutput("Selling not possible by" + firstName + " " + lastName);
        }
    }
    public synchronized long getOwnedQuantity(Coin coin) {
        return wallet.getOrDefault(coin, 0L);
    }
}


