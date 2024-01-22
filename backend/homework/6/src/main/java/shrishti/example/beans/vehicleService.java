package shrishti.example.beans;

public class vehicleService {
    private speakerService speaker;
    private tyreService tyre;
    private int priceTag;

    private int cost;

    public int getPriceTag() {return priceTag;}
    public void setPriceTag(int priceTag) {
        this.priceTag = priceTag;
    }
    public tyreService getTyre() {
        return tyre;
    }
    public void setTyre(tyreService tyre) {
        this.tyre = tyre;
    }
    public speakerService getSpeaker() {
        return speaker;
    }
    public void setSpeaker(speakerService speaker) {
        this.speaker = speaker;
    }
    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public vehicleService(speakerService speaker, tyreService tyre, int priceTag){
        this.priceTag=priceTag;
        this.speaker=speaker;
        this.tyre=tyre;
    }



}
