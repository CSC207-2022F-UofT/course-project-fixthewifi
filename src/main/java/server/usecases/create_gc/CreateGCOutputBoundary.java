package server.usecases.create_gc;

/**
 * The OutputBoundary interface called by CreatGCInteractor.
 */
public interface CreateGCOutputBoundary {
    /**
     * parses the CreateGCOutputData for a IfComManager.
     * String contains Constants.GROUP_CHAT, chat_uid,  admins UID, every other members UID,
     * in that order separated by Constants.SPR
     */
    void prepareSuccessView(CreateGCOutputData output_data);

}
