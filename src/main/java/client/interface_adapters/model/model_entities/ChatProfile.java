package client.interface_adapters.model.model_entities;

/**
 * This class represents the profile of a given GroupChat.
 * @author Brenden McFarlane
 */
public class ChatProfile extends Profile
{
    public ChatProfile(String name, String description)
    {
        super(name, description);
    }

    @Override
    public String toString() {
        return "Name: " + getName() + "\n" +
                "Description: " + getDescription() + "\n";
    }
}


