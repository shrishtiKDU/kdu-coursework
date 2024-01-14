package shrishti.example;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Parse {
    @JsonProperty("type")
    private String type;

    @JsonProperty("data")
    private CoinData coinData;

    public Parse() {
    }
    public Parse(String type, CoinData coinData) {
        this.type = type;
        this.coinData = coinData;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public CoinData getCoinData() {
        return coinData;
    }
    public void setCoinData(CoinData coinData) {
        this.coinData = coinData;
    }
    @Override
    public String toString() {
        return "Data{" +
                "type='" + type + '\'' +
                ", coinData=" + coinData +
                '}';
    }
    public static class CoinData {
        private String coin;
        public long getVolume() {
            return volume;
        }
        public void setVolume(long volume) {
            this.volume = volume;
        }
        private long volume;
        private long quantity;
        @JsonProperty("wallet_address")
        private String walletAddress;
        private float price;
        public CoinData() {
        }

        public CoinData(String coin, long quantity, String walletAddress) {
            this.coin = coin;
            this.quantity = quantity;
            this.walletAddress = walletAddress;
        }

        public CoinData(String coin, float price) {
            this.coin = coin;
            this.price = price;
        }

        public CoinData(String coin, long volume) {
            this.coin = coin;
            this.volume = volume;
        }
        public String getCoin() {
            return coin;
        }
        public void setCoin(String coin) {
            this.coin = coin;
        }

        public long getQuantity() {
            return quantity;
        }

        public void setQuantity(long quantity) {
            this.quantity = quantity;
        }

        public String getWalletAddress() {
            return walletAddress;
        }

        public void setWalletAddress(String walletAddress) {
            this.walletAddress = walletAddress;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        // Additional methods as needed

        @Override
        public String toString() {
            return "CoinData{" +
                    "coin='" + coin + '\'' +
                    ", quantity=" + quantity +
                    ", wallet_address='" + walletAddress + '\'' +
                    ", price=" + price +
                    '}';
        }
    }
}