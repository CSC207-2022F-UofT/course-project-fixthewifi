package client.interface_adapters.controllers;

public interface FriendControllerInputBoundary
{
    public void requestFriend(int friendUid);
    public void acceptFriend(int peerUid);
    public void refuseFriend(int peerUid);

    public void deleteFriend(int peerUid);
    public void viewFriend();
}
