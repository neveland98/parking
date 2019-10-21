package parkinglot;
import java.sql.*;
import java.util.LinkedList;
import java.util.Queue;
public class ParkingLot {
	//attributes
	private int capacity;//capacity of the lot
	private int numCars = 0;//current number of cars
	private int carsAllTime = 0; //number of cars that used the parking lot since opening
	private double ticketPrice;//price of one ticket
	private double totalProfit = 0; //total profit made since opening
	private int currentTicket = 0;//current ticket number
	private Gate entranceGate = new Gate();
	private Gate exitGate = new Gate();
	private Car carsInLot[];
	private Queue<Car> carQueue;
	//constructors
	ParkingLot() {
		capacity = 30;
		carsInLot = new Car[60];
		carQueue = new LinkedList<Car>();
		
		ticketPrice = 5.0;
	}
	ParkingLot(int c, double p) {
		capacity = c;
		carsInLot = new Car[2*c];
		ticketPrice = p;
		carQueue = new LinkedList<Car>();
		}
	//methods
	public void enter(Car c) {
		/* Check if there is space available
		 * if there is space, give car ticket and allow to enter, and increment numCars
		 * else,  allow car to queue at gate 
		 */
		if(numCars < capacity) {
			c.setTicket(new Ticket());
		}
		else {
			carQueue.add(c);
		}
	}
	public void exit(Car c) {
		/*
		 * if gate is available, allow ticket to be paid and decrement numCars
		 * else, enqueue car at exit gate
		 * also add first car from carqueue to lot
		 */
		if(!exitGate.busy()) {
			
		}
	}
	public void enter(String n) {//owner name
		/* Check if there is space available
		 * if there is space, give car ticket and allow to enter, and increment numCars
		 * else,  allow car to queue at gate 
		 */
	}
	public void exit(String n) {//owner name
		/*
		 * if gate is available, allow ticket to be paid and decrement numCars
		 * else, enqueue car at exit gate
		 */
	}
	
  
}
