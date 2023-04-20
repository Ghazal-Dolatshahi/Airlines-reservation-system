
public class Ticket {
    private final String ticketId;
    private final Flight flight;
    private final Passenger passenger;
    private String explanation;

    public Ticket(String ticketId, Flight flight, Passenger passenger, String explanation) {
        this.ticketId = ticketId;
        this.flight = flight;
        this.passenger = passenger;
        this.explanation = explanation;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getTicketId() {
        return ticketId;
    }

    public Flight getFlight() {
        return flight;
    }

    public Passenger getPassenger() {
        return passenger;
    }
}
