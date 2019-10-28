package parkinglot;
import java.util.LinkedList;
public class Group {
	//a
	private String groupName;
	private double groupPrice;
	private LinkedList<ParkingLot> plist;
	//c
	Group() { 
		plist = new LinkedList<ParkingLot>();
		groupPrice = 5.0;
		groupName = "A Group";
	}
	Group(double p,String n) {
		plist = new LinkedList<ParkingLot>();
		groupPrice = p;
		groupName = n;
	}
	//m
	public void addLot(ParkingLot p) {
		p.setPrice(groupPrice);
		plist.add(p);
	}
	public double getPrice() {
		return groupPrice;
	}
	public void setPrice(double p) {
		groupPrice = p;
	}
	public String getName() {
		return groupName;
	}
	public void setName(String s) {
		groupName = s;
	}
	public void getStats() {
		for(int i = 0; i < plist.size();i++) {
			plist.peek().getStats();
			plist.add(plist.remove());
		}
	}
}
