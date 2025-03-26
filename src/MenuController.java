import java.util.Scanner;

public class MenuController {
    private static Customer customer = new Customer();
    private static Flight flight = new Flight();
    private static FlightReservation reservation = new FlightReservation();


    public static void AdminMenuChoice (int option )  {
        Scanner sc = new Scanner(System.in);

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
                String customerID = sc.nextLine();
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
}
