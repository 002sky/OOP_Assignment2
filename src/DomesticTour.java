import java.util.ArrayList;
import java.util.HashMap;

public class DomesticTour extends Tour {
    private HashMap<String,Price> pricesMap;
    private boolean isPrivateTour;
    private boolean isHoneymoonTour;
    private State state;

    public DomesticTour(){
        this("name",8,null,false,false,null);
    }

    public DomesticTour(String name,int duration, HashMap<String, Price> pricesMap, boolean isPrivateTour, boolean isHoneymoonTour, State state) {

        super(name,duration);
        this.pricesMap = pricesMap;
        this.isPrivateTour = isPrivateTour;
        this.isHoneymoonTour = isHoneymoonTour;
        this.state = state;
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
}
