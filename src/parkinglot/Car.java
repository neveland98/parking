package parkinglot;

public class Car {
	//attributes
	boolean parked = false;
	private String ownerName;
	private Ticket t;
	//constructors
	Car() {ownerName = "John Doe";};
	Car(String s) {ownerName = s;};
	//methods
	void setName(String n) {
		ownerName = n;
	}
	String getName() {
		return ownerName;
	}
	void setTicket(Ticket t) {
		this.t = t;
	}
	Ticket getTicket() {
		return t;
	}
	String getTicketTime() {
		return t.getTime().toString();
	}
	int getTicketNumber() {
		return t.getNumber();
	}
	public double requestPrice(Group g) {
		return g.getPrice();
	}
	public double requestPrice(ParkingLot p) {
		return p.getPrice();
	}
	public void togglePark() {
		parked = !parked;
	}
	public boolean parked() {
		return parked;
	}

}
