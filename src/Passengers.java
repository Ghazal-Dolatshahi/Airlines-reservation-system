import java.util.ArrayList;
import java.util.Objects;

public class Passengers {
    ArrayList<Passenger> passengerData;

    public Passengers() {
        this.passengerData = new ArrayList<>();
    }

    public void changePassword(String newPassword, int j) {
        passengerData.get(j).setPassword(newPassword);
    }

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