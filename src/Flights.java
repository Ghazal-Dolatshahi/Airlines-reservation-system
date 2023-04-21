import java.util.ArrayList;
import java.util.Objects;

public class Flights {
    ArrayList<Flight> flightData;
    AdminControl adminControl = new AdminControl();

    public Flights() {
        this.flightData = new ArrayList<>();
    }

    /**
     * <span style = "font-family : Times New Roman ; font-size :12px ;color:#1E90FF">Fill the arraylist of flight data with default flights </span>
     */

    public void showFlights() {
        Flight data1 = new Flight("wx-20", "Yazd", "Shiraz", "1402/09/25", "12:30", "2500000", "110");
        Flight data2 = new Flight("gh-45", "Kish", "Tehran", "1402/01/31", "8:45", "2250000", "105");
        Flight data3 = new Flight("wx-67", "Tehran", "Mashhad", "1402/08/30", "04:25", "1500000", "102");
        Flight data4 = new Flight("ab-26", "Gorgan", "Mashhad", "1402/09/16", "01:50", "1250000", "150");
        Flight data5 = new Flight("wx-24", "Gorgan", "Esfahan", "1402/09/05", "18:55", "700000", "0");
        Flight data6 = new Flight("gh-97", "Kish", "Tehran", "1402/10/08", "14:50", "2250000", "105");
        Flight data7 = new Flight("wx-57", "Tabriz", "Mashhad", "1402/11/22", "16:00", "2250000", "51");
        Flight data8 = new Flight("cd-44", "Mashhad", "Kish", "1402/10/18", "00:00", "2150000", "107");
        Flight data9 = new Flight("wx-18", "Yazd", "Mashhad", "1402/09/15", "14:50", "950000", "56");
        Flight data10 = new Flight("gh-22", "Yazd", "Mashhad", "1402/09/25", "20:20", "2250000", "40");
        Flight data11 = new Flight("wx-45", "Yazd", "Mashhad", "1402/06/31", "01:50", "950000", "56");
        Flight data12 = new Flight("wx-78", "Yazd", "Mashhad", "1402/09/15", "15:50", "3000000", "78");
        Flight data13 = new Flight("wx-122", "Yazd", "Mashhad", "1402/09/15", "14:50", "3000000", "45");

        flightData.add(0, data1);
        flightData.add(1, data2);
        flightData.add(2, data3);
        flightData.add(3, data4);
        flightData.add(4, data5);
        flightData.add(5, data6);
        flightData.add(6, data7);
        flightData.add(7, data8);
        flightData.add(8, data9);
        flightData.add(9, data10);
        flightData.add(10, data11);
        flightData.add(11, data12);
        flightData.add(12, data13);
    }

    /**
     * <span style = "font-family : Times New Roman ; font-size :12px ;color:#1E90FF">Based on information search and find the flight</span>
     * @param origin
     *              the origin of the  desired flight
     * @param destination
     *              the destination of the desired flight
     * @param time
     *              the time of the desired flight
     * @param date
     *              the date of the desired flight
     * @param price2
     *              the price of the desired flight
     * @param temp
     *              the number of times the search is repeated
     * @param database
     *              have the list of passengers, flights, tickets and admins and  check the format of program entries
     * @return
     *              the number of flights that found
     */
    public int searchFlight(String origin, String destination, String time, String date, int price2, int temp, Database database) {
        int count = 0;
        switch (temp) {

            case 0 -> {
                for (int i = 0; i < flightData.size(); i++) {
                    if (Objects.equals(origin, flightData.get(i).getOrigin())) {
                        adminControl.flightSchedules(i, database);
                        count++;
                    }
                }
            }

            case 1 -> {
                for (int i = 0; i < flightData.size(); i++) {
                    if (Objects.equals(destination, flightData.get(i).getDestination()) && Objects.equals(origin, flightData.get(i).getOrigin())) {
                        adminControl.flightSchedules(i, database);
                        count++;
                    }
                }
            }

            case 2 -> {
                for (int i = 0; i < flightData.size(); i++) {
                    if (Objects.equals(destination, flightData.get(i).getDestination()) && Objects.equals(origin, flightData.get(i).getOrigin())
                            && Objects.equals(date, flightData.get(i).getDate())) {
                        adminControl.flightSchedules(i, database);
                        count++;
                    }
                }
            }

            case 3 -> {
                for (int i = 0; i < flightData.size(); i++) {
                    if (Objects.equals(destination, flightData.get(i).getDestination()) && Objects.equals(origin, flightData.get(i).getOrigin())
                            && Objects.equals(date, flightData.get(i).getDate()) && Objects.equals(time, flightData.get(i).getTime())) {
                        adminControl.flightSchedules(i, database);
                        count++;
                    }
                }
            }

            case 4 -> {
                for (int i = 0; i < flightData.size(); i++) {
                    if (Objects.equals(destination, flightData.get(i).getDestination()) && Objects.equals(origin, flightData.get(i).getOrigin())
                            && Objects.equals(date, flightData.get(i).getDate()) && Integer.parseInt(flightData.get(i).getPrice()) <= price2 &&
                            Objects.equals(time, flightData.get(i).getTime())) {
                        adminControl.flightSchedules(i, database);
                        count++;
                    }
                }
            }

        }
        return count;
    }

    /**
     * <span style = "font-family : Times New Roman ; font-size :12px ;color:#1E90FF">Based on the information add the flight in the arraylist</span>
     * @param flightId
     *                  the flight ID of the flight that entered by admin
     * @param origin
     *                  the origin of the flight that entered by admin
     * @param destination
     *                  the destination of the flight that entered by admin
     * @param date
     *                  the date of the flight that entered by admin
     * @param time
     *                  the time of the flight that entered by admin
     * @param price
     *                  the price of the flight that entered by admin
     * @param seats
     *                  the seats of the flight that entered by admin
     */
    public void addFlight(String flightId, String origin, String destination, String date, String time, String price, String seats) {

        Flight newData = new Flight(flightId, origin, destination, date, time, price, seats);
        flightData.add(flightData.size(), newData);
    }

    /**
     * <span style = "font-family : Times New Roman ; font-size :12px ;color:#1E90FF">Based on flight ID remove the flight from arraylist</span>
     * @param flightIdRemove
     *                      the flight ID of the flight that the admin wants to remove
     * @param database
     *                      have the list of passengers, flights, tickets and admins and check the format of program entries
     * @return
     *                      1 if found the flight with this flight ID , otherwise return 0
     */
    public int removeFlight(String flightIdRemove, Database database) {
        int count = 0;

        for (int i = 0; i < flightData.size(); i++) {
            if (Objects.equals(flightIdRemove, flightData.get(i).getFlightId())) {
                database.tickets.removeTicket(flightIdRemove, database);
                flightData.remove(i);
                i--;
                count = 1;
            }
        }
        return count;
    }

    /**
     * <span style = "font-family : Times New Roman ; font-size :12px ;color:#1E90FF">Based on the information update flights</span>
     * @param field
     *              the fields that needs to be updated
     * @param update
     *              the replacement quantity
     * @param i
     *              the cell number of arraylist of flight data
     * @param database
     *              have the list of passengers, flights, tickets and admins and check the format of program entries
     */
    public void updateFlight(String field, String update, int i, Database database) {

        switch (field) {

            case "flightid" -> {
                database.tickets.updateTicket(flightData.get(i).getFlightId(), update, "flightid", flightData.get(i).getFlightId(), database);
                flightData.get(i).setFlightId(update);
            }

            case "origin" -> {
                database.tickets.updateTicket(flightData.get(i).getFlightId(), update, "origin", flightData.get(i).getOrigin(), database);
                flightData.get(i).setOrigin(update);
            }

            case "destination" -> {
                database.tickets.updateTicket(flightData.get(i).getFlightId(), update, "destination", flightData.get(i).getDestination(), database);
                flightData.get(i).setDestination(update);
            }

            case "price" -> {
                database.tickets.updateTicket(flightData.get(i).getFlightId(), update, "price", flightData.get(i).getPrice(), database);
                flightData.get(i).setPrice(update);
            }

            case "seats" -> {
                database.tickets.updateTicket(flightData.get(i).getFlightId(), update, "seats", flightData.get(i).getSeats(), database);
                flightData.get(i).setSeats(update);
            }

            case "time" -> {
                database.tickets.updateTicket(flightData.get(i).getFlightId(), update, "time", flightData.get(i).getTime(), database);
                flightData.get(i).setTime(update);
            }

            case "date" -> {
                database.tickets.updateTicket(flightData.get(i).getFlightId(), update, "date", flightData.get(i).getDate(), database);
                flightData.get(i).setDate(update);
            }
        }
    }
}
