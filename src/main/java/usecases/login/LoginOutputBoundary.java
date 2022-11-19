package usecases.login;

import entities.User;

public interface LoginOutputBoundary {
    String error(String message);
    User ifSuccess(User user);
}