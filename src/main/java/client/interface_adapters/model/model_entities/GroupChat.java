package client.interface_adapters.model.model_entities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * A class representing a Groupchat.
 * @author Brenden McFarlane
 */
public class GroupChat extends Chat {
    /**
     * Representation invariants:
     * admin is always in members.
     */

    private User admin;
    private final HashMap<Integer, User> members;


    public GroupChat(int chatUid, ChatProfile profile, User admin, HashMap<Integer, User> members, List<Message> messages){
        super(chatUid, profile, messages);
        this.admin = admin;
        this.members = members;
    }

    public User getAdmin() {
        return this.admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    public void addMember(User user){
        members.put(user.getUid(), user);
    }

    public User getMember(int userUid)
    {
        return members.get(userUid);
    }
    public void deleteMember(int userUid)
    {
        members.remove(userUid);
    }

    @Override
    public String toString() {
        return "lol what";
    }
}
