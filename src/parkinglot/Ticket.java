package parkinglot;
import java.sql.*;
public class Ticket {
	//attributes
	private int ticketNumber;
	private Timestamp time;
	private String lot;
	//c
	Ticket() {
		ticketNumber = -1;
		time = new Timestamp(System.currentTimeMillis());
		
	}
	Ticket(int n) {
		ticketNumber = n;
		time = new Timestamp(System.currentTimeMillis());
	}
	Ticket(int n, long d) {
		ticketNumber = n;
		time = new Timestamp(d);
	}
	//m 
	String getTime() {
		return time.toString();
	}
	int getNumber() {
		return ticketNumber;
	}
}
