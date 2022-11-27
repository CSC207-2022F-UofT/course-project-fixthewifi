package client.interface_adapters.model.model_entities;

public class Friend implements User
{
    private UserProfile profile;

    @Override
    public int getUid() {
        return 0;
    }
}
