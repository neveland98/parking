package parkinglot;

public class Gate {
	//attributes
	private boolean busy = false;
	//constructor
	Gate() {};
	//methods
	boolean busy() {return this.busy;}
	void toggleState() {this.busy = !this.busy;};
	
}
