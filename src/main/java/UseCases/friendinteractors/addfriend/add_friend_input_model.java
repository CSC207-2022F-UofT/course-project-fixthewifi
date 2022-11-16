package usecases.friendinteractors.addfriend;

public class add_friend_input_model {
    final private int requesterid;
    final private int friendid;
    final private int rejectinfo;


    public add_friend_input_model(int friendid, int requesterid, int rejectinfo){
        this.friendid = friendid;
        this.requesterid = requesterid;
        this.rejectinfo = rejectinfo;
    }

    public int getRequesterid() {
        return requesterid;
    }

    public int getFriendid() {
        return friendid;
    }

    public int getRejectinfo() {
        return rejectinfo;
    }
}
