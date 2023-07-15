import java.util.ArrayList;
import java.util.Locale;


public class TourManagement {
    private static ArrayList<Tour> tourList;
    private static ArrayList<Country> CountryList;


    public TourManagement() {
        tourList = new ArrayList<>();
        CountryList = new ArrayList<>();
    }


    public void removeCountry(String name) {
        CountryList.removeIf(country -> country.getName().equals(name));
    }

    public void removeState(Country country, String name) {
        CountryList.forEach(c -> {
            if (c.getName().equals(country.getName())) {
                c.getStates().removeIf(state -> state.getName().equals(name));
            }
        });
    }

    public void addCountry(Country country) {
        CountryList.add(country);
    }

    public void addState(String CountryName, String StateName) {
        CountryList.forEach(c -> {
            if (c.getName().equals(CountryName)) {
                c.getStates().add(new State(StateName));
            }
        });


    }

    public void addTour(Tour tour) {
        tourList.add(tour);
    }

    public ArrayList<Tour> getTourList() {
        return tourList;
    }

    public ArrayList<Country> getCountryList() {
        return CountryList;
    }

    public void InitialCountry() {
        ArrayList<State> states1 = new ArrayList<>();
        states1.add(new State("Singapore"));
        Country country1 = new Country("Singapore", states1);
        CountryList.add(country1);

        ArrayList<State> states2 = new ArrayList<>();
        states2.add(new State("Tokyo"));
        Country country2 = new Country("Japan", states2);
        CountryList.add(country2);

        ArrayList<State> states3 = new ArrayList<>();
        states3.add(new State("Johor"));
        Country country3 = new Country("Malaysia", states3);
        CountryList.add(country3);

        ArrayList<State> states4 = new ArrayList<>();
        states4.add(new State("Bangkok"));
        Country country4 = new Country("Thailand", states4);
        CountryList.add(country4);

    }

    public void printCountryList() {
        for (Country country : CountryList) {
            System.out.print(country.getName() + ",");
        }
    }

    public void printStateList(String CountryName) {
        CountryList.forEach(country -> {
            if (country.getName().equals(CountryName)) {
                System.out.print("State of the Country : ");
                country.getStates().forEach(state -> {
                    System.out.print(state.getName() + ",");
                });
            }
        });

    }

    public boolean checkHasStates(String stateName) {
        boolean[] check = new boolean[1];
        CountryList.forEach(country -> {
            country.getStates().forEach(state -> {
                if (state.getName().equals(stateName)) {
                    System.out.println(state.getName() + " is a state of the country " + country.getName());
                    check[0] = true;
                }else {
                    check[0] = false;
                            ;
                }
            });
        });
        return check[0];
    }

}
