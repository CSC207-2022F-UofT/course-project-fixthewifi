package server.entities;

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
    private ArrayList<Message> messages;
    private final User admin;
    private ArrayList<User> members;


    public GroupChat(int UID, User admin, ArrayList<User> members){
        this.UID = UID;
        this.messages = new ArrayList<Message>();
        this.admin = admin;
        this.members = members;

    }
    @Override
    public int getUid() {
        return this.UID;
    }

    public ArrayList<Message> getMessages(){
        return this.messages;
    }

    @Override
    public void addMsg(Message msg) {

    }

    @Override
    public void deleteMsg() {

    }

    public User getAdmin() {
        return this.admin;
    }


    public ArrayList<User> getMembers(){
        return this.members;
    }

    public void addUser(User friend){
        this.members.add(friend);
    }

    public void removeUser(User member){
        if(member != this.admin) {
            this.members.remove(member);
        }

    }



}
