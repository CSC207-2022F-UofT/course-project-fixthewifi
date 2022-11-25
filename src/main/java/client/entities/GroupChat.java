package client.entities;

import server.entities.Chat;
import server.entities.GroupProfile;
import server.entities.Message;
import server.entities.User;

import java.util.ArrayList;

/**
 * A class representing a Groupchat.
 * @author Brenden McFarlane
 */
public class GroupChat implements Chat {
    /**
     * Representation invariants:
     * admin is always in members.
     */
    private final int UID;
    private ArrayList<server.entities.Message> messages;
    private final server.entities.User admin;
    private ArrayList<server.entities.User> members;

    private final GroupProfile profile;


    public GroupChat(int UID, User admin, ArrayList<User> members, GroupProfile profile){
        this.UID = UID;
        this.profile = profile;
        this.messages = new ArrayList<server.entities.Message>();
        this.admin = admin;
        this.members = members;

    }
    @Override
    public int getUid() {
        return this.UID;
    }

    public ArrayList<server.entities.Message> getMessages(){
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


    public ArrayList<server.entities.User> getMembers(){
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
