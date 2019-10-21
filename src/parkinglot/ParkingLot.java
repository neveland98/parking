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
	private LinkedList<Car> carsInLot;
	private Queue<Car> carQueue;
	//constructors
	ParkingLot() {
		capacity = 30;
		carsInLot = new LinkedList<Car>();
		carQueue = new LinkedList<Car>();
		
		ticketPrice = 5.0;
	}
	ParkingLot(int c, double p) {
		capacity = c;
		carsInLot = new LinkedList<Car>();
		ticketPrice = p;
		carQueue = new LinkedList<Car>();
		}
	//methods
	public void enter(Car c) {
		/* Check if there is space available
		 * if there is space, give car ticket and allow to enter, and increment numCars
		 * else,  allow car to queue at gate 
		 */
		entranceGate.toggleState();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(numCars < capacity) {
			c.setTicket(new Ticket(currentTicket));
			numCars++;
			carsAllTime++;
			currentTicket++;
			carsInLot.add(c);
			System.out.print(c.getName() + "'s car has entered the parking lot.");
		}
		else {
			carQueue.add(c);
		}
		entranceGate.toggleState();
	}
	public void exit(Car c) {
		/*
		 * if gate is available, allow ticket to be paid and decrement numCars
		 * else, enqueue car at exit gate
		 * also add first car from carqueue to lot
		 */
		exitGate.toggleState();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(c.getName() + "'s car has left the parking lot at " + c.getTicketTime() + ".");
		totalProfit += ticketPrice;
		carsInLot.remove(carsInLot.indexOf(c));
		numCars--;
		exitGate.toggleState();
		if(!carQueue.isEmpty()) {
			carQueue.peek().setTicket(new Ticket(currentTicket));
			numCars++;
			carsAllTime++;
			currentTicket++;
			System.out.print(carQueue.peek().getName() + "'s car has entered the parking lot with ticket number" + carQueue.remove().getTicketNumber() + ".");
		}
	}
	public void getStats() {
		System.out.println("Total profits: $" + totalProfit);
		System.out.println("Total cars parked in lot: " + carsAllTime);
	}
  
}
