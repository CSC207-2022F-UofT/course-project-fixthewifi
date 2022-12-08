package client.interface_adapters.model.model_entities;

public abstract class User
{
    private int uid;
    private final UserProfile profile;

    public User(int uid, UserProfile profile)
    {
        this.uid = uid;
        this.profile = profile;
    }

<
    public double getRating()
    {
        return profile.getRating();
    }

