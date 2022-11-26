package client.entities;

import server.entities.Chat;
import server.entities.Message;

import java.util.ArrayList;
import java.util.List;

public class PrivateChat implements Chat
{
    private final int uid;
    private final Self self;
    private final Friend friend;
    private final List<server.entities.Message> messages;

    public PrivateChat(int uid, Self self, Friend friend)
    {
        this.uid = uid;
        this.self = self;
        this.friend = friend;
        this.messages = new ArrayList<server.entities.Message>();
    }

    @Override
    public void addMsg(Message msg)
    {
        messages.add(msg);
    }

    @Override
    public void deleteMsg()
    {

    }

    @Override
    public int getUid() {
        return uid;
    }
}
