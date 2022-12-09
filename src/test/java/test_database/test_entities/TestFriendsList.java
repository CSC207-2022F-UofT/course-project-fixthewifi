package test_database.test_entities;

import server.entities.FriendsList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class TestFriendsList {
    @Test
    public void testViewFriendsEmptyList(){
        FriendsList friends = new FriendsList();
        Assertions.assertTrue(friends.viewFriends().isEmpty());
    }
//    @Test
//    public void testAddFriend(){
//        CommonUser User = new CommonUser(111111, "1user", 1);
//        FriendsList friends = new FriendsList();
//
//        friends.addFriend(User);
//        Assertions.assertFalse(friends.viewFriends().isEmpty());
//        Assertions.assertTrue(friends.viewFriends().contains(User));
//    }
//    @Test
//    public void testAdd2Friends(){
//        CommonUser User = new CommonUser(111111, "1user", 1);
//        CommonUser user2 = new CommonUser(222222, "2user", 2);
//        FriendsList friends = new FriendsList();
//
//        friends.addFriend(User);
//        friends.addFriend(user2);
//        Assertions.assertFalse(friends.viewFriends().isEmpty());
//        Assertions.assertTrue(friends.viewFriends().contains(User));
//        Assertions.assertTrue(friends.viewFriends().contains(user2));
//    }
//
//    @Test
//    public void testAddFriendRemoveFriend(){
//        CommonUser User = new CommonUser(111111, "1user", 1);
//        FriendsList friends = new FriendsList();
//
//        friends.addFriend(User);
//        friends.deleteFriend(User);
//
//        Assertions.assertTrue(friends.viewFriends().isEmpty());
//    }
//    @Test
//    public void testAdd2FriendsRemove1Friend(){
//        CommonUser User = new CommonUser(111111, "1user", 1);
//        FriendsList friends = new FriendsList();
//
//        friends.addFriend(User);
//        friends.deleteFriend(User);
//
//        Assertions.assertTrue(friends.viewFriends().isEmpty());
//    }
}
