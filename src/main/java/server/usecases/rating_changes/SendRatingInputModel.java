package server.usecases.rating_changes;

public class SendRatingInputModel {
    int receiverUid;
    double avgRating;

    public SendRatingInputModel(int receiverUid, double avgRating) {
        this.receiverUid = receiverUid;
        this.avgRating = avgRating;
    }

}
