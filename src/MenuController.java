import java.util.Scanner;

public class MenuController {
    private static final Customer customer = new Customer();
    private static final Flight flight = new Flight();
    private static final FlightReservation reservation = new FlightReservation();


    public static void AdminMenuChoice (int option )  {
        Scanner sc = new Scanner(System.in);
        String customerID = null;
        switch (option){
            case 1:
                customer.addNewCustomer();
                break;
            case 2:
                customer.displayCustomersData(false);
                System.out.print("Enter Customer ID to Search: ");
                customer.searchUser(sc.nextLine());
                break;

            case 3:
                customer.displayCustomersData(false);
                System.out.print("Enter Customer ID to Update: ");
                customerID = sc.nextLine();
                if (!Customer.getCustomersCollection().isEmpty()) {
                    customer.editUserInfo(customerID);
                } else {
                    System.out.printf("%-50sNo Customer with the ID %s Found...!!!\n", " ", customerID);
                }
                break;
            case 4:
                customer.displayCustomersData(false);
                System.out.print("Enter Customer ID to Delete: ");
                customerID = sc.nextLine();
                if (!Customer.getCustomersCollection().isEmpty()) {
                    customer.editUserInfo(customerID);
                } else {
                    System.out.printf("%-50sNo Customer with the ID %s Found...!!!\n", " ", customerID);
                }
                break;
            case 5:
                customer.displayCustomersData(false);
                break;
            case 6:
                customer.displayCustomersData(false);
                System.out.print(
                        "\n\nEnter the ID of the user to display all flights registered by that user...");
                String id = sc.nextLine();
                reservation.displayFlightsRegisteredByOneUser(id);
                break;
            case 7:
                System.out.print(
                        "Do you want to display Passengers of all flights or a specific flight.... 'Y/y' for displaying all flights and 'N/n' to look for a"
                                +
                                " specific flight.... ");
                char choice = sc.nextLine().charAt(0);
                if ('y' == choice || 'Y' == choice) {
                    reservation.displayRegisteredUsersForAllFlight();
                } else if ('n' == choice || 'N' == choice) {
                    flight.displayFlightSchedule();
                    System.out.print(
                            "Enter the Flight Number to display the list of passengers registered in that flight... ");
                    String flightNum = sc.nextLine();
                    reservation.displayRegisteredUsersForASpecificFlight(flightNum);
                } else {
                    System.out.println("Invalid Choice...No Response...!");
                }
                break;
            case 8:
                flight.displayFlightSchedule();
                System.out.print("Enter the Flight Number to delete the flight : ");
                String flightNum = sc.nextLine();
                flight.deleteFlight(flightNum);
            case 0:
                System.out.println("Thanks for Using BAV Airlines Ticketing System...!!!");
                break;
            default:
                System.out.println(
                        "Invalid Choice...Looks like you're Robot...Entering values randomly...You've Have to login again...");

        }


    }

    public static void PassengerMenuChoice (int option,  String userId) {
        Scanner sc = new Scanner(System.in);

        switch( option) {
            case 1:
                flight.displayFlightSchedule();
                System.out.print("\nEnter the desired flight number to book :\t ");
                String flightToBook = sc.nextLine();
                System.out.print("Enter the Number of tickets for " + flightToBook + " flight :   ");

                int numOfTickets = sc.nextInt();
                while (numOfTickets > 10) {
                    System.out.print(
                            "ERROR!! You can't book more than 10 tickets at a time for single flight....Enter number of tickets again : ");
                    numOfTickets = sc.nextInt();
                }

                sc.nextLine();
                reservation.bookFlight(flightToBook, numOfTickets, userId);
                break;
            case 2:
                customer.editUserInfo(userId);
                break;
            case 3:

                System.out.print(
                        "Are you sure to delete your account...It's an irreversible action...Enter Y/y to confirm...");
                char confirmationChar = sc.nextLine().charAt(0);
                if (confirmationChar == 'Y' || confirmationChar == 'y') {
                    customer.deleteUser(userId);
                    System.out.printf("User %s's account deleted Successfully...!!!", userId);
                } else {
                    System.out.println("Action has been cancelled...");
                }


                break;
            case 4:
                flight.displayFlightSchedule();
                flight.displayMeasurementInstructions();
                break;
            case 5:
                reservation.cancelFlight(userId);
                break;
            case 6:
                reservation.displayFlightsRegisteredByOneUser(userId);
                break;
            case 0:
                System.out.println("Logging out...");
                break;
            default:
                System.out.println(
                        "Invalid Choice...Looks like you're Robot...Entering values randomly...You've Have to login again...");
        }
    }

    public static void showAdminMenuInfo(String username){
        System.out.printf("\n\n%-60s+++++++++ 2nd Layer Menu +++++++++%50sLogged in as \"%s\"\n", "",
                "", username);
        System.out.printf("%-30s (a) Enter 1 to add new Passenger....\n", "");
        System.out.printf("%-30s (b) Enter 2 to search a Passenger....\n", "");
        System.out.printf("%-30s (c) Enter 3 to update the Data of the Passenger....\n", "");
        System.out.printf("%-30s (d) Enter 4 to delete a Passenger....\n", "");
        System.out.printf("%-30s (e) Enter 5 to Display all Passengers....\n", "");
        System.out.printf("%-30s (f) Enter 6 to Display all flights registered by a Passenger...\n",
                "");
        System.out.printf("%-30s (g) Enter 7 to Display all registered Passengers in a Flight....\n",
                "");
        System.out.printf("%-30s (h) Enter 8 to Delete a Flight....\n", "");
        System.out.printf("%-30s (i) Enter 0 to Go back to the Main Menu/Logout....\n", "");
        System.out.print("Enter the desired Choice :   ");
    }

    public static void (int option) {}



}
