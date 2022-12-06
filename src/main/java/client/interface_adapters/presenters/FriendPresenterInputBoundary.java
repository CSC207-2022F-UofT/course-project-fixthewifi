package client.interface_adapters.presenters;

public interface FriendPresenterInputBoundary
{
    void receiveRequest(String data);
    void receiveAccept(String data);
    void receiveDelete(String data);
    void receiveView(String data);
}
