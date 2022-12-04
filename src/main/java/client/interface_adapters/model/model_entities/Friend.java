package client.interface_adapters.model.model_entities;

import java.util.HashMap;

public class Friend extends User
{
    private int uid;

    public Friend(int uid, UserProfile userProfile)
    {
        super(uid, userProfile);
        this.uid = uid;
    }
}
