package interface_adapters.register;
import usecases.*;
import frameworks_and_drivers.communication_manager.IfComManager;
import usecases.register.*;


public class RegisterController {
    final RegisterInputBoundary inbound;

    public RegisterController(RegisterInputBoundary bound){
        this.inbound = bound;
    }
    void logout(String username, String password){
        inbound.register(username, password);
    }
}
