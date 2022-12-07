package server.usecases.friendinteractors.acceptfriend;


public class acceptFriendInputModel {
    private final int friendid;
    private final int requesterid;
    private final String ifAccept;



    public acceptFriendInputModel(int friendid, int requesterid, String ifAccept){
        this.friendid = friendid;
        this.requesterid = requesterid;
        this.ifAccept = ifAccept;
    }

    public int getFriendid() {
        return friendid;
    }

    public int getRequesterid() {
        return requesterid;
    }

    public String getIfAccept() {
        return ifAccept;
    }
}
