package Entities;

import java.util.List;

public class FriendList {
    private List<User> friendList;

    public FriendList(){};

    public void addFriend(User user){
        friendList.add(user);
    }

    public void deleteFriend(User user){
        friendList.remove(user);
    }

    public List<User> viewFriends(){
        return friendList;
    }
}
