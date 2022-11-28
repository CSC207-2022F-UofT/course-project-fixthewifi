package interface_adapters.logout;
import usecases.logout.*;

public class LogoutController {
    final LogoutInputBoundary inbound;

    public LogoutController(LogoutInputBoundary bound){
        this.inbound = bound;
    }
    void logout(int uid){
        inbound.logout(uid);
    }
}
