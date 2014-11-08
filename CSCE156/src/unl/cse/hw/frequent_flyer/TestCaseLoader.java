package unl.cse.hw.frequent_flyer;

import java.io.File;
import java.util.Scanner;

public class TestCaseLoader {

    public static void clearAll() {
	System.out.println("Clearing out Customers table...");
	Customer.clear();
	System.out.println("Clearing out Flights table...");
	Flight.clear();
	System.out.println("Clearing out FlightNumbers table...");
	FlightNumber.clear();
    }

    public static void loadCustomers() {
	try {
            Scanner s = new Scanner(new File("customers.dat"));
            int n = s.nextInt();
	    s.nextLine();
            for(int i=0; i<n; i++) {
                String line = s.nextLine();
                String tokens[] = line.split(";");
		Customer.addCustomer(tokens[0],
				     tokens[1],
				     tokens[2],
				     tokens[3],
				     tokens[4].equals("P") ? true : false);
		for(int j=5; j<tokens.length; j++) {
		    String toks[] = tokens[j].split(",");
		    Customer.addCustomerFlight(tokens[0], toks[0], toks[1]);
		}
            }
        } catch (Exception e) {
            e.printStackTrace();
	}
    }

    public static void loadFlights() {
	try {
	    Scanner s = new Scanner(new File("flights.dat"));
	    int n = s.nextInt();
	    s.nextLine();
	    for(int i=0; i<n; i++) {
		String line = s.nextLine();
		String tokens[] = line.split(";");
		Flight.addFlight(Integer.parseInt(tokens[0]),
				 tokens[1],
				 Double.parseDouble(tokens[2]));
	    }
	} catch (Exception e) {
	    e.printStackTrace();
	}
    }

    public static void loadFlightNumbers() {
	try {
	Scanner s = new Scanner(new File("flight_numbers.dat"));
	int n = s.nextInt();
	s.nextLine();
	for(int i=0; i<n; i++) {
	    String line = s.nextLine();
	    String tokens[] = line.split(";");
	    String orig[] = tokens[2].split(",");
	    String dest[] = tokens[4].split(",");
	    FlightNumber.addFlightNumber(tokens[1],
					 orig[0],
					 orig[1],
					 orig[2],
					 tokens[3],
					 dest[0],
					 dest[1],
					 dest[2],
					 tokens[5].equals("D") ? true : false,
					 Double.parseDouble(tokens[6]));
	}
	} catch(Exception e) {
	    e.printStackTrace();
	}
    }


    public static void main(String args[]) {
	clearAll();
	loadFlightNumbers();
	loadFlights();
	loadCustomers();
    }


}
 