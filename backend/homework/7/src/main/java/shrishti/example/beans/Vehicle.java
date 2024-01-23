package shrishti.example.beans;

public class Vehicle {
    private Speaker speaker;
    private Tyre tyre;
    private int priceTag;

    private double cost;



    public int getPriceTag() {return priceTag;}
    public Tyre getTyre() {
        return tyre;
    }
    public void setTyre(Tyre tyre) {
        this.tyre = tyre;
    }
    public Speaker getSpeaker() {
        return speaker;
    }
    public void setSpeaker(Speaker speaker) {
        this.speaker = speaker;
    }
    public double getCost() {
        return cost;
    }
    public void setCost(double cost) {
        this.cost = cost;
    }
    public Vehicle(Speaker speaker, Tyre tyre, int priceTag){
        this.priceTag=priceTag;
        this.speaker=speaker;
        this.tyre=tyre;

    }
}
