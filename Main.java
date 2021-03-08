import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Airline airline = simulate();
        ticketReservation(airline);
    }
//    Create a new Airline object
//   generate flights for October 2017.
//    Flight numbers should be the same from day to day.
    public static Airline simulate(){
        Airline airline = new Airline("Air Queens");
        System.out.println(airline);
        Random rand = new Random();
        for(int i = 6; i <= 22; i++) {
            double mins = rand.nextInt(60);
            double time = i + mins / 100;
            airline.createFlight(time, 100, "Kennedy", "Laguardia");
            airline.createFlight(time, 100, "Laguardia", "Kennedy");
        }
        for(int i = 0; i < 10000; i++) {
            Passenger p = new Passenger("FirstName" + i, "LastName"+i, "Phone"+ i);
            Flight f = airline.getFlights().get(rand.nextInt(airline.getFlights().size()));
            airline.book(p, f);
        }
        return airline;
    }
    public static void ticketReservation(Airline airline) {
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("Ready to book your flights. Enter your first and last name please: ");
            String name = input.nextLine();
            System.out.println("Type your address on one line please:");
            String address = input.nextLine();
            System.out.println("Type your phone number on one line please:");
            String phone = input.nextLine();
            System.out.println("Ready to book your flights between Kennedy and Laguardia for October 2017");

            Passenger p = new Passenger(name.split(" ")[0], name.split(" ")[1], phone);

            while(true) {
                System.out.println("Do you want to book or cancel a flight? Answer Yes of No:");
                String bookOrCancel = input.nextLine();

                if(bookOrCancel.equalsIgnoreCase("Yes")) {
                    System.out.println("Enter C to cancel, K for a flight from Kennedy, or L for a flight from Laguardia");
                    String flightOptions = input.nextLine();
                    if(flightOptions.equalsIgnoreCase("C")) {
                        System.out.println("Here are the tickets you have booked:");
                        int i = 0;
                        for(Ticket t: p.getMyTickets()) {
                            System.out.println( ++i + " " + t);
                        }
                        System.out.println("Type the number of the ticket you wish to cancel:");
                        int ticketToCancel = Integer.parseInt(input.nextLine());
                        Ticket cancel = p.getMyTickets().get(ticketToCancel - 1);
                        airline.cancel(cancel);

                    } else if(flightOptions.equalsIgnoreCase("K")
                            || flightOptions.equalsIgnoreCase("L")) {

                        String origin = "";

                        if(flightOptions.equalsIgnoreCase("K")) {
                            origin = "Kennedy";
                        } else {
                            origin = "Laguardia";
                        }


                        System.out.println("Enter the day in October that you want to fly:");
                        String day = input.nextLine();

                        System.out.println("Enter an hour you would like to fly (in range 1 - 24)");
                        String hours = input.nextLine();

                        ArrayList<Flight> flights = airline.findFlights(day, Double.parseDouble(hours), origin);

                        System.out.println("Here are available flights");

                        for(Flight f: flights) {
                            System.out.println(f);
                        }

                        System.out.println("Type the number of the flight you wish to book:");
                        int flightId = Integer.parseInt(input.nextLine());

                        for(Flight f: flights) {
                            if(flightId == f.getFlightNumber()) {
                                airline.book(p, f);
                                System.out.println("Successfully Booked ticket");
                            }
                        }
                    } else {
                        //  invalid options entered
                    }
                } else if(bookOrCancel.equalsIgnoreCase("No")) {
                    System.out.println("Thank you for booking with Air Queens");

                    if( p.getMyTickets().size() > 0) {
                        System.out.println("Here is a list of your bookings:");
                        for(Ticket t: p.getMyTickets()) {
                            System.out.println(t);
                        }

                    }
                    return;
                }
            }
        }
    }
}