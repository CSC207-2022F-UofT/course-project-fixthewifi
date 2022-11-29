package usecases.create_gc;

import entities.User;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * Output data model for the interactor to pass into the CreateGCOutputAdapter.
 * @author Brenden McFarlane
 */
public class CreateGCOutputData {
    /**
     * The UID of the Admin of the newly made GroupChat.
     */
    private final int admin;
    /**
     * The UIDs of the users who are a part of the newly made GroupChat.
     */
    private final ArrayList<Integer> members;
    private final String peerID;
    private final int peerPort;


    public CreateGCOutputData(int admin, ArrayList<Integer> members, String peerID, int peerPort){
        this.admin = admin;
        this.members = members;
        this.peerID = peerID;
        this.peerPort = peerPort;
    }

    public int getAdmin(){return this.admin;}

    public ArrayList<Integer> getMembers(){return this.members;}

    public int getPeerPort() {return this.peerPort;}
    public String getPeerID() {return this.peerID;}
}
