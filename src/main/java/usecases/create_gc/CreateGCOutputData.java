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
     * Admin of the newly made GroupChat.
     */
    private final User admin;
    /**
     * the users who are a part of the newly made GroupChat.
     */
    private final ArrayList<User> members;
    /**
     * Initial request time for making the newly made GroupChat.
     */
    private final LocalDateTime time;

    public CreateGCOutputData(User admin, ArrayList<User> members, LocalDateTime time){
        this.admin = admin;
        this.members = members;
        this.time = time;
    }

    /**
     * @return the admin of the OutputData.
     */
    public User getAdmin(){return this.admin;}

    /**
     * @return the members of the OutputData.
     */
    public ArrayList<User> getMembers(){return this.members;}

    /**
     * @return the request time of the OutputData.
     */
    public LocalDateTime getTime(){return this.time;}
}
