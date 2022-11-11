package entities;

public interface User
{
    public int getUid();

    public Chat getChatByChatUid(int uid);

    public CommonUser getFriendByUid(int uid);
    
    public boolean checkUserExistsByUid(int uid);
}
