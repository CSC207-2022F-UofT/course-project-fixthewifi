package client.entities;

import server.entities.Message;

public interface Chat
{
    public void addMsg(Message msg);
    public void deleteMsg();

    public int getUid();
}
