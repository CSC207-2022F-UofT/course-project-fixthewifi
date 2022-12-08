package client.interface_adapters.model;

import client.interface_adapters.model.model_entities.*;

import java.util.HashMap;

public class Model implements ModelInterface
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

    public void addPrivateChat(int uid, String name, String description,int friendUid)
    {
        Friend friend = self.getFriend(friendUid);
        Chat chat = ChatFactory.getPrivateChat(uid, name, description, self, friend);
        self.addChat(chat);
    }

    public String getPageState() {
        return pageState;
    }
    public String getProfileInfo()
    {
            return self.profile.toString();
    }
    public void setSelfName(String name)
    {
        self.profile.setName(name);
    }
    public void setSelfDesc(String name)
    {
        self.profile.setDescription(name);
    }

    public void setSelfSetPic(String name)
    {
     //   self.profile.setProfilePic(name);
    }

    public void setPageState(String state)
    {
        pageState = state;
    }

    public void setSelfStatus(boolean b)
    {
    }

    public int findPrivateChat(int friendUid)
    {
        for (int chatUid : self.getChatUidList())

    public double getRating(int userUid)
    {
        if (userUid == getSelfUid())
        {
            return self.profile.getRating();
        }
        return self.friendList.get(userUid).userProfile.getRating();
    }

    public void setRating(String rating)
    {
        self.profile.setRating(Double.parseDouble(rating));
    }


    public int getRequester(int uid) throws userNotFoundException {
        if (friendRequester.containsKey(uid))
        {
            Chat chat = self.getChat(chatUid);
            if (chat instanceof PrivateChat)
                if (((PrivateChat) chat).getFriendUid() == friendUid)
                {
                    return chat.getUid();
                }
        }
        return -1;
    }

    public void setSelfName(String s) {
    }

    public void setSelfDescription(String s) {
    }

    public void setRating(double parseDouble) {
    }

    public void addRequester(int uid, String name)
    {
        friendRequests.put(uid, name);
    }

    @Override
    public String toString() {
        return self.toString();
    }

    public void deleteFriend(int friendUid)
    {
        self.deleteFriend(friendUid);
    }

    public void deletePrivateChat(int friendUid)
    {
        for (int uid : self.getChatUidList())
        {
            Chat chat = self.getChat(uid);
            if ( chat instanceof PrivateChat)
                if (((PrivateChat) chat).getFriendUid() == friendUid)
                {
                    self.deleteChat(chat.getUid());
                }
        }
    }
}

