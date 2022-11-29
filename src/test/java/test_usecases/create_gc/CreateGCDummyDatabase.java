package test_usecases.create_gc;

import entities.GroupChat;
import entities.GroupProfile;
import entities.User;
import usecases.create_gc.CreateGCDBGateway;

import java.util.HashMap;

/**
 * This is an implementation of CreateDBGateway in order to test CreateGCInteractor
 * independently of the database layer.
 * @author Brenden McFarlane
 */
public class CreateGCDummyDatabase implements CreateGCDBGateway {
    private int UID;
    private GroupChat uploaded_chat;
    private final HashMap<Integer, User>  UID_to_user;

    public CreateGCDummyDatabase(int UID) {
        this.UID = UID;
        this.UID_to_user = new HashMap<Integer, User>();
    }

    public GroupChat getUploaded_chat(){return this.uploaded_chat;}
    @Override
    public int getNewUID() {
        return this.UID;
    }
    @Override
    public void addGC(GroupChat group_chat) {
        this.uploaded_chat = group_chat;
    }
    public void addUser(int UID, User user){
        this.UID_to_user.put(UID,user);
    }

    @Override
    public User getUserByUID(int UID) {
        if(this.UID_to_user.containsKey(UID)){
            return this.UID_to_user.get(UID);
        }
           return null;
    }

    @Override
    public String getPeerIDFromUID(int UID) {
        return null;
    }

    @Override
    public int getPeerPortFromUID(int UID) {
        return 0;
    }
}
