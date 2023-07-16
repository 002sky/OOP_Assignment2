import java.util.HashMap;

public abstract class Tour {
    private String name;
    private int duration;
    public Tour(String name,int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getDuration() {
        return duration;
    }
    public void setDuration(int duration) {
        this.duration = duration;
    }


    @Override
    public String toString() {
        return  "Tour: " + name;

    }

    public abstract HashMap<String,Price> getPricesMap();

}
