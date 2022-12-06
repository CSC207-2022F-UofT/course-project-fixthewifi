package client.interface_adapters.model.model_entities;

import java.util.ArrayList;
import java.util.HashMap;

public class ChatFactory
{
    public static Chat getPrivateChat(int chatUid, String name, String description, User user1, User user2)
    {
        ChatProfile profile = new ChatProfile(name, description);
        HashMap<Integer, User> members = new HashMap<>();
        members.put(user1.getUid(), user1);
        members.put(user2.getUid(), user2);
        ArrayList<Message> messages = new ArrayList<>();
        return new GroupChat(chatUid, profile, null, members, messages);
    }
}
