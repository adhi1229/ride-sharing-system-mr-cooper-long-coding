package cab_booking;
class Rating {
	 String ratingId, tripId, raterType, comment;
	 double score;

	 Rating(String id, String tripId, String type, double score, String comment) {
	     this.ratingId = id;
	     this.tripId = tripId;
	     this.raterType = type;
	     this.score = score;
	     this.comment = comment;
	 }

	 void submit() {
	     System.out.println("Rating submitted: " + score);
	 }
	}
