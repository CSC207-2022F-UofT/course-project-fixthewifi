package usecases.friendinteractors.deletefriend;

public class delete_friend_input_model {
    public int friendid;
    public int requesterid;
    public String friendName;
    public String requesterName;

    public delete_friend_input_model(int friendid, int requesterid){
        this.friendid = friendid;
        this.requesterid = requesterid;
        this.friendName = "";
        this.requesterName = "";
    }

    public delete_friend_input_model(String friendName, String requesterName){
        this.friendid = -1;
        this.requesterid = -1;
        this.friendName = friendName;
        this.requesterName = requesterName;
    }
}
