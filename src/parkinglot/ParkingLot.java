package parkinglot;
import java.sql.*;
import java.util.LinkedList;
import java.util.Queue;
public class ParkingLot {
	//attributes
	private String lotName;
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
		lotName = "Parking Lot";
		ticketPrice = 5.0;
	}
	ParkingLot(int c, double p, String n) {
		capacity = c;
		carsInLot = new LinkedList<Car>();
		ticketPrice = p;
		carQueue = new LinkedList<Car>();
		lotName = n;
		}
	//methods
	public void enter(Car c) {
		/* Check if there is space available
		 * if there is space, give car ticket and allow to enter, and increment numCars
		 * else,  allow car to queue at gate 
		 */
		if(c.parked()) {
			System.out.println(c.getName() + "'s car is already parked!");
			return;
		}
		entranceGate.toggleState();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(numCars < capacity) {
			c.setTicket(new Ticket(currentTicket));
			System.out.println(c.getName() + "'s car has entered the parking lot with ticket number " + currentTicket + ".");
			numCars++;
			carsAllTime++;
			currentTicket++;
			c.togglePark();
			carsInLot.add(c);
			
		}
		else {
			carQueue.add(c);
			System.out.println(c.getName() + "'s car has joined the line.");
		}
		entranceGate.toggleState();
	}
	public void exit(Car c) {
		/*
		 * if gate is available, allow ticket to be paid and decrement numCars
		 * else, enqueue car at exit gate
		 * also add first car from carqueue to lot
		 */
		//System.out.println("this function ran");
		exitGate.toggleState();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(c.getName() + "'s car has left the parking lot at " + c.getTicketTime() + ".");
		totalProfit += ticketPrice;
		c.togglePark();
		carsInLot.remove(carsInLot.indexOf(c));
		numCars--;
		exitGate.toggleState();
		if(!carQueue.isEmpty()) {
			carQueue.peek().setTicket(new Ticket(currentTicket));
			numCars++;
			carsAllTime++;
			currentTicket++;
			Car temp = carQueue.peek();
			temp.togglePark();
			carsInLot.add(temp);
			System.out.println(temp.getName() + "'s car has entered the parking lot with ticket number " + carQueue.remove().getTicketNumber() + ".");
		}
	}
	public void getStats() {
		System.out.println("Total profits: $" + totalProfit);
		System.out.println("Total cars parked in lot: " + carsAllTime);
	}
	public void enEx(String s) {
		if(s.isEmpty()) {
			return;
		}
		if(s.charAt(s.length()-1) == 'E') {
			enter(new Car(s.substring(0,s.length()-2)));
		}
		else {
			for(int i = 0; i < carsInLot.size(); i++ ) {
				//System.out.println(carsInLot.get(i).getName() + " from lot");
				//System.out.println(s.substring(0,s.length() - 2) + " from file");
				//System.out.println(carsInLot.get(i).getName() == s.substring(0,s.length() - 2));
				if(carsInLot.get(i).getName().contentEquals(s.substring(0,s.length() - 2)) ) {
					exit(carsInLot.get(i));
					return;
				}
			}
		}
	}
	public void setPrice(double p) {
		ticketPrice = p;
	}
	public double getPrice() {
		return ticketPrice;
	}
  
}
