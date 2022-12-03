package client.interface_adapters.model.model_entities;

import server.entities.Chat;
import server.entities.GroupProfile;
import server.entities.Message;
import server.entities.User;

import java.util.ArrayList;
import java.util.List;

/**
 * A class representing a Groupchat.
 * @author Brenden McFarlane
 */
public class GroupChat implements Chat {
    /**
     * Representation invariants:
     * admin is always in members.
     */
    private final int chatUid;
    private final GroupProfile profile;
    private final User admin;
    private final List<User> members;
    private final List<Message> messages;




    public GroupChat(int chatUid, GroupProfile profile, User admin, List<User> members, List<Message> messages){
        this.chatUid = chatUid;
        this.profile = profile;
        this.admin = admin;
        this.members = members;
        this.messages = messages;
    }

    @Override
    public int getUid() {
        return this.chatUid;
    }

    public List<Message> getMessages(){
        return this.messages;
    }

    @Override
    public void addMsg(Message msg) {

    }

    @Override
    public void deleteMsg() {

    }

    public server.entities.User getAdmin() {
        return this.admin;
    }


    public List<User> getMembers(){
        return this.members;
    }

    public void addUser(server.entities.User friend){
        this.members.add(friend);
    }

    public void removeUser(User member){
        if(member != this.admin) {
            this.members.remove(member);
        }

    }



}
