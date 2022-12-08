package client.interface_adapters.model;

import client.interface_adapters.model.model_entities.*;

import java.util.HashMap;
import java.util.List;

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

    public void addPrivateChat(int uid, String name, String description,int friendUid)
    {
        Friend friend = self.getFriend(friendUid);
        Chat chat = ChatFactory.getPrivateChat(uid, name, description, self, friend);
        self.addChat(chat);
    }

    public void addMsg(int msgUid, int senderUid, String content, String time, int chatUid)
    {
        self.getChat(chatUid).addMsg(MessageFactory.newMessage(msgUid, senderUid, content, time));
    }

    public void addGroupChat(int uid, String name, String description, int adminUid, List<Integer> membersUid)
    {
        User admin;
        if (adminUid == getSelfUid())
        {
            admin = self;
        }
        else if (self.getFriendUidList().contains(adminUid))
        {
            admin = self.getFriend(adminUid);
        }
        else
        {
            admin = null;
        }
        HashMap<Integer, User> memberList = new HashMap<>();
        for (Integer memberUid : membersUid)
        {
            if (memberUid == getSelfUid())
            {
                memberList.put(memberUid, self);
            }
            else if (self.getFriendUidList().contains(memberUid))
            {
                memberList.put(memberUid, self.getFriend(memberUid));
            }
        }
        Chat chat = ChatFactory.getGroupChat(uid, name, description, admin, memberList);
        self.addChat(chat);
    }

    public String getPageState() {
        return pageState;
    }

    public void setPageState(String state)
    {
        pageState = state;
    }

    public int findPrivateChat(int friendUid)
    {
        for (int chatUid : self.getChatUidList())
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

    public void setSelfName(String s)
    {
        self.setName(s);
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
    public String toString()
    {
        return self.showEverything();
    }

    public void deleteFriend(int friendUid)
    {
        self.deleteFriend(friendUid);
    }

    public void setSelfStatus(boolean status)
    {
        self.setStatus(status);
    }

    public void addUserToChat(int userUid, String name, String description, double avgRating, boolean online, int chatUid, int adminUid)
    {
        if (self.getChat(chatUid).getMembersUid().contains(userUid))
        {
            return;
        }
        User user = UserFactory.newUser(userUid, name, description, avgRating, online);
        if (userUid == adminUid)
        {
            ((GroupChat) self.getChat(chatUid)).setAdmin(user);
        }
        ((GroupChat) self.getChat(chatUid)).addMember(user);
    }

    public double getRating(int userUid)
    {
        if (userUid == getSelfUid())
        {
            return self.getRating();
        }
        return self.getFriend(userUid).getRating();
    }

    public void setRating(String rating)
    {
        self.setRating(Double.parseDouble(rating));
    }


    public int getRequester(int uid) throws userNotFoundException {
        if (friendRequests.containsKey(uid))
        {
            return uid;
        }
        else
        {
            throw new userNotFoundException("The uid entered is not found.");
        }
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

