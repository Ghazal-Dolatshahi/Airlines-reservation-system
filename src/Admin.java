import java.util.Scanner;

public class Admin {
    private String username;
    private String password;
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
                \t<1> Add\s
                \t<2> Update
                \t<3> Remove
                \t<4> Flight schedules
                \t<0> sign out\s""");
    }
    public void adminOption(){
        boolean bool3 = true ;
        while (bool3 == true) {
            adminMenuOption();
            int adminOptionInput = scanner.nextInt();
            switch (adminOptionInput) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 0:
                    bool3 = false;
                    break;
                default:
                    System.out.println("Invalid number!\nplease choose a number again");

            }
        }
    }
}
