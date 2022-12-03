package client.interface_adapters.model;

import client.interface_adapters.model.model_entities.Self;
import client.interface_adapters.model.model_entities.UserFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Model
{
    private final Self self;
    private String pageState;
    private final HashMap<Integer, String> requesterList;

    public Model()
    {
        this.self = UserFactory.newSelf();
        pageState = "LOGIN_PAGE";
        requesterList = new HashMap<Integer, String>();

    }

    public void addRequester(int uid, String name)
    {
        requesterList.put(uid, name);
    }

    public String getPageState()
    {
        return pageState;
    }

    public void setSelfUid(int uid)
    {
        self.uid = uid;
    }

    public int getSelfUid() 
    {
        return self.uid;
    }

    public void storeChatMsg(int parseInt, int parseInt1, String s, String s1)
    {
    }


    public String getDescription(int userUid)
    {
        if (userUid == getSelfUid())
        {
            return self.profile.getDescription();
        }
        return self.friendList.get(userUid).userProfile.getDescription();
    }

    public void setPageState(String state)
    {
        pageState = state;
    }

    public void setSelfStatus(boolean b)
    {
        self.profile.setOnline(b);
    }

    public int getRequester(int uid) throws userNotFoundException {
        if (requesterList.containsKey(uid))
        {
            return uid;
        }
        else
        {
            throw new userNotFoundException("The uid entered is not found.");
        }
    }
}
