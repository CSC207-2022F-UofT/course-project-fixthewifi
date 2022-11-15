package test_usecases.create_gc;

import entities.GroupChat;
import entities.GroupProfile;
import usecases.create_gc.CreateGCDBGateway;

/**
 * This is a dummy implementation of CreateDBGateway in order to tes CreateGCInteractor
 * independently of the database layer.
 * @author Brenden McFarlane
 */
public class CreateGCDummyDatabase implements CreateGCDBGateway {
    private int UID;
    private GroupChat uploaded_chat;

    public CreateGCDummyDatabase(int UID) {
        this.UID = UID;
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
}
