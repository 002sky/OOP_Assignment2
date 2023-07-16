import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        TourManagement tourManagement = new TourManagement();

        tourManagement.InitialCountry();

        while (true) {
            boolean outerLoopExit = false;
            System.out.println("1. Add Country");
            System.out.println("2. Add State for Country");
            System.out.println("3. Create Tour");
            System.out.println("4. View Tours");
            System.out.println("5. Exit");

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
                    System.out.println("3. Exit");

                    int choice1 = input.nextInt();
                    input.nextLine();

                    switch (choice1) {
                        case 1:
                            System.out.println("Country: Malaysia");
                            String tourName;
                            do {
                                System.out.println("\nEnter Tour Name");
                                tourName = input.nextLine();
                            } while (tourName.isEmpty());

                            tourManagement.printStateList("Malaysia");
                            System.out.println("\nEnter the state name");
                            String stateName;
                            State state;
                            do {
                                stateName = input.nextLine();

                            } while (!tourManagement.checkHasStates("Malaysia", stateName));

                            state = tourManagement.getState("Malaysia", stateName);
                            System.out.println(state.getName());

                            boolean hasPrivateTour;
                            String privateTour;
                            do {
                                System.out.println("Has Private Tour: Yes/No");
                                privateTour = input.nextLine();
                            } while (tourManagement.CheckYesNO(privateTour));

                            if (privateTour.equalsIgnoreCase("yes")) {
                                hasPrivateTour = true;
                            } else {
                                hasPrivateTour = false;
                            }

                            boolean hasHoneymoon;
                            String honeymoonTour;

                            do {
                                System.out.println("Has Honeymoon Tour: Yes/No");
                                honeymoonTour = input.nextLine();
                            } while (tourManagement.CheckYesNO(honeymoonTour));

                            if (honeymoonTour.equalsIgnoreCase("yes")) {
                                hasHoneymoon = true;
                            } else {
                                hasHoneymoon = false;
                            }

                            int duration = 0;
                            System.out.println("Enter the Duration");
                            boolean intExit = true;
                            do {
                                if(input.hasNextInt() && input.hasNext()){
                                    duration = input.nextInt();
                                    input.nextLine();
                                    intExit =false;
                                }else{
                                    System.out.println("Please enter a valid number");
                                    input.nextLine();
                                }
                            }while (intExit);

                            Tour newTour = new DomesticTour(tourName, duration, hasPrivateTour, hasHoneymoon, state);
                            tourManagement.addTour(newTour);
                            break;
                        case 2:
                            String tourName2;

                            do {
                                System.out.println("Enter Tour Name");
                                tourName2 = input.nextLine();
                            } while (tourName2.isEmpty());

                            tourManagement.printCountryList();
                            System.out.println("\nEnter the Country Name");

                            String countryName2;
                            do {
                                countryName2 = input.nextLine();

                            } while (!tourManagement.checkCountry(countryName2));

                            Country newCountry2 = tourManagement.getCountry(countryName2);

                            tourManagement.printStateList(countryName2);

                            System.out.println("\nEnter the state name");
                            String stateName2;

                            do {
                                stateName2 = input.nextLine();
                            } while (!tourManagement.checkHasStates(countryName2, stateName2));

                            State state2 = tourManagement.getState(countryName2, stateName2);

                            boolean hasPrivateTour2;
                            String privateTour2;
                            do {
                                System.out.println("Has Private Tour");
                                privateTour2 = input.nextLine();
                            } while (tourManagement.CheckYesNO(privateTour2));

                            if (privateTour2.equalsIgnoreCase("yes")) {
                                hasPrivateTour2 = true;
                            } else {
                                hasPrivateTour2 = false;
                            }

                            boolean hasJoinedTour;
                            String joinedTour;
                            do {
                                System.out.println("Has Joined Tour: Yes/No");
                                joinedTour = input.nextLine();
                            } while (tourManagement.CheckYesNO(joinedTour));

                            if (joinedTour.equalsIgnoreCase("yes")) {
                                hasJoinedTour = true;
                            } else {
                                hasJoinedTour = false;
                            }
                            int duration2 = 0;
                            System.out.println("Enter the Duration");
                            boolean intExit2 = true;
                            do {
                                if(input.hasNextInt() && input.hasNext()){
                                    duration2 = input.nextInt();
                                    input.nextLine();
                                    intExit2 =false;
                                }else{
                                    System.out.println("Please enter a valid number");
                                    input.nextLine();
                                }
                            }while (intExit2);


                            Tour newTour2 = new OverseaTour(tourName2, duration2, hasPrivateTour2, hasJoinedTour, newCountry2, state2);
                            tourManagement.addTour(newTour2);
                            break;

                        case 3:
                            break;
                    }

                    break;
                case 4:
                    if (tourManagement.getTourList().isEmpty()) {
                        System.out.println("Tour List is Empty");
                        break;
                    } else {
                        tourManagement.printTourList();
                    }
                    System.out.println("Select the Tour to view Detail");

                    int index = -1;

                    boolean intExit3 = true;
                    do {
                        if(input.hasNextInt() && input.hasNext()){
                            index = input.nextInt() - 1;
                            input.nextLine();
                            intExit3 =false;
                        }else{
                            System.out.println("Please enter a valid number");
                            input.nextLine();
                        }
                    }while (intExit3);

                    boolean TourExit = true;
                    while (TourExit) {
                        System.out.println("1. View Tour");
                        System.out.println("2. Update Price");
                        System.out.println("3. Exit");

                        int choice3 = input.nextInt();
                        input.nextLine();

                        switch (choice3) {
                            case 1:
                                tourManagement.getTour(index);
                                break;
                            case 2:
                                System.out.println("1. Normal Price");
                                System.out.println("2. Peak Price");

                                int choice4 = input.nextInt();
                                input.nextLine();
                                switch (choice4) {
                                    case 1:
                                        tourManagement.getPrice(index, "NormalPrice");

                                        System.out.println("Choice which price you want to update");
                                        System.out.println("1. Adult Price");
                                        System.out.println("2. Children With Bed Price");
                                        System.out.println("3. Children Without Bed Price");
                                        System.out.println("4. Infant Price");
                                        System.out.println("5. Exit");

                                        int choice5 = input.nextInt();
                                        input.nextLine();
                                        boolean priceExit = true;

                                        switch (choice5) {
                                            case 1:
                                                double adultPrice = 0;
                                                do {
                                                    if (input.hasNextInt() && input.hasNext()) {
                                                        adultPrice = input.nextInt();
                                                        input.nextLine();
                                                        priceExit = false;
                                                    } else {
                                                        System.out.println("Please enter a valid number");
                                                        input.nextLine();
                                                    }
                                                } while (priceExit);

                                                tourManagement.updatePrice(index, "NormalPrice", "AdultPrice", adultPrice);
                                                break;
                                            case 2:
                                                double ChildrenWithBedPrice = 0;
                                                do {
                                                    if (input.hasNextInt() && input.hasNext()) {
                                                        ChildrenWithBedPrice = input.nextInt();
                                                        input.nextLine();
                                                        priceExit = false;
                                                    } else {
                                                        System.out.println("Please enter a valid number");
                                                        input.nextLine();
                                                    }
                                                } while (priceExit);

                                                tourManagement.updatePrice(index, "NormalPrice", "ChildrenWithBedPrice", ChildrenWithBedPrice);
                                                break;
                                            case 3:

                                                double ChildrenWithoutBedPrice = 0;
                                                do {
                                                    if (input.hasNextInt() && input.hasNext()) {
                                                        ChildrenWithoutBedPrice = input.nextInt();
                                                        input.nextLine();
                                                        priceExit = false;
                                                    } else {
                                                        System.out.println("Please enter a valid number");
                                                        input.nextLine();
                                                    }
                                                } while (priceExit);
                                                tourManagement.updatePrice(index, "NormalPrice", "ChildrenWithoutBedPrice", ChildrenWithoutBedPrice);
                                                break;
                                            case 4:
                                                double InfantPrice = 0;
                                                do {
                                                    if (input.hasNextInt() && input.hasNext()) {
                                                        InfantPrice = input.nextInt();
                                                        input.nextLine();
                                                        priceExit = false;
                                                    } else {
                                                        System.out.println("Please enter a valid number");
                                                        input.nextLine();
                                                    }
                                                } while (priceExit);
                                                tourManagement.updatePrice(index, "NormalPrice", "InfantPrice", InfantPrice);
                                                break;
                                            case 5:
                                                break;
                                        }

                                        break;
                                    case 2:
                                        tourManagement.getPrice(index, "PeakPrice");
                                        System.out.println("Choice which price you want to update");
                                        System.out.println("1. Adult Price");
                                        System.out.println("2. Children With Bed Price");
                                        System.out.println("3. Children Without Bed Price");
                                        System.out.println("4. Infant Price");
                                        System.out.println("5. Exit");

                                        int choice6 = input.nextInt();
                                        input.nextLine();
                                        boolean priceExit2 = true;

                                        switch (choice6) {
                                            case 1:
                                                double adultPrice = 0;
                                                do {
                                                    if (input.hasNextInt() && input.hasNext()) {
                                                        adultPrice = input.nextInt();
                                                        input.nextLine();
                                                        priceExit2 = false;
                                                    } else {
                                                        System.out.println("Please enter a valid number");
                                                        input.nextLine();
                                                    }
                                                } while (priceExit2);

                                                tourManagement.updatePrice(index, "PeakPrice", "AdultPrice", adultPrice);
                                                break;
                                            case 2:
                                                double ChildrenWithBedPrice = 0;
                                                do {
                                                    if (input.hasNextInt() && input.hasNext()) {
                                                        ChildrenWithBedPrice = input.nextInt();
                                                        input.nextLine();
                                                        priceExit2 = false;
                                                    } else {
                                                        System.out.println("Please enter a valid number");
                                                        input.nextLine();
                                                    }
                                                } while (priceExit2);

                                                tourManagement.updatePrice(index, "PeakPrice", "ChildrenWithBedPrice", ChildrenWithBedPrice);
                                                break;
                                            case 3:

                                                double ChildrenWithoutBedPrice = 0;
                                                do {
                                                    if (input.hasNextInt() && input.hasNext()) {
                                                        ChildrenWithoutBedPrice = input.nextInt();
                                                        input.nextLine();
                                                        priceExit2 = false;
                                                    } else {
                                                        System.out.println("Please enter a valid number");
                                                        input.nextLine();
                                                    }
                                                } while (priceExit2);
                                                tourManagement.updatePrice(index, "PeakPrice", "ChildrenWithoutBedPrice", ChildrenWithoutBedPrice);
                                                break;
                                            case 4:
                                                double InfantPrice = 0;
                                                do {
                                                    if (input.hasNextInt() && input.hasNext()) {
                                                        InfantPrice = input.nextInt();
                                                        input.nextLine();
                                                        priceExit2 = false;
                                                    } else {
                                                        System.out.println("Please enter a valid number");
                                                        input.nextLine();
                                                    }
                                                } while (priceExit2);
                                                tourManagement.updatePrice(index, "PeakPrice", "InfantPrice", InfantPrice);
                                                break;
                                            case 5:
                                                break;
                                        }

                                        break;
                                    case 3:
                                        TourExit = false;
                                        break;
                                }
                            case 3:
                                TourExit =false;
                                break;
                        }
                    }

                    break;
                case 5:
                    outerLoopExit = true;
                    break;
            }

            if (outerLoopExit) {
                System.out.println("System Exit");
                break;
            }
        }


    }


}

