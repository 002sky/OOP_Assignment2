import java.util.ArrayList;
import java.util.HashMap;

public class OverseaTour extends Tour{
    private HashMap<String,Price> pricesMap;
    private boolean isPrivateTour;
    private boolean isJoinTour;
    private Country country;
    private State state;


    public OverseaTour(){
        this("name",6,false,false,null,null);
    }

    public OverseaTour(String name,int duration, boolean isPrivateTour, boolean isJoinTour, Country country, State state) {
        super(name, duration);
        this.pricesMap = setPricesMap();
        this.isPrivateTour = isPrivateTour;
        this.isJoinTour = isJoinTour;
        this.country = country;
        this.state = state;
    }
    public HashMap<String, Price> setPricesMap(){
        Price normalPrice = new NormalPrice();
        Price peakPrice = new PeakPrice();
        normalPrice.setOverseaPrice();
        peakPrice.setOverseaPrice();
        HashMap<String, Price> tmppricesMap = new HashMap<>();
        tmppricesMap.put(normalPrice.getClass().getName() , normalPrice);
        tmppricesMap.put(peakPrice.getClass().getName(), peakPrice);

        return tmppricesMap;
    }


    public HashMap<String, Price> getPricesMap() {
        return pricesMap;
    }

    public boolean isPrivateTour() {
        return isPrivateTour;
    }

    public void setPrivateTour(boolean privateTour) {
        isPrivateTour = privateTour;
    }

    public boolean isJoinTour() {
        return isJoinTour;
    }

    public void setJoinTour(boolean joinTour) {
        isJoinTour = joinTour;
    }

    public void setPricesMap(HashMap<String, Price> pricesMap) {
        this.pricesMap = pricesMap;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Tour: " + super.getName()
                + "\nCountry: " + country.getName()
                + "\nState: " + state.getName()
                + "\nHas Private Tour: " + (isPrivateTour() ? "Yes" : "no")
                + "\nHas Honeymoon Tour: " + (isJoinTour() ? "Yes" : "no")
                + "\nDuration: " + super.getDuration() + " days"
                + "\nPrice: " + priceMapToString();

    }

    public String priceMapToString(){
        Price normalPrice = pricesMap.get("NormalPrice");
        Price peakPrice = pricesMap.get("PeakPrice");

        return  "\nNormal Price:" + normalPrice.toString() +
                "\nPeak Price:" + peakPrice.toString();
    }


}
