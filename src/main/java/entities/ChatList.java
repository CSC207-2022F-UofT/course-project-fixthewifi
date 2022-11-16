package entities;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ChatList
{
    private final List<Chat> chats;

    public ChatList()
    {
        this.chats = new ArrayList<Chat>();
    }


    public ChatList(List<Chat> chats)
    {
        this.chats = chats;
    }

    public Chat getChatByChatUid(int uid)
    {
        Chat toReturn = null;
        for (Chat chat : chats)
        {
            if (chat.getUid() == uid)
            {
                toReturn = chat;
            }
        }

        if (toReturn != null)
        {
            return toReturn;
        }
        else
        {
            throw new NoSuchElementException("Chat not found.");
        }
    }

    public void addChat(Chat chat)
    {
        chats.add(chat);
    }
}
