package server.interface_adapters.register;
import server.frameworks_and_drivers.Constants;
import server.frameworks_and_drivers.communication_manager.IfComManager;
import server.usecases.register.*;

public class RegisterOutputAdapter implements RegisterOutputBoundary {
    final IfComManager comManager;
    char SPR = 30;
    public RegisterOutputAdapter(IfComManager com){
        this.comManager = com;
    }

    @Override
    public void successRedirect(int uid, String address, int peerPort){
        String content = Constants.REGISTER + "#"+ "success" + SPR + uid;
        comManager.send(address, peerPort, content);
    }
}
