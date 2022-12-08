package server.interface_adapters.logout;
import server.frameworks_and_drivers.communication_manager.IfComManager;
import server.usecases.logout.*;

/*
Receives a string called message,
which contains the string of the uid of the user that would like to log out
which the class then calls the LogoutInputBoundary in use cases file to execute the task
*/

public class LogoutController {
    final LogoutInputBoundary inbound;

    public LogoutController(LogoutInputBoundary bound){
        this.inbound = bound;
    }
    public void logout(String msg){
        int uid = Integer.valueOf(msg);
        inbound.logout(uid);
    }
}
