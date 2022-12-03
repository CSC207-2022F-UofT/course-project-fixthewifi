package server.usecases.rating_changes;

public interface SendRatingDsGateway {
    void storeRating(int receiverUid, double avgRating);
    String userAddress(int identifier);
    int userPort(int identifier);
}
