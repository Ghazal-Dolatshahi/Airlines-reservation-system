import java.util.Scanner;
import java.util.*;
public class Passenger {
    Scanner scanner = new Scanner(System.in);
    private String userName;
    private String password;
    private int charge;
    Admin admin = new Admin();
    Flights flights = new Flights();
    //    HashMap<String, Integer> passengerCharge = new HashMap<>();
    int[] ticketIdArray = new int[1000];
    static String[][] ticketData = new String[100][100];
    int q;
    int temp = 0;

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
        if(temp == 0 ){
            q = 0;
        }
        temp = 1;
        boolean bool1 = true;

        while (bool1) {

            passengersMenuOption();
            int passengerCommand = scanner.nextInt();

            switch (passengerCommand) {
                case 1 -> changePassword(j, data, userName);
                case 2 -> searchFlights();
                case 3 -> bookingTicket(userName);
                case 4 -> ticketCancellation(userName);
                case 5 -> bookedTicket(userName);
                case 6 -> addCharge(userName);
                case 0 -> bool1 = false;
                default -> System.out.print("Invalid number!\nplease choose a number again : ");
            }
        }
    }

    public void changePassword(int j, Passenger[] data, String userName) {

        System.out.println("--------------------------- ✈ Change password ✈ ---------------------------");
        System.out.print("Enter the new password : ");
        String newPassword = scanner.next();
        data[j] = new Passenger(userName, newPassword, charge);
        System.out.println("The changes were made successfully ✔\n1- Back");
        int passengerCommand2 = scanner.nextInt();

        while (passengerCommand2 != 1) {
            System.out.println("Invalid number!\n1- Back");
            System.out.print("Please choose a number again : ");
            passengerCommand2 = scanner.nextInt();
        }

    }

    public void addCharge(String userName) {

        System.out.println("--------------------------- ✈ Add charge ✈ ---------------------------");
        System.out.print("Please add your charge : ");
//        passengerCharge.computeIfAbsent(userName, k -> getCharge());
//        passengerCharge.replace(userName, passengerCharge.get(userName), scanner.nextInt() + passengerCharge.get(userName));
//        System.out.println("Your charge has been successfully added ✔\nNow your charge is " + passengerCharge.get(userName) + "\n1- Back");
        int charge = scanner.nextInt();
        for (int i = 0; i < Perform.data.length; i++) {
            if (Perform.data[i] == null) {
                break;
            }
            if (Objects.equals(Perform.data[i].getUserName(), userName)) {
                Perform.data[i].setCharge(Perform.data[i].getCharge() + charge);
                System.out.println("Your charge has been successfully added ✔\nNow your charge is " + Perform.data[i].getCharge() + "\n1- Back");
            }
        }
        int passengerCommand2 = scanner.nextInt();

        while (passengerCommand2 != 1) {
            System.out.println("Invalid number!\n1- Back");
            System.out.print("Please choose a number again : ");
            passengerCommand2 = scanner.nextInt();
        }
    }

    public void searchFlights() {
        int count = 0;
        int count2 = 0;
        boolean bool = true ;

        flights.flightSchedules(admin.getFlightData());

        while(bool) {
            System.out.println("Origin : ");
            String origin = scanner.next();

            for (int i = 0; i < admin.getFlightData().size(); i++) {
                if (Objects.equals(origin, admin.getFlightData().get(i).getOrigin()) && admin.getFlightData().get(i).getSeats() > 0) {
                    flights.flightSchedules2(i);
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
                    flights.flightSchedules2(i);
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
                    flights.flightSchedules2(i);
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
                    flights.flightSchedules2(i);
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
                        .get(i).getPrice() >= price1 && admin.getFlightData().get(i).getSeats() > 0 && Objects.equals(time, admin.getFlightData().get(i).getTime())) {
                    flights.flightSchedules2(i);
                    count = 5;
                }
            }

            if (count == 4) {
                System.out.println("This flight not found!");
                break;
            }
            bool = false;
        }
    }

    public void fillArray () {

        Random rand = new Random();
        for (int i = 0; i < 1000; i++) {

            ticketIdArray[i] = rand.nextInt(4000) + 2000;
            for (int j = 0; j < ticketIdArray.length; j++) {

                if( ticketIdArray[i] ==  ticketIdArray[j]){
                    ticketIdArray[i] = rand.nextInt(4000) + 2000;
                }
            }

        }
    }

    public void bookingTicket(String userName){
        int count = 0;
        int count2 = 0;
//        passengerCharge.computeIfAbsent(userName, k -> getCharge());
        int c = 0;
        for (int i = 0; i < Perform.data.length; i++) {
            if (Perform.data[i] == null) {
                break;
            }
            if(Objects.equals(Perform.data[i].getUserName(), userName)){
                c = i;
            }
        }
        System.out.print("Enter the FlightId : ");
        String flightIdBook = scanner.next();

        for (int i = 0; i < admin.getFlightData().size(); i++) {
            if(Objects.equals(flightIdBook, admin.getFlightData().get(i).getFlightId())){
                if((admin.getFlightData().get(i).getSeats() > 0) &&(admin.getFlightData().get(i).getPrice() <= Perform.data[c].getCharge())){
                    System.out.print("Enter 1 to book : ");
                    int book = scanner.nextInt();
                    count = 1;
                    if(book == 1) {
                        System.out.println("Your ticket has been booked successfully ✔");
                        for (int j = 0; j < 100; j++) {
                            if(Objects.equals(ticketData[j][0], userName)){
                                count2 = 1;
                                for(int k = 0 ; k < 100 ; k++){
                                    if(ticketData[j][k] == null){
                                        ticketData[j][k] = flightIdBook;
                                        ticketData[j][k +  1] = String.valueOf(ticketIdArray[q]);
                                        break;
                                    }
                                }
                            }
                        }

                        if(count2 == 0){
                            for (int j = 0; j < 100; j++){
                                if(ticketData[j][0] == null) {
                                    ticketData[j][0] = userName;
                                    ticketData[j][1] = flightIdBook;
                                    ticketData[j][2] = String.valueOf(ticketIdArray[q]);
                                    break;
                                }
                            }
                        }

                        System.out.println("Your ticket id is : " + ticketIdArray[q]);
                        q++;
                        admin.getFlightData().get(i).setSeats(admin.getFlightData().get(i).getSeats() - 1);
//                        passengerCharge.replace(userName, passengerCharge.get(userName) - admin.getFlightData().get(i).getPrice());
                        Perform.data[c].setCharge(Perform.data[c].getCharge()-admin.getFlightData().get(i).getPrice());
                    }
                }
            }
        }

        if(count == 0) {
            int count3 = 0;

            for (int i = 0; i < admin.getFlightData().size(); i++) {

                if (Objects.equals(flightIdBook, admin.getFlightData().get(i).getFlightId())) {
                    if (admin.getFlightData().get(i).getSeats() == 0 && admin.getFlightData().get(i).getPrice() > Perform.data[c].getCharge()) {
                        System.out.println("Sorry! the capacity of this flight has been completed and the price of this ticket is more than your charge");
                        count3 = 1;
                        break;
                    }
                    if (admin.getFlightData().get(i).getSeats() == 0) {
                        System.out.println("Sorry! the capacity of this flight has been completed");
                        count3 = 1;
                    }
                    if (admin.getFlightData().get(i).getPrice() > Perform.data[c].getCharge()) {
                        System.out.println("Sorry! the price of this ticket is more than your charge");
                        count3 = 1;
                    }
                }
            }
            if (count3 == 0) {
                System.out.println("This flight not found!");
            }
        }
    }

    public void bookedTicket (String userName){
        int count = 0;
        int count2 = 0;

        for (int j = 0; j < 100; j++) {
            if (Objects.equals(ticketData[j][0], userName)) {

                for (int k = 1; k < 100; k += 2) {
                    String id = ticketData[j][k];

                    for (int i = 0; i < admin.getFlightData().size(); i++) {
                        if(count2 == 0) {
                            System.out.println("FlightId\t\tOrigin\t\tDestination\t\t\tDate\t\t\t\tTime\t\t\tPrice\t\tSeats");
                        }
                        count2 = 1;
                        if (Objects.equals(id, admin.getFlightData().get(i).getFlightId())) {
                            count = 1;
                            flights.flightSchedules2(i);
                        }
                    }
                }
            }
        }

        if(count == 0){
            System.out.println("No tickets have been booked!");
        }

    }

    public void ticketCancellation (String userName){
        int count = 0;
        int c = 0;
        for (int i = 0; i < Perform.data.length; i++) {
            if (Perform.data[i] == null) {
                break;
            }
            if(Objects.equals(Perform.data[i].getUserName(), userName)){
                c = i;
            }
        }
        System.out.print("Enter the ticket id : ");
        String  ticketId = scanner.next();

        for (int j = 0; j < 100; j++) {
            if(Objects.equals(ticketData[j][0], userName)){

                for(int k = 0 ; k < 100 ; k+=2){
                    if(Objects.equals(ticketId, ticketData[j][k])){
                        count = 1;
                        String idCancellation = ticketData[j][k - 1];
                        ticketData[j][k] = null;
                        ticketData[j][k - 1] = null;

                        for (int i = 0; i < admin.getFlightData().size(); i++) {
                            if(Objects.equals(idCancellation, admin.getFlightData().get(i).getFlightId())){
                                admin.getFlightData().get(i).setSeats(admin.getFlightData().get(i).getSeats() + 1);
                                Perform.data[c].setCharge(Perform.data[i].getCharge()+admin.getFlightData().get(i).getPrice());
//                               passengerCharge.replace(userName, passengerCharge.get(userName) + admin.getFlightData().get(i).getPrice());
                                System.out.println("Your ticket has been cancelled ✔");

                            }
                        }
                    }
                }
            }
        }
        if(count == 0 ){
            System.out.println("No tickets have been registered for you with this ID");
        }
    }
}