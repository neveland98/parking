package parkinglot;
import java.io.*;
public class Main {
    public static void main(String[] args) {
    	String filename = args[0];
    	try {
			BufferedReader br = new BufferedReader(new FileReader(filename));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	ParkingLot p = new ParkingLot(1,5.0);
    	p.getStats();
    }
}
