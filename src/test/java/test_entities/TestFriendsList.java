package test_entities;

import entities.CommonUser;
import entities.FriendsList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestFriendsList {
    @Test
    public void testViewFriendsEmptyList(){
        FriendsList friends = new FriendsList();
        Assertions.assertTrue(friends.viewFriends().isEmpty());
    }
    @Test
    public void testAddFriend(){
        CommonUser user1 = new CommonUser(111111, "1user", 1);
        FriendsList friends = new FriendsList();

        friends.addFriend(user1);
        Assertions.assertFalse(friends.viewFriends().isEmpty());
        Assertions.assertTrue(friends.viewFriends().contains(user1));
    }
    @Test
    public void testAdd2Friends(){
        CommonUser user1 = new CommonUser(111111, "1user", 1);
        CommonUser user2 = new CommonUser(222222, "2user", 2);
        FriendsList friends = new FriendsList();

        friends.addFriend(user1);
        friends.addFriend(user2);
        Assertions.assertFalse(friends.viewFriends().isEmpty());
        Assertions.assertTrue(friends.viewFriends().contains(user1));
        Assertions.assertTrue(friends.viewFriends().contains(user2));
    }

    @Test
    public void testAddFriendRemoveFriend(){
        CommonUser user1 = new CommonUser(111111, "1user", 1);
        FriendsList friends = new FriendsList();

        friends.addFriend(user1);
        friends.deleteFriend(user1);

        Assertions.assertTrue(friends.viewFriends().isEmpty());
    }
    @Test
    public void testAdd2FriendsRemove1Friend(){
        CommonUser user1 = new CommonUser(111111, "1user", 1);
        FriendsList friends = new FriendsList();

        friends.addFriend(user1);
        friends.deleteFriend(user1);

        Assertions.assertTrue(friends.viewFriends().isEmpty());
    }
}
