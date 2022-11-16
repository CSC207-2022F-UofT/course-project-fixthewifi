package usecases.friendinteractors.requestfriend;

public class requestFriendInputModel {
    final private int requesterid;
    final private int friendid;
    final private String requesterName;
    final  private String friendName;

    public requestFriendInputModel(int friendid, int requesterid){
        this.friendid = friendid;
        this.requesterid = requesterid;
        this.friendName = "";
        this.requesterName = "requesterName";
    }

    public requestFriendInputModel(String friendName, String requesterName){
        this.friendid = -1;
        this.requesterid = -1;
        this.friendName = friendName;
        this.requesterName = requesterName;
    }

    public int getRequesterid() {
        return requesterid;
    }

    public int getFriendid() {
        return friendid;
    }

    public String getRequesterName() {
        return requesterName;
    }

    public String getFriendName() {
        return friendName;
    }
}
