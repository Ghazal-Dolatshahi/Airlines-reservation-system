public class Passenger {
    private final String userName;
    private String password;
    private String charge;

    public Passenger(String userName, String password, String charge) {
        this.userName = userName;
        this.password = password;
        this.charge = charge;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getCharge() {
        return charge;
    }

    public void setCharge(String charge) {
        this.charge = charge;
    }
}