package client.interface_adapters.model.model_entities;

import java.util.List;

public class PrivateChat extends Chat
{
    private User user1;
    private User user2;
    public PrivateChat(int chatUid, ChatProfile profile, User user1, User user2 , List<Message> messages){
        super(chatUid, profile, messages);
        this.user1 = user1;
        this.user2 = user2;
    }

    @Override
    public String toString()
    {
        return "Name: " + getName() + "Description: " + getDescription() + "Members: " ;
    }
}
