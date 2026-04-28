package cab_booking;
import java.util.*;
class Customer {
String customerId;
String name;
String phone;
double rating;
List<Trip> tripHistory = new ArrayList<>();

Customer(String id, String name, String phone){
	     this.customerId = id;
	     this.name = name;
	     this.phone = phone;
	     this.rating = 5.0;
}
Trip requestRide(String pickup, String drop){
	     Trip t = new Trip(UUID.randomUUID().toString(), customerId, pickup, drop);
	     System.out.println("Ride requested");
	     return t;
}
void cancelRide(Trip t){
	     t.cancel();
}
void rateDriver(Driver d, double score){
	     d.rating = (d.rating + score) / 2;
}
void viewHistory(){
	   for (Trip t : tripHistory){
	         System.out.println(t.tripId + " " + t.status);
	    }
	}
}
