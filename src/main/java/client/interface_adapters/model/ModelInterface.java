package client.interface_adapters.model;

import client.interface_adapters.model.model_entities.Chat;
import client.interface_adapters.model.model_entities.PrivateChat;

public interface ModelInterface {
    public int getSelfUid();
    public void setSelfUid(int uid);
    public String getDescription(int userUid);
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

    public void deleteFriend(int friendUid);

    public void deletePrivateChat(int friendUid);
}
