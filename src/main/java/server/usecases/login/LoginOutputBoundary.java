package server.usecases.login;

import server.entities.User;

public interface LoginOutputBoundary {
    void error(String message, String address, int userPort);
    void ifSuccess(int uid, String userProfile, String chatList, String friendList, String address, int userPort);
}