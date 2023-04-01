import java.util.Objects;
import java.util.Scanner;

public class Perform {
    Passenger passenger = new Passenger();
    Scanner scanner = new Scanner(System.in);
    Passenger[] data = new Passenger[100];
    Admin admin = new Admin("admin", "2004");
    int i = 0;

    public void panel() {

        boolean bool = true;
        while (bool == true) {
            System.out.println("---------------------------✈ Welcome to airline reservation system ✈---------------------------");
            System.out.println("\t<1> Sign in ");
            System.out.println("\t<2> Sign up ");
            System.out.println("\t<3> Exit ");

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
        System.out.println("Enter your Username : ");
        String userName = scanner.next();
        System.out.println("Enter your password :");
        String password = (scanner.next());
        int charge = 0;
        data[i++] = new Passenger(password , userName , charge);
        System.out.println("Your sign up is successful ✔ \nNow you can press <1> to go back to the menu option and sign in ;)");
        System.out.println("\t<1> Back");
        int back = scanner.nextInt();
        if (back == 1) {
            panel();
        } else
            System.out.println("Invalid number!\n please choose a number again ");
    }

    public void signIn() {
        System.out.println("Enter your Username : ");
        String userName = scanner.next();
        System.out.println("Enter your password :");
        String password = scanner.next();
        int count = 0;
        if (Objects.equals(password, "2004") && Objects.equals(userName, "admin")) {
            admin.adminOption();
            panel();
            count = 1;
        }
        for (int j = 0; j < i ; j++) {
            if (Objects.equals(userName, data[j].getUserName()) && Objects.equals(password, data[j].getPassword())) {
                int cellOfPassword = j ;
                passenger.passengerOption(cellOfPassword , data , userName);
                panel();
                count = 1;
                break;
            }
        }
        if (count == 0) {
            System.out.println("sorry your password and username is invalid \nplease sign up and then try again");
            panel();
        }
    }
}