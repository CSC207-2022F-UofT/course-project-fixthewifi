package server.entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ChatFactory
{
    public static GroupChat getGroupChat(int chatUid, String name, String description, User admin, HashMap<Integer, User> members)
    {
        ChatProfile profile = new ChatProfile(name, description);
        ArrayList<Message> messages = new ArrayList<>();
        return  new GroupChat(chatUid, profile, admin, members, messages);
    }
}


