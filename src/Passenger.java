import java.util.Scanner;

public class Passenger {
    Scanner scanner = new Scanner(System.in);

    private  String userName;
    private String password;
    private int charge ;


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

    public void passengersMenuOption(){
        System.out.println("---------------------------✈ Passengers menu option ✈---------------------------");
        System.out.println("""
                \t<1> Change password\s
                \t<2> Search flight tickets
                \t<3> Booking ticket
                \t<4> Ticket cancellation
                \t<5> Booked tickets
                \t<6> Add charge\s
                \t<0> sign out\s""");
    }
    public void passengerOption(int cellOfPassword , Passenger[] data , String username) {
        boolean bool1 = true;
        boolean bool2 = true;
        while (bool1 == true) {
            passengersMenuOption();
            int passengerInput = scanner.nextInt();
            switch (passengerInput) {
                case 1:
                    System.out.println("Enter the new password");
                    String newPassword = scanner.next();
                    data[cellOfPassword]=  new Passenger(username ,newPassword , charge);
                    System.out.println("The changes were made successfully :)\n<1> Back to last menu");
                    int passengerInput2 = 0;
                    while (bool2 == true) {
                        passengerInput2 = scanner.nextInt();
                        switch (passengerInput2) {
                            case 1:
                                bool2 = false;
                                break;
                            default:
                                System.out.println("Invalid number!\nplease choose a number again");
                        }
                    }
                    break;
                case 2:
                    bool1 = false;
                    break;
                case 3:
                    bool1 = false;
                    break;
                case 4:
                    bool1 = false;
                    break;
                case 5:
                    bool1 = false;
                    break;
                case 6:
                    System.out.println("please add your charge :");
                    setCharge(scanner.nextInt());
                    System.out.println("your charge has been successfully added\nNow your charge is" + getCharge() + "\n<1> Back");
                    while (bool2 == true) {
                        passengerInput2 = scanner.nextInt();
                        switch (passengerInput2) {
                            case 1:
                                bool2 = false;
                                break;
                            default:
                                System.out.println("Invalid number!\nplease choose a number again");
                        }
                    }
                    break;
                case 0:
                    bool1 = false;
                    break;
                default:
                    System.out.println("Invalid number!\nplease choose a number again");

            }
        }
    }

}


