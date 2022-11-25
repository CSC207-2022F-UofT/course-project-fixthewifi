package client.usecases.friendinteractors.viewfriend;

public class view_friend_input_model {

    private int requesterid;
    public view_friend_input_model(int requesterid){
        this.requesterid = requesterid;
    }

    public int getRequesterid() {
        return requesterid;
    }
}
