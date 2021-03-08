import java.util.ArrayList;

public class Flight {

    int flightNumber, seats, filledSeats;
    double flightLength;
    Airline airline;
    String date;
    String originAirport;
    String destination;
    String departureTime;
    ArrayList<Ticket> tickets;
    static int counter;
    public Flight(int seats, double flightLength, Airline airline, String date,
    		String originAirport, String destination, String departureTime) {
        this.flightNumber = ++counter;
        this.seats = seats;
        this.flightLength = flightLength;
        this.airline = airline;
        this.date = date;
        this.originAirport = originAirport;
        this.destination = destination;
        this.departureTime = departureTime;
        this.tickets = new ArrayList<Ticket>();
    }
    public int getFlightNumber() {
        return flightNumber;
    }
    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }
    public int getSeats() {
        return seats;
    }
    public void setSeats(int seats) {
        this.seats = seats;
    }
    public int getFilledSeats() {
        return filledSeats;
    }
    public void setFilledSeats(int filledSeats) {
        this.filledSeats = filledSeats;
    }
    public double getFlightLength() {
        return flightLength;
    }
    public void setFlightLength(double flightLength) {
        this.flightLength = flightLength;
    }
    public Airline getAirline() {
        return airline;
    }
    public void setAirline(Airline airline) {
        this.airline = airline;
    }
    public String getDate() {
        return date;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public String getOriginAirport() {
        return originAirport;
    }
    public void setOriginAirport(String originAirport) {
        this.originAirport = originAirport;
    }
    public String getDestination() {
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }
    public String getDepartureTime() {
        return departureTime;
    }
    public void setDepartureTime(String departureTime) {
        this.departureTime = departureTime;
    }
    public ArrayList<Ticket> getTickets() {
        return tickets;
    }
    public void setTickets(ArrayList<Ticket> tickets) {
        this.tickets = tickets;
    }
    public static int getCounter() {
        return counter;
    }
    public static void setCounter(int counter) {
        Flight.counter = counter;
    }
    public String toString() {
        return airline +
                " " + flightNumber +" " + date + " " + departureTime +
                " from " + originAirport + " " + destination +
                " ticket cost " + getCost();
    }
    boolean matches(String d, double t, String from) {
        String day = date.split("\\.")[1];
        if( day.equals(d)
                && originAirport == from
                && Math.abs(Double.parseDouble(departureTime) - t) <= 4) {
            return true;
        }
        return false;
    }
    //     empty seats left?
    boolean hasSpace() {
        return this.filledSeats <= this.seats;
    }
    //    newly issued ticket to the flight
    void addTicket(Ticket t) {
        this.filledSeats++;
        tickets.add(t);
    }
    boolean holdsTicket(Ticket ticket) {
        return tickets.contains(ticket);
    }
    //    Remove a canceled ticket from the flight.
    void remove(Ticket ticket) {
        tickets.remove(ticket);
        this.filledSeats--;
    }
    double getCost() {
        return airline.cost(this);
    }

}
