package server.usecases.login;
import java.util.*;

public interface LoginOutputBoundary {

    void sendSelfProfile(String[] userProfile, String address, int userPort);

    void sendFriend(String[] friend, String address, int userPort);

    void sendChat(String[] chat, String address, int userPort);

    void sendUser(int chatUid, int adminUid, String[] user, String address, int userPort);

    void error(String s, String address, int userPort);
}