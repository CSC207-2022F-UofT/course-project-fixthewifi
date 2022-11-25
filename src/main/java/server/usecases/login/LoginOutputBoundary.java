package server.usecases.login;

import server.entities.User;

public interface LoginOutputBoundary {
    String error(String message);
    User ifSuccess(User user);
}