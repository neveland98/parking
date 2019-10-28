package parkinglot;
import java.io.*;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) throws IOException {
    	String filename = args[0];
    	File file = new File(filename);
    	int size;
    	double price;
    	String st;
		Scanner sc = new Scanner(file);
		size = sc.nextInt();
		price = sc.nextDouble();
		ParkingLot p = new ParkingLot(size,price,"Lot A");
	    while (sc.hasNextLine()) {
	    	st = sc.nextLine();
	    	p.enEx(st);
	    	//System.out.println(st);
	    } 
	    
	    p.getStats();
	    sc.close();
    }
}
