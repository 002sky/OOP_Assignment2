import java.util.HashMap;

public class DomesticTour extends Tour {
    private HashMap<String,Price> pricesMap;
    private boolean isPrivateTour;
    private boolean isHoneymoonTour;
    private State state;

    protected DomesticTour(){
        this("name",8,false,false,null);
    }

    protected DomesticTour(String name,int duration, boolean isPrivateTour, boolean isHoneymoonTour, State state) {

        super(name,duration);
        this.pricesMap = setPricesMap();
        this.isPrivateTour = isPrivateTour;
        this.isHoneymoonTour = isHoneymoonTour;
        this.state = state;
    }

    public HashMap<String, Price> setPricesMap(){
        Price normalPrice = new NormalPrice();
        Price peakPrice = new PeakPrice();
        normalPrice.setDomesticPrice();
        peakPrice.setDomesticPrice();

        HashMap<String, Price> tmppricesMap = new HashMap<>();
        tmppricesMap.put(normalPrice.getClass().getName() , normalPrice);
        tmppricesMap.put(peakPrice.getClass().getName(), peakPrice);

        return tmppricesMap;
    }

    public void setHoneymoonTour(boolean isHoneymoonTour){
        this.isHoneymoonTour = isHoneymoonTour;
    }

    public boolean isHoneymoonTour(){
        return isHoneymoonTour;
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

    public void setPricesMap(HashMap<String, Price> pricesMap) {
        this.pricesMap = pricesMap;
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
                + "\nTour Type: Domestic Tour"
                + "\nState: " + state.getName()
                + "\nis Private Tour: " + (isPrivateTour() ? "Yes" : "no")
                + "\nis Honeymoon Tour: " + (isHoneymoonTour() ? "Yes" : "no")
                + "\nDuration: " + super.getDuration()+ " days"
                + "\nPrice" + priceMapToString();


    }

    public String priceMapToString(){
        Price normalPrice = pricesMap.get("NormalPrice");
        Price peakPrice = pricesMap.get("PeakPrice");

        return  "\nNormal Price:" + normalPrice.toString() +
                "\nPeak Price:" + peakPrice.toString();
    }


}
