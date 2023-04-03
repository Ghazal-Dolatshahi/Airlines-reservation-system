import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Admin {
    private String username;
    private String password;
    ArrayList<Flights> flightData = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    public Admin(String username, String password) {
        this.username = "admin";
        this.password = "2004";
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
    int temp = 0;
    public void adminOption(){
        if(temp == 0) {
            showFlights(flightData);
        }
        temp = 1;
        boolean bool3 = true ;
        while (bool3 == true) {
            adminMenuOption();
            int adminOptionInput = scanner.nextInt();
            switch (adminOptionInput) {
                case 1:
                    addFlight(flightData);
                    break;
                case 2:
                    updateFlight(flightData);
                    break;
                case 3:
                    removeFlight(flightData);
                    break;
                case 4:
                    flightSchedules(flightData);
                    break;
                case 0:
                    bool3 = false;
                    break;
                default:
                    System.out.print("Invalid number!\nplease choose a number again : ");

            }
        }
    }
    public void showFlights(ArrayList<Flights> flightData){
        Flights data1 = new Flights("wx-20" ,"Yazd" ,"Shiraz" , "2023-09-25" ,"12:30" ,"2500000" , 110 );
        Flights data2 = new Flights("gh-45" ,"Kish" ,"Tehran" , "2023-09-30" ,"8:45" ,"2250000" , 105 );
        Flights data3 = new Flights("wx-67" ,"Tehran" ,"Mashhad" , "2023-08-30" ,"4:25" ,"1500000" , 102 );
        Flights data4 = new Flights("ab-26" ,"Ahvaz" ,"Mashhad" , "2023-09-16" ,"1:50" ,"1250000" , 150 );
        Flights data5 = new Flights("wx-24" ,"Gorgan" ,"Esfahan" , "2023-09-05" ,"18:55" ,"700000", 96 );
        Flights data6 = new Flights("gh-97" ,"Kish" ,"Tehran" , "2023-10-08" ,"14:50" ,"2250000" , 105 );
        Flights data7 = new Flights("wx-57" ,"Tabriz" ,"Mashhad" , "2023-11-22" ,"16:00" ,"2250000" , 51 );
        Flights data8 = new Flights("cd-44" ,"Mashhad" ,"Kish" , "2023-10-18" ,"0:00" ,"2150000" , 105 );
        Flights data9 = new Flights("wx-18" ,"Yazd" ,"Mashhad" , "2023-09-15" ,"14:50" ,"950000" , 56 );
        Flights data10 = new Flights("gh-22" ,"Yazd" ,"Mashhad" , "2023-09-15" ,"20:20" ,"2250000" , 40 );
        flightData.add(0,data1);
        flightData.add(1,data2);
        flightData.add(2,data3);
        flightData.add(3,data4);
        flightData.add(4,data5);
        flightData.add(5,data6);
        flightData.add(6,data7);
        flightData.add(7,data8);
        flightData.add(8,data9);
        flightData.add(9,data10);
    }
    public void flightSchedules(ArrayList<Flights> flightData){
        System.out.println("FlightId\t\tOrigin\t\tDestination\t\t\tDate\t\t\t\tTime\t\t\tPrice\t\tSeats" );
        for(int i = 0 ; i < flightData.size() ; i++) {
            System.out.println(flightData.get(i).getFlightId() + "\t\t\t" + flightData.get(i).getOrigin() + "\t\t\t" +
                    flightData.get(i).getDestination() + "\t\t\t" + flightData.get(i).getDate() + "\t\t\t" +
                    flightData.get(i).getTime() + "\t\t\t" + flightData.get(i).getPrice() + "\t\t\t" +
                    flightData.get(i).getSeats());
            System.out.println(flightData.size());

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
            String price = scanner.next();
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
                    count = 1;
                    bool = false;
                }
            }
            if (count == 0) {
                System.out.print("This flight not found\nPlease try again\n ");
            }
        }
        }
    }
    public void updateFlight(ArrayList<Flights> flightData){
        System.out.print("How meny flights do you want to update ? ");
        int number = scanner.nextInt();
        for (int j = 0; j < number; j++) {
            boolean check = true;
            while (check) {
                System.out.print("Which flight do you want to update ?\nPlease enter the flightId : ");
                String flightIdUpdate = scanner.next();
                int count = 0;
                for (int i = 0; i < flightData.size(); i++) {
                    if (Objects.equals(flightIdUpdate, flightData.get(i).getFlightId())) {
                        System.out.print("which field of flight do you want to update ? (please enter all the letters in lowercase) ");
                        String field = scanner.next();
                        switch (field) {
                            case "flightid":
                                System.out.print("Enter the new FlightId : ");
                                String newFlightId = scanner.next();
                                flightData.get(i).setFlightId(newFlightId);
                                System.out.println("The FlightId of this flight update successfully ✔");
                                break;
                            case "origin":
                                System.out.print("Enter the new origin : ");
                                String newOrigin = scanner.next();
                                flightData.get(i).setOrigin(newOrigin);
                                System.out.println("The Origin of this flight update successfully ✔");
                                break;
                            case "destination":
                                System.out.print("Enter the new FlightId : ");
                                String newDestination = scanner.next();
                                flightData.get(i).setDestination(newDestination);
                                System.out.println("The Destination of this flight update successfully ✔");
                                break;
                            case "price":
                                System.out.print("Enter the new Price : ");
                                String newPrice = scanner.next();
                                flightData.get(i).setPrice(newPrice);
                                System.out.println("The Price of this flight update successfully ✔");
                                break;
                            case "seats":
                                System.out.print("Enter the new number of seats : ");
                                int newSeats = scanner.nextInt();
                                flightData.get(i).setSeats(newSeats);
                                System.out.println("The Seats of this flight update successfully ✔");
                                break;
                            case "time":
                                System.out.print("Enter the new Time : ");
                                String newTime = scanner.next();
                                flightData.get(i).setTime(newTime);
                                System.out.println("The Time of this flight update successfully ✔");
                                break;
                            case "date":
                                System.out.print("Enter the new Date : ");
                                String newDate = scanner.next();
                                flightData.get(i).setDate(newDate);
                                System.out.println("The Date of this flight update successfully ✔");
                                break;
                            default:
                                System.out.println("This field not found!");
                        }
                        count = 1;
                        check = false;
                    }
                }
                if (count == 0) {
                    System.out.println("This flight not found!");
                }
            }
        }
    }
}

