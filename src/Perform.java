import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Perform {
    Passenger passenger = new Passenger();
    Scanner scanner = new Scanner(System.in);
    Passenger[] data = new Passenger[100];
    Admin admin = new Admin("admin", "2004" );
    int i = 0;

    public void panel() {

        boolean bool = true;
        while (bool == true) {
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
        System.out.println("--------------------------- ✈ Sign up ✈ ---------------------------");
            System.out.print("Enter your Username : ");
            String userName = scanner.next();
            int temp = 0;
            while (temp == 0 ) {
                for (int i = 0; i < data.length; i++) {
                    if (data[i] == null) {
                        temp = 1;
                        break;
                    }
                    while (Objects.equals(userName, data[i].getUserName())) {
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
            System.out.print(userName + "Your sign up is successful ✔ \n1- Back");
            System.out.print("\nNow you can press (1) to return to the previous menu : ");
            int back = scanner.nextInt();
            while (back != 1) {
                System.out.print("Invalid number!\n1- Back \n");
                System.out.print("Please choose a number again : ");
                back = scanner.nextInt();
            }
            panel();
        }

    public void signIn() {
        System.out.println("--------------------------- ✈ Sign in ✈ ---------------------------");
        System.out.print("Enter your Username : ");
        String userName = scanner.next();
        System.out.print("Enter your password : ");
        String password = scanner.next();
        int count = 0;
        if (Objects.equals(password, "2004") && Objects.equals(userName, "admin")) {
            admin.adminOption();
            panel();
            count = 1;
        }
        for (int j = 0; j < i ; j++) {
            if (Objects.equals(userName, data[j].getUserName()) && Objects.equals(password, data[j].getPassword())) {
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