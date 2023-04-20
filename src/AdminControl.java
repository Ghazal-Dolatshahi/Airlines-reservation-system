import java.util.Objects;
import java.util.Scanner;

public class AdminControl {
    Scanner scanner = new Scanner(System.in);

    public void adminMenuOption() {

        System.out.println("--------------------------- ✈ Admin menu option ✈ ---------------------------");
        System.out.println("""
                1- Add
                2- Update
                3- Remove
                4- Flight schedules
                0- sign out""");
    }

    public void adminOption(Database database) {
        boolean bool3 = true;

        while (bool3) {
            adminMenuOption();
            String command = scanner.next();
            switch (command) {

                case "1" -> addData(database);
                case "2" -> updateData(database);
                case "3" -> removeData(database);
                case "4" -> {
                    System.out.printf("|%-10s|%-10s|%-12s|%-12s|%-8s|%-10s|%-8s %n", "FlightId", "Origin", "Destination", "Date", "Time", "Price", "Seats");
                    flightSchedules(-1, database);
                }
                case "0" -> bool3 = false;
                default -> System.out.print("Invalid! please choose a number again : ");

            }
        }

    }

    public void addData(Database database) {
        boolean bool2;
        String price = null;
        String destination = null;
        String origin = null;
        String seats = null;
        String time = null;
        String date = null;

        System.out.println("--------------------------- ✈ Add flights ✈ ---------------------------");
        System.out.print("How many flights do you want to add ? ");
        String number = scanner.next();
        if (database.checkNum(number)) {
            int number2 = Integer.parseInt(number);

            for (int i = 0; i < number2; i++) {
                System.out.print("Enter the FlightId : ");
                String flightId = scanner.next();

                for (int j = 0; j < database.flights.flightData.size(); j++) {
                    if (Objects.equals(flightId, database.flights.flightData.get(j).getFlightId())) {
                        System.out.println("This flight is exist");
                        System.out.print("Enter the FlightId : ");
                        flightId = scanner.next();
                        j = -1;
                    }
                }

                bool2 = true;
                while (bool2) {
                    System.out.print("Enter the origin (first letter must be in capitalized): ");
                    origin = scanner.next();
                    if (database.checkLetter(origin)) {
                        bool2 = false;
                    } else {
                        System.out.println("Invalid! try again");
                    }
                }

                bool2 = true;
                while (bool2) {
                    System.out.print("Enter the destination (first letter must be in capitalized): ");
                    destination = scanner.next();
                    if (database.checkLetter(destination) && !Objects.equals(origin, destination)) {
                        bool2 = false;
                    } else {
                        System.out.println("Invalid! try again");
                        if (Objects.equals(destination, origin)) {
                            System.out.println("The origin and destination are the same! try again");
                        }
                    }
                }

                bool2 = true;
                while (bool2) {
                    System.out.print("Enter the date : ");
                    date = scanner.next();
                    if (database.checkDate(date)) {
                        bool2 = false;
                    } else {
                        System.out.println("Invalid! try again");
                    }
                }

                bool2 = true;
                while (bool2) {
                    System.out.print("Enter the time : ");
                    time = scanner.next();
                    if (database.checkTime(time)) {
                        bool2 = false;
                    } else
                        System.out.println("Invalid! try again");
                }

                bool2 = true;
                while (bool2) {
                    System.out.print("Enter the price : ");
                    price = scanner.next();
                    if (database.checkNum(price) && Integer.parseInt(price) >= 0)
                        bool2 = false;
                    else
                        System.out.println("Invalid! try again");
                }

                bool2 = true;
                while (bool2) {
                    System.out.print("Enter the number of seats : ");
                    seats = scanner.next();
                    if (database.checkNum(seats) && Integer.parseInt(seats) > 0)
                        bool2 = false;
                    else
                        System.out.println("Invalid! try again");
                }

                database.flights.addFlight(flightId, origin, destination, date, time, price, seats);
                System.out.println("This flight add successfully ✔");
            }
        } else
            System.out.println("Invalid! try again");
    }

    public void removeData(Database database) {
        boolean bool;
        int count;

        System.out.println("--------------------------- ✈ remove flights ✈ ---------------------------");
        System.out.print("How many fights do you want to remove ? ");
        String num = scanner.next();
        bool = database.checkNum(num);
        if (bool) {
            int num2 = Integer.parseInt(num);

            for (int j = 0; j < num2; j++) {
                System.out.print("Enter the flightId : ");
                String flightIdRemove = scanner.next();
                count = database.flights.removeFlight(flightIdRemove, database);
                if (count == 0) {
                    System.out.println("Flight not found !");
                    j -= 1;
                }
            }

            System.out.println("This flight remove successfully ✔");
        } else
            System.out.println("Invalid! try again");
    }

    public void updateData(Database database) {
        boolean check;
        int count = 0;

        System.out.println("--------------------------- ✈ update flights ✈ ---------------------------");

        System.out.print("How many flights do you want to update ? ");
        String number = scanner.next();
        boolean bool;
        bool = database.checkNum(number);
        if (bool) {
            int number2 = Integer.parseInt(number);

            for (int j = 0; j < number2; j++) {
                check = true;
                while (check) {
                    System.out.print("Please enter the flightId : ");
                    String flightIdUpdate = scanner.next();

                    for (int i = 0; i < database.flights.flightData.size(); i++) {
                        if (Objects.equals(flightIdUpdate, database.flights.flightData.get(i).getFlightId())) {
                            System.out.print("which field of flight do you want to update (All letters must be in lowercase)? ");
                            String field = scanner.next();
                            i = fieldFlight(field, i, database);
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
        } else
            System.out.println("Invalid! try again");
    }

    public int fieldFlight(String field, int i, Database database) {
        String newPrice = null;
        boolean bool2 = true;

        switch (field) {

            case "flightid" -> {
                System.out.print("Enter the new FlightId : ");
                String newFlightId = scanner.next();
                for (int j = 0; j < database.flights.flightData.size(); j++) {
                    if (Objects.equals(newFlightId, database.flights.flightData.get(j).getFlightId()) && !Objects.equals(newFlightId, database.flights.flightData.get(i).getFlightId())) {
                        System.out.println("This flight is exist");
                        System.out.print("Enter the new FlightId : ");
                        newFlightId = scanner.next();
                        j = -1;
                    }
                }
                database.flights.updateFlight(field, newFlightId, i, database);
                System.out.println("The FlightId of this flight update successfully ✔");
            }

            case "origin" -> {
                while (bool2) {
                    System.out.print("Enter the new origin : ");
                    String newOrigin = scanner.next();
                    if (database.checkLetter(newOrigin) && !Objects.equals(newOrigin, database.flights.flightData.get(i).getDestination())) {
                        database.flights.updateFlight(field, newOrigin, i, database);
                        System.out.println("The Origin of this flight update successfully ✔");
                        bool2 = false;
                    } else
                        System.out.println("Invalid! try again");
                    if (Objects.equals(newOrigin, database.flights.flightData.get(i).getDestination())) {
                        System.out.println("The origin and destination are the same! try again");
                    }
                }
            }

            case "destination" -> {
                while (bool2) {
                    System.out.print("Enter the new Destination : ");
                    String newDestination = scanner.next();
                    if (database.checkLetter(newDestination) && !Objects.equals(newDestination, database.flights.flightData.get(i).getOrigin())) {
                        database.flights.updateFlight(field, newDestination, i, database);
                        System.out.println("The Destination of this flight update successfully ✔");
                        bool2 = false;
                    } else
                        System.out.println("Invalid! try again");
                    if (Objects.equals(newDestination, database.flights.flightData.get(i).getOrigin())) {
                        System.out.println("The origin and destination are the same! try again");
                    }
                }
            }

            case "price" -> {
                while (bool2) {
                    System.out.print("Enter the new Price : ");
                    newPrice = scanner.next();
                    if (database.checkNum(newPrice) && Integer.parseInt(newPrice) >= 0)
                        bool2 = false;
                    else
                        System.out.println("Invalid! try again");

                }
                database.flights.updateFlight(field, newPrice, i, database);
                System.out.println("The Price of this flight update successfully ✔");
            }

            case "seats" -> {
                String newSeats = null;

                while (bool2) {
                    System.out.print("Enter the new number of seats : ");
                    newSeats = scanner.next();
                    if (database.checkNum(newSeats) && Integer.parseInt(newSeats) >= 0)
                        bool2 = false;
                    else
                        System.out.println("Invalid! try again");
                }
                database.flights.updateFlight(field, newSeats, i, database);
                System.out.println("The Seats of this flight update successfully ✔");
            }

            case "time" -> {
                String newTime = null;

                while (bool2) {
                    System.out.print("Enter the new Time : ");
                    newTime = scanner.next();
                    if (database.checkTime(newTime))
                        bool2 = false;
                    else
                        System.out.println("Invalid! try again");
                }
                database.flights.updateFlight(field, newTime, i, database);
                System.out.println("The Time of this flight update successfully ✔");
            }

            case "date" -> {
                String newDate = null;

                while (bool2) {
                    System.out.print("Enter the new Date : ");
                    newDate = scanner.next();
                    if (database.checkDate(newDate))
                        bool2 = false;
                    else
                        System.out.println("Invalid! try again");
                }
                database.flights.updateFlight(field, newDate, i, database);
                System.out.println("The Date of this flight update successfully ✔");
            }

            default -> {
                System.out.println("This field not found!");
                i = -1;
            }
        }
        return i;
    }

    public void flightSchedules(int i, Database database) {

        if (i >= 0) {
            System.out.printf("---------------------------------------------------------------------------%n");
            System.out.printf("|%-10s|%-10s|%-12s|%-12s|%-8s|%-10s|%-8s %n", database.flights.flightData.get(i).getFlightId(),
                    database.flights.flightData.get(i).getOrigin(), database.flights.flightData.get(i).getDestination(),
                    database.flights.flightData.get(i).getDate(), database.flights.flightData.get(i).getTime(),
                    database.flights.flightData.get(i).getPrice(), database.flights.flightData.get(i).getSeats());
        } else
            for (int j = 0; j < database.flights.flightData.size(); j++) {
                System.out.printf("---------------------------------------------------------------------------%n");
                System.out.printf("|%-10s|%-10s|%-12s|%-12s|%-8s|%-10s|%-8s %n", database.flights.flightData.get(j).getFlightId(),
                        database.flights.flightData.get(j).getOrigin(), database.flights.flightData.get(j).getDestination(),
                        database.flights.flightData.get(j).getDate(), database.flights.flightData.get(j).getTime(),
                        database.flights.flightData.get(j).getPrice(), database.flights.flightData.get(j).getSeats());
            }
    }
}
