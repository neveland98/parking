package parkinglot;

public class Car {
	//attributes
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
		return t.toString();
	}

}
