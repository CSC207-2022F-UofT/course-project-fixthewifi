package client.usecases.login;

import server.usecases.login.LoginDBGateWay;
import server.usecases.login.LoginInputBoundary;
import server.usecases.login.LoginOutputBoundary;

public class LoginInteractor implements LoginInputBoundary {
    final server.usecases.login.LoginDBGateWay db;
    final LoginOutputBoundary outputBoundary;

    public LoginInteractor(LoginDBGateWay db, LoginOutputBoundary outputBoundary){
        this.db = db;
        this.outputBoundary = outputBoundary;
    }

    @Override
    public void login(int UID, String password){
        boolean k = db.check(UID, password);
        if (k){

        }
        else{
            outputBoundary.error("Username or Password do not match");
        }
    }

}
