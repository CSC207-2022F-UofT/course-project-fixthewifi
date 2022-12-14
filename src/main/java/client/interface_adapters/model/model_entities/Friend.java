package client.interface_adapters.model.model_entities;

import java.util.HashMap;

public class Friend extends User
{
    public Friend(int uid, UserProfile userProfile)
    {
        super(uid, userProfile);
    }

    @Override
    public String toString() {
        return "uid: " + getUid() + "\n" + profile.toString();
    }
}