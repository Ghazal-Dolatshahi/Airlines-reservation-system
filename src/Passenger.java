import java.util.ArrayList;
import java.util.Scanner;
import java.util.*;
public class Passenger {
    Scanner scanner = new Scanner(System.in);
    private String userName;
    private String password;
    private int charge;
    Admin admin = new Admin("admin", "2004");
    ArrayList<Flights> flightData = new ArrayList<>();
    HashMap<String , Integer> passengerCharge = new HashMap<>();

    public Passenger(String userName, String password, int charge) {
        this.userName = userName;
        this.password = password;
        this.charge = charge;
    }

    public Passenger() {

    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }

    public void passengersMenuOption() {
        System.out.println("--------------------------- ✈ Passengers menu option ✈ ---------------------------");
        System.out.println("""
                1- Change password
                2- Search flight tickets
                3- Booking ticket
                4- Ticket cancellation
                5- Booked tickets
                6- Add charge
                0- sign out""");
    }

    public void passengerOption(int j, Passenger[] data, String username) {
        boolean bool1 = true;
        while (bool1 == true) {
            passengersMenuOption();
            int passengerInput = scanner.nextInt();
            switch (passengerInput) {
                case 1:
                    changePassword(j, data, username);
                    break;
                case 2:
                    searchFlights();
                    bool1 = false;
                    break;
                case 3:
                    bool1 = false;
                    break;
                case 4:
                    bool1 = false;
                    break;
                case 5:
                    bool1 = false;
                    break;
                case 6:
                    addCharge(username);
                    break;
                case 0:
                    bool1 = false;
                    break;
                default:
                    System.out.print("Invalid number!\nplease choose a number again : ");

            }
        }
    }

    public void changePassword(int j, Passenger[] data, String username) {
        System.out.println("--------------------------- ✈ Change password ✈ ---------------------------");
        System.out.print("Enter the new password : ");
        String newPassword = scanner.next();
        data[j] = new Passenger(username, newPassword, charge);
        System.out.println("The changes were made successfully ✔\n1- Back");
        int passengerInput2 = scanner.nextInt();
        while (passengerInput2 != 1) {
            System.out.println("Invalid number!\n1- Back");
            System.out.print("Please choose a number again : ");
            passengerInput2 = scanner.nextInt();
        }
    }

    public void addCharge(String username) {
        System.out.println("--------------------------- ✈ Add charge ✈ ---------------------------");
        System.out.print("please add your charge : ");
        passengerCharge.computeIfAbsent(username, k -> getCharge());
        passengerCharge.replace(username , passengerCharge.get(username),scanner.nextInt() + passengerCharge.get(username) );
        System.out.println("your charge has been successfully added ✔\nNow your charge is " + passengerCharge.get(username) + "\n1- Back");
        int passengerInput2 = scanner.nextInt();
        while (passengerInput2 != 1) {
            System.out.println("Invalid number!\n1- Back");
            System.out.print("Please choose a number again : ");
            passengerInput2 = scanner.nextInt();
        }
    }

    public void searchFlights() {
        int count = 0;
        int temp = 0;
        admin.setFlightData(admin.flightSchedules(flightData));
        System.out.println("Origin : ");
        String origin = scanner.next();
        for (int i = 0; i < flightData.size(); i++) {
            if (Objects.equals(origin, flightData.get(i).getOrigin())) {
                if (temp == 0) {
                    System.out.println("FlightId\t\tOrigin\t\tDestination\t\t\tDate\t\t\t\tTime\t\t\tPrice\t\tSeats");
                }
                temp = 1;
                admin.flightSchedules2(i);
                count = 1;
            }
        }
        if (count == 0) {
            System.out.println("This flight not found!");
        }
    }
}