package interface_adapters.register;
import frameworks_and_drivers.communication_manager.IfComManager;
import usecases.register.*;

public class RegisterOutputAdapter implements RegisterOutputBoundary {
    final IfComManager comManager;
    public RegisterOutputAdapter(IfComManager com){
        this.comManager = com;
    }

    @Override
    public void successRedirect(int uid, String address, int peerPort){
        String content = "Success, your UID is: " + uid;
        comManager.send(address, peerPort, content);
    }
}
