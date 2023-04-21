import java.util.ArrayList;
import java.util.Objects;

public class Passengers {
    ArrayList<Passenger> passengerData;

    public Passengers() {
        this.passengerData = new ArrayList<>();
    }

    /**
     *<span style = "font-family : Times New Roman ; font-size :12px ;color:#1E90FF"> Change the password of the passenger</span>
     * @param newPassword
     *                  the new password that chosen by the passenger
     * @param j
     *                  the cell number of the arraylist of passenger data
     */
    public void changePassword(String newPassword, int j) {
        passengerData.get(j).setPassword(newPassword);
    }

    /**
     * <span style = "font-family : Times New Roman ; font-size :12px ;color:#1E90FF"> passenger charge setting</span>
     * @param userName
     *                  the username of the passenger
     * @param charge
     *                  the charge of the passenger
     */
    public void addCharge(String userName, String charge) {
        for (Passenger datum : passengerData) {
            if (datum == null) {
                break;
            }
            if ((Objects.equals(datum.getUserName(), userName))) {
                datum.setCharge(String.valueOf(Integer.parseInt(datum.getCharge()) + Integer.parseInt(charge)));
            }
        }
    }
}