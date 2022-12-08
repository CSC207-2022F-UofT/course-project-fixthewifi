package server.usecases.create_gc;

import server.entities.GroupChat;
import server.entities.User;

/**
 * Database access interface for the CreateGCInteractor.
 */
public interface CreateGCDBGateway {

    /**
     * provides a UID that is not being used by any GroupChat
     * @return a 6 digit integer that is not being used by any other GroupChat
     */
    int getNewUID();

    /**
     * adds GroupChat to database. GroupChat must have a unique UID.
     * @param group_chat is the groupchat that will be added
     */
    void addGC(GroupChat group_chat);

    User getUserByUID(int UID);

    String getPeerIDFromUID(int UID);

    int getPeerPortFromUID(int UID);


}
