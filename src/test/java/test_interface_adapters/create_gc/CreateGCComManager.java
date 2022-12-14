package test_interface_adapters.create_gc;

import server.frameworks_and_drivers.communication_manager.ComManagerUser;
import server.frameworks_and_drivers.communication_manager.IfComManager;

/**
 * An implementation of IfCommanager for the purposes of testing CreateGCOutputAdapter.
 */
public class CreateGCComManager implements IfComManager {
    String peerID;
    int peerPort;
    String msg;
    @Override
    public void init(int port, ComManagerUser user) {

    }

    @Override
    public void send(String address, int peerPort, String msg) {
        this.peerID = address;
        this.peerPort = peerPort;
        this.msg = msg;
    }
}
