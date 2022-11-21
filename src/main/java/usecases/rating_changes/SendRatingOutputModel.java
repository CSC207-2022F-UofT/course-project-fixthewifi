// same as SendTeamInputModel.java
package usecases.rating_changes;

public class SendRatingOutputModel {
    int receiverUid;
    double avgRating;
    
    public int getReceiverUid() {
        return receiverUid;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public SendRatingOutputModel(int receiverUid, double avgRating) {
        this.receiverUid = receiverUid;
        this.avgRating = avgRating;
    }
}
