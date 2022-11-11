package entities;

public interface User
{
    public int getUid();

    public int getStatus();

    public String getStringStatus();

    public Chat getChatByChatUid(int uid);

    public CommonUser getFriendByUid(int uid);
}
