package client.interface_adapters.model;

import client.interface_adapters.model.model_entities.*;

import java.util.HashMap;

public class Model
{
    private final Self self;
    private String pageState;
    private final HashMap<Integer, String> friendRequests;

    public Model()
    {
        this.self = UserFactory.newSelf();
        pageState = "LOGIN_PAGE";
        friendRequests = new HashMap<>();
    }

    //TODO: If you want to store/get data into the model, create the corresponding setter/getter method
    // by using the provided methods inside <self>.

    public int getSelfUid()
    {
        return self.getUid();
    }
    public void setSelfUid(int uid)
    {
        self.setUid(uid);
    }

    public String getDescription(int userUid)
    {
        if (userUid == self.getUid())
        {
            return self.getDescription();
        }
        return self.getFriend(userUid).getDescription();
    }

    public void addFriend(int uid, String name, String description, double rating, boolean online)
    {
        Friend friend = UserFactory.newFriend(uid, name, description, rating, online);
        self.addFriend(friend);
    }

    public void addChat(int uid, String name, String description)
    {
        Chat chat = ChatFactory.getChat(uid, name, description);
        self.addChat(chat);
    }

    public String getPageState() {
        return pageState;
    }

    public void setPageState(String state)
    {
        pageState = state;
    }

    public void setSelfStatus(boolean b)
    {

    }

    public void setSelfName(String s) {
    }

    public void setSelfDescription(String s) {
    }

    public void setRating(double parseDouble) {
    }

}

