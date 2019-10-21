package parkinglot;
import java.sql.*;
public class Ticket {
	//attributes
	private Timestamp time;
	//c
	Ticket() {
		time = new Timestamp(System.currentTimeMillis());
	}
	Ticket(long d) {
		time = new Timestamp(d);
	}
	//m 
	String getTime() {
		return time.toString();
	}
}
