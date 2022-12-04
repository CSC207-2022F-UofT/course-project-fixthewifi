package client.interface_adapters.model.model_entities;

import java.util.ArrayList;
import java.util.HashMap;

public class ChatFactory
{
    public static Chat getChat(int chatUid, String name, String description)
    {
        ChatProfile profile = new ChatProfile(name, description);
        HashMap<Integer, User> members = new HashMap<>();
        ArrayList<Message> messages = new ArrayList<>();
        return new GroupChat(chatUid, profile, null, members, messages);
    }
}
