package shrishti.example.beans;

public class speakerService {
    private String speakerName;
    private int speakerCost;

    public speakerService() {

    }

    public String getSpeakerName() {
        return speakerName;
    }
    public void setSpeakerName(String speakerName) {
        this.speakerName = speakerName;
    }
    public int getSpeakerCost() {
        return speakerCost;
    }
    public void setSpeakerCost(int speakerCost) {
        this.speakerCost = speakerCost;
    }

    public speakerService(String speakerName, int speakerCost){
        this.speakerCost=speakerCost;
        this.speakerName=speakerName;
    }

}
