package entities;
import java.util.ArrayList;

public class FriendsList
{
    private ArrayList<CommonUser> friendlist;
    public CommonUser getFriendByUid;
    
    public FriendsList(){
        this.friendlist = new ArrayList<>();
    }

    public void addFriend(CommonUser user){
        this.friendlist.add(user);
    }

    public void deleteFriend(CommonUser user){
        this.friendlist.remove(user);
    }

    public ArrayList<CommonUser> viewFriends(){
        return friendlist;
    }
    
}
