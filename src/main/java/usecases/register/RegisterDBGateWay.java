package usecases.register;

public interface RegisterDBGateWay {
    /**
     * Creates files and account for user in the database, returns uid of the user
     * @param username username of user
     * @param password password of user
     */
    int RegisterAndReturnUID(String username, String password);
    String userAddress(int identifier);
    int userPort(int identifier);

}