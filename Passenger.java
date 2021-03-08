import java.util.ArrayList;

public class Passenger {
    String firstName;
    String lastName;
    String phone;
    ArrayList<Ticket> myTickets;
    public Passenger(String firstName, String lastName, String phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.myTickets = new ArrayList<>();
    }
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public ArrayList<Ticket> getMyTickets() {
        return myTickets;
    }
    public void setMyTickets(ArrayList<Ticket> myTickets) {
        this.myTickets = myTickets;
    }
    public String toString() {
        return firstName + " " + lastName;
    }//  cancels the passenger’s ticket t
    public void cancel(Ticket t){
        myTickets.remove(t);
        t.cancel(t);
    }
    //    finds all flights for an airline on a particular date within 4 hours of a
    //    particular departure time from a particular city.
    public ArrayList<Flight> findFlights(Airline a, String date, double time, String from){
        return a.findFlights(date, time, from);
    }
    //    books a ticket for a particular flight (for the passenger).
    public Ticket bookFlight(Flight f) {
        Ticket t = new Ticket(f.getAirline(), this, f, f.getCost());
        myTickets.add(t);
        f.addTicket(t);
        return t;
    }
    //    reports where the passenger holds a particular ticket
    public boolean holdsTicket(Ticket t){
        return myTickets.contains(t);
    }

}