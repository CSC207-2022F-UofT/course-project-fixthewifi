package server.usecases.retrieve_friendslist;

import java.util.ArrayList;

/**
 * represenation invariants:
 * -for every UIDs[i], the corresponding username
 * of that user is username[i].
 * -the username of another user is in RetrieveFriendsListOutputData.usernames
 * iff that user is in their friends list
 * -the UID of another user is in RetrieveFriendsListOutputData.UIDs
 * iff that user is in their friends list
 */
public class RetrieveFriendsListOutputData {
    /**
     * the UID of the user who is making the GroupChat
     */
    private int requester;
    /**
     * the List of UIDs and usernames of users, connected by
     * server.frameworks_and_drivers.Constants.SPR .
     */
    private ArrayList<String> users;

    private String peerID;
    private int peer_port;

    public RetrieveFriendsListOutputData(int requester, ArrayList<String> users,
                                         int peer_port, String peerID){
        this.requester = requester;
        this.users = users;
        this.peer_port = peer_port;
        this.peerID = peerID;
    }

    public void setRequester(int requester) {
        this.requester = requester;
    }

    public int getRequester() {
        return this.requester;
    }

    public void setusers(ArrayList<String> users) {
        this.users = users;
    }

    public ArrayList<String> getUsers() {
        return this.users;
    }



    public int getPeer_port() {return this.peer_port;}
    public String getPeerID() { return this.peerID;}
}
