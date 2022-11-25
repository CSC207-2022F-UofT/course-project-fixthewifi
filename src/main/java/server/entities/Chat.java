package server.entities;

public interface Chat
{
    public void addMsg(Message msg);
    public void deleteMsg();

    public int getUid();
}
