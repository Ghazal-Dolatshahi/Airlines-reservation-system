import java.util.Objects;
import java.util.Scanner;

public class Menu {
    Scanner scanner = new Scanner(System.in);
    AdminControl adminControl = new AdminControl();
    PassengerControl passengerControl = new PassengerControl();
    int temp = 0;
    int k = 0;

    /**
     * <h1 style = "font-family : Times New Roman ; color:#20B2AA">Menu method :</h1>
     *
     * <pre style = "font-family : Times New Roman ; font-size :12px ;color:#20B2AA">
     * Enter 1 to sign in   <span style=" font-size :12px ; font-family : Times New Roman">{@link #signIn(Database)}</span><hr>
     * Enter 2 to sign up    <span style=" font-size :12px ; font-family : Times New Roman">{@link #signUp(Database)}</span><hr>
     * Enter 3 to Exit <hr></pre>
     *
     *     <img src = "../src/Pics/air-plane.jpg" height = "300" width = "620">
     *
     * @param database
     *                have the list of passengers,flights,tickets and admins and check the format of program entries
     * @see Database
     *                public class Database
     */

    public void menu(Database database) {

        boolean bool = true;
        while (bool) {
            System.out.println("\033[94m---------- ✈ \u001b[0m Welcome to airline reservation system \033[94m✈ -------------\u001b[0m");
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
                default -> System.out.println("\033[91mInvalid!\u001b[0m please choose a number again");
            }
        }
    }

    /**
     *
     * <span style = "font-family : Times New Roman ; font-size :12px ;color:#1E90FF">Each passenger chooses her/his password and username and sign up </span>
     * @param database
     *               have the list of passengers, flights, tickets and admins and check the format of program entries
     */

    public void signUp(Database database) {
        System.out.println("\033[94m--------------------------- ✈ \u001b[0mSign up \033[94m✈ ---------------------------\u001b[0m");
        String userName = setUsername(database);

        System.out.print("Enter your password : ");
        String password = scanner.next();

        Passenger newPassenger = new Passenger(userName, password, "0");
        database.passengers.passengerData.add(k, newPassenger);
        k++;

        System.out.println("\u001b[35mDear " + userName +"\u001b[0m" + " Welcome to Airlines reservation system \nYour sign up was successful ✔ \n1- Back");
        String command = scanner.next();

        while (!Objects.equals(command, "1") || !database.checkNum(command)) {
            System.out.println("\033[91mInvalid number!\u001b[0m Please choose a number again \n 1- Back ");
            command = scanner.next();
        }

        menu(database);
    }

    /**
     * <span style = "font-family : Times New Roman ; font-size :12px ;color:#1E90FF">Users enter their password and username and sign in </span>
     * @param database
     *                 have the list of passengers, flights, tickets and admins and check the format of program entries
     */
    public void signIn(Database database) {
        if (temp == 0) {
            database.flights.showFlights();
        }
        temp = 1;
        int count = 0;

        System.out.println("\033[94m--------------------------- ✈\u001b[0m Sign in \033[94m✈ ---------------------------\u001b[0m");
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

    /**
     * <span style = "font-family : Times New Roman ; font-size :12px ;color:#1E90FF">Gets a username from the users and checks that it is not duplicated </span>
     * @param database
     *                  have the list of passengers, flights, tickets and admins and check the format of program entries
     * @return
     *                  the valid username
     */
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