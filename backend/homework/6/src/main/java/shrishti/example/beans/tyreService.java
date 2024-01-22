package shrishti.example.beans;

public class tyreService {
    private String tyreName;
    private int tyreCost;

    public tyreService() {

    }
    public int getTyreCost() {
        return tyreCost;
    }
    public void setTyreCost(int tyreCost) {
        this.tyreCost = tyreCost;
    }
    public String getTyreName() {
        return tyreName;
    }

    public void setTyreName(String tyreName) {
        this.tyreName = tyreName;
    }


    public tyreService(String tyreName, int tyreCost){
        this.tyreCost=tyreCost;
        this.tyreName=tyreName;
    }


}
