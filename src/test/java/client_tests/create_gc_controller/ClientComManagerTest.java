package client_tests.create_gc_controller;

import client.frameworks_and_drivers.communication_manager.ComManagerUser;
import client.frameworks_and_drivers.communication_manager.IfComManager;

/**
 * This is a mock implementation of IFComManager for the testing purposes of the
 * client side controller. It just stores argument values when a method is called on it.
 */
public class ClientComManagerTest implements IfComManager {
    String address;
    int peerPort;
    String msg;
    @Override
    public void init(int port, ComManagerUser user) {

    }

    @Override
    public void send(String address, int peerPort, String msg) {
        this.address = address;
        this.peerPort = peerPort;
        this.msg = msg;
    }
}
