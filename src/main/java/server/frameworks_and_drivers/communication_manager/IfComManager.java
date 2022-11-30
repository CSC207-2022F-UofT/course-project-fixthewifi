package server.frameworks_and_drivers.communication_manager;

public interface IfComManager
{
    public void init(int port, ComManagerUser user);
    public void send(String address, int peerPort, String msg);
}
