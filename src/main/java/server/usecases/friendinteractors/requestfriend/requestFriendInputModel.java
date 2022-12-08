package server.usecases.friendinteractors.requestfriend;

public class requestFriendInputModel {
    final private int requesterid;
    final private int friendid;
    final private String requesterName;
    final  private String friendName;

    /**
     * Delete friend input model based on id
     * @param friendid
     * @param requesterid
     */
    public requestFriendInputModel(int friendid, int requesterid){
        this.friendid = friendid;
        this.requesterid = requesterid;
        this.friendName = "";
        this.requesterName = "";
    }

    /**
     * Delete friend input model based on name
     * @param friendName
     * @param requesterid
     */
    public requestFriendInputModel(String friendName, int requesterid){
        this.friendid = -1;
        this.requesterid = requesterid;
        this.friendName = friendName;
        this.requesterName = "";
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
