package client.interface_adapters.model.model_entities;

public class Friend implements User
{
    public UserProfile profile;

    @Override
    public int getUid() {
        return 0;
    }
}
