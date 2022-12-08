package server.usecases.friendinteractors.viewfriend;

public class view_friend_input_model {

    private final int requesterid;
    public view_friend_input_model(int requesterid){
        this.requesterid = requesterid;
    }

    public int getRequesterid() {
        return requesterid;
    }
}
