package client.interface_adapters.message;

public interface MsgControllerInputBoundary
{
    void sendMsg(String content, int Uid);
    void receiveMsg(String toDissect);
}
