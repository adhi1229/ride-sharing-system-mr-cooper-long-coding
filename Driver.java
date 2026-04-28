package cab_booking;

class Driver {
String driverId, name, phone, vehicleDetails, location;
double rating;
boolean isOnline;
double earningsToday;
Driver(String id, String name, String phone, String vehicleDetails, String location) {
   this.driverId = id;
   this.name = name;
   this.phone = phone;
   this.vehicleDetails = vehicleDetails;
   this.location = location;
   this.rating = 5.0;
   this.isOnline = false;
   this.earningsToday = 0;
}
void goOnline() {
   isOnline = true;
}
void goOffline() {
   isOnline = false;
}
void acceptRide(Trip trip) {
   trip.driverId = this.driverId;
   System.out.println("Driver " + name + " accepted ride");
}
void completeTrip(Trip trip) {
   earningsToday += trip.fare;
   System.out.println("Trip completed by driver " + name);
}
}