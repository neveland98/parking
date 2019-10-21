package parkinglot;

public class ParkingLot {
	//attributes
	private int capacity;//capacity of the lot
	private int numCars = 0;//current number of cars
	private int currentTicket = 0;//current ticket number
	private Gate entranceGate = new Gate();
	private Gate exitGate = new Gate();
	//constructors
	ParkingLot() {capacity = 30;}
	ParkingLot(int c) {capacity = c;}
	//methods
	public void enter(Car c) {
		/* Check if there is space available
		 * if there is space, give car ticket and allow to enter, and increment numCars
		 * else,  allow car to queue at gate 
		 */
	}
	public void exit(Car c) {
		/*
		 * if gate is available, allow ticket to be paid and decrement numCars
		 * else, enqueue car at exit gate
		 */
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
