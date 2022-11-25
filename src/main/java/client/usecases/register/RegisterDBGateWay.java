package client.usecases.register;

public interface RegisterDBGateWay {
    /**
     * Creates files and account for user in the database, returns uid of the user
     * @param username username of user
     * @param password password of user
     * @return
     */
    int RegisterAndReturnUID(String username, String password);
}