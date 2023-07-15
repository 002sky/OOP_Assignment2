import java.util.ArrayList;
import java.util.Locale;

public class Country {
    private String name;
    private ArrayList<State> states;

    public Country(String name, ArrayList<State> states) {
        this.name = name;
        this.states = states;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public ArrayList<State> getStates() {
        return states;
    }

    public void setStates(ArrayList<State> states) {
        this.states = states;
    }



}
