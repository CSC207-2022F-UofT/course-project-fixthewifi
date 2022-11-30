package server.usecases.create_gc;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * The input data required for the CreateGCInteractor to create a new GroupChat.
 * @author Brenden McFarlane
 */
public class CreateGCInputData {
    /**
     * The UID of the user who will be the admin of the new GroupChat.
     */
    private final int admin;
    /**
     * A list of the UIDs of the users who will be a part of the new GroupChat
     */
    private final ArrayList<Integer> members;


    public CreateGCInputData(int admin, ArrayList<Integer> members){
        this.admin = admin;
        this.members = members;
    }

    /**
     * @return the admin of the InputData
     */
    public int getAdmin(){return this.admin;}
    /**
     * @return the members of the InputData
     */
    public ArrayList<Integer> getMembers(){return this.members;}

}
