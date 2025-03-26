import java.util.Scanner;

public class LoginManager {
    private String[][] adminCredentials;
    private Customer customer;
    private Flight flight;
    private RolesAndPermissions rolesAndPermissions;
    private Scanner sc = new Scanner(System.in) ;
    private FlightReservation reservation;

    public LoginManager(String[][] adminCredentials, Customer customer, Flight flight, RolesAndPermissions rolesAndPermissions, Scanner sc, FlightReservation reservation) {
        this.adminCredentials = adminCredentials;
        this.customer = customer;
        this.flight = flight;
        this.rolesAndPermissions = rolesAndPermissions;
        this.sc = sc;
        this.reservation = reservation;
    }

    void adminLogin() {
        System.out.print("\nEnter the UserName to login to the Management System :     ");
        String username = sc.nextLine();
        System.out.print("Enter the Password to login to the Management System :    ");
        String password = sc.nextLine();
        System.out.println();

        int privileges = rolesAndPermissions.validateAdmin(username, password);

        if (privileges == -1) {
            System.out.printf(
                    "\n%20sERROR!!! Unable to login Cannot find user with the entered credentials.... Try Creating New Credentials or get yourself register by pressing 4....\n",
                    "");
        } else if (privileges == 0) {
            System.out.println(
                    "You've standard/default privileges to access the data... You can just view customers data..."
                            + "Can't perform any actions on them....");
            customer.displayCustomersData(true);
        } else {
            // admin menu
        }
    }
}
