import java.util.ArrayList;

public class Admins {
    ArrayList<Admin> admins;

    public Admins() {

        this.admins = new ArrayList<>();
        Admin admin1 = new Admin("admin", "2004");
        admins.add(0, admin1);
    }
}
