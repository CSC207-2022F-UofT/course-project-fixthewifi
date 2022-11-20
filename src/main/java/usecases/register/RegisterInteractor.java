package usecases.register;

import usecases.login.LoginDBGateWay;

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
    public void register(String username, String password){
        int uid = db.RegisterAndReturnUID(username, password);
        outbound.successRedirect(uid);
    }
}
