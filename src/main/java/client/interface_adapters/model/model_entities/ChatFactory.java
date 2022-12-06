package client.interface_adapters.model.model_entities;

import java.util.ArrayList;
import java.util.HashMap;

public class ChatFactory
{
    public static PrivateChat getPrivateChat(int chatUid, String name, String description, User user1, User user2)
    {
        ChatProfile profile = new ChatProfile(name, description);
        ArrayList<Message> messages = new ArrayList<>();
        return new PrivateChat(chatUid, profile, user1, user2, messages);
    }
}
