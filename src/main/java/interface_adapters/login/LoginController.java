package interface_adapters.login;
import usecases.login.*;

public class LoginController {
    final LoginInputBoundary inbound;

    public LoginController(LoginInputBoundary bound){
        this.inbound = bound;
    }
    void login(int uid, String password){
        inbound.login(uid, password);
    }
}
