import java.util.ArrayList;
import java.util.HashMap;



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
            if (country.getName().equals("Malaysia")) {
                continue; // skip this iteration of the loop
            }

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

    public boolean checkHasStates(String CountryName, String stateName) {
        boolean[] check = new boolean[1];
        check[0] = false;

        CountryList.forEach(country -> {
            if (country.getName().equals(CountryName)) {
                country.getStates().forEach(state -> {
                    if (state.getName().equals(stateName)) {
                        check[0] = true;
                    }
                });
            }
        });

        if (!check[0]) {
            System.out.println("Please enter a valid state name");
        }

        return check[0];

    }

    public boolean checkCountry(String CountryName) {
        boolean[] check = new boolean[1];
        check[0] = false;
        CountryList.forEach(country -> {
            if (country.getName().equals(CountryName)) {
                System.out.println(CountryName + " is selected");
                check[0] = true;
            }
        });

        if (!check[0]) {
            System.out.println("Please enter a valid country name");
        }

        return check[0];
    }


    public boolean CheckYesNO(String Answer) {
        if (Answer.toLowerCase().matches("yes") || Answer.toLowerCase().matches("no")) {
            return false;
        } else {
            System.out.println("Please enter yes and no");
        }
        return true;
    }

    public State getState(String CountryName, String StateName) {
        State[] stateValue = new State[1];
        CountryList.forEach(country -> {
            if (country.getName().equals(CountryName)) {
                country.getStates().forEach(state -> {
                    if (state.getName().equals(StateName)) {
                        stateValue[0] = state;
                    }
                });
            }
        });

        if (stateValue[0] == null) {
            System.out.println("Please enter a valid state name");
        }

        return stateValue[0];
    }

    public Country getCountry(String CountryName) {
        Country[] countries = new Country[1];

        CountryList.forEach(country -> {
            if (country.getName().equals(CountryName)) {
                countries[0] = country;
            }
        });
        if (countries[0] == null) {
            System.out.println("Please enter a valid country name");
        }
        return countries[0];
    }

    public void printTourList() {
        for (Tour tour : tourList) {
            System.out.println(tourList.indexOf(tour) + 1 + ". " + tour.getName() + " " + (tour.getClass().getName().equalsIgnoreCase("DomesticTour") ? "(Domestic Tour)" : "(Oversea Tour)"));
        }
    }

    public void getTour(int index) {
        System.out.println(tourList.get(index).toString());
    }

    public Price getPrice(int TourIndex, String type) {
        Tour tour = tourList.get(TourIndex);
        HashMap<String, Price> prices = tour.getPricesMap();
        if (prices.containsKey(type)) {
            System.out.println(prices.get(type).toString());
            return prices.get(type);
        }
        return null;
    }

    public void updatePrice(int index, String type, String selectedPrice, double price) {

        if (tourList.get(index).getPricesMap().containsKey(type)) {
            if (selectedPrice.equalsIgnoreCase("AdultPrice")) {
                tourList.get(index).getPricesMap().get(type).setAdultPrice(price);
            } else if (selectedPrice.equalsIgnoreCase("InfantPrice")) {
                tourList.get(index).getPricesMap().get(type).setInfantPrice(price);
            } else if (selectedPrice.equalsIgnoreCase("ChildrenWithoutBedPrice")) {
                tourList.get(index).getPricesMap().get(type).setChildrenWithoutBedPrice(price);
            } else {
                tourList.get(index).getPricesMap().get(type).setChildrenWithBedPrice(price);
            }
        }
    }

}


