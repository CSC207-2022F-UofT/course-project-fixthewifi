package entities;

public class Rating {
    private double avgRating;
    private int numOfRatings;
    private int totalRating;
    
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

    public int getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(int totalRating) {
        this.totalRating = totalRating;
    }

    public double calculateAvgRating(int submittedRating) {
        totalRating += submittedRating;
        numOfRatings++;
        avgRating = totalRating / numOfRatings;
        return avgRating; 
    }

}
