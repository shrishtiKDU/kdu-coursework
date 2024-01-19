package shrishti.example.entity;

public class Team {

    private String teamName;
    private Player playerId;
    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Player getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Player playerId) {
        this.playerId = playerId;
    }

    public Team(String teamName, Player playerId){
        this.teamName=teamName;
        this.playerId=playerId;
    }





}
