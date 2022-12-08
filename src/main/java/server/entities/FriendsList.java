package server.entities;

import java.util.Collections;
import java.util.List;

public class FriendsList
{
    private List<User> friendlist;
    public User getFriendByUid;
    
    public FriendsList(){
        friendlist = Collections.emptyList();
    }

    public void addFriend(User user){
        friendlist.add(user);
    }

    public void deleteFriend(User user){
        friendlist.remove(user);
    }

    public List<User> viewFriends(){
        return friendlist;
    }
    
}
