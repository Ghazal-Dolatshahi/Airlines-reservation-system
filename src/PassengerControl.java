import java.util.Objects;
import java.util.Scanner;

public class PassengerControl {
    Scanner scanner = new Scanner(System.in);
    AdminControl adminControl = new AdminControl();

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

    public void passengerOption(int j, String userName, Database database) {
        boolean bool1 = true;

        while (bool1) {
            passengersMenuOption();
            int command = scanner.nextInt();

            switch (command) {
                case 1 -> changePasswordData(j, database);
                case 2 -> searchFlightsData(database);
                case 3 -> bookingTicketData(userName, database);
                case 4 -> ticketCancellationData(userName, database);
                case 5 -> bookedTickets(userName, database);
                case 6 -> addChargeData(userName, database);
                case 0 -> bool1 = false;
                default -> System.out.print("Invalid number! please choose a number again : ");
            }
        }

    }

    public void changePasswordData(int j, Database database) {

        System.out.println("--------------------------- ✈ Change password ✈ ---------------------------");
        System.out.print("Enter the new password : ");
        String newPassword = scanner.next();
        database.passengers.changePassword(newPassword, j);
        System.out.println("The changes were made successfully ✔\n1- Back");
        String command2 = scanner.next();

        while (!Objects.equals(command2, "1") || !database.checkNum(command2)) {
            System.out.println("Invalid number! Please choose a number again \n1- Back");
            command2 = scanner.next();
        }

    }

    public void addChargeData(String userName, Database database) {
        boolean bool2 = true;
        System.out.println("--------------------------- ✈ Add charge ✈ ---------------------------");

        while (bool2) {
            System.out.print("Please add your charge : ");
            String charge = scanner.next();
            boolean bool = database.checkNum(charge);
            if (bool && Integer.parseInt(charge) >= 0) {
                database.passengers.addCharge(userName, charge);

                for (int i = 0; i < database.passengers.passengerData.size(); i++) {
                    if (database.passengers.passengerData.get(i) == null) {
                        break;
                    }
                    if ((Objects.equals(database.passengers.passengerData.get(i).getUserName(), userName))) {
                        System.out.println("Your charge has been successfully added ✔\nNow your charge is " +
                                database.passengers.passengerData.get(i).getCharge() + "\n1- Back");
                    }
                }
                bool2 = false;

            } else
                System.out.println("Invalid! try again");
        }

        String command2 = scanner.next();

        while (!Objects.equals(command2, "1") || !database.checkNum(command2)) {
            System.out.println("Invalid number! Please choose a number again \n1- Back");
            command2 = scanner.next();
        }
    }

    public void searchFlightsData(Database database) {
        int temp = 0;
        boolean bool = true;

        System.out.printf("|%-10s|%-10s|%-12s|%-12s|%-8s|%-10s|%-8s %n", "FlightId", "Origin", "Destination", "Date", "Time", "Price", "Seats");
        adminControl.flightSchedules(-1, database);
        System.out.println("--------------------------- ✈ Searching Flights ✈ ---------------------------");

        while (bool) {

            System.out.print("Origin : ");
            String origin = scanner.next();
            System.out.printf("|%-10s|%-10s|%-12s|%-12s|%-8s|%-10s|%-8s %n", "FlightId", "Origin", "Destination", "Date", "Time", "Price", "Seats");
            int count2 = database.flights.searchFlight(origin, null, null, null, 0, temp, database);
            if (count2 == 1) {
                break;
            }
            if (count2 == 0) {
                System.out.println("This flight not found!");
                break;
            }

            temp++;
            System.out.print("Destination : ");
            String destination = scanner.next();
            System.out.printf("|%-10s|%-10s|%-12s|%-12s|%-8s|%-10s|%-8s %n", "FlightId", "Origin", "Destination", "Date", "Time", "Price", "Seats");
            count2 = database.flights.searchFlight(origin, destination, null, null, 0, temp, database);
            if (count2 == 1) {
                break;
            }
            if (count2 == 0) {
                System.out.println("This flight not found!");
                break;
            }

            temp++;
            System.out.print("Date : ");
            String date = scanner.next();
            System.out.printf("|%-10s|%-10s|%-12s|%-12s|%-8s|%-10s|%-8s %n", "FlightId", "Origin", "Destination", "Date", "Time", "Price", "Seats");
            count2 = database.flights.searchFlight(origin, destination, null, date, 0, temp, database);
            if (count2 == 1) {
                break;
            }
            if (count2 == 0) {
                System.out.println("This flight not found!");
                break;
            }

            temp++;
            System.out.print("Time : ");
            String time = scanner.next();
            System.out.printf("|%-10s|%-10s|%-12s|%-12s|%-8s|%-10s|%-8s %n", "FlightId", "Origin", "Destination", "Date", "Time", "Price", "Seats");
            count2 = database.flights.searchFlight(origin, destination, time, date, 0, temp, database);
            if (count2 == 1) {
                break;
            }
            if (count2 == 0) {
                System.out.println("This flight not found!");
                break;
            }

            temp++;
            System.out.print(" The price less than :");
            String price = scanner.next();
            System.out.printf("|%-10s|%-10s|%-12s|%-12s|%-8s|%-10s|%-8s %n", "FlightId", "Origin", "Destination", "Date", "Time", "Price", "Seats");
            boolean bool2 = database.checkNum(price);
            if (bool2) {
                int price2 = Integer.parseInt(price);
                count2 = database.flights.searchFlight(origin, destination, time, date, price2, temp, database);
            }
            if (count2 == 0) {
                System.out.println("This flight not found!");
                break;
            }

            bool = false;
        }
    }


    public void bookingTicketData(String userName, Database database) {

        System.out.println("--------------------------- ✈ Booking ticket ✈ ---------------------------");
        System.out.print("Enter the FlightId : ");
        String flightIdBook = scanner.next();

        for (int j = 0; j < database.passengers.passengerData.size(); j++) {
            if (database.passengers.passengerData.get(j) == null) {
                break;
            }
            if (Objects.equals(database.passengers.passengerData.get(j).getUserName(), userName)) {
                int count = 0;

                for (int i = 0; i < database.flights.flightData.size(); i++) {
                    if (Objects.equals(flightIdBook, database.flights.flightData.get(i).getFlightId())) {
                        if ((Integer.parseInt(database.flights.flightData.get(i).getSeats()) > 0) &&
                                (Integer.parseInt(database.flights.flightData.get(i).getPrice()) <= Integer.parseInt(database.passengers.passengerData.get(j).getCharge()))) {
                            database.flights.flightData.get(i).setSeats(String.valueOf((Integer.parseInt(database.flights.flightData.get(i).getSeats())) - 1));
                            int q = database.tickets.addTicket(i, j, database);
                            count = 1;
                            System.out.println("Your ticket has been booked successfully ✔");
                            System.out.println("your ticket id is :" + database.tickets.ticketIdArray[q - 1]);
                            database.passengers.addCharge(userName, String.valueOf(-(Integer.parseInt(database.flights.flightData.get(i).getPrice()))));
                        }
                    }
                }

                if (count == 0) {
                    int count3 = 0;

                    for (int i = 0; i < database.flights.flightData.size(); i++) {

                        if (Objects.equals(flightIdBook, database.flights.flightData.get(i).getFlightId())) {
                            if (Integer.parseInt(database.flights.flightData.get(i).getSeats()) == 0 && Integer.parseInt(database.flights.flightData.get(i).getPrice()) > Integer.parseInt(database.passengers.passengerData.get(j).getCharge())) {
                                System.out.println("Sorry! the capacity of this flight has been completed and the price of this ticket is more than your charge");
                                count3 = 1;
                                break;
                            }
                            if (Integer.parseInt(database.flights.flightData.get(i).getSeats()) == 0) {
                                System.out.println("Sorry! the capacity of this flight has been completed");
                                count3 = 1;
                            }
                            if (Integer.parseInt(database.flights.flightData.get(i).getPrice()) > Integer.parseInt(database.passengers.passengerData.get(j).getCharge())) {
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
        }
    }

    public void ticketCancellationData(String userName, Database database) {
        int count;
        System.out.println("--------------------------- ✈ Ticket cancellation ✈ ---------------------------");

        System.out.print("Enter your TicketId :");
        String ticketId = scanner.next();
        count = database.tickets.removeTicket2(userName, ticketId, database);
        if (count > 0)
            System.out.println("The ticket cancel successfully ");
        else
            System.out.println("This ticket not found !");

    }

    public void bookedTickets(String userName, Database database) {
        System.out.println("--------------------------- ✈ Booking ticket ✈ ---------------------------");
        int count = 0;

        System.out.printf("|%-10s|%-10s|%-10s|%-12s|%-12s|%-8s|%-10s|%-8s|%-50s %n", "TicketId", "FlightId", "Origin", "Destination", "Date", "Time", "Price", "Seats", "Explanation");

        for (int i = 0; i < database.tickets.ticket.size(); i++) {
            if (Objects.equals(database.tickets.ticket.get(i).getPassenger().getUserName(), userName)) {
                System.out.printf("|%-10s|%-10s|%-10s|%-12s|%-12s|%-8s|%-10s|%-8s|%-50s %n", database.tickets.ticket.get(i).getTicketId(),
                        database.tickets.ticket.get(i).getFlight().getFlightId(), database.tickets.ticket.get(i).getFlight().getOrigin(),
                        database.tickets.ticket.get(i).getFlight().getDestination(), database.tickets.ticket.get(i).getFlight().getDate(),
                        database.tickets.ticket.get(i).getFlight().getTime(), database.tickets.ticket.get(i).getFlight().getPrice(),
                        database.tickets.ticket.get(i).getFlight().getSeats(), database.tickets.ticket.get(i).getExplanation());
                count = 1;
            }

        }

        if (count == 0) {
            System.out.println("\n                                     Not found!");
        }
    }
}