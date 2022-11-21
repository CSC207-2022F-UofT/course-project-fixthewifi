package frameworks_and_drivers.comManager;

public interface IfComManager
{
    public void init(int port, ComManagerUser user);
    public void send(String address, int peerPort, String msg);
}
