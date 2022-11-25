package client.frameworks_and_drivers.communication_manager;

import server.frameworks_and_drivers.communication_manager.ComManagerUser;

public interface IfComManager
{
    public void init(int port, ComManagerUser user);
    public void send(String address, int peerPort, String msg);
}
