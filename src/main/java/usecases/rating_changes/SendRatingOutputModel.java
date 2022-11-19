// same as SendTeamInputModel.java
package usecases.rating_changes;

public class SendRatingOutputModel {
    int receiverUid;
    double avgRating;

    public SendRatingOutputModel(int receiverUid, double avgRating) {
        this.receiverUid = receiverUid;
        this.avgRating = avgRating;
    }
}
