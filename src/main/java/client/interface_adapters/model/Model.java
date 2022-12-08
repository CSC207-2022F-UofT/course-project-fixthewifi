package client.interface_adapters.model;

import client.frameworks_and_drivers.view.console_view.ModelObserver;
import client.interface_adapters.model.model_entities.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Model implements ModelInterface
{
    private final Self self;
    private String pageState;
    private final HashMap<Integer, String> friendRequests;
    private final List<ModelObserver> obList;
    public Model()
    {
        this.self = UserFactory.newSelf();
        pageState = "LOGIN_PAGE";
        friendRequests = new HashMap<>();
        obList = new ArrayList<>();
    }

    public void addObserver(ModelObserver ob)
    {
        obList.add(ob);
    }

    @Override
    public void notifyView(String data)
    {
        for (ModelObserver ob : obList)
        {
            ob.update(data);
        }
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


    public String getPageState() {
        return pageState;
    }

    public void setPageState(String state)
    {
        pageState = state;
    }


    public String getDescription(int userUid) throws UserNotFoundException {
        if (userUid == self.getUid())
        {
            return self.getDescription();
        }
        return self.getFriend(userUid).getDescription();
    }

    public String getFriendName(int uid)
    {
        return "";
    }


    public void addFriend(int uid, String name, String description, double rating, boolean online)
    {
        Friend friend = UserFactory.newFriend(uid, name, description, rating, online);
        self.addFriend(friend);
    }

    public void addPrivateChat(int uid, String name, String description,int friendUid)
    {
        Friend friend = null;
        try {
            friend = self.getFriend(friendUid);
        } catch (UserNotFoundException e) {
            System.out.println("Private chat cannot be created because friend is not found.");
        }
        Chat chat = ChatFactory.getPrivateChat(uid, name, description, self, friend);
        self.addChat(chat);
    }

    public void addMsg(int msgUid, int senderUid, String content, String time, int chatUid)
    {
        try {
            self.getChat(chatUid).addMsg(MessageFactory.newMessage(msgUid, senderUid, content, time));
        } catch (ChatNotFoundException e) {
            System.out.println("Cannot add message because chat is not found.");
        }
    }

    public void addGroupChat(int uid, String name, String description, int adminUid, List<Integer> membersUid)
    {
        User admin = null;
        if (adminUid == getSelfUid())
        {
            admin = self;
        }
        else if (self.getFriendUidList().contains(adminUid))
        {
            try {
                admin = self.getFriend(adminUid);
            } catch (UserNotFoundException e) {
                System.out.println("Group chat cannot be created because admin is not found.");
            }
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
                try {
                    memberList.put(memberUid, self.getFriend(memberUid));
                } catch (UserNotFoundException e) {
                    System.out.println("Group chat cannot be created because member is not found.");
                }
            }
        }
        Chat chat = ChatFactory.getGroupChat(uid, name, description, admin, memberList);
        self.addChat(chat);
    }

    public int findPrivateChat(int friendUid)
    {
        for (int chatUid : self.getChatUidList())
        {
            Chat chat = null;
            try {
                chat = self.getChat(chatUid);
            } catch (ChatNotFoundException e) {
                System.out.println("What, how do you even trigger this exception in this method??");
            }
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

    public void setSelfDescription(String s)
    {
        self.setDescription(s);
    }

    public void setRating(double parseDouble) {
        self.setRating(parseDouble);
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

    public String showSelfProfile()
    {
        return self.toString();
    }

    public String showChats()
    {
        return self.showChats();
    }

    public String showChat(int chatUid) throws ChatNotFoundException {
        return self.getChat(chatUid).toString();
    }

    public String showFriends()
    {
        return self.showFriends();
    }

    public void deleteFriend(int friendUid)
    {
        try {
            self.deleteFriend(friendUid);
        } catch (UserNotFoundException e) {
            System.out.println("Cannot delete friend because friend cannot be found.");
        }
    }

    public void setSelfStatus(boolean status)
    {
        self.setStatus(status);
    }

    public void addUserToChat(int userUid, String name, String description, double avgRating, boolean online, int chatUid, int adminUid)
    {
        try
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
        catch (ChatNotFoundException e)
        {
            System.out.println(e);
        }

    }

    public double getRating(int userUid) throws UserNotFoundException {
        if (userUid == getSelfUid())
        {
            return self.getRating();
        }
        return self.getFriend(userUid).getRating();
    }

    public int getRequester(int uid) throws UserNotFoundException {
        if (friendRequests.containsKey(uid))
        {
            return uid;
        }
        else
        {
            throw new UserNotFoundException("The uid entered is not found.");
        }
    }


    public void deletePrivateChat(int friendUid)
    {
        for (int uid : self.getChatUidList())
        {
            Chat chat = null;
            try {
                chat = self.getChat(uid);
            } catch (ChatNotFoundException e) {
                throw new RuntimeException(e);
            }
            if ( chat instanceof PrivateChat)
                if (((PrivateChat) chat).getFriendUid() == friendUid)
                {
                    self.deleteChat(chat.getUid());
                }
        }
    }


}

