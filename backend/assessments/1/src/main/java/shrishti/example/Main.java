package shrishti.example;
import java.io.BufferedReader;
//import shrishti.example.Logger.logger;


import shrishti.example.entity.DataCenter;
import shrishti.example.entity.Player;


import java.io.FileReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/IPL_2021-data.csv"));
        String line;
        br.readLine();
        while ((line = br.readLine()) != null) {
            // Split the line into columns
            String[] columns = line.split(",");
            Player myPlayer = new Player();
            myPlayer.setName(columns[0]);
            myPlayer.setTeam(columns[1]);
            myPlayer.setRole(columns[2]);
            myPlayer.setMatches(Integer.parseInt(columns[3]));
            myPlayer.setRuns(Integer.parseInt(columns[4]));
            myPlayer.setAverage(Float.parseFloat(columns[5]));
            myPlayer.setSr(Float.parseFloat(columns[6]));
            myPlayer.setWickets(Integer.parseInt(columns[7]));


            DataCenter.getPlayerList().add(myPlayer);
            DataCenter.addToTeam(myPlayer,columns[1]);
        }



    }
}