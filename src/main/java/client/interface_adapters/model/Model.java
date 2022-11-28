package client.interface_adapters.model;

import client.frameworks_and_drivers.view.console_view.ConsoleView;
import client.interface_adapters.model.model_entities.Self;

public class Model
{
    private final Self self;
    public String pageState;
    public int friendRequester;

    public Model()
    {
        this.self = new Self();
        pageState = "LOGIN_PAGE";
    }

    public void setSelfUid(int uid)
    {
        self.setUid(uid);
    }

    public int getSelfUid() 
    {
        return self.getUid();
    }

    public void storeChatMsg(int parseInt, int parseInt1, String s, String s1) {
    }


    public String getDescription(int userUid)
    {
        if (userUid == getSelfUid())
        {
            return self.userProfile.getDescription();
        }
        return self.friendList.get(userUid).profile.getDescription();
    }

    public void setPageState(String state)
    {
        pageState = state;
    }

    public void setSelfStatus(boolean b) {
    }
}

