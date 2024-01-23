package shrishti.example.beans;

public class Speaker {
    private String speakerName;
    private int speakerCost;

    public Speaker() {

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

    public Speaker(String speakerName, int speakerCost){
        this.speakerCost=speakerCost;
        this.speakerName=speakerName;
    }

}
