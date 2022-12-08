package test_entities;
import server.entities.*;
import server.entities.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.HashMap;

public class TestGroupChat{
//    @Test
//    public void testGetUID(){
//        int UID = 336413;
//        User admin = UserFactory.newUser(UID, "", "", 0, true);
//        HashMap<Integer, User> list = new HashMap<>();
//        list.put(336413, admin);
//        GroupChat chat1 = ChatFactory.getGroupChat(123, "", "", admin, list);
//
//        Assertions.assertEquals(UID,chat1.getUid(), "did not return correct UID");
//    }

    @Test
    public void testGetMessages(){
//        int UID = 336413;
//        User admin = new User(123456,"name", 0);
//        ArrayList<User> list = new ArrayList<User>();
//        list.add(admin);
//        GroupChat chat1 = new GroupChat(UID, admin, list);
//
//        Assertions.assertTrue(chat1.getMessages().isEmpty());
    }

    @Test
    public void testAddMsg(){

    }

    @Test
    public void testDeleteMsg(){

    }

    @Test
    public void testGetAdmin(){
//        int UID = 336413;
//        User admin = new User(123456,"name", 0);
//        ArrayList<User> list = new ArrayList<User>();
//        list.add(admin);
//        GroupChat chat1 = new GroupChat(UID, admin, list);
//
//        Assertions.assertEquals(admin, chat1.getAdmin(), "did not return correct admin");
    }

    @Test
    public void testGetMembers(){
//        int UID = 336413;
//        User admin = new User(123456,"name", 0);
//        ArrayList<User> list = new ArrayList<User>();
//        list.add(admin);
//        GroupChat chat1 = new GroupChat(UID, admin, list);
//
//        Assertions.assertEquals(list, chat1.getMembers(), "did not correct members list");
    }

    @Test
    public void testAddUser(){
//        int UID = 336413;
//        User admin = new User(123456,"name", 0);
//        ArrayList<User> list = new ArrayList<User>();
//        list.add(admin);
//        GroupChat chat1 = new GroupChat(UID, admin, list);
//
//        User other = new User(123457,"name", 0);
//        chat1.addUser(other);
//        Assertions.assertTrue(chat1.getMembers().contains(admin) &&
//                chat1.getMembers().contains(other) && chat1.getMembers().size() == 2);
    }

    @Test
    public void testRemoveUser(){
//        int UID = 336413;
//        User admin = new User(123456,"name", 0);
//        ArrayList<User> list = new ArrayList<User>();
//        list.add(admin);
//        GroupChat chat1 = new GroupChat(UID, admin, list);
//
//        User other = new User(123457,"name", 0);
//        chat1.addUser(other);
//        chat1.removeUser(other);
//        Assertions.assertTrue((chat1.getMembers().contains(admin) &&
//                !(chat1.getMembers().contains(other)) && chat1.getMembers().size() == 1),
//                "did not properly remove user");
    }

    /**
     * ensures GroupChat.RemoveUser() cannot remove admin (fails silently).
     */
    @Test
    public void testRemoveUserRetainsAdmin(){
//        int UID = 336413;
//        User admin = new User(123456,"name", 0);
//        ArrayList<User> list = new ArrayList<User>();
//        list.add(admin);
//        GroupChat chat1 = new GroupChat(UID, admin, list);
//
//        User other = new User(123457,"name", 0);
//        chat1.addUser(other);
//        chat1.removeUser(other);
//        chat1.removeUser(admin);
//        Assertions.assertTrue((chat1.getMembers().contains(admin) &&
//                        !(chat1.getMembers().contains(other)) && chat1.getMembers().size() == 1),
//                "did not properly retain admin");
    }


}