package client.usecases.logout;

public interface LogoutDBGateWay {
    /**
    Goes to the files and rewrites the ifonline file into 0
     */
    void logoutByUID(int UID);
}
