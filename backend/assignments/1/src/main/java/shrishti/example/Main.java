package shrishti.example;
import java.io.BufferedReader;
import shrishti.example.Logger.logger;
import java.util.*;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws IOException {

        Map<Integer, Trader> traderMap= new HashMap<Integer, Trader>();
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/coins.csv"));
        String line;
        br.readLine();
        while ((line = br.readLine()) != null) {
            // Split the line into columns
            String[] columns = line.split(",");
            Coin myCoin = new Coin();
            myCoin.setRank(Integer.parseInt(columns[1]));
            myCoin.setSymbol(columns[3]);
            myCoin.setPrice(Double.parseDouble(columns[4]));
            myCoin.setCirculatingSupply(Double.parseDouble(columns[5]));
            myCoin.setName(columns[2]);
        }


        BufferedReader txnBr = new BufferedReader(new FileReader("src/main/resources/traders.csv"));
        String traderline;
        txnBr.readLine();
        while ((traderline = txnBr.readLine())!=null){
            String[] txnColumn = traderline.split(",");
            Trader myTrader = new Trader();
            myTrader.setFirstName(txnColumn[1]);
            myTrader.setLastName(txnColumn[2]);
            myTrader.setPhone(txnColumn[3]);
            myTrader.setWalletAddress(txnColumn[4]);
            traderMap.put(Integer.parseInt(txnColumn[0]), myTrader);

        }

        String jsonFilePath = "src/main/resources/small_transaction.json";
        ObjectMapper objectMapper = new ObjectMapper();
        CountDownLatch latch=new CountDownLatch(3);
        try {
            JsonNode jsonNode;
            jsonNode = objectMapper.readTree(new File(jsonFilePath));
            executeTransactions(jsonNode, latch);
            logger.printMessage("JSON content as JsonNode: \n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void executeTransactions(JsonNode jsonTransactions, CountDownLatch latch)
        throws JsonProcessingException{
            ExecutorService performService = Executors.newFixedThreadPool(10);
            ObjectMapper objectMapper = new ObjectMapper();
            Parse[] transactions = objectMapper.treeToValue(jsonTransactions, Parse[].class);
            ArrayList<Parse> transactionArray = new ArrayList<>();
            Collections.addAll(transactionArray, transactions);
            for(Parse obj: transactionArray){
                performService.execute(new PerformTxn(obj));
            }
            performService.shutdown();

        }
    }



