package shrishti.example.entity;
import java.util.*;
import shrishti.example.Logger.logger;
public class DataCenter {


    static ArrayList<Player> listOfPlayers= new ArrayList<>();
    public static ArrayList<Player> getPlayerList(){return listOfPlayers;}
    static HashMap<String, List<Player>> teamListAndPlayer = new HashMap<>();
  //  static ArrayList<Team> listOfTeams = new ArrayList<Team>();

    public static void addToTeam(Player player, String team){
        if(team=="CSK"){
           teamListAndPlayer.put("CSK", Arrays.asList(player));
        }
        if(team == "PBKS"){
            teamListAndPlayer.put("PBKS", Arrays.asList(player));
        }
        if(team=="KKR"){
            teamListAndPlayer.put("KKR", Arrays.asList(player));
        }
        if(team == "DC"){
            teamListAndPlayer.put("DC", Arrays.asList(player));
        }
        if(team == "SRH"){
            teamListAndPlayer.put("SRH", Arrays.asList(player));
        }
        if(team == "RCB"){
            teamListAndPlayer.put("RCB", Arrays.asList(player));
        }

        if(team == "MI"){
            teamListAndPlayer.put("MI", Arrays.asList(player));
        }

        if(team == "RR"){
            teamListAndPlayer.put("RR", Arrays.asList(player));
        }
    }

    void topWicketTakers(int n){
        List<Player> topWicketTakers =listOfPlayers.values().stream().sorted(Comparator.comparing(Player::getWickets).reversed()).limit(n).toList();
        for(Player player : topWicketTakers){
            logger.printOutput(player.getName(), 1);
        }
    }

    void topRunGetters(int n){
        List<Player> topRunGetters = players.values().stream().sorted(Comparator.comparing(Player::getRuns).reversed()).limit(n).toList();
        for(Player player : topRunGetters){
          logger.printOutput(player.getName(),1);
        }
    }

    void goodWicketTakers(){
        List<Player> goodWicketTakers = players.values().stream().filter(player-> player.getWickets() >=40).toList();
        for(Player player : goodWicketTakers){
         logger.printOutput(player.getName(),1);
        }
    }
    



}
