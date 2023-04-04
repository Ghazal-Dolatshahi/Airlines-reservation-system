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
    HashMap<String, Integer> passengerCharge = new HashMap<>();

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

    public void passengerOption(int j, Passenger[] data, String userName) {
        boolean bool1 = true;
        while (bool1 == true) {
            passengersMenuOption();
            int passengerInput = scanner.nextInt();
            switch (passengerInput) {
                case 1:
                    changePassword(j, data, userName);
                    break;
                case 2:
                    searchFlights();
                    break;
                case 3:
//                    bookingTicket(userName);
                    bool1 = false;
                    break;
                case 4:
                    bool1 = false;
                    break;
                case 5:
                    bool1 = false;
                    break;
                case 6:
                    addCharge(userName);
                    break;
                case 0:
                    bool1 = false;
                    break;
                default:
                    System.out.print("Invalid number!\nplease choose a number again : ");

            }
        }
    }

    public void changePassword(int j, Passenger[] data, String userName) {
        System.out.println("--------------------------- ✈ Change password ✈ ---------------------------");
        System.out.print("Enter the new password : ");
        String newPassword = scanner.next();
        data[j] = new Passenger(userName, newPassword, charge);
        System.out.println("The changes were made successfully ✔\n1- Back");
        int passengerInput2 = scanner.nextInt();
        while (passengerInput2 != 1) {
            System.out.println("Invalid number!\n1- Back");
            System.out.print("Please choose a number again : ");
            passengerInput2 = scanner.nextInt();
        }
    }

    public void addCharge(String userName) {
        System.out.println("--------------------------- ✈ Add charge ✈ ---------------------------");
        System.out.print("please add your charge : ");
        passengerCharge.computeIfAbsent(userName, k -> getCharge());
        passengerCharge.replace(userName, passengerCharge.get(userName), scanner.nextInt() + passengerCharge.get(userName));
        System.out.println("your charge has been successfully added ✔\nNow your charge is " + passengerCharge.get(userName) + "\n1- Back");
        int passengerInput2 = scanner.nextInt();
        while (passengerInput2 != 1) {
            System.out.println("Invalid number!\n1- Back");
            System.out.print("Please choose a number again : ");
            passengerInput2 = scanner.nextInt();
        }
    }

    public void searchFlights() {
        int count = 0;
        int count2 = 0;
        admin.flightSchedules(admin.getFlightData());
        boolean bool = true ;
        while(bool == true) {
            System.out.println("Origin : ");
            String origin = scanner.next();
            System.out.println("FlightId\t\tOrigin\t\tDestination\t\t\tDate\t\t\t\tTime\t\t\tPrice\t\tSeats");
            for (int i = 0; i < admin.getFlightData().size(); i++) {
                if (Objects.equals(origin, admin.getFlightData().get(i).getOrigin()) && admin.getFlightData().get(i).getSeats() > 0) {
                    admin.flightSchedules2(i);
                    count2++;
                    count = 1;
                }
            }
            if(count2 == 1){
                break;
            }
            if (count == 0 ) {
                System.out.println("This flight not found!");
                break;
            }
            System.out.println("Destination : ");
            String destination = scanner.next();
            count2 = 0;
            for (int i = 0; i < admin.getFlightData().size(); i++) {
                if (Objects.equals(destination, admin.getFlightData().get(i).getDestination()) && Objects.equals(origin, admin.getFlightData().get(i).getOrigin())
                        && admin.getFlightData().get(i).getSeats() > 0) {
                    admin.flightSchedules2(i);
                    count = 2;
                    count2++;
                }
            }
            if(count2 == 1){
                break;
            }
            if (count == 1 ) {
                System.out.println("This flight not found!");
                break;
            }
            count2 = 0;
            System.out.println("Date : ");
            String date = scanner.next();
            for (int i = 0; i < admin.getFlightData().size(); i++) {
                if (Objects.equals(destination, admin.getFlightData().get(i).getDestination()) && Objects.equals(origin, admin.getFlightData().get(i).getOrigin())
                        && Objects.equals(date, admin.getFlightData().get(i).getDate()) && admin.getFlightData().get(i).getSeats() > 0) {
                    admin.flightSchedules2(i);
                    count = 3;
                    count2++;
                }
            }
            if(count2 == 1){
                break;
            }
            if (count == 2) {
                System.out.println("This flight not found!");
                break;
            }
            count2 = 0;
            System.out.println("Time : ");
            String time = scanner.next();
            for (int i = 0; i < admin.getFlightData().size(); i++) {
                if (Objects.equals(destination, admin.getFlightData().get(i).getDestination()) && Objects.equals(origin, admin.getFlightData().get(i).getOrigin())
                        && Objects.equals(date, admin.getFlightData().get(i).getDate()) && Objects.equals(time, admin.getFlightData().get(i).getTime()) &&
                        admin.getFlightData().get(i).getSeats() > 0) {
                    admin.flightSchedules2(i);
                    count = 4;
                    count2++;
                }
            }
            if(count2 == 1){
                break;
            }
            if (count == 3 ) {
                System.out.println("This flight not found!");
                break;
            }
            System.out.println("Range of price : ");
            System.out.print("More than :");
            int price1 = scanner.nextInt();
            System.out.print("Less than :");
            int price2 = scanner.nextInt();
            for (int i = 0; i < admin.getFlightData().size(); i++) {
                if (Objects.equals(destination, admin.getFlightData().get(i).getDestination()) && Objects.equals(origin, admin.getFlightData().get(i).getOrigin())
                        && Objects.equals(date, admin.getFlightData().get(i).getDate()) && admin.getFlightData().get(i).getPrice() <= price2 && admin.getFlightData()
                        .get(i).getPrice() >= price1 && admin.getFlightData().get(i).getSeats() > 0) {
                    admin.flightSchedules2(i);
                    count = 5;
                }
            }
            if (count == 4) {
                System.out.println("This flight not found!");
                break;
            }
        }
    }
//    public void bookingTicket(String userName){
//        int count = 0;
//        passengerCharge.computeIfAbsent(userName, k -> getCharge());
//        System.out.print("Enter the FlightId : ");
//       String flightIdBook = scanner.next();
//        for (int i = 0; i < admin.getFlightData().size(); i++) {
//            if(Objects.equals(flightIdBook, admin.getFlightData().get(i).getFlightId())){
//                if((admin.getFlightData().get(i).getSeats() > 0) &&(admin.getFlightData().get(i).getPrice() <= passengerCharge.get(userName))){
//                    System.out.print("Enter 1 to book : ");
//                    int book = scanner.nextInt();
//                    count = 1;
//                    if(book == 1) {
//                        System.out.println("your booking ticket has been successfully added ✔");
//                        admin.getFlightData().get(i).setSeats(admin.getFlightData().get(i).getSeats() - 1);
//                        passengerCharge.replace(userName, passengerCharge.get(userName) - admin.getFlightData().get(i).getPrice());
//                    }
//                    }
//                }
//            }
//        if(count == 1){
//            System.out.println("Sorry you cant book this ticket");
//        }
//    }
}