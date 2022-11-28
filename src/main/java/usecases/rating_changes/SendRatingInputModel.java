package usecases.rating_changes;

public class SendRatingInputModel {
    int senderUid;
    int receiverUid;
    double avgRating;

    public SendRatingInputModel(int senderUid, int receiverUid, double avgRating) {
        this.senderUid = senderUid;
        this.receiverUid = receiverUid;
        this.avgRating = avgRating;
    }

}
