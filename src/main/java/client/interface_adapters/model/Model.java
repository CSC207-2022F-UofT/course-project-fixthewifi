package client.interface_adapters.model;

import client.frameworks_and_drivers.view.console_view.ConsoleView;
import client.interface_adapters.model.model_entities.Self;

public class Model
{
    private final Self self;
    private final ConsoleView view;
    public String pageState;

    public Model(ConsoleView view)
    {
        this.view = view;
        this.self = new Self();
    }

    public int getSelfUid() 
    {
        return self.getUid();
    }

    public void storeChatMsg(int parseInt, int parseInt1, String s, String s1) {
    }
}

