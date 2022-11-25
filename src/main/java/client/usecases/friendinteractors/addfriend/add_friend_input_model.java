package client.usecases.friendinteractors.addfriend;

public class add_friend_input_model {
    private final int friendid;
    private final int requesterid;
    private final String friendName;
    private final String requesterName;


    public add_friend_input_model(int friendid, int requesterid){
        this.friendid = friendid;
        this.requesterid = requesterid;
        this.friendName = "";
        this.requesterName = "";
    }

    public add_friend_input_model(String friendName, String requesterName){
        this.friendid = -1;
        this.requesterid = -1;
        this.friendName = friendName;
        this.requesterName = requesterName;
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
