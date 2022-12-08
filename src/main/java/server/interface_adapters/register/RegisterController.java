package server.interface_adapters.register;
import server.usecases.register.*;
import server.frameworks_and_drivers.communication_manager.IfComManager;


public class RegisterController {
    /*
    This class essentially has 1 function, which is the register function
    The function takes in 3 parameters: msg, peerIp, and peerPort
    msg is split into msg[0] and msg[1], which are the username and password
    then the 4 parameters are sent into the registerinputboundary
     */
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
