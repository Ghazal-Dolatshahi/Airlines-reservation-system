import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

import static java.lang.Math.abs;

public class Tickets {
    String[] ticketIdArray;
    ArrayList<Ticket> ticket;
    int temp = 0;

    int temp2;

    public Tickets() {
        this.ticket = new ArrayList<>();
    }

    public int addTicket(int i, int j, Database database) {
        if (temp == 0) {
            fillArray();
            temp2 = 0;
        }
        temp = 1;

        Ticket ticketData = new Ticket(ticketIdArray[temp2], new Flight(database.flights.flightData.get(i).getFlightId(), database.flights.flightData.get(i).getOrigin(),
                database.flights.flightData.get(i).getDestination(), database.flights.flightData.get(i).getDate(), database.flights.flightData.get(i).getTime(),
                database.flights.flightData.get(i).getPrice(), database.flights.flightData.get(i).getSeats()), new Passenger(database.passengers.passengerData.get(j).getUserName(),
                database.passengers.passengerData.get(j).getPassword(), database.passengers.passengerData.get(j).getCharge()), "Nothing to show");

        ticket.add(ticket.size(), ticketData);
        temp2++;

        return temp2;
    }

    public void removeTicket(String flightIdRemove, Database database) {

        for (int i = 0; i < ticket.size(); i++) {
            if (Objects.equals(flightIdRemove, ticket.get(i).getFlight().getFlightId())) {
                {
                    database.passengers.addCharge(ticket.get(i).getPassenger().getUserName(), ticket.get(i).getFlight().getPrice());
                    ticket.remove(i);
                    i -= 1;
                }
            }
        }
    }

    public int removeTicket2(String userName, String ticketId, Database database) {
        int count = 0;
        String flightId = null;

        for (int i = 0; i < ticket.size(); i++) {
            if (Objects.equals(ticket.get(i).getPassenger().getUserName(), userName) && (Objects.equals(ticket.get(i).getTicketId(), ticketId))) {
                flightId = ticket.get(i).getFlight().getFlightId();
                database.passengers.addCharge(ticket.get(i).getPassenger().getUserName(), ticket.get(i).getFlight().getPrice());
                ticket.remove(i);
                i -= 1;
                count++;
            }
        }

        if (count > 0) {
            for (int k = 0; k < database.flights.flightData.size(); k++) {
                if (Objects.equals(database.flights.flightData.get(k).getFlightId(), flightId)) {
                    database.flights.flightData.get(k).setSeats(String.valueOf((Integer.parseInt(database.flights.flightData.get(k).getSeats())) + 1));
                }
            }
        }

        return count;
    }

    public void updateTicket(String flightId, String update, String field, String previous, Database database) {
        int distance;
        String userName;
        int k = 0;

        for (Ticket value : ticket) {
            if (Objects.equals(flightId, value.getFlight().getFlightId())) {
                userName = value.getPassenger().getUserName();
                value.setExplanation("The " + field + " of this flight change from " + previous + " to " + update);

                switch (field) {
                    case "flightid" -> value.getFlight().setFlightId(update);
                    case "origin" -> value.getFlight().setOrigin(update);
                    case "destination" -> value.getFlight().setDestination(update);
                    case "date" -> value.getFlight().setDate(update);
                    case "time" -> value.getFlight().setTime(update);
                    case "price" -> {
                        if (Integer.parseInt(update) > Integer.parseInt(value.getFlight().getPrice())) {
                            distance = Integer.parseInt(value.getFlight().getPrice()) - Integer.parseInt(update);

                            for (int j = 0; j < database.passengers.passengerData.size(); j++) {
                                if (Objects.equals(userName, database.passengers.passengerData.get(j).getUserName())) {
                                    k = j;
                                }
                            }

                            if (((Integer.parseInt(database.passengers.passengerData.get(k).getCharge())) < abs(distance))) {
                                removeTicket(flightId, database);
                            } else if ((Integer.parseInt(database.passengers.passengerData.get(k).getCharge())) >= abs(distance)) {
                                database.passengers.addCharge(userName, String.valueOf(distance));
                                value.getFlight().setPrice(update);
                            }
                        } else if (Integer.parseInt(update) < Integer.parseInt(value.getFlight().getPrice())) {
                            distance = Integer.parseInt(value.getFlight().getPrice()) - Integer.parseInt(update);
                            database.passengers.addCharge(userName, String.valueOf(distance));
                            value.getFlight().setPrice(update);
                        }
                    }
                    case "seats" -> value.getFlight().setSeats(update);
                }
            }
        }
    }

    public void fillArray() {

        ticketIdArray = new String[10];
        Random rand = new Random();

        for (int i = 0; i < 10; i++) {
            ticketIdArray[i] = String.valueOf(rand.nextInt(4000) + 2000);

            for (int j = i - 1; j >= 0; j--) {
                if (Objects.equals(ticketIdArray[i], ticketIdArray[j])) {
                    ticketIdArray[i] = String.valueOf(rand.nextInt(4000) + 2000);
                }
            }
        }
    }
}