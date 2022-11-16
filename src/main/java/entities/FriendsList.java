package entities;

import java.util.Collections;
import java.util.List;

public class FriendsList
{
    private List<CommonUser> friendlist;
    public CommonUser getFriendByUid;
    
    public FriendsList(){
        friendlist = Collections.emptyList();
    }

    public void addFriend(CommonUser user){
        friendlist.add(user);
    }

    public void deleteFriend(CommonUser user){
        friendlist.remove(user);
    }

    public List<CommonUser> viewFriends(){
        return friendlist;
    }
    
}
