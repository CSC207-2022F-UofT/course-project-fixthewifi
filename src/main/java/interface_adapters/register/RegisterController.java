package interface_adapters.register;
import usecases.register.*;
import frameworks_and_drivers.communication_manager.IfComManager;


public class RegisterController {
    final RegisterInputBoundary inbound;

    public RegisterController(RegisterInputBoundary bound){
        this.inbound = bound;
    }
    void register(String username, String password){
        inbound.register(username, password);
    }
}
