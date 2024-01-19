package shrishti.example.entity;

public class Player {

    private String name;
    private String team;
    private String role;
    private int matches;
    private int runs;
    private float average;

    private float sr;

    private int wickets;

    public Player() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public int getWickets() {
        return wickets;
    }

    public void setWickets(int wickets) {
        this.wickets = wickets;
    }

    public float getSr() {
        return sr;
    }

    public void setSr(float sr) {
        this.sr = sr;
    }
    public float getAverage() {
        return average;
    }

    public void setAverage(float average) {
        this.average = average;
    }
    public int getMatches() {
        return matches;
    }

    public void setMatches(int matches) {
        this.matches = matches;
    }
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }
    public int getRuns() {
        return runs;
    }
    public void setRuns(int runs) {
        this.runs = runs;
    }
    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public Player(String name, String team, String role, int matches, int runs, float average, float sr, int wickets){
        this.name=name;
        this.team=team;
        this.role=role;
        this.average=average;
        this.sr=sr;
        this.wickets=wickets;
        this.matches=matches;
        this.runs=runs;
    }




}