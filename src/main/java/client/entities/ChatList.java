package client.entities;

import server.entities.Chat;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ChatList
{
    private final List<server.entities.Chat> chats;

    public ChatList()
    {
        this.chats = new ArrayList<server.entities.Chat>();
    }


    public ChatList(List<server.entities.Chat> chats)
    {
        this.chats = chats;
    }

    public server.entities.Chat getChatByChatUid(int uid)
    {
        server.entities.Chat toReturn = null;
        for (server.entities.Chat chat : chats)
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
