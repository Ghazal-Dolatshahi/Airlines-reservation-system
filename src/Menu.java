import java.util.Objects;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    AdminControl adminControl = new AdminControl();
    PassengerControl passengerControl = new PassengerControl();
    int temp = 0;
    int k = 0;

    public void menu(Database database) {

        boolean bool = true;
        while (bool) {
            System.out.println("--------------------------- ✈ Welcome to airline reservation system ✈ ---------------------------");
            System.out.println("1- Sign in ");
            System.out.println("2- Sign up ");
            System.out.println("3- Exit ");

            String command = scanner.next();
            switch (command) {
                case "1" -> {
                    signIn(database);
                    bool = false;
                }
                case "2" -> {
                    signUp(database);
                    bool = false;
                }
                case "3" -> bool = false;
                default -> System.out.println("Invalid! please choose a number again");
            }
        }
    }

    public void signUp(Database database) {
        System.out.println("--------------------------- ✈ Sign up ✈ ---------------------------");
        String userName = setUsername(database);

        System.out.print("Enter your password : ");
        String password = scanner.next();

        Passenger newPassenger = new Passenger(userName, password, "0");
        database.passengers.passengerData.add(k, newPassenger);
        k++;

        System.out.println("Dear " + userName + " Welcome to Airlines reservation system \nYour sign up was successful ✔ \n1- Back");
        String command = scanner.next();

        while (!Objects.equals(command, "1") || !database.checkNum(command)) {
            System.out.println("Invalid number! Please choose a number again \n 1- Back ");
            command = scanner.next();
        }

        menu(database);
    }

    public void signIn(Database database) {
        if (temp == 0) {
            database.flights.showFlights();
        }
        temp = 1;
        int count = 0;

        System.out.println("--------------------------- ✈ Sign in ✈ ---------------------------");
        System.out.print("Enter your Username : ");
        String userName = scanner.next();
        System.out.print("Enter your password : ");
        String password = scanner.next();

        if (Objects.equals(password, database.admins.admins.get(0).getPassword()) && Objects.equals(userName, database.admins.admins.get(0).getUsername())) {
            adminControl.adminOption(database);
            menu(database);
            count = 1;
        }

        for (int j = 0; j < database.passengers.passengerData.size(); j++) {
            if (Objects.equals(userName, database.passengers.passengerData.get(j).getUserName()) && Objects.equals(password, database.passengers.passengerData.get(j).getPassword())) {
                passengerControl.passengerOption(j, userName, database);
                menu(database);
                count = 1;
                break;
            }
        }

        if (count == 0) {
            System.out.println("No user found with this password and username!");
            menu(database);
        }
    }

    public String setUsername(Database database) {
        int temp = 0;

        System.out.print("Enter your Username : ");
        String userName = scanner.next();

        while (temp == 0) {
            for (int i = 0; i < database.passengers.passengerData.size(); i++) {
                if (database.passengers.passengerData.get(i) == null) {
                    break;
                }
                while (Objects.equals(userName, database.passengers.passengerData.get(i).getUserName()) || Objects.equals(userName, database.admins.admins.get(0).getUsername())) {
                    System.out.println("This username has already used :(");
                    System.out.print("Enter your Username : ");
                    userName = scanner.next();
                    i = 0;
                }
            }
            temp = 1;
        }
        return userName;
    }
}