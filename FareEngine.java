package cab_booking;
class FareEngine {
	 double baseFare = 30;
	 double surgeMultiplier = 1.0;

	 double estimate(double distance) {
	     return baseFare + distance * 12;
	 }

	 void applySurge(double surge) {
	     surgeMultiplier = surge;
	 }

	 double computeFinal(double distanceKm, double timeMin, String type) {
	     double perKm = type.equals("premium") ? 18 : 12;
	     double fare = baseFare + (distanceKm * perKm) + (timeMin * 2);

	     fare = fare * surgeMultiplier;

	     if (fare < 60) fare = 60;

	     return fare;
	 }
	}
