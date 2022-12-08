package server.usecases.login;
import java.util.*;

public class LoginInteractor implements LoginInputBoundary{
    private final LoginDBGateWay db;
    private final LoginOutputBoundary outputBoundary;

    public LoginInteractor(LoginDBGateWay db, LoginOutputBoundary outputBoundary){
        this.db = db;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void login(int uid, String password){
        String address = db.userAddress(uid);
        boolean success = db.check(uid, password);
        if (success){
            String userProfile = db.getUserProfile(uid);
            String chatList = db.getChats(uid);
            String friendList = db.getFriends(uid);
            String requesters = db.getRequesters(uid);
            outputBoundary.ifSuccess(uid, userProfile, requesters, friendList, address, 4444);
        }
        else{
            outputBoundary.error("Username or Password do not match", address, 4444);
        }
    }

}
