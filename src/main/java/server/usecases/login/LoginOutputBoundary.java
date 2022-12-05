package server.usecases.login;
import java.util.*;

import server.entities.User;

public interface LoginOutputBoundary {
    void error(String message, String address, int userPort);
    void ifSuccess(int uid, String[] userProfile, ArrayList<String[]> chatList, ArrayList<String[]> friendList, String address, int userPort);
}