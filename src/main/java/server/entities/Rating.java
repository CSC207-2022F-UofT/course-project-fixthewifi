package server.entities;

public class Rating {
    private double avgRating;
    private int numOfRatings;
    private double totalRating;
    // Possible feature would be to create an array to store individual ratings. But not neccessary
    
    public double getAvgRating() {
        return avgRating;
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
