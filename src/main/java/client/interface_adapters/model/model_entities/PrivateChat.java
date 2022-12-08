package client.interface_adapters.model.model_entities;

import java.util.ArrayList;
import java.util.List;

public class PrivateChat extends Chat
{
    private Self self;
    private Friend friend;
    public PrivateChat(int chatUid, ChatProfile profile, Self self, Friend friend , List<Message> messages){
        super(chatUid, profile, messages);
        this.self = self;
        this.friend = friend;
    }

    public int getFriendUid()
    {
        return friend.getUid();
    }
    @Override
    public String toString()
    {
        return "Name: " + getName() + "Description: " + getDescription() + "Members: " ;
    }

    @Override
    public List<Integer> getMembersUid() {
        List<Integer> toReturn = new ArrayList<>(2);
        toReturn.add(self.getUid());
        toReturn.add(friend.getUid());
        return toReturn;
    }
}
