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


    public CreateGCOutputData(int admin, ArrayList<Integer> members){
        this.admin = admin;
        this.members = members;
    }

    /**
     * @return the admin of the OutputData.
     */
    public int getAdmin(){return this.admin;}

    /**
     * @return the members of the OutputData.
     */
    public ArrayList<Integer> getMembers(){return this.members;}

}
