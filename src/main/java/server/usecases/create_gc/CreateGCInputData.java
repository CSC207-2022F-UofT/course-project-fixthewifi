package server.usecases.create_gc;

import java.util.ArrayList;

/**
 * The input data required for the CreateGCInteractor to create a new GroupChat.
 * @author Brenden McFarlane
 */
public class CreateGCInputData {
    private final int admin_uid;
    private final ArrayList<Integer> members_uids;


    public CreateGCInputData(int admin_uid, ArrayList<Integer> members_uids){
        this.admin_uid = admin_uid;
        this.members_uids = members_uids;
    }

    public int getAdmin_uid(){return this.admin_uid;}

    public ArrayList<Integer> getMembers_uids(){return this.members_uids;}

}
