package usecases.create_gc;
import entities.*;

import java.time.LocalDateTime;
import java.util.ArrayList;

/**
 * The input data required for the CreateGCInteractor to create a new GroupChat.
 * @author Brenden McFarlane
 */
public class CreateGCInputData {
    /**
     * User who will be the admin of the new GroupChat.
     */
    private final User admin;
    /**
     * A list of users who will be a part of the new GroupChat
     */
    private ArrayList<User> members;
    /**
     * Time of the request to make a new GroupChat
     */
    private final LocalDateTime time;

    public CreateGCInputData(User admin, ArrayList<User> members, LocalDateTime time){
        this.admin = admin;
        this.members = members;
        this.time = time;
    }

    /**
     * @return the admin of the InputData
     */
    public User getAdmin(){return this.admin;}
    /**
     * @return the members of the InputData
     */
    public ArrayList<User> getMembers(){return this.members;}
    /**
     * @return the request time of the InputData
     */
    public LocalDateTime getTime(){return this.time;}
}
