package client.entities;

import server.entities.Chat;
import server.entities.CommonUser;

public interface User
{
    public int getUid();

    public Chat getChatByChatUid(int uid);

    public CommonUser getFriendByUid(int uid);

}
