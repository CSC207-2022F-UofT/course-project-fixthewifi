package client.usecases.create_gc;

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
    /**
     * Initial request time for making the newly made GroupChat.
     */
    private final LocalDateTime time;

    public CreateGCOutputData(int admin, ArrayList<Integer> members, LocalDateTime time){
        this.admin = admin;
        this.members = members;
        this.time = time;
    }

    /**
     * @return the admin of the OutputData.
     */
    public int getAdmin(){return this.admin;}

    /**
     * @return the members of the OutputData.
     */
    public ArrayList<Integer> getMembers(){return this.members;}

    /**
     * @return the request time of the OutputData.
     */
    public LocalDateTime getTime(){return this.time;}
}
