// same as SendTeamInputModel.java
package usecases.rating_changes;

public class SendRatingOutputModel {
    int senderUid;
    int receiverUid;
    double avgRating;
    private final int userPort;
    private final String userAddress;
    
    public int getReceiverUid() {
        return receiverUid;
    }

    public double getAvgRating() {
        return avgRating;
    }

    public int getUserPort() {
        return userPort;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public SendRatingOutputModel(String userAddress, int userPort, int senderUid, int receiverUid, double avgRating) {
        this.userAddress = userAddress;
        this.userPort = userPort;
        this.senderUid = senderUid;
        this.receiverUid = receiverUid;
        this.avgRating = avgRating;
    }


}
