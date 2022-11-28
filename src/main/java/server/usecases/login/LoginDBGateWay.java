package server.usecases.login;
import java.util.*;

public interface LoginDBGateWay {
    /*
    getUserProfile: gets the name and description and rating of the user and
    returns it as a string

    getChats: get name, description, member uid of all the chats of the user
    and returns it as a string

    getFriends: get name, uid, description, rating, status of friends in friend
    list and returns it as a string

    other methods are intuitive
    */
    boolean check(int UID, String password);
    String getUserProfile(int uid);
    String getChats(int uid);
    String getFriends(int uid);

    String userAddress(int uid);
    int userPort(int uid);
}
