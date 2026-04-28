package cab_booking;
class Trip {
 String tripId, customerId, driverId, pickup, drop, status;
 double fare;
 long startTime, endTime;
 Trip(String tripId, String customerId, String pickup, String drop) {
     this.tripId = tripId;
     this.customerId = customerId;
     this.pickup = pickup;
     this.drop = drop;
     this.status = "REQUESTED";
 }
 void start() {
     status = "ONGOING";
     startTime = System.currentTimeMillis();
     System.out.println("Trip started");
 }

 void complete() {
     status = "COMPLETED";
     endTime = System.currentTimeMillis();
     System.out.println("Trip completed");
 }

 void cancel() {
     status = "CANCELLED";
     fare = 50;
     System.out.println("Trip cancelledCharge:rs 50");
 }

 void calculateFare(FareEngine engine, double distanceKm, double timeMin, String type) {
     fare = engine.computeFinal(distanceKm, timeMin, type);
 }
}