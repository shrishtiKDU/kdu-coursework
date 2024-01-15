package shrishti.example;
import java.io.BufferedReader;

import java.nio.file.Path;

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
    public static void main(String[] args) {

    }
    public static ArrayList<String[]> parseCSV(Path path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path.toString()))) {
            ArrayList<String[]> data = new ArrayList<>();

            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                String[] columns = line.split(",");

                if(columns.length == 6) {
                    Coin c = new Coin(Integer.parseInt(columns[1]), columns[2], columns[3], Double.parseDouble(columns[4]), Long.parseLong(columns[5]));
                    MarketPlace.getListOfCoins().add(c);
                } else if (columns.length == 5) {
                    Trader t = new Trader(columns[1], columns[2], columns[3], columns[4]);
                    MarketPlace.getListOfTraders().add(t);
                }

                data.add(columns);
            }
            return data;
        } catch (IOException I) {
            System.out.println(I);
        }

        return null;
    }
    public static JsonNode parseJsonFile(String path) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            return objectMapper.readTree(new File(path));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static void executeTransactions(JsonNode jsonTransactions, CountDownLatch
            latch) throws JsonProcessingException, InterruptedException {
        ExecutorService execService = Executors.newFixedThreadPool(10);

        ObjectMapper objectMapper = new ObjectMapper();
        Parse[] transactions = objectMapper.treeToValue(jsonTransactions, Parse[].class);

        ArrayList<Parse> transactionArrayList = new ArrayList<>();
        Collections.addAll(transactionArrayList, transactions);

        for(Parse obj : transactionArrayList) {
            execService.execute(new PerformTxn(obj, latch));
        }

        latch.await();

        execService.shutdown();
    }
}












