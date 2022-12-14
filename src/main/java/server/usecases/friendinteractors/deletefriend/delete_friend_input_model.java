package server.usecases.friendinteractors.deletefriend;

public class delete_friend_input_model {
    final private int friendid;
    final private int requesterid;
    final private int chatUid;
    final private String friendName;
    final private String requesterName;

    public delete_friend_input_model(int friendid, int requesterid, int chatUid){
        this.friendid = friendid;
        this.requesterid = requesterid;
        this.friendName = "";
        this.requesterName = "";
        this.chatUid = chatUid;
    }

    public delete_friend_input_model(String friendName, String requesterName){
        this.friendid = -1;
        this.requesterid = -1;
        this.chatUid = -1;
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

    public int getChatUid()
    {
        return chatUid;
    }
}
