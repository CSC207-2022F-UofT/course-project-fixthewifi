package server.interface_adapters.logout;
import server.frameworks_and_drivers.communication_manager.IfComManager;
import server.usecases.logout.*;

public class LogoutController {
    final LogoutInputBoundary inbound;

    public LogoutController(LogoutInputBoundary bound){
        this.inbound = bound;
    }
    void logout(String msg){
        int uid = Integer.valueOf(msg);
        inbound.logout(uid);
    }
}
