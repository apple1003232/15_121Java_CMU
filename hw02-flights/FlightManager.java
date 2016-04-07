/**
 * 
 * @author [First Name] [Last Name] <[Andrew ID]>
 * @section [Section Letter]
 * @date [date]
 * 
 * 
 */

// You may not import any additional classes or packages.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FlightManager {
	
	public ArrayList<Flight> flights = new ArrayList<Flight>();
	
	// Use this method to test your code. Completely remove the main method
	// when you're done.
	public static void main(String[] args) {
		FlightManager fm = new FlightManager();
		
	}
	
	// Do not change this method.
	public FlightManager() {
		loadFlights();
	}
	
	/**
	 * Loads the flight data using the given specification. You must use the
     * specification provided in the write-up in order to receive full credit.
	 */
	private void loadFlights() {
		String filename = "flights.txt";
		
		try {
			Scanner sc = new Scanner(new File(filename));
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				// Look up the String.split method in the Java API to
				// understand how it works!
				String[] splitLine = line.split("[|]");
				
				// Write your code here for loadFlights.
				Flight n = new Flight(splitLine[0], 
									  splitLine[1], 
									  splitLine[2], 
									  splitLine[3], 
									  splitLine[4], 
									  Integer.parseInt(splitLine[5])
									  );
				flights.add(n);
			}
		} catch(FileNotFoundException fnfe) {
			System.out.println("I could not load the file. Please make sure " +
			                   "the file is in the correct directory.");
			System.exit(0);
		} catch(Exception e) {
			System.out.println("Error while creating the flights:");
			e.printStackTrace();
			System.exit(0);
		}
	}
	
	/**
	 * Returns the flights ArrayList.
	 * @return ArrayList<Flight>
	 */
	public ArrayList<Flight> getFlights() {
		return flights;
	}
	
	/**
	 * Finds and returns all Flights that depart from the given ICAO airport
     * code. This method must run in O(n) time. For example (your data may be
     * different):
	 *   Flights f = new Flights();
	 *   f.getFlightsDepartingFrom("PIT");
	 *   // could return [DL8273, WN2834, WN5243]
	 * @param airport - the ICAO airport code to search for
	 * @return - an ArrayList of Flight objects that depart from the given
	 * ICAO code
	 */
	public ArrayList<Flight> getFlightsDepartingFrom(String airport) {
		ArrayList<Flight> result = new ArrayList<Flight>();
		for(int i = 0;i< flights.size(); i++){
			if(flights.get(i).getDepartureAirport().compareTo(airport)==0)
				result.add(flights.get(i));
		}
		return result; // remove this line when you're done
	}
	
	
	
	/**
	 * Finds and returns an ArrayList<Flight> representing all direct Flights
     * starting in startAirport and ending at endAirport, grouped by their
     * unique identifier. For example:
	 *   Flights f = new Flights();
	 *   f.getFlightsAlongPath("PIT", "LAS"); // could return [WN2834, WN5243]
	 * @param departureAirport - the ICAO code of the departure airport
	 * @param arrivalAirport - the ICAO code of the arrival airport
	 * @return - an ArrayList<Flight> that are non-stop
	 */
	public ArrayList<Flight> getNonStopFlights(String departureAirport,
	        String arrivalAirport) {
		ArrayList<Flight> n = new ArrayList<Flight>();
		for(int i = 0; i<flights.size();i++){
			if(flights.get(i).getArrivalAirport().compareTo(arrivalAirport)==0 && 
			   flights.get(i).getDepartureAirport().compareTo(departureAirport)==0)
			{
				n.add(flights.get(i));
			}
		}
		return n; // remove this line when you're done
	}
		
	/**
	 * Cancels all flights that stop in the given airport. You must deepCopy
     * the global flights ArrayList and then remove any flights that ever exist
     * in at a given airport.
	 * @param airport - the airport that has canceled all flights
	 * @return - an ArrayList<Flight> that are still able to fly
	 */
	public ArrayList<Flight> cancelFlights(String airport) {
		ArrayList<Flight> n = deepCopy(flights);
		for(int i = 0; i<n.size();i++){
			if(n.get(i).getArrivalAirport().compareTo(airport)==0 || 
			   n.get(i).getDepartureAirport().compareTo(airport)==0)
			{
				n.remove(i);
				i--;
			}
		}
		return n; // remove this line when you're done
	}

    // Extra credit method. If you don't want to implement this method,
	// just leave it as is.
    public ArrayList<Flight> cancelFlightsCorrectly(String airport) {
		return null; // remove this line when you're done
	}
	
	/**
	 * Calculates the total distance traveled for all given flightIdentifiers
	 * @param flightIdentifiers - an ArrayList<String> representing the
     *      flightIdentifiers to search for
	 * @return - the total distance (in miles) traveled
	 */
	public int getTotalDistance(ArrayList<String> flightIdentifiers) {
		int s=0;
		for(int i=0;i<flightIdentifiers.size();i++){
			for(int j=0;j<flights.size();j++){
				if(flights.get(j).getIdentifier().compareTo(flightIdentifiers.get(i))==0){
					s+=flights.get(j).getDistance();
					break;
				}
			}
		}
		return s; // remove this line when you're done
	}
	
	/**
	 * Arranges the flights in an ArrayList<ArrayList<Flight>>. Each
     * ArrayList<ArrayList> represents a unique flight path. Each
     * ArrayList<ArrayList<Flight>> represents a collection of the flight path,
	 * in the same order as the input file.
	 */
	public ArrayList<ArrayList<Flight>> arrangedFlights() {
		ArrayList<ArrayList<Flight>> r = new ArrayList<ArrayList<Flight>>();
		ArrayList<String> id = new ArrayList<String>();
		for(int i=0;i<flights.size();i++){
			if(id.contains(flights.get(i).getIdentifier()) ){
				r.get(id.indexOf(flights.get(i).getIdentifier())).add(flights.get(i));
			}else{
				ArrayList<Flight> t = new ArrayList<Flight>();
				t.add(flights.get(i));
				r.add(t);
			}
		}
		return r; // remove this line when you're done
	}
	
	/**
	 * Returns an ArrayList<ArrayList<Flight>> corresponding to all flights that start at
     * departureAirport and end at arrivalArrival airport and have at least 1
     * stop in between. 
	 * 
	 * HINT: You may find it helpful to use the arrangedFlights() method.
	 * @param departureAirport - the ICAO code of the departure airport
	 * @param arrivalAirport - the ICAO code of the arrival airport
	 * @return - an organized list of all multi-hop flights
	 */
	public ArrayList<ArrayList<Flight>> getMultiHopFlights(String departureAirport,
	        String arrivalAirport) {
		ArrayList<ArrayList<Flight>> ar = arrangedFlights();
		ArrayList<ArrayList<Flight>> r = new ArrayList<ArrayList<Flight>>();
		for(int i=0;i<ar.size();i++){
			for(int j=0;j<ar.get(i).size();j++){
				ArrayList<Flight> temp = new ArrayList<Flight>();
				if(ar.get(i).get(j).getDepartureAirport().compareTo(departureAirport)==0){
					temp.add(ar.get(i).get(j));
					int ind;
					for(ind=j+1; ind<ar.get(i).size();ind++){
						temp.add(ar.get(i).get(ind));
						if(ar.get(i).get(ind).getArrivalAirport().compareTo(arrivalAirport)==0)
							break;
					}
					if(ind==ar.get(i).size() && ar.get(i).get(ind-1).getArrivalAirport().compareTo(arrivalAirport)!=0);
					else
						r.add(temp);
				}
			}
		}
		return r; // remove this line when you're done
	}

	/**
	 * Returns an ArrayList<Flight> of all the flights that depart from the
	 * given airport in the AM (i.e. between 0000 and 1159, midnight and
	 * noon). This method must run in O(n) time.
	 *
	 * @param departureAirport - the ICAO code of the departure airport
	 * @return - a list of all the departing AM flights from the airport
	 */
	public ArrayList<Flight> morningDepartingFlights(String departureAirport) {
		ArrayList<Flight> r = new ArrayList<Flight>();
		
			for(int j=0;j<flights.size();j++){
				if(flights.get(j).getDepartureAirport().compareTo(departureAirport)==0 && 
				   flights.get(j).getDepartureTime().compareTo("0000")>=0 && 
				   flights.get(j).getDepartureTime().compareTo("1159")<=0)
				{
					r.add(flights.get(j));
				}
			}
		
        return r; // remove this line when you're done
	}
	
  
	
	/**
	 * Returns an ArrayList<Flight> of Flight(s) that go from the specified
	 * departure airport to the specified arrival airport in the fewest number
	 * of miles. The shortest flight path can be nonstop or multi-hop. If there
	 * is no flight path that goes between the two specified airports, return
	 * an empty List.
	 
	 * @param departureAirport - the ICAO code of the departure airport
	 * @param arrivalAirport - the ICAO code of the arrival airport
	 * @return - a list of the Flights in the shortest flight path, in order
	 */
	public ArrayList<Flight> shortestFlight(String departureAirport,
	        String arrivalAirport) {
		ArrayList<Flight> r1 = new ArrayList<Flight>();
		int d = Integer.MAX_VALUE;
		ArrayList<Flight> non = getNonStopFlights(departureAirport, arrivalAirport);
		if(non!=null){
			for(int i=0;i<non.size();i++){
				d = non.get(i).getDistance()<d ? non.get(i).getDistance() : d;
			}
			for(int i=0;i<non.size();i++){
				if(non.get(i).getDistance()==d)
					r1.add(non.get(i));
			}
		}
		int d2 = Integer.MAX_VALUE;
		ArrayList<ArrayList<Flight>> mul = getMultiHopFlights(departureAirport, arrivalAirport);
		ArrayList<ArrayList<String>> mulstr = new ArrayList<ArrayList<String>>();
		ArrayList<Flight> r2 = new ArrayList<Flight>();
		if(mul!=null){
			for(int i=0;i<mul.size();i++){
				ArrayList<String> s = new ArrayList<String>();
				for(int j=0;j<mul.get(i).size();j++)
					s.add(mul.get(i).get(j).getIdentifier());
				mulstr.add(s);
			}
			for(int i=0;i<mul.size();i++){
				d2 = getTotalDistance(mulstr.get(i))<d2 ? getTotalDistance(mulstr.get(i)) : d2;
				r2 = deepCopy(mul.get(i));
			}
			
		}
		if(d2 < d) return r2;
		if(d2 > d) return r1;
		return null; // remove this line when you're done
		//if d==d2 ?
	}
	
	/**
	 * deepCopies an ArrayList<Flight>
	 * @param theFlights
	 * @return - a new ArrayList<Flight> containing the same Flights in the
     *      same order as the given ArrayList<Flight>
	 */
	private ArrayList<Flight> deepCopy(ArrayList<Flight> theFlights) {
		ArrayList<Flight> n = new ArrayList<Flight>();
		for(int i=0; i< theFlights.size();i++){
			Flight f = new Flight(theFlights.get(i).getIdentifier(), 
								  theFlights.get(i).getDepartureAirport(), 
								  theFlights.get(i).getDepartureTime(),
								  theFlights.get(i).getArrivalAirport(), 
								  theFlights.get(i).getArrivalTime(), 
								  theFlights.get(i).getDistance()
								 );
			n.add(f);
		}

		return n; // remove this line when you're done
	}
}
