package test_interface_adapters.retrieve_friendslist;

import server.frameworks_and_drivers.communication_manager.ComManagerUser;
import server.frameworks_and_drivers.communication_manager.IfComManager;

public class TestRetrieveFriendsListComManager implements IfComManager {
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
