package server.usecases.rating_changes;

public interface SendRatingDsGateway {
    void storeRating(int receiverUid, double avgRating, double number, double total);
    String userAddress(int identifier);
    int userPort(int identifier);

    double[] getAverageRating(int userUid);
}
