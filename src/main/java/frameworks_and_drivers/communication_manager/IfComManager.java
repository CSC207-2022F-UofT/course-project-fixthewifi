package frameworks_and_drivers.communication_manager;

import java.io.IOException;
import java.net.UnknownHostException;

public interface IfComManager
{
    public void init(int port, ComManagerUser user);
    public void send(String address, int peerPort, String msg);
}
