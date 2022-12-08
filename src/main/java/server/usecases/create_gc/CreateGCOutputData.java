package server.usecases.create_gc;

import java.util.ArrayList;

/**
 * Output data model for the interactor to pass into the CreateGCOutputAdapter.
 * @author Brenden McFarlane
 */
public class CreateGCOutputData {
    private final int chat_uid;
    private final int admin_uid;
    private final String user_peerID; // user's ip address
    private final int user_peerPort;
    private final ArrayList<Integer> members_Uids;



    public CreateGCOutputData(int chat_uid, int admin_uid, String user_peerID,
                              int peerPort, ArrayList<Integer> members_Uids){
        this.admin_uid = admin_uid;
        this.user_peerID = user_peerID;
        this.user_peerPort = peerPort;
        this.members_Uids = members_Uids;
        this.chat_uid = chat_uid;
    }

    public int getChat_uid() {return this.chat_uid;}

    public int getAdmin_uid(){return this.admin_uid;}

    public ArrayList<Integer> getMembers_Uids(){return this.members_Uids;}

    public int getUser_peerPort() {return this.user_peerPort;}
    public String getUser_peerID() {return this.user_peerID;}
}
