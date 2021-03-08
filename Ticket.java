public class Ticket {

    int ticketNumber = 0;
    Airline myAirline;
    Passenger myPassenger;
    Flight myFlight;
    Double price;
    static int counter;

    public Ticket(Airline myAirline, Passenger myPassenger, Flight myFlight, Double price) {
        this.myAirline = myAirline;
        this.myPassenger = myPassenger;
        this.myFlight = myFlight;
        this.price = price;
        this.ticketNumber = ++counter;
    }
    public int getTicketNumber() {
        return ticketNumber;
    }
    public void setTicketNumber(int ticketNumber) {
        this.ticketNumber = ticketNumber;
    }
    public Airline getMyAirline() {
        return myAirline;
    }
    public void setMyAirline(Airline myAirline) {
        this.myAirline = myAirline;
    }
    public Passenger getMyPassenger() {
        return myPassenger;
    }
    public void setMyPassenger(Passenger myPassenger) {
        this.myPassenger = myPassenger;
    }
    public Flight getMyFlight() {
        return myFlight;
    }
    public void setMyFlight(Flight myFlight) {
        this.myFlight = myFlight;
    }
    public Double getPrice() {
        return price;
    }
    public void setPrice(Double price) {
        this.price = price;
    }
    public static int getCounter() {
        return counter;
    }
    public static void setCounter(int counter) {
        Ticket.counter = counter;
    }
    public String toString() {
        return
                myPassenger + " booked on " + myFlight.getAirline() +" " + myFlight.getFlightNumber() +
                            " " + myFlight.getDate() +" " + myFlight.getDepartureTime() +
                            " from " + myFlight.getOriginAirport() + " " + myFlight.getDestination() +
                            " ticket cost " + price;
    }
    //  cancels the passenger’s ticket t
    void cancel(Ticket t){
        myFlight.remove(t);
    }

}
