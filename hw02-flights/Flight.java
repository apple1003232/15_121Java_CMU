/*
 *
 * DO NOT EDIT OR CHANGE THIS FILE!
 *
 */

public class Flight {

	private String identifier;
	private String departureAirport;
	private String departureTime;
	private String arrivalAirport;
	private String arrivalTime;
	private Integer distance;
	
	/**
	 * Creates a new Flight object with the given parameters
	 * 
	 * @param identifier - the unique identifier for the flight path provided
     *      by the airline
	 * @param departureAirport - the ICAO airport code for the departing
     *      airport
	 * @param departureTime - the 24-hour representation of the departure time
     *      of the flight
	 * @param arrivalAirport - the ICAO airport code for the arrival airport
	 * @param arrivalTime - the 24-hour representation of the arrival time of
     *      the flight
	 * @param distance - the total distance (in miles) traveled by the flight
	 */
	public Flight(String identifier, String departAirport, String departTime,
	              String arrivalAirport, String arrivalTime, Integer distance) {
		this.identifier = identifier;
		this.departureAirport = departAirport;
		this.departureTime = departTime;
		this.arrivalAirport = arrivalAirport;
		this.arrivalTime = arrivalTime;
		this.distance = distance;
	}
	
	/**
	 * Returns the identifier for the flight path. For example:
	 *   UA3921 (which is United Airlines Flight 3921)
	 *   DL2903 (which is Delta Flight 2903)
	 *   AA9024 (which is American Airlines Flight 9024)
	 * @return - the unique identifier for the flight path
	 */
	public String getIdentifier() {
		return this.identifier;
	}
	
	/**
	 * Returns the ICAO code for the departure airport. For example:
	 *   PIT (which is Pittsburgh International Airport)
	 *   ORD (which is Chicago International Airport)
	 *   LAS (which is Las Vegas International Airport)
	 * @return the ICAO code for the departure airport of this flight
	 */
	public String getDepartureAirport() {
		return this.departureAirport;
	}
	
	/**
	 * Returns the 24-hour representation of the departure time. All times are
	 * represented in the local time of the departure airport. For example,
	 * Pittsburgh is in Eastern Standard Time (EST), so all flights departing
	 * from PIT are represented in EST. For example:
	 *   0600 (6:00 AM)
	 *   1044 (10:44 AM)
	 *   1533 (2:33 PM)
	 * @return the 24-hour representation of the departure time of the flight
	 */
	public String getDepartureTime() {
		return this.departureTime;
	}
	
	/**
	 * Returns the ICAO code for the arrival airport. For example:
	 *   PIT (Pittsburgh International Airport)
	 *   ORD (Chicago International Airport)
	 *   LAS (Las Vegas International Airport)
	 * @return the ICAO code for the arrival airport of this flight
	 */
	public String getArrivalAirport() {
		return this.arrivalAirport;
	}
	
	/**
	 * Returns the 24-hour representation of the arrival time. All times are
	 * represented in the local time of the arrival airport. For example, Las
	 * Vegas is in Pacific Standard Time (PST), so all flights departing from
	 * LAS are represented in PST. For example:
	 *   0600 (6:00 AM)
	 *   1044 (10:44 AM)
	 *   1533 (3:33 PM)
	 * @return the 24-hour representation of the arrival time of the flight
	 */
	public String getArrivalTime() {
		return this.arrivalTime;
	}
	
	/**
	 * Returns the total distance (in miles) traveled by this flight. If a
	 * flight has multiple "legs" (more than one stop), the total distance
	 * traveled is the sum of the distances of all the legs traveled. For
	 * example:
	 *   PIT -> LAS = 2190 miles
	 *   PIT -> JFK -> ORD = 421 + 814 => 1235 total miles</pre>
	 * @return the total distance (in miles) traveled by this flight
	 */
	public Integer getDistance() {
		return this.distance;
	}
	
	/**
	 * Pretty format the Flight object.
	 * @return the String representing the Flight object
	 */
	public String toString() {
		return this.identifier;
	}
	
	/**
	 * Returns a nicely formatted Flight object - mostly for debugging.
	 * @return - a String representing a nicely formatted Flight object
	 */
	public String getInfo() {
		StringBuilder sb = new StringBuilder();
		
		sb.append(this.identifier);
		sb.append(": ");
		sb.append(this.departureAirport);
		sb.append("(");
		sb.append(this.departureTime);
		sb.append(") -> ");
		sb.append(this.arrivalAirport);
		sb.append("(");
		sb.append(this.arrivalTime);
		sb.append(")");
		
		return sb.toString();
	}
	
	/**
	 * Determines if two flights are equal. Two flights are equal if all 
	 * their properties are also equal.
	 */
	public boolean equals(Flight flight) {
		return this.identifier.equals(flight.identifier) &&
			   this.departureAirport.equals(flight.departureAirport) &&
			   this.departureTime.equals(flight.departureTime) &&
			   this.arrivalAirport.equals(flight.arrivalAirport) &&
			   this.arrivalTime.equals(flight.arrivalTime) &&
			   this.distance.equals(flight.distance);
	}
}
