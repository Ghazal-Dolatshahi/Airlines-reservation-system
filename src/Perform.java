import java.util.Objects;
import java.util.Scanner;

public class Perform {
    Scanner scanner = new Scanner(System.in);
    Passenger passenger = new Passenger();
    static Passenger[] data = new Passenger[100];
    Admin admin = new Admin();
    Flights flights =  new Flights();
    int i = 0;
    int temp = 0;
    public void panel() {

        boolean bool = true;
        while (bool) {
            System.out.println("--------------------------- ✈ Welcome to airline reservation system ✈ ---------------------------");
            System.out.println("1- Sign in ");
            System.out.println("2- Sign up ");
            System.out.println("3- Exit ");

            int inputMenuOption = scanner.nextInt();
            switch (inputMenuOption) {
                case 1 -> {
                    signIn();
                    bool = false;
                }
                case 2 -> {
                    signUp();
                    bool = false;
                }
                case 3 -> bool = false;
                default -> System.out.println("Invalid number!\nplease choose a number again");
            }
        }
    }

    public void signUp() {

        int temp = 0;
        System.out.println("--------------------------- ✈ Sign up ✈ ---------------------------");
            System.out.print("Enter your Username : ");
            String userName = scanner.next();
            while (temp == 0 ) {
                for (int i = 0; i < data.length; i++) {
                    if (data[i] == null) {
                        break;
                    }
                    while (Objects.equals(userName, data[i].getUserName()) || Objects.equals(userName, "admin")) {
                        System.out.println("This username has already used\nTry again");
                        System.out.print("Enter your Username : ");
                        userName = scanner.next();
                        i = 0;
                    }
                }
                temp = 1;
            }

            System.out.print("Enter your password : ");
            String password = (scanner.next());
            passenger.setCharge(0);
            data[i++] = new Passenger(password, userName, passenger.getCharge());
            System.out.println(userName + " Your sign up is successful ✔ \n1- Back");
            int back = scanner.nextInt();

            while (back != 1) {
                System.out.println("Invalid number!\n1- Back \n");
                System.out.print("Please choose a number again : ");
                back = scanner.nextInt();
            }

            panel();
        }

    public void signIn() {
        if(temp == 0) {
            flights.showFlights(admin.getFlightData());
            passenger.fillArray();
        }
        temp = 1;
        int count = 0;

        System.out.println("--------------------------- ✈ Sign in ✈ ---------------------------");
        System.out.print("Enter your Username : ");
        String userName = scanner.next();
        System.out.print("Enter your password : ");
        String password = scanner.next();

        if (Objects.equals(password, "2004") && Objects.equals(userName, "admin")) {
            System.out.println("Welcome admin");
            admin.adminOption();
            panel();
            count = 1;
        }

        for (int j = 0; j < i ; j++) {
            if (Objects.equals(userName, data[j].getUserName()) && Objects.equals(password, data[j].getPassword())) {
                System.out.println("Welcome " + userName);
                passenger.passengerOption(j, data , userName);
                panel();
                count = 1;
                break;
            }
        }

        if (count == 0) {
            System.out.println("Sorry your password and username is invalid \nplease sign up and then try again");
            panel();
        }
    }
}