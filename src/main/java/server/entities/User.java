package server.entities;

public interface User
{
    public int getUid();

    public Chat getChatByChatUid(int uid);

    public CommonUser getFriendByUid(int uid);

}
