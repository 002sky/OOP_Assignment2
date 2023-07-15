import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        TourManagement tourManagement = new TourManagement();

        tourManagement.InitialCountry();

        while (true) {
            System.out.println("1. Add Country");
            System.out.println("2. Add State for Country");
            System.out.println("3. Create Tour");
            int choice = input.nextInt();
            input.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter The Country Name");
                    String name = input.nextLine();
                    ArrayList<State> countryState = new ArrayList<>();
                    while (true) {
                        boolean exit = false;
                        System.out.println("1. Add State");
                        System.out.println("2. Exit");
                        int choice1 = input.nextInt();
                        input.nextLine();
                        switch (choice1) {
                            case 1:
                                System.out.println("Enter The State Name");
                                String stateName = input.nextLine();
                                countryState.add(new State(stateName));
                                break;
                            case 2:
                                exit = true;
                                break;
                        }
                        if (exit) {
                            break;
                        }
                    }
                    Country newCountry = new Country(name, countryState);

                    tourManagement.addCountry(newCountry);
                    break;
                case 2:
                    tourManagement.printCountryList();
                    System.out.println("\nEnter The Country Name");
                    String countryName = input.nextLine();
                    while (true) {
                        boolean exit = false;
                        System.out.println("1. Add State");
                        System.out.println("2. Exit");
                        int choice2 = input.nextInt();
                        input.nextLine();
                        switch (choice2) {
                            case 1:
                                System.out.println("Enter The State Name");
                                String stateName = input.nextLine();
                                tourManagement.addState(countryName, stateName);
                                break;
                            case 2:
                                exit = true;
                                break;
                        }
                        if (exit) {
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Please Select The Tour Type");
                    System.out.println("1. Domestic Tour ");
                    System.out.println("2. Oversea Tour ");

                    int choice1 = input.nextInt();
                    input.nextLine();
                    switch (choice1) {
                        case 1:
                            System.out.println("Country: Malaysia");
                            tourManagement.printStateList("Malaysia");
                            System.out.println("\nEnter the state name");

                            String stateName = input.nextLine();

                            System.out.println("Has Private Tour");
                            boolean hasPrivateTour;
                            if (input.nextLine().equalsIgnoreCase("yes")) {
                                hasPrivateTour = true;
                            } else {
                                hasPrivateTour = false;
                            }
                            System.out.println(hasPrivateTour);

                            boolean hasHoneymoon;
                            System.out.println("Has Honeymoon Tour:");
                            if (input.nextLine().equalsIgnoreCase("yes")) {
                                hasHoneymoon = true;
                            } else {
                                hasHoneymoon = false;
                            }
                            System.out.println(hasHoneymoon);

                            System.out.println("Enter the Duration");
                            int duration = input.nextInt();





                            break;
                        case 2:
                            tourManagement.addTour(new OverseaTour());
                            break;
                    }


                    break;
            }

        }


    }


}

