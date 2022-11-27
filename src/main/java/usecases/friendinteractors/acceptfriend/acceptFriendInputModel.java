package usecases.friendinteractors.acceptfriend;

public class acceptFriendInputModel {
    private final int friendid;
    private final int requesterid;
    private final String friendName;
    private final String requesterName;


    public acceptFriendInputModel(int friendid, int requesterid){
        this.friendid = friendid;
        this.requesterid = requesterid;
        this.friendName = "";
        this.requesterName = "";
    }

    public int getFriendid() {
        return friendid;
    }

    public int getRequesterid() {
        return requesterid;
    }

    public String getFriendName() {
        return friendName;
    }

    public String getRequesterName() {
        return requesterName;
    }
}
