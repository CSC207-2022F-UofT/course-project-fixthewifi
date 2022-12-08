package client.interface_adapters.model;

import client.interface_adapters.model.model_entities.Chat;
import client.interface_adapters.model.model_entities.PrivateChat;

import java.util.List;

public interface ModelInterface {
    public int getSelfUid();
    public void setSelfUid(int uid);
    public String getDescription(int userUid) throws UserNotFoundException;
    public void addFriend(int uid, String name, String description, double rating, boolean online);
    public void addPrivateChat(int uid, String name, String description,int friendUid);
    public String getPageState();
    public void setPageState(String state);
    public int findPrivateChat(int friendUid);
    public void setSelfName(String s);
    public void setSelfDescription(String s);

    public void setRating(double parseDouble);

    public void addRequester(int uid, String name);

    @Override
    public String toString();


    public void deletePrivateChat(int friendUid);

    void setSelfStatus(boolean b);

    void addUserToChat(int parseInt, String datum, String datum1, double parseDouble, boolean online, int parseInt1, int parseInt2);

    void addMsg(int i, int parseInt, String s, String s1, int parseInt1);

    void addGroupChat(int parseInt, String datum, String datum1, int parseInt1, List<Integer> membersUid);

    void notifyView(String data);

    public String showSelfProfile();

    public String showChats();

    public String showFriends();

    void deleteFriend(int friendUid);

}
