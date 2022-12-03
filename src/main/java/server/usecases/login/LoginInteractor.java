package server.usecases.login;
import java.util.*;

public class LoginInteractor implements LoginInputBoundary{
    final LoginDBGateWay db;
    final LoginOutputBoundary outputBoundary;

    public LoginInteractor(LoginDBGateWay db, LoginOutputBoundary outputBoundary){
        this.db = db;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void login(int uid, String password){
        String address = db.userAddress(uid);
        int userPort = db.userPort(uid);
        boolean success = db.check(uid, password);
        if (success){
            String userProfile = db.getUserProfile(uid);
            String chatList = db.getChats(uid);
            String friendList = db.getFriends(uid);
            outputBoundary.ifSuccess(uid, userProfile, chatList, friendList, address, userPort);
        }
        else{
            outputBoundary.error("Username or Password do not match", address, userPort);
        }
    }

}
