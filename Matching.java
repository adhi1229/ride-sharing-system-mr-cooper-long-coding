package cab_booking;
import java.util.List;
class Matching {
	 double searchRadiusKm = 5;
	 Driver findNearestDriver(List<Driver> drivers) {
	     for (Driver d : drivers) {
	         if (d.isOnline) {
	             return d;
	         }
	     }
	     return null;
	 }
	}
