package test_entities;
import server.entities.*;
import server.entities.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;

public class TestGroupChat{
    @Test
    public void testGetUID(){
        int UID = 336413;
        int admin_uid = 123456;
        User admin = UserFactory.newUser(UID, "", "", 0, true);
        HashMap<Integer, User> list = new HashMap<>();
        list.put(admin_uid, admin);
        GroupChat chat1 = ChatFactory.getGroupChat(UID, "", "", admin, list);

        Assertions.assertEquals(UID,chat1.getUid(), "did not return correct UID");
    }


    @Test
    public void testGetAdmin(){
        int UID = 336413;
        int admin_uid = 123456;
        User admin = UserFactory.newUser(UID, "", "", 0, true);
        HashMap<Integer, User> list = new HashMap<>();
        list.put(admin_uid, admin);
        GroupChat chat1 = ChatFactory.getGroupChat(UID, "", "", admin, list);

        Assertions.assertEquals(admin, chat1.getAdmin(), "did not return correct admin");
    }

    @Test
    public void testGetMembers(){
        int UID = 336413;
        int admin_uid = 123456;
        User admin = UserFactory.newUser(UID, "", "", 0, true);
        HashMap<Integer, User> list = new HashMap<>();
        list.put(admin_uid, admin);
        GroupChat chat1 = ChatFactory.getGroupChat(UID, "", "", admin, list);
        for(User u : list.values()){
            Assertions.assertTrue(chat1.getMembers().contains(u), "did not correct members list");
        }

    }

    @Test
    public void testAddUser(){
        int UID = 336413;
        int admin_uid = 123456;
        User admin = UserFactory.newUser(UID, "", "", 0, true);
        HashMap<Integer, User> list = new HashMap<>();
        list.put(admin_uid, admin);
        GroupChat chat1 = ChatFactory.getGroupChat(UID, "", "", admin, list);

        User other = UserFactory.newUser(123457, "", "", 0, true);
        chat1.addMember(other);
        Assertions.assertTrue(chat1.getMembers().contains(admin) &&
                chat1.getMembers().contains(other) && chat1.getMembers().size() == 2);
    }

    @Test
    public void testRemoveUser(){
        int UID = 336413;
        int admin_uid = 123456;
        User admin = UserFactory.newUser(UID, "", "", 0, true);
        HashMap<Integer, User> list = new HashMap<>();
        list.put(admin_uid, admin);
        GroupChat chat1 = ChatFactory.getGroupChat(UID, "", "", admin, list);

        User other = UserFactory.newUser(123457, "", "", 0, true);
        chat1.addMember(other);
        chat1.deleteMember(other.getUid());
        Assertions.assertTrue((chat1.getMembers().contains(admin) &&
                !(chat1.getMembers().contains(other)) && chat1.getMembers().size() == 1),
                "did not properly remove user");
    }

    /**
     * ensures GroupChat.RemoveUser() cannot remove admin (fails silently).
     */
    @Test
    public void testRemoveUserRetainsAdmin(){
        int UID = 336413;
        int admin_uid = 123456;
        User admin = UserFactory.newUser(UID, "", "", 0, true);
        HashMap<Integer, User> list = new HashMap<>();
        list.put(admin_uid, admin);
        GroupChat chat1 = ChatFactory.getGroupChat(UID, "", "", admin, list);

        User other = UserFactory.newUser(123457,"name", "", 0, true);
        chat1.addMember(other);
        chat1.deleteMember(other.getUid());
        chat1.deleteMember(admin.getUid());
        Assertions.assertTrue((chat1.getMembers().contains(admin) &&
                        !(chat1.getMembers().contains(other)) && chat1.getMembers().size() == 1),
                "did not properly retain admin");
    }


}