package server.interface_adapters.register;
import server.usecases.register.*;
import server.frameworks_and_drivers.communication_manager.IfComManager;


public class RegisterController {
    final RegisterInputBoundary inbound;
    char CONTENT_SPR = 30;

    public RegisterController(RegisterInputBoundary bound){
        this.inbound = bound;
    }
    public void register(String msg, String peerIp, int peerPort)
    {
        String[] content = msg.split(String.valueOf(CONTENT_SPR));
        inbound.register(content[0], content[1], peerIp, peerPort);
    }
}
