package usecases.friendinteractors.deletefriend;

public class delete_friend_input_model {
    public int friendid;
    public int requesterid;
    public String friendName;
    public String requesterName;

    public delete_friend_input_model(int friendid, int requesterid){
        this.friendid = friendid;
        this.requesterid = requesterid;
    }

    public delete_friend_input_model(String friendName, String requesterName){
        this.friendName = friendName;
        this.requesterName = requesterName;
    }
}
