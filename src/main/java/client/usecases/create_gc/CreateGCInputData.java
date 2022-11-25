package client.usecases.create_gc;
import server.entities.*;

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
    /**
     * Time of the request to make a new GroupChat
     */
    private final LocalDateTime time;

    public CreateGCInputData(int admin, ArrayList<Integer> members, LocalDateTime time){
        this.admin = admin;
        this.members = members;
        this.time = time;
    }

    /**
     * @return the admin of the InputData
     */
    public int getAdmin(){return this.admin;}
    /**
     * @return the members of the InputData
     */
    public ArrayList<Integer> getMembers(){return this.members;}
    /**
     * @return the request time of the InputData
     */
    public LocalDateTime getTime(){return this.time;}
}
