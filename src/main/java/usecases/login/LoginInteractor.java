package usecases.login;
import entities.User;

public class LoginInteractor implements LoginInputBoundary{
    final LoginDBGateWay db;
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
