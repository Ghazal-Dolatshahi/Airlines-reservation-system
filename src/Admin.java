import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Admin {
    Scanner scanner = new Scanner(System.in);
    Flights flights = new Flights();

    private String username;
    private String password;
    public static ArrayList<Flights> flightData = new ArrayList<>();

    public Admin() {
        this.username = "admin";
        this.password = "2004";
    }

    public ArrayList<Flights> getFlightData() {
        return flightData;
    }

    public void setFlightData(ArrayList<Flights> flightData) {
        this.flightData = flightData;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void adminMenuOption() {
        System.out.println("---------------------------✈ Admin menu option ✈---------------------------");
        System.out.println("""
                1- Add
                2- Update
                3- Remove
                4- Flight schedules
                0- sign out""");
    }

    public void adminOption(){

        boolean bool3 = true ;
        while (bool3) {
            adminMenuOption();
            int adminOptionCommand = scanner.nextInt();
            switch (adminOptionCommand) {
                case 1 -> addFlight(flightData);
                case 2 -> updateFlight(flightData);
                case 3 -> removeFlight(flightData);
                case 4 -> flights.flightSchedules(flightData);
                case 0 -> bool3 = false;
                default -> System.out.print("Invalid number!\nplease choose a number again : ");
            }
        }
    }

    public void addFlight(ArrayList<Flights> flightData){

        System.out.println("---------------------------✈ Add flights ✈---------------------------");
        System.out.print("How many flights do you want to add ?");
        int addFlight = scanner.nextInt();

        for(int i = 0 ; i < addFlight ; i++) {
            System.out.print("Enter the flightId : ");
            String flightId = scanner.next();
            System.out.print("Enter the origin : ");
            String origin = scanner.next();
            System.out.print("Enter the destination : ");
            String destination = scanner.next();
            System.out.print("Enter the date : ");
            String date = scanner.next();
            System.out.print("Enter the time : ");
            String time = scanner.next();
            System.out.print("Enter the price : ");
            int price = scanner.nextInt();
            System.out.print("Enter the seats : ");
            int seats = scanner.nextInt();
            Flights dataNew = new Flights(flightId, origin, destination, date, time, price, seats);
            flightData.add(flightData.size(), dataNew);
            System.out.println("This flight add successfully ✔");
        }
    }

    public void removeFlight(ArrayList<Flights> flightData){
        System.out.print("How many fights do you want to remove ?");
        int flightRemove = scanner.nextInt();

        for (int j = 0; j < flightRemove; j++) {
            boolean bool = true ;

        while(bool) {
            System.out.print("Enter the flightId : ");
            String flightIdRemove = scanner.next();
            int count = 0;

            for (int i = 0; i < flightData.size(); i++) {
                if (Objects.equals(flightIdRemove, flightData.get(i).getFlightId())) {
                    flightData.remove(i);
                    System.out.println("This flight remove successfully ✔");
                    for (int i1 = 0; i1 < 100; i1++) {
                        for (int i2 = 1; i2 < 100; i2+=2) {
                            if(Objects.equals(Passenger.ticketData[i1][i2], flightIdRemove)){
                                Passenger.ticketData[i1][i2] = null;
                                Passenger.ticketData[i1 + 1][i2] = null;
                            }

                        }
                    }
                    count = 1;
                    bool = false;
                }
            }

            if (count == 0) {
                System.out.print("This flight not found\nPlease try again\n ");
                bool = false;
            }
        }
        }
    }
    public void updateFlight(ArrayList<Flights> flightData){
        boolean check = true;
        int count = 0;

        System.out.print("How many flights do you want to update ? ");
        int number = scanner.nextInt();

        for (int j = 0; j < number; j++) {

            while (check) {
                System.out.print("Which flight do you want to update ?\nPlease enter the flightId : ");
                String flightIdUpdate = scanner.next();

                for (int i = 0; i < flightData.size(); i++) {
                    if (Objects.equals(flightIdUpdate, flightData.get(i).getFlightId())) {
                        System.out.print("which field of flight do you want to update ?(Enter the letters in lowercase)");
                        String field = scanner.next();

                        switch (field) {
                            case "flightid" -> {
                                System.out.print("Enter the new FlightId : ");
                                String newFlightId = scanner.next();
                                flightData.get(i).setFlightId(newFlightId);
                                System.out.println("The FlightId of this flight update successfully ✔");
                            }
                            case "origin" -> {
                                System.out.print("Enter the new origin : ");
                                String newOrigin = scanner.next();
                                flightData.get(i).setOrigin(newOrigin);
                                System.out.println("The Origin of this flight update successfully ✔");
                            }
                            case "destination" -> {
                                System.out.print("Enter the new Destination : ");
                                String newDestination = scanner.next();
                                flightData.get(i).setDestination(newDestination);
                                System.out.println("The Destination of this flight update successfully ✔");
                            }
                            case "price" -> {
                                System.out.print("Enter the new Price : ");
                                int newPrice = scanner.nextInt();
                                flightData.get(i).setPrice(newPrice);
                                System.out.println("The Price of this flight update successfully ✔");
                            }
                            case "seats" -> {
                                System.out.print("Enter the new number of seats : ");
                                int newSeats = scanner.nextInt();
                                flightData.get(i).setSeats(newSeats);
                                System.out.println("The Seats of this flight update successfully ✔");
                            }
                            case "time" -> {
                                System.out.print("Enter the new Time : ");
                                String newTime = scanner.next();
                                flightData.get(i).setTime(newTime);
                                System.out.println("The Time of this flight update successfully ✔");
                            }
                            case "date" -> {
                                System.out.print("Enter the new Date : ");
                                String newDate = scanner.next();
                                flightData.get(i).setDate(newDate);
                                System.out.println("The Date of this flight update successfully ✔");
                            }
                            default -> System.out.println("This field not found!");
                        }

                        count = 1;
                        check = false;
                    }
                }

                if (count == 0) {
                    System.out.println("This flight not found!");
                    check = false;
                }
            }

        }
    }
}

