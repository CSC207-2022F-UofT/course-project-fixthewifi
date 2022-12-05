package client.interface_adapters.model.model_entities;

public class Rating {
    private double avgRating;
    private int numOfRatings;
    private double totalRating;
    // Possible feature would be to create an array to store individual ratings. But not neccessary

    public Rating(double avgRating, int numOfRatings, double totalRating)
    {
        this.avgRating = avgRating;
        this.numOfRatings = numOfRatings;
        this.totalRating = totalRating;
    }
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

    public void setRating(double rating)
    {
        this.avgRating = rating;
    }

}
