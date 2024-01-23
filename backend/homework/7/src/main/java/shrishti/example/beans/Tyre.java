package shrishti.example.beans;

public class Tyre {
    private String tyreName;
    private int tyreCost;

    public Tyre() {

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


    public Tyre(String tyreName, int tyreCost){
        this.tyreCost=tyreCost;
        this.tyreName=tyreName;
    }


}
