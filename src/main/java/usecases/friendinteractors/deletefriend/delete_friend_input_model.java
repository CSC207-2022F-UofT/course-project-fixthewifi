package usecases.friendinteractors.deletefriend;

public class delete_friend_input_model {
    public int friendid;
    public int requesterid;
    public String friendName;
    public String requesterName;

    /**
     * Delete friend input model based on id
     * @param friendid
     * @param requesterid
     */

    public delete_friend_input_model(int friendid, int requesterid){
        this.friendid = friendid;
        this.requesterid = requesterid;
        this.friendName = "";
        this.requesterName = "";
    }

    /**
     * Delete friend input model based on name
     * @param friendName
     * @param requesterName
     */
    public delete_friend_input_model(String friendName, String requesterName){
        this.friendid = -1;
        this.requesterid = -1;
        this.friendName = friendName;
        this.requesterName = requesterName;
    }
}
