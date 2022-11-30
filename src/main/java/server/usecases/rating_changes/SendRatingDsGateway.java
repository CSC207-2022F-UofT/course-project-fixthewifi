package server.usecases.rating_changes;

public interface SendRatingDsGateway {
    void storeRating(int receiverUid, double avgRating);
}
