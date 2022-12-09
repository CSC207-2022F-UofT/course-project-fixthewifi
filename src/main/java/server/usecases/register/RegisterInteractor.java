package server.usecases.register;

public class RegisterInteractor implements RegisterInputBoundary {
    final RegisterDBGateWay db;
    final RegisterOutputBoundary outbound;

    /**
     * This class registers the user's account
     */
    public RegisterInteractor(RegisterDBGateWay db, RegisterOutputBoundary outbound){
        this.db = db;
        this.outbound = outbound;
    }

    /**
     * The class calls the RegisterAndReturnUID method in the database
     * The class then tells the output adapter/boundary to redirect the user to the login page
     * @param username is the username of the user
     * @param password is the password of the user
     */
    @Override
    public void register(String username, String password, String ipAddress, int port)
    {
        int uid = db.getNewUid(username, password);
        db.registerUser(uid, username, password, ipAddress, port);
        outbound.successRedirect(uid, ipAddress, port, username);
    }
}
