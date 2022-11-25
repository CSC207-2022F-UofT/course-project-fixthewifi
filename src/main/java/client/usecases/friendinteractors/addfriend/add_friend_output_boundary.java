package client.usecases.friendinteractors.addfriend;

public interface add_friend_output_boundary
{
    void success(int requestor, String address, int peerPort);
    void fail(int requestor, String address, int peerPort);
}
