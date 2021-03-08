import java.util.ArrayList;
import java.util.Random;

public class Airline {
    String name;
    ArrayList<Flight> flights;
    double baseCost;

    public Airline(String name) {
        this.name = name;
        this.flights = new ArrayList<Flight>();
        this.baseCost = 200;
    }
    public String getName() {
        return name;
    }
    public ArrayList<Flight> getFlights() {
        return flights;
    }
    public String toString() {
        return name;
    }
    //    cancel the ticket
    void cancel(Ticket t) {
        t.getMyFlight().remove(t);
        t.getMyPassenger().cancel(t);

        issueRefund(t);
    }
    //    issues a refund
    void issueRefund(Ticket t) {
        System.out.println("Airline " + this +  " refunds " + t.getPrice()
        	+ " to " + t.myPassenger.getFirstName() + " " + t.getMyPassenger().getLastName());
     }
    //    finds all flights
    ArrayList<Flight> findFlights(String date, double time, String origin) {
        ArrayList<Flight> matches = new ArrayList<Flight>();
        for(Flight f: flights) {
            if (f.matches(date, time, origin))
                matches.add(f);
        }
        return matches;
    }
    //    books a passenger on a flight
    Ticket book(Passenger p, Flight f) {
        return p.bookFlight(f);
    }
    
    double cost(Flight f) {
        double number = baseCost + (baseCost / ( f.getSeats()) - f.getFilledSeats() + 1);
        number = Math.round(number * 100);
        number = number/100;
        return number;
    }
    void createFlight(double time, int numSeats, String from, String to) {
        Random rand = new Random();
        Flight f;
        int flightNumber = 0;
        int length = rand.nextInt(24);

        for (int i = 1; i <= 31; i++) {
            String date = "10." + i + ".2017";
            String departureTime = String.format("%.02f", time);
            f = new Flight(numSeats, length, this, date, from, to, departureTime);
            if( i == 1)
                flightNumber = f.getFlightNumber();
            else
                f.setFlightNumber(flightNumber);

            this.flights.add(f);
        }
    }
}
