package client.interface_adapters.model;

import client.interface_adapters.model.model_entities.Friend;
import client.interface_adapters.model.model_entities.Self;
import client.interface_adapters.model.model_entities.UserFactory;

public class Model
{
    private final Self self;
    public String pageState;
    public int friendRequester;

    public Model()
    {
        this.self = UserFactory.newSelf();
        pageState = "LOGIN_PAGE";
    }

    public void setSelfUid(int uid)
    {
        self.uid = uid;
    }

    public int getSelfUid() 
    {
        return self.uid;
    }

    public void storeChatMsg(int parseInt, int parseInt1, String s, String s1) {
    }

    public void addFriend(int uid, String name, String description, double rating, boolean online)
    {
        self.addFriend(uid, name, description, rating, online);
    }

    public void addChat(int uid, String name, String description, String[] messages)
    {
        self.addChat(uid, name, description, messages);
    }

    public String getDescription(int userUid)
    {
        if (userUid == getSelfUid())
        {
            return self.profile.getDescription();
        }
        return self.friendList.get(userUid).profile.getDescription();
    }

    public void setPageState(String state)
    {
        pageState = state;
    }

    public void setSelfStatus(boolean b) {
    }

    public void setSelfName(String s) {
    }

    public void setSelfDescription(String s) {
    }

    public void setRating(double parseDouble) {
    }

}

