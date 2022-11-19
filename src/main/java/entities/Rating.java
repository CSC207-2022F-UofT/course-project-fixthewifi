package entities;

public class Rating {
    private double avgRating;
    private int numOfRatings;
    private double totalRating;
    
    public double getAvgRating() {
        return avgRating;
    }
    public void setAvgRating(float avgRating) {
        this.avgRating = avgRating;
    }

    public int getNumOfRatings() {
        return numOfRatings;
    }

    public void setNumOfRatings(int numOfRatings) {
        this.numOfRatings = numOfRatings;
    }

    public double getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(int totalRating) {
        this.totalRating = totalRating;
    }

    public double calculateAvgRating(double submittedRating) {
        totalRating += submittedRating;
        numOfRatings++;
        avgRating = totalRating / numOfRatings;
        return avgRating; 
    }

}
