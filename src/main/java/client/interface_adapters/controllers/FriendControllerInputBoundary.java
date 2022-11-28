package client.interface_adapters.controllers;

public interface FriendControllerInputBoundary
{
    public void request(int friendUid);
    public void accept(int peerUid);
    public void refuse(int peerUid);

}
