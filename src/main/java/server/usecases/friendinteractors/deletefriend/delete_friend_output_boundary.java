package server.usecases.friendinteractors.deletefriend;

public interface delete_friend_output_boundary {
    void success(int requesterid, String address, int peerPort);
    void fail(int requesterid, String address, int peerPort);
}
