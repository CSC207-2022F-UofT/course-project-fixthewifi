package client.interface_adapters.model.model_entities;

public abstract class User
{
    public int uid;
    public final UserProfile profile;

    public User(int uid, UserProfile profile)
    {
        this.uid = uid;
        this.profile = profile;
    }
}
