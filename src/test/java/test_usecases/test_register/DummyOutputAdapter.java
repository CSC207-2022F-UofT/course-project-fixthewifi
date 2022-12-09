package test_usecases.test_register;
import server.usecases.register.RegisterOutputBoundary;

public class DummyOutputAdapter implements RegisterOutputBoundary{
    public int uid;
    public int peerPort;

    @Override
    public void successRedirect(int uid, String address, int peerPort, String name) {
        this.uid = uid;
        this.peerPort = peerPort;
    }
}
