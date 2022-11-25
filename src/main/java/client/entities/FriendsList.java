package client.entities;

import server.entities.CommonUser;

import java.util.Collections;
import java.util.List;

public class FriendsList
{
    private List<server.entities.CommonUser> friendlist;
    public server.entities.CommonUser getFriendByUid;
    
    public FriendsList(){
        friendlist = Collections.emptyList();
    }

    public void addFriend(server.entities.CommonUser user){
        friendlist.add(user);
    }

    public void deleteFriend(server.entities.CommonUser user){
        friendlist.remove(user);
    }

    public List<CommonUser> viewFriends(){
        return friendlist;
    }
    
}
