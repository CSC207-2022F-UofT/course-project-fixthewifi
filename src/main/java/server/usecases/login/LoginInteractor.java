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
        if (address.equals("-1"))
        {
            // This checks if the user is logging into an account that doesn't exist yet.
            return;
        }
        int userPort = db.userPort(uid);
        if (userPort == -1)
        {
            //This checks if a user is logging into an deleted account.
            return;
        }
        boolean success = db.check(uid, password);

        if (success)
        {
            db.setOnline(uid);
            String[] userProfile = db.getUserProfile(uid);
            ArrayList<String[]> chatList = db.getChats(uid);
            ArrayList<String[]> friendList = db.getFriends(uid);

            outputBoundary.sendSelfProfile(userProfile, address, userPort);
            for (String[] friend : friendList)
            {
                outputBoundary.sendFriend(friend, address, userPort);
            }
            for (String[] chat : chatList)
            {
                outputBoundary.sendChat(chat, address, userPort);
                String[] members = chat[5].split("-");
                for (String member : members)
                {
                    String[] user = db.getUserProfile(Integer.parseInt(member));
                    outputBoundary.sendUser(Integer.parseInt(chat[0]), Integer.parseInt(chat[4]), user, address, userPort);
                }
            }
        }
        else
        {
            outputBoundary.error("Username or Password do not match", address, userPort);
        }
    }

}
